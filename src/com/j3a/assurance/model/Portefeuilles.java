package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Portefeuilles generated by hbm2java
 */
@Entity
@Table(name = "portefeuilles", catalog = "zeusbd")
public class Portefeuilles implements java.io.Serializable {

	private String codePortefeilles;
	private Achat achat;

	public Portefeuilles() {
	}

	public Portefeuilles(String codePortefeilles) {
		this.codePortefeilles = codePortefeilles;
	}

	public Portefeuilles(String codePortefeilles, Achat achat) {
		this.codePortefeilles = codePortefeilles;
		this.achat = achat;
	}

	@Id
	@Column(name = "CODE_PORTEFEILLES", unique = true, nullable = false, length = 20)
	public String getCodePortefeilles() {
		return this.codePortefeilles;
	}

	public void setCodePortefeilles(String codePortefeilles) {
		this.codePortefeilles = codePortefeilles;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "portefeuilles")
	public Achat getAchat() {
		return this.achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

}
