package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CategorieCima generated by hbm2java
 */
@Entity
@Table(name = "categorie_cima", catalog = "zeusbd")
public class CategorieCima implements java.io.Serializable {

	private String codecategoriecima;
	private String libellecatecima;
	private Set<Etatc10bCategorie> etatc10bCategories = new HashSet<Etatc10bCategorie>(
			0);
	private Set<Etatc9Categorie> etatc9Categories = new HashSet<Etatc9Categorie>(
			0);
	private Set<Lgc1credit> lgc1credits = new HashSet<Lgc1credit>(0);
	private Set<Etatc10TabA> etatc10TabAs = new HashSet<Etatc10TabA>(0);
	private Set<Etatc10aCategorie> etatc10aCategories = new HashSet<Etatc10aCategorie>(
			0);
	private Set<Lgc1debit> lgc1debits = new HashSet<Lgc1debit>(0);

	public CategorieCima() {
	}

	public CategorieCima(String codecategoriecima) {
		this.codecategoriecima = codecategoriecima;
	}

	public CategorieCima(String codecategoriecima, String libellecatecima,
			Set<Etatc10bCategorie> etatc10bCategories,
			Set<Etatc9Categorie> etatc9Categories, Set<Lgc1credit> lgc1credits,
			Set<Etatc10TabA> etatc10TabAs,
			Set<Etatc10aCategorie> etatc10aCategories, Set<Lgc1debit> lgc1debits) {
		this.codecategoriecima = codecategoriecima;
		this.libellecatecima = libellecatecima;
		this.etatc10bCategories = etatc10bCategories;
		this.etatc9Categories = etatc9Categories;
		this.lgc1credits = lgc1credits;
		this.etatc10TabAs = etatc10TabAs;
		this.etatc10aCategories = etatc10aCategories;
		this.lgc1debits = lgc1debits;
	}

	@Id
	@Column(name = "CODECATEGORIECIMA", unique = true, nullable = false, length = 20)
	public String getCodecategoriecima() {
		return this.codecategoriecima;
	}

	public void setCodecategoriecima(String codecategoriecima) {
		this.codecategoriecima = codecategoriecima;
	}

	@Column(name = "LIBELLECATECIMA", length = 100)
	public String getLibellecatecima() {
		return this.libellecatecima;
	}

	public void setLibellecatecima(String libellecatecima) {
		this.libellecatecima = libellecatecima;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Etatc10bCategorie> getEtatc10bCategories() {
		return this.etatc10bCategories;
	}

	public void setEtatc10bCategories(Set<Etatc10bCategorie> etatc10bCategories) {
		this.etatc10bCategories = etatc10bCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Etatc9Categorie> getEtatc9Categories() {
		return this.etatc9Categories;
	}

	public void setEtatc9Categories(Set<Etatc9Categorie> etatc9Categories) {
		this.etatc9Categories = etatc9Categories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Lgc1credit> getLgc1credits() {
		return this.lgc1credits;
	}

	public void setLgc1credits(Set<Lgc1credit> lgc1credits) {
		this.lgc1credits = lgc1credits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Etatc10TabA> getEtatc10TabAs() {
		return this.etatc10TabAs;
	}

	public void setEtatc10TabAs(Set<Etatc10TabA> etatc10TabAs) {
		this.etatc10TabAs = etatc10TabAs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Etatc10aCategorie> getEtatc10aCategories() {
		return this.etatc10aCategories;
	}

	public void setEtatc10aCategories(Set<Etatc10aCategorie> etatc10aCategories) {
		this.etatc10aCategories = etatc10aCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorieCima")
	public Set<Lgc1debit> getLgc1debits() {
		return this.lgc1debits;
	}

	public void setLgc1debits(Set<Lgc1debit> lgc1debits) {
		this.lgc1debits = lgc1debits;
	}

}
