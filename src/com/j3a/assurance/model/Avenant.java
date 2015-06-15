package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

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
 * Avenant generated by hbm2java
 */
@Entity
@Table(name = "avenant", catalog = "zeusbd")
public class Avenant implements java.io.Serializable {

	private String numAvenant;
	private Contrat contrat;
	private Exercice exercice;
	private Utilisateur utilisateur;
	private VehiculesAssures vehiculesAssures;
	private Date dateAvenant;
	private Date effet;
	private Date dateEmission;
	private Date echeance;
	private Short duree;
	private Date resiliation;
	private String observation;
	private Short envoyerMail;
	private String mouvement;
	private Set<AvListeCorpsEngin> avListeCorpsEngins = new HashSet<AvListeCorpsEngin>(
			0);
	private Set<AvenantListeGestionConfie> avenantListeGestionConfies = new HashSet<AvenantListeGestionConfie>(
			0);
	private Set<AvListeHabitation> avListeHabitations = new HashSet<AvListeHabitation>(
			0);
	private Set<AvListeAssureIa> avListeAssureIas = new HashSet<AvListeAssureIa>(
			0);
	private Set<AvListeAdherent> avListeAdherents = new HashSet<AvListeAdherent>(
			0);
	private Set<AvenantRisqueNta> avenantRisqueNtas = new HashSet<AvenantRisqueNta>(
			0);
	private Set<AvTrafic> avTrafics = new HashSet<AvTrafic>(0);
	private Set<Quittance> quittances = new HashSet<Quittance>(0);

	public Avenant() {
	}

	public Avenant(String numAvenant, Contrat contrat, Utilisateur utilisateur) {
		this.numAvenant = numAvenant;
		this.contrat = contrat;
		this.utilisateur = utilisateur;
	}

	public Avenant(String numAvenant, Contrat contrat, Exercice exercice,
			Utilisateur utilisateur, VehiculesAssures vehiculesAssures,
			Date dateAvenant, Date effet, Date dateEmission, Date echeance,
			Short duree, Date resiliation, String observation,
			Short envoyerMail, String mouvement,
			Set<AvListeCorpsEngin> avListeCorpsEngins,
			Set<AvenantListeGestionConfie> avenantListeGestionConfies,
			Set<AvListeHabitation> avListeHabitations,
			Set<AvListeAssureIa> avListeAssureIas,
			Set<AvListeAdherent> avListeAdherents,
			Set<AvenantRisqueNta> avenantRisqueNtas, Set<AvTrafic> avTrafics,
			Set<Quittance> quittances) {
		this.numAvenant = numAvenant;
		this.contrat = contrat;
		this.exercice = exercice;
		this.utilisateur = utilisateur;
		this.vehiculesAssures = vehiculesAssures;
		this.dateAvenant = dateAvenant;
		this.effet = effet;
		this.dateEmission = dateEmission;
		this.echeance = echeance;
		this.duree = duree;
		this.resiliation = resiliation;
		this.observation = observation;
		this.envoyerMail = envoyerMail;
		this.mouvement = mouvement;
		this.avListeCorpsEngins = avListeCorpsEngins;
		this.avenantListeGestionConfies = avenantListeGestionConfies;
		this.avListeHabitations = avListeHabitations;
		this.avListeAssureIas = avListeAssureIas;
		this.avListeAdherents = avListeAdherents;
		this.avenantRisqueNtas = avenantRisqueNtas;
		this.avTrafics = avTrafics;
		this.quittances = quittances;
	}

	@Id
	@Column(name = "NUM_AVENANT", unique = true, nullable = false, length = 25)
	public String getNumAvenant() {
		return this.numAvenant;
	}

	public void setNumAvenant(String numAvenant) {
		this.numAvenant = numAvenant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_POLICE", nullable = false)
	public Contrat getContrat() {
		return this.contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODEEXERCICE")
	public Exercice getExercice() {
		return this.exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_UTILISATEUR", nullable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VEHICULES_ASSURES")
	public VehiculesAssures getVehiculesAssures() {
		return this.vehiculesAssures;
	}

	public void setVehiculesAssures(VehiculesAssures vehiculesAssures) {
		this.vehiculesAssures = vehiculesAssures;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_AVENANT", length = 19)
	public Date getDateAvenant() {
		return this.dateAvenant;
	}

	public void setDateAvenant(Date dateAvenant) {
		this.dateAvenant = dateAvenant;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFET", length = 19)
	public Date getEffet() {
		return this.effet;
	}

	public void setEffet(Date effet) {
		this.effet = effet;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_EMISSION", length = 19)
	public Date getDateEmission() {
		return this.dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ECHEANCE", length = 19)
	public Date getEcheance() {
		return this.echeance;
	}

	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}

	@Column(name = "DUREE")
	public Short getDuree() {
		return this.duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RESILIATION", length = 19)
	public Date getResiliation() {
		return this.resiliation;
	}

	public void setResiliation(Date resiliation) {
		this.resiliation = resiliation;
	}

	@Column(name = "OBSERVATION", length = 50)
	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Column(name = "ENVOYER_MAIL")
	public Short getEnvoyerMail() {
		return this.envoyerMail;
	}

	public void setEnvoyerMail(Short envoyerMail) {
		this.envoyerMail = envoyerMail;
	}

	@Column(name = "MOUVEMENT", length = 50)
	public String getMouvement() {
		return this.mouvement;
	}

	public void setMouvement(String mouvement) {
		this.mouvement = mouvement;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvListeCorpsEngin> getAvListeCorpsEngins() {
		return this.avListeCorpsEngins;
	}

	public void setAvListeCorpsEngins(Set<AvListeCorpsEngin> avListeCorpsEngins) {
		this.avListeCorpsEngins = avListeCorpsEngins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvenantListeGestionConfie> getAvenantListeGestionConfies() {
		return this.avenantListeGestionConfies;
	}

	public void setAvenantListeGestionConfies(
			Set<AvenantListeGestionConfie> avenantListeGestionConfies) {
		this.avenantListeGestionConfies = avenantListeGestionConfies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvListeHabitation> getAvListeHabitations() {
		return this.avListeHabitations;
	}

	public void setAvListeHabitations(Set<AvListeHabitation> avListeHabitations) {
		this.avListeHabitations = avListeHabitations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvListeAssureIa> getAvListeAssureIas() {
		return this.avListeAssureIas;
	}

	public void setAvListeAssureIas(Set<AvListeAssureIa> avListeAssureIas) {
		this.avListeAssureIas = avListeAssureIas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvListeAdherent> getAvListeAdherents() {
		return this.avListeAdherents;
	}

	public void setAvListeAdherents(Set<AvListeAdherent> avListeAdherents) {
		this.avListeAdherents = avListeAdherents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvenantRisqueNta> getAvenantRisqueNtas() {
		return this.avenantRisqueNtas;
	}

	public void setAvenantRisqueNtas(Set<AvenantRisqueNta> avenantRisqueNtas) {
		this.avenantRisqueNtas = avenantRisqueNtas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<AvTrafic> getAvTrafics() {
		return this.avTrafics;
	}

	public void setAvTrafics(Set<AvTrafic> avTrafics) {
		this.avTrafics = avTrafics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avenant")
	public Set<Quittance> getQuittances() {
		return this.quittances;
	}

	public void setQuittances(Set<Quittance> quittances) {
		this.quittances = quittances;
	}

}
