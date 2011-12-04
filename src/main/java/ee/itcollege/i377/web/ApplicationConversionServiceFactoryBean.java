package ee.itcollege.i377.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

import ee.itcollege.i377.entities.Piiripunkt;
import ee.itcollege.i377.entities.Piirivalvur;
import ee.itcollege.i377.entities.Vahtkond;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	    registry.addConverter(PiiripunktConverter());
	    registry.addConverter(PiirivalvurConverter());
	    registry.addConverter(VahtkondConverter());
	}
	
	Converter<Piiripunkt, String> PiiripunktConverter() {
        return new Converter<Piiripunkt, String>() {
            @Override
			public String convert(Piiripunkt o) {
            	return o.getNimetus();
            }
        };
    }
	
	Converter<Piirivalvur, String> PiirivalvurConverter() {
        return new Converter<Piirivalvur, String>() {
            @Override
			public String convert(Piirivalvur o) {
            	return o.getNimi();
            }
        };
    }	

	Converter<Vahtkond, String> VahtkondConverter() {
        return new Converter<Vahtkond, String>() {
            @Override
			public String convert(Vahtkond o) {
            	return o.getNimetus();
            }
        };
    }	

}
