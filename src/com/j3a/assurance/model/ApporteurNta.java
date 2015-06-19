package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ApporteurNta generated by hbm2java
 */
@Entity
@Table(name = "apporteur_nta", catalog = "zeusbd")
public class ApporteurNta implements java.io.Serializable {

	private ApporteurNtaId id;
	private Apporteur apporteur;
	private RisqueNta risqueNta;
	private Date dateApporteurNta;
	private BigDecimal tauxComApporteurNta;
	private BigDecimal montantComApporteurNta;

	public ApporteurNta() {
	}

	public ApporteurNta(ApporteurNtaId id, Apporteur apporteur,
			RisqueNta risqueNta) {
		this.id = id;
		this.apporteur = apporteur;
		this.risqueNta = risqueNta;
	}

	public ApporteurNta(ApporteurNtaId id, Apporteur apporteur,
			RisqueNta risqueNta, Date dateApporteurNta,
			BigDecimal tauxComApporteurNta, BigDecimal montantComApporteurNta) {
		this.id = id;
		this.apporteur = apporteur;
		this.risqueNta = risqueNta;
		this.dateApporteurNta = dateApporteurNta;
		this.tauxComApporteurNta = tauxComApporteurNta;
		this.montantComApporteurNta = montantComApporteurNta;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeApporteur", column = @Column(name = "CODE_APPORTEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "codeRisquenta", column = @Column(name = "CODE_RISQUENTA", nullable = false, length = 30)) })
	public ApporteurNtaId getId() {
		return this.id;
	}

	public void setId(ApporteurNtaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_APPORTEUR", nullable = false, insertable = false, updatable = false)
	public Apporteur getApporteur() {
		return this.apporteur;
	}

	public void setApporteur(Apporteur apporteur) {
		this.apporteur = apporteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RISQUENTA", nullable = false, insertable = false, updatable = false)
	public RisqueNta getRisqueNta() {
		return this.risqueNta;
	}

	public void setRisqueNta(RisqueNta risqueNta) {
		this.risqueNta = risqueNta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_NTA", length = 19)
	public Date getDateApporteurNta() {
		return this.dateApporteurNta;
	}

	public void setDateApporteurNta(Date dateApporteurNta) {
		this.dateApporteurNta = dateApporteurNta;
	}

	@Column(name = "TAUX_COM_APPORTEUR_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurNta() {
		return this.tauxComApporteurNta;
	}

	public void setTauxComApporteurNta(BigDecimal tauxComApporteurNta) {
		this.tauxComApporteurNta = tauxComApporteurNta;
	}

	@Column(name = "MONTANT_COM_APPORTEUR_NTA", precision = 15, scale = 4)
	public BigDecimal getMontantComApporteurNta() {
		return this.montantComApporteurNta;
	}

	public void setMontantComApporteurNta(BigDecimal montantComApporteurNta) {
		this.montantComApporteurNta = montantComApporteurNta;
	}

}
