package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pays generated by hbm2java
 */
@Entity
@Table(name = "pays", catalog = "zeusbd")
public class Pays implements java.io.Serializable {

	private String codePays;
	private String libellePays;
	private Set<Province> provinces = new HashSet<Province>(0);

	public Pays() {
	}

	public Pays(String codePays) {
		this.codePays = codePays;
	}

	public Pays(String codePays, String libellePays, Set<Province> provinces) {
		this.codePays = codePays;
		this.libellePays = libellePays;
		this.provinces = provinces;
	}

	@Id
	@Column(name = "CODE_PAYS", unique = true, nullable = false, length = 15)
	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	@Column(name = "LIBELLE_PAYS", length = 30)
	public String getLibellePays() {
		return this.libellePays;
	}

	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pays")
	public Set<Province> getProvinces() {
		return this.provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}

}
