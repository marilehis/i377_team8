package ee.itcollege.i377.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.entities.Vahtkond;
import ee.itcollege.i377.entities.VahtkonndPiiriloigul;

@RooWebScaffold(path = "vahtkonndpiiriloiguls", formBackingObject = VahtkonndPiiriloigul.class)
@RequestMapping("/vahtkonndpiiriloiguls")
@Controller
public class VahtkonndPiiriloigulController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, 
    		@RequestParam(value = "size", required = false) Integer size, 
    		@RequestParam(value = "vahtkondId", required = true) Long vahtkondId, 
    		Model uiModel) {
		uiModel.addAttribute("vahtkond", Vahtkond.findVahtkond(vahtkondId));
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkonndpiiriloiguls", 
            		VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(vahtkondId, page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VahtkonndPiiriloigul.countVahtkonndPiiriloiguls(vahtkondId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkonndpiiriloiguls", 
            		VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(vahtkondId, 0, 10000));
        }
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonndpiiriloiguls/list";
    }
}
//findVahtkonndPiiriloigulEntriesByVahtkond