package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.KontaktiLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "kontaktiliiks", formBackingObject = KontaktiLiik.class)
@RequestMapping("/kontaktiliiks")
@Controller
public class KontaktiLiikController {
}
