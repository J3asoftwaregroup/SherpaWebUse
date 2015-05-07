package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GarantieGarantieChoisieNtaId generated by hbm2java
 */
@Embeddable
public class GarantieGarantieChoisieNtaId implements java.io.Serializable {

	private String codeGarantie;
	private String codeGarantieChoisienta;

	public GarantieGarantieChoisieNtaId() {
	}

	public GarantieGarantieChoisieNtaId(String codeGarantie,
			String codeGarantieChoisienta) {
		this.codeGarantie = codeGarantie;
		this.codeGarantieChoisienta = codeGarantieChoisienta;
	}

	@Column(name = "CODE_GARANTIE", nullable = false, length = 12)
	public String getCodeGarantie() {
		return this.codeGarantie;
	}

	public void setCodeGarantie(String codeGarantie) {
		this.codeGarantie = codeGarantie;
	}

	@Column(name = "CODE_GARANTIE_CHOISIENTA", nullable = false, length = 35)
	public String getCodeGarantieChoisienta() {
		return this.codeGarantieChoisienta;
	}

	public void setCodeGarantieChoisienta(String codeGarantieChoisienta) {
		this.codeGarantieChoisienta = codeGarantieChoisienta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GarantieGarantieChoisieNtaId))
			return false;
		GarantieGarantieChoisieNtaId castOther = (GarantieGarantieChoisieNtaId) other;

		return ((this.getCodeGarantie() == castOther.getCodeGarantie()) || (this
				.getCodeGarantie() != null
				&& castOther.getCodeGarantie() != null && this
				.getCodeGarantie().equals(castOther.getCodeGarantie())))
				&& ((this.getCodeGarantieChoisienta() == castOther
						.getCodeGarantieChoisienta()) || (this
						.getCodeGarantieChoisienta() != null
						&& castOther.getCodeGarantieChoisienta() != null && this
						.getCodeGarantieChoisienta().equals(
								castOther.getCodeGarantieChoisienta())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGarantie() == null ? 0 : this.getCodeGarantie()
						.hashCode());
		result = 37
				* result
				+ (getCodeGarantieChoisienta() == null ? 0 : this
						.getCodeGarantieChoisienta().hashCode());
		return result;
	}

}
