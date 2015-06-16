package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

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
 * GarantieGarantieChoisieNta generated by hbm2java
 */
@Entity
@Table(name = "garantie_garantie_choisie_nta", catalog = "zeusbd")
public class GarantieGarantieChoisieNta implements java.io.Serializable {

	private GarantieGarantieChoisieNtaId id;
	private Garantie garantie;
	private GarantieChoisieNta garantieChoisieNta;
	private BigDecimal primeAnnuelleNta;
	private String natureNta;
	private BigDecimal tauxNta;
	private BigDecimal maximumNta;
	private BigDecimal minimumNta;
	private BigDecimal primeNetteNta;
	private BigDecimal tauxFranchiseNta;
	private BigDecimal reductionNta;
	private String smpNta;
	private BigDecimal tauxPrimeNta;
	private BigDecimal tauxLciNta;
	private BigDecimal tauxRedNta;
	private BigDecimal tauxGesNta;
	private BigDecimal tauxComNta;
	private BigDecimal tauxintermNta;
	private BigDecimal tauxConsNta;
	private BigDecimal tauxredfranchNta;
	private BigDecimal tauxcouvNta;
	private String observationNta;
	private Date dateGarantieGarantieChoisieNta;
	private BigDecimal facteurNta;
	private BigDecimal franchiseNta;
	private BigDecimal capitalNta;

	public GarantieGarantieChoisieNta() {
	}

	public GarantieGarantieChoisieNta(GarantieGarantieChoisieNtaId id,
			Garantie garantie, GarantieChoisieNta garantieChoisieNta) {
		this.id = id;
		this.garantie = garantie;
		this.garantieChoisieNta = garantieChoisieNta;
	}

	public GarantieGarantieChoisieNta(GarantieGarantieChoisieNtaId id,
			Garantie garantie, GarantieChoisieNta garantieChoisieNta,
			BigDecimal primeAnnuelleNta, String natureNta, BigDecimal tauxNta,
			BigDecimal maximumNta, BigDecimal minimumNta,
			BigDecimal primeNetteNta, BigDecimal tauxFranchiseNta,
			BigDecimal reductionNta, String smpNta, BigDecimal tauxPrimeNta,
			BigDecimal tauxLciNta, BigDecimal tauxRedNta,
			BigDecimal tauxGesNta, BigDecimal tauxComNta,
			BigDecimal tauxintermNta, BigDecimal tauxConsNta,
			BigDecimal tauxredfranchNta, BigDecimal tauxcouvNta,
			String observationNta, Date dateGarantieGarantieChoisieNta,
			BigDecimal facteurNta, BigDecimal franchiseNta,
			BigDecimal capitalNta) {
		this.id = id;
		this.garantie = garantie;
		this.garantieChoisieNta = garantieChoisieNta;
		this.primeAnnuelleNta = primeAnnuelleNta;
		this.natureNta = natureNta;
		this.tauxNta = tauxNta;
		this.maximumNta = maximumNta;
		this.minimumNta = minimumNta;
		this.primeNetteNta = primeNetteNta;
		this.tauxFranchiseNta = tauxFranchiseNta;
		this.reductionNta = reductionNta;
		this.smpNta = smpNta;
		this.tauxPrimeNta = tauxPrimeNta;
		this.tauxLciNta = tauxLciNta;
		this.tauxRedNta = tauxRedNta;
		this.tauxGesNta = tauxGesNta;
		this.tauxComNta = tauxComNta;
		this.tauxintermNta = tauxintermNta;
		this.tauxConsNta = tauxConsNta;
		this.tauxredfranchNta = tauxredfranchNta;
		this.tauxcouvNta = tauxcouvNta;
		this.observationNta = observationNta;
		this.dateGarantieGarantieChoisieNta = dateGarantieGarantieChoisieNta;
		this.facteurNta = facteurNta;
		this.franchiseNta = franchiseNta;
		this.capitalNta = capitalNta;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeGarantie", column = @Column(name = "CODE_GARANTIE", nullable = false, length = 12)),
			@AttributeOverride(name = "codeGarantieChoisienta", column = @Column(name = "CODE_GARANTIE_CHOISIENTA", nullable = false, length = 35)) })
	public GarantieGarantieChoisieNtaId getId() {
		return this.id;
	}

	public void setId(GarantieGarantieChoisieNtaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_GARANTIE", nullable = false, insertable = false, updatable = false)
	public Garantie getGarantie() {
		return this.garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_GARANTIE_CHOISIENTA", nullable = false, insertable = false, updatable = false)
	public GarantieChoisieNta getGarantieChoisieNta() {
		return this.garantieChoisieNta;
	}

	public void setGarantieChoisieNta(GarantieChoisieNta garantieChoisieNta) {
		this.garantieChoisieNta = garantieChoisieNta;
	}

	@Column(name = "PRIME_ANNUELLE_NTA", precision = 15, scale = 3)
	public BigDecimal getPrimeAnnuelleNta() {
		return this.primeAnnuelleNta;
	}

	public void setPrimeAnnuelleNta(BigDecimal primeAnnuelleNta) {
		this.primeAnnuelleNta = primeAnnuelleNta;
	}

	@Column(name = "NATURE_NTA", length = 50)
	public String getNatureNta() {
		return this.natureNta;
	}

	public void setNatureNta(String natureNta) {
		this.natureNta = natureNta;
	}

	@Column(name = "TAUX_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxNta() {
		return this.tauxNta;
	}

	public void setTauxNta(BigDecimal tauxNta) {
		this.tauxNta = tauxNta;
	}

	@Column(name = "MAXIMUM_NTA", precision = 15, scale = 3)
	public BigDecimal getMaximumNta() {
		return this.maximumNta;
	}

	public void setMaximumNta(BigDecimal maximumNta) {
		this.maximumNta = maximumNta;
	}

	@Column(name = "MINIMUM_NTA", precision = 15, scale = 3)
	public BigDecimal getMinimumNta() {
		return this.minimumNta;
	}

	public void setMinimumNta(BigDecimal minimumNta) {
		this.minimumNta = minimumNta;
	}

	@Column(name = "PRIME_NETTE_NTA", precision = 15, scale = 3)
	public BigDecimal getPrimeNetteNta() {
		return this.primeNetteNta;
	}

	public void setPrimeNetteNta(BigDecimal primeNetteNta) {
		this.primeNetteNta = primeNetteNta;
	}

	@Column(name = "TAUX_FRANCHISE_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxFranchiseNta() {
		return this.tauxFranchiseNta;
	}

	public void setTauxFranchiseNta(BigDecimal tauxFranchiseNta) {
		this.tauxFranchiseNta = tauxFranchiseNta;
	}

	@Column(name = "REDUCTION_NTA", precision = 15, scale = 3)
	public BigDecimal getReductionNta() {
		return this.reductionNta;
	}

	public void setReductionNta(BigDecimal reductionNta) {
		this.reductionNta = reductionNta;
	}

	@Column(name = "SMP_NTA", length = 30)
	public String getSmpNta() {
		return this.smpNta;
	}

	public void setSmpNta(String smpNta) {
		this.smpNta = smpNta;
	}

	@Column(name = "TAUX_PRIME_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxPrimeNta() {
		return this.tauxPrimeNta;
	}

	public void setTauxPrimeNta(BigDecimal tauxPrimeNta) {
		this.tauxPrimeNta = tauxPrimeNta;
	}

	@Column(name = "TAUX_LCI_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxLciNta() {
		return this.tauxLciNta;
	}

	public void setTauxLciNta(BigDecimal tauxLciNta) {
		this.tauxLciNta = tauxLciNta;
	}

	@Column(name = "TAUX_RED_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxRedNta() {
		return this.tauxRedNta;
	}

	public void setTauxRedNta(BigDecimal tauxRedNta) {
		this.tauxRedNta = tauxRedNta;
	}

	@Column(name = "TAUX_GES_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxGesNta() {
		return this.tauxGesNta;
	}

	public void setTauxGesNta(BigDecimal tauxGesNta) {
		this.tauxGesNta = tauxGesNta;
	}

	@Column(name = "TAUX_COM_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxComNta() {
		return this.tauxComNta;
	}

	public void setTauxComNta(BigDecimal tauxComNta) {
		this.tauxComNta = tauxComNta;
	}

	@Column(name = "TAUXINTERM_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxintermNta() {
		return this.tauxintermNta;
	}

	public void setTauxintermNta(BigDecimal tauxintermNta) {
		this.tauxintermNta = tauxintermNta;
	}

	@Column(name = "TAUX_CONS_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxConsNta() {
		return this.tauxConsNta;
	}

	public void setTauxConsNta(BigDecimal tauxConsNta) {
		this.tauxConsNta = tauxConsNta;
	}

	@Column(name = "TAUXREDFRANCH_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxredfranchNta() {
		return this.tauxredfranchNta;
	}

	public void setTauxredfranchNta(BigDecimal tauxredfranchNta) {
		this.tauxredfranchNta = tauxredfranchNta;
	}

	@Column(name = "TAUXCOUV_NTA", precision = 6, scale = 4)
	public BigDecimal getTauxcouvNta() {
		return this.tauxcouvNta;
	}

	public void setTauxcouvNta(BigDecimal tauxcouvNta) {
		this.tauxcouvNta = tauxcouvNta;
	}

	@Column(name = "OBSERVATION_NTA", length = 50)
	public String getObservationNta() {
		return this.observationNta;
	}

	public void setObservationNta(String observationNta) {
		this.observationNta = observationNta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_GARANTIE_GARANTIE_CHOISIE_NTA", length = 10)
	public Date getDateGarantieGarantieChoisieNta() {
		return this.dateGarantieGarantieChoisieNta;
	}

	public void setDateGarantieGarantieChoisieNta(
			Date dateGarantieGarantieChoisieNta) {
		this.dateGarantieGarantieChoisieNta = dateGarantieGarantieChoisieNta;
	}

	@Column(name = "FACTEUR_NTA", precision = 15, scale = 3)
	public BigDecimal getFacteurNta() {
		return this.facteurNta;
	}

	public void setFacteurNta(BigDecimal facteurNta) {
		this.facteurNta = facteurNta;
	}

	@Column(name = "FRANCHISE_NTA", precision = 15, scale = 3)
	public BigDecimal getFranchiseNta() {
		return this.franchiseNta;
	}

	public void setFranchiseNta(BigDecimal franchiseNta) {
		this.franchiseNta = franchiseNta;
	}

	@Column(name = "CAPITAL_NTA", precision = 15, scale = 3)
	public BigDecimal getCapitalNta() {
		return this.capitalNta;
	}

	public void setCapitalNta(BigDecimal capitalNta) {
		this.capitalNta = capitalNta;
	}

}
