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

import ee.itcollege.i377.entities.Piirivalvur;

@RooWebScaffold(path = "piirivalvurs", formBackingObject = Piirivalvur.class)
@RequestMapping("/piirivalvurs")
@Controller
public class PiirivalvurController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Piirivalvur piirivalvur, BindingResult bindingResult, Principal principal, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvur", piirivalvur);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurs/create";
        }
        uiModel.asMap().clear();
        piirivalvur.setAvaja(principal.getName());
        piirivalvur.setAvatud(new Date());
        piirivalvur.persist();
        return "redirect:/piirivalvurs";
    }
    
	
}
