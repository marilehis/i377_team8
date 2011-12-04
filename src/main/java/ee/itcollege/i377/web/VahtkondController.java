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

import ee.itcollege.i377.entities.SurrogaatKuupaev;
import ee.itcollege.i377.entities.Vahtkond;

@RooWebScaffold(path = "vahtkonds", formBackingObject = Vahtkond.class)
@RequestMapping("/vahtkonds")
@Controller
public class VahtkondController {
	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Vahtkond vahtkond, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkond", vahtkond);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonds/update";
        }
        uiModel.asMap().clear();
        vahtkond.setMuudetud(new Date());
        vahtkond.setMuutja(principal.getName());
        vahtkond.merge();
        return "redirect:/vahtkonds";
    }    
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Vahtkond vahtkond, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkond", vahtkond);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonds/create";
        }
        uiModel.asMap().clear();
        vahtkond.setAvatud(new Date());
        vahtkond.setAvaja(principal.getName());
        vahtkond.setMuudetud(SurrogaatKuupaev.getInstance());
        vahtkond.setSuletud(SurrogaatKuupaev.getInstance());
        vahtkond.persist();
        return "redirect:/vahtkonds";
    }

    @RequestMapping(value = "/{vahtkondId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("vahtkondId") Long vahtkondId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Principal principal, Model uiModel) {
        Vahtkond vahtkond = Vahtkond.findVahtkond(vahtkondId);
        vahtkond.setSuletud(new Date());
        vahtkond.setSulgeja(principal.getName());
        vahtkond.merge();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vahtkonds";
    }
    
}
