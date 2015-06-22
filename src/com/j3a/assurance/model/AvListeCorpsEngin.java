package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

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
 * AvListeCorpsEngin generated by hbm2java
 */
@Entity
@Table(name = "av_liste_corps_engin", catalog = "zeusbd")
public class AvListeCorpsEngin implements java.io.Serializable {

	private AvListeCorpsEnginId id;
	private Avenant avenant;
	private ListeCorpsEngin listeCorpsEngin;
	private Date dateAvListeCorpsEngin;

	public AvListeCorpsEngin() {
	}

	public AvListeCorpsEngin(AvListeCorpsEnginId id, Avenant avenant,
			ListeCorpsEngin listeCorpsEngin) {
		this.id = id;
		this.avenant = avenant;
		this.listeCorpsEngin = listeCorpsEngin;
	}

	public AvListeCorpsEngin(AvListeCorpsEnginId id, Avenant avenant,
			ListeCorpsEngin listeCorpsEngin, Date dateAvListeCorpsEngin) {
		this.id = id;
		this.avenant = avenant;
		this.listeCorpsEngin = listeCorpsEngin;
		this.dateAvListeCorpsEngin = dateAvListeCorpsEngin;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numAvenant", column = @Column(name = "NUM_AVENANT", nullable = false, length = 25)),
			@AttributeOverride(name = "codeListeCorpsEngin", column = @Column(name = "CODE_LISTE_CORPS_ENGIN", nullable = false, length = 27)) })
	public AvListeCorpsEnginId getId() {
		return this.id;
	}

	public void setId(AvListeCorpsEnginId id) {
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
	@JoinColumn(name = "CODE_LISTE_CORPS_ENGIN", nullable = false, insertable = false, updatable = false)
	public ListeCorpsEngin getListeCorpsEngin() {
		return this.listeCorpsEngin;
	}

	public void setListeCorpsEngin(ListeCorpsEngin listeCorpsEngin) {
		this.listeCorpsEngin = listeCorpsEngin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_AV_LISTE_CORPS_ENGIN", length = 10)
	public Date getDateAvListeCorpsEngin() {
		return this.dateAvListeCorpsEngin;
	}

	public void setDateAvListeCorpsEngin(Date dateAvListeCorpsEngin) {
		this.dateAvListeCorpsEngin = dateAvListeCorpsEngin;
	}

}
