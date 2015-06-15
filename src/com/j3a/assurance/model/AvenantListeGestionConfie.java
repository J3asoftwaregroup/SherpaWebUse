package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

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
 * AvenantListeGestionConfie generated by hbm2java
 */
@Entity
@Table(name = "avenant_liste_gestion_confie", catalog = "zeusbd")
public class AvenantListeGestionConfie implements java.io.Serializable {

	private AvenantListeGestionConfieId id;
	private Avenant avenant;
	private ListeGestionConfie listeGestionConfie;
	private Date dateAvListeGc;

	public AvenantListeGestionConfie() {
	}

	public AvenantListeGestionConfie(AvenantListeGestionConfieId id,
			Avenant avenant, ListeGestionConfie listeGestionConfie) {
		this.id = id;
		this.avenant = avenant;
		this.listeGestionConfie = listeGestionConfie;
	}

	public AvenantListeGestionConfie(AvenantListeGestionConfieId id,
			Avenant avenant, ListeGestionConfie listeGestionConfie,
			Date dateAvListeGc) {
		this.id = id;
		this.avenant = avenant;
		this.listeGestionConfie = listeGestionConfie;
		this.dateAvListeGc = dateAvListeGc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numAvenant", column = @Column(name = "NUM_AVENANT", nullable = false, length = 25)),
			@AttributeOverride(name = "codeListeGestionConfie", column = @Column(name = "CODE_LISTE_GESTION_CONFIE", nullable = false, length = 60)) })
	public AvenantListeGestionConfieId getId() {
		return this.id;
	}

	public void setId(AvenantListeGestionConfieId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_AVENANT", nullable = false, insertable = false, updatable = false)
	public Avenant getAvenant() {
		return this.avenant;
	}

	public void setAvenant(Avenant avenant) {
		this.avenant = avenant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_LISTE_GESTION_CONFIE", nullable = false, insertable = false, updatable = false)
	public ListeGestionConfie getListeGestionConfie() {
		return this.listeGestionConfie;
	}

	public void setListeGestionConfie(ListeGestionConfie listeGestionConfie) {
		this.listeGestionConfie = listeGestionConfie;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_AV_LISTE_GC", length = 19)
	public Date getDateAvListeGc() {
		return this.dateAvListeGc;
	}

	public void setDateAvListeGc(Date dateAvListeGc) {
		this.dateAvListeGc = dateAvListeGc;
	}

}
