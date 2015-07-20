package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PersonnecautExercice generated by hbm2java
 */
@Entity
@Table(name = "personnecaut_exercice", catalog = "zeusbd")
public class PersonnecautExercice implements java.io.Serializable {

	private PersonnecautExerciceId id;

	public PersonnecautExercice() {
	}

	public PersonnecautExercice(PersonnecautExerciceId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeEtatCima", column = @Column(name = "CODE_ETAT_CIMA", nullable = false, length = 20)),
			@AttributeOverride(name = "codePersCaut", column = @Column(name = "CODE_PERS_CAUT", nullable = false, length = 20)) })
	public PersonnecautExerciceId getId() {
		return this.id;
	}

	public void setId(PersonnecautExerciceId id) {
		this.id = id;
	}

}