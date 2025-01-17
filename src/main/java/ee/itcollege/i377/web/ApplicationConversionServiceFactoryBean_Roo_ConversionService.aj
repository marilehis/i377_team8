// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.i377.web;

import ee.itcollege.i377.entities.AdminAlluvus;
import ee.itcollege.i377.entities.Amet;
import ee.itcollege.i377.entities.AmetPiiripunkti;
import ee.itcollege.i377.entities.AmetVaeosa;
import ee.itcollege.i377.entities.Auaste;
import ee.itcollege.i377.entities.AuastmeMuutumine;
import ee.itcollege.i377.entities.IntsidendiLiik;
import ee.itcollege.i377.entities.Intsident;
import ee.itcollege.i377.entities.IsikIntsidendi;
import ee.itcollege.i377.entities.IsikuSeadusIntsidendi;
import ee.itcollege.i377.entities.Kodakondsus;
import ee.itcollege.i377.entities.KontaktiLiik;
import ee.itcollege.i377.entities.Objekt;
import ee.itcollege.i377.entities.ObjektIntsidendi;
import ee.itcollege.i377.entities.ObjektiLiik;
import ee.itcollege.i377.entities.ObjektiSeadusIntsidendi;
import ee.itcollege.i377.entities.OrgYksus;
import ee.itcollege.i377.entities.PiiriloiguHaldaja;
import ee.itcollege.i377.entities.Piiriloik;
import ee.itcollege.i377.entities.Piiripunkt;
import ee.itcollege.i377.entities.PiiripunktiAlluvus;
import ee.itcollege.i377.entities.PiiripunktiOrgYksus;
import ee.itcollege.i377.entities.Piiririkkuja;
import ee.itcollege.i377.entities.Piirivalvur;
import ee.itcollege.i377.entities.PiirivalvurIntsidendi;
import ee.itcollege.i377.entities.PiirivalvurPiiripunkti;
import ee.itcollege.i377.entities.PiirivalvurVaeosa;
import ee.itcollege.i377.entities.PiirivalvurVodikohal;
import ee.itcollege.i377.entities.PiirivalvuriKontakt;
import ee.itcollege.i377.entities.PiirivalvuriSeadusIntsidendi;
import ee.itcollege.i377.entities.RiigiAdminYksus;
import ee.itcollege.i377.entities.RiigiAdminYksuseLiik;
import ee.itcollege.i377.entities.Riik;
import ee.itcollege.i377.entities.Ruumiyksus;
import ee.itcollege.i377.entities.RuumiyksuseLiik;
import ee.itcollege.i377.entities.Seadus;
import ee.itcollege.i377.entities.SeadusePunkt;
import ee.itcollege.i377.entities.SeotudKontaktisik;
import ee.itcollege.i377.entities.SuguluseRolliLiik;
import ee.itcollege.i377.entities.Vaeosa;
import ee.itcollege.i377.entities.VaeosaAlluvus;
import ee.itcollege.i377.entities.Vahtkond;
import ee.itcollege.i377.entities.VahtkondIntsidendi;
import ee.itcollege.i377.entities.VahtkonnaLiige;
import ee.itcollege.i377.entities.VahtkonndPiiriloigul;
import ee.itcollege.i377.entities.VoimalikAlluvus;
import ee.itcollege.i377.entities.Voodikoht;
import java.lang.String;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new AdminAlluvusConverter());
        registry.addConverter(new AmetConverter());
        registry.addConverter(new AmetPiiripunktiConverter());
        registry.addConverter(new AmetVaeosaConverter());
        registry.addConverter(new AuasteConverter());
        registry.addConverter(new AuastmeMuutumineConverter());
        registry.addConverter(new IntsidendiLiikConverter());
        registry.addConverter(new IntsidentConverter());
        registry.addConverter(new IsikIntsidendiConverter());
        registry.addConverter(new IsikuSeadusIntsidendiConverter());
        registry.addConverter(new KodakondsusConverter());
        registry.addConverter(new KontaktiLiikConverter());
        registry.addConverter(new ObjektConverter());
        registry.addConverter(new ObjektIntsidendiConverter());
        registry.addConverter(new ObjektiLiikConverter());
        registry.addConverter(new ObjektiSeadusIntsidendiConverter());
        registry.addConverter(new OrgYksusConverter());
        registry.addConverter(new PiiriloiguHaldajaConverter());
        registry.addConverter(new PiiriloikConverter());
        registry.addConverter(new PiiripunktConverter());
        registry.addConverter(new PiiripunktiAlluvusConverter());
        registry.addConverter(new PiiripunktiOrgYksusConverter());
        registry.addConverter(new PiiririkkujaConverter());
        registry.addConverter(new PiirivalvurConverter());
        registry.addConverter(new PiirivalvurIntsidendiConverter());
        registry.addConverter(new PiirivalvurPiiripunktiConverter());
        registry.addConverter(new PiirivalvurVaeosaConverter());
        registry.addConverter(new PiirivalvurVodikohalConverter());
        registry.addConverter(new PiirivalvuriKontaktConverter());
        registry.addConverter(new PiirivalvuriSeadusIntsidendiConverter());
        registry.addConverter(new RiigiAdminYksusConverter());
        registry.addConverter(new RiigiAdminYksuseLiikConverter());
        registry.addConverter(new RiikConverter());
        registry.addConverter(new RuumiyksusConverter());
        registry.addConverter(new RuumiyksuseLiikConverter());
        registry.addConverter(new SeadusConverter());
        registry.addConverter(new SeadusePunktConverter());
        registry.addConverter(new SeotudKontaktisikConverter());
        registry.addConverter(new SuguluseRolliLiikConverter());
        registry.addConverter(new VaeosaConverter());
        registry.addConverter(new VaeosaAlluvusConverter());
        registry.addConverter(new VahtkondConverter());
        registry.addConverter(new VahtkondIntsidendiConverter());
        registry.addConverter(new VahtkonnaLiigeConverter());
        registry.addConverter(new VahtkonndPiiriloigulConverter());
        registry.addConverter(new VoimalikAlluvusConverter());
        registry.addConverter(new VoodikohtConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AdminAlluvusConverter implements Converter<AdminAlluvus, String> {
        public String convert(AdminAlluvus adminAlluvus) {
            return new StringBuilder().append(adminAlluvus.getAlates()).append(" ").append(adminAlluvus.getAvaja()).append(" ").append(adminAlluvus.getAvatud()).append(" ").append(adminAlluvus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AmetConverter implements Converter<Amet, String> {
        public String convert(Amet amet) {
            return new StringBuilder().append(amet.getAvaja()).append(" ").append(amet.getAvatud()).append(" ").append(amet.getIscoKood()).append(" ").append(amet.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AmetPiiripunktiConverter implements Converter<AmetPiiripunkti, String> {
        public String convert(AmetPiiripunkti ametPiiripunkti) {
            return new StringBuilder().append(ametPiiripunkti.getAlates()).append(" ").append(ametPiiripunkti.getAvaja()).append(" ").append(ametPiiripunkti.getAvatud()).append(" ").append(ametPiiripunkti.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AmetVaeosaConverter implements Converter<AmetVaeosa, String> {
        public String convert(AmetVaeosa ametVaeosa) {
            return new StringBuilder().append(ametVaeosa.getAlates()).append(" ").append(ametVaeosa.getAvaja()).append(" ").append(ametVaeosa.getAvatud()).append(" ").append(ametVaeosa.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AuasteConverter implements Converter<Auaste, String> {
        public String convert(Auaste auaste) {
            return new StringBuilder().append(auaste.getAvaja()).append(" ").append(auaste.getAvatud()).append(" ").append(auaste.getKommentaar()).append(" ").append(auaste.getKood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.AuastmeMuutumineConverter implements Converter<AuastmeMuutumine, String> {
        public String convert(AuastmeMuutumine auastmeMuutumine) {
            return new StringBuilder().append(auastmeMuutumine.getAlates()).append(" ").append(auastmeMuutumine.getAvaja()).append(" ").append(auastmeMuutumine.getAvatud()).append(" ").append(auastmeMuutumine.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.IntsidendiLiikConverter implements Converter<IntsidendiLiik, String> {
        public String convert(IntsidendiLiik intsidendiLiik) {
            return new StringBuilder().append(intsidendiLiik.getAvaja()).append(" ").append(intsidendiLiik.getAvatud()).append(" ").append(intsidendiLiik.getKommentaar()).append(" ").append(intsidendiLiik.getKood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.IntsidentConverter implements Converter<Intsident, String> {
        public String convert(Intsident intsident) {
            return new StringBuilder().append(intsident.getAvaja()).append(" ").append(intsident.getAvatud()).append(" ").append(intsident.getGpsLatituud()).append(" ").append(intsident.getGpsLongituud()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.IsikIntsidendiConverter implements Converter<IsikIntsidendi, String> {
        public String convert(IsikIntsidendi isikIntsidendi) {
            return new StringBuilder().append(isikIntsidendi.getAlates()).append(" ").append(isikIntsidendi.getAvaja()).append(" ").append(isikIntsidendi.getAvatud()).append(" ").append(isikIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.IsikuSeadusIntsidendiConverter implements Converter<IsikuSeadusIntsidendi, String> {
        public String convert(IsikuSeadusIntsidendi isikuSeadusIntsidendi) {
            return new StringBuilder().append(isikuSeadusIntsidendi.getAlates()).append(" ").append(isikuSeadusIntsidendi.getAvaja()).append(" ").append(isikuSeadusIntsidendi.getAvatud()).append(" ").append(isikuSeadusIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.KodakondsusConverter implements Converter<Kodakondsus, String> {
        public String convert(Kodakondsus kodakondsus) {
            return new StringBuilder().append(kodakondsus.getAlates()).append(" ").append(kodakondsus.getAvaja()).append(" ").append(kodakondsus.getAvatud()).append(" ").append(kodakondsus.getIsikukood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.KontaktiLiikConverter implements Converter<KontaktiLiik, String> {
        public String convert(KontaktiLiik kontaktiLiik) {
            return new StringBuilder().append(kontaktiLiik.getAvaja()).append(" ").append(kontaktiLiik.getAvatud()).append(" ").append(kontaktiLiik.getKommentaar()).append(" ").append(kontaktiLiik.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.ObjektConverter implements Converter<Objekt, String> {
        public String convert(Objekt objekt) {
            return new StringBuilder().append(objekt.getAvaja()).append(" ").append(objekt.getAvatud()).append(" ").append(objekt.getKommentaar()).append(" ").append(objekt.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.ObjektIntsidendiConverter implements Converter<ObjektIntsidendi, String> {
        public String convert(ObjektIntsidendi objektIntsidendi) {
            return new StringBuilder().append(objektIntsidendi.getAlates()).append(" ").append(objektIntsidendi.getAvaja()).append(" ").append(objektIntsidendi.getAvatud()).append(" ").append(objektIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.ObjektiLiikConverter implements Converter<ObjektiLiik, String> {
        public String convert(ObjektiLiik objektiLiik) {
            return new StringBuilder().append(objektiLiik.getAvaja()).append(" ").append(objektiLiik.getAvatud()).append(" ").append(objektiLiik.getKommentaar()).append(" ").append(objektiLiik.getKood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.ObjektiSeadusIntsidendiConverter implements Converter<ObjektiSeadusIntsidendi, String> {
        public String convert(ObjektiSeadusIntsidendi objektiSeadusIntsidendi) {
            return new StringBuilder().append(objektiSeadusIntsidendi.getAlates()).append(" ").append(objektiSeadusIntsidendi.getAvaja()).append(" ").append(objektiSeadusIntsidendi.getAvatud()).append(" ").append(objektiSeadusIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.OrgYksusConverter implements Converter<OrgYksus, String> {
        public String convert(OrgYksus orgYksus) {
            return new StringBuilder().append(orgYksus.getAlates()).append(" ").append(orgYksus.getAvaja()).append(" ").append(orgYksus.getAvatud()).append(" ").append(orgYksus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiriloiguHaldajaConverter implements Converter<PiiriloiguHaldaja, String> {
        public String convert(PiiriloiguHaldaja piiriloiguHaldaja) {
            return new StringBuilder().append(piiriloiguHaldaja.getAlates()).append(" ").append(piiriloiguHaldaja.getAvaja()).append(" ").append(piiriloiguHaldaja.getAvatud()).append(" ").append(piiriloiguHaldaja.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiriloikConverter implements Converter<Piiriloik, String> {
        public String convert(Piiriloik piiriloik) {
            return new StringBuilder().append(piiriloik.getGpsKoordinaadid()).append(" ").append(piiriloik.getKommentaar()).append(" ").append(piiriloik.getKood()).append(" ").append(piiriloik.getNimetus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiripunktConverter implements Converter<Piiripunkt, String> {
        public String convert(Piiripunkt piiripunkt) {
            return new StringBuilder().append(piiripunkt.getAlates()).append(" ").append(piiripunkt.getGpsLatitude()).append(" ").append(piiripunkt.getGpsLongituide()).append(" ").append(piiripunkt.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiripunktiAlluvusConverter implements Converter<PiiripunktiAlluvus, String> {
        public String convert(PiiripunktiAlluvus piiripunktiAlluvus) {
            return new StringBuilder().append(piiripunktiAlluvus.getAlates()).append(" ").append(piiripunktiAlluvus.getAvaja()).append(" ").append(piiripunktiAlluvus.getAvatud()).append(" ").append(piiripunktiAlluvus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiripunktiOrgYksusConverter implements Converter<PiiripunktiOrgYksus, String> {
        public String convert(PiiripunktiOrgYksus piiripunktiOrgYksus) {
            return new StringBuilder().append(piiripunktiOrgYksus.getAlates()).append(" ").append(piiripunktiOrgYksus.getAvaja()).append(" ").append(piiripunktiOrgYksus.getAvatud()).append(" ").append(piiripunktiOrgYksus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiiririkkujaConverter implements Converter<Piiririkkuja, String> {
        public String convert(Piiririkkuja piiririkkuja) {
            return new StringBuilder().append(piiririkkuja.getAvaja()).append(" ").append(piiririkkuja.getAvatud()).append(" ").append(piiririkkuja.getEesnimi()).append(" ").append(piiririkkuja.getIsikukood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvurConverter implements Converter<Piirivalvur, String> {
        public String convert(Piirivalvur piirivalvur) {
            return new StringBuilder().append(piirivalvur.getEesnimed()).append(" ").append(piirivalvur.getIsikukood()).append(" ").append(piirivalvur.getKommentaar()).append(" ").append(piirivalvur.getPerekonnanimi()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvurIntsidendiConverter implements Converter<PiirivalvurIntsidendi, String> {
        public String convert(PiirivalvurIntsidendi piirivalvurIntsidendi) {
            return new StringBuilder().append(piirivalvurIntsidendi.getAlates()).append(" ").append(piirivalvurIntsidendi.getAvaja()).append(" ").append(piirivalvurIntsidendi.getAvatud()).append(" ").append(piirivalvurIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvurPiiripunktiConverter implements Converter<PiirivalvurPiiripunkti, String> {
        public String convert(PiirivalvurPiiripunkti piirivalvurPiiripunkti) {
            return new StringBuilder().append(piirivalvurPiiripunkti.getAlates()).append(" ").append(piirivalvurPiiripunkti.getAvaja()).append(" ").append(piirivalvurPiiripunkti.getAvatud()).append(" ").append(piirivalvurPiiripunkti.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvurVaeosaConverter implements Converter<PiirivalvurVaeosa, String> {
        public String convert(PiirivalvurVaeosa piirivalvurVaeosa) {
            return new StringBuilder().append(piirivalvurVaeosa.getAlates()).append(" ").append(piirivalvurVaeosa.getAvaja()).append(" ").append(piirivalvurVaeosa.getAvatud()).append(" ").append(piirivalvurVaeosa.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvurVodikohalConverter implements Converter<PiirivalvurVodikohal, String> {
        public String convert(PiirivalvurVodikohal piirivalvurVodikohal) {
            return new StringBuilder().append(piirivalvurVodikohal.getAlates()).append(" ").append(piirivalvurVodikohal.getAvaja()).append(" ").append(piirivalvurVodikohal.getAvatud()).append(" ").append(piirivalvurVodikohal.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvuriKontaktConverter implements Converter<PiirivalvuriKontakt, String> {
        public String convert(PiirivalvuriKontakt piirivalvuriKontakt) {
            return new StringBuilder().append(piirivalvuriKontakt.getAlates()).append(" ").append(piirivalvuriKontakt.getAvaja()).append(" ").append(piirivalvuriKontakt.getAvatud()).append(" ").append(piirivalvuriKontakt.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.PiirivalvuriSeadusIntsidendiConverter implements Converter<PiirivalvuriSeadusIntsidendi, String> {
        public String convert(PiirivalvuriSeadusIntsidendi piirivalvuriSeadusIntsidendi) {
            return new StringBuilder().append(piirivalvuriSeadusIntsidendi.getAlates()).append(" ").append(piirivalvuriSeadusIntsidendi.getAvaja()).append(" ").append(piirivalvuriSeadusIntsidendi.getAvatud()).append(" ").append(piirivalvuriSeadusIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.RiigiAdminYksusConverter implements Converter<RiigiAdminYksus, String> {
        public String convert(RiigiAdminYksus riigiAdminYksus) {
            return new StringBuilder().append(riigiAdminYksus.getAlates()).append(" ").append(riigiAdminYksus.getAvaja()).append(" ").append(riigiAdminYksus.getAvatud()).append(" ").append(riigiAdminYksus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.RiigiAdminYksuseLiikConverter implements Converter<RiigiAdminYksuseLiik, String> {
        public String convert(RiigiAdminYksuseLiik riigiAdminYksuseLiik) {
            return new StringBuilder().append(riigiAdminYksuseLiik.getAlates()).append(" ").append(riigiAdminYksuseLiik.getAvaja()).append(" ").append(riigiAdminYksuseLiik.getAvatud()).append(" ").append(riigiAdminYksuseLiik.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.RiikConverter implements Converter<Riik, String> {
        public String convert(Riik riik) {
            return new StringBuilder().append(riik.getAnsiKood()).append(" ").append(riik.getAvaja()).append(" ").append(riik.getAvatud()).append(" ").append(riik.getIsoKood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.RuumiyksusConverter implements Converter<Ruumiyksus, String> {
        public String convert(Ruumiyksus ruumiyksus) {
            return new StringBuilder().append(ruumiyksus.getAadress()).append(" ").append(ruumiyksus.getAvaja()).append(" ").append(ruumiyksus.getAvatud()).append(" ").append(ruumiyksus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.RuumiyksuseLiikConverter implements Converter<RuumiyksuseLiik, String> {
        public String convert(RuumiyksuseLiik ruumiyksuseLiik) {
            return new StringBuilder().append(ruumiyksuseLiik.getAvaja()).append(" ").append(ruumiyksuseLiik.getAvatud()).append(" ").append(ruumiyksuseLiik.getKommentaar()).append(" ").append(ruumiyksuseLiik.getKood()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.SeadusConverter implements Converter<Seadus, String> {
        public String convert(Seadus seadus) {
            return new StringBuilder().append(seadus.getAvaja()).append(" ").append(seadus.getAvatud()).append(" ").append(seadus.getKehtivAlates()).append(" ").append(seadus.getKehtivKuni()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.SeadusePunktConverter implements Converter<SeadusePunkt, String> {
        public String convert(SeadusePunkt seadusePunkt) {
            return new StringBuilder().append(seadusePunkt.getAvaja()).append(" ").append(seadusePunkt.getAvatud()).append(" ").append(seadusePunkt.getKehtivAlates()).append(" ").append(seadusePunkt.getKehtivKuni()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.SeotudKontaktisikConverter implements Converter<SeotudKontaktisik, String> {
        public String convert(SeotudKontaktisik seotudKontaktisik) {
            return new StringBuilder().append(seotudKontaktisik.getAlates()).append(" ").append(seotudKontaktisik.getAvaja()).append(" ").append(seotudKontaktisik.getAvatud()).append(" ").append(seotudKontaktisik.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.SuguluseRolliLiikConverter implements Converter<SuguluseRolliLiik, String> {
        public String convert(SuguluseRolliLiik suguluseRolliLiik) {
            return new StringBuilder().append(suguluseRolliLiik.getAvaja()).append(" ").append(suguluseRolliLiik.getAvatud()).append(" ").append(suguluseRolliLiik.getKommentaar()).append(" ").append(suguluseRolliLiik.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VaeosaConverter implements Converter<Vaeosa, String> {
        public String convert(Vaeosa vaeosa) {
            return new StringBuilder().append(vaeosa.getAlates()).append(" ").append(vaeosa.getAvaja()).append(" ").append(vaeosa.getAvatud()).append(" ").append(vaeosa.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VaeosaAlluvusConverter implements Converter<VaeosaAlluvus, String> {
        public String convert(VaeosaAlluvus vaeosaAlluvus) {
            return new StringBuilder().append(vaeosaAlluvus.getAlates()).append(" ").append(vaeosaAlluvus.getAvaja()).append(" ").append(vaeosaAlluvus.getAvatud()).append(" ").append(vaeosaAlluvus.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VahtkondConverter implements Converter<Vahtkond, String> {
        public String convert(Vahtkond vahtkond) {
            return new StringBuilder().append(vahtkond.getAlates()).append(" ").append(vahtkond.getAvaja()).append(" ").append(vahtkond.getAvatud()).append(" ").append(vahtkond.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VahtkondIntsidendiConverter implements Converter<VahtkondIntsidendi, String> {
        public String convert(VahtkondIntsidendi vahtkondIntsidendi) {
            return new StringBuilder().append(vahtkondIntsidendi.getAlates()).append(" ").append(vahtkondIntsidendi.getAvaja()).append(" ").append(vahtkondIntsidendi.getAvatud()).append(" ").append(vahtkondIntsidendi.getKirjeldus()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VahtkonnaLiigeConverter implements Converter<VahtkonnaLiige, String> {
        public String convert(VahtkonnaLiige vahtkonnaLiige) {
            return new StringBuilder().append(vahtkonnaLiige.getAlates()).append(" ").append(vahtkonnaLiige.getAvaja()).append(" ").append(vahtkonnaLiige.getAvatud()).append(" ").append(vahtkonnaLiige.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VahtkonndPiiriloigulConverter implements Converter<VahtkonndPiiriloigul, String> {
        public String convert(VahtkonndPiiriloigul vahtkonndPiiriloigul) {
            return new StringBuilder().append(vahtkonndPiiriloigul.getAlates()).append(" ").append(vahtkonndPiiriloigul.getAvaja()).append(" ").append(vahtkonndPiiriloigul.getAvatud()).append(" ").append(vahtkonndPiiriloigul.getKommentaar()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VoimalikAlluvusConverter implements Converter<VoimalikAlluvus, String> {
        public String convert(VoimalikAlluvus voimalikAlluvus) {
            return new StringBuilder().append(voimalikAlluvus.getAvaja()).append(" ").append(voimalikAlluvus.getAvatud()).append(" ").append(voimalikAlluvus.getKommentaar()).append(" ").append(voimalikAlluvus.getMuudetud()).toString();
        }
        
    }
    
    static class ee.itcollege.i377.web.ApplicationConversionServiceFactoryBean.VoodikohtConverter implements Converter<Voodikoht, String> {
        public String convert(Voodikoht voodikoht) {
            return new StringBuilder().append(voodikoht.getAvaja()).append(" ").append(voodikoht.getAvatud()).append(" ").append(voodikoht.getKommentaar()).append(" ").append(voodikoht.getLaius()).toString();
        }
        
    }
    
}
