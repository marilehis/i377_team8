package ee.itcollege.i377.entities;

import java.util.Date;
import java.util.List;

public class SeedDatabase {
	
	public void setPiirivalvurid(List<Piirivalvur> list) {
		for(Piirivalvur o: list) {
			if (! Piirivalvur.exists(o)) {
				o.setAvaja("automaatika");
				o.setAvatud(new Date());
				o.setMuudetud(SurrogaatKuupaev.getInstance());
				o.setSuletud(SurrogaatKuupaev.getInstance());
				o.persist();
			}
		}
	}
	
	public void setVahtkonnad(List<Vahtkond> list) {
		for (Vahtkond o: list) {
			if (! Vahtkond.exists(o)) {
				o.setAvaja("automaatika");
				o.setAvatud(new Date());
				o.setAlates(new Date());
				o.setKuni(SurrogaatKuupaev.getInstance());
				o.setMuudetud(SurrogaatKuupaev.getInstance());
				o.setSuletud(SurrogaatKuupaev.getInstance());
				o.persist();
			}
		}
	}
	
	public void setPiiripunktid(List<Piiripunkt> list) {
		for (Piiripunkt o: list) {
			if (! Piiripunkt.exists(o)) {
				o.setAvaja("automaatika");
				o.setAvatud(new Date());
				o.setAlates(new Date());
				o.setKuni(SurrogaatKuupaev.getInstance());
				o.setMuudetud(SurrogaatKuupaev.getInstance());
				o.setSuletud(SurrogaatKuupaev.getInstance());
				o.persist();
			}
		}
	}
	
	public void setPiiriloigud(List<Piiriloik> list) {
		for (Piiriloik o: list) {
			if (! Piiriloik.exists(o)) {
				o.setAvaja("automaatika");
				o.setAvatud(new Date());
				o.setMuudetud(SurrogaatKuupaev.getInstance());
				o.setSuletud(SurrogaatKuupaev.getInstance());
				o.persist();
			}
		}
	}

}
