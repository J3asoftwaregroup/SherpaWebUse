package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Compagnie generated by hbm2java
 */
@Entity
@Table(name = "compagnie", catalog = "zeusbd")
public class Compagnie implements java.io.Serializable {

	private String codeCompagnie;
	private String raisonSocialCompagnie;
	private Set<CoassuranceCompagnie> coassuranceCompagnies = new HashSet<CoassuranceCompagnie>(
			0);
	private Set<ReassuranceCompagnie> reassuranceCompagnies = new HashSet<ReassuranceCompagnie>(
			0);

	public Compagnie() {
	}

	public Compagnie(String codeCompagnie) {
		this.codeCompagnie = codeCompagnie;
	}

	public Compagnie(String codeCompagnie, String raisonSocialCompagnie,
			Set<CoassuranceCompagnie> coassuranceCompagnies,
			Set<ReassuranceCompagnie> reassuranceCompagnies) {
		this.codeCompagnie = codeCompagnie;
		this.raisonSocialCompagnie = raisonSocialCompagnie;
		this.coassuranceCompagnies = coassuranceCompagnies;
		this.reassuranceCompagnies = reassuranceCompagnies;
	}

	@Id
	@Column(name = "CODE_COMPAGNIE", unique = true, nullable = false, length = 10)
	public String getCodeCompagnie() {
		return this.codeCompagnie;
	}

	public void setCodeCompagnie(String codeCompagnie) {
		this.codeCompagnie = codeCompagnie;
	}

	@Column(name = "RAISON_SOCIAL_COMPAGNIE", length = 40)
	public String getRaisonSocialCompagnie() {
		return this.raisonSocialCompagnie;
	}

	public void setRaisonSocialCompagnie(String raisonSocialCompagnie) {
		this.raisonSocialCompagnie = raisonSocialCompagnie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compagnie")
	public Set<CoassuranceCompagnie> getCoassuranceCompagnies() {
		return this.coassuranceCompagnies;
	}

	public void setCoassuranceCompagnies(
			Set<CoassuranceCompagnie> coassuranceCompagnies) {
		this.coassuranceCompagnies = coassuranceCompagnies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compagnie")
	public Set<ReassuranceCompagnie> getReassuranceCompagnies() {
		return this.reassuranceCompagnies;
	}

	public void setReassuranceCompagnies(
			Set<ReassuranceCompagnie> reassuranceCompagnies) {
		this.reassuranceCompagnies = reassuranceCompagnies;
	}

}
