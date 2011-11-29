package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.PiirivalvuriKontakt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvurikontakts", formBackingObject = PiirivalvuriKontakt.class)
@RequestMapping("/piirivalvurikontakts")
@Controller
public class PiirivalvuriKontaktController {
}
