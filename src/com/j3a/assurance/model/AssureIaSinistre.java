package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

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
 * AssureIaSinistre generated by hbm2java
 */
@Entity
@Table(name = "assure_ia_sinistre", catalog = "zeusbd")
public class AssureIaSinistre implements java.io.Serializable {

	private AssureIaSinistreId id;
	private AssureIa assureIa;
	private Sinistre sinistre;
	private String circonstancesSinistre;
	private String consequencesSinistre;
	private BigDecimal respAssure;
	private Date dateSinistreIa;

	public AssureIaSinistre() {
	}

	public AssureIaSinistre(AssureIaSinistreId id, AssureIa assureIa,
			Sinistre sinistre) {
		this.id = id;
		this.assureIa = assureIa;
		this.sinistre = sinistre;
	}

	public AssureIaSinistre(AssureIaSinistreId id, AssureIa assureIa,
			Sinistre sinistre, String circonstancesSinistre,
			String consequencesSinistre, BigDecimal respAssure,
			Date dateSinistreIa) {
		this.id = id;
		this.assureIa = assureIa;
		this.sinistre = sinistre;
		this.circonstancesSinistre = circonstancesSinistre;
		this.consequencesSinistre = consequencesSinistre;
		this.respAssure = respAssure;
		this.dateSinistreIa = dateSinistreIa;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeSinistre", column = @Column(name = "CODE_SINISTRE", nullable = false, length = 40)),
			@AttributeOverride(name = "numIdentification", column = @Column(name = "NUM_IDENTIFICATION", nullable = false, length = 25)) })
	public AssureIaSinistreId getId() {
		return this.id;
	}

	public void setId(AssureIaSinistreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_IDENTIFICATION", nullable = false, insertable = false, updatable = false)
	public AssureIa getAssureIa() {
		return this.assureIa;
	}

	public void setAssureIa(AssureIa assureIa) {
		this.assureIa = assureIa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false, insertable = false, updatable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@Column(name = "CIRCONSTANCES_SINISTRE", length = 65535)
	public String getCirconstancesSinistre() {
		return this.circonstancesSinistre;
	}

	public void setCirconstancesSinistre(String circonstancesSinistre) {
		this.circonstancesSinistre = circonstancesSinistre;
	}

	@Column(name = "CONSEQUENCES_SINISTRE", length = 65535)
	public String getConsequencesSinistre() {
		return this.consequencesSinistre;
	}

	public void setConsequencesSinistre(String consequencesSinistre) {
		this.consequencesSinistre = consequencesSinistre;
	}

	@Column(name = "RESP_ASSURE", precision = 15, scale = 3)
	public BigDecimal getRespAssure() {
		return this.respAssure;
	}

	public void setRespAssure(BigDecimal respAssure) {
		this.respAssure = respAssure;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SINISTRE_IA", length = 19)
	public Date getDateSinistreIa() {
		return this.dateSinistreIa;
	}

	public void setDateSinistreIa(Date dateSinistreIa) {
		this.dateSinistreIa = dateSinistreIa;
	}

}
