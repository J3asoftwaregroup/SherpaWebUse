package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypePersonne generated by hbm2java
 */
@Entity
@Table(name = "type_personne", catalog = "zeusbd")
public class TypePersonne implements java.io.Serializable {

	private int codeTypePers;
	private String libelleTypePers;
	private Set<Etre> etres = new HashSet<Etre>(0);

	public TypePersonne() {
	}

	public TypePersonne(int codeTypePers) {
		this.codeTypePers = codeTypePers;
	}

	public TypePersonne(int codeTypePers, String libelleTypePers,
			Set<Etre> etres) {
		this.codeTypePers = codeTypePers;
		this.libelleTypePers = libelleTypePers;
		this.etres = etres;
	}

	@Id
	@Column(name = "CODE_TYPE_PERS", unique = true, nullable = false)
	public int getCodeTypePers() {
		return this.codeTypePers;
	}

	public void setCodeTypePers(int codeTypePers) {
		this.codeTypePers = codeTypePers;
	}

	@Column(name = "LIBELLE_TYPE_PERS", length = 65535)
	public String getLibelleTypePers() {
		return this.libelleTypePers;
	}

	public void setLibelleTypePers(String libelleTypePers) {
		this.libelleTypePers = libelleTypePers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typePersonne")
	public Set<Etre> getEtres() {
		return this.etres;
	}

	public void setEtres(Set<Etre> etres) {
		this.etres = etres;
	}

}
