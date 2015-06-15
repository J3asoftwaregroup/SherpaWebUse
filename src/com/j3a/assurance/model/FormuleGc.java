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
 * FormuleGc generated by hbm2java
 */
@Entity
@Table(name = "formule_gc", catalog = "zeusbd")
public class FormuleGc implements java.io.Serializable {

	private String codeFormuleGc;
	private String libelleFormuleGc;
	private String couvertureFormule;
	private Set<GarantieFormuleGc> garantieFormuleGcs = new HashSet<GarantieFormuleGc>(
			0);
	private Set<GestionConfieFormule> gestionConfieFormules = new HashSet<GestionConfieFormule>(
			0);

	public FormuleGc() {
	}

	public FormuleGc(String codeFormuleGc) {
		this.codeFormuleGc = codeFormuleGc;
	}

	public FormuleGc(String codeFormuleGc, String libelleFormuleGc,
			String couvertureFormule,
			Set<GarantieFormuleGc> garantieFormuleGcs,
			Set<GestionConfieFormule> gestionConfieFormules) {
		this.codeFormuleGc = codeFormuleGc;
		this.libelleFormuleGc = libelleFormuleGc;
		this.couvertureFormule = couvertureFormule;
		this.garantieFormuleGcs = garantieFormuleGcs;
		this.gestionConfieFormules = gestionConfieFormules;
	}

	@Id
	@Column(name = "CODE_FORMULE_GC", unique = true, nullable = false, length = 60)
	public String getCodeFormuleGc() {
		return this.codeFormuleGc;
	}

	public void setCodeFormuleGc(String codeFormuleGc) {
		this.codeFormuleGc = codeFormuleGc;
	}

	@Column(name = "LIBELLE_FORMULE_GC", length = 200)
	public String getLibelleFormuleGc() {
		return this.libelleFormuleGc;
	}

	public void setLibelleFormuleGc(String libelleFormuleGc) {
		this.libelleFormuleGc = libelleFormuleGc;
	}

	@Column(name = "COUVERTURE_FORMULE", length = 10)
	public String getCouvertureFormule() {
		return this.couvertureFormule;
	}

	public void setCouvertureFormule(String couvertureFormule) {
		this.couvertureFormule = couvertureFormule;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formuleGc")
	public Set<GarantieFormuleGc> getGarantieFormuleGcs() {
		return this.garantieFormuleGcs;
	}

	public void setGarantieFormuleGcs(Set<GarantieFormuleGc> garantieFormuleGcs) {
		this.garantieFormuleGcs = garantieFormuleGcs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formuleGc")
	public Set<GestionConfieFormule> getGestionConfieFormules() {
		return this.gestionConfieFormules;
	}

	public void setGestionConfieFormules(
			Set<GestionConfieFormule> gestionConfieFormules) {
		this.gestionConfieFormules = gestionConfieFormules;
	}

}
