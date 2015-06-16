package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

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
 * ApporteurAssure generated by hbm2java
 */
@Entity
@Table(name = "apporteur_assure", catalog = "zeusbd")
public class ApporteurAssure implements java.io.Serializable {

	private ApporteurAssureId id;
	private Apporteur apporteur;
	private AssureIa assureIa;
	private Date dateApporteurAssure;
	private BigDecimal tauxComApporteurAssure;
	private BigDecimal montantComApporteurAssure;

	public ApporteurAssure() {
	}

	public ApporteurAssure(ApporteurAssureId id, Apporteur apporteur,
			AssureIa assureIa) {
		this.id = id;
		this.apporteur = apporteur;
		this.assureIa = assureIa;
	}

	public ApporteurAssure(ApporteurAssureId id, Apporteur apporteur,
			AssureIa assureIa, Date dateApporteurAssure,
			BigDecimal tauxComApporteurAssure,
			BigDecimal montantComApporteurAssure) {
		this.id = id;
		this.apporteur = apporteur;
		this.assureIa = assureIa;
		this.dateApporteurAssure = dateApporteurAssure;
		this.tauxComApporteurAssure = tauxComApporteurAssure;
		this.montantComApporteurAssure = montantComApporteurAssure;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeApporteur", column = @Column(name = "CODE_APPORTEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "numIdentification", column = @Column(name = "NUM_IDENTIFICATION", nullable = false, length = 25)) })
	public ApporteurAssureId getId() {
		return this.id;
	}

	public void setId(ApporteurAssureId id) {
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
	@JoinColumn(name = "NUM_IDENTIFICATION", nullable = false, insertable = false, updatable = false)
	public AssureIa getAssureIa() {
		return this.assureIa;
	}

	public void setAssureIa(AssureIa assureIa) {
		this.assureIa = assureIa;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_ASSURE", length = 19)
	public Date getDateApporteurAssure() {
		return this.dateApporteurAssure;
	}

	public void setDateApporteurAssure(Date dateApporteurAssure) {
		this.dateApporteurAssure = dateApporteurAssure;
	}

	@Column(name = "TAUX_COM_APPORTEUR_ASSURE", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurAssure() {
		return this.tauxComApporteurAssure;
	}

	public void setTauxComApporteurAssure(BigDecimal tauxComApporteurAssure) {
		this.tauxComApporteurAssure = tauxComApporteurAssure;
	}

	@Column(name = "MONTANT_COM_APPORTEUR_ASSURE", precision = 15, scale = 4)
	public BigDecimal getMontantComApporteurAssure() {
		return this.montantComApporteurAssure;
	}

	public void setMontantComApporteurAssure(
			BigDecimal montantComApporteurAssure) {
		this.montantComApporteurAssure = montantComApporteurAssure;
	}

}
