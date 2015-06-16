package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApporteurHabitationId generated by hbm2java
 */
@Embeddable
public class ApporteurHabitationId implements java.io.Serializable {

	private String codeApporteur;
	private String codeHabitation;

	public ApporteurHabitationId() {
	}

	public ApporteurHabitationId(String codeApporteur, String codeHabitation) {
		this.codeApporteur = codeApporteur;
		this.codeHabitation = codeHabitation;
	}

	@Column(name = "CODE_APPORTEUR", nullable = false, length = 10)
	public String getCodeApporteur() {
		return this.codeApporteur;
	}

	public void setCodeApporteur(String codeApporteur) {
		this.codeApporteur = codeApporteur;
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
		if (!(other instanceof ApporteurHabitationId))
			return false;
		ApporteurHabitationId castOther = (ApporteurHabitationId) other;

		return ((this.getCodeApporteur() == castOther.getCodeApporteur()) || (this
				.getCodeApporteur() != null
				&& castOther.getCodeApporteur() != null && this
				.getCodeApporteur().equals(castOther.getCodeApporteur())))
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
				+ (getCodeApporteur() == null ? 0 : this.getCodeApporteur()
						.hashCode());
		result = 37
				* result
				+ (getCodeHabitation() == null ? 0 : this.getCodeHabitation()
						.hashCode());
		return result;
	}

}
