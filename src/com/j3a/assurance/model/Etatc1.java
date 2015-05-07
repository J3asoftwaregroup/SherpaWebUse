package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Etatc1 generated by hbm2java
 */
@Entity
@Table(name = "etatc1", catalog = "zeusbd")
public class Etatc1 implements java.io.Serializable {

	private String idetatc1;
	private EtatCima etatCima;
	private String libelle;
	private Short annee;
	private Set<Lgc1debit> lgc1debits = new HashSet<Lgc1debit>(0);
	private Set<Lgc1credit> lgc1credits = new HashSet<Lgc1credit>(0);

	public Etatc1() {
	}

	public Etatc1(String idetatc1) {
		this.idetatc1 = idetatc1;
	}

	public Etatc1(String idetatc1, EtatCima etatCima, String libelle,
			Short annee, Set<Lgc1debit> lgc1debits, Set<Lgc1credit> lgc1credits) {
		this.idetatc1 = idetatc1;
		this.etatCima = etatCima;
		this.libelle = libelle;
		this.annee = annee;
		this.lgc1debits = lgc1debits;
		this.lgc1credits = lgc1credits;
	}

	@Id
	@Column(name = "IDETATC1", unique = true, nullable = false)
	public String getIdetatc1() {
		return this.idetatc1;
	}

	public void setIdetatc1(String idetatc1) {
		this.idetatc1 = idetatc1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_CIMA")
	public EtatCima getEtatCima() {
		return this.etatCima;
	}

	public void setEtatCima(EtatCima etatCima) {
		this.etatCima = etatCima;
	}

	@Column(name = "LIBELLE", length = 75)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "ANNEE")
	public Short getAnnee() {
		return this.annee;
	}

	public void setAnnee(Short annee) {
		this.annee = annee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatc1")
	public Set<Lgc1debit> getLgc1debits() {
		return this.lgc1debits;
	}

	public void setLgc1debits(Set<Lgc1debit> lgc1debits) {
		this.lgc1debits = lgc1debits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatc1")
	public Set<Lgc1credit> getLgc1credits() {
		return this.lgc1credits;
	}

	public void setLgc1credits(Set<Lgc1credit> lgc1credits) {
		this.lgc1credits = lgc1credits;
	}

}
