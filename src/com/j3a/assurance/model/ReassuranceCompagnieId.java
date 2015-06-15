package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ReassuranceCompagnieId generated by hbm2java
 */
@Embeddable
public class ReassuranceCompagnieId implements java.io.Serializable {

	private String codeReassurance;
	private String codeCompagnie;

	public ReassuranceCompagnieId() {
	}

	public ReassuranceCompagnieId(String codeReassurance, String codeCompagnie) {
		this.codeReassurance = codeReassurance;
		this.codeCompagnie = codeCompagnie;
	}

	@Column(name = "CODE_REASSURANCE", nullable = false, length = 16)
	public String getCodeReassurance() {
		return this.codeReassurance;
	}

	public void setCodeReassurance(String codeReassurance) {
		this.codeReassurance = codeReassurance;
	}

	@Column(name = "CODE_COMPAGNIE", nullable = false, length = 10)
	public String getCodeCompagnie() {
		return this.codeCompagnie;
	}

	public void setCodeCompagnie(String codeCompagnie) {
		this.codeCompagnie = codeCompagnie;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReassuranceCompagnieId))
			return false;
		ReassuranceCompagnieId castOther = (ReassuranceCompagnieId) other;

		return ((this.getCodeReassurance() == castOther.getCodeReassurance()) || (this
				.getCodeReassurance() != null
				&& castOther.getCodeReassurance() != null && this
				.getCodeReassurance().equals(castOther.getCodeReassurance())))
				&& ((this.getCodeCompagnie() == castOther.getCodeCompagnie()) || (this
						.getCodeCompagnie() != null
						&& castOther.getCodeCompagnie() != null && this
						.getCodeCompagnie()
						.equals(castOther.getCodeCompagnie())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeReassurance() == null ? 0 : this.getCodeReassurance()
						.hashCode());
		result = 37
				* result
				+ (getCodeCompagnie() == null ? 0 : this.getCodeCompagnie()
						.hashCode());
		return result;
	}

}
