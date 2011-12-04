package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.VahtkonndPiiriloigul;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkonndpiiriloiguls", formBackingObject = VahtkonndPiiriloigul.class)
@RequestMapping("/vahtkonndpiiriloiguls")
@Controller
public class VahtkonndPiiriloigulController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "vahtkondId", required = false) Integer _vahtkondId, Model uiModel) {
        int id = 0;
		if(_vahtkondId!=null)id = _vahtkondId.intValue();
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkonndpiiriloiguls", VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(id,page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VahtkonndPiiriloigul.countVahtkonndPiiriloiguls() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkonndpiiriloiguls", VahtkonndPiiriloigul.findVahtkonndPiiriloigulEntriesByVahtkond(id,0,10000));
        }
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonndpiiriloiguls/list";
    }
}
//findVahtkonndPiiriloigulEntriesByVahtkond