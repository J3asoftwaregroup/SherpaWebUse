package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

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
 * GarantieFormuleGc generated by hbm2java
 */
@Entity
@Table(name = "garantie_formule_gc", catalog = "zeusbd")
public class GarantieFormuleGc implements java.io.Serializable {

	private GarantieFormuleGcId id;
	private FormuleGc formuleGc;
	private Garantie garantie;
	private Date dateGarantieFormuleGc;

	public GarantieFormuleGc() {
	}

	public GarantieFormuleGc(GarantieFormuleGcId id, FormuleGc formuleGc,
			Garantie garantie) {
		this.id = id;
		this.formuleGc = formuleGc;
		this.garantie = garantie;
	}

	public GarantieFormuleGc(GarantieFormuleGcId id, FormuleGc formuleGc,
			Garantie garantie, Date dateGarantieFormuleGc) {
		this.id = id;
		this.formuleGc = formuleGc;
		this.garantie = garantie;
		this.dateGarantieFormuleGc = dateGarantieFormuleGc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeGarantie", column = @Column(name = "CODE_GARANTIE", nullable = false, length = 12)),
			@AttributeOverride(name = "codeFormuleGc", column = @Column(name = "CODE_FORMULE_GC", nullable = false, length = 60)) })
	public GarantieFormuleGcId getId() {
		return this.id;
	}

	public void setId(GarantieFormuleGcId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_FORMULE_GC", nullable = false, insertable = false, updatable = false)
	public FormuleGc getFormuleGc() {
		return this.formuleGc;
	}

	public void setFormuleGc(FormuleGc formuleGc) {
		this.formuleGc = formuleGc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_GARANTIE", nullable = false, insertable = false, updatable = false)
	public Garantie getGarantie() {
		return this.garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_GARANTIE_FORMULE_GC", length = 19)
	public Date getDateGarantieFormuleGc() {
		return this.dateGarantieFormuleGc;
	}

	public void setDateGarantieFormuleGc(Date dateGarantieFormuleGc) {
		this.dateGarantieFormuleGc = dateGarantieFormuleGc;
	}

}
