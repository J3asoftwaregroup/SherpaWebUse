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
 * AvListeAdherent generated by hbm2java
 */
@Entity
@Table(name = "av_liste_adherent", catalog = "zeusbd")
public class AvListeAdherent implements java.io.Serializable {

	private AvListeAdherentId id;
	private Avenant avenant;
	private ListeAdherent listeAdherent;
	private Date dateAvAdherent;

	public AvListeAdherent() {
	}

	public AvListeAdherent(AvListeAdherentId id, Avenant avenant,
			ListeAdherent listeAdherent) {
		this.id = id;
		this.avenant = avenant;
		this.listeAdherent = listeAdherent;
	}

	public AvListeAdherent(AvListeAdherentId id, Avenant avenant,
			ListeAdherent listeAdherent, Date dateAvAdherent) {
		this.id = id;
		this.avenant = avenant;
		this.listeAdherent = listeAdherent;
		this.dateAvAdherent = dateAvAdherent;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numAvenant", column = @Column(name = "NUM_AVENANT", nullable = false, length = 25)),
			@AttributeOverride(name = "codeListeAdherent", column = @Column(name = "CODE_LISTE_ADHERENT", nullable = false, length = 60)) })
	public AvListeAdherentId getId() {
		return this.id;
	}

	public void setId(AvListeAdherentId id) {
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
	@JoinColumn(name = "CODE_LISTE_ADHERENT", nullable = false, insertable = false, updatable = false)
	public ListeAdherent getListeAdherent() {
		return this.listeAdherent;
	}

	public void setListeAdherent(ListeAdherent listeAdherent) {
		this.listeAdherent = listeAdherent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_AV_ADHERENT", length = 19)
	public Date getDateAvAdherent() {
		return this.dateAvAdherent;
	}

	public void setDateAvAdherent(Date dateAvAdherent) {
		this.dateAvAdherent = dateAvAdherent;
	}

}
