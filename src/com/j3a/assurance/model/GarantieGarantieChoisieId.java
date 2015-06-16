package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GarantieGarantieChoisieId generated by hbm2java
 */
@Embeddable
public class GarantieGarantieChoisieId implements java.io.Serializable {

	private String codeGarantieChoisie;
	private String codeGarantie;

	public GarantieGarantieChoisieId() {
	}

	public GarantieGarantieChoisieId(String codeGarantieChoisie,
			String codeGarantie) {
		this.codeGarantieChoisie = codeGarantieChoisie;
		this.codeGarantie = codeGarantie;
	}

	@Column(name = "CODE_GARANTIE_CHOISIE", nullable = false, length = 30)
	public String getCodeGarantieChoisie() {
		return this.codeGarantieChoisie;
	}

	public void setCodeGarantieChoisie(String codeGarantieChoisie) {
		this.codeGarantieChoisie = codeGarantieChoisie;
	}

	@Column(name = "CODE_GARANTIE", nullable = false, length = 12)
	public String getCodeGarantie() {
		return this.codeGarantie;
	}

	public void setCodeGarantie(String codeGarantie) {
		this.codeGarantie = codeGarantie;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GarantieGarantieChoisieId))
			return false;
		GarantieGarantieChoisieId castOther = (GarantieGarantieChoisieId) other;

		return ((this.getCodeGarantieChoisie() == castOther
				.getCodeGarantieChoisie()) || (this.getCodeGarantieChoisie() != null
				&& castOther.getCodeGarantieChoisie() != null && this
				.getCodeGarantieChoisie().equals(
						castOther.getCodeGarantieChoisie())))
				&& ((this.getCodeGarantie() == castOther.getCodeGarantie()) || (this
						.getCodeGarantie() != null
						&& castOther.getCodeGarantie() != null && this
						.getCodeGarantie().equals(castOther.getCodeGarantie())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGarantieChoisie() == null ? 0 : this
						.getCodeGarantieChoisie().hashCode());
		result = 37
				* result
				+ (getCodeGarantie() == null ? 0 : this.getCodeGarantie()
						.hashCode());
		return result;
	}

}
