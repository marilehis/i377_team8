package ee.itcollege.i377.web;

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

import ee.itcollege.i377.entities.Piiripunkt;
import ee.itcollege.i377.entities.SurrogaatKuupaev;

@RooWebScaffold(path = "piiripunkts", formBackingObject = Piiripunkt.class)
@RequestMapping("/piiripunkts")
@Controller
public class PiiripunktController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Piiripunkt piiripunkt, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiripunkt", piiripunkt);
            return "piiripunkts/create";
        }
        uiModel.asMap().clear();
        piiripunkt.persist();
        return "redirect:/piiripunkts";
    }
    	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Piiripunkt piiripunkt, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiripunkt", piiripunkt);
            return "piiripunkts/update";
        }
        uiModel.asMap().clear();
        piiripunkt.merge();
        return "redirect:/piiripunkts";
    }
    
    @RequestMapping(value = "/{piiripunktId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("piiripunktId") Long piiripunktId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Principal principal, Model uiModel) {
    	Piiripunkt piiripunkt = Piiripunkt.findPiiripunkt(piiripunktId);
    	piiripunkt.merge();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piiripunkts";
    }
}
