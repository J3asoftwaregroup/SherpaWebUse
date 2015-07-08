package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Etatc10aCategorieId generated by hbm2java
 */
@Embeddable
public class Etatc10aCategorieId implements java.io.Serializable {

	private String codecategoriecima;
	private String codeEtatc10a;

	public Etatc10aCategorieId() {
	}

	public Etatc10aCategorieId(String codecategoriecima, String codeEtatc10a) {
		this.codecategoriecima = codecategoriecima;
		this.codeEtatc10a = codeEtatc10a;
	}

	@Column(name = "CODECATEGORIECIMA", nullable = false, length = 20)
	public String getCodecategoriecima() {
		return this.codecategoriecima;
	}

	public void setCodecategoriecima(String codecategoriecima) {
		this.codecategoriecima = codecategoriecima;
	}

	@Column(name = "CODE_ETATC10A", nullable = false, length = 20)
	public String getCodeEtatc10a() {
		return this.codeEtatc10a;
	}

	public void setCodeEtatc10a(String codeEtatc10a) {
		this.codeEtatc10a = codeEtatc10a;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Etatc10aCategorieId))
			return false;
		Etatc10aCategorieId castOther = (Etatc10aCategorieId) other;

		return ((this.getCodecategoriecima() == castOther
				.getCodecategoriecima()) || (this.getCodecategoriecima() != null
				&& castOther.getCodecategoriecima() != null && this
				.getCodecategoriecima()
				.equals(castOther.getCodecategoriecima())))
				&& ((this.getCodeEtatc10a() == castOther.getCodeEtatc10a()) || (this
						.getCodeEtatc10a() != null
						&& castOther.getCodeEtatc10a() != null && this
						.getCodeEtatc10a().equals(castOther.getCodeEtatc10a())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodecategoriecima() == null ? 0 : this
						.getCodecategoriecima().hashCode());
		result = 37
				* result
				+ (getCodeEtatc10a() == null ? 0 : this.getCodeEtatc10a()
						.hashCode());
		return result;
	}

}
