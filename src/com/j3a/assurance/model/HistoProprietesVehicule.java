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
 * HistoProprietesVehicule generated by hbm2java
 */
@Entity
@Table(name = "histo_proprietes_vehicule", catalog = "zeusbd")
public class HistoProprietesVehicule implements java.io.Serializable {

	private String codeHistoVehicule;
	private Vehicule vehicule;
	private String numImmat;
	private Date dateImmat;
	private String numImmatPrec;
	private Date dateImmatPrec;
	private Short nbreCarte;
	private String statut;
	private String genre;
	private String marque;
	private String energie;
	private String typeVehicule;
	private String typeCommercial;
	private String chassis;
	private String numMoteur;
	private String gage;
	private BigDecimal poidsVide;
	private BigDecimal chargeUtile;
	private BigDecimal puissFisc;
	private BigDecimal puissReelle;
	private Short nbrePlaceCab;
	private Short nbrePlaceHorscab;
	private BigDecimal valNeuf;
	private BigDecimal valVenale;
	private String couleur;
	private String protection;
	private Date dateHisto;
	private String avenantId;

	public HistoProprietesVehicule() {
	}

	public HistoProprietesVehicule(String codeHistoVehicule, Vehicule vehicule) {
		this.codeHistoVehicule = codeHistoVehicule;
		this.vehicule = vehicule;
	}

	public HistoProprietesVehicule(String codeHistoVehicule, Vehicule vehicule,
			String numImmat, Date dateImmat, String numImmatPrec,
			Date dateImmatPrec, Short nbreCarte, String statut, String genre,
			String marque, String energie, String typeVehicule,
			String typeCommercial, String chassis, String numMoteur,
			String gage, BigDecimal poidsVide, BigDecimal chargeUtile,
			BigDecimal puissFisc, BigDecimal puissReelle, Short nbrePlaceCab,
			Short nbrePlaceHorscab, BigDecimal valNeuf, BigDecimal valVenale,
			String couleur, String protection, Date dateHisto, String avenantId) {
		this.codeHistoVehicule = codeHistoVehicule;
		this.vehicule = vehicule;
		this.numImmat = numImmat;
		this.dateImmat = dateImmat;
		this.numImmatPrec = numImmatPrec;
		this.dateImmatPrec = dateImmatPrec;
		this.nbreCarte = nbreCarte;
		this.statut = statut;
		this.genre = genre;
		this.marque = marque;
		this.energie = energie;
		this.typeVehicule = typeVehicule;
		this.typeCommercial = typeCommercial;
		this.chassis = chassis;
		this.numMoteur = numMoteur;
		this.gage = gage;
		this.poidsVide = poidsVide;
		this.chargeUtile = chargeUtile;
		this.puissFisc = puissFisc;
		this.puissReelle = puissReelle;
		this.nbrePlaceCab = nbrePlaceCab;
		this.nbrePlaceHorscab = nbrePlaceHorscab;
		this.valNeuf = valNeuf;
		this.valVenale = valVenale;
		this.couleur = couleur;
		this.protection = protection;
		this.dateHisto = dateHisto;
		this.avenantId = avenantId;
	}

	@Id
	@Column(name = "CODE_HISTO_VEHICULE", unique = true, nullable = false, length = 30)
	public String getCodeHistoVehicule() {
		return this.codeHistoVehicule;
	}

	public void setCodeHistoVehicule(String codeHistoVehicule) {
		this.codeHistoVehicule = codeHistoVehicule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_VEHICULE", nullable = false)
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Column(name = "NUM_IMMAT", length = 16)
	public String getNumImmat() {
		return this.numImmat;
	}

	public void setNumImmat(String numImmat) {
		this.numImmat = numImmat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_IMMAT", length = 10)
	public Date getDateImmat() {
		return this.dateImmat;
	}

	public void setDateImmat(Date dateImmat) {
		this.dateImmat = dateImmat;
	}

	@Column(name = "NUM_IMMAT_PREC", length = 16)
	public String getNumImmatPrec() {
		return this.numImmatPrec;
	}

	public void setNumImmatPrec(String numImmatPrec) {
		this.numImmatPrec = numImmatPrec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_IMMAT_PREC", length = 10)
	public Date getDateImmatPrec() {
		return this.dateImmatPrec;
	}

	public void setDateImmatPrec(Date dateImmatPrec) {
		this.dateImmatPrec = dateImmatPrec;
	}

	@Column(name = "NBRE_CARTE")
	public Short getNbreCarte() {
		return this.nbreCarte;
	}

	public void setNbreCarte(Short nbreCarte) {
		this.nbreCarte = nbreCarte;
	}

	@Column(name = "STATUT", length = 40)
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Column(name = "GENRE", length = 20)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "MARQUE", length = 40)
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Column(name = "ENERGIE", length = 20)
	public String getEnergie() {
		return this.energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	@Column(name = "TYPE_VEHICULE", length = 100)
	public String getTypeVehicule() {
		return this.typeVehicule;
	}

	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	@Column(name = "TYPE_COMMERCIAL", length = 20)
	public String getTypeCommercial() {
		return this.typeCommercial;
	}

	public void setTypeCommercial(String typeCommercial) {
		this.typeCommercial = typeCommercial;
	}

	@Column(name = "CHASSIS", length = 16)
	public String getChassis() {
		return this.chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	@Column(name = "NUM_MOTEUR", length = 16)
	public String getNumMoteur() {
		return this.numMoteur;
	}

	public void setNumMoteur(String numMoteur) {
		this.numMoteur = numMoteur;
	}

	@Column(name = "GAGE", length = 20)
	public String getGage() {
		return this.gage;
	}

	public void setGage(String gage) {
		this.gage = gage;
	}

	@Column(name = "POIDS_VIDE", precision = 15, scale = 3)
	public BigDecimal getPoidsVide() {
		return this.poidsVide;
	}

	public void setPoidsVide(BigDecimal poidsVide) {
		this.poidsVide = poidsVide;
	}

	@Column(name = "CHARGE_UTILE", precision = 15, scale = 3)
	public BigDecimal getChargeUtile() {
		return this.chargeUtile;
	}

	public void setChargeUtile(BigDecimal chargeUtile) {
		this.chargeUtile = chargeUtile;
	}

	@Column(name = "PUISS_FISC", precision = 15, scale = 3)
	public BigDecimal getPuissFisc() {
		return this.puissFisc;
	}

	public void setPuissFisc(BigDecimal puissFisc) {
		this.puissFisc = puissFisc;
	}

	@Column(name = "PUISS_REELLE", precision = 15, scale = 3)
	public BigDecimal getPuissReelle() {
		return this.puissReelle;
	}

	public void setPuissReelle(BigDecimal puissReelle) {
		this.puissReelle = puissReelle;
	}

	@Column(name = "NBRE_PLACE_CAB")
	public Short getNbrePlaceCab() {
		return this.nbrePlaceCab;
	}

	public void setNbrePlaceCab(Short nbrePlaceCab) {
		this.nbrePlaceCab = nbrePlaceCab;
	}

	@Column(name = "NBRE_PLACE_HORSCAB")
	public Short getNbrePlaceHorscab() {
		return this.nbrePlaceHorscab;
	}

	public void setNbrePlaceHorscab(Short nbrePlaceHorscab) {
		this.nbrePlaceHorscab = nbrePlaceHorscab;
	}

	@Column(name = "VAL_NEUF", precision = 15, scale = 3)
	public BigDecimal getValNeuf() {
		return this.valNeuf;
	}

	public void setValNeuf(BigDecimal valNeuf) {
		this.valNeuf = valNeuf;
	}

	@Column(name = "VAL_VENALE", precision = 15, scale = 3)
	public BigDecimal getValVenale() {
		return this.valVenale;
	}

	public void setValVenale(BigDecimal valVenale) {
		this.valVenale = valVenale;
	}

	@Column(name = "COULEUR", length = 20)
	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Column(name = "PROTECTION", length = 20)
	public String getProtection() {
		return this.protection;
	}

	public void setProtection(String protection) {
		this.protection = protection;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_HISTO", length = 10)
	public Date getDateHisto() {
		return this.dateHisto;
	}

	public void setDateHisto(Date dateHisto) {
		this.dateHisto = dateHisto;
	}

	@Column(name = "AVENANT_ID", length = 60)
	public String getAvenantId() {
		return this.avenantId;
	}

	public void setAvenantId(String avenantId) {
		this.avenantId = avenantId;
	}

}
