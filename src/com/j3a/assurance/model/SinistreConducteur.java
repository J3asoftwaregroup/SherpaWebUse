package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

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
 * SinistreConducteur generated by hbm2java
 */
@Entity
@Table(name = "sinistre_conducteur", catalog = "zeusbd")
public class SinistreConducteur implements java.io.Serializable {

	private SinistreConducteurId id;
	private ConducteurSinistre conducteurSinistre;
	private Sinistre sinistre;
	private Date dateConducteurSinistre;

	public SinistreConducteur() {
	}

	public SinistreConducteur(SinistreConducteurId id,
			ConducteurSinistre conducteurSinistre, Sinistre sinistre) {
		this.id = id;
		this.conducteurSinistre = conducteurSinistre;
		this.sinistre = sinistre;
	}

	public SinistreConducteur(SinistreConducteurId id,
			ConducteurSinistre conducteurSinistre, Sinistre sinistre,
			Date dateConducteurSinistre) {
		this.id = id;
		this.conducteurSinistre = conducteurSinistre;
		this.sinistre = sinistre;
		this.dateConducteurSinistre = dateConducteurSinistre;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeConducteurSinistre", column = @Column(name = "CODE_CONDUCTEUR_SINISTRE", nullable = false, length = 16)),
			@AttributeOverride(name = "codeSinistre", column = @Column(name = "CODE_SINISTRE", nullable = false, length = 40)) })
	public SinistreConducteurId getId() {
		return this.id;
	}

	public void setId(SinistreConducteurId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CONDUCTEUR_SINISTRE", nullable = false, insertable = false, updatable = false)
	public ConducteurSinistre getConducteurSinistre() {
		return this.conducteurSinistre;
	}

	public void setConducteurSinistre(ConducteurSinistre conducteurSinistre) {
		this.conducteurSinistre = conducteurSinistre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false, insertable = false, updatable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CONDUCTEUR_SINISTRE", length = 19)
	public Date getDateConducteurSinistre() {
		return this.dateConducteurSinistre;
	}

	public void setDateConducteurSinistre(Date dateConducteurSinistre) {
		this.dateConducteurSinistre = dateConducteurSinistre;
	}

}
