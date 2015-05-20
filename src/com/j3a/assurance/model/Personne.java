package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personne generated by hbm2java
 */
@Entity
@Table(name = "personne", catalog = "zeusbd")
public class Personne implements java.io.Serializable {

	private String numSouscripteur;
	private Date datePers;
	private String nomRaisonSociale;
	private String adresseGeo;
	private String adresse;
	private String telephone;
	private String fax;
	private String email;
	private String loginPers;
	private String motPassePers;
	private Set<Contrat> contrats = new HashSet<Contrat>(0);
	private Physique physique;
	private Set<Contact> contacts = new HashSet<Contact>(0);
	private Set<Etre> etres = new HashSet<Etre>(0);
	private Morale morale;
	private Set<PersonneNationalite> personneNationalites = new HashSet<PersonneNationalite>(
			0);

	public Personne() {
	}

	public Personne(String numSouscripteur) {
		this.numSouscripteur = numSouscripteur;
	}

	public Personne(String numSouscripteur, Date datePers,
			String nomRaisonSociale, String adresseGeo, String adresse,
			String telephone, String fax, String email,String loginPers,String motPassePers, Set<Contrat> contrats,
			Physique physique, Set<Contact> contacts, Set<Etre> etres,
			Morale morale, Set<PersonneNationalite> personneNationalites) {
		this.numSouscripteur = numSouscripteur;
		this.datePers = datePers;
		this.nomRaisonSociale = nomRaisonSociale;
		this.adresseGeo = adresseGeo;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.contrats = contrats;
		this.physique = physique;
		this.contacts = contacts;
		this.etres = etres;
		this.morale = morale;
		this.personneNationalites = personneNationalites;
		this.loginPers = loginPers;
		this.motPassePers = motPassePers;
		
	}

	@Id
	@Column(name = "NUM_SOUSCRIPTEUR", unique = true, nullable = false, length = 15)
	public String getNumSouscripteur() {
		return this.numSouscripteur;
	}

	public void setNumSouscripteur(String numSouscripteur) {
		this.numSouscripteur = numSouscripteur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PERS", length = 10)
	public Date getDatePers() {
		return this.datePers;
	}

	public void setDatePers(Date datePers) {
		this.datePers = datePers;
	}

	@Column(name = "NOM_RAISON_SOCIALE", length = 50)
	public String getNomRaisonSociale() {
		return this.nomRaisonSociale;
	}

	public void setNomRaisonSociale(String nomRaisonSociale) {
		this.nomRaisonSociale = nomRaisonSociale;
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
	
	@Column(name = "LOGIN_PERS", length = 20)
	public String getLoginPers() {
		return loginPers;
	}

	public void setLoginPers(String loginPers) {
		this.loginPers = loginPers;
	}
	
	@Column(name = "MOT_PASSE_PERS", length = 10)
	public String getMotPassePers() {
		return motPassePers;
	}

	public void setMotPassePers(String motPassePers) {
		this.motPassePers = motPassePers;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne")
	public Physique getPhysique() {
		return this.physique;
	}

	public void setPhysique(Physique physique) {
		this.physique = physique;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Etre> getEtres() {
		return this.etres;
	}

	public void setEtres(Set<Etre> etres) {
		this.etres = etres;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne")
	public Morale getMorale() {
		return this.morale;
	}

	public void setMorale(Morale morale) {
		this.morale = morale;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<PersonneNationalite> getPersonneNationalites() {
		return this.personneNationalites;
	}

	public void setPersonneNationalites(
			Set<PersonneNationalite> personneNationalites) {
		this.personneNationalites = personneNationalites;
	}

	
}
