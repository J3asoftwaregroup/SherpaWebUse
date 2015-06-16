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
 * AffaireApporteur generated by hbm2java
 */
@Entity
@Table(name = "affaire_apporteur", catalog = "zeusbd")
public class AffaireApporteur implements java.io.Serializable {

	private String codeAffaire;
	private Apporteur apporteur;
	private String numeroPoliceAff;
	private String numAvenantAff;
	private BigDecimal comAff;
	private Date dateAff;
	private String etatReglAff;
	private BigDecimal resteAPayerAff;
	private String mouvementAffApp;
	private Set<ReglementApporteur> reglementApporteurs = new HashSet<ReglementApporteur>(
			0);

	public AffaireApporteur() {
	}

	public AffaireApporteur(String codeAffaire, Apporteur apporteur) {
		this.codeAffaire = codeAffaire;
		this.apporteur = apporteur;
	}

	public AffaireApporteur(String codeAffaire, Apporteur apporteur,
			String numeroPoliceAff, String numAvenantAff, BigDecimal comAff,
			Date dateAff, String etatReglAff, BigDecimal resteAPayerAff,
			String mouvementAffApp, Set<ReglementApporteur> reglementApporteurs) {
		this.codeAffaire = codeAffaire;
		this.apporteur = apporteur;
		this.numeroPoliceAff = numeroPoliceAff;
		this.numAvenantAff = numAvenantAff;
		this.comAff = comAff;
		this.dateAff = dateAff;
		this.etatReglAff = etatReglAff;
		this.resteAPayerAff = resteAPayerAff;
		this.mouvementAffApp = mouvementAffApp;
		this.reglementApporteurs = reglementApporteurs;
	}

	@Id
	@Column(name = "CODE_AFFAIRE", unique = true, nullable = false, length = 30)
	public String getCodeAffaire() {
		return this.codeAffaire;
	}

	public void setCodeAffaire(String codeAffaire) {
		this.codeAffaire = codeAffaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_APPORTEUR", nullable = false)
	public Apporteur getApporteur() {
		return this.apporteur;
	}

	public void setApporteur(Apporteur apporteur) {
		this.apporteur = apporteur;
	}

	@Column(name = "NUMERO_POLICE_AFF", length = 20)
	public String getNumeroPoliceAff() {
		return this.numeroPoliceAff;
	}

	public void setNumeroPoliceAff(String numeroPoliceAff) {
		this.numeroPoliceAff = numeroPoliceAff;
	}

	@Column(name = "NUM_AVENANT_AFF", length = 25)
	public String getNumAvenantAff() {
		return this.numAvenantAff;
	}

	public void setNumAvenantAff(String numAvenantAff) {
		this.numAvenantAff = numAvenantAff;
	}

	@Column(name = "COM_AFF", precision = 15, scale = 3)
	public BigDecimal getComAff() {
		return this.comAff;
	}

	public void setComAff(BigDecimal comAff) {
		this.comAff = comAff;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_AFF", length = 10)
	public Date getDateAff() {
		return this.dateAff;
	}

	public void setDateAff(Date dateAff) {
		this.dateAff = dateAff;
	}

	@Column(name = "ETAT_REGL_AFF", length = 15)
	public String getEtatReglAff() {
		return this.etatReglAff;
	}

	public void setEtatReglAff(String etatReglAff) {
		this.etatReglAff = etatReglAff;
	}

	@Column(name = "RESTE_A_PAYER_AFF", precision = 15, scale = 3)
	public BigDecimal getResteAPayerAff() {
		return this.resteAPayerAff;
	}

	public void setResteAPayerAff(BigDecimal resteAPayerAff) {
		this.resteAPayerAff = resteAPayerAff;
	}

	@Column(name = "MOUVEMENT_AFF_APP", length = 40)
	public String getMouvementAffApp() {
		return this.mouvementAffApp;
	}

	public void setMouvementAffApp(String mouvementAffApp) {
		this.mouvementAffApp = mouvementAffApp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "affaireApporteur")
	public Set<ReglementApporteur> getReglementApporteurs() {
		return this.reglementApporteurs;
	}

	public void setReglementApporteurs(
			Set<ReglementApporteur> reglementApporteurs) {
		this.reglementApporteurs = reglementApporteurs;
	}

}
