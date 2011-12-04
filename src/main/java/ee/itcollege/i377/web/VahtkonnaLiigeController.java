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
        vahtkonnaLiige.persist();
        return "redirect:/vahtkonds/" + encodeUrlPathSegment(vahtkonnaLiige.getVahtkond().getVahtkondId().toString(), httpServletRequest) + "?form";
    }
    
	
}
