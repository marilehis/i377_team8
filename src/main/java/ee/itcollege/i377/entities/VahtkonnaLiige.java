package ee.itcollege.i377.entities;

import java.io.Serializable;
import java.util.Date;

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

import ee.itcollege.i377.entities.VahtkonnaLiige;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;


/**
 * The persistent class for the VAHTKONNA_LIIGE database table.
 * 
 */
@Entity
@RooToString
@RooEntity
@Table(name="VAHTKONNA_LIIGE")
public class VahtkonnaLiige implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VAHTKONNA_LIIGE_ID")
	private Long vahtkonnaLiigeId;

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

	//bi-directional many-to-one association to Piirivalvur
    @ManyToOne
	@JoinColumn(name="PIIRIVALVUR_ID")
	private Piirivalvur piirivalvur;

	//bi-directional many-to-one association to Vahtkond
    @ManyToOne
	@JoinColumn(name="VAHTKOND_ID")
	private Vahtkond vahtkond;
    
    
    
    private String vahtkondName;
	
	public String getVahtkondName() {
		return this.vahtkondName;
	}
	
	public void setVahtkondName(String vahtkondName) {
		this.vahtkondName = vahtkondName;
	}

    public VahtkonnaLiige() {
    }

	public Long getVahtkonnaLiigeId() {
		return this.vahtkonnaLiigeId;
	}

	public void setVahtkonnaLiigeId(Long vahtkonnaLiigeId) {
		this.vahtkonnaLiigeId = vahtkonnaLiigeId;
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

	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	
	public Vahtkond getVahtkond() {
		return this.vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}
	
	@PreRemove
	public void preventRemove() {
		 throw new SecurityException("Vahtkonna liikme kustutamine keelatud!");
	}
	
	 public static List<VahtkonnaLiige> findAllVahtkonnaLiiges() {
		 List<VahtkonnaLiige> L = entityManager().createQuery("SELECT o FROM VahtkonnaLiige o", VahtkonnaLiige.class).getResultList();
		 for(VahtkonnaLiige item : L ){
			 L.setVahtkondName(L.getVahtkond().getNimetus());
		 }
		 return L;
	 }
	
	
	
	 
}
