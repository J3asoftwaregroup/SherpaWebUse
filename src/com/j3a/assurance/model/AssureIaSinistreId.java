package com.j3a.assurance.model;

// Generated 15 juin 2015 17:23:41 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssureIaSinistreId generated by hbm2java
 */
@Embeddable
public class AssureIaSinistreId implements java.io.Serializable {

	private String codeSinistre;
	private String numIdentification;

	public AssureIaSinistreId() {
	}

	public AssureIaSinistreId(String codeSinistre, String numIdentification) {
		this.codeSinistre = codeSinistre;
		this.numIdentification = numIdentification;
	}

	@Column(name = "CODE_SINISTRE", nullable = false, length = 40)
	public String getCodeSinistre() {
		return this.codeSinistre;
	}

	public void setCodeSinistre(String codeSinistre) {
		this.codeSinistre = codeSinistre;
	}

	@Column(name = "NUM_IDENTIFICATION", nullable = false, length = 25)
	public String getNumIdentification() {
		return this.numIdentification;
	}

	public void setNumIdentification(String numIdentification) {
		this.numIdentification = numIdentification;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AssureIaSinistreId))
			return false;
		AssureIaSinistreId castOther = (AssureIaSinistreId) other;

		return ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
				.getCodeSinistre() != null
				&& castOther.getCodeSinistre() != null && this
				.getCodeSinistre().equals(castOther.getCodeSinistre())))
				&& ((this.getNumIdentification() == castOther
						.getNumIdentification()) || (this
						.getNumIdentification() != null
						&& castOther.getNumIdentification() != null && this
						.getNumIdentification().equals(
								castOther.getNumIdentification())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		result = 37
				* result
				+ (getNumIdentification() == null ? 0 : this
						.getNumIdentification().hashCode());
		return result;
	}

}
