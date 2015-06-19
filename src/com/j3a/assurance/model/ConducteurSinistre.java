package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ConducteurSinistre generated by hbm2java
 */
@Entity
@Table(name = "conducteur_sinistre", catalog = "zeusbd")
public class ConducteurSinistre implements java.io.Serializable {

	private String codeConducteurSinistre;
	private String nomCondSinistre;
	private String prenomCondSinistre;
	private Date dateNaissCondSinistre;
	private String numPermis;
	private String categoriePermis;
	private String adresse;
	private String telFixe;
	private String telCell;
	private String email;
	private Set<SinistreConducteur> sinistreConducteurs = new HashSet<SinistreConducteur>(
			0);

	public ConducteurSinistre() {
	}

	public ConducteurSinistre(String codeConducteurSinistre) {
		this.codeConducteurSinistre = codeConducteurSinistre;
	}

	public ConducteurSinistre(String codeConducteurSinistre,
			String nomCondSinistre, String prenomCondSinistre,
			Date dateNaissCondSinistre, String numPermis,
			String categoriePermis, String adresse, String telFixe,
			String telCell, String email,
			Set<SinistreConducteur> sinistreConducteurs) {
		this.codeConducteurSinistre = codeConducteurSinistre;
		this.nomCondSinistre = nomCondSinistre;
		this.prenomCondSinistre = prenomCondSinistre;
		this.dateNaissCondSinistre = dateNaissCondSinistre;
		this.numPermis = numPermis;
		this.categoriePermis = categoriePermis;
		this.adresse = adresse;
		this.telFixe = telFixe;
		this.telCell = telCell;
		this.email = email;
		this.sinistreConducteurs = sinistreConducteurs;
	}

	@Id
	@Column(name = "CODE_CONDUCTEUR_SINISTRE", unique = true, nullable = false, length = 16)
	public String getCodeConducteurSinistre() {
		return this.codeConducteurSinistre;
	}

	public void setCodeConducteurSinistre(String codeConducteurSinistre) {
		this.codeConducteurSinistre = codeConducteurSinistre;
	}

	@Column(name = "NOM_COND_SINISTRE", length = 20)
	public String getNomCondSinistre() {
		return this.nomCondSinistre;
	}

	public void setNomCondSinistre(String nomCondSinistre) {
		this.nomCondSinistre = nomCondSinistre;
	}

	@Column(name = "PRENOM_COND_SINISTRE", length = 60)
	public String getPrenomCondSinistre() {
		return this.prenomCondSinistre;
	}

	public void setPrenomCondSinistre(String prenomCondSinistre) {
		this.prenomCondSinistre = prenomCondSinistre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISS_COND_SINISTRE", length = 10)
	public Date getDateNaissCondSinistre() {
		return this.dateNaissCondSinistre;
	}

	public void setDateNaissCondSinistre(Date dateNaissCondSinistre) {
		this.dateNaissCondSinistre = dateNaissCondSinistre;
	}

	@Column(name = "NUM_PERMIS", length = 10)
	public String getNumPermis() {
		return this.numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	@Column(name = "CATEGORIE_PERMIS", length = 5)
	public String getCategoriePermis() {
		return this.categoriePermis;
	}

	public void setCategoriePermis(String categoriePermis) {
		this.categoriePermis = categoriePermis;
	}

	@Column(name = "ADRESSE", length = 60)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "TEL_FIXE", length = 15)
	public String getTelFixe() {
		return this.telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	@Column(name = "TEL_CELL", length = 15)
	public String getTelCell() {
		return this.telCell;
	}

	public void setTelCell(String telCell) {
		this.telCell = telCell;
	}

	@Column(name = "EMAIL", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteurSinistre")
	public Set<SinistreConducteur> getSinistreConducteurs() {
		return this.sinistreConducteurs;
	}

	public void setSinistreConducteurs(
			Set<SinistreConducteur> sinistreConducteurs) {
		this.sinistreConducteurs = sinistreConducteurs;
	}

}
