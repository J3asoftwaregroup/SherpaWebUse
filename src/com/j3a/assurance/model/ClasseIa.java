package com.j3a.assurance.model;

// Generated 15 juin 2015 17:23:41 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClasseIa generated by hbm2java
 */
@Entity
@Table(name = "classe_ia", catalog = "zeusbd")
public class ClasseIa implements java.io.Serializable {

	private String codeClasseIa;
	private String libelleClasseIa;
	private String natureClasseIa;
	private String tarifClasseIa;
	private Set<AssureIa> assureIas = new HashSet<AssureIa>(0);

	public ClasseIa() {
	}

	public ClasseIa(String codeClasseIa) {
		this.codeClasseIa = codeClasseIa;
	}

	public ClasseIa(String codeClasseIa, String libelleClasseIa,
			String natureClasseIa, String tarifClasseIa, Set<AssureIa> assureIas) {
		this.codeClasseIa = codeClasseIa;
		this.libelleClasseIa = libelleClasseIa;
		this.natureClasseIa = natureClasseIa;
		this.tarifClasseIa = tarifClasseIa;
		this.assureIas = assureIas;
	}

	@Id
	@Column(name = "CODE_CLASSE_IA", unique = true, nullable = false, length = 50)
	public String getCodeClasseIa() {
		return this.codeClasseIa;
	}

	public void setCodeClasseIa(String codeClasseIa) {
		this.codeClasseIa = codeClasseIa;
	}

	@Column(name = "LIBELLE_CLASSE_IA", length = 100)
	public String getLibelleClasseIa() {
		return this.libelleClasseIa;
	}

	public void setLibelleClasseIa(String libelleClasseIa) {
		this.libelleClasseIa = libelleClasseIa;
	}

	@Column(name = "NATURE_CLASSE_IA", length = 100)
	public String getNatureClasseIa() {
		return this.natureClasseIa;
	}

	public void setNatureClasseIa(String natureClasseIa) {
		this.natureClasseIa = natureClasseIa;
	}

	@Column(name = "TARIF_CLASSE_IA", length = 50)
	public String getTarifClasseIa() {
		return this.tarifClasseIa;
	}

	public void setTarifClasseIa(String tarifClasseIa) {
		this.tarifClasseIa = tarifClasseIa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classeIa")
	public Set<AssureIa> getAssureIas() {
		return this.assureIas;
	}

	public void setAssureIas(Set<AssureIa> assureIas) {
		this.assureIas = assureIas;
	}

}
