package ee.itcollege.i377.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@MappedSuperclass
@RooToString
@RooEntity(mappedSuperclass = true)
public class Baasolem {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		String avaja;
		String muutja;
		String sulgeja;
		
		@Temporal( TemporalType.DATE)
	    @DateTimeFormat(style="M-")
		Date avatud;
		
		@Temporal( TemporalType.DATE)
	    @DateTimeFormat(style="M-")
		Date muudetud;
		
		@Temporal( TemporalType.DATE)
	    @DateTimeFormat(style="M-")
		Date suletud;
				
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAvaja() {
			return avaja;
		}
		public void setAvaja(String avaja) {
			this.avaja = avaja;
		}
		public String getMuutja() {
			return muutja;
		}
		public void setMuutja(String muutja) {
			this.muutja = muutja;
		}
		public String getSulgeja() {
			return sulgeja;
		}
		public void setSulgeja(String sulgeja) {
			this.sulgeja = sulgeja;
		}
		public Date getAvatud() {
			return avatud;
		}
		public void setAvatud(Date avatud) {
			this.avatud = avatud;
		}
		public Date getMuudetud() {
			return muudetud;
		}
		public void setMuudetud(Date muudetud) {
			this.muudetud = muudetud;
		}
		public Date getSuletud() {
			return suletud;
		}
		public void setSuletud(Date suletud) {
			this.suletud = suletud;
		}

	

	}

	
	
	

