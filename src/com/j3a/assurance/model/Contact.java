package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contact generated by hbm2java
 */
@Entity
@Table(name = "contact", catalog = "zeusbd")
public class Contact implements java.io.Serializable {

	private String idContact;
	private Personne personne;
	private String adresseGeo;
	private String adresse;
	private String telephone;
	private String fax;
	private String email;
	private Date dateContact;

	public Contact() {
	}

	public Contact(String idContact, Personne personne) {
		this.idContact = idContact;
		this.personne = personne;
	}

	public Contact(String idContact, Personne personne, String adresseGeo,
			String adresse, String telephone, String fax, String email,
			Date dateContact) {
		this.idContact = idContact;
		this.personne = personne;
		this.adresseGeo = adresseGeo;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.dateContact = dateContact;
	}

	@Id
	@Column(name = "ID_CONTACT", unique = true, nullable = false, length = 15)
	public String getIdContact() {
		return this.idContact;
	}

	public void setIdContact(String idContact) {
		this.idContact = idContact;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_SOUSCRIPTEUR", nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "ADRESSE_GEO", length = 75)
	public String getAdresseGeo() {
		return this.adresseGeo;
	}

	public void setAdresseGeo(String adresseGeo) {
		this.adresseGeo = adresseGeo;
	}

	@Column(name = "ADRESSE", length = 60)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "TELEPHONE", length = 16)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "FAX", length = 16)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "EMAIL", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CONTACT", length = 19)
	public Date getDateContact() {
		return this.dateContact;
	}

	public void setDateContact(Date dateContact) {
		this.dateContact = dateContact;
	}

}
