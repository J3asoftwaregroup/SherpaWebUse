package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Beneficiaire generated by hbm2java
 */
@Entity
@Table(name = "beneficiaire", catalog = "zeusbd")
public class Beneficiaire implements java.io.Serializable {

	private String codeBeneficiaire;
	private AssureIa assureIa;
	private String nomBeneficiaire;
	private String prenomBeneficiaire;
	private Date datenaissBeneficiaire;
	private String lieunaissBeneficiaire;
	private String adresseBeneficiaire;
	private String telBeneficiaire;
	private String mailBeneficiaire;
	private Integer partBeneficiaire;

	public Beneficiaire() {
	}

	public Beneficiaire(String codeBeneficiaire, AssureIa assureIa) {
		this.codeBeneficiaire = codeBeneficiaire;
		this.assureIa = assureIa;
	}

	public Beneficiaire(String codeBeneficiaire, AssureIa assureIa,
			String nomBeneficiaire, String prenomBeneficiaire,
			Date datenaissBeneficiaire, String lieunaissBeneficiaire,
			String adresseBeneficiaire, String telBeneficiaire,
			String mailBeneficiaire, Integer partBeneficiaire) {
		this.codeBeneficiaire = codeBeneficiaire;
		this.assureIa = assureIa;
		this.nomBeneficiaire = nomBeneficiaire;
		this.prenomBeneficiaire = prenomBeneficiaire;
		this.datenaissBeneficiaire = datenaissBeneficiaire;
		this.lieunaissBeneficiaire = lieunaissBeneficiaire;
		this.adresseBeneficiaire = adresseBeneficiaire;
		this.telBeneficiaire = telBeneficiaire;
		this.mailBeneficiaire = mailBeneficiaire;
		this.partBeneficiaire = partBeneficiaire;
	}

	@Id
	@Column(name = "CODE_BENEFICIAIRE", unique = true, nullable = false, length = 30)
	public String getCodeBeneficiaire() {
		return this.codeBeneficiaire;
	}

	public void setCodeBeneficiaire(String codeBeneficiaire) {
		this.codeBeneficiaire = codeBeneficiaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_IDENTIFICATION", nullable = false)
	public AssureIa getAssureIa() {
		return this.assureIa;
	}

	public void setAssureIa(AssureIa assureIa) {
		this.assureIa = assureIa;
	}

	@Column(name = "NOM_BENEFICIAIRE", length = 20)
	public String getNomBeneficiaire() {
		return this.nomBeneficiaire;
	}

	public void setNomBeneficiaire(String nomBeneficiaire) {
		this.nomBeneficiaire = nomBeneficiaire;
	}

	@Column(name = "PRENOM_BENEFICIAIRE", length = 60)
	public String getPrenomBeneficiaire() {
		return this.prenomBeneficiaire;
	}

	public void setPrenomBeneficiaire(String prenomBeneficiaire) {
		this.prenomBeneficiaire = prenomBeneficiaire;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATENAISS_BENEFICIAIRE", length = 10)
	public Date getDatenaissBeneficiaire() {
		return this.datenaissBeneficiaire;
	}

	public void setDatenaissBeneficiaire(Date datenaissBeneficiaire) {
		this.datenaissBeneficiaire = datenaissBeneficiaire;
	}

	@Column(name = "LIEUNAISS_BENEFICIAIRE", length = 20)
	public String getLieunaissBeneficiaire() {
		return this.lieunaissBeneficiaire;
	}

	public void setLieunaissBeneficiaire(String lieunaissBeneficiaire) {
		this.lieunaissBeneficiaire = lieunaissBeneficiaire;
	}

	@Column(name = "ADRESSE_BENEFICIAIRE", length = 60)
	public String getAdresseBeneficiaire() {
		return this.adresseBeneficiaire;
	}

	public void setAdresseBeneficiaire(String adresseBeneficiaire) {
		this.adresseBeneficiaire = adresseBeneficiaire;
	}

	@Column(name = "TEL_BENEFICIAIRE", length = 20)
	public String getTelBeneficiaire() {
		return this.telBeneficiaire;
	}

	public void setTelBeneficiaire(String telBeneficiaire) {
		this.telBeneficiaire = telBeneficiaire;
	}

	@Column(name = "MAIL_BENEFICIAIRE", length = 60)
	public String getMailBeneficiaire() {
		return this.mailBeneficiaire;
	}

	public void setMailBeneficiaire(String mailBeneficiaire) {
		this.mailBeneficiaire = mailBeneficiaire;
	}

	@Column(name = "PART_BENEFICIAIRE")
	public Integer getPartBeneficiaire() {
		return this.partBeneficiaire;
	}

	public void setPartBeneficiaire(Integer partBeneficiaire) {
		this.partBeneficiaire = partBeneficiaire;
	}

}
