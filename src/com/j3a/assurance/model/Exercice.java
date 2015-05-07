package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Exercice generated by hbm2java
 */
@Entity
@Table(name = "exercice", catalog = "zeusbd")
public class Exercice implements java.io.Serializable {

	private int codeexercice;
	private String libelleExercice;
	private BigDecimal chiffreAffExo;
	private BigDecimal primeExercice;
	private BigDecimal primeAReporterExo;
	private BigDecimal precExo;
	private String etatExercice;
	private Set<C10Exercice> c10Exercices = new HashSet<C10Exercice>(0);
	private Set<C9Exercice> c9Exercices = new HashSet<C9Exercice>(0);
	private Set<Avenant> avenants = new HashSet<Avenant>(0);
	private Set<Vente> ventes = new HashSet<Vente>(0);
	private Set<Etatc10tabbExercice> etatc10tabbExercices = new HashSet<Etatc10tabbExercice>(
			0);
	private Set<ModifiCapital> modifiCapitals = new HashSet<ModifiCapital>(0);
	private Set<ObligationEmprunt> obligationEmprunts = new HashSet<ObligationEmprunt>(
			0);
	private Set<Achat> achats = new HashSet<Achat>(0);
	private Set<Etatc10tabaExercice> etatc10tabaExercices = new HashSet<Etatc10tabaExercice>(
			0);
	private Set<Portefeuilles> portefeuilleses = new HashSet<Portefeuilles>(0);

	public Exercice() {
	}

	public Exercice(int codeexercice) {
		this.codeexercice = codeexercice;
	}

	public Exercice(int codeexercice, String libelleExercice,
			BigDecimal chiffreAffExo, BigDecimal primeExercice,
			BigDecimal primeAReporterExo, BigDecimal precExo,
			String etatExercice, Set<C10Exercice> c10Exercices,
			Set<C9Exercice> c9Exercices, Set<Avenant> avenants,
			Set<Vente> ventes, Set<Etatc10tabbExercice> etatc10tabbExercices,
			Set<ModifiCapital> modifiCapitals,
			Set<ObligationEmprunt> obligationEmprunts, Set<Achat> achats,
			Set<Etatc10tabaExercice> etatc10tabaExercices,
			Set<Portefeuilles> portefeuilleses) {
		this.codeexercice = codeexercice;
		this.libelleExercice = libelleExercice;
		this.chiffreAffExo = chiffreAffExo;
		this.primeExercice = primeExercice;
		this.primeAReporterExo = primeAReporterExo;
		this.precExo = precExo;
		this.etatExercice = etatExercice;
		this.c10Exercices = c10Exercices;
		this.c9Exercices = c9Exercices;
		this.avenants = avenants;
		this.ventes = ventes;
		this.etatc10tabbExercices = etatc10tabbExercices;
		this.modifiCapitals = modifiCapitals;
		this.obligationEmprunts = obligationEmprunts;
		this.achats = achats;
		this.etatc10tabaExercices = etatc10tabaExercices;
		this.portefeuilleses = portefeuilleses;
	}

	@Id
	@Column(name = "CODEEXERCICE", unique = true, nullable = false)
	public int getCodeexercice() {
		return this.codeexercice;
	}

	public void setCodeexercice(int codeexercice) {
		this.codeexercice = codeexercice;
	}

	@Column(name = "LIBELLE_EXERCICE", length = 6)
	public String getLibelleExercice() {
		return this.libelleExercice;
	}

	public void setLibelleExercice(String libelleExercice) {
		this.libelleExercice = libelleExercice;
	}

	@Column(name = "CHIFFRE_AFF_EXO")
	public BigDecimal getChiffreAffExo() {
		return this.chiffreAffExo;
	}

	public void setChiffreAffExo(BigDecimal chiffreAffExo) {
		this.chiffreAffExo = chiffreAffExo;
	}

	@Column(name = "PRIME_EXERCICE")
	public BigDecimal getPrimeExercice() {
		return this.primeExercice;
	}

	public void setPrimeExercice(BigDecimal primeExercice) {
		this.primeExercice = primeExercice;
	}

	@Column(name = "PRIME_A_REPORTER_EXO")
	public BigDecimal getPrimeAReporterExo() {
		return this.primeAReporterExo;
	}

	public void setPrimeAReporterExo(BigDecimal primeAReporterExo) {
		this.primeAReporterExo = primeAReporterExo;
	}

	@Column(name = "PREC_EXO")
	public BigDecimal getPrecExo() {
		return this.precExo;
	}

	public void setPrecExo(BigDecimal precExo) {
		this.precExo = precExo;
	}

	@Column(name = "ETAT_EXERCICE", length = 20)
	public String getEtatExercice() {
		return this.etatExercice;
	}

	public void setEtatExercice(String etatExercice) {
		this.etatExercice = etatExercice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<C10Exercice> getC10Exercices() {
		return this.c10Exercices;
	}

	public void setC10Exercices(Set<C10Exercice> c10Exercices) {
		this.c10Exercices = c10Exercices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<C9Exercice> getC9Exercices() {
		return this.c9Exercices;
	}

	public void setC9Exercices(Set<C9Exercice> c9Exercices) {
		this.c9Exercices = c9Exercices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Avenant> getAvenants() {
		return this.avenants;
	}

	public void setAvenants(Set<Avenant> avenants) {
		this.avenants = avenants;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Vente> getVentes() {
		return this.ventes;
	}

	public void setVentes(Set<Vente> ventes) {
		this.ventes = ventes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Etatc10tabbExercice> getEtatc10tabbExercices() {
		return this.etatc10tabbExercices;
	}

	public void setEtatc10tabbExercices(
			Set<Etatc10tabbExercice> etatc10tabbExercices) {
		this.etatc10tabbExercices = etatc10tabbExercices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<ModifiCapital> getModifiCapitals() {
		return this.modifiCapitals;
	}

	public void setModifiCapitals(Set<ModifiCapital> modifiCapitals) {
		this.modifiCapitals = modifiCapitals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<ObligationEmprunt> getObligationEmprunts() {
		return this.obligationEmprunts;
	}

	public void setObligationEmprunts(Set<ObligationEmprunt> obligationEmprunts) {
		this.obligationEmprunts = obligationEmprunts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Etatc10tabaExercice> getEtatc10tabaExercices() {
		return this.etatc10tabaExercices;
	}

	public void setEtatc10tabaExercices(
			Set<Etatc10tabaExercice> etatc10tabaExercices) {
		this.etatc10tabaExercices = etatc10tabaExercices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercice")
	public Set<Portefeuilles> getPortefeuilleses() {
		return this.portefeuilleses;
	}

	public void setPortefeuilleses(Set<Portefeuilles> portefeuilleses) {
		this.portefeuilleses = portefeuilleses;
	}

}
