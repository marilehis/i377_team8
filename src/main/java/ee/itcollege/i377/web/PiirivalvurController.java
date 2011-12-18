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

import ee.itcollege.i377.entities.Piirivalvur;
import ee.itcollege.i377.entities.SurrogaatKuupaev;

@RooWebScaffold(path = "piirivalvurs", formBackingObject = Piirivalvur.class)
@RequestMapping("/piirivalvurs")
@Controller
public class PiirivalvurController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Piirivalvur piirivalvur, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvur", piirivalvur);
            return "piirivalvurs/create";
        }
        uiModel.asMap().clear();
        piirivalvur.persist();
        return "redirect:/piirivalvurs";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Piirivalvur piirivalvur, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvur", piirivalvur);
            return "piirivalvurs/update";
        }
        uiModel.asMap().clear();
        piirivalvur.merge();
        return "redirect:/piirivalvurs";
    }
    
    @RequestMapping(value = "/{piirivalvurId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("piirivalvurId") Long piirivalvurId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Principal principal, Model uiModel) {
        Piirivalvur piirivalvur = Piirivalvur.findPiirivalvur(piirivalvurId);
        piirivalvur.merge();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piirivalvurs";
    }
    	
}
