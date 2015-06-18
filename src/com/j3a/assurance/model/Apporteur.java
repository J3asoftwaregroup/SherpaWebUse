package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Apporteur generated by hbm2java
 */
@Entity
@Table(name = "apporteur", catalog = "zeusbd")
public class Apporteur implements java.io.Serializable {

	private String codeApporteur;
	private CompteApporteur compteApporteur;
	private TypeApporteur typeApporteur;
	private String libelleApporteur;
	private String contactApporteur;
	private String adresseApporteur;
	private Date dateCrea;
	private Set<ApporteurAssure> apporteurAssures = new HashSet<ApporteurAssure>(
			0);
	private Set<ApporteurCorpsEngin> apporteurCorpsEngins = new HashSet<ApporteurCorpsEngin>(
			0);
	private Set<Contrat> contrats = new HashSet<Contrat>(0);
	private Set<ApporteurHabitation> apporteurHabitations = new HashSet<ApporteurHabitation>(
			0);
	private Set<ApporteurGestionConfiee> apporteurGestionConfiees = new HashSet<ApporteurGestionConfiee>(
			0);
	private Set<ApporteurVehicule> apporteurVehicules = new HashSet<ApporteurVehicule>(
			0);
	private Set<CompteApporteur> compteApporteurs = new HashSet<CompteApporteur>(
			0);
	private Set<ApporteurAdherent> apporteurAdherents = new HashSet<ApporteurAdherent>(
			0);
	private Set<ApporteurAliment> apporteurAliments = new HashSet<ApporteurAliment>(
			0);
	private Set<AffaireApporteur> affaireApporteurs = new HashSet<AffaireApporteur>(
			0);
	private Set<ApporteurNta> apporteurNtas = new HashSet<ApporteurNta>(0);

	public Apporteur() {
	}

	public Apporteur(String codeApporteur, TypeApporteur typeApporteur) {
		this.codeApporteur = codeApporteur;
		this.typeApporteur = typeApporteur;
	}

	public Apporteur(String codeApporteur, CompteApporteur compteApporteur,
			TypeApporteur typeApporteur, String libelleApporteur,
			String contactApporteur, String adresseApporteur, Date dateCrea,
			Set<ApporteurAssure> apporteurAssures,
			Set<ApporteurCorpsEngin> apporteurCorpsEngins,
			Set<Contrat> contrats,
			Set<ApporteurHabitation> apporteurHabitations,
			Set<ApporteurGestionConfiee> apporteurGestionConfiees,
			Set<ApporteurVehicule> apporteurVehicules,
			Set<CompteApporteur> compteApporteurs,
			Set<ApporteurAdherent> apporteurAdherents,
			Set<ApporteurAliment> apporteurAliments,
			Set<AffaireApporteur> affaireApporteurs,
			Set<ApporteurNta> apporteurNtas) {
		this.codeApporteur = codeApporteur;
		this.compteApporteur = compteApporteur;
		this.typeApporteur = typeApporteur;
		this.libelleApporteur = libelleApporteur;
		this.contactApporteur = contactApporteur;
		this.adresseApporteur = adresseApporteur;
		this.dateCrea = dateCrea;
		this.apporteurAssures = apporteurAssures;
		this.apporteurCorpsEngins = apporteurCorpsEngins;
		this.contrats = contrats;
		this.apporteurHabitations = apporteurHabitations;
		this.apporteurGestionConfiees = apporteurGestionConfiees;
		this.apporteurVehicules = apporteurVehicules;
		this.compteApporteurs = compteApporteurs;
		this.apporteurAdherents = apporteurAdherents;
		this.apporteurAliments = apporteurAliments;
		this.affaireApporteurs = affaireApporteurs;
		this.apporteurNtas = apporteurNtas;
	}

	@Id
	@Column(name = "CODE_APPORTEUR", unique = true, nullable = false, length = 10)
	public String getCodeApporteur() {
		return this.codeApporteur;
	}

	public void setCodeApporteur(String codeApporteur) {
		this.codeApporteur = codeApporteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_COMPTE_APP")
	public CompteApporteur getCompteApporteur() {
		return this.compteApporteur;
	}

	public void setCompteApporteur(CompteApporteur compteApporteur) {
		this.compteApporteur = compteApporteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TYPE", nullable = false)
	public TypeApporteur getTypeApporteur() {
		return this.typeApporteur;
	}

	public void setTypeApporteur(TypeApporteur typeApporteur) {
		this.typeApporteur = typeApporteur;
	}

	@Column(name = "LIBELLE_APPORTEUR", length = 100)
	public String getLibelleApporteur() {
		return this.libelleApporteur;
	}

	public void setLibelleApporteur(String libelleApporteur) {
		this.libelleApporteur = libelleApporteur;
	}

	@Column(name = "CONTACT_APPORTEUR", length = 16)
	public String getContactApporteur() {
		return this.contactApporteur;
	}

	public void setContactApporteur(String contactApporteur) {
		this.contactApporteur = contactApporteur;
	}

	@Column(name = "ADRESSE_APPORTEUR", length = 50)
	public String getAdresseApporteur() {
		return this.adresseApporteur;
	}

	public void setAdresseApporteur(String adresseApporteur) {
		this.adresseApporteur = adresseApporteur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREA", length = 10)
	public Date getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurAssure> getApporteurAssures() {
		return this.apporteurAssures;
	}

	public void setApporteurAssures(Set<ApporteurAssure> apporteurAssures) {
		this.apporteurAssures = apporteurAssures;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurCorpsEngin> getApporteurCorpsEngins() {
		return this.apporteurCorpsEngins;
	}

	public void setApporteurCorpsEngins(
			Set<ApporteurCorpsEngin> apporteurCorpsEngins) {
		this.apporteurCorpsEngins = apporteurCorpsEngins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurHabitation> getApporteurHabitations() {
		return this.apporteurHabitations;
	}

	public void setApporteurHabitations(
			Set<ApporteurHabitation> apporteurHabitations) {
		this.apporteurHabitations = apporteurHabitations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurGestionConfiee> getApporteurGestionConfiees() {
		return this.apporteurGestionConfiees;
	}

	public void setApporteurGestionConfiees(
			Set<ApporteurGestionConfiee> apporteurGestionConfiees) {
		this.apporteurGestionConfiees = apporteurGestionConfiees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurVehicule> getApporteurVehicules() {
		return this.apporteurVehicules;
	}

	public void setApporteurVehicules(Set<ApporteurVehicule> apporteurVehicules) {
		this.apporteurVehicules = apporteurVehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<CompteApporteur> getCompteApporteurs() {
		return this.compteApporteurs;
	}

	public void setCompteApporteurs(Set<CompteApporteur> compteApporteurs) {
		this.compteApporteurs = compteApporteurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurAdherent> getApporteurAdherents() {
		return this.apporteurAdherents;
	}

	public void setApporteurAdherents(Set<ApporteurAdherent> apporteurAdherents) {
		this.apporteurAdherents = apporteurAdherents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurAliment> getApporteurAliments() {
		return this.apporteurAliments;
	}

	public void setApporteurAliments(Set<ApporteurAliment> apporteurAliments) {
		this.apporteurAliments = apporteurAliments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<AffaireApporteur> getAffaireApporteurs() {
		return this.affaireApporteurs;
	}

	public void setAffaireApporteurs(Set<AffaireApporteur> affaireApporteurs) {
		this.affaireApporteurs = affaireApporteurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apporteur")
	public Set<ApporteurNta> getApporteurNtas() {
		return this.apporteurNtas;
	}

	public void setApporteurNtas(Set<ApporteurNta> apporteurNtas) {
		this.apporteurNtas = apporteurNtas;
	}

}
