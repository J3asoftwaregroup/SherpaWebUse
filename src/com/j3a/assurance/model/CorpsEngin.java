package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

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
 * CorpsEngin generated by hbm2java
 */
@Entity
@Table(name = "corps_engin", catalog = "zeusbd")
public class CorpsEngin implements java.io.Serializable {

	private String codeEngin;
	private Categorie categorie;
	private ListeCorpsEngin listeCorpsEngin;
	private String embarcation;
	private String armateur;
	private String numImmatEngin;
	private Date dateImmatEngin;
	private String typeEmbarcation;
	private Integer anneeConstruction;
	private Integer age;
	private String pavillonEngin;
	private String typeCoque;
	private String propulsion;
	private Integer jaugeBrute;
	private Integer jaugeNette;
	private Integer longueurEngin;
	private Integer largeurEngin;
	private Integer nbreMoteurEngin;
	private String marqueMoteurEngin;
	private BigDecimal valeurMoteurEngin;
	private Integer puissanceEngin;
	private String energieEngin;
	private String catNavigation;
	private String genreEngin;
	private BigDecimal valCoqueEngin;
	private BigDecimal valeurAccessoireEngin;
	private BigDecimal valeurNeufEngin;
	private BigDecimal valeurVenaleEngin;
	private BigDecimal fraisRetirement;
	private String limiteNavigation;
	private String systProtection;
	private String portDattach;
	private Integer nbrePassagerEngin;
	private Integer nbreEquipagesEngin;
	private Set<ApporteurCorpsEngin> apporteurCorpsEngins = new HashSet<ApporteurCorpsEngin>(
			0);
	private Set<CorpsSinistre> corpsSinistres = new HashSet<CorpsSinistre>(0);
	private Set<GarantieChoisieTransportCorps> garantieChoisieTransportCorpses = new HashSet<GarantieChoisieTransportCorps>(
			0);

	public CorpsEngin() {
	}

	public CorpsEngin(String codeEngin) {
		this.codeEngin = codeEngin;
	}

	public CorpsEngin(String codeEngin, Categorie categorie,
			ListeCorpsEngin listeCorpsEngin, String embarcation,
			String armateur, String numImmatEngin, Date dateImmatEngin,
			String typeEmbarcation, Integer anneeConstruction, Integer age,
			String pavillonEngin, String typeCoque, String propulsion,
			Integer jaugeBrute, Integer jaugeNette, Integer longueurEngin,
			Integer largeurEngin, Integer nbreMoteurEngin,
			String marqueMoteurEngin, BigDecimal valeurMoteurEngin,
			Integer puissanceEngin, String energieEngin, String catNavigation,
			String genreEngin, BigDecimal valCoqueEngin,
			BigDecimal valeurAccessoireEngin, BigDecimal valeurNeufEngin,
			BigDecimal valeurVenaleEngin, BigDecimal fraisRetirement,
			String limiteNavigation, String systProtection, String portDattach,
			Integer nbrePassagerEngin, Integer nbreEquipagesEngin,
			Set<ApporteurCorpsEngin> apporteurCorpsEngins,
			Set<CorpsSinistre> corpsSinistres,
			Set<GarantieChoisieTransportCorps> garantieChoisieTransportCorpses) {
		this.codeEngin = codeEngin;
		this.categorie = categorie;
		this.listeCorpsEngin = listeCorpsEngin;
		this.embarcation = embarcation;
		this.armateur = armateur;
		this.numImmatEngin = numImmatEngin;
		this.dateImmatEngin = dateImmatEngin;
		this.typeEmbarcation = typeEmbarcation;
		this.anneeConstruction = anneeConstruction;
		this.age = age;
		this.pavillonEngin = pavillonEngin;
		this.typeCoque = typeCoque;
		this.propulsion = propulsion;
		this.jaugeBrute = jaugeBrute;
		this.jaugeNette = jaugeNette;
		this.longueurEngin = longueurEngin;
		this.largeurEngin = largeurEngin;
		this.nbreMoteurEngin = nbreMoteurEngin;
		this.marqueMoteurEngin = marqueMoteurEngin;
		this.valeurMoteurEngin = valeurMoteurEngin;
		this.puissanceEngin = puissanceEngin;
		this.energieEngin = energieEngin;
		this.catNavigation = catNavigation;
		this.genreEngin = genreEngin;
		this.valCoqueEngin = valCoqueEngin;
		this.valeurAccessoireEngin = valeurAccessoireEngin;
		this.valeurNeufEngin = valeurNeufEngin;
		this.valeurVenaleEngin = valeurVenaleEngin;
		this.fraisRetirement = fraisRetirement;
		this.limiteNavigation = limiteNavigation;
		this.systProtection = systProtection;
		this.portDattach = portDattach;
		this.nbrePassagerEngin = nbrePassagerEngin;
		this.nbreEquipagesEngin = nbreEquipagesEngin;
		this.apporteurCorpsEngins = apporteurCorpsEngins;
		this.corpsSinistres = corpsSinistres;
		this.garantieChoisieTransportCorpses = garantieChoisieTransportCorpses;
	}

	@Id
	@Column(name = "CODE_ENGIN", unique = true, nullable = false, length = 30)
	public String getCodeEngin() {
		return this.codeEngin;
	}

	public void setCodeEngin(String codeEngin) {
		this.codeEngin = codeEngin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CATEGORIE")
	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_LISTE_CORPS_ENGIN")
	public ListeCorpsEngin getListeCorpsEngin() {
		return this.listeCorpsEngin;
	}

	public void setListeCorpsEngin(ListeCorpsEngin listeCorpsEngin) {
		this.listeCorpsEngin = listeCorpsEngin;
	}

	@Column(name = "EMBARCATION", length = 60)
	public String getEmbarcation() {
		return this.embarcation;
	}

	public void setEmbarcation(String embarcation) {
		this.embarcation = embarcation;
	}

	@Column(name = "ARMATEUR", length = 60)
	public String getArmateur() {
		return this.armateur;
	}

	public void setArmateur(String armateur) {
		this.armateur = armateur;
	}

	@Column(name = "NUM_IMMAT_ENGIN", length = 20)
	public String getNumImmatEngin() {
		return this.numImmatEngin;
	}

	public void setNumImmatEngin(String numImmatEngin) {
		this.numImmatEngin = numImmatEngin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_IMMAT_ENGIN", length = 10)
	public Date getDateImmatEngin() {
		return this.dateImmatEngin;
	}

	public void setDateImmatEngin(Date dateImmatEngin) {
		this.dateImmatEngin = dateImmatEngin;
	}

	@Column(name = "TYPE_EMBARCATION", length = 60)
	public String getTypeEmbarcation() {
		return this.typeEmbarcation;
	}

	public void setTypeEmbarcation(String typeEmbarcation) {
		this.typeEmbarcation = typeEmbarcation;
	}

	@Column(name = "ANNEE_CONSTRUCTION")
	public Integer getAnneeConstruction() {
		return this.anneeConstruction;
	}

	public void setAnneeConstruction(Integer anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "PAVILLON_ENGIN", length = 60)
	public String getPavillonEngin() {
		return this.pavillonEngin;
	}

	public void setPavillonEngin(String pavillonEngin) {
		this.pavillonEngin = pavillonEngin;
	}

	@Column(name = "TYPE_COQUE", length = 60)
	public String getTypeCoque() {
		return this.typeCoque;
	}

	public void setTypeCoque(String typeCoque) {
		this.typeCoque = typeCoque;
	}

	@Column(name = "PROPULSION", length = 30)
	public String getPropulsion() {
		return this.propulsion;
	}

	public void setPropulsion(String propulsion) {
		this.propulsion = propulsion;
	}

	@Column(name = "JAUGE_BRUTE")
	public Integer getJaugeBrute() {
		return this.jaugeBrute;
	}

	public void setJaugeBrute(Integer jaugeBrute) {
		this.jaugeBrute = jaugeBrute;
	}

	@Column(name = "JAUGE_NETTE")
	public Integer getJaugeNette() {
		return this.jaugeNette;
	}

	public void setJaugeNette(Integer jaugeNette) {
		this.jaugeNette = jaugeNette;
	}

	@Column(name = "LONGUEUR_ENGIN")
	public Integer getLongueurEngin() {
		return this.longueurEngin;
	}

	public void setLongueurEngin(Integer longueurEngin) {
		this.longueurEngin = longueurEngin;
	}

	@Column(name = "LARGEUR_ENGIN")
	public Integer getLargeurEngin() {
		return this.largeurEngin;
	}

	public void setLargeurEngin(Integer largeurEngin) {
		this.largeurEngin = largeurEngin;
	}

	@Column(name = "NBRE_MOTEUR_ENGIN")
	public Integer getNbreMoteurEngin() {
		return this.nbreMoteurEngin;
	}

	public void setNbreMoteurEngin(Integer nbreMoteurEngin) {
		this.nbreMoteurEngin = nbreMoteurEngin;
	}

	@Column(name = "MARQUE_MOTEUR_ENGIN", length = 60)
	public String getMarqueMoteurEngin() {
		return this.marqueMoteurEngin;
	}

	public void setMarqueMoteurEngin(String marqueMoteurEngin) {
		this.marqueMoteurEngin = marqueMoteurEngin;
	}

	@Column(name = "VALEUR_MOTEUR_ENGIN", precision = 15, scale = 3)
	public BigDecimal getValeurMoteurEngin() {
		return this.valeurMoteurEngin;
	}

	public void setValeurMoteurEngin(BigDecimal valeurMoteurEngin) {
		this.valeurMoteurEngin = valeurMoteurEngin;
	}

	@Column(name = "PUISSANCE_ENGIN")
	public Integer getPuissanceEngin() {
		return this.puissanceEngin;
	}

	public void setPuissanceEngin(Integer puissanceEngin) {
		this.puissanceEngin = puissanceEngin;
	}

	@Column(name = "ENERGIE_ENGIN", length = 15)
	public String getEnergieEngin() {
		return this.energieEngin;
	}

	public void setEnergieEngin(String energieEngin) {
		this.energieEngin = energieEngin;
	}

	@Column(name = "CAT_NAVIGATION", length = 10)
	public String getCatNavigation() {
		return this.catNavigation;
	}

	public void setCatNavigation(String catNavigation) {
		this.catNavigation = catNavigation;
	}

	@Column(name = "GENRE_ENGIN", length = 16)
	public String getGenreEngin() {
		return this.genreEngin;
	}

	public void setGenreEngin(String genreEngin) {
		this.genreEngin = genreEngin;
	}

	@Column(name = "VAL_COQUE_ENGIN", precision = 15, scale = 3)
	public BigDecimal getValCoqueEngin() {
		return this.valCoqueEngin;
	}

	public void setValCoqueEngin(BigDecimal valCoqueEngin) {
		this.valCoqueEngin = valCoqueEngin;
	}

	@Column(name = "VALEUR_ACCESSOIRE_ENGIN", precision = 15, scale = 3)
	public BigDecimal getValeurAccessoireEngin() {
		return this.valeurAccessoireEngin;
	}

	public void setValeurAccessoireEngin(BigDecimal valeurAccessoireEngin) {
		this.valeurAccessoireEngin = valeurAccessoireEngin;
	}

	@Column(name = "VALEUR_NEUF_ENGIN", precision = 15, scale = 3)
	public BigDecimal getValeurNeufEngin() {
		return this.valeurNeufEngin;
	}

	public void setValeurNeufEngin(BigDecimal valeurNeufEngin) {
		this.valeurNeufEngin = valeurNeufEngin;
	}

	@Column(name = "VALEUR_VENALE_ENGIN", precision = 15, scale = 3)
	public BigDecimal getValeurVenaleEngin() {
		return this.valeurVenaleEngin;
	}

	public void setValeurVenaleEngin(BigDecimal valeurVenaleEngin) {
		this.valeurVenaleEngin = valeurVenaleEngin;
	}

	@Column(name = "FRAIS_RETIREMENT", precision = 15, scale = 3)
	public BigDecimal getFraisRetirement() {
		return this.fraisRetirement;
	}

	public void setFraisRetirement(BigDecimal fraisRetirement) {
		this.fraisRetirement = fraisRetirement;
	}

	@Column(name = "LIMITE_NAVIGATION", length = 60)
	public String getLimiteNavigation() {
		return this.limiteNavigation;
	}

	public void setLimiteNavigation(String limiteNavigation) {
		this.limiteNavigation = limiteNavigation;
	}

	@Column(name = "SYST_PROTECTION", length = 30)
	public String getSystProtection() {
		return this.systProtection;
	}

	public void setSystProtection(String systProtection) {
		this.systProtection = systProtection;
	}

	@Column(name = "PORT_DATTACH", length = 50)
	public String getPortDattach() {
		return this.portDattach;
	}

	public void setPortDattach(String portDattach) {
		this.portDattach = portDattach;
	}

	@Column(name = "NBRE_PASSAGER_ENGIN")
	public Integer getNbrePassagerEngin() {
		return this.nbrePassagerEngin;
	}

	public void setNbrePassagerEngin(Integer nbrePassagerEngin) {
		this.nbrePassagerEngin = nbrePassagerEngin;
	}

	@Column(name = "NBRE_EQUIPAGES_ENGIN")
	public Integer getNbreEquipagesEngin() {
		return this.nbreEquipagesEngin;
	}

	public void setNbreEquipagesEngin(Integer nbreEquipagesEngin) {
		this.nbreEquipagesEngin = nbreEquipagesEngin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corpsEngin")
	public Set<ApporteurCorpsEngin> getApporteurCorpsEngins() {
		return this.apporteurCorpsEngins;
	}

	public void setApporteurCorpsEngins(
			Set<ApporteurCorpsEngin> apporteurCorpsEngins) {
		this.apporteurCorpsEngins = apporteurCorpsEngins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corpsEngin")
	public Set<CorpsSinistre> getCorpsSinistres() {
		return this.corpsSinistres;
	}

	public void setCorpsSinistres(Set<CorpsSinistre> corpsSinistres) {
		this.corpsSinistres = corpsSinistres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corpsEngin")
	public Set<GarantieChoisieTransportCorps> getGarantieChoisieTransportCorpses() {
		return this.garantieChoisieTransportCorpses;
	}

	public void setGarantieChoisieTransportCorpses(
			Set<GarantieChoisieTransportCorps> garantieChoisieTransportCorpses) {
		this.garantieChoisieTransportCorpses = garantieChoisieTransportCorpses;
	}

}
