package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * Cgpp generated by hbm2java
 */
@Entity
@Table(name = "cgpp", catalog = "zeusbd")
public class Cgpp implements java.io.Serializable {

	private String codeCgpp;
	private EtatCima etatCima;
	private BigDecimal dotProvDepDeb;
	private BigDecimal perteExoAntDeb;
	private BigDecimal pertExptExoDeb;
	private BigDecimal moinValCsEDeb;
	private BigDecimal autrePerteDeb;
	private BigDecimal imfDeb;
	private BigDecimal benefNetDeb;
	private BigDecimal totalDeb;
	private BigDecimal benfExplCred;
	private BigDecimal profiExoAntCred;
	private BigDecimal repProvAntCred;
	private BigDecimal profitExoCred;
	private BigDecimal plusValEltCred;
	private BigDecimal pertNetCred;
	private BigDecimal totalCred;
	private String libelleCgpp;
	private BigDecimal pertDeploitDeb;
	private Date dateCgpp;

	public Cgpp() {
	}

	public Cgpp(String codeCgpp) {
		this.codeCgpp = codeCgpp;
	}

	public Cgpp(String codeCgpp, EtatCima etatCima, BigDecimal dotProvDepDeb,
			BigDecimal perteExoAntDeb, BigDecimal pertExptExoDeb,
			BigDecimal moinValCsEDeb, BigDecimal autrePerteDeb,
			BigDecimal imfDeb, BigDecimal benefNetDeb, BigDecimal totalDeb,
			BigDecimal benfExplCred, BigDecimal profiExoAntCred,
			BigDecimal repProvAntCred, BigDecimal profitExoCred,
			BigDecimal plusValEltCred, BigDecimal pertNetCred,
			BigDecimal totalCred, String libelleCgpp,
			BigDecimal pertDeploitDeb, Date dateCgpp) {
		this.codeCgpp = codeCgpp;
		this.etatCima = etatCima;
		this.dotProvDepDeb = dotProvDepDeb;
		this.perteExoAntDeb = perteExoAntDeb;
		this.pertExptExoDeb = pertExptExoDeb;
		this.moinValCsEDeb = moinValCsEDeb;
		this.autrePerteDeb = autrePerteDeb;
		this.imfDeb = imfDeb;
		this.benefNetDeb = benefNetDeb;
		this.totalDeb = totalDeb;
		this.benfExplCred = benfExplCred;
		this.profiExoAntCred = profiExoAntCred;
		this.repProvAntCred = repProvAntCred;
		this.profitExoCred = profitExoCred;
		this.plusValEltCred = plusValEltCred;
		this.pertNetCred = pertNetCred;
		this.totalCred = totalCred;
		this.libelleCgpp = libelleCgpp;
		this.pertDeploitDeb = pertDeploitDeb;
		this.dateCgpp = dateCgpp;
	}

	@Id
	@Column(name = "CODE_CGPP", unique = true, nullable = false, length = 20)
	public String getCodeCgpp() {
		return this.codeCgpp;
	}

	public void setCodeCgpp(String codeCgpp) {
		this.codeCgpp = codeCgpp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_CIMA")
	public EtatCima getEtatCima() {
		return this.etatCima;
	}

	public void setEtatCima(EtatCima etatCima) {
		this.etatCima = etatCima;
	}

	@Column(name = "DOT_PROV_DEP_DEB", precision = 15, scale = 3)
	public BigDecimal getDotProvDepDeb() {
		return this.dotProvDepDeb;
	}

	public void setDotProvDepDeb(BigDecimal dotProvDepDeb) {
		this.dotProvDepDeb = dotProvDepDeb;
	}

	@Column(name = "PERTE_EXO_ANT_DEB", precision = 15, scale = 3)
	public BigDecimal getPerteExoAntDeb() {
		return this.perteExoAntDeb;
	}

	public void setPerteExoAntDeb(BigDecimal perteExoAntDeb) {
		this.perteExoAntDeb = perteExoAntDeb;
	}

	@Column(name = "PERT_EXPT_EXO_DEB", precision = 15, scale = 3)
	public BigDecimal getPertExptExoDeb() {
		return this.pertExptExoDeb;
	}

	public void setPertExptExoDeb(BigDecimal pertExptExoDeb) {
		this.pertExptExoDeb = pertExptExoDeb;
	}

	@Column(name = "MOIN_VAL_CS_E_DEB", precision = 15, scale = 3)
	public BigDecimal getMoinValCsEDeb() {
		return this.moinValCsEDeb;
	}

	public void setMoinValCsEDeb(BigDecimal moinValCsEDeb) {
		this.moinValCsEDeb = moinValCsEDeb;
	}

	@Column(name = "AUTRE_PERTE_DEB", precision = 15, scale = 3)
	public BigDecimal getAutrePerteDeb() {
		return this.autrePerteDeb;
	}

	public void setAutrePerteDeb(BigDecimal autrePerteDeb) {
		this.autrePerteDeb = autrePerteDeb;
	}

	@Column(name = "IMF_DEB", precision = 15, scale = 3)
	public BigDecimal getImfDeb() {
		return this.imfDeb;
	}

	public void setImfDeb(BigDecimal imfDeb) {
		this.imfDeb = imfDeb;
	}

	@Column(name = "BENEF_NET_DEB", precision = 15, scale = 3)
	public BigDecimal getBenefNetDeb() {
		return this.benefNetDeb;
	}

	public void setBenefNetDeb(BigDecimal benefNetDeb) {
		this.benefNetDeb = benefNetDeb;
	}

	@Column(name = "TOTAL_DEB", precision = 15, scale = 3)
	public BigDecimal getTotalDeb() {
		return this.totalDeb;
	}

	public void setTotalDeb(BigDecimal totalDeb) {
		this.totalDeb = totalDeb;
	}

	@Column(name = "BENF_EXPL_CRED", precision = 15, scale = 3)
	public BigDecimal getBenfExplCred() {
		return this.benfExplCred;
	}

	public void setBenfExplCred(BigDecimal benfExplCred) {
		this.benfExplCred = benfExplCred;
	}

	@Column(name = "PROFI_EXO_ANT_CRED", precision = 15, scale = 3)
	public BigDecimal getProfiExoAntCred() {
		return this.profiExoAntCred;
	}

	public void setProfiExoAntCred(BigDecimal profiExoAntCred) {
		this.profiExoAntCred = profiExoAntCred;
	}

	@Column(name = "REP_PROV_ANT_CRED", precision = 15, scale = 3)
	public BigDecimal getRepProvAntCred() {
		return this.repProvAntCred;
	}

	public void setRepProvAntCred(BigDecimal repProvAntCred) {
		this.repProvAntCred = repProvAntCred;
	}

	@Column(name = "PROFIT_EXO_CRED", precision = 15, scale = 3)
	public BigDecimal getProfitExoCred() {
		return this.profitExoCred;
	}

	public void setProfitExoCred(BigDecimal profitExoCred) {
		this.profitExoCred = profitExoCred;
	}

	@Column(name = "PLUS_VAL_ELT_CRED", precision = 15, scale = 3)
	public BigDecimal getPlusValEltCred() {
		return this.plusValEltCred;
	}

	public void setPlusValEltCred(BigDecimal plusValEltCred) {
		this.plusValEltCred = plusValEltCred;
	}

	@Column(name = "PERT_NET_CRED", precision = 15, scale = 3)
	public BigDecimal getPertNetCred() {
		return this.pertNetCred;
	}

	public void setPertNetCred(BigDecimal pertNetCred) {
		this.pertNetCred = pertNetCred;
	}

	@Column(name = "TOTAL_CRED", precision = 15, scale = 3)
	public BigDecimal getTotalCred() {
		return this.totalCred;
	}

	public void setTotalCred(BigDecimal totalCred) {
		this.totalCred = totalCred;
	}

	@Column(name = "LIBELLE_CGPP", length = 100)
	public String getLibelleCgpp() {
		return this.libelleCgpp;
	}

	public void setLibelleCgpp(String libelleCgpp) {
		this.libelleCgpp = libelleCgpp;
	}

	@Column(name = "PERT_DEPLOIT_DEB", precision = 15, scale = 3)
	public BigDecimal getPertDeploitDeb() {
		return this.pertDeploitDeb;
	}

	public void setPertDeploitDeb(BigDecimal pertDeploitDeb) {
		this.pertDeploitDeb = pertDeploitDeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CGPP", length = 19)
	public Date getDateCgpp() {
		return this.dateCgpp;
	}

	public void setDateCgpp(Date dateCgpp) {
		this.dateCgpp = dateCgpp;
	}

}