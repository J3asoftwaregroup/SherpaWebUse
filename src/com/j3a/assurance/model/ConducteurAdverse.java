package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

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
 * ConducteurAdverse generated by hbm2java
 */
@Entity
@Table(name = "conducteur_adverse", catalog = "zeusbd")
public class ConducteurAdverse implements java.io.Serializable {

	private String codeConducteurAdverse;
	private String nom;
	private String prenom;
	private String numPermis;
	private String categoriePermis;
	private Date validitePermis;
	private String immatriculation;
	private String marque;
	private String typeDuvehicule;
	private String adresse;
	private String telFixe;
	private String telCell;
	private String email;
	private Set<PartieAdverse> partieAdverses = new HashSet<PartieAdverse>(0);

	public ConducteurAdverse() {
	}

	public ConducteurAdverse(String codeConducteurAdverse) {
		this.codeConducteurAdverse = codeConducteurAdverse;
	}

	public ConducteurAdverse(String codeConducteurAdverse, String nom,
			String prenom, String numPermis, String categoriePermis,
			Date validitePermis, String immatriculation, String marque,
			String typeDuvehicule, String adresse, String telFixe,
			String telCell, String email, Set<PartieAdverse> partieAdverses) {
		this.codeConducteurAdverse = codeConducteurAdverse;
		this.nom = nom;
		this.prenom = prenom;
		this.numPermis = numPermis;
		this.categoriePermis = categoriePermis;
		this.validitePermis = validitePermis;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeDuvehicule = typeDuvehicule;
		this.adresse = adresse;
		this.telFixe = telFixe;
		this.telCell = telCell;
		this.email = email;
		this.partieAdverses = partieAdverses;
	}

	@Id
	@Column(name = "CODE_CONDUCTEUR_ADVERSE", unique = true, nullable = false, length = 30)
	public String getCodeConducteurAdverse() {
		return this.codeConducteurAdverse;
	}

	public void setCodeConducteurAdverse(String codeConducteurAdverse) {
		this.codeConducteurAdverse = codeConducteurAdverse;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDITE_PERMIS", length = 10)
	public Date getValiditePermis() {
		return this.validitePermis;
	}

	public void setValiditePermis(Date validitePermis) {
		this.validitePermis = validitePermis;
	}

	@Column(name = "IMMATRICULATION", length = 15)
	public String getImmatriculation() {
		return this.immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Column(name = "MARQUE", length = 40)
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Column(name = "TYPE_DUVEHICULE", length = 100)
	public String getTypeDuvehicule() {
		return this.typeDuvehicule;
	}

	public void setTypeDuvehicule(String typeDuvehicule) {
		this.typeDuvehicule = typeDuvehicule;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conducteurAdverse")
	public Set<PartieAdverse> getPartieAdverses() {
		return this.partieAdverses;
	}

	public void setPartieAdverses(Set<PartieAdverse> partieAdverses) {
		this.partieAdverses = partieAdverses;
	}

}
