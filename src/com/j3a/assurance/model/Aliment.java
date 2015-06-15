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
 * Aliment generated by hbm2java
 */
@Entity
@Table(name = "aliment", catalog = "zeusbd")
public class Aliment implements java.io.Serializable {

	private String codeAliment;
	private Categorie categorie;
	private Trafic trafic;
	private String numImprimer;
	private String avisAliment;
	private Date emissionAliment;
	private BigDecimal pleinExpAliment;
	private String engin;
	private String ligne;
	private String numVoyage;
	private Integer age;
	private String pavillon;
	private String depart;
	private String destination;
	private Date dateEmb;
	private String lieuEmb;
	private String natureMarchandise;
	private String emballage;
	private Integer nombre;
	private BigDecimal valeur;
	private String devise;
	private Integer poidsBrutMarch;
	private Integer poidsNetMarch;
	private String marque;
	private BigDecimal valeurContaineur;
	private String immatriculationEngin;
	private Date datePremiereCirculationEngin;
	private Set apporteurAliments = new HashSet(0);
	private Set garantieChoisieTransports = new HashSet(0);
	private Set alimentSinistres = new HashSet(0);

	public Aliment() {
	}

	public Aliment(String codeAliment) {
		this.codeAliment = codeAliment;
	}

	public Aliment(String codeAliment, Categorie categorie, Trafic trafic,
			String numImprimer, String avisAliment, Date emissionAliment,
			BigDecimal pleinExpAliment, String engin, String ligne,
			String numVoyage, Integer age, String pavillon, String depart,
			String destination, Date dateEmb, String lieuEmb,
			String natureMarchandise, String emballage, Integer nombre,
			BigDecimal valeur, String devise, Integer poidsBrutMarch,
			Integer poidsNetMarch, String marque, BigDecimal valeurContaineur,
			String immatriculationEngin, Date datePremiereCirculationEngin,
			Set apporteurAliments, Set garantieChoisieTransports,
			Set alimentSinistres) {
		this.codeAliment = codeAliment;
		this.categorie = categorie;
		this.trafic = trafic;
		this.numImprimer = numImprimer;
		this.avisAliment = avisAliment;
		this.emissionAliment = emissionAliment;
		this.pleinExpAliment = pleinExpAliment;
		this.engin = engin;
		this.ligne = ligne;
		this.numVoyage = numVoyage;
		this.age = age;
		this.pavillon = pavillon;
		this.depart = depart;
		this.destination = destination;
		this.dateEmb = dateEmb;
		this.lieuEmb = lieuEmb;
		this.natureMarchandise = natureMarchandise;
		this.emballage = emballage;
		this.nombre = nombre;
		this.valeur = valeur;
		this.devise = devise;
		this.poidsBrutMarch = poidsBrutMarch;
		this.poidsNetMarch = poidsNetMarch;
		this.marque = marque;
		this.valeurContaineur = valeurContaineur;
		this.immatriculationEngin = immatriculationEngin;
		this.datePremiereCirculationEngin = datePremiereCirculationEngin;
		this.apporteurAliments = apporteurAliments;
		this.garantieChoisieTransports = garantieChoisieTransports;
		this.alimentSinistres = alimentSinistres;
	}

	@Id
	@Column(name = "CODE_ALIMENT", unique = true, nullable = false, length = 35)
	public String getCodeAliment() {
		return this.codeAliment;
	}

	public void setCodeAliment(String codeAliment) {
		this.codeAliment = codeAliment;
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
	@JoinColumn(name = "CODE_TRAFIC")
	public Trafic getTrafic() {
		return this.trafic;
	}

	public void setTrafic(Trafic trafic) {
		this.trafic = trafic;
	}

	@Column(name = "NUM_IMPRIMER", length = 30)
	public String getNumImprimer() {
		return this.numImprimer;
	}

	public void setNumImprimer(String numImprimer) {
		this.numImprimer = numImprimer;
	}

	@Column(name = "AVIS_ALIMENT", length = 14)
	public String getAvisAliment() {
		return this.avisAliment;
	}

	public void setAvisAliment(String avisAliment) {
		this.avisAliment = avisAliment;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMISSION_ALIMENT", length = 10)
	public Date getEmissionAliment() {
		return this.emissionAliment;
	}

	public void setEmissionAliment(Date emissionAliment) {
		this.emissionAliment = emissionAliment;
	}

	@Column(name = "PLEIN_EXP_ALIMENT", precision = 15, scale = 3)
	public BigDecimal getPleinExpAliment() {
		return this.pleinExpAliment;
	}

	public void setPleinExpAliment(BigDecimal pleinExpAliment) {
		this.pleinExpAliment = pleinExpAliment;
	}

	@Column(name = "ENGIN", length = 50)
	public String getEngin() {
		return this.engin;
	}

	public void setEngin(String engin) {
		this.engin = engin;
	}

	@Column(name = "LIGNE", length = 50)
	public String getLigne() {
		return this.ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	@Column(name = "NUM_VOYAGE", length = 10)
	public String getNumVoyage() {
		return this.numVoyage;
	}

	public void setNumVoyage(String numVoyage) {
		this.numVoyage = numVoyage;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "PAVILLON", length = 50)
	public String getPavillon() {
		return this.pavillon;
	}

	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}

	@Column(name = "DEPART", length = 50)
	public String getDepart() {
		return this.depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	@Column(name = "DESTINATION", length = 50)
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_EMB", length = 10)
	public Date getDateEmb() {
		return this.dateEmb;
	}

	public void setDateEmb(Date dateEmb) {
		this.dateEmb = dateEmb;
	}

	@Column(name = "LIEU_EMB", length = 50)
	public String getLieuEmb() {
		return this.lieuEmb;
	}

	public void setLieuEmb(String lieuEmb) {
		this.lieuEmb = lieuEmb;
	}

	@Column(name = "NATURE_MARCHANDISE", length = 60)
	public String getNatureMarchandise() {
		return this.natureMarchandise;
	}

	public void setNatureMarchandise(String natureMarchandise) {
		this.natureMarchandise = natureMarchandise;
	}

	@Column(name = "EMBALLAGE", length = 30)
	public String getEmballage() {
		return this.emballage;
	}

	public void setEmballage(String emballage) {
		this.emballage = emballage;
	}

	@Column(name = "NOMBRE")
	public Integer getNombre() {
		return this.nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	@Column(name = "VALEUR", precision = 15, scale = 3)
	public BigDecimal getValeur() {
		return this.valeur;
	}

	public void setValeur(BigDecimal valeur) {
		this.valeur = valeur;
	}

	@Column(name = "DEVISE", length = 20)
	public String getDevise() {
		return this.devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	@Column(name = "POIDS_BRUT_MARCH")
	public Integer getPoidsBrutMarch() {
		return this.poidsBrutMarch;
	}

	public void setPoidsBrutMarch(Integer poidsBrutMarch) {
		this.poidsBrutMarch = poidsBrutMarch;
	}

	@Column(name = "POIDS_NET_MARCH")
	public Integer getPoidsNetMarch() {
		return this.poidsNetMarch;
	}

	public void setPoidsNetMarch(Integer poidsNetMarch) {
		this.poidsNetMarch = poidsNetMarch;
	}

	@Column(name = "MARQUE", length = 40)
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Column(name = "VALEUR_CONTAINEUR", precision = 15, scale = 3)
	public BigDecimal getValeurContaineur() {
		return this.valeurContaineur;
	}

	public void setValeurContaineur(BigDecimal valeurContaineur) {
		this.valeurContaineur = valeurContaineur;
	}

	@Column(name = "IMMATRICULATION_ENGIN", length = 20)
	public String getImmatriculationEngin() {
		return this.immatriculationEngin;
	}

	public void setImmatriculationEngin(String immatriculationEngin) {
		this.immatriculationEngin = immatriculationEngin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PREMIERE_CIRCULATION_ENGIN", length = 10)
	public Date getDatePremiereCirculationEngin() {
		return this.datePremiereCirculationEngin;
	}

	public void setDatePremiereCirculationEngin(
			Date datePremiereCirculationEngin) {
		this.datePremiereCirculationEngin = datePremiereCirculationEngin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aliment")
	public Set getApporteurAliments() {
		return this.apporteurAliments;
	}

	public void setApporteurAliments(Set apporteurAliments) {
		this.apporteurAliments = apporteurAliments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aliment")
	public Set getGarantieChoisieTransports() {
		return this.garantieChoisieTransports;
	}

	public void setGarantieChoisieTransports(Set garantieChoisieTransports) {
		this.garantieChoisieTransports = garantieChoisieTransports;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aliment")
	public Set getAlimentSinistres() {
		return this.alimentSinistres;
	}

	public void setAlimentSinistres(Set alimentSinistres) {
		this.alimentSinistres = alimentSinistres;
	}

}
