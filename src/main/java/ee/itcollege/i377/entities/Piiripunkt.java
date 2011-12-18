package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the PIIRIPUNKT database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Piiripunkt extends Baasolem implements Serializable {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates; // ok

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUIDE")
	private BigDecimal gpsLongituide;

	private String kommentaar;

	private String kood;

	@Column(name="KORGUS_MEREPINNAST")
	private BigDecimal korgusMerepinnast;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni; // ok

	private String nimetus;

	//bi-directional many-to-one association to AmetPiiripunkti
	@OneToMany(mappedBy="piiripunkt")
	private Set<AmetPiiripunkti> ametPiiripunktis;

	//bi-directional many-to-one association to PiiriloiguHaldaja
	@OneToMany(mappedBy="piiripunkt")
	private Set<PiiriloiguHaldaja> piiriloiguHaldajas;

	//bi-directional many-to-one association to PiiripunktiAlluvus
	@OneToMany(mappedBy="piiripunkt")
	private Set<PiiripunktiAlluvus> piiripunktiAlluvuses;

	//bi-directional many-to-one association to PiiripunktiOrgYksus
	@OneToMany(mappedBy="piiripunkt")
	private Set<PiiripunktiOrgYksus> piiripunktiOrgYksuses;

	//bi-directional many-to-one association to Vahtkond
	@OneToMany(mappedBy="piiripunkt")
	private Set<Vahtkond> vahtkonds;

    public Piiripunkt() {
    }

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public BigDecimal getGpsLatitude() {
		return this.gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLongituide() {
		return this.gpsLongituide;
	}

	public void setGpsLongituide(BigDecimal gpsLongituide) {
		this.gpsLongituide = gpsLongituide;
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

	public BigDecimal getKorgusMerepinnast() {
		return this.korgusMerepinnast;
	}

	public void setKorgusMerepinnast(BigDecimal korgusMerepinnast) {
		this.korgusMerepinnast = korgusMerepinnast;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public Set<AmetPiiripunkti> getAmetPiiripunktis() {
		return this.ametPiiripunktis;
	}

	public void setAmetPiiripunktis(Set<AmetPiiripunkti> ametPiiripunktis) {
		this.ametPiiripunktis = ametPiiripunktis;
	}
	
	public Set<PiiriloiguHaldaja> getPiiriloiguHaldajas() {
		return this.piiriloiguHaldajas;
	}

	public void setPiiriloiguHaldajas(Set<PiiriloiguHaldaja> piiriloiguHaldajas) {
		this.piiriloiguHaldajas = piiriloiguHaldajas;
	}
	
	public Set<PiiripunktiAlluvus> getPiiripunktiAlluvuses() {
		return this.piiripunktiAlluvuses;
	}

	public void setPiiripunktiAlluvuses(Set<PiiripunktiAlluvus> piiripunktiAlluvuses) {
		this.piiripunktiAlluvuses = piiripunktiAlluvuses;
	}
	
	public Set<PiiripunktiOrgYksus> getPiiripunktiOrgYksuses() {
		return this.piiripunktiOrgYksuses;
	}

	public void setPiiripunktiOrgYksuses(Set<PiiripunktiOrgYksus> piiripunktiOrgYksuses) {
		this.piiripunktiOrgYksuses = piiripunktiOrgYksuses;
	}
	
	public Set<Vahtkond> getVahtkonds() {
		return this.vahtkonds;
	}

	public void setVahtkonds(Set<Vahtkond> vahtkonds) {
		this.vahtkonds = vahtkonds;
	}
	
	public static boolean exists(Piiripunkt o) {
    	return entityManager().
    			createQuery("SELECT COUNT(o) FROM Piiripunkt o WHERE o.nimetus = :nimetus", Long.class).
    			setParameter("nimetus", o.getNimetus()).
    			getSingleResult() > 0;
	}
	
    public static long countPiiripunkts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Piiripunkt o WHERE o.sulgeja IS NULL", Long.class).
        		getSingleResult();
    }
    
    public static List<Piiripunkt> findAllPiiripunkts() {
        return entityManager().createQuery("SELECT o FROM Piiripunkt o WHERE o.sulgeja IS NULL", Piiripunkt.class).
        		getResultList();
    }
    
    public static List<Piiripunkt> findPiiripunktEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Piiripunkt o WHERE o.sulgeja IS NULL", Piiripunkt.class).
        		setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Piiripunkti ei tohi kustutada!");
    }    

}
