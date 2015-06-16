package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Intervention generated by hbm2java
 */
@Entity
@Table(name = "intervention", catalog = "zeusbd")
public class Intervention implements java.io.Serializable {

	private String refIntervention;
	private Intervenant intervenant;
	private Sinistre sinistre;
	private String libelleIntervention;
	private Date dateIntervention;
	private String rapport;
	private String typeRapport;
	private BigDecimal chargesIntervention;
	private BigDecimal taxe;
	private BigDecimal fraisAnnexe;
	private BigDecimal montantTtc;
	private String etat;
	private String sousGarantieSupportInt;
	private Set<ReglementSinistre> reglementSinistres = new HashSet<ReglementSinistre>(
			0);

	public Intervention() {
	}

	public Intervention(String refIntervention, Intervenant intervenant) {
		this.refIntervention = refIntervention;
		this.intervenant = intervenant;
	}

	public Intervention(String refIntervention, Intervenant intervenant,
			Sinistre sinistre, String libelleIntervention,
			Date dateIntervention, String rapport, String typeRapport,
			BigDecimal chargesIntervention, BigDecimal taxe,
			BigDecimal fraisAnnexe, BigDecimal montantTtc, String etat,
			String sousGarantieSupportInt,
			Set<ReglementSinistre> reglementSinistres) {
		this.refIntervention = refIntervention;
		this.intervenant = intervenant;
		this.sinistre = sinistre;
		this.libelleIntervention = libelleIntervention;
		this.dateIntervention = dateIntervention;
		this.rapport = rapport;
		this.typeRapport = typeRapport;
		this.chargesIntervention = chargesIntervention;
		this.taxe = taxe;
		this.fraisAnnexe = fraisAnnexe;
		this.montantTtc = montantTtc;
		this.etat = etat;
		this.sousGarantieSupportInt = sousGarantieSupportInt;
		this.reglementSinistres = reglementSinistres;
	}

	@Id
	@Column(name = "REF_INTERVENTION", unique = true, nullable = false, length = 16)
	public String getRefIntervention() {
		return this.refIntervention;
	}

	public void setRefIntervention(String refIntervention) {
		this.refIntervention = refIntervention;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_INTERVENANT", nullable = false)
	public Intervenant getIntervenant() {
		return this.intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE")
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "LIBELLE_INTERVENTION", length = 100)
	public String getLibelleIntervention() {
		return this.libelleIntervention;
	}

	public void setLibelleIntervention(String libelleIntervention) {
		this.libelleIntervention = libelleIntervention;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_INTERVENTION", length = 10)
	public Date getDateIntervention() {
		return this.dateIntervention;
	}

	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	@Column(name = "RAPPORT", length = 150)
	public String getRapport() {
		return this.rapport;
	}

	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	@Column(name = "TYPE_RAPPORT", length = 150)
	public String getTypeRapport() {
		return this.typeRapport;
	}

	public void setTypeRapport(String typeRapport) {
		this.typeRapport = typeRapport;
	}

	@Column(name = "CHARGES_INTERVENTION", precision = 15, scale = 3)
	public BigDecimal getChargesIntervention() {
		return this.chargesIntervention;
	}

	public void setChargesIntervention(BigDecimal chargesIntervention) {
		this.chargesIntervention = chargesIntervention;
	}

	@Column(name = "TAXE", precision = 15, scale = 3)
	public BigDecimal getTaxe() {
		return this.taxe;
	}

	public void setTaxe(BigDecimal taxe) {
		this.taxe = taxe;
	}

	@Column(name = "FRAIS_ANNEXE", precision = 15, scale = 3)
	public BigDecimal getFraisAnnexe() {
		return this.fraisAnnexe;
	}

	public void setFraisAnnexe(BigDecimal fraisAnnexe) {
		this.fraisAnnexe = fraisAnnexe;
	}

	@Column(name = "MONTANT_TTC", precision = 15, scale = 3)
	public BigDecimal getMontantTtc() {
		return this.montantTtc;
	}

	public void setMontantTtc(BigDecimal montantTtc) {
		this.montantTtc = montantTtc;
	}

	@Column(name = "ETAT", length = 50)
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Column(name = "SOUS_GARANTIE_SUPPORT_INT", length = 100)
	public String getSousGarantieSupportInt() {
		return this.sousGarantieSupportInt;
	}

	public void setSousGarantieSupportInt(String sousGarantieSupportInt) {
		this.sousGarantieSupportInt = sousGarantieSupportInt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "intervention")
	public Set<ReglementSinistre> getReglementSinistres() {
		return this.reglementSinistres;
	}

	public void setReglementSinistres(Set<ReglementSinistre> reglementSinistres) {
		this.reglementSinistres = reglementSinistres;
	}

}
