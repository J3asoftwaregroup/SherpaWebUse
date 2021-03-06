package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

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
 * Quittance generated by hbm2java
 */
@Entity
@Table(name = "quittance", catalog = "zeusbd")
public class Quittance implements java.io.Serializable {

	private String codeQuittance;
	private Avenant avenant;
	private String etatQuittance;
	private BigDecimal primeCedee;
	private BigDecimal accessoire;
	private BigDecimal taxes;
	private BigDecimal netAPayer;
	private BigDecimal fga;
	private Date dateQuittance;
	private BigDecimal primeNette;
	private BigDecimal accCnie;
	private BigDecimal accIntrerm;
	private BigDecimal accGestionnaire;
	private BigDecimal comInterm;
	private BigDecimal comConseil;
	private BigDecimal comGestionnaire;
	private BigDecimal comAperition;
	private BigDecimal commision;
	private BigDecimal primeExoEncours;
	private BigDecimal primeReport;
	private BigDecimal prec;
	private BigDecimal primeTotale;
	private Set<Reglement> reglements = new HashSet<Reglement>(0);

	public Quittance() {
	}

	public Quittance(String codeQuittance, Avenant avenant) {
		this.codeQuittance = codeQuittance;
		this.avenant = avenant;
	}

	public Quittance(String codeQuittance, Avenant avenant,
			String etatQuittance, BigDecimal primeCedee, BigDecimal accessoire,
			BigDecimal taxes, BigDecimal netAPayer, BigDecimal fga,
			Date dateQuittance, BigDecimal primeNette, BigDecimal accCnie,
			BigDecimal accIntrerm, BigDecimal accGestionnaire,
			BigDecimal comInterm, BigDecimal comConseil,
			BigDecimal comGestionnaire, BigDecimal comAperition,
			BigDecimal commision, BigDecimal primeExoEncours,
			BigDecimal primeReport, BigDecimal prec, BigDecimal primeTotale,
			Set<Reglement> reglements) {
		this.codeQuittance = codeQuittance;
		this.avenant = avenant;
		this.etatQuittance = etatQuittance;
		this.primeCedee = primeCedee;
		this.accessoire = accessoire;
		this.taxes = taxes;
		this.netAPayer = netAPayer;
		this.fga = fga;
		this.dateQuittance = dateQuittance;
		this.primeNette = primeNette;
		this.accCnie = accCnie;
		this.accIntrerm = accIntrerm;
		this.accGestionnaire = accGestionnaire;
		this.comInterm = comInterm;
		this.comConseil = comConseil;
		this.comGestionnaire = comGestionnaire;
		this.comAperition = comAperition;
		this.commision = commision;
		this.primeExoEncours = primeExoEncours;
		this.primeReport = primeReport;
		this.prec = prec;
		this.primeTotale = primeTotale;
		this.reglements = reglements;
	}

	@Id
	@Column(name = "CODE_QUITTANCE", unique = true, nullable = false, length = 30)
	public String getCodeQuittance() {
		return this.codeQuittance;
	}

	public void setCodeQuittance(String codeQuittance) {
		this.codeQuittance = codeQuittance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_AVENANT", nullable = false)
	public Avenant getAvenant() {
		return this.avenant;
	}

	public void setAvenant(Avenant avenant) {
		this.avenant = avenant;
	}

	@Column(name = "ETAT_QUITTANCE", length = 15)
	public String getEtatQuittance() {
		return this.etatQuittance;
	}

	public void setEtatQuittance(String etatQuittance) {
		this.etatQuittance = etatQuittance;
	}

	@Column(name = "PRIME_CEDEE", precision = 15, scale = 3)
	public BigDecimal getPrimeCedee() {
		return this.primeCedee;
	}

	public void setPrimeCedee(BigDecimal primeCedee) {
		this.primeCedee = primeCedee;
	}

	@Column(name = "ACCESSOIRE", precision = 15, scale = 3)
	public BigDecimal getAccessoire() {
		return this.accessoire;
	}

	public void setAccessoire(BigDecimal accessoire) {
		this.accessoire = accessoire;
	}

	@Column(name = "TAXES", precision = 15, scale = 3)
	public BigDecimal getTaxes() {
		return this.taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	@Column(name = "NET_A_PAYER", precision = 15, scale = 3)
	public BigDecimal getNetAPayer() {
		return this.netAPayer;
	}

	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}

	@Column(name = "FGA", precision = 15, scale = 3)
	public BigDecimal getFga() {
		return this.fga;
	}

	public void setFga(BigDecimal fga) {
		this.fga = fga;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_QUITTANCE", length = 19)
	public Date getDateQuittance() {
		return this.dateQuittance;
	}

	public void setDateQuittance(Date dateQuittance) {
		this.dateQuittance = dateQuittance;
	}

	@Column(name = "PRIME_NETTE", precision = 15, scale = 3)
	public BigDecimal getPrimeNette() {
		return this.primeNette;
	}

	public void setPrimeNette(BigDecimal primeNette) {
		this.primeNette = primeNette;
	}

	@Column(name = "ACC_CNIE", precision = 15, scale = 3)
	public BigDecimal getAccCnie() {
		return this.accCnie;
	}

	public void setAccCnie(BigDecimal accCnie) {
		this.accCnie = accCnie;
	}

	@Column(name = "ACC_INTRERM", precision = 15, scale = 3)
	public BigDecimal getAccIntrerm() {
		return this.accIntrerm;
	}

	public void setAccIntrerm(BigDecimal accIntrerm) {
		this.accIntrerm = accIntrerm;
	}

	@Column(name = "ACC_GESTIONNAIRE", precision = 15, scale = 3)
	public BigDecimal getAccGestionnaire() {
		return this.accGestionnaire;
	}

	public void setAccGestionnaire(BigDecimal accGestionnaire) {
		this.accGestionnaire = accGestionnaire;
	}

	@Column(name = "COM_INTERM", precision = 15, scale = 3)
	public BigDecimal getComInterm() {
		return this.comInterm;
	}

	public void setComInterm(BigDecimal comInterm) {
		this.comInterm = comInterm;
	}

	@Column(name = "COM_CONSEIL", precision = 15, scale = 3)
	public BigDecimal getComConseil() {
		return this.comConseil;
	}

	public void setComConseil(BigDecimal comConseil) {
		this.comConseil = comConseil;
	}

	@Column(name = "COM_GESTIONNAIRE", precision = 15, scale = 3)
	public BigDecimal getComGestionnaire() {
		return this.comGestionnaire;
	}

	public void setComGestionnaire(BigDecimal comGestionnaire) {
		this.comGestionnaire = comGestionnaire;
	}

	@Column(name = "COM_APERITION", precision = 15, scale = 3)
	public BigDecimal getComAperition() {
		return this.comAperition;
	}

	public void setComAperition(BigDecimal comAperition) {
		this.comAperition = comAperition;
	}

	@Column(name = "COMMISION", precision = 15, scale = 3)
	public BigDecimal getCommision() {
		return this.commision;
	}

	public void setCommision(BigDecimal commision) {
		this.commision = commision;
	}

	@Column(name = "PRIME_EXO_ENCOURS", precision = 15, scale = 3)
	public BigDecimal getPrimeExoEncours() {
		return this.primeExoEncours;
	}

	public void setPrimeExoEncours(BigDecimal primeExoEncours) {
		this.primeExoEncours = primeExoEncours;
	}

	@Column(name = "PRIME_REPORT", precision = 15, scale = 3)
	public BigDecimal getPrimeReport() {
		return this.primeReport;
	}

	public void setPrimeReport(BigDecimal primeReport) {
		this.primeReport = primeReport;
	}

	@Column(name = "PREC", precision = 15, scale = 3)
	public BigDecimal getPrec() {
		return this.prec;
	}

	public void setPrec(BigDecimal prec) {
		this.prec = prec;
	}

	@Column(name = "PRIME_TOTALE", precision = 15, scale = 3)
	public BigDecimal getPrimeTotale() {
		return this.primeTotale;
	}

	public void setPrimeTotale(BigDecimal primeTotale) {
		this.primeTotale = primeTotale;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quittance")
	public Set<Reglement> getReglements() {
		return this.reglements;
	}

	public void setReglements(Set<Reglement> reglements) {
		this.reglements = reglements;
	}

}
