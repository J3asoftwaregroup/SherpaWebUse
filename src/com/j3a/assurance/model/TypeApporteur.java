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
 * TypeApporteur generated by hbm2java
 */
@Entity
@Table(name = "type_apporteur", catalog = "zeusbd")
public class TypeApporteur implements java.io.Serializable {

	private String idType;
	private String libelle;
	private Set<Apporteur> apporteurs = new HashSet<Apporteur>(0);
	private Set<TypeApporteurCategorie> typeApporteurCategories = new HashSet<TypeApporteurCategorie>(
			0);

	public TypeApporteur() {
	}

	public TypeApporteur(String idType) {
		this.idType = idType;
	}

	public TypeApporteur(String idType, String libelle,
			Set<Apporteur> apporteurs,
			Set<TypeApporteurCategorie> typeApporteurCategories) {
		this.idType = idType;
		this.libelle = libelle;
		this.apporteurs = apporteurs;
		this.typeApporteurCategories = typeApporteurCategories;
	}

	@Id
	@Column(name = "ID_TYPE", unique = true, nullable = false, length = 10)
	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Column(name = "LIBELLE", length = 50)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeApporteur")
	public Set<Apporteur> getApporteurs() {
		return this.apporteurs;
	}

	public void setApporteurs(Set<Apporteur> apporteurs) {
		this.apporteurs = apporteurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeApporteur")
	public Set<TypeApporteurCategorie> getTypeApporteurCategories() {
		return this.typeApporteurCategories;
	}

	public void setTypeApporteurCategories(
			Set<TypeApporteurCategorie> typeApporteurCategories) {
		this.typeApporteurCategories = typeApporteurCategories;
	}

}
