package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SinistreConducteurId generated by hbm2java
 */
@Embeddable
public class SinistreConducteurId implements java.io.Serializable {

	private String codeConducteurSinistre;
	private String codeSinistre;

	public SinistreConducteurId() {
	}

	public SinistreConducteurId(String codeConducteurSinistre,
			String codeSinistre) {
		this.codeConducteurSinistre = codeConducteurSinistre;
		this.codeSinistre = codeSinistre;
	}

	@Column(name = "CODE_CONDUCTEUR_SINISTRE", nullable = false, length = 16)
	public String getCodeConducteurSinistre() {
		return this.codeConducteurSinistre;
	}

	public void setCodeConducteurSinistre(String codeConducteurSinistre) {
		this.codeConducteurSinistre = codeConducteurSinistre;
	}

	@Column(name = "CODE_SINISTRE", nullable = false, length = 40)
	public String getCodeSinistre() {
		return this.codeSinistre;
	}

	public void setCodeSinistre(String codeSinistre) {
		this.codeSinistre = codeSinistre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SinistreConducteurId))
			return false;
		SinistreConducteurId castOther = (SinistreConducteurId) other;

		return ((this.getCodeConducteurSinistre() == castOther
				.getCodeConducteurSinistre()) || (this
				.getCodeConducteurSinistre() != null
				&& castOther.getCodeConducteurSinistre() != null && this
				.getCodeConducteurSinistre().equals(
						castOther.getCodeConducteurSinistre())))
				&& ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
						.getCodeSinistre() != null
						&& castOther.getCodeSinistre() != null && this
						.getCodeSinistre().equals(castOther.getCodeSinistre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeConducteurSinistre() == null ? 0 : this
						.getCodeConducteurSinistre().hashCode());
		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		return result;
	}

}
