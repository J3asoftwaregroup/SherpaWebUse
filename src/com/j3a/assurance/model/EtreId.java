package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EtreId generated by hbm2java
 */
@Embeddable
public class EtreId implements java.io.Serializable {

	private String numSouscripteur;
	private int codeTypePers;

	public EtreId() {
	}

	public EtreId(String numSouscripteur, int codeTypePers) {
		this.numSouscripteur = numSouscripteur;
		this.codeTypePers = codeTypePers;
	}

	@Column(name = "NUM_SOUSCRIPTEUR", nullable = false, length = 15)
	public String getNumSouscripteur() {
		return this.numSouscripteur;
	}

	public void setNumSouscripteur(String numSouscripteur) {
		this.numSouscripteur = numSouscripteur;
	}

	@Column(name = "CODE_TYPE_PERS", nullable = false)
	public int getCodeTypePers() {
		return this.codeTypePers;
	}

	public void setCodeTypePers(int codeTypePers) {
		this.codeTypePers = codeTypePers;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EtreId))
			return false;
		EtreId castOther = (EtreId) other;

		return ((this.getNumSouscripteur() == castOther.getNumSouscripteur()) || (this
				.getNumSouscripteur() != null
				&& castOther.getNumSouscripteur() != null && this
				.getNumSouscripteur().equals(castOther.getNumSouscripteur())))
				&& (this.getCodeTypePers() == castOther.getCodeTypePers());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumSouscripteur() == null ? 0 : this.getNumSouscripteur()
						.hashCode());
		result = 37 * result + this.getCodeTypePers();
		return result;
	}

}
