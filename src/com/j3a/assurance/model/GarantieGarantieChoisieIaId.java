package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GarantieGarantieChoisieIaId generated by hbm2java
 */
@Embeddable
public class GarantieGarantieChoisieIaId implements java.io.Serializable {

	private String codeGarantie;
	private String codeGrtieChoisieIa;

	public GarantieGarantieChoisieIaId() {
	}

	public GarantieGarantieChoisieIaId(String codeGarantie,
			String codeGrtieChoisieIa) {
		this.codeGarantie = codeGarantie;
		this.codeGrtieChoisieIa = codeGrtieChoisieIa;
	}

	@Column(name = "CODE_GARANTIE", nullable = false, length = 12)
	public String getCodeGarantie() {
		return this.codeGarantie;
	}

	public void setCodeGarantie(String codeGarantie) {
		this.codeGarantie = codeGarantie;
	}

	@Column(name = "CODE_GRTIE_CHOISIE_IA", nullable = false, length = 50)
	public String getCodeGrtieChoisieIa() {
		return this.codeGrtieChoisieIa;
	}

	public void setCodeGrtieChoisieIa(String codeGrtieChoisieIa) {
		this.codeGrtieChoisieIa = codeGrtieChoisieIa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GarantieGarantieChoisieIaId))
			return false;
		GarantieGarantieChoisieIaId castOther = (GarantieGarantieChoisieIaId) other;

		return ((this.getCodeGarantie() == castOther.getCodeGarantie()) || (this
				.getCodeGarantie() != null
				&& castOther.getCodeGarantie() != null && this
				.getCodeGarantie().equals(castOther.getCodeGarantie())))
				&& ((this.getCodeGrtieChoisieIa() == castOther
						.getCodeGrtieChoisieIa()) || (this
						.getCodeGrtieChoisieIa() != null
						&& castOther.getCodeGrtieChoisieIa() != null && this
						.getCodeGrtieChoisieIa().equals(
								castOther.getCodeGrtieChoisieIa())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGarantie() == null ? 0 : this.getCodeGarantie()
						.hashCode());
		result = 37
				* result
				+ (getCodeGrtieChoisieIa() == null ? 0 : this
						.getCodeGrtieChoisieIa().hashCode());
		return result;
	}

}
