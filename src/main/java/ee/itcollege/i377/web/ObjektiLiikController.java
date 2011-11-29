package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.ObjektiLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "objektiliiks", formBackingObject = ObjektiLiik.class)
@RequestMapping("/objektiliiks")
@Controller
public class ObjektiLiikController {
}
