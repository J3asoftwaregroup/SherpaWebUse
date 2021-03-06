package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

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
 * SocieteAssurance generated by hbm2java
 */
@Entity
@Table(name = "societe_assurance", catalog = "zeusbd")
public class SocieteAssurance implements java.io.Serializable {

	private String codeSocieteAssurance;
	private String abrege;
	private String nomSocieteAssurance;
	private String adressePostale;
	private String deviseUtilise;
	private String modPass;
	private String mailSocieteAssurancePublic;
	private Date dateConstitution;
	private String referenceStattut;
	private Boolean modifiStatut;
	private String pays;
	private Set<Contrat> contrats = new HashSet<Contrat>(0);

	public SocieteAssurance() {
	}

	public SocieteAssurance(String codeSocieteAssurance) {
		this.codeSocieteAssurance = codeSocieteAssurance;
	}

	public SocieteAssurance(String codeSocieteAssurance, String abrege,
			String nomSocieteAssurance, String adressePostale,
			String deviseUtilise, String modPass,
			String mailSocieteAssurancePublic, Date dateConstitution,
			String referenceStattut, Boolean modifiStatut, String pays,
			Set<Contrat> contrats) {
		this.codeSocieteAssurance = codeSocieteAssurance;
		this.abrege = abrege;
		this.nomSocieteAssurance = nomSocieteAssurance;
		this.adressePostale = adressePostale;
		this.deviseUtilise = deviseUtilise;
		this.modPass = modPass;
		this.mailSocieteAssurancePublic = mailSocieteAssurancePublic;
		this.dateConstitution = dateConstitution;
		this.referenceStattut = referenceStattut;
		this.modifiStatut = modifiStatut;
		this.pays = pays;
		this.contrats = contrats;
	}

	@Id
	@Column(name = "CODE_SOCIETE_ASSURANCE", unique = true, nullable = false, length = 15)
	public String getCodeSocieteAssurance() {
		return this.codeSocieteAssurance;
	}

	public void setCodeSocieteAssurance(String codeSocieteAssurance) {
		this.codeSocieteAssurance = codeSocieteAssurance;
	}

	@Column(name = "ABREGE", length = 10)
	public String getAbrege() {
		return this.abrege;
	}

	public void setAbrege(String abrege) {
		this.abrege = abrege;
	}

	@Column(name = "NOM_SOCIETE_ASSURANCE", length = 50)
	public String getNomSocieteAssurance() {
		return this.nomSocieteAssurance;
	}

	public void setNomSocieteAssurance(String nomSocieteAssurance) {
		this.nomSocieteAssurance = nomSocieteAssurance;
	}

	@Column(name = "ADRESSE_POSTALE", length = 25)
	public String getAdressePostale() {
		return this.adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}

	@Column(name = "DEVISE_UTILISE", length = 10)
	public String getDeviseUtilise() {
		return this.deviseUtilise;
	}

	public void setDeviseUtilise(String deviseUtilise) {
		this.deviseUtilise = deviseUtilise;
	}

	@Column(name = "MOD_PASS", length = 10)
	public String getModPass() {
		return this.modPass;
	}

	public void setModPass(String modPass) {
		this.modPass = modPass;
	}

	@Column(name = "MAIL_SOCIETE_ASSURANCE_PUBLIC", length = 60)
	public String getMailSocieteAssurancePublic() {
		return this.mailSocieteAssurancePublic;
	}

	public void setMailSocieteAssurancePublic(String mailSocieteAssurancePublic) {
		this.mailSocieteAssurancePublic = mailSocieteAssurancePublic;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CONSTITUTION", length = 10)
	public Date getDateConstitution() {
		return this.dateConstitution;
	}

	public void setDateConstitution(Date dateConstitution) {
		this.dateConstitution = dateConstitution;
	}

	@Column(name = "REFERENCE_STATTUT", length = 25)
	public String getReferenceStattut() {
		return this.referenceStattut;
	}

	public void setReferenceStattut(String referenceStattut) {
		this.referenceStattut = referenceStattut;
	}

	@Column(name = "MODIFI_STATUT")
	public Boolean getModifiStatut() {
		return this.modifiStatut;
	}

	public void setModifiStatut(Boolean modifiStatut) {
		this.modifiStatut = modifiStatut;
	}

	@Column(name = "PAYS", length = 60)
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "societeAssurance")
	public Set<Contrat> getContrats() {
		return this.contrats;
	}

	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}

}
