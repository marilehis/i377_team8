package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.Piiriloik;


import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RooWebScaffold(path = "piiriloiks", formBackingObject = Piiriloik.class)
@RequestMapping("/piiriloiks")
@Controller
public class PiiriloikController {
	
	private Piiriloik setCreated(Piiriloik piiriloik,Principal principal){
		piiriloik.setAvaja(principal.getName());
		piiriloik.setAvatud(new Date());
		piiriloik.persist();
        return piiriloik;
	}
	
	private Piiriloik setModified(Piiriloik piiriloik,Principal principal){
		piiriloik.setMuutja(principal.getName());
		piiriloik.setMuudetud(new Date());
		piiriloik.merge();
        return piiriloik;
	}
	
	private String hasErrors(Piiriloik piiriloik,Model uiModel,String go_to){
		uiModel.addAttribute("piiriloik", piiriloik);
        addDateTimeFormatPatterns(uiModel);
		return go_to;
	}
	
	
	 @RequestMapping(method = RequestMethod.POST)
	 public String create(@Valid Piiriloik piiriloik, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors())return this.hasErrors(piiriloik, uiModel, "piiriloik/create");
        uiModel.asMap().clear();
        piiriloik = this.setCreated(piiriloik,principal);     
        return "redirect:/piiriloiks";
	 }
	    	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Piiriloik piiriloik, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) this.hasErrors(piiriloik, uiModel, "piiriloiks/update");
        uiModel.asMap().clear();
        piiriloik = this.setModified(piiriloik,principal);
        piiriloik.merge();
        return "redirect:/piiriloiks";
    }
    
    @RequestMapping(value = "/{piiriloikId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("piiriloikId") Long piiriloikId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Principal principal, Model uiModel) {
    	Piiriloik piiriloik = Piiriloik.findPiiriloik(piiriloikId);
    	piiriloik = this.setModified(piiriloik,principal);
    	piiriloik.merge();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piiriloiks";
    }
}
