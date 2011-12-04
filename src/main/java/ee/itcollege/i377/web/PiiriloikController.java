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

import ee.itcollege.i377.entities.Piiriloik;

@RooWebScaffold(path = "piiriloiks", formBackingObject = Piiriloik.class)
@RequestMapping("/piiriloiks")
@Controller
public class PiiriloikController {

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Piiriloik piiriloik,
			BindingResult bindingResult, Principal principal, Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("piiriloik", piiriloik);
			addDateTimeFormatPatterns(uiModel);
			return "piiriloiks/create";
		}
		uiModel.asMap().clear();
		piiriloik.setAvaja(principal.getName());
		piiriloik.setAvatud(new Date());
		piiriloik.persist();

		return "redirect:/piiriloiks";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Piiriloik piiriloik,
			BindingResult bindingResult, Principal principal, Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("piiripunkt", piiriloik);
			addDateTimeFormatPatterns(uiModel);
			return "piiriloiks/update";
		}
		uiModel.asMap().clear();
		piiriloik.setMuudetud(new Date());
		piiriloik.setMuutja(principal.getName());
		piiriloik.merge();
		return "redirect:/piiriloiks";
	}

	@RequestMapping(value = "/{piiriloikId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("piiriloikId") Long piiriloikId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Principal principal, Model uiModel) {
		Piiriloik piiriloik = Piiriloik.findPiiriloik(piiriloikId);
		piiriloik.setSuletud(new Date());
		piiriloik.setSulgeja(principal.getName());
		piiriloik.merge();
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/piiriloiks";
	}
}
