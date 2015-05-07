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
 * GarantieChoisieTransportCorps generated by hbm2java
 */
@Entity
@Table(name = "garantie_choisie_transport_corps", catalog = "zeusbd")
public class GarantieChoisieTransportCorps implements java.io.Serializable {

	private String codeGrtieChoisieTrspCorps;
	private CorpsEngin corpsEngin;
	private String libelleGarantieChoisieCorps;
	private Date dateGarantieChoisieCorps;
	private BigDecimal montantGarantieCorps;
	private BigDecimal accessoirecorps;
	private String codeAvenantCorps;
	private Set<GarantieGarantieChoisieCorps> garantieGarantieChoisieCorpses = new HashSet<GarantieGarantieChoisieCorps>(
			0);

	public GarantieChoisieTransportCorps() {
	}

	public GarantieChoisieTransportCorps(String codeGrtieChoisieTrspCorps) {
		this.codeGrtieChoisieTrspCorps = codeGrtieChoisieTrspCorps;
	}

	public GarantieChoisieTransportCorps(String codeGrtieChoisieTrspCorps,
			CorpsEngin corpsEngin, String libelleGarantieChoisieCorps,
			Date dateGarantieChoisieCorps, BigDecimal montantGarantieCorps,
			BigDecimal accessoirecorps, String codeAvenantCorps,
			Set<GarantieGarantieChoisieCorps> garantieGarantieChoisieCorpses) {
		this.codeGrtieChoisieTrspCorps = codeGrtieChoisieTrspCorps;
		this.corpsEngin = corpsEngin;
		this.libelleGarantieChoisieCorps = libelleGarantieChoisieCorps;
		this.dateGarantieChoisieCorps = dateGarantieChoisieCorps;
		this.montantGarantieCorps = montantGarantieCorps;
		this.accessoirecorps = accessoirecorps;
		this.codeAvenantCorps = codeAvenantCorps;
		this.garantieGarantieChoisieCorpses = garantieGarantieChoisieCorpses;
	}

	@Id
	@Column(name = "CODE_GRTIE_CHOISIE_TRSP_CORPS", unique = true, nullable = false, length = 35)
	public String getCodeGrtieChoisieTrspCorps() {
		return this.codeGrtieChoisieTrspCorps;
	}

	public void setCodeGrtieChoisieTrspCorps(String codeGrtieChoisieTrspCorps) {
		this.codeGrtieChoisieTrspCorps = codeGrtieChoisieTrspCorps;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ENGIN")
	public CorpsEngin getCorpsEngin() {
		return this.corpsEngin;
	}

	public void setCorpsEngin(CorpsEngin corpsEngin) {
		this.corpsEngin = corpsEngin;
	}

	@Column(name = "LIBELLE_GARANTIE_CHOISIE_CORPS", length = 50)
	public String getLibelleGarantieChoisieCorps() {
		return this.libelleGarantieChoisieCorps;
	}

	public void setLibelleGarantieChoisieCorps(
			String libelleGarantieChoisieCorps) {
		this.libelleGarantieChoisieCorps = libelleGarantieChoisieCorps;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_GARANTIE_CHOISIE_CORPS", length = 10)
	public Date getDateGarantieChoisieCorps() {
		return this.dateGarantieChoisieCorps;
	}

	public void setDateGarantieChoisieCorps(Date dateGarantieChoisieCorps) {
		this.dateGarantieChoisieCorps = dateGarantieChoisieCorps;
	}

	@Column(name = "MONTANT_GARANTIE_CORPS", precision = 15, scale = 3)
	public BigDecimal getMontantGarantieCorps() {
		return this.montantGarantieCorps;
	}

	public void setMontantGarantieCorps(BigDecimal montantGarantieCorps) {
		this.montantGarantieCorps = montantGarantieCorps;
	}

	@Column(name = "ACCESSOIRECORPS", precision = 15, scale = 3)
	public BigDecimal getAccessoirecorps() {
		return this.accessoirecorps;
	}

	public void setAccessoirecorps(BigDecimal accessoirecorps) {
		this.accessoirecorps = accessoirecorps;
	}

	@Column(name = "CODE_AVENANT_CORPS", length = 28)
	public String getCodeAvenantCorps() {
		return this.codeAvenantCorps;
	}

	public void setCodeAvenantCorps(String codeAvenantCorps) {
		this.codeAvenantCorps = codeAvenantCorps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "garantieChoisieTransportCorps")
	public Set<GarantieGarantieChoisieCorps> getGarantieGarantieChoisieCorpses() {
		return this.garantieGarantieChoisieCorpses;
	}

	public void setGarantieGarantieChoisieCorpses(
			Set<GarantieGarantieChoisieCorps> garantieGarantieChoisieCorpses) {
		this.garantieGarantieChoisieCorpses = garantieGarantieChoisieCorpses;
	}

}
