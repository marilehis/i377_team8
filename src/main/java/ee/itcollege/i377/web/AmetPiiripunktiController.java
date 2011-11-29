package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.AmetPiiripunkti;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "ametpiiripunktis", formBackingObject = AmetPiiripunkti.class)
@RequestMapping("/ametpiiripunktis")
@Controller
public class AmetPiiripunktiController {
}
