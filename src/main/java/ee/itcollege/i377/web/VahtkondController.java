package ee.itcollege.i377.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.i377.entities.Vahtkond;

@RooWebScaffold(path = "vahtkonds", formBackingObject = Vahtkond.class)
@RequestMapping("/vahtkonds")
@Controller
public class VahtkondController {
	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Vahtkond vahtkond, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkond", vahtkond);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonds/update";
        }
        uiModel.asMap().clear();
        vahtkond.merge();
        return "redirect:/vahtkonds";
    }    
	
}
