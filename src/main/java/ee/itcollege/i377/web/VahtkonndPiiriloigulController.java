package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.VahtkonndPiiriloigul;
import ee.itcollege.i377.entities.Vahtkond;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

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