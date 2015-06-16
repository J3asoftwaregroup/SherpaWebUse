package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ListeAdherentSanteId generated by hbm2java
 */
@Embeddable
public class ListeAdherentSanteId implements java.io.Serializable {

	private String codeListeAdherent;
	private String codeAdherent;

	public ListeAdherentSanteId() {
	}

	public ListeAdherentSanteId(String codeListeAdherent, String codeAdherent) {
		this.codeListeAdherent = codeListeAdherent;
		this.codeAdherent = codeAdherent;
	}

	@Column(name = "CODE_LISTE_ADHERENT", nullable = false, length = 60)
	public String getCodeListeAdherent() {
		return this.codeListeAdherent;
	}

	public void setCodeListeAdherent(String codeListeAdherent) {
		this.codeListeAdherent = codeListeAdherent;
	}

	@Column(name = "CODE_ADHERENT", nullable = false, length = 60)
	public String getCodeAdherent() {
		return this.codeAdherent;
	}

	public void setCodeAdherent(String codeAdherent) {
		this.codeAdherent = codeAdherent;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ListeAdherentSanteId))
			return false;
		ListeAdherentSanteId castOther = (ListeAdherentSanteId) other;

		return ((this.getCodeListeAdherent() == castOther
				.getCodeListeAdherent()) || (this.getCodeListeAdherent() != null
				&& castOther.getCodeListeAdherent() != null && this
				.getCodeListeAdherent()
				.equals(castOther.getCodeListeAdherent())))
				&& ((this.getCodeAdherent() == castOther.getCodeAdherent()) || (this
						.getCodeAdherent() != null
						&& castOther.getCodeAdherent() != null && this
						.getCodeAdherent().equals(castOther.getCodeAdherent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeListeAdherent() == null ? 0 : this
						.getCodeListeAdherent().hashCode());
		result = 37
				* result
				+ (getCodeAdherent() == null ? 0 : this.getCodeAdherent()
						.hashCode());
		return result;
	}

}
