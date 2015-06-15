package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

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
 * ApporteurAliment generated by hbm2java
 */
@Entity
@Table(name = "apporteur_aliment", catalog = "zeusbd")
public class ApporteurAliment implements java.io.Serializable {

	private ApporteurAlimentId id;
	private Aliment aliment;
	private Apporteur apporteur;
	private Date dateApporteurAliment;
	private BigDecimal tauxComApporteurAliment;
	private BigDecimal montantComApporteurAliment;

	public ApporteurAliment() {
	}

	public ApporteurAliment(ApporteurAlimentId id, Aliment aliment,
			Apporteur apporteur) {
		this.id = id;
		this.aliment = aliment;
		this.apporteur = apporteur;
	}

	public ApporteurAliment(ApporteurAlimentId id, Aliment aliment,
			Apporteur apporteur, Date dateApporteurAliment,
			BigDecimal tauxComApporteurAliment,
			BigDecimal montantComApporteurAliment) {
		this.id = id;
		this.aliment = aliment;
		this.apporteur = apporteur;
		this.dateApporteurAliment = dateApporteurAliment;
		this.tauxComApporteurAliment = tauxComApporteurAliment;
		this.montantComApporteurAliment = montantComApporteurAliment;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeApporteur", column = @Column(name = "CODE_APPORTEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "codeAliment", column = @Column(name = "CODE_ALIMENT", nullable = false, length = 35)) })
	public ApporteurAlimentId getId() {
		return this.id;
	}

	public void setId(ApporteurAlimentId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ALIMENT", nullable = false, insertable = false, updatable = false)
	public Aliment getAliment() {
		return this.aliment;
	}

	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_APPORTEUR", nullable = false, insertable = false, updatable = false)
	public Apporteur getApporteur() {
		return this.apporteur;
	}

	public void setApporteur(Apporteur apporteur) {
		this.apporteur = apporteur;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_ALIMENT", length = 19)
	public Date getDateApporteurAliment() {
		return this.dateApporteurAliment;
	}

	public void setDateApporteurAliment(Date dateApporteurAliment) {
		this.dateApporteurAliment = dateApporteurAliment;
	}

	@Column(name = "TAUX_COM_APPORTEUR_ALIMENT", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurAliment() {
		return this.tauxComApporteurAliment;
	}

	public void setTauxComApporteurAliment(BigDecimal tauxComApporteurAliment) {
		this.tauxComApporteurAliment = tauxComApporteurAliment;
	}

	@Column(name = "MONTANT_COM_APPORTEUR_ALIMENT", precision = 15, scale = 4)
	public BigDecimal getMontantComApporteurAliment() {
		return this.montantComApporteurAliment;
	}

	public void setMontantComApporteurAliment(
			BigDecimal montantComApporteurAliment) {
		this.montantComApporteurAliment = montantComApporteurAliment;
	}

}
