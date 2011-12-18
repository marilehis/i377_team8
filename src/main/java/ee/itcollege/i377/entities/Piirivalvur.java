package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRIVALVUR database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Piirivalvur extends Baasolem implements Serializable {
	private static final long serialVersionUID = 1L;

	private String eesnimed;

	private String isikukood;

	private String kommentaar;

	private String perekonnanimi;

	@Column(name="SODURI_KOOD")
	private String soduriKood;

	private String sugu;

	//bi-directional many-to-one association to AuastmeMuutumine
	@OneToMany(mappedBy="piirivalvur")
	private Set<AuastmeMuutumine> auastmeMuutumines;

	//bi-directional many-to-one association to PiirivalvuriKontakt
	@OneToMany(mappedBy="piirivalvur")
	private Set<PiirivalvuriKontakt> piirivalvuriKontakts;

	//bi-directional many-to-one association to PiirivalvurIntsidendi
	@OneToMany(mappedBy="piirivalvur")
	private Set<PiirivalvurIntsidendi> piirivalvurIntsidendis;

	//bi-directional many-to-one association to PiirivalvurPiiripunkti
	@OneToMany(mappedBy="piirivalvur")
	private Set<PiirivalvurPiiripunkti> piirivalvurPiiripunktis;

	//bi-directional many-to-one association to PiirivalvurVaeosa
	@OneToMany(mappedBy="piirivalvur")
	private Set<PiirivalvurVaeosa> piirivalvurVaeosas;

	//bi-directional many-to-one association to PiirivalvurVodikohal
	@OneToMany(mappedBy="piirivalvur")
	private Set<PiirivalvurVodikohal> piirivalvurVodikohals;

	//bi-directional many-to-one association to SeotudKontaktisik
	@OneToMany(mappedBy="piirivalvur")
	private Set<SeotudKontaktisik> seotudKontaktisiks;

	//bi-directional many-to-one association to VahtkonnaLiige
	@OneToMany(mappedBy="piirivalvur")
	private Set<VahtkonnaLiige> vahtkonnaLiiges;

    public Piirivalvur() {
    }

	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSoduriKood() {
		return this.soduriKood;
	}

	public void setSoduriKood(String soduriKood) {
		this.soduriKood = soduriKood;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public Set<AuastmeMuutumine> getAuastmeMuutumines() {
		return this.auastmeMuutumines;
	}

	public void setAuastmeMuutumines(Set<AuastmeMuutumine> auastmeMuutumines) {
		this.auastmeMuutumines = auastmeMuutumines;
	}
	
	public Set<PiirivalvuriKontakt> getPiirivalvuriKontakts() {
		return this.piirivalvuriKontakts;
	}

	public void setPiirivalvuriKontakts(Set<PiirivalvuriKontakt> piirivalvuriKontakts) {
		this.piirivalvuriKontakts = piirivalvuriKontakts;
	}
	
	public Set<PiirivalvurIntsidendi> getPiirivalvurIntsidendis() {
		return this.piirivalvurIntsidendis;
	}

	public void setPiirivalvurIntsidendis(Set<PiirivalvurIntsidendi> piirivalvurIntsidendis) {
		this.piirivalvurIntsidendis = piirivalvurIntsidendis;
	}
	
	public Set<PiirivalvurPiiripunkti> getPiirivalvurPiiripunktis() {
		return this.piirivalvurPiiripunktis;
	}

	public void setPiirivalvurPiiripunktis(Set<PiirivalvurPiiripunkti> piirivalvurPiiripunktis) {
		this.piirivalvurPiiripunktis = piirivalvurPiiripunktis;
	}
	
	public Set<PiirivalvurVaeosa> getPiirivalvurVaeosas() {
		return this.piirivalvurVaeosas;
	}

	public void setPiirivalvurVaeosas(Set<PiirivalvurVaeosa> piirivalvurVaeosas) {
		this.piirivalvurVaeosas = piirivalvurVaeosas;
	}
	
	public Set<PiirivalvurVodikohal> getPiirivalvurVodikohals() {
		return this.piirivalvurVodikohals;
	}

	public void setPiirivalvurVodikohals(Set<PiirivalvurVodikohal> piirivalvurVodikohals) {
		this.piirivalvurVodikohals = piirivalvurVodikohals;
	}
	
	public Set<SeotudKontaktisik> getSeotudKontaktisiks() {
		return this.seotudKontaktisiks;
	}

	public void setSeotudKontaktisiks(Set<SeotudKontaktisik> seotudKontaktisiks) {
		this.seotudKontaktisiks = seotudKontaktisiks;
	}
	
	public Set<VahtkonnaLiige> getVahtkonnaLiiges() {
		return this.vahtkonnaLiiges;
	}

	public void setVahtkonnaLiiges(Set<VahtkonnaLiige> vahtkonnaLiiges) {
		this.vahtkonnaLiiges = vahtkonnaLiiges;
	}
	
    public static boolean exists(Piirivalvur p) {
    	return entityManager().
    			createQuery("SELECT COUNT(o) FROM Piirivalvur o WHERE o.eesnimed = :eesnimed AND o.perekonnanimi = :perekonnanimi", Long.class).
    			setParameter("eesnimed", p.getEesnimed()).
    			setParameter("perekonnanimi", p.getPerekonnanimi()).
    			getSingleResult() > 0;
    }
    
    public static long countPiirivalvurs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Piirivalvur o WHERE o.sulgeja IS NULL", Long.class).
        		getSingleResult();
        
    }
    
    public static List<Piirivalvur> findAllPiirivalvurs() {
        return entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.sulgeja IS NULL", Piirivalvur.class).
        		getResultList();
    }
    
    public static List<Piirivalvur> findPiirivalvurEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.sulgeja IS NULL", Piirivalvur.class).
        		setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Piirivalvurit ei tohi kustutada");
    }    
    
    public static Piirivalvur findByIsikukood(String isikukood) {
        return entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.isikukood = :isikukood", Piirivalvur.class).
        		setParameter("isikukood", isikukood).
        		getSingleResult();
    }
    
    public String getNimi() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getEesnimed());
    	sb.append(" ");
    	sb.append(getPerekonnanimi());
    	return sb.toString();
    }
    
    public List<IndividuaalneToograafik> getIndividuaalneToograafik(Date alates, Date kuni) {
    	return IndividuaalneToograafik.findIndividuaalneToograafikFor(this, alates, kuni);
    }
	
}
