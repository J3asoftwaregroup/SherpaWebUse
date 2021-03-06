package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ObligationExercice generated by hbm2java
 */
@Entity
@Table(name = "obligation_exercice", catalog = "zeusbd")
public class ObligationExercice implements java.io.Serializable {

	private ObligationExerciceId id;

	public ObligationExercice() {
	}

	public ObligationExercice(ObligationExerciceId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeEtatCima", column = @Column(name = "CODE_ETAT_CIMA", nullable = false, length = 20)),
			@AttributeOverride(name = "codeObEmp", column = @Column(name = "CODE_OB_EMP", nullable = false, length = 20)) })
	public ObligationExerciceId getId() {
		return this.id;
	}

	public void setId(ObligationExerciceId id) {
		this.id = id;
	}

}
