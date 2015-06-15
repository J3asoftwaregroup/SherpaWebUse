package com.j3a.assurance.model;

// Generated 15 juin 2015 17:23:41 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ReglementSinistreGc generated by hbm2java
 */
@Entity
@Table(name = "reglement_sinistre_gc", catalog = "zeusbd")
public class ReglementSinistreGc implements java.io.Serializable {

	private String codeReglementSinistreGc;
	private Sinistre sinistre;
	private BigDecimal fraisReel;
	private BigDecimal montantExclusion;
	private BigDecimal montantBase;
	private BigDecimal montantForce;
	private BigDecimal montantDiffere;
	private BigDecimal montantRemboursement;
	private BigDecimal montantReglement;
	private String motifExclusion;

	public ReglementSinistreGc() {
	}

	public ReglementSinistreGc(String codeReglementSinistreGc) {
		this.codeReglementSinistreGc = codeReglementSinistreGc;
	}

	public ReglementSinistreGc(String codeReglementSinistreGc,
			Sinistre sinistre, BigDecimal fraisReel,
			BigDecimal montantExclusion, BigDecimal montantBase,
			BigDecimal montantForce, BigDecimal montantDiffere,
			BigDecimal montantRemboursement, BigDecimal montantReglement,
			String motifExclusion) {
		this.codeReglementSinistreGc = codeReglementSinistreGc;
		this.sinistre = sinistre;
		this.fraisReel = fraisReel;
		this.montantExclusion = montantExclusion;
		this.montantBase = montantBase;
		this.montantForce = montantForce;
		this.montantDiffere = montantDiffere;
		this.montantRemboursement = montantRemboursement;
		this.montantReglement = montantReglement;
		this.motifExclusion = motifExclusion;
	}

	@Id
	@Column(name = "CODE_REGLEMENT_SINISTRE_GC", unique = true, nullable = false, length = 16)
	public String getCodeReglementSinistreGc() {
		return this.codeReglementSinistreGc;
	}

	public void setCodeReglementSinistreGc(String codeReglementSinistreGc) {
		this.codeReglementSinistreGc = codeReglementSinistreGc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE")
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "FRAIS_REEL", precision = 15, scale = 3)
	public BigDecimal getFraisReel() {
		return this.fraisReel;
	}

	public void setFraisReel(BigDecimal fraisReel) {
		this.fraisReel = fraisReel;
	}

	@Column(name = "MONTANT_EXCLUSION", precision = 15, scale = 3)
	public BigDecimal getMontantExclusion() {
		return this.montantExclusion;
	}

	public void setMontantExclusion(BigDecimal montantExclusion) {
		this.montantExclusion = montantExclusion;
	}

	@Column(name = "MONTANT_BASE", precision = 15, scale = 3)
	public BigDecimal getMontantBase() {
		return this.montantBase;
	}

	public void setMontantBase(BigDecimal montantBase) {
		this.montantBase = montantBase;
	}

	@Column(name = "MONTANT_FORCE", precision = 15, scale = 3)
	public BigDecimal getMontantForce() {
		return this.montantForce;
	}

	public void setMontantForce(BigDecimal montantForce) {
		this.montantForce = montantForce;
	}

	@Column(name = "MONTANT_DIFFERE", precision = 15, scale = 3)
	public BigDecimal getMontantDiffere() {
		return this.montantDiffere;
	}

	public void setMontantDiffere(BigDecimal montantDiffere) {
		this.montantDiffere = montantDiffere;
	}

	@Column(name = "MONTANT_REMBOURSEMENT", precision = 15, scale = 3)
	public BigDecimal getMontantRemboursement() {
		return this.montantRemboursement;
	}

	public void setMontantRemboursement(BigDecimal montantRemboursement) {
		this.montantRemboursement = montantRemboursement;
	}

	@Column(name = "MONTANT_REGLEMENT", precision = 15, scale = 3)
	public BigDecimal getMontantReglement() {
		return this.montantReglement;
	}

	public void setMontantReglement(BigDecimal montantReglement) {
		this.montantReglement = montantReglement;
	}

	@Column(name = "MOTIF_EXCLUSION", length = 65535)
	public String getMotifExclusion() {
		return this.motifExclusion;
	}

	public void setMotifExclusion(String motifExclusion) {
		this.motifExclusion = motifExclusion;
	}

}
