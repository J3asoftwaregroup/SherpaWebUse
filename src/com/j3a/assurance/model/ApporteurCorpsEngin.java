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
 * ApporteurCorpsEngin generated by hbm2java
 */
@Entity
@Table(name = "apporteur_corps_engin", catalog = "zeusbd")
public class ApporteurCorpsEngin implements java.io.Serializable {

	private ApporteurCorpsEnginId id;
	private Apporteur apporteur;
	private CorpsEngin corpsEngin;
	private Date dateApporteurCorpsEngin;
	private BigDecimal tauxComApporteurCorpsEngin;
	private BigDecimal montantComApporteurComEngin;

	public ApporteurCorpsEngin() {
	}

	public ApporteurCorpsEngin(ApporteurCorpsEnginId id, Apporteur apporteur,
			CorpsEngin corpsEngin) {
		this.id = id;
		this.apporteur = apporteur;
		this.corpsEngin = corpsEngin;
	}

	public ApporteurCorpsEngin(ApporteurCorpsEnginId id, Apporteur apporteur,
			CorpsEngin corpsEngin, Date dateApporteurCorpsEngin,
			BigDecimal tauxComApporteurCorpsEngin,
			BigDecimal montantComApporteurComEngin) {
		this.id = id;
		this.apporteur = apporteur;
		this.corpsEngin = corpsEngin;
		this.dateApporteurCorpsEngin = dateApporteurCorpsEngin;
		this.tauxComApporteurCorpsEngin = tauxComApporteurCorpsEngin;
		this.montantComApporteurComEngin = montantComApporteurComEngin;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeApporteur", column = @Column(name = "CODE_APPORTEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "codeEngin", column = @Column(name = "CODE_ENGIN", nullable = false, length = 30)) })
	public ApporteurCorpsEnginId getId() {
		return this.id;
	}

	public void setId(ApporteurCorpsEnginId id) {
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
	@JoinColumn(name = "CODE_ENGIN", nullable = false, insertable = false, updatable = false)
	public CorpsEngin getCorpsEngin() {
		return this.corpsEngin;
	}

	public void setCorpsEngin(CorpsEngin corpsEngin) {
		this.corpsEngin = corpsEngin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_CORPS_ENGIN", length = 19)
	public Date getDateApporteurCorpsEngin() {
		return this.dateApporteurCorpsEngin;
	}

	public void setDateApporteurCorpsEngin(Date dateApporteurCorpsEngin) {
		this.dateApporteurCorpsEngin = dateApporteurCorpsEngin;
	}

	@Column(name = "TAUX_COM_APPORTEUR_CORPS_ENGIN", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurCorpsEngin() {
		return this.tauxComApporteurCorpsEngin;
	}

	public void setTauxComApporteurCorpsEngin(
			BigDecimal tauxComApporteurCorpsEngin) {
		this.tauxComApporteurCorpsEngin = tauxComApporteurCorpsEngin;
	}

	@Column(name = "MONTANT_COM_APPORTEUR_COM_ENGIN", precision = 15, scale = 3)
	public BigDecimal getMontantComApporteurComEngin() {
		return this.montantComApporteurComEngin;
	}

	public void setMontantComApporteurComEngin(
			BigDecimal montantComApporteurComEngin) {
		this.montantComApporteurComEngin = montantComApporteurComEngin;
	}

}
