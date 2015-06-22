package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ListeAffilie generated by hbm2java
 */
@Entity
@Table(name = "liste_affilie", catalog = "zeusbd")
public class ListeAffilie implements java.io.Serializable {

	private String codeListeAffilie;
	private AdherentsSante adherentsSante;
	private String libelleListeAffilie;
	private Set<AffilieListeAffilie> affilieListeAffilies = new HashSet<AffilieListeAffilie>(
			0);

	public ListeAffilie() {
	}

	public ListeAffilie(String codeListeAffilie) {
		this.codeListeAffilie = codeListeAffilie;
	}

	public ListeAffilie(String codeListeAffilie, AdherentsSante adherentsSante,
			String libelleListeAffilie,
			Set<AffilieListeAffilie> affilieListeAffilies) {
		this.codeListeAffilie = codeListeAffilie;
		this.adherentsSante = adherentsSante;
		this.libelleListeAffilie = libelleListeAffilie;
		this.affilieListeAffilies = affilieListeAffilies;
	}

	@Id
	@Column(name = "CODE_LISTE_AFFILIE", unique = true, nullable = false, length = 60)
	public String getCodeListeAffilie() {
		return this.codeListeAffilie;
	}

	public void setCodeListeAffilie(String codeListeAffilie) {
		this.codeListeAffilie = codeListeAffilie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ADHERENT")
	public AdherentsSante getAdherentsSante() {
		return this.adherentsSante;
	}

	public void setAdherentsSante(AdherentsSante adherentsSante) {
		this.adherentsSante = adherentsSante;
	}

	@Column(name = "LIBELLE_LISTE_AFFILIE", length = 60)
	public String getLibelleListeAffilie() {
		return this.libelleListeAffilie;
	}

	public void setLibelleListeAffilie(String libelleListeAffilie) {
		this.libelleListeAffilie = libelleListeAffilie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeAffilie")
	public Set<AffilieListeAffilie> getAffilieListeAffilies() {
		return this.affilieListeAffilies;
	}

	public void setAffilieListeAffilies(
			Set<AffilieListeAffilie> affilieListeAffilies) {
		this.affilieListeAffilies = affilieListeAffilies;
	}

}
