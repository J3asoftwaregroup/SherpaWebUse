package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProfilUtilisateurId generated by hbm2java
 */
@Embeddable
public class ProfilUtilisateurId implements java.io.Serializable {

	private String codeUtilisateur;
	private String codeProfil;

	public ProfilUtilisateurId() {
	}

	public ProfilUtilisateurId(String codeUtilisateur, String codeProfil) {
		this.codeUtilisateur = codeUtilisateur;
		this.codeProfil = codeProfil;
	}

	@Column(name = "CODE_UTILISATEUR", nullable = false, length = 10)
	public String getCodeUtilisateur() {
		return this.codeUtilisateur;
	}

	public void setCodeUtilisateur(String codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	@Column(name = "CODE_PROFIL", nullable = false, length = 10)
	public String getCodeProfil() {
		return this.codeProfil;
	}

	public void setCodeProfil(String codeProfil) {
		this.codeProfil = codeProfil;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProfilUtilisateurId))
			return false;
		ProfilUtilisateurId castOther = (ProfilUtilisateurId) other;

		return ((this.getCodeUtilisateur() == castOther.getCodeUtilisateur()) || (this
				.getCodeUtilisateur() != null
				&& castOther.getCodeUtilisateur() != null && this
				.getCodeUtilisateur().equals(castOther.getCodeUtilisateur())))
				&& ((this.getCodeProfil() == castOther.getCodeProfil()) || (this
						.getCodeProfil() != null
						&& castOther.getCodeProfil() != null && this
						.getCodeProfil().equals(castOther.getCodeProfil())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeUtilisateur() == null ? 0 : this.getCodeUtilisateur()
						.hashCode());
		result = 37
				* result
				+ (getCodeProfil() == null ? 0 : this.getCodeProfil()
						.hashCode());
		return result;
	}

}
