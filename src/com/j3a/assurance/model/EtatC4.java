package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

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
 * EtatC4 generated by hbm2java
 */
@Entity
@Table(name = "etat_c4", catalog = "zeusbd")
public class EtatC4 implements java.io.Serializable {

	private String codeengagements;
	private EtatCima etatCima;
	private String libelleengagementsreglementes;
	private BigDecimal provisionsrisqueencours;
	private BigDecimal provisionssinistreapayer;
	private BigDecimal provisionsmathematiques;
	private BigDecimal autresprovisionstech;
	private BigDecimal autresengagementsregl;
	private BigDecimal totalengagementsregl;
	private BigDecimal totalactifsadmisrepresentation;
	private BigDecimal tauxcouvertureengagement;
	private Date dateEtatc4;
	private Set<EngagementsActifrep> engagementsActifreps = new HashSet<EngagementsActifrep>(
			0);

	public EtatC4() {
	}

	public EtatC4(String codeengagements) {
		this.codeengagements = codeengagements;
	}

	public EtatC4(String codeengagements, EtatCima etatCima,
			String libelleengagementsreglementes,
			BigDecimal provisionsrisqueencours,
			BigDecimal provisionssinistreapayer,
			BigDecimal provisionsmathematiques,
			BigDecimal autresprovisionstech, BigDecimal autresengagementsregl,
			BigDecimal totalengagementsregl,
			BigDecimal totalactifsadmisrepresentation,
			BigDecimal tauxcouvertureengagement, Date dateEtatc4,
			Set<EngagementsActifrep> engagementsActifreps) {
		this.codeengagements = codeengagements;
		this.etatCima = etatCima;
		this.libelleengagementsreglementes = libelleengagementsreglementes;
		this.provisionsrisqueencours = provisionsrisqueencours;
		this.provisionssinistreapayer = provisionssinistreapayer;
		this.provisionsmathematiques = provisionsmathematiques;
		this.autresprovisionstech = autresprovisionstech;
		this.autresengagementsregl = autresengagementsregl;
		this.totalengagementsregl = totalengagementsregl;
		this.totalactifsadmisrepresentation = totalactifsadmisrepresentation;
		this.tauxcouvertureengagement = tauxcouvertureengagement;
		this.dateEtatc4 = dateEtatc4;
		this.engagementsActifreps = engagementsActifreps;
	}

	@Id
	@Column(name = "CODEENGAGEMENTS", unique = true, nullable = false, length = 20)
	public String getCodeengagements() {
		return this.codeengagements;
	}

	public void setCodeengagements(String codeengagements) {
		this.codeengagements = codeengagements;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_CIMA")
	public EtatCima getEtatCima() {
		return this.etatCima;
	}

	public void setEtatCima(EtatCima etatCima) {
		this.etatCima = etatCima;
	}

	@Column(name = "LIBELLEENGAGEMENTSREGLEMENTES", length = 100)
	public String getLibelleengagementsreglementes() {
		return this.libelleengagementsreglementes;
	}

	public void setLibelleengagementsreglementes(
			String libelleengagementsreglementes) {
		this.libelleengagementsreglementes = libelleengagementsreglementes;
	}

	@Column(name = "PROVISIONSRISQUEENCOURS", precision = 15, scale = 3)
	public BigDecimal getProvisionsrisqueencours() {
		return this.provisionsrisqueencours;
	}

	public void setProvisionsrisqueencours(BigDecimal provisionsrisqueencours) {
		this.provisionsrisqueencours = provisionsrisqueencours;
	}

	@Column(name = "PROVISIONSSINISTREAPAYER", precision = 15, scale = 3)
	public BigDecimal getProvisionssinistreapayer() {
		return this.provisionssinistreapayer;
	}

	public void setProvisionssinistreapayer(BigDecimal provisionssinistreapayer) {
		this.provisionssinistreapayer = provisionssinistreapayer;
	}

	@Column(name = "PROVISIONSMATHEMATIQUES", precision = 15, scale = 3)
	public BigDecimal getProvisionsmathematiques() {
		return this.provisionsmathematiques;
	}

	public void setProvisionsmathematiques(BigDecimal provisionsmathematiques) {
		this.provisionsmathematiques = provisionsmathematiques;
	}

	@Column(name = "AUTRESPROVISIONSTECH", precision = 15, scale = 3)
	public BigDecimal getAutresprovisionstech() {
		return this.autresprovisionstech;
	}

	public void setAutresprovisionstech(BigDecimal autresprovisionstech) {
		this.autresprovisionstech = autresprovisionstech;
	}

	@Column(name = "AUTRESENGAGEMENTSREGL", precision = 15, scale = 3)
	public BigDecimal getAutresengagementsregl() {
		return this.autresengagementsregl;
	}

	public void setAutresengagementsregl(BigDecimal autresengagementsregl) {
		this.autresengagementsregl = autresengagementsregl;
	}

	@Column(name = "TOTALENGAGEMENTSREGL", precision = 15, scale = 3)
	public BigDecimal getTotalengagementsregl() {
		return this.totalengagementsregl;
	}

	public void setTotalengagementsregl(BigDecimal totalengagementsregl) {
		this.totalengagementsregl = totalengagementsregl;
	}

	@Column(name = "TOTALACTIFSADMISREPRESENTATION", precision = 15, scale = 3)
	public BigDecimal getTotalactifsadmisrepresentation() {
		return this.totalactifsadmisrepresentation;
	}

	public void setTotalactifsadmisrepresentation(
			BigDecimal totalactifsadmisrepresentation) {
		this.totalactifsadmisrepresentation = totalactifsadmisrepresentation;
	}

	@Column(name = "TAUXCOUVERTUREENGAGEMENT", precision = 6, scale = 4)
	public BigDecimal getTauxcouvertureengagement() {
		return this.tauxcouvertureengagement;
	}

	public void setTauxcouvertureengagement(BigDecimal tauxcouvertureengagement) {
		this.tauxcouvertureengagement = tauxcouvertureengagement;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ETATC4", length = 19)
	public Date getDateEtatc4() {
		return this.dateEtatc4;
	}

	public void setDateEtatc4(Date dateEtatc4) {
		this.dateEtatc4 = dateEtatc4;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatC4")
	public Set<EngagementsActifrep> getEngagementsActifreps() {
		return this.engagementsActifreps;
	}

	public void setEngagementsActifreps(
			Set<EngagementsActifrep> engagementsActifreps) {
		this.engagementsActifreps = engagementsActifreps;
	}

}
