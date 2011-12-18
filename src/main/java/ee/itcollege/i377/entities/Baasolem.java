package ee.itcollege.i377.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

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
		
		Date avatud;
		Date muudetud;
		Date suletud;
			
		
		protected static String authUser() {

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			if (auth != null) {
				String userName = auth.getName();
				return userName;
			}

			else

				return null;

		}


		@PrePersist
		public void recordCreated() {
			setAvatud(new Date());
			setMuudetud((SurrogaatKuupaev.getInstance()));
			setSuletud((SurrogaatKuupaev.getInstance()));
			setAvaja(authUser());
		}

		@PreUpdate
		public void recordUpdated() {
			setMuudetud(new Date());
			setMuutja(authUser());
		}

		@PreRemove
		public void preventRemove() {
			throw new SecurityException("Removing of records is prohibited!");
		}

		@Transactional
		public void remove() {
			setSuletud(new Date());
			setSulgeja(authUser());
			merge();
		}

		@Transactional
		public Baasolem merge() {
			if (this.entityManager == null)
				this.entityManager = entityManager();

			if (this.id != null && !entityManager.contains(this)) {
				Baasolem oldEntity = entityManager().find(getClass(), id);
				if (getAvatud() == null)
					setAvatud(oldEntity.getAvatud());
				if (getAvaja() == null)
					setAvaja(oldEntity.getAvaja());
				if (getSuletud() == null)
					setSuletud(oldEntity.getSuletud());
				if (getSulgeja() == null)
					setSulgeja(oldEntity.getSulgeja());

			}
			Baasolem merged = this.entityManager.merge(this);
			this.entityManager.flush();
			return merged;
		}
		
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		protected String getAvaja() {
			return avaja;
		}
		protected void setAvaja(String avaja) {
			this.avaja = avaja;
		}
		protected String getMuutja() {
			return muutja;
		}
		protected void setMuutja(String muutja) {
			this.muutja = muutja;
		}
		protected String getSulgeja() {
			return sulgeja;
		}
		protected void setSulgeja(String sulgeja) {
			this.sulgeja = sulgeja;
		}
		protected Date getAvatud() {
			return avatud;
		}
		protected void setAvatud(Date avatud) {
			this.avatud = avatud;
		}
		protected Date getMuudetud() {
			return muudetud;
		}
		protected void setMuudetud(Date muudetud) {
			this.muudetud = muudetud;
		}
		protected Date getSuletud() {
			return suletud;
		}
		protected void setSuletud(Date suletud) {
			this.suletud = suletud;
		}

	

	}

	
	
	

