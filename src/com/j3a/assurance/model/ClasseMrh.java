package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClasseMrh generated by hbm2java
 */
@Entity
@Table(name = "classe_mrh", catalog = "zeusbd")
public class ClasseMrh implements java.io.Serializable {

	private String codeClasseMrh;
	private String libelleClasseMrh;
	private String natureClasseMrh;
	private String tarifClasseMrh;
	private Set<Habitation> habitations = new HashSet<Habitation>(0);

	public ClasseMrh() {
	}

	public ClasseMrh(String codeClasseMrh) {
		this.codeClasseMrh = codeClasseMrh;
	}

	public ClasseMrh(String codeClasseMrh, String libelleClasseMrh,
			String natureClasseMrh, String tarifClasseMrh,
			Set<Habitation> habitations) {
		this.codeClasseMrh = codeClasseMrh;
		this.libelleClasseMrh = libelleClasseMrh;
		this.natureClasseMrh = natureClasseMrh;
		this.tarifClasseMrh = tarifClasseMrh;
		this.habitations = habitations;
	}

	@Id
	@Column(name = "CODE_CLASSE_MRH", unique = true, nullable = false, length = 30)
	public String getCodeClasseMrh() {
		return this.codeClasseMrh;
	}

	public void setCodeClasseMrh(String codeClasseMrh) {
		this.codeClasseMrh = codeClasseMrh;
	}

	@Column(name = "LIBELLE_CLASSE_MRH", length = 100)
	public String getLibelleClasseMrh() {
		return this.libelleClasseMrh;
	}

	public void setLibelleClasseMrh(String libelleClasseMrh) {
		this.libelleClasseMrh = libelleClasseMrh;
	}

	@Column(name = "NATURE_CLASSE_MRH", length = 100)
	public String getNatureClasseMrh() {
		return this.natureClasseMrh;
	}

	public void setNatureClasseMrh(String natureClasseMrh) {
		this.natureClasseMrh = natureClasseMrh;
	}

	@Column(name = "TARIF_CLASSE_MRH", length = 30)
	public String getTarifClasseMrh() {
		return this.tarifClasseMrh;
	}

	public void setTarifClasseMrh(String tarifClasseMrh) {
		this.tarifClasseMrh = tarifClasseMrh;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classeMrh")
	public Set<Habitation> getHabitations() {
		return this.habitations;
	}

	public void setHabitations(Set<Habitation> habitations) {
		this.habitations = habitations;
	}

}
