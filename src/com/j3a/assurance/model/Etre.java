package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

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
 * Etre generated by hbm2java
 */
@Entity
@Table(name = "etre", catalog = "zeusbd")
public class Etre implements java.io.Serializable {

	private EtreId id;
	private Personne personne;
	private TypePersonne typePersonne;
	private Date datePers;

	public Etre() {
	}

	public Etre(EtreId id, Personne personne, TypePersonne typePersonne) {
		this.id = id;
		this.personne = personne;
		this.typePersonne = typePersonne;
	}

	public Etre(EtreId id, Personne personne, TypePersonne typePersonne,
			Date datePers) {
		this.id = id;
		this.personne = personne;
		this.typePersonne = typePersonne;
		this.datePers = datePers;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numSouscripteur", column = @Column(name = "NUM_SOUSCRIPTEUR", nullable = false, length = 15)),
			@AttributeOverride(name = "codeTypePers", column = @Column(name = "CODE_TYPE_PERS", nullable = false)) })
	public EtreId getId() {
		return this.id;
	}

	public void setId(EtreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_SOUSCRIPTEUR", nullable = false, insertable = false, updatable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_TYPE_PERS", nullable = false, insertable = false, updatable = false)
	public TypePersonne getTypePersonne() {
		return this.typePersonne;
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		this.typePersonne = typePersonne;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PERS", length = 10)
	public Date getDatePers() {
		return this.datePers;
	}

	public void setDatePers(Date datePers) {
		this.datePers = datePers;
	}

}
