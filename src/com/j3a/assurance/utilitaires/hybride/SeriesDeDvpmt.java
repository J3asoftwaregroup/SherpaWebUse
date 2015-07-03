package com.j3a.assurance.utilitaires.hybride;

import java.math.BigDecimal;
import java.util.HashMap;

public class SeriesDeDvpmt {

	public SeriesDeDvpmt() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer anneeSurv;
	private String momtSurv;
	private BigDecimal MtanSinistre;
	private HashMap<Integer, BigDecimal> anneeMtant;
	public Integer getAnneeSurv() {
		return anneeSurv;
	}
	public void setAnneeSurv(Integer anneeSurv) {
		this.anneeSurv = anneeSurv;
	}
	public BigDecimal getMtanSinistre() {
		return MtanSinistre;
	}
	public void setMtanSinistre(BigDecimal mtanSinistre) {
		MtanSinistre = mtanSinistre;
	}
	public HashMap<Integer, BigDecimal> getAnneeMtant() {
		return anneeMtant;
	}
	public void setAnneeMtant(HashMap<Integer, BigDecimal> anneeMtant) {
		this.anneeMtant = anneeMtant;
	}
	public String getMomtSurv() {
		return momtSurv;
	}
	public void setMomtSurv(String momtSurv) {
		this.momtSurv = momtSurv;
	}
	
	
	
	
	

}
