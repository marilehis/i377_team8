package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seadusepunkts", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunkts")
@Controller
public class SeadusePunktController {
}
