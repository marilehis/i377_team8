// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.Intsident;
import ee.itcollege.i377.entities.PiiriloiguHaldaja;
import ee.itcollege.i377.entities.Piiriloik;
import ee.itcollege.i377.entities.VahtkonndPiiriloigul;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PiiriloikController_Roo_Controller {
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiiriloikController.createForm(Model uiModel) {
        uiModel.addAttribute("piiriloik", new Piiriloik());
        return "piiriloiks/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String PiiriloikController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("piiriloik", Piiriloik.findPiiriloik(id));
        uiModel.addAttribute("itemId", id);
        return "piiriloiks/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiiriloikController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piiriloiks", Piiriloik.findPiiriloikEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Piiriloik.countPiiriloiks() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piiriloiks", Piiriloik.findAllPiiriloiks());
        }
        return "piiriloiks/list";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String PiiriloikController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("piiriloik", Piiriloik.findPiiriloik(id));
        return "piiriloiks/update";
    }
    
    @ModelAttribute("intsidents")
    public Collection<Intsident> PiiriloikController.populateIntsidents() {
        return Intsident.findAllIntsidents();
    }
    
    @ModelAttribute("piiriloiguhaldajas")
    public Collection<PiiriloiguHaldaja> PiiriloikController.populatePiiriloiguHaldajas() {
        return PiiriloiguHaldaja.findAllPiiriloiguHaldajas();
    }
    
    @ModelAttribute("piiriloiks")
    public Collection<Piiriloik> PiiriloikController.populatePiiriloiks() {
        return Piiriloik.findAllPiiriloiks();
    }
    
    @ModelAttribute("vahtkonndpiiriloiguls")
    public Collection<VahtkonndPiiriloigul> PiiriloikController.populateVahtkonndPiiriloiguls() {
        return VahtkonndPiiriloigul.findAllVahtkonndPiiriloiguls();
    }
    
    String PiiriloikController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
