package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * TypeApporteurCategorie generated by hbm2java
 */
@Entity
@Table(name = "type_apporteur_categorie", catalog = "zeusbd")
public class TypeApporteurCategorie implements java.io.Serializable {

	private TypeApporteurCategorieId id;
	private Categorie categorie;
	private TypeApporteur typeApporteur;
	private BigDecimal tauxComApporteurCategorie;
	private Date dateApporteurCategorie;

	public TypeApporteurCategorie() {
	}

	public TypeApporteurCategorie(TypeApporteurCategorieId id,
			Categorie categorie, TypeApporteur typeApporteur) {
		this.id = id;
		this.categorie = categorie;
		this.typeApporteur = typeApporteur;
	}

	public TypeApporteurCategorie(TypeApporteurCategorieId id,
			Categorie categorie, TypeApporteur typeApporteur,
			BigDecimal tauxComApporteurCategorie, Date dateApporteurCategorie) {
		this.id = id;
		this.categorie = categorie;
		this.typeApporteur = typeApporteur;
		this.tauxComApporteurCategorie = tauxComApporteurCategorie;
		this.dateApporteurCategorie = dateApporteurCategorie;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idType", column = @Column(name = "ID_TYPE", nullable = false, length = 10)),
			@AttributeOverride(name = "codeCategorie", column = @Column(name = "CODE_CATEGORIE", nullable = false, length = 15)) })
	public TypeApporteurCategorieId getId() {
		return this.id;
	}

	public void setId(TypeApporteurCategorieId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CATEGORIE", nullable = false, insertable = false, updatable = false)
	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TYPE", nullable = false, insertable = false, updatable = false)
	public TypeApporteur getTypeApporteur() {
		return this.typeApporteur;
	}

	public void setTypeApporteur(TypeApporteur typeApporteur) {
		this.typeApporteur = typeApporteur;
	}

	@Column(name = "TAUX_COM_APPORTEUR_CATEGORIE", precision = 6, scale = 4)
	public BigDecimal getTauxComApporteurCategorie() {
		return this.tauxComApporteurCategorie;
	}

	public void setTauxComApporteurCategorie(
			BigDecimal tauxComApporteurCategorie) {
		this.tauxComApporteurCategorie = tauxComApporteurCategorie;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_APPORTEUR_CATEGORIE", length = 19)
	public Date getDateApporteurCategorie() {
		return this.dateApporteurCategorie;
	}

	public void setDateApporteurCategorie(Date dateApporteurCategorie) {
		this.dateApporteurCategorie = dateApporteurCategorie;
	}

}
