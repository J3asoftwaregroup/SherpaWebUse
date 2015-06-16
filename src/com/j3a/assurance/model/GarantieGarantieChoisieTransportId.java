package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GarantieGarantieChoisieTransportId generated by hbm2java
 */
@Embeddable
public class GarantieGarantieChoisieTransportId implements java.io.Serializable {

	private String codeGarantieChoisieTransport;
	private String codeGarantie;

	public GarantieGarantieChoisieTransportId() {
	}

	public GarantieGarantieChoisieTransportId(
			String codeGarantieChoisieTransport, String codeGarantie) {
		this.codeGarantieChoisieTransport = codeGarantieChoisieTransport;
		this.codeGarantie = codeGarantie;
	}

	@Column(name = "CODE_GARANTIE_CHOISIE_TRANSPORT", nullable = false, length = 40)
	public String getCodeGarantieChoisieTransport() {
		return this.codeGarantieChoisieTransport;
	}

	public void setCodeGarantieChoisieTransport(
			String codeGarantieChoisieTransport) {
		this.codeGarantieChoisieTransport = codeGarantieChoisieTransport;
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
		if (!(other instanceof GarantieGarantieChoisieTransportId))
			return false;
		GarantieGarantieChoisieTransportId castOther = (GarantieGarantieChoisieTransportId) other;

		return ((this.getCodeGarantieChoisieTransport() == castOther
				.getCodeGarantieChoisieTransport()) || (this
				.getCodeGarantieChoisieTransport() != null
				&& castOther.getCodeGarantieChoisieTransport() != null && this
				.getCodeGarantieChoisieTransport().equals(
						castOther.getCodeGarantieChoisieTransport())))
				&& ((this.getCodeGarantie() == castOther.getCodeGarantie()) || (this
						.getCodeGarantie() != null
						&& castOther.getCodeGarantie() != null && this
						.getCodeGarantie().equals(castOther.getCodeGarantie())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGarantieChoisieTransport() == null ? 0 : this
						.getCodeGarantieChoisieTransport().hashCode());
		result = 37
				* result
				+ (getCodeGarantie() == null ? 0 : this.getCodeGarantie()
						.hashCode());
		return result;
	}

}
