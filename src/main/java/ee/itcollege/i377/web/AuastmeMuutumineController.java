package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.AuastmeMuutumine;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "auastmemuutumines", formBackingObject = AuastmeMuutumine.class)
@RequestMapping("/auastmemuutumines")
@Controller
public class AuastmeMuutumineController {
}
