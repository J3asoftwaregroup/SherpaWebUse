package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HabitationSinistreId generated by hbm2java
 */
@Embeddable
public class HabitationSinistreId implements java.io.Serializable {

	private String codeSinistre;
	private String codeHabitation;

	public HabitationSinistreId() {
	}

	public HabitationSinistreId(String codeSinistre, String codeHabitation) {
		this.codeSinistre = codeSinistre;
		this.codeHabitation = codeHabitation;
	}

	@Column(name = "CODE_SINISTRE", nullable = false, length = 40)
	public String getCodeSinistre() {
		return this.codeSinistre;
	}

	public void setCodeSinistre(String codeSinistre) {
		this.codeSinistre = codeSinistre;
	}

	@Column(name = "CODE_HABITATION", nullable = false, length = 30)
	public String getCodeHabitation() {
		return this.codeHabitation;
	}

	public void setCodeHabitation(String codeHabitation) {
		this.codeHabitation = codeHabitation;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HabitationSinistreId))
			return false;
		HabitationSinistreId castOther = (HabitationSinistreId) other;

		return ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
				.getCodeSinistre() != null
				&& castOther.getCodeSinistre() != null && this
				.getCodeSinistre().equals(castOther.getCodeSinistre())))
				&& ((this.getCodeHabitation() == castOther.getCodeHabitation()) || (this
						.getCodeHabitation() != null
						&& castOther.getCodeHabitation() != null && this
						.getCodeHabitation().equals(
								castOther.getCodeHabitation())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		result = 37
				* result
				+ (getCodeHabitation() == null ? 0 : this.getCodeHabitation()
						.hashCode());
		return result;
	}

}
