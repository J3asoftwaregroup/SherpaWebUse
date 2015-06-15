package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Facture generated by hbm2java
 */
@Entity
@Table(name = "facture", catalog = "zeusbd")
public class Facture implements java.io.Serializable {

	private String codeFacture;
	private Date dateEmissionFact;
	private BigDecimal montantHtFact;
	private BigDecimal tvaFact;
	private BigDecimal montantTtcFact;
	private String observation;
	private String etatFacture;
	private Set reglementSinistres = new HashSet(0);
	private Set acteMedicals = new HashSet(0);
	private Set expertises = new HashSet(0);

	public Facture() {
	}

	public Facture(String codeFacture) {
		this.codeFacture = codeFacture;
	}

	public Facture(String codeFacture, Date dateEmissionFact,
			BigDecimal montantHtFact, BigDecimal tvaFact,
			BigDecimal montantTtcFact, String observation, String etatFacture,
			Set reglementSinistres, Set acteMedicals, Set expertises) {
		this.codeFacture = codeFacture;
		this.dateEmissionFact = dateEmissionFact;
		this.montantHtFact = montantHtFact;
		this.tvaFact = tvaFact;
		this.montantTtcFact = montantTtcFact;
		this.observation = observation;
		this.etatFacture = etatFacture;
		this.reglementSinistres = reglementSinistres;
		this.acteMedicals = acteMedicals;
		this.expertises = expertises;
	}

	@Id
	@Column(name = "CODE_FACTURE", unique = true, nullable = false, length = 16)
	public String getCodeFacture() {
		return this.codeFacture;
	}

	public void setCodeFacture(String codeFacture) {
		this.codeFacture = codeFacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_EMISSION_FACT", length = 10)
	public Date getDateEmissionFact() {
		return this.dateEmissionFact;
	}

	public void setDateEmissionFact(Date dateEmissionFact) {
		this.dateEmissionFact = dateEmissionFact;
	}

	@Column(name = "MONTANT_HT_FACT", precision = 15, scale = 3)
	public BigDecimal getMontantHtFact() {
		return this.montantHtFact;
	}

	public void setMontantHtFact(BigDecimal montantHtFact) {
		this.montantHtFact = montantHtFact;
	}

	@Column(name = "TVA_FACT", precision = 15, scale = 3)
	public BigDecimal getTvaFact() {
		return this.tvaFact;
	}

	public void setTvaFact(BigDecimal tvaFact) {
		this.tvaFact = tvaFact;
	}

	@Column(name = "MONTANT_TTC_FACT", precision = 15, scale = 3)
	public BigDecimal getMontantTtcFact() {
		return this.montantTtcFact;
	}

	public void setMontantTtcFact(BigDecimal montantTtcFact) {
		this.montantTtcFact = montantTtcFact;
	}

	@Column(name = "OBSERVATION", length = 50)
	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Column(name = "ETAT_FACTURE", length = 50)
	public String getEtatFacture() {
		return this.etatFacture;
	}

	public void setEtatFacture(String etatFacture) {
		this.etatFacture = etatFacture;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	public Set getReglementSinistres() {
		return this.reglementSinistres;
	}

	public void setReglementSinistres(Set reglementSinistres) {
		this.reglementSinistres = reglementSinistres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	public Set getActeMedicals() {
		return this.acteMedicals;
	}

	public void setActeMedicals(Set acteMedicals) {
		this.acteMedicals = acteMedicals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	public Set getExpertises() {
		return this.expertises;
	}

	public void setExpertises(Set expertises) {
		this.expertises = expertises;
	}

}
