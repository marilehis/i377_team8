package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRILOIK database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Piiriloik extends Baasolem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="GPS_KOORDINAADID")
	private String gpsKoordinaadid;

	private String kommentaar;

	private String kood;

	private String nimetus;

	//bi-directional many-to-one association to Intsident
	@OneToMany(mappedBy="piiriloik")
	private Set<Intsident> intsidents;

	//bi-directional many-to-one association to PiiriloiguHaldaja
	@OneToMany(mappedBy="piiriloik")
	private Set<PiiriloiguHaldaja> piiriloiguHaldajas;

	//bi-directional many-to-one association to VahtkonndPiiriloigul
	@OneToMany(mappedBy="piiriloik")
	private Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls;

    public Piiriloik() {
    }


	public String getGpsKoordinaadid() {
		return this.gpsKoordinaadid;
	}

	public void setGpsKoordinaadid(String gpsKoordinaadid) {
		this.gpsKoordinaadid = gpsKoordinaadid;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public Set<Intsident> getIntsidents() {
		return this.intsidents;
	}

	public void setIntsidents(Set<Intsident> intsidents) {
		this.intsidents = intsidents;
	}
	
	public Set<PiiriloiguHaldaja> getPiiriloiguHaldajas() {
		return this.piiriloiguHaldajas;
	}

	public void setPiiriloiguHaldajas(Set<PiiriloiguHaldaja> piiriloiguHaldajas) {
		this.piiriloiguHaldajas = piiriloiguHaldajas;
	}
	
	public Set<VahtkonndPiiriloigul> getVahtkonndPiiriloiguls() {
		return this.vahtkonndPiiriloiguls;
	}

	public void setVahtkonndPiiriloiguls(Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls) {
		this.vahtkonndPiiriloiguls = vahtkonndPiiriloiguls;
	}
	
	public static boolean exists(Piiriloik o) {
    	return entityManager().
    			createQuery("SELECT COUNT(o) FROM Piiriloik o WHERE o.nimetus = :nimetus", Long.class).
    			setParameter("nimetus", o.getNimetus()).
    			getSingleResult() > 0;
	}
	
    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Piirilõiku ei tohi kustutada!");
    }
    
    public static long countPiiriloiks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Piiriloik o WHERE o.sulgeja IS NULL", Long.class).
        		getSingleResult();
    }
    
    public static List<Piiriloik> findAllPiiriloiks() {
        return entityManager().createQuery("SELECT o FROM Piiriloik o WHERE o.sulgeja IS NULL", Piiriloik.class).
        		getResultList();
    }
    
    public static List<Piiriloik> findPiiriloikEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Piiriloik o WHERE o.sulgeja IS NULL", Piiriloik.class).setFirstResult(firstResult).setMaxResults(maxResults).
        		getResultList();
    }
	
}
