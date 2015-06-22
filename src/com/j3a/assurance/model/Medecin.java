package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Medecin generated by hbm2java
 */
@Entity
@Table(name = "medecin", catalog = "zeusbd")
public class Medecin implements java.io.Serializable {

	private String codeMedecin;
	private String raisonSociale;
	private String nom;
	private String prenom;
	private String adresse;
	private String telFixe;
	private String telCell;
	private String email;
	private Set<ActeMedical> acteMedicals = new HashSet<ActeMedical>(0);

	public Medecin() {
	}

	public Medecin(String codeMedecin) {
		this.codeMedecin = codeMedecin;
	}

	public Medecin(String codeMedecin, String raisonSociale, String nom,
			String prenom, String adresse, String telFixe, String telCell,
			String email, Set<ActeMedical> acteMedicals) {
		this.codeMedecin = codeMedecin;
		this.raisonSociale = raisonSociale;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telFixe = telFixe;
		this.telCell = telCell;
		this.email = email;
		this.acteMedicals = acteMedicals;
	}

	@Id
	@Column(name = "CODE_MEDECIN", unique = true, nullable = false, length = 10)
	public String getCodeMedecin() {
		return this.codeMedecin;
	}

	public void setCodeMedecin(String codeMedecin) {
		this.codeMedecin = codeMedecin;
	}

	@Column(name = "RAISON_SOCIALE", length = 50)
	public String getRaisonSociale() {
		return this.raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	@Column(name = "NOM", length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", length = 100)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medecin")
	public Set<ActeMedical> getActeMedicals() {
		return this.acteMedicals;
	}

	public void setActeMedicals(Set<ActeMedical> acteMedicals) {
		this.acteMedicals = acteMedicals;
	}

}
