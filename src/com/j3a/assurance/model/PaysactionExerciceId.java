package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PaysactionExerciceId generated by hbm2java
 */
@Embeddable
public class PaysactionExerciceId implements java.io.Serializable {

	private String codeEtatCima;
	private String codePa;

	public PaysactionExerciceId() {
	}

	public PaysactionExerciceId(String codeEtatCima, String codePa) {
		this.codeEtatCima = codeEtatCima;
		this.codePa = codePa;
	}

	@Column(name = "CODE_ETAT_CIMA", nullable = false, length = 20)
	public String getCodeEtatCima() {
		return this.codeEtatCima;
	}

	public void setCodeEtatCima(String codeEtatCima) {
		this.codeEtatCima = codeEtatCima;
	}

	@Column(name = "CODE_PA", nullable = false, length = 20)
	public String getCodePa() {
		return this.codePa;
	}

	public void setCodePa(String codePa) {
		this.codePa = codePa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaysactionExerciceId))
			return false;
		PaysactionExerciceId castOther = (PaysactionExerciceId) other;

		return ((this.getCodeEtatCima() == castOther.getCodeEtatCima()) || (this
				.getCodeEtatCima() != null
				&& castOther.getCodeEtatCima() != null && this
				.getCodeEtatCima().equals(castOther.getCodeEtatCima())))
				&& ((this.getCodePa() == castOther.getCodePa()) || (this
						.getCodePa() != null && castOther.getCodePa() != null && this
						.getCodePa().equals(castOther.getCodePa())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeEtatCima() == null ? 0 : this.getCodeEtatCima()
						.hashCode());
		result = 37 * result
				+ (getCodePa() == null ? 0 : this.getCodePa().hashCode());
		return result;
	}

}