package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

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
 * GestionConfieeSinistre generated by hbm2java
 */
@Entity
@Table(name = "gestion_confiee_sinistre", catalog = "zeusbd")
public class GestionConfieeSinistre implements java.io.Serializable {

	private GestionConfieeSinistreId id;
	private GestionConfiee gestionConfiee;
	private Sinistre sinistre;
	private String nummFactureGestionnaireGc;
	private String consequencesSinistreGc;
	private String commentaireSinistreGc;
	private Date dateSinistreGc;
	private Date dateDebutSinistreGc;
	private Date dateFinSinistreGc;

	public GestionConfieeSinistre() {
	}

	public GestionConfieeSinistre(GestionConfieeSinistreId id,
			GestionConfiee gestionConfiee, Sinistre sinistre) {
		this.id = id;
		this.gestionConfiee = gestionConfiee;
		this.sinistre = sinistre;
	}

	public GestionConfieeSinistre(GestionConfieeSinistreId id,
			GestionConfiee gestionConfiee, Sinistre sinistre,
			String nummFactureGestionnaireGc, String consequencesSinistreGc,
			String commentaireSinistreGc, Date dateSinistreGc,
			Date dateDebutSinistreGc, Date dateFinSinistreGc) {
		this.id = id;
		this.gestionConfiee = gestionConfiee;
		this.sinistre = sinistre;
		this.nummFactureGestionnaireGc = nummFactureGestionnaireGc;
		this.consequencesSinistreGc = consequencesSinistreGc;
		this.commentaireSinistreGc = commentaireSinistreGc;
		this.dateSinistreGc = dateSinistreGc;
		this.dateDebutSinistreGc = dateDebutSinistreGc;
		this.dateFinSinistreGc = dateFinSinistreGc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeGestionConfie", column = @Column(name = "CODE_GESTION_CONFIE", nullable = false, length = 60)),
			@AttributeOverride(name = "codeSinistre", column = @Column(name = "CODE_SINISTRE", nullable = false, length = 40)) })
	public GestionConfieeSinistreId getId() {
		return this.id;
	}

	public void setId(GestionConfieeSinistreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_GESTION_CONFIE", nullable = false, insertable = false, updatable = false)
	public GestionConfiee getGestionConfiee() {
		return this.gestionConfiee;
	}

	public void setGestionConfiee(GestionConfiee gestionConfiee) {
		this.gestionConfiee = gestionConfiee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false, insertable = false, updatable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "NUMM_FACTURE_GESTIONNAIRE_GC", length = 20)
	public String getNummFactureGestionnaireGc() {
		return this.nummFactureGestionnaireGc;
	}

	public void setNummFactureGestionnaireGc(String nummFactureGestionnaireGc) {
		this.nummFactureGestionnaireGc = nummFactureGestionnaireGc;
	}

	@Column(name = "CONSEQUENCES_SINISTRE_GC", length = 65535)
	public String getConsequencesSinistreGc() {
		return this.consequencesSinistreGc;
	}

	public void setConsequencesSinistreGc(String consequencesSinistreGc) {
		this.consequencesSinistreGc = consequencesSinistreGc;
	}

	@Column(name = "COMMENTAIRE_SINISTRE_GC", length = 65535)
	public String getCommentaireSinistreGc() {
		return this.commentaireSinistreGc;
	}

	public void setCommentaireSinistreGc(String commentaireSinistreGc) {
		this.commentaireSinistreGc = commentaireSinistreGc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SINISTRE_GC", length = 19)
	public Date getDateSinistreGc() {
		return this.dateSinistreGc;
	}

	public void setDateSinistreGc(Date dateSinistreGc) {
		this.dateSinistreGc = dateSinistreGc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_DEBUT_SINISTRE_GC", length = 19)
	public Date getDateDebutSinistreGc() {
		return this.dateDebutSinistreGc;
	}

	public void setDateDebutSinistreGc(Date dateDebutSinistreGc) {
		this.dateDebutSinistreGc = dateDebutSinistreGc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FIN_SINISTRE_GC", length = 19)
	public Date getDateFinSinistreGc() {
		return this.dateFinSinistreGc;
	}

	public void setDateFinSinistreGc(Date dateFinSinistreGc) {
		this.dateFinSinistreGc = dateFinSinistreGc;
	}

}
