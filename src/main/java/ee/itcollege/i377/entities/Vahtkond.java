package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the VAHTKOND database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Vahtkond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKOND_ID")
	private Long vahtkondId;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date alates; // ok

	private String avaja;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date avatud; // ok

	private String kommentaar;

	private String kood;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date kuni; // ok

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date muudetud; // ok

	private String muutja;

	private String nimetus;

    @Temporal( TemporalType.DATE)
    @DateTimeFormat(style="M-")
	private Date suletud; // ok

	private String sulgeja;

	//bi-directional many-to-one association to Piiripunkt
    @ManyToOne
	@JoinColumn(name="PIIRIPUNKT_ID")
	private Piiripunkt piiripunkt;

	//bi-directional many-to-one association to Vaeosa
    @ManyToOne
	@JoinColumn(name="VAEOSA_ID_ID")
	private Vaeosa vaeosa;

	//bi-directional many-to-one association to VahtkondIntsidendi
	@OneToMany(mappedBy="vahtkond")
	private Set<VahtkondIntsidendi> vahtkondIntsidendis;

	//bi-directional many-to-one association to VahtkonnaLiige
	@OneToMany(mappedBy="vahtkond")
	private Set<VahtkonnaLiige> vahtkonnaLiiges;

	//bi-directional many-to-one association to VahtkonndPiiriloigul
	@OneToMany(mappedBy="vahtkond")
	private Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls;

	
	
	private String vahtkondName;
	
	public String getVahtkondName() {
		return this.vahtkondName;
	}
	
	public void setVahtkondName(String vahtkondName) {
		this.vahtkondName = vahtkondName;
	}
	
	
    public Vahtkond() {
    }

	public Long getVahtkondId() {
		return this.vahtkondId;
	}

	public void setVahtkondId(Long vahtkondId) {
		this.vahtkondId = vahtkondId;
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

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
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

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
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

	public Piiripunkt getPiiripunkt() {
		return this.piiripunkt;
	}

	public void setPiiripunkt(Piiripunkt piiripunkt) {
		this.piiripunkt = piiripunkt;
	}
	
	public Vaeosa getVaeosa() {
		return this.vaeosa;
	}

	public void setVaeosa(Vaeosa vaeosa) {
		this.vaeosa = vaeosa;
	}
	
	public Set<VahtkondIntsidendi> getVahtkondIntsidendis() {
		return this.vahtkondIntsidendis;
	}

	public void setVahtkondIntsidendis(Set<VahtkondIntsidendi> vahtkondIntsidendis) {
		this.vahtkondIntsidendis = vahtkondIntsidendis;
	}
	
	public Set<VahtkonnaLiige> getVahtkonnaLiiges() {
		return this.vahtkonnaLiiges;
	}

	public void setVahtkonnaLiiges(Set<VahtkonnaLiige> vahtkonnaLiiges) {
		this.vahtkonnaLiiges = vahtkonnaLiiges;
	}
	
	public Set<VahtkonndPiiriloigul> getVahtkonndPiiriloiguls() {
		return this.vahtkonndPiiriloiguls;
	}

	public void setVahtkonndPiiriloiguls(Set<VahtkonndPiiriloigul> vahtkonndPiiriloiguls) {
		this.vahtkonndPiiriloiguls = vahtkonndPiiriloiguls;
	}
	
	public static boolean exists(Vahtkond o) {
    	return entityManager().
    			createQuery("SELECT COUNT(o) FROM Vahtkond o WHERE o.nimetus = :nimetus", Long.class).
    			setParameter("nimetus", o.getNimetus()).
    			getSingleResult() > 0;
	}

	public static Vahtkond findByNimetus(String nimetus) {
    	return entityManager().
    			createQuery("SELECT o FROM Vahtkond o WHERE o.nimetus = :nimetus", Vahtkond.class).
    			setParameter("nimetus", nimetus).
    			getSingleResult();
	}

	@PreRemove
	public void preventRemove() {
		 throw new SecurityException("Vahtkonna kustutamine keelatud");
	}
	 
    public static List<Vahtkond> findAllVahtkonds() {
        return entityManager().createQuery("SELECT o FROM Vahtkond o WHERE o.suletud IS NULL", Vahtkond.class).getResultList();
    }
	    
	 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("Kood: ").append(getKood()).append(", ");
        sb.append("Alates: ").append(getAlates()).append(", ");
        sb.append("Kuni: ").append(getKuni()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Piiripunkt: ").append(getPiiripunkt()).append(", ");
        sb.append("Vaeosa: ").append(getVaeosa()).append(", ");
        sb.append("VahtkondId: ").append(getVahtkondId()).append(", ");
        sb.append("VahtkondIntsidendis: ").append(getVahtkondIntsidendis() == null ? "null" : getVahtkondIntsidendis().size()).append(", ");
        sb.append("VahtkonnaLiiges: ").append(getVahtkonnaLiiges() == null ? "null" : getVahtkonnaLiiges().size()).append(", ");
        sb.append("VahtkonndPiiriloiguls: ").append(getVahtkonndPiiriloiguls() == null ? "null" : getVahtkonndPiiriloiguls().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
    
    
    
	
}
