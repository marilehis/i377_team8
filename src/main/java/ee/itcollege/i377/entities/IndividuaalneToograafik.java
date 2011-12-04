package ee.itcollege.i377.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndividuaalneToograafik {

	private Date alates;
	private Date kuni;
	private Piiriloik piiriloik;
	private Vahtkond vahtkond;

	public IndividuaalneToograafik() {
	}

	public Date getAlates() {
		return alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Piiriloik getPiiriloik() {
		return piiriloik;
	}

	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

	public static List<IndividuaalneToograafik> findIndividuaalneToograafikFor(Piirivalvur piirivalvur,
			Date alates, Date kuni) {
		List<IndividuaalneToograafik> rows = new ArrayList<IndividuaalneToograafik>();
		for(VahtkonnaLiige vahtkonnaLiige : piirivalvur.getVahtkonnaLiiges()) {
			if (null != vahtkonnaLiige.getSuletud())
				continue;
			
			Vahtkond vahtkond = vahtkonnaLiige.getVahtkond();
			if (null != vahtkond.getSuletud())
				continue;
				
			for(VahtkonndPiiriloigul vahtkondPiiriloigul : vahtkond.getVahtkonndPiiriloiguls()) {
				if (null != vahtkondPiiriloigul.getSuletud())
					continue;
				
				if ((null != alates) && (alates.after(vahtkondPiiriloigul.getAlates()))) {
					continue;
				}
				
				if ((null != kuni) && (kuni.before(vahtkondPiiriloigul.getAlates()))) {
					continue;
				}
				
				IndividuaalneToograafik rida = new IndividuaalneToograafik();
				rida.setAlates(vahtkondPiiriloigul.getAlates());
				rida.setKuni(vahtkondPiiriloigul.getKuni());
				rida.setPiiriloik(vahtkondPiiriloigul.getPiiriloik());
				rida.setVahtkond(vahtkond);
				rows.add(rida);
			}
		}
    	return rows;
    }}
