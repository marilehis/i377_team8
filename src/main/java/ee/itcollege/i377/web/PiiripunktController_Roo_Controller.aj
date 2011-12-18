// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.AmetPiiripunkti;
import ee.itcollege.i377.entities.PiiriloiguHaldaja;
import ee.itcollege.i377.entities.Piiripunkt;
import ee.itcollege.i377.entities.PiiripunktiAlluvus;
import ee.itcollege.i377.entities.PiiripunktiOrgYksus;
import ee.itcollege.i377.entities.Vahtkond;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PiiripunktController_Roo_Controller {
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiiripunktController.createForm(Model uiModel) {
        uiModel.addAttribute("piiripunkt", new Piiripunkt());
        addDateTimeFormatPatterns(uiModel);
        return "piiripunkts/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String PiiripunktController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piiripunkt", Piiripunkt.findPiiripunkt(id));
        uiModel.addAttribute("itemId", id);
        return "piiripunkts/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiiripunktController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piiripunkts", Piiripunkt.findPiiripunktEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Piiripunkt.countPiiripunkts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piiripunkts", Piiripunkt.findAllPiiripunkts());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piiripunkts/list";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String PiiripunktController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("piiripunkt", Piiripunkt.findPiiripunkt(id));
        addDateTimeFormatPatterns(uiModel);
        return "piiripunkts/update";
    }
    
    @ModelAttribute("ametpiiripunktis")
    public Collection<AmetPiiripunkti> PiiripunktController.populateAmetPiiripunktis() {
        return AmetPiiripunkti.findAllAmetPiiripunktis();
    }
    
    @ModelAttribute("piiriloiguhaldajas")
    public Collection<PiiriloiguHaldaja> PiiripunktController.populatePiiriloiguHaldajas() {
        return PiiriloiguHaldaja.findAllPiiriloiguHaldajas();
    }
    
    @ModelAttribute("piiripunkts")
    public Collection<Piiripunkt> PiiripunktController.populatePiiripunkts() {
        return Piiripunkt.findAllPiiripunkts();
    }
    
    @ModelAttribute("piiripunktialluvuses")
    public Collection<PiiripunktiAlluvus> PiiripunktController.populatePiiripunktiAlluvuses() {
        return PiiripunktiAlluvus.findAllPiiripunktiAlluvuses();
    }
    
    @ModelAttribute("piiripunktiorgyksuses")
    public Collection<PiiripunktiOrgYksus> PiiripunktController.populatePiiripunktiOrgYksuses() {
        return PiiripunktiOrgYksus.findAllPiiripunktiOrgYksuses();
    }
    
    @ModelAttribute("vahtkonds")
    public Collection<Vahtkond> PiiripunktController.populateVahtkonds() {
        return Vahtkond.findAllVahtkonds();
    }
    
    void PiiripunktController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piiripunkt_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piiripunkt_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String PiiripunktController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
