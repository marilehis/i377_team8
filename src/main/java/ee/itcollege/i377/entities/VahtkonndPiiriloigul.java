package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VAHTKONND_PIIRILOIGUL database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="VAHTKONND_PIIRILOIGUL")
public class VahtkonndPiiriloigul implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKOND_PIIRILOIUL_ID")
	private Long vahtkondPiiriloiulId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates; // ok

	private String avaja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date avatud; // ok

	private String kommentaar;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni; // ok

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date muudetud; // ok

	private String muutja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date suletud; // ok

	private String sulgeja;

	//bi-directional many-to-one association to Piiriloik
    @ManyToOne
	@JoinColumn(name="PIIRILOIK_ID")
	private Piiriloik piiriloik;

	//bi-directional many-to-one association to Vahtkond
    @ManyToOne
	@JoinColumn(name="VAHTKOND_ID")
	private Vahtkond vahtkond;

    public VahtkonndPiiriloigul() {
    }

	public Long getVahtkondPiiriloiulId() {
		return this.vahtkondPiiriloiulId;
	}

	public void setVahtkondPiiriloiulId(Long vahtkondPiiriloiulId) {
		this.vahtkondPiiriloiulId = vahtkondPiiriloiulId;
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Piiriloik getPiiriloik() {
		return this.piiriloik;
	}

	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}
	
	public Vahtkond getVahtkond() {
		return this.vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}
	
	 public static List<VahtkonndPiiriloigul> findVahtkonndPiiriloigulEntriesByVahtkond(Long vahtkondId, int firstResult, int maxResults) {
		 return entityManager().
				 createQuery("SELECT o FROM VahtkonndPiiriloigul o where o.suletud = :surrogaat AND vahtkond_ID = "+ vahtkondId.toString(), VahtkonndPiiriloigul.class).
				 setParameter("surrogaat", SurrogaatKuupaev.getInstance()).
				 setFirstResult(firstResult).
				 setMaxResults(maxResults).
				 getResultList();
	 }
	 
    public static long countVahtkonndPiiriloiguls(Long vahtkondId) {
        return entityManager().
        		createQuery("SELECT COUNT(o) FROM VahtkonndPiiriloigul o WHERE o.suletud = :surrogaat AND vahtkond_ID = " + vahtkondId.toString(), Long.class).
        		setParameter("surrogaat", SurrogaatKuupaev.getInstance()).
        		getSingleResult();
    }
    
    public static List<VahtkonndPiiriloigul> findAllVahtkonndPiiriloiguls() {
        return entityManager().createQuery("SELECT o FROM VahtkonndPiiriloigul o WHERE o.suletud = :surrogaat", VahtkonndPiiriloigul.class).
        		setParameter("surrogaat", SurrogaatKuupaev.getInstance()).
        		getResultList();
    }
    
    public static List<VahtkonndPiiriloigul> findVahtkonndPiiriloigulEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM VahtkonndPiiriloigul o WHERE o.suletud = :surrogaat", VahtkonndPiiriloigul.class).
        		setParameter("surrogaat", SurrogaatKuupaev.getInstance()).
        		setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	 
    @PreRemove
	public void preventRemove() {
		 throw new SecurityException("Vahtkonna ja piirilõigu seose kustutamine keelatud!");
	}
	 
}
