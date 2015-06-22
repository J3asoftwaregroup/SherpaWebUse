package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AlimentSinistreId generated by hbm2java
 */
@Embeddable
public class AlimentSinistreId implements java.io.Serializable {

	private String codeSinistre;
	private String codeAliment;

	public AlimentSinistreId() {
	}

	public AlimentSinistreId(String codeSinistre, String codeAliment) {
		this.codeSinistre = codeSinistre;
		this.codeAliment = codeAliment;
	}

	@Column(name = "CODE_SINISTRE", nullable = false, length = 40)
	public String getCodeSinistre() {
		return this.codeSinistre;
	}

	public void setCodeSinistre(String codeSinistre) {
		this.codeSinistre = codeSinistre;
	}

	@Column(name = "CODE_ALIMENT", nullable = false, length = 35)
	public String getCodeAliment() {
		return this.codeAliment;
	}

	public void setCodeAliment(String codeAliment) {
		this.codeAliment = codeAliment;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AlimentSinistreId))
			return false;
		AlimentSinistreId castOther = (AlimentSinistreId) other;

		return ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
				.getCodeSinistre() != null
				&& castOther.getCodeSinistre() != null && this
				.getCodeSinistre().equals(castOther.getCodeSinistre())))
				&& ((this.getCodeAliment() == castOther.getCodeAliment()) || (this
						.getCodeAliment() != null
						&& castOther.getCodeAliment() != null && this
						.getCodeAliment().equals(castOther.getCodeAliment())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		result = 37
				* result
				+ (getCodeAliment() == null ? 0 : this.getCodeAliment()
						.hashCode());
		return result;
	}

}
