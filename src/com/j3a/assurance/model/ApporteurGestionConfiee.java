package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

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
 * ApporteurGestionConfiee generated by hbm2java
 */
@Entity
@Table(name = "apporteur_gestion_confiee", catalog = "zeusbd")
public class ApporteurGestionConfiee implements java.io.Serializable {

	private ApporteurGestionConfieeId id;
	private Apporteur apporteur;
	private GestionConfiee gestionConfiee;
	private Date dateApporteurGc;
	private BigDecimal tauxComApporteurGc;
	private BigDecimal montantComApporteurGc;

	public ApporteurGestionConfiee() {
	}

	public ApporteurGestionConfiee(ApporteurGestionConfieeId id,
			Apporteur apporteur, GestionConfiee gestionConfiee) {
		this.id = id;
		this.apporteur = apporteur;
		this.gestionConfiee = gestionConfiee;
	}

	public ApporteurGestionConfiee(ApporteurGestionConfieeId id,
			Apporteur apporteur, GestionConfiee gestionConfiee,
			Date dateApporteurGc, BigDecimal tauxComApporteurGc,
			BigDecimal montantComApporteurGc) {
		this.id = id;
		this.apporteur = apporteur;
		this.gestionConfiee = gestionConfiee;
		this.dateApporteurGc = dateApporteurGc;
		this.tauxComApporteurGc = tauxComApporteurGc;
		this.montantComApporteurGc = montantComApporteurGc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeApporteur", column = @Column(name = "CODE_APPORTEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "codeGestionConfie", column = @Column(name = "CODE_GESTION_CONFIE", nullable = false, length = 60)) })
	public ApporteurGestionConfieeId getId() {
		return this.id;
	}

	public void setId(ApporteurGestionConfieeId id) {
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
	@JoinColumn(name = "CODE_GESTION_CONFIE", nullable = false, insertable = false, updatable = false)
	public GestionConfiee getGestionConfiee() {
		return this.gestionConfiee;
	}

	public void setGestionConfiee(GestionConfiee gestionConfiee) {
		this.gestionConfiee = gestionConfiee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_GC", length = 19)
	public Date getDateApporteurGc() {
		return this.dateApporteurGc;
	}

	public void setDateApporteurGc(Date dateApporteurGc) {
		this.dateApporteurGc = dateApporteurGc;
	}

	@Column(name = "TAUX_COM_APPORTEUR_GC", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurGc() {
		return this.tauxComApporteurGc;
	}

	public void setTauxComApporteurGc(BigDecimal tauxComApporteurGc) {
		this.tauxComApporteurGc = tauxComApporteurGc;
	}

	@Column(name = "MONTANT_COM_APPORTEUR_GC", precision = 15, scale = 4)
	public BigDecimal getMontantComApporteurGc() {
		return this.montantComApporteurGc;
	}

	public void setMontantComApporteurGc(BigDecimal montantComApporteurGc) {
		this.montantComApporteurGc = montantComApporteurGc;
	}

}
