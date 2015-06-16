package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AvListeAdherentId generated by hbm2java
 */
@Embeddable
public class AvListeAdherentId implements java.io.Serializable {

	private String numAvenant;
	private String codeListeAdherent;

	public AvListeAdherentId() {
	}

	public AvListeAdherentId(String numAvenant, String codeListeAdherent) {
		this.numAvenant = numAvenant;
		this.codeListeAdherent = codeListeAdherent;
	}

	@Column(name = "NUM_AVENANT", nullable = false, length = 25)
	public String getNumAvenant() {
		return this.numAvenant;
	}

	public void setNumAvenant(String numAvenant) {
		this.numAvenant = numAvenant;
	}

	@Column(name = "CODE_LISTE_ADHERENT", nullable = false, length = 60)
	public String getCodeListeAdherent() {
		return this.codeListeAdherent;
	}

	public void setCodeListeAdherent(String codeListeAdherent) {
		this.codeListeAdherent = codeListeAdherent;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AvListeAdherentId))
			return false;
		AvListeAdherentId castOther = (AvListeAdherentId) other;

		return ((this.getNumAvenant() == castOther.getNumAvenant()) || (this
				.getNumAvenant() != null && castOther.getNumAvenant() != null && this
				.getNumAvenant().equals(castOther.getNumAvenant())))
				&& ((this.getCodeListeAdherent() == castOther
						.getCodeListeAdherent()) || (this
						.getCodeListeAdherent() != null
						&& castOther.getCodeListeAdherent() != null && this
						.getCodeListeAdherent().equals(
								castOther.getCodeListeAdherent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumAvenant() == null ? 0 : this.getNumAvenant()
						.hashCode());
		result = 37
				* result
				+ (getCodeListeAdherent() == null ? 0 : this
						.getCodeListeAdherent().hashCode());
		return result;
	}

}
