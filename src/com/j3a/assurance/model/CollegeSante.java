package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CollegeSante generated by hbm2java
 */
@Entity
@Table(name = "college_sante", catalog = "zeusbd")
public class CollegeSante implements java.io.Serializable {

	private String codeCollege;
	private String libelleCollege;
	private String tarifSante;
	private Set<AdherentsSante> adherentsSantes = new HashSet<AdherentsSante>(0);
	private Set<GestionConfiee> gestionConfiees = new HashSet<GestionConfiee>(0);

	public CollegeSante() {
	}

	public CollegeSante(String codeCollege) {
		this.codeCollege = codeCollege;
	}

	public CollegeSante(String codeCollege, String libelleCollege,
			String tarifSante, Set<AdherentsSante> adherentsSantes,
			Set<GestionConfiee> gestionConfiees) {
		this.codeCollege = codeCollege;
		this.libelleCollege = libelleCollege;
		this.tarifSante = tarifSante;
		this.adherentsSantes = adherentsSantes;
		this.gestionConfiees = gestionConfiees;
	}

	@Id
	@Column(name = "CODE_COLLEGE", unique = true, nullable = false, length = 50)
	public String getCodeCollege() {
		return this.codeCollege;
	}

	public void setCodeCollege(String codeCollege) {
		this.codeCollege = codeCollege;
	}

	@Column(name = "LIBELLE_COLLEGE", length = 60)
	public String getLibelleCollege() {
		return this.libelleCollege;
	}

	public void setLibelleCollege(String libelleCollege) {
		this.libelleCollege = libelleCollege;
	}

	@Column(name = "TARIF_SANTE", length = 60)
	public String getTarifSante() {
		return this.tarifSante;
	}

	public void setTarifSante(String tarifSante) {
		this.tarifSante = tarifSante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collegeSante")
	public Set<AdherentsSante> getAdherentsSantes() {
		return this.adherentsSantes;
	}

	public void setAdherentsSantes(Set<AdherentsSante> adherentsSantes) {
		this.adherentsSantes = adherentsSantes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collegeSante")
	public Set<GestionConfiee> getGestionConfiees() {
		return this.gestionConfiees;
	}

	public void setGestionConfiees(Set<GestionConfiee> gestionConfiees) {
		this.gestionConfiees = gestionConfiees;
	}

}
