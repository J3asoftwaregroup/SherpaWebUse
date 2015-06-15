package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

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
 * GarantieChoisieTransport generated by hbm2java
 */
@Entity
@Table(name = "garantie_choisie_transport", catalog = "zeusbd")
public class GarantieChoisieTransport implements java.io.Serializable {

	private String codeGarantieChoisieTransport;
	private Aliment aliment;
	private String libelleGarantieChosie;
	private Date dateGarantieChoisie;
	private BigDecimal montantGaranties;
	private BigDecimal accessoiretrsp;
	private String codeAvenantTransport;
	private Set garantieGarantieChoisieTransports = new HashSet(0);

	public GarantieChoisieTransport() {
	}

	public GarantieChoisieTransport(String codeGarantieChoisieTransport) {
		this.codeGarantieChoisieTransport = codeGarantieChoisieTransport;
	}

	public GarantieChoisieTransport(String codeGarantieChoisieTransport,
			Aliment aliment, String libelleGarantieChosie,
			Date dateGarantieChoisie, BigDecimal montantGaranties,
			BigDecimal accessoiretrsp, String codeAvenantTransport,
			Set garantieGarantieChoisieTransports) {
		this.codeGarantieChoisieTransport = codeGarantieChoisieTransport;
		this.aliment = aliment;
		this.libelleGarantieChosie = libelleGarantieChosie;
		this.dateGarantieChoisie = dateGarantieChoisie;
		this.montantGaranties = montantGaranties;
		this.accessoiretrsp = accessoiretrsp;
		this.codeAvenantTransport = codeAvenantTransport;
		this.garantieGarantieChoisieTransports = garantieGarantieChoisieTransports;
	}

	@Id
	@Column(name = "CODE_GARANTIE_CHOISIE_TRANSPORT", unique = true, nullable = false, length = 40)
	public String getCodeGarantieChoisieTransport() {
		return this.codeGarantieChoisieTransport;
	}

	public void setCodeGarantieChoisieTransport(
			String codeGarantieChoisieTransport) {
		this.codeGarantieChoisieTransport = codeGarantieChoisieTransport;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ALIMENT")
	public Aliment getAliment() {
		return this.aliment;
	}

	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}

	@Column(name = "LIBELLE_GARANTIE_CHOSIE", length = 70)
	public String getLibelleGarantieChosie() {
		return this.libelleGarantieChosie;
	}

	public void setLibelleGarantieChosie(String libelleGarantieChosie) {
		this.libelleGarantieChosie = libelleGarantieChosie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_GARANTIE_CHOISIE", length = 10)
	public Date getDateGarantieChoisie() {
		return this.dateGarantieChoisie;
	}

	public void setDateGarantieChoisie(Date dateGarantieChoisie) {
		this.dateGarantieChoisie = dateGarantieChoisie;
	}

	@Column(name = "MONTANT_GARANTIES", precision = 15, scale = 3)
	public BigDecimal getMontantGaranties() {
		return this.montantGaranties;
	}

	public void setMontantGaranties(BigDecimal montantGaranties) {
		this.montantGaranties = montantGaranties;
	}

	@Column(name = "ACCESSOIRETRSP", precision = 15, scale = 3)
	public BigDecimal getAccessoiretrsp() {
		return this.accessoiretrsp;
	}

	public void setAccessoiretrsp(BigDecimal accessoiretrsp) {
		this.accessoiretrsp = accessoiretrsp;
	}

	@Column(name = "CODE_AVENANT_TRANSPORT", length = 28)
	public String getCodeAvenantTransport() {
		return this.codeAvenantTransport;
	}

	public void setCodeAvenantTransport(String codeAvenantTransport) {
		this.codeAvenantTransport = codeAvenantTransport;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "garantieChoisieTransport")
	public Set getGarantieGarantieChoisieTransports() {
		return this.garantieGarantieChoisieTransports;
	}

	public void setGarantieGarantieChoisieTransports(
			Set garantieGarantieChoisieTransports) {
		this.garantieGarantieChoisieTransports = garantieGarantieChoisieTransports;
	}

}
