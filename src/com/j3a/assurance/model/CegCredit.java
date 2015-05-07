package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CegCredit generated by hbm2java
 */
@Entity
@Table(name = "ceg_credit", catalog = "zeusbd")
public class CegCredit implements java.io.Serializable {

	private String codeCegCredit;
	private EtatCima etatCima;
	private BigDecimal primeAccNetAnnulOpBruttes;
	private BigDecimal primeAccNetAnnulCessRetro;
	private BigDecimal primeAccNetAnnulOpNettes;
	private BigDecimal provPrimeOuverturePrecedentOpBruttes;
	private BigDecimal provPrimeOuverturePrecedentCessRetro;
	private BigDecimal provPrimeOuverturePrecedentOpNettes;
	private BigDecimal provPrimeClotureEncoursOpBruttes;
	private BigDecimal provPrimeClotureEncoursCessRetro;
	private BigDecimal provPrimeClotureEncoursOpNettes;
	private BigDecimal primeExoOpBruttes;
	private BigDecimal primeExoCessRetro;
	private BigDecimal primeExoOpNettes;
	private BigDecimal pduitFinanciersTitres;
	private BigDecimal pduitsFinanciersAutres;
	private BigDecimal totalPduitsPlcmt;
	private BigDecimal transfertCharges;
	private BigDecimal comRecuCoass;
	private BigDecimal pduitsAcc;
	private BigDecimal totalAutresPduits;
	private BigDecimal chargesNonImputables;
	private BigDecimal soldeDebiteur;
	private BigDecimal totalCred;

	public CegCredit() {
	}

	public CegCredit(String codeCegCredit) {
		this.codeCegCredit = codeCegCredit;
	}

	public CegCredit(String codeCegCredit, EtatCima etatCima,
			BigDecimal primeAccNetAnnulOpBruttes,
			BigDecimal primeAccNetAnnulCessRetro,
			BigDecimal primeAccNetAnnulOpNettes,
			BigDecimal provPrimeOuverturePrecedentOpBruttes,
			BigDecimal provPrimeOuverturePrecedentCessRetro,
			BigDecimal provPrimeOuverturePrecedentOpNettes,
			BigDecimal provPrimeClotureEncoursOpBruttes,
			BigDecimal provPrimeClotureEncoursCessRetro,
			BigDecimal provPrimeClotureEncoursOpNettes,
			BigDecimal primeExoOpBruttes, BigDecimal primeExoCessRetro,
			BigDecimal primeExoOpNettes, BigDecimal pduitFinanciersTitres,
			BigDecimal pduitsFinanciersAutres, BigDecimal totalPduitsPlcmt,
			BigDecimal transfertCharges, BigDecimal comRecuCoass,
			BigDecimal pduitsAcc, BigDecimal totalAutresPduits,
			BigDecimal chargesNonImputables, BigDecimal soldeDebiteur,
			BigDecimal totalCred) {
		this.codeCegCredit = codeCegCredit;
		this.etatCima = etatCima;
		this.primeAccNetAnnulOpBruttes = primeAccNetAnnulOpBruttes;
		this.primeAccNetAnnulCessRetro = primeAccNetAnnulCessRetro;
		this.primeAccNetAnnulOpNettes = primeAccNetAnnulOpNettes;
		this.provPrimeOuverturePrecedentOpBruttes = provPrimeOuverturePrecedentOpBruttes;
		this.provPrimeOuverturePrecedentCessRetro = provPrimeOuverturePrecedentCessRetro;
		this.provPrimeOuverturePrecedentOpNettes = provPrimeOuverturePrecedentOpNettes;
		this.provPrimeClotureEncoursOpBruttes = provPrimeClotureEncoursOpBruttes;
		this.provPrimeClotureEncoursCessRetro = provPrimeClotureEncoursCessRetro;
		this.provPrimeClotureEncoursOpNettes = provPrimeClotureEncoursOpNettes;
		this.primeExoOpBruttes = primeExoOpBruttes;
		this.primeExoCessRetro = primeExoCessRetro;
		this.primeExoOpNettes = primeExoOpNettes;
		this.pduitFinanciersTitres = pduitFinanciersTitres;
		this.pduitsFinanciersAutres = pduitsFinanciersAutres;
		this.totalPduitsPlcmt = totalPduitsPlcmt;
		this.transfertCharges = transfertCharges;
		this.comRecuCoass = comRecuCoass;
		this.pduitsAcc = pduitsAcc;
		this.totalAutresPduits = totalAutresPduits;
		this.chargesNonImputables = chargesNonImputables;
		this.soldeDebiteur = soldeDebiteur;
		this.totalCred = totalCred;
	}

	@Id
	@Column(name = "CODE_CEG_CREDIT", unique = true, nullable = false, length = 20)
	public String getCodeCegCredit() {
		return this.codeCegCredit;
	}

	public void setCodeCegCredit(String codeCegCredit) {
		this.codeCegCredit = codeCegCredit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_CIMA")
	public EtatCima getEtatCima() {
		return this.etatCima;
	}

	public void setEtatCima(EtatCima etatCima) {
		this.etatCima = etatCima;
	}

	@Column(name = "PRIME_ACC_NET_ANNUL_OP_BRUTTES", precision = 15, scale = 3)
	public BigDecimal getPrimeAccNetAnnulOpBruttes() {
		return this.primeAccNetAnnulOpBruttes;
	}

	public void setPrimeAccNetAnnulOpBruttes(
			BigDecimal primeAccNetAnnulOpBruttes) {
		this.primeAccNetAnnulOpBruttes = primeAccNetAnnulOpBruttes;
	}

	@Column(name = "PRIME_ACC_NET_ANNUL_CESS_RETRO", precision = 15, scale = 3)
	public BigDecimal getPrimeAccNetAnnulCessRetro() {
		return this.primeAccNetAnnulCessRetro;
	}

	public void setPrimeAccNetAnnulCessRetro(
			BigDecimal primeAccNetAnnulCessRetro) {
		this.primeAccNetAnnulCessRetro = primeAccNetAnnulCessRetro;
	}

	@Column(name = "PRIME_ACC_NET_ANNUL_OP_NETTES", precision = 15, scale = 3)
	public BigDecimal getPrimeAccNetAnnulOpNettes() {
		return this.primeAccNetAnnulOpNettes;
	}

	public void setPrimeAccNetAnnulOpNettes(BigDecimal primeAccNetAnnulOpNettes) {
		this.primeAccNetAnnulOpNettes = primeAccNetAnnulOpNettes;
	}

	@Column(name = "PROV_PRIME_OUVERTURE_PRECEDENT_OP_BRUTTES", precision = 15, scale = 3)
	public BigDecimal getProvPrimeOuverturePrecedentOpBruttes() {
		return this.provPrimeOuverturePrecedentOpBruttes;
	}

	public void setProvPrimeOuverturePrecedentOpBruttes(
			BigDecimal provPrimeOuverturePrecedentOpBruttes) {
		this.provPrimeOuverturePrecedentOpBruttes = provPrimeOuverturePrecedentOpBruttes;
	}

	@Column(name = "PROV_PRIME_OUVERTURE_PRECEDENT_CESS_RETRO", precision = 15, scale = 3)
	public BigDecimal getProvPrimeOuverturePrecedentCessRetro() {
		return this.provPrimeOuverturePrecedentCessRetro;
	}

	public void setProvPrimeOuverturePrecedentCessRetro(
			BigDecimal provPrimeOuverturePrecedentCessRetro) {
		this.provPrimeOuverturePrecedentCessRetro = provPrimeOuverturePrecedentCessRetro;
	}

	@Column(name = "PROV_PRIME_OUVERTURE_PRECEDENT_OP_NETTES", precision = 15, scale = 3)
	public BigDecimal getProvPrimeOuverturePrecedentOpNettes() {
		return this.provPrimeOuverturePrecedentOpNettes;
	}

	public void setProvPrimeOuverturePrecedentOpNettes(
			BigDecimal provPrimeOuverturePrecedentOpNettes) {
		this.provPrimeOuverturePrecedentOpNettes = provPrimeOuverturePrecedentOpNettes;
	}

	@Column(name = "PROV_PRIME_CLOTURE_ENCOURS_OP_BRUTTES", precision = 15, scale = 3)
	public BigDecimal getProvPrimeClotureEncoursOpBruttes() {
		return this.provPrimeClotureEncoursOpBruttes;
	}

	public void setProvPrimeClotureEncoursOpBruttes(
			BigDecimal provPrimeClotureEncoursOpBruttes) {
		this.provPrimeClotureEncoursOpBruttes = provPrimeClotureEncoursOpBruttes;
	}

	@Column(name = "PROV_PRIME_CLOTURE_ENCOURS_CESS_RETRO", precision = 15, scale = 3)
	public BigDecimal getProvPrimeClotureEncoursCessRetro() {
		return this.provPrimeClotureEncoursCessRetro;
	}

	public void setProvPrimeClotureEncoursCessRetro(
			BigDecimal provPrimeClotureEncoursCessRetro) {
		this.provPrimeClotureEncoursCessRetro = provPrimeClotureEncoursCessRetro;
	}

	@Column(name = "PROV_PRIME_CLOTURE_ENCOURS_OP_NETTES", precision = 15, scale = 3)
	public BigDecimal getProvPrimeClotureEncoursOpNettes() {
		return this.provPrimeClotureEncoursOpNettes;
	}

	public void setProvPrimeClotureEncoursOpNettes(
			BigDecimal provPrimeClotureEncoursOpNettes) {
		this.provPrimeClotureEncoursOpNettes = provPrimeClotureEncoursOpNettes;
	}

	@Column(name = "PRIME_EXO_OP_BRUTTES", precision = 15, scale = 3)
	public BigDecimal getPrimeExoOpBruttes() {
		return this.primeExoOpBruttes;
	}

	public void setPrimeExoOpBruttes(BigDecimal primeExoOpBruttes) {
		this.primeExoOpBruttes = primeExoOpBruttes;
	}

	@Column(name = "PRIME_EXO_CESS_RETRO", precision = 15, scale = 3)
	public BigDecimal getPrimeExoCessRetro() {
		return this.primeExoCessRetro;
	}

	public void setPrimeExoCessRetro(BigDecimal primeExoCessRetro) {
		this.primeExoCessRetro = primeExoCessRetro;
	}

	@Column(name = "PRIME_EXO_OP_NETTES", precision = 15, scale = 3)
	public BigDecimal getPrimeExoOpNettes() {
		return this.primeExoOpNettes;
	}

	public void setPrimeExoOpNettes(BigDecimal primeExoOpNettes) {
		this.primeExoOpNettes = primeExoOpNettes;
	}

	@Column(name = "PDUIT_FINANCIERS_TITRES", precision = 15, scale = 3)
	public BigDecimal getPduitFinanciersTitres() {
		return this.pduitFinanciersTitres;
	}

	public void setPduitFinanciersTitres(BigDecimal pduitFinanciersTitres) {
		this.pduitFinanciersTitres = pduitFinanciersTitres;
	}

	@Column(name = "PDUITS_FINANCIERS_AUTRES", precision = 15, scale = 3)
	public BigDecimal getPduitsFinanciersAutres() {
		return this.pduitsFinanciersAutres;
	}

	public void setPduitsFinanciersAutres(BigDecimal pduitsFinanciersAutres) {
		this.pduitsFinanciersAutres = pduitsFinanciersAutres;
	}

	@Column(name = "TOTAL_PDUITS_PLCMT", precision = 15, scale = 3)
	public BigDecimal getTotalPduitsPlcmt() {
		return this.totalPduitsPlcmt;
	}

	public void setTotalPduitsPlcmt(BigDecimal totalPduitsPlcmt) {
		this.totalPduitsPlcmt = totalPduitsPlcmt;
	}

	@Column(name = "TRANSFERT_CHARGES", precision = 15, scale = 3)
	public BigDecimal getTransfertCharges() {
		return this.transfertCharges;
	}

	public void setTransfertCharges(BigDecimal transfertCharges) {
		this.transfertCharges = transfertCharges;
	}

	@Column(name = "COM_RECU_COASS", precision = 15, scale = 3)
	public BigDecimal getComRecuCoass() {
		return this.comRecuCoass;
	}

	public void setComRecuCoass(BigDecimal comRecuCoass) {
		this.comRecuCoass = comRecuCoass;
	}

	@Column(name = "PDUITS_ACC", precision = 15, scale = 3)
	public BigDecimal getPduitsAcc() {
		return this.pduitsAcc;
	}

	public void setPduitsAcc(BigDecimal pduitsAcc) {
		this.pduitsAcc = pduitsAcc;
	}

	@Column(name = "TOTAL_AUTRES_PDUITS", precision = 15, scale = 3)
	public BigDecimal getTotalAutresPduits() {
		return this.totalAutresPduits;
	}

	public void setTotalAutresPduits(BigDecimal totalAutresPduits) {
		this.totalAutresPduits = totalAutresPduits;
	}

	@Column(name = "CHARGES_NON_IMPUTABLES", precision = 15, scale = 3)
	public BigDecimal getChargesNonImputables() {
		return this.chargesNonImputables;
	}

	public void setChargesNonImputables(BigDecimal chargesNonImputables) {
		this.chargesNonImputables = chargesNonImputables;
	}

	@Column(name = "SOLDE_DEBITEUR", precision = 15, scale = 3)
	public BigDecimal getSoldeDebiteur() {
		return this.soldeDebiteur;
	}

	public void setSoldeDebiteur(BigDecimal soldeDebiteur) {
		this.soldeDebiteur = soldeDebiteur;
	}

	@Column(name = "TOTAL_CRED", precision = 15, scale = 3)
	public BigDecimal getTotalCred() {
		return this.totalCred;
	}

	public void setTotalCred(BigDecimal totalCred) {
		this.totalCred = totalCred;
	}

}
