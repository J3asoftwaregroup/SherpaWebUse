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
 * Risque generated by hbm2java
 */
@Entity
@Table(name = "risque", catalog = "zeusbd")
public class Risque implements java.io.Serializable {

	private String codeRisque;
	private String libelleRisque;
	private Set<Garantie> garanties = new HashSet<Garantie>(0);
	private Set<Categorie> categories = new HashSet<Categorie>(0);
	private Set<Contrat> contrats = new HashSet<Contrat>(0);

	public Risque() {
	}

	public Risque(String codeRisque) {
		this.codeRisque = codeRisque;
	}

	public Risque(String codeRisque, String libelleRisque,
			Set<Garantie> garanties, Set<Categorie> categories,
			Set<Contrat> contrats) {
		this.codeRisque = codeRisque;
		this.libelleRisque = libelleRisque;
		this.garanties = garanties;
		this.categories = categories;
		this.contrats = contrats;
	}

	@Id
	@Column(name = "CODE_RISQUE", unique = true, nullable = false, length = 12)
	public String getCodeRisque() {
		return this.codeRisque;
	}

	public void setCodeRisque(String codeRisque) {
		this.codeRisque = codeRisque;
	}

	@Column(name = "LIBELLE_RISQUE", length = 50)
	public String getLibelleRisque() {
		return this.libelleRisque;
	}

	public void setLibelleRisque(String libelleRisque) {
		this.libelleRisque = libelleRisque;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "risque")
	public Set<Garantie> getGaranties() {
		return this.garanties;
	}

	public void setGaranties(Set<Garantie> garanties) {
		this.garanties = garanties;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "risque")
	public Set<Categorie> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "risque")
	public Set<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}

}
