package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

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
 * AvListeAssureIa generated by hbm2java
 */
@Entity
@Table(name = "av_liste_assure_ia", catalog = "zeusbd")
public class AvListeAssureIa implements java.io.Serializable {

	private AvListeAssureIaId id;
	private Avenant avenant;
	private ListeAssureIa listeAssureIa;
	private Date dateAvListeAssureIa;

	public AvListeAssureIa() {
	}

	public AvListeAssureIa(AvListeAssureIaId id, Avenant avenant,
			ListeAssureIa listeAssureIa) {
		this.id = id;
		this.avenant = avenant;
		this.listeAssureIa = listeAssureIa;
	}

	public AvListeAssureIa(AvListeAssureIaId id, Avenant avenant,
			ListeAssureIa listeAssureIa, Date dateAvListeAssureIa) {
		this.id = id;
		this.avenant = avenant;
		this.listeAssureIa = listeAssureIa;
		this.dateAvListeAssureIa = dateAvListeAssureIa;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeListeAssureIa", column = @Column(name = "CODE_LISTE_ASSURE_IA", nullable = false, length = 30)),
			@AttributeOverride(name = "numAvenant", column = @Column(name = "NUM_AVENANT", nullable = false, length = 25)) })
	public AvListeAssureIaId getId() {
		return this.id;
	}

	public void setId(AvListeAssureIaId id) {
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
	@JoinColumn(name = "CODE_LISTE_ASSURE_IA", nullable = false, insertable = false, updatable = false)
	public ListeAssureIa getListeAssureIa() {
		return this.listeAssureIa;
	}

	public void setListeAssureIa(ListeAssureIa listeAssureIa) {
		this.listeAssureIa = listeAssureIa;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_AV_LISTE_ASSURE_IA", length = 10)
	public Date getDateAvListeAssureIa() {
		return this.dateAvListeAssureIa;
	}

	public void setDateAvListeAssureIa(Date dateAvListeAssureIa) {
		this.dateAvListeAssureIa = dateAvListeAssureIa;
	}

}
