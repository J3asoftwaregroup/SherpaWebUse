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
 * Nationalite generated by hbm2java
 */
@Entity
@Table(name = "nationalite", catalog = "zeusbd")
public class Nationalite implements java.io.Serializable {

	private int codeNationalite;
	private String libelleNationalite;
	private Set<PersonneNationalite> personneNationalites = new HashSet<PersonneNationalite>(
			0);

	public Nationalite() {
	}

	public Nationalite(int codeNationalite) {
		this.codeNationalite = codeNationalite;
	}

	public Nationalite(int codeNationalite, String libelleNationalite,
			Set<PersonneNationalite> personneNationalites) {
		this.codeNationalite = codeNationalite;
		this.libelleNationalite = libelleNationalite;
		this.personneNationalites = personneNationalites;
	}

	@Id
	@Column(name = "CODE_NATIONALITE", unique = true, nullable = false)
	public int getCodeNationalite() {
		return this.codeNationalite;
	}

	public void setCodeNationalite(int codeNationalite) {
		this.codeNationalite = codeNationalite;
	}

	@Column(name = "LIBELLE_NATIONALITE", length = 20)
	public String getLibelleNationalite() {
		return this.libelleNationalite;
	}

	public void setLibelleNationalite(String libelleNationalite) {
		this.libelleNationalite = libelleNationalite;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nationalite")
	public Set<PersonneNationalite> getPersonneNationalites() {
		return this.personneNationalites;
	}

	public void setPersonneNationalites(
			Set<PersonneNationalite> personneNationalites) {
		this.personneNationalites = personneNationalites;
	}

}
