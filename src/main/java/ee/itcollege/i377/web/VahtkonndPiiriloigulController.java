package ee.itcollege.i377.web;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.entities.Vahtkond;
import ee.itcollege.i377.entities.VahtkonndPiiriloigul;

@RooWebScaffold(path = "vahtkonndpiiriloiguls", formBackingObject = VahtkonndPiiriloigul.class)
@RequestMapping("/vahtkonndpiiriloiguls")
@Controller
public class VahtkonndPiiriloigulController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, 
    		@RequestParam(value = "size", required = false) Integer size, 
    		@RequestParam(value = "vahtkondId", required = true) Long vahtkondId, 
    		Model uiModel) {
		uiModel.addAttribute("vahtkond", Vahtkond.findVahtkond(vahtkondId));
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkonndpiiriloiguls", 
            		VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(vahtkondId, page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VahtkonndPiiriloigul.countVahtkonndPiiriloiguls(vahtkondId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkonndpiiriloiguls", 
            		VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(vahtkondId, 0, 10000));
        }
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonndpiiriloiguls/list";
    }
	
	private Vahtkond getVahtkond(HttpServletRequest request) {
    	Long vahtkondId = Long.parseLong(request.getParameter("vahtkondId"));
    	return Vahtkond.findVahtkond(vahtkondId);
	}
	
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest request) {
        uiModel.addAttribute("vahtkonndPiiriloigul", new VahtkonndPiiriloigul());
        uiModel.addAttribute("vahtkond", getVahtkond(request));
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonndpiiriloiguls/create";
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid VahtkonndPiiriloigul vahtkonndPiiriloigul, BindingResult bindingResult, 
    		Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
    	Vahtkond vahtkond = getVahtkond(httpServletRequest);
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonndPiiriloigul", vahtkonndPiiriloigul);
            uiModel.addAttribute("vahtkond", vahtkond);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonndpiiriloiguls/create";
        }
        uiModel.asMap().clear();
        vahtkonndPiiriloigul.setVahtkond(vahtkond);
        vahtkonndPiiriloigul.setAvaja(principal.getName());
        vahtkonndPiiriloigul.setAvatud(new Date());
        vahtkonndPiiriloigul.persist();
        return "redirect:/vahtkonndpiiriloiguls?vahtkondId=" + vahtkond.getVahtkondId().toString();
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid VahtkonndPiiriloigul vahtkonndPiiriloigul, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonndPiiriloigul", vahtkonndPiiriloigul);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonndpiiriloiguls/update";
        }
        uiModel.asMap().clear();
        vahtkonndPiiriloigul.setMuudetud(new Date());
        vahtkonndPiiriloigul.setMuutja(principal.getName());
        vahtkonndPiiriloigul.merge();
        return "redirect:/vahtkonndpiiriloiguls?vahtkondId=" + vahtkonndPiiriloigul.getVahtkond().getVahtkondId().toString();
    }
	
}
