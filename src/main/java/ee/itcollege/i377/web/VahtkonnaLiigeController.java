package ee.itcollege.i377.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
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

import ee.itcollege.i377.entities.Piirivalvur;
import ee.itcollege.i377.entities.SurrogaatKuupaev;
import ee.itcollege.i377.entities.Vahtkond;
import ee.itcollege.i377.entities.VahtkonnaLiige;

@RooWebScaffold(path = "vahtkonnaliiges", formBackingObject = VahtkonnaLiige.class)
@RequestMapping("/vahtkonnaliiges")
@Controller
public class VahtkonnaLiigeController {
	
	private Vahtkond getVahtkond(HttpServletRequest request) {
		return Vahtkond.findVahtkond(Long.parseLong(request.getParameter("vahtkondId")));
	}
	
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("vahtkonnaLiige", new VahtkonnaLiige());
        uiModel.addAttribute("vahtkond", getVahtkond(httpServletRequest));
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonnaliiges/create";
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid VahtkonnaLiige vahtkonnaLiige, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonnaLiige", vahtkonnaLiige);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonnaliiges/create";
        }
        uiModel.asMap().clear();
        vahtkonnaLiige.setVahtkond(getVahtkond(httpServletRequest));
        vahtkonnaLiige.setAvaja(principal.getName());
        vahtkonnaLiige.setAvatud(new Date());
        vahtkonnaLiige.setMuudetud(SurrogaatKuupaev.getInstance());
        vahtkonnaLiige.setSuletud(SurrogaatKuupaev.getInstance());
        vahtkonnaLiige.persist();
        return "redirect:/vahtkonds/" + encodeUrlPathSegment(vahtkonnaLiige.getVahtkond().getVahtkondId().toString(), httpServletRequest) + "?form";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid VahtkonnaLiige vahtkonnaLiige, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonnaLiige", vahtkonnaLiige);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonnaliiges/update";
        }
        uiModel.asMap().clear();
        vahtkonnaLiige.setMuudetud(new Date());
        vahtkonnaLiige.setMuutja(principal.getName());
        vahtkonnaLiige.merge();
        return "redirect:/vahtkonds/" + encodeUrlPathSegment(vahtkonnaLiige.getVahtkond().getVahtkondId().toString(), httpServletRequest) + "?form";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(
    		@RequestParam(value = "piirivalvurId", required = true) Long piirivalvurId, 
    		@RequestParam(value = "alates", required = false) String alates,
    		@RequestParam(value = "kuni", required = false) String kuni,
    		Model uiModel) {
    	Piirivalvur piirivalvur = Piirivalvur.findPiirivalvur(piirivalvurId);
    	
    	SimpleDateFormat fmt = new SimpleDateFormat("MMM d, yyyy");
    	
    	Date dateAlates = null;
    	try {
    		dateAlates = fmt.parse(alates);
    	} catch(Exception e) {}
    	
    	Date dateKuni = null;
    	try {
    		dateKuni = fmt.parse(kuni);
    	} catch(Exception e) {}
    	
        uiModel.addAttribute("rows", piirivalvur.getIndividuaalneToograafik(dateAlates, dateKuni));
        uiModel.addAttribute("piirivalvur", piirivalvur);
        uiModel.addAttribute("alates", alates);
        uiModel.addAttribute("kuni", kuni);
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonnaliiges/list";
    }
	
}
