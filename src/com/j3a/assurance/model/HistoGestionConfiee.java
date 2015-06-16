package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

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
 * HistoGestionConfiee generated by hbm2java
 */
@Entity
@Table(name = "histo_gestion_confiee", catalog = "zeusbd")
public class HistoGestionConfiee implements java.io.Serializable {

	private String codeHistoGc;
	private GestionConfiee gestionConfiee;
	private Date dateHistoGc;
	private String histoCodeGestionConfie;
	private String histoNumIdentificationGc;
	private String histoNatureGc;
	private String histoDescriptionGc;
	private String histoTerritorialiteGc;
	private String histoTauxCouvGc;
	private BigDecimal histoPlanfondAnnuelGc;
	private Long histoTauxAjustGc;
	private Integer histoNbreChefFamille;
	private Integer histoNbrRetChefFamille;
	private BigDecimal histoPrimeChefFamille;
	private BigDecimal histoPrimeRetChefFamille;
	private BigDecimal histoPrimeTotChefFamille;
	private Integer histoNbreConjointGc;
	private Integer histoNbreRetConjoint;
	private BigDecimal histoPrimeConjoint;
	private BigDecimal histoPrimeRetConjoint;
	private BigDecimal histoPrimeTotConjoint;
	private Integer histoNbreEnftMaj;
	private Integer histoNbreRetEnftMaj;
	private BigDecimal histoPrimeEnftMaj;
	private BigDecimal histoPrimeRetEnftMaj;
	private BigDecimal histoPrimeTotEnftMaj;
	private Integer histoNbreEnftGc;
	private Integer histoNbreRetEnftGc;
	private BigDecimal histoPrimeEnfant;
	private BigDecimal histoPrimeRetEnftGc;
	private BigDecimal histoPrimeTotEnftGc;

	public HistoGestionConfiee() {
	}

	public HistoGestionConfiee(String codeHistoGc, String histoCodeGestionConfie) {
		this.codeHistoGc = codeHistoGc;
		this.histoCodeGestionConfie = histoCodeGestionConfie;
	}

	public HistoGestionConfiee(String codeHistoGc,
			GestionConfiee gestionConfiee, Date dateHistoGc,
			String histoCodeGestionConfie, String histoNumIdentificationGc,
			String histoNatureGc, String histoDescriptionGc,
			String histoTerritorialiteGc, String histoTauxCouvGc,
			BigDecimal histoPlanfondAnnuelGc, Long histoTauxAjustGc,
			Integer histoNbreChefFamille, Integer histoNbrRetChefFamille,
			BigDecimal histoPrimeChefFamille,
			BigDecimal histoPrimeRetChefFamille,
			BigDecimal histoPrimeTotChefFamille, Integer histoNbreConjointGc,
			Integer histoNbreRetConjoint, BigDecimal histoPrimeConjoint,
			BigDecimal histoPrimeRetConjoint, BigDecimal histoPrimeTotConjoint,
			Integer histoNbreEnftMaj, Integer histoNbreRetEnftMaj,
			BigDecimal histoPrimeEnftMaj, BigDecimal histoPrimeRetEnftMaj,
			BigDecimal histoPrimeTotEnftMaj, Integer histoNbreEnftGc,
			Integer histoNbreRetEnftGc, BigDecimal histoPrimeEnfant,
			BigDecimal histoPrimeRetEnftGc, BigDecimal histoPrimeTotEnftGc) {
		this.codeHistoGc = codeHistoGc;
		this.gestionConfiee = gestionConfiee;
		this.dateHistoGc = dateHistoGc;
		this.histoCodeGestionConfie = histoCodeGestionConfie;
		this.histoNumIdentificationGc = histoNumIdentificationGc;
		this.histoNatureGc = histoNatureGc;
		this.histoDescriptionGc = histoDescriptionGc;
		this.histoTerritorialiteGc = histoTerritorialiteGc;
		this.histoTauxCouvGc = histoTauxCouvGc;
		this.histoPlanfondAnnuelGc = histoPlanfondAnnuelGc;
		this.histoTauxAjustGc = histoTauxAjustGc;
		this.histoNbreChefFamille = histoNbreChefFamille;
		this.histoNbrRetChefFamille = histoNbrRetChefFamille;
		this.histoPrimeChefFamille = histoPrimeChefFamille;
		this.histoPrimeRetChefFamille = histoPrimeRetChefFamille;
		this.histoPrimeTotChefFamille = histoPrimeTotChefFamille;
		this.histoNbreConjointGc = histoNbreConjointGc;
		this.histoNbreRetConjoint = histoNbreRetConjoint;
		this.histoPrimeConjoint = histoPrimeConjoint;
		this.histoPrimeRetConjoint = histoPrimeRetConjoint;
		this.histoPrimeTotConjoint = histoPrimeTotConjoint;
		this.histoNbreEnftMaj = histoNbreEnftMaj;
		this.histoNbreRetEnftMaj = histoNbreRetEnftMaj;
		this.histoPrimeEnftMaj = histoPrimeEnftMaj;
		this.histoPrimeRetEnftMaj = histoPrimeRetEnftMaj;
		this.histoPrimeTotEnftMaj = histoPrimeTotEnftMaj;
		this.histoNbreEnftGc = histoNbreEnftGc;
		this.histoNbreRetEnftGc = histoNbreRetEnftGc;
		this.histoPrimeEnfant = histoPrimeEnfant;
		this.histoPrimeRetEnftGc = histoPrimeRetEnftGc;
		this.histoPrimeTotEnftGc = histoPrimeTotEnftGc;
	}

	@Id
	@Column(name = "CODE_HISTO_GC", unique = true, nullable = false, length = 60)
	public String getCodeHistoGc() {
		return this.codeHistoGc;
	}

	public void setCodeHistoGc(String codeHistoGc) {
		this.codeHistoGc = codeHistoGc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_GESTION_CONFIE")
	public GestionConfiee getGestionConfiee() {
		return this.gestionConfiee;
	}

	public void setGestionConfiee(GestionConfiee gestionConfiee) {
		this.gestionConfiee = gestionConfiee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_HISTO_GC", length = 19)
	public Date getDateHistoGc() {
		return this.dateHistoGc;
	}

	public void setDateHistoGc(Date dateHistoGc) {
		this.dateHistoGc = dateHistoGc;
	}

	@Column(name = "HISTO_CODE_GESTION_CONFIE", nullable = false, length = 60)
	public String getHistoCodeGestionConfie() {
		return this.histoCodeGestionConfie;
	}

	public void setHistoCodeGestionConfie(String histoCodeGestionConfie) {
		this.histoCodeGestionConfie = histoCodeGestionConfie;
	}

	@Column(name = "HISTO_NUM_IDENTIFICATION_GC", length = 20)
	public String getHistoNumIdentificationGc() {
		return this.histoNumIdentificationGc;
	}

	public void setHistoNumIdentificationGc(String histoNumIdentificationGc) {
		this.histoNumIdentificationGc = histoNumIdentificationGc;
	}

	@Column(name = "HISTO_NATURE_GC", length = 60)
	public String getHistoNatureGc() {
		return this.histoNatureGc;
	}

	public void setHistoNatureGc(String histoNatureGc) {
		this.histoNatureGc = histoNatureGc;
	}

	@Column(name = "HISTO_DESCRIPTION_GC", length = 60)
	public String getHistoDescriptionGc() {
		return this.histoDescriptionGc;
	}

	public void setHistoDescriptionGc(String histoDescriptionGc) {
		this.histoDescriptionGc = histoDescriptionGc;
	}

	@Column(name = "HISTO_TERRITORIALITE_GC", length = 60)
	public String getHistoTerritorialiteGc() {
		return this.histoTerritorialiteGc;
	}

	public void setHistoTerritorialiteGc(String histoTerritorialiteGc) {
		this.histoTerritorialiteGc = histoTerritorialiteGc;
	}

	@Column(name = "HISTO_TAUX_COUV_GC", length = 80)
	public String getHistoTauxCouvGc() {
		return this.histoTauxCouvGc;
	}

	public void setHistoTauxCouvGc(String histoTauxCouvGc) {
		this.histoTauxCouvGc = histoTauxCouvGc;
	}

	@Column(name = "HISTO_PLANFOND_ANNUEL_GC", precision = 15, scale = 3)
	public BigDecimal getHistoPlanfondAnnuelGc() {
		return this.histoPlanfondAnnuelGc;
	}

	public void setHistoPlanfondAnnuelGc(BigDecimal histoPlanfondAnnuelGc) {
		this.histoPlanfondAnnuelGc = histoPlanfondAnnuelGc;
	}

	@Column(name = "HISTO_TAUX_AJUST_GC", precision = 10, scale = 0)
	public Long getHistoTauxAjustGc() {
		return this.histoTauxAjustGc;
	}

	public void setHistoTauxAjustGc(Long histoTauxAjustGc) {
		this.histoTauxAjustGc = histoTauxAjustGc;
	}

	@Column(name = "HISTO_NBRE_CHEF_FAMILLE")
	public Integer getHistoNbreChefFamille() {
		return this.histoNbreChefFamille;
	}

	public void setHistoNbreChefFamille(Integer histoNbreChefFamille) {
		this.histoNbreChefFamille = histoNbreChefFamille;
	}

	@Column(name = "HISTO_NBR_RET_CHEF_FAMILLE")
	public Integer getHistoNbrRetChefFamille() {
		return this.histoNbrRetChefFamille;
	}

	public void setHistoNbrRetChefFamille(Integer histoNbrRetChefFamille) {
		this.histoNbrRetChefFamille = histoNbrRetChefFamille;
	}

	@Column(name = "HISTO_PRIME_CHEF_FAMILLE", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeChefFamille() {
		return this.histoPrimeChefFamille;
	}

	public void setHistoPrimeChefFamille(BigDecimal histoPrimeChefFamille) {
		this.histoPrimeChefFamille = histoPrimeChefFamille;
	}

	@Column(name = "HISTO_PRIME_RET_CHEF_FAMILLE", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeRetChefFamille() {
		return this.histoPrimeRetChefFamille;
	}

	public void setHistoPrimeRetChefFamille(BigDecimal histoPrimeRetChefFamille) {
		this.histoPrimeRetChefFamille = histoPrimeRetChefFamille;
	}

	@Column(name = "HISTO_PRIME_TOT_CHEF_FAMILLE", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeTotChefFamille() {
		return this.histoPrimeTotChefFamille;
	}

	public void setHistoPrimeTotChefFamille(BigDecimal histoPrimeTotChefFamille) {
		this.histoPrimeTotChefFamille = histoPrimeTotChefFamille;
	}

	@Column(name = "HISTO_NBRE_CONJOINT_GC")
	public Integer getHistoNbreConjointGc() {
		return this.histoNbreConjointGc;
	}

	public void setHistoNbreConjointGc(Integer histoNbreConjointGc) {
		this.histoNbreConjointGc = histoNbreConjointGc;
	}

	@Column(name = "HISTO_NBRE_RET_CONJOINT")
	public Integer getHistoNbreRetConjoint() {
		return this.histoNbreRetConjoint;
	}

	public void setHistoNbreRetConjoint(Integer histoNbreRetConjoint) {
		this.histoNbreRetConjoint = histoNbreRetConjoint;
	}

	@Column(name = "HISTO_PRIME_CONJOINT", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeConjoint() {
		return this.histoPrimeConjoint;
	}

	public void setHistoPrimeConjoint(BigDecimal histoPrimeConjoint) {
		this.histoPrimeConjoint = histoPrimeConjoint;
	}

	@Column(name = "HISTO_PRIME_RET_CONJOINT", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeRetConjoint() {
		return this.histoPrimeRetConjoint;
	}

	public void setHistoPrimeRetConjoint(BigDecimal histoPrimeRetConjoint) {
		this.histoPrimeRetConjoint = histoPrimeRetConjoint;
	}

	@Column(name = "HISTO_PRIME_TOT_CONJOINT", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeTotConjoint() {
		return this.histoPrimeTotConjoint;
	}

	public void setHistoPrimeTotConjoint(BigDecimal histoPrimeTotConjoint) {
		this.histoPrimeTotConjoint = histoPrimeTotConjoint;
	}

	@Column(name = "HISTO_NBRE_ENFT_MAJ")
	public Integer getHistoNbreEnftMaj() {
		return this.histoNbreEnftMaj;
	}

	public void setHistoNbreEnftMaj(Integer histoNbreEnftMaj) {
		this.histoNbreEnftMaj = histoNbreEnftMaj;
	}

	@Column(name = "HISTO_NBRE_RET_ENFT_MAJ")
	public Integer getHistoNbreRetEnftMaj() {
		return this.histoNbreRetEnftMaj;
	}

	public void setHistoNbreRetEnftMaj(Integer histoNbreRetEnftMaj) {
		this.histoNbreRetEnftMaj = histoNbreRetEnftMaj;
	}

	@Column(name = "HISTO_PRIME_ENFT_MAJ", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeEnftMaj() {
		return this.histoPrimeEnftMaj;
	}

	public void setHistoPrimeEnftMaj(BigDecimal histoPrimeEnftMaj) {
		this.histoPrimeEnftMaj = histoPrimeEnftMaj;
	}

	@Column(name = "HISTO_PRIME_RET_ENFT_MAJ", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeRetEnftMaj() {
		return this.histoPrimeRetEnftMaj;
	}

	public void setHistoPrimeRetEnftMaj(BigDecimal histoPrimeRetEnftMaj) {
		this.histoPrimeRetEnftMaj = histoPrimeRetEnftMaj;
	}

	@Column(name = "HISTO_PRIME_TOT_ENFT_MAJ", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeTotEnftMaj() {
		return this.histoPrimeTotEnftMaj;
	}

	public void setHistoPrimeTotEnftMaj(BigDecimal histoPrimeTotEnftMaj) {
		this.histoPrimeTotEnftMaj = histoPrimeTotEnftMaj;
	}

	@Column(name = "HISTO_NBRE_ENFT_GC")
	public Integer getHistoNbreEnftGc() {
		return this.histoNbreEnftGc;
	}

	public void setHistoNbreEnftGc(Integer histoNbreEnftGc) {
		this.histoNbreEnftGc = histoNbreEnftGc;
	}

	@Column(name = "HISTO_NBRE_RET_ENFT_GC")
	public Integer getHistoNbreRetEnftGc() {
		return this.histoNbreRetEnftGc;
	}

	public void setHistoNbreRetEnftGc(Integer histoNbreRetEnftGc) {
		this.histoNbreRetEnftGc = histoNbreRetEnftGc;
	}

	@Column(name = "HISTO_PRIME_ENFANT", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeEnfant() {
		return this.histoPrimeEnfant;
	}

	public void setHistoPrimeEnfant(BigDecimal histoPrimeEnfant) {
		this.histoPrimeEnfant = histoPrimeEnfant;
	}

	@Column(name = "HISTO_PRIME_RET_ENFT_GC", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeRetEnftGc() {
		return this.histoPrimeRetEnftGc;
	}

	public void setHistoPrimeRetEnftGc(BigDecimal histoPrimeRetEnftGc) {
		this.histoPrimeRetEnftGc = histoPrimeRetEnftGc;
	}

	@Column(name = "HISTO_PRIME_TOT_ENFT_GC", precision = 15, scale = 3)
	public BigDecimal getHistoPrimeTotEnftGc() {
		return this.histoPrimeTotEnftGc;
	}

	public void setHistoPrimeTotEnftGc(BigDecimal histoPrimeTotEnftGc) {
		this.histoPrimeTotEnftGc = histoPrimeTotEnftGc;
	}

}
