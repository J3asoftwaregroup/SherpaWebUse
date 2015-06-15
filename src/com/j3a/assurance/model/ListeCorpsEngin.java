package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ListeCorpsEngin generated by hbm2java
 */
@Entity
@Table(name = "liste_corps_engin", catalog = "zeusbd")
public class ListeCorpsEngin implements java.io.Serializable {

	private String codeListeCorpsEngin;
	private String libelleListeCorpsEngin;
	private Set corpsEngins = new HashSet(0);
	private Set avListeCorpsEngins = new HashSet(0);

	public ListeCorpsEngin() {
	}

	public ListeCorpsEngin(String codeListeCorpsEngin) {
		this.codeListeCorpsEngin = codeListeCorpsEngin;
	}

	public ListeCorpsEngin(String codeListeCorpsEngin,
			String libelleListeCorpsEngin, Set corpsEngins,
			Set avListeCorpsEngins) {
		this.codeListeCorpsEngin = codeListeCorpsEngin;
		this.libelleListeCorpsEngin = libelleListeCorpsEngin;
		this.corpsEngins = corpsEngins;
		this.avListeCorpsEngins = avListeCorpsEngins;
	}

	@Id
	@Column(name = "CODE_LISTE_CORPS_ENGIN", unique = true, nullable = false, length = 27)
	public String getCodeListeCorpsEngin() {
		return this.codeListeCorpsEngin;
	}

	public void setCodeListeCorpsEngin(String codeListeCorpsEngin) {
		this.codeListeCorpsEngin = codeListeCorpsEngin;
	}

	@Column(name = "LIBELLE_LISTE_CORPS_ENGIN", length = 50)
	public String getLibelleListeCorpsEngin() {
		return this.libelleListeCorpsEngin;
	}

	public void setLibelleListeCorpsEngin(String libelleListeCorpsEngin) {
		this.libelleListeCorpsEngin = libelleListeCorpsEngin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCorpsEngin")
	public Set getCorpsEngins() {
		return this.corpsEngins;
	}

	public void setCorpsEngins(Set corpsEngins) {
		this.corpsEngins = corpsEngins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listeCorpsEngin")
	public Set getAvListeCorpsEngins() {
		return this.avListeCorpsEngins;
	}

	public void setAvListeCorpsEngins(Set avListeCorpsEngins) {
		this.avListeCorpsEngins = avListeCorpsEngins;
	}

}
