package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProfilUtilisateur generated by hbm2java
 */
@Entity
@Table(name = "profil_utilisateur", catalog = "zeusbd")
public class ProfilUtilisateur implements java.io.Serializable {

	private ProfilUtilisateurId id;
	private Profil profil;
	private Utilisateur utilisateur;
	private Date dateProfilUtilisateur;

	public ProfilUtilisateur() {
	}

	public ProfilUtilisateur(ProfilUtilisateurId id, Profil profil,
			Utilisateur utilisateur) {
		this.id = id;
		this.profil = profil;
		this.utilisateur = utilisateur;
	}

	public ProfilUtilisateur(ProfilUtilisateurId id, Profil profil,
			Utilisateur utilisateur, Date dateProfilUtilisateur) {
		this.id = id;
		this.profil = profil;
		this.utilisateur = utilisateur;
		this.dateProfilUtilisateur = dateProfilUtilisateur;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeUtilisateur", column = @Column(name = "CODE_UTILISATEUR", nullable = false, length = 10)),
			@AttributeOverride(name = "codeProfil", column = @Column(name = "CODE_PROFIL", nullable = false, length = 10)) })
	public ProfilUtilisateurId getId() {
		return this.id;
	}

	public void setId(ProfilUtilisateurId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_PROFIL", nullable = false, insertable = false, updatable = false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_UTILISATEUR", nullable = false, insertable = false, updatable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PROFIL_UTILISATEUR", length = 10)
	public Date getDateProfilUtilisateur() {
		return this.dateProfilUtilisateur;
	}

	public void setDateProfilUtilisateur(Date dateProfilUtilisateur) {
		this.dateProfilUtilisateur = dateProfilUtilisateur;
	}

}
