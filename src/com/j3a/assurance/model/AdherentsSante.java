package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

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
 * AdherentsSante generated by hbm2java
 */
@Entity
@Table(name = "adherents_sante", catalog = "zeusbd")
public class AdherentsSante implements java.io.Serializable {

	private String codeAdherent;
	private Categorie categorie;
	private CollegeSante collegeSante;
	private String nomAdherent;
	private String prenomAdherent;
	private String sexeAdherent;
	private String adresseAdherent;
	private Date naissAdherent;
	private String localisationAdherent;
	private String statutadhsante;
	private Set<ApporteurAdherent> apporteurAdherents = new HashSet<ApporteurAdherent>(
			0);
	private Set<ListeAffilie> listeAffilies = new HashSet<ListeAffilie>(0);
	private Set<ListeAdherentSante> listeAdherentSantes = new HashSet<ListeAdherentSante>(
			0);

	public AdherentsSante() {
	}

	public AdherentsSante(String codeAdherent, CollegeSante collegeSante) {
		this.codeAdherent = codeAdherent;
		this.collegeSante = collegeSante;
	}

	public AdherentsSante(String codeAdherent, Categorie categorie,
			CollegeSante collegeSante, String nomAdherent,
			String prenomAdherent, String sexeAdherent, String adresseAdherent,
			Date naissAdherent, String localisationAdherent,
			String statutadhsante, Set<ApporteurAdherent> apporteurAdherents,
			Set<ListeAffilie> listeAffilies,
			Set<ListeAdherentSante> listeAdherentSantes) {
		this.codeAdherent = codeAdherent;
		this.categorie = categorie;
		this.collegeSante = collegeSante;
		this.nomAdherent = nomAdherent;
		this.prenomAdherent = prenomAdherent;
		this.sexeAdherent = sexeAdherent;
		this.adresseAdherent = adresseAdherent;
		this.naissAdherent = naissAdherent;
		this.localisationAdherent = localisationAdherent;
		this.statutadhsante = statutadhsante;
		this.apporteurAdherents = apporteurAdherents;
		this.listeAffilies = listeAffilies;
		this.listeAdherentSantes = listeAdherentSantes;
	}

	@Id
	@Column(name = "CODE_ADHERENT", unique = true, nullable = false, length = 60)
	public String getCodeAdherent() {
		return this.codeAdherent;
	}

	public void setCodeAdherent(String codeAdherent) {
		this.codeAdherent = codeAdherent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CATEGORIE")
	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_COLLEGE", nullable = false)
	public CollegeSante getCollegeSante() {
		return this.collegeSante;
	}

	public void setCollegeSante(CollegeSante collegeSante) {
		this.collegeSante = collegeSante;
	}

	@Column(name = "NOM_ADHERENT", length = 60)
	public String getNomAdherent() {
		return this.nomAdherent;
	}

	public void setNomAdherent(String nomAdherent) {
		this.nomAdherent = nomAdherent;
	}

	@Column(name = "PRENOM_ADHERENT", length = 80)
	public String getPrenomAdherent() {
		return this.prenomAdherent;
	}

	public void setPrenomAdherent(String prenomAdherent) {
		this.prenomAdherent = prenomAdherent;
	}

	@Column(name = "SEXE_ADHERENT", length = 9)
	public String getSexeAdherent() {
		return this.sexeAdherent;
	}

	public void setSexeAdherent(String sexeAdherent) {
		this.sexeAdherent = sexeAdherent;
	}

	@Column(name = "ADRESSE_ADHERENT", length = 80)
	public String getAdresseAdherent() {
		return this.adresseAdherent;
	}

	public void setAdresseAdherent(String adresseAdherent) {
		this.adresseAdherent = adresseAdherent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NAISS_ADHERENT", length = 10)
	public Date getNaissAdherent() {
		return this.naissAdherent;
	}

	public void setNaissAdherent(Date naissAdherent) {
		this.naissAdherent = naissAdherent;
	}

	@Column(name = "LOCALISATION_ADHERENT", length = 60)
	public String getLocalisationAdherent() {
		return this.localisationAdherent;
	}

	public void setLocalisationAdherent(String localisationAdherent) {
		this.localisationAdherent = localisationAdherent;
	}

	@Column(name = "STATUTADHSANTE", length = 20)
	public String getStatutadhsante() {
		return this.statutadhsante;
	}

	public void setStatutadhsante(String statutadhsante) {
		this.statutadhsante = statutadhsante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adherentsSante")
	public Set<ApporteurAdherent> getApporteurAdherents() {
		return this.apporteurAdherents;
	}

	public void setApporteurAdherents(Set<ApporteurAdherent> apporteurAdherents) {
		this.apporteurAdherents = apporteurAdherents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adherentsSante")
	public Set<ListeAffilie> getListeAffilies() {
		return this.listeAffilies;
	}

	public void setListeAffilies(Set<ListeAffilie> listeAffilies) {
		this.listeAffilies = listeAffilies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adherentsSante")
	public Set<ListeAdherentSante> getListeAdherentSantes() {
		return this.listeAdherentSantes;
	}

	public void setListeAdherentSantes(
			Set<ListeAdherentSante> listeAdherentSantes) {
		this.listeAdherentSantes = listeAdherentSantes;
	}

}
