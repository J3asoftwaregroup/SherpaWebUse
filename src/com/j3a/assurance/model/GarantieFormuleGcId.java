package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GarantieFormuleGcId generated by hbm2java
 */
@Embeddable
public class GarantieFormuleGcId implements java.io.Serializable {

	private String codeGarantie;
	private String codeFormuleGc;

	public GarantieFormuleGcId() {
	}

	public GarantieFormuleGcId(String codeGarantie, String codeFormuleGc) {
		this.codeGarantie = codeGarantie;
		this.codeFormuleGc = codeFormuleGc;
	}

	@Column(name = "CODE_GARANTIE", nullable = false, length = 12)
	public String getCodeGarantie() {
		return this.codeGarantie;
	}

	public void setCodeGarantie(String codeGarantie) {
		this.codeGarantie = codeGarantie;
	}

	@Column(name = "CODE_FORMULE_GC", nullable = false, length = 60)
	public String getCodeFormuleGc() {
		return this.codeFormuleGc;
	}

	public void setCodeFormuleGc(String codeFormuleGc) {
		this.codeFormuleGc = codeFormuleGc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GarantieFormuleGcId))
			return false;
		GarantieFormuleGcId castOther = (GarantieFormuleGcId) other;

		return ((this.getCodeGarantie() == castOther.getCodeGarantie()) || (this
				.getCodeGarantie() != null
				&& castOther.getCodeGarantie() != null && this
				.getCodeGarantie().equals(castOther.getCodeGarantie())))
				&& ((this.getCodeFormuleGc() == castOther.getCodeFormuleGc()) || (this
						.getCodeFormuleGc() != null
						&& castOther.getCodeFormuleGc() != null && this
						.getCodeFormuleGc()
						.equals(castOther.getCodeFormuleGc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGarantie() == null ? 0 : this.getCodeGarantie()
						.hashCode());
		result = 37
				* result
				+ (getCodeFormuleGc() == null ? 0 : this.getCodeFormuleGc()
						.hashCode());
		return result;
	}

}
