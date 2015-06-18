package com.j3a.assurance.model;

// Generated 16 juin 2015 18:00:51 by Hibernate Tools 4.3.1

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
 * PersonneNationalite generated by hbm2java
 */
@Entity
@Table(name = "personne_nationalite", catalog = "zeusbd")
public class PersonneNationalite implements java.io.Serializable {

	private PersonneNationaliteId id;
	private Nationalite nationalite;
	private Personne personne;
	private Date dateNationalite;

	public PersonneNationalite() {
	}

	public PersonneNationalite(PersonneNationaliteId id,
			Nationalite nationalite, Personne personne) {
		this.id = id;
		this.nationalite = nationalite;
		this.personne = personne;
	}

	public PersonneNationalite(PersonneNationaliteId id,
			Nationalite nationalite, Personne personne, Date dateNationalite) {
		this.id = id;
		this.nationalite = nationalite;
		this.personne = personne;
		this.dateNationalite = dateNationalite;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeNationalite", column = @Column(name = "CODE_NATIONALITE", nullable = false)),
			@AttributeOverride(name = "numSouscripteur", column = @Column(name = "NUM_SOUSCRIPTEUR", nullable = false, length = 15)) })
	public PersonneNationaliteId getId() {
		return this.id;
	}

	public void setId(PersonneNationaliteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_NATIONALITE", nullable = false, insertable = false, updatable = false)
	public Nationalite getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_SOUSCRIPTEUR", nullable = false, insertable = false, updatable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NATIONALITE", length = 10)
	public Date getDateNationalite() {
		return this.dateNationalite;
	}

	public void setDateNationalite(Date dateNationalite) {
		this.dateNationalite = dateNationalite;
	}

}
