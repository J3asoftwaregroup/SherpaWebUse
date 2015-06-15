package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GestionConfieeSinistreId generated by hbm2java
 */
@Embeddable
public class GestionConfieeSinistreId implements java.io.Serializable {

	private String codeGestionConfie;
	private String codeSinistre;

	public GestionConfieeSinistreId() {
	}

	public GestionConfieeSinistreId(String codeGestionConfie,
			String codeSinistre) {
		this.codeGestionConfie = codeGestionConfie;
		this.codeSinistre = codeSinistre;
	}

	@Column(name = "CODE_GESTION_CONFIE", nullable = false, length = 60)
	public String getCodeGestionConfie() {
		return this.codeGestionConfie;
	}

	public void setCodeGestionConfie(String codeGestionConfie) {
		this.codeGestionConfie = codeGestionConfie;
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
		if (!(other instanceof GestionConfieeSinistreId))
			return false;
		GestionConfieeSinistreId castOther = (GestionConfieeSinistreId) other;

		return ((this.getCodeGestionConfie() == castOther
				.getCodeGestionConfie()) || (this.getCodeGestionConfie() != null
				&& castOther.getCodeGestionConfie() != null && this
				.getCodeGestionConfie()
				.equals(castOther.getCodeGestionConfie())))
				&& ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
						.getCodeSinistre() != null
						&& castOther.getCodeSinistre() != null && this
						.getCodeSinistre().equals(castOther.getCodeSinistre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeGestionConfie() == null ? 0 : this
						.getCodeGestionConfie().hashCode());
		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		return result;
	}

}
