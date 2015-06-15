package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

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
 * Victime generated by hbm2java
 */
@Entity
@Table(name = "victime", catalog = "zeusbd")
public class Victime implements java.io.Serializable {

	private String numVictime;
	private Recours recours;
	private Sinistre sinistre;
	private String nomVictime;
	private String prenomVictime;
	private Date dateNaissVictime;
	private String adresseVictime;
	private String professionVictime;
	private String etatVictime;
	private BigDecimal sommePrejudice;
	private Boolean etatIndemniser;
	private Set<Prejudice> prejudices = new HashSet<Prejudice>(0);
	private Set<ActeMedical> acteMedicals = new HashSet<ActeMedical>(0);
	private Set<AyantDroit> ayantDroits = new HashSet<AyantDroit>(0);
	private Set<ReglementSinistre> reglementSinistres = new HashSet<ReglementSinistre>(
			0);

	public Victime() {
	}

	public Victime(String numVictime, Sinistre sinistre) {
		this.numVictime = numVictime;
		this.sinistre = sinistre;
	}

	public Victime(String numVictime, Recours recours, Sinistre sinistre,
			String nomVictime, String prenomVictime, Date dateNaissVictime,
			String adresseVictime, String professionVictime,
			String etatVictime, BigDecimal sommePrejudice,
			Boolean etatIndemniser, Set<Prejudice> prejudices,
			Set<ActeMedical> acteMedicals, Set<AyantDroit> ayantDroits,
			Set<ReglementSinistre> reglementSinistres) {
		this.numVictime = numVictime;
		this.recours = recours;
		this.sinistre = sinistre;
		this.nomVictime = nomVictime;
		this.prenomVictime = prenomVictime;
		this.dateNaissVictime = dateNaissVictime;
		this.adresseVictime = adresseVictime;
		this.professionVictime = professionVictime;
		this.etatVictime = etatVictime;
		this.sommePrejudice = sommePrejudice;
		this.etatIndemniser = etatIndemniser;
		this.prejudices = prejudices;
		this.acteMedicals = acteMedicals;
		this.ayantDroits = ayantDroits;
		this.reglementSinistres = reglementSinistres;
	}

	@Id
	@Column(name = "NUM_VICTIME", unique = true, nullable = false, length = 30)
	public String getNumVictime() {
		return this.numVictime;
	}

	public void setNumVictime(String numVictime) {
		this.numVictime = numVictime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REFERENCE_TIERS")
	public Recours getRecours() {
		return this.recours;
	}

	public void setRecours(Recours recours) {
		this.recours = recours;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "NOM_VICTIME", length = 30)
	public String getNomVictime() {
		return this.nomVictime;
	}

	public void setNomVictime(String nomVictime) {
		this.nomVictime = nomVictime;
	}

	@Column(name = "PRENOM_VICTIME", length = 60)
	public String getPrenomVictime() {
		return this.prenomVictime;
	}

	public void setPrenomVictime(String prenomVictime) {
		this.prenomVictime = prenomVictime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISS_VICTIME", length = 10)
	public Date getDateNaissVictime() {
		return this.dateNaissVictime;
	}

	public void setDateNaissVictime(Date dateNaissVictime) {
		this.dateNaissVictime = dateNaissVictime;
	}

	@Column(name = "ADRESSE_VICTIME", length = 100)
	public String getAdresseVictime() {
		return this.adresseVictime;
	}

	public void setAdresseVictime(String adresseVictime) {
		this.adresseVictime = adresseVictime;
	}

	@Column(name = "PROFESSION_VICTIME", length = 30)
	public String getProfessionVictime() {
		return this.professionVictime;
	}

	public void setProfessionVictime(String professionVictime) {
		this.professionVictime = professionVictime;
	}

	@Column(name = "ETAT_VICTIME", length = 20)
	public String getEtatVictime() {
		return this.etatVictime;
	}

	public void setEtatVictime(String etatVictime) {
		this.etatVictime = etatVictime;
	}

	@Column(name = "SOMME_PREJUDICE", precision = 15, scale = 3)
	public BigDecimal getSommePrejudice() {
		return this.sommePrejudice;
	}

	public void setSommePrejudice(BigDecimal sommePrejudice) {
		this.sommePrejudice = sommePrejudice;
	}

	@Column(name = "ETAT_INDEMNISER")
	public Boolean getEtatIndemniser() {
		return this.etatIndemniser;
	}

	public void setEtatIndemniser(Boolean etatIndemniser) {
		this.etatIndemniser = etatIndemniser;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "victime")
	public Set<Prejudice> getPrejudices() {
		return this.prejudices;
	}

	public void setPrejudices(Set<Prejudice> prejudices) {
		this.prejudices = prejudices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "victime")
	public Set<ActeMedical> getActeMedicals() {
		return this.acteMedicals;
	}

	public void setActeMedicals(Set<ActeMedical> acteMedicals) {
		this.acteMedicals = acteMedicals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "victime")
	public Set<AyantDroit> getAyantDroits() {
		return this.ayantDroits;
	}

	public void setAyantDroits(Set<AyantDroit> ayantDroits) {
		this.ayantDroits = ayantDroits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "victime")
	public Set<ReglementSinistre> getReglementSinistres() {
		return this.reglementSinistres;
	}

	public void setReglementSinistres(Set<ReglementSinistre> reglementSinistres) {
		this.reglementSinistres = reglementSinistres;
	}

}
