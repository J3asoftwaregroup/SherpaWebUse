package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * HabitationSinistre generated by hbm2java
 */
@Entity
@Table(name = "habitation_sinistre", catalog = "zeusbd")
public class HabitationSinistre implements java.io.Serializable {

	private HabitationSinistreId id;
	private Habitation habitation;
	private Sinistre sinistre;
	private String circonstancesSinistreh;
	private BigDecimal respAssureSinistreh;
	private Boolean domageMatH;
	private Boolean domageCorpH;
	private String consequencesSinistreh;
	private Date dateSinistreHabitation;

	public HabitationSinistre() {
	}

	public HabitationSinistre(HabitationSinistreId id, Habitation habitation,
			Sinistre sinistre) {
		this.id = id;
		this.habitation = habitation;
		this.sinistre = sinistre;
	}

	public HabitationSinistre(HabitationSinistreId id, Habitation habitation,
			Sinistre sinistre, String circonstancesSinistreh,
			BigDecimal respAssureSinistreh, Boolean domageMatH,
			Boolean domageCorpH, String consequencesSinistreh,
			Date dateSinistreHabitation) {
		this.id = id;
		this.habitation = habitation;
		this.sinistre = sinistre;
		this.circonstancesSinistreh = circonstancesSinistreh;
		this.respAssureSinistreh = respAssureSinistreh;
		this.domageMatH = domageMatH;
		this.domageCorpH = domageCorpH;
		this.consequencesSinistreh = consequencesSinistreh;
		this.dateSinistreHabitation = dateSinistreHabitation;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeSinistre", column = @Column(name = "CODE_SINISTRE", nullable = false, length = 40)),
			@AttributeOverride(name = "codeHabitation", column = @Column(name = "CODE_HABITATION", nullable = false, length = 30)) })
	public HabitationSinistreId getId() {
		return this.id;
	}

	public void setId(HabitationSinistreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_HABITATION", nullable = false, insertable = false, updatable = false)
	public Habitation getHabitation() {
		return this.habitation;
	}

	public void setHabitation(Habitation habitation) {
		this.habitation = habitation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false, insertable = false, updatable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "CIRCONSTANCES_SINISTREH", length = 65535)
	public String getCirconstancesSinistreh() {
		return this.circonstancesSinistreh;
	}

	public void setCirconstancesSinistreh(String circonstancesSinistreh) {
		this.circonstancesSinistreh = circonstancesSinistreh;
	}

	@Column(name = "RESP_ASSURE_SINISTREH", precision = 15, scale = 3)
	public BigDecimal getRespAssureSinistreh() {
		return this.respAssureSinistreh;
	}

	public void setRespAssureSinistreh(BigDecimal respAssureSinistreh) {
		this.respAssureSinistreh = respAssureSinistreh;
	}

	@Column(name = "DOMAGE_MAT_H")
	public Boolean getDomageMatH() {
		return this.domageMatH;
	}

	public void setDomageMatH(Boolean domageMatH) {
		this.domageMatH = domageMatH;
	}

	@Column(name = "DOMAGE_CORP_H")
	public Boolean getDomageCorpH() {
		return this.domageCorpH;
	}

	public void setDomageCorpH(Boolean domageCorpH) {
		this.domageCorpH = domageCorpH;
	}

	@Column(name = "CONSEQUENCES_SINISTREH", length = 65535)
	public String getConsequencesSinistreh() {
		return this.consequencesSinistreh;
	}

	public void setConsequencesSinistreh(String consequencesSinistreh) {
		this.consequencesSinistreh = consequencesSinistreh;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SINISTRE_HABITATION", length = 19)
	public Date getDateSinistreHabitation() {
		return this.dateSinistreHabitation;
	}

	public void setDateSinistreHabitation(Date dateSinistreHabitation) {
		this.dateSinistreHabitation = dateSinistreHabitation;
	}

}
