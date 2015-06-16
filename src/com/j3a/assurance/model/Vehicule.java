package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

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
 * Vehicule generated by hbm2java
 */
@Entity
@Table(name = "vehicule", catalog = "zeusbd")
public class Vehicule implements java.io.Serializable {

	private String codeVehicule;
	private SousCatVehicule sousCatVehicule;
	private VehiculesAssures vehiculesAssures;
	private String numImmat;
	private Date dateImmat;
	private String numImmatPrec;
	private Date dateImmatPrec;
	private Short nbreCarte;
	private Date datePremiereCirc;
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
	private String carrosserie;
	private Boolean remorque;
	private String typeTransporte;
	private Short nbreTransporte;
	private Set<Attestation> attestations = new HashSet<Attestation>(0);
	private Set<HistoMouvement> histoMouvements = new HashSet<HistoMouvement>(0);
	private Set<ApporteurVehicule> apporteurVehicules = new HashSet<ApporteurVehicule>(
			0);
	private Set<VehiculeZoneGeographique> vehiculeZoneGeographiques = new HashSet<VehiculeZoneGeographique>(
			0);
	private Set<VehiculeSinistre> vehiculeSinistres = new HashSet<VehiculeSinistre>(
			0);
	private Set<ConduireVehicule> conduireVehicules = new HashSet<ConduireVehicule>(
			0);
	private Set<HistoProprietesVehicule> histoProprietesVehicules = new HashSet<HistoProprietesVehicule>(
			0);
	private Set<GarantieChoisie> garantieChoisies = new HashSet<GarantieChoisie>(
			0);

	public Vehicule() {
	}

	public Vehicule(String codeVehicule, SousCatVehicule sousCatVehicule) {
		this.codeVehicule = codeVehicule;
		this.sousCatVehicule = sousCatVehicule;
	}

	public Vehicule(String codeVehicule, SousCatVehicule sousCatVehicule,
			VehiculesAssures vehiculesAssures, String numImmat, Date dateImmat,
			String numImmatPrec, Date dateImmatPrec, Short nbreCarte,
			Date datePremiereCirc, String statut, String genre, String marque,
			String energie, String typeVehicule, String typeCommercial,
			String chassis, String numMoteur, String gage,
			BigDecimal poidsVide, BigDecimal chargeUtile, BigDecimal puissFisc,
			BigDecimal puissReelle, Short nbrePlaceCab, Short nbrePlaceHorscab,
			BigDecimal valNeuf, BigDecimal valVenale, String couleur,
			String protection, String carrosserie, Boolean remorque,
			String typeTransporte, Short nbreTransporte,
			Set<Attestation> attestations, Set<HistoMouvement> histoMouvements,
			Set<ApporteurVehicule> apporteurVehicules,
			Set<VehiculeZoneGeographique> vehiculeZoneGeographiques,
			Set<VehiculeSinistre> vehiculeSinistres,
			Set<ConduireVehicule> conduireVehicules,
			Set<HistoProprietesVehicule> histoProprietesVehicules,
			Set<GarantieChoisie> garantieChoisies) {
		this.codeVehicule = codeVehicule;
		this.sousCatVehicule = sousCatVehicule;
		this.vehiculesAssures = vehiculesAssures;
		this.numImmat = numImmat;
		this.dateImmat = dateImmat;
		this.numImmatPrec = numImmatPrec;
		this.dateImmatPrec = dateImmatPrec;
		this.nbreCarte = nbreCarte;
		this.datePremiereCirc = datePremiereCirc;
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
		this.carrosserie = carrosserie;
		this.remorque = remorque;
		this.typeTransporte = typeTransporte;
		this.nbreTransporte = nbreTransporte;
		this.attestations = attestations;
		this.histoMouvements = histoMouvements;
		this.apporteurVehicules = apporteurVehicules;
		this.vehiculeZoneGeographiques = vehiculeZoneGeographiques;
		this.vehiculeSinistres = vehiculeSinistres;
		this.conduireVehicules = conduireVehicules;
		this.histoProprietesVehicules = histoProprietesVehicules;
		this.garantieChoisies = garantieChoisies;
	}

	@Id
	@Column(name = "CODE_VEHICULE", unique = true, nullable = false, length = 30)
	public String getCodeVehicule() {
		return this.codeVehicule;
	}

	public void setCodeVehicule(String codeVehicule) {
		this.codeVehicule = codeVehicule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SOUS_CAT_VEHICULE", nullable = false)
	public SousCatVehicule getSousCatVehicule() {
		return this.sousCatVehicule;
	}

	public void setSousCatVehicule(SousCatVehicule sousCatVehicule) {
		this.sousCatVehicule = sousCatVehicule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VEHICULES_ASSURES")
	public VehiculesAssures getVehiculesAssures() {
		return this.vehiculesAssures;
	}

	public void setVehiculesAssures(VehiculesAssures vehiculesAssures) {
		this.vehiculesAssures = vehiculesAssures;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PREMIERE_CIRC", length = 10)
	public Date getDatePremiereCirc() {
		return this.datePremiereCirc;
	}

	public void setDatePremiereCirc(Date datePremiereCirc) {
		this.datePremiereCirc = datePremiereCirc;
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

	@Column(name = "CARROSSERIE", length = 50)
	public String getCarrosserie() {
		return this.carrosserie;
	}

	public void setCarrosserie(String carrosserie) {
		this.carrosserie = carrosserie;
	}

	@Column(name = "REMORQUE")
	public Boolean getRemorque() {
		return this.remorque;
	}

	public void setRemorque(Boolean remorque) {
		this.remorque = remorque;
	}

	@Column(name = "TYPE_TRANSPORTE", length = 65535)
	public String getTypeTransporte() {
		return this.typeTransporte;
	}

	public void setTypeTransporte(String typeTransporte) {
		this.typeTransporte = typeTransporte;
	}

	@Column(name = "NBRE_TRANSPORTE")
	public Short getNbreTransporte() {
		return this.nbreTransporte;
	}

	public void setNbreTransporte(Short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<Attestation> getAttestations() {
		return this.attestations;
	}

	public void setAttestations(Set<Attestation> attestations) {
		this.attestations = attestations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<HistoMouvement> getHistoMouvements() {
		return this.histoMouvements;
	}

	public void setHistoMouvements(Set<HistoMouvement> histoMouvements) {
		this.histoMouvements = histoMouvements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<ApporteurVehicule> getApporteurVehicules() {
		return this.apporteurVehicules;
	}

	public void setApporteurVehicules(Set<ApporteurVehicule> apporteurVehicules) {
		this.apporteurVehicules = apporteurVehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<VehiculeZoneGeographique> getVehiculeZoneGeographiques() {
		return this.vehiculeZoneGeographiques;
	}

	public void setVehiculeZoneGeographiques(
			Set<VehiculeZoneGeographique> vehiculeZoneGeographiques) {
		this.vehiculeZoneGeographiques = vehiculeZoneGeographiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<VehiculeSinistre> getVehiculeSinistres() {
		return this.vehiculeSinistres;
	}

	public void setVehiculeSinistres(Set<VehiculeSinistre> vehiculeSinistres) {
		this.vehiculeSinistres = vehiculeSinistres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<ConduireVehicule> getConduireVehicules() {
		return this.conduireVehicules;
	}

	public void setConduireVehicules(Set<ConduireVehicule> conduireVehicules) {
		this.conduireVehicules = conduireVehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<HistoProprietesVehicule> getHistoProprietesVehicules() {
		return this.histoProprietesVehicules;
	}

	public void setHistoProprietesVehicules(
			Set<HistoProprietesVehicule> histoProprietesVehicules) {
		this.histoProprietesVehicules = histoProprietesVehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
	public Set<GarantieChoisie> getGarantieChoisies() {
		return this.garantieChoisies;
	}

	public void setGarantieChoisies(Set<GarantieChoisie> garantieChoisies) {
		this.garantieChoisies = garantieChoisies;
	}

}
