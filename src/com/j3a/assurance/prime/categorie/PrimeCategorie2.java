package com.j3a.sherpawebuser.prime.categorie;

import java.math.BigDecimal;

public class PrimeCategorie2 implements PrimeCategorieInterface {

	private String energie;
	private String typeVehicule;
	private java.math.BigDecimal puissFisc = BigDecimal.ZERO;
	private String zone;
	private String categorie;
	private String classe;
	private String statut;
	private java.math.BigDecimal primeBase = BigDecimal.ZERO;
	private boolean remorque;
	private java.math.BigDecimal primeRemorque = BigDecimal.ZERO;
	private java.math.BigDecimal surprimes = BigDecimal.ZERO;
	private String typeTransporte="";
	private java.math.BigDecimal primeRc = BigDecimal.ZERO;
	private java.math.BigDecimal defenseRecours = BigDecimal.ZERO;
	private java.math.BigDecimal defenseRecoursDommage = BigDecimal.ZERO;
	private java.math.BigDecimal immobilisation = BigDecimal.ZERO;
	private java.math.BigDecimal remboursemmentAnticipe = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRC = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRNC1 = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRNC2 = BigDecimal.ZERO;
	private java.math.BigDecimal valeurVenale = BigDecimal.ZERO;
	private java.math.BigDecimal valeurNeuve = BigDecimal.ZERO;
	private int dureePermis;
	private java.math.BigDecimal dommage = BigDecimal.ZERO;
	private java.math.BigDecimal collision = BigDecimal.ZERO;
	private java.math.BigDecimal volMain = BigDecimal.ZERO;
	private java.math.BigDecimal volAccessoires = BigDecimal.ZERO;
	private java.math.BigDecimal volVandalisme = BigDecimal.ZERO;
	private java.math.BigDecimal montantAccessoires = BigDecimal.ZERO;
	private java.math.BigDecimal incendie = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere1 = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere2 = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere3= BigDecimal.ZERO;
	private String optionSR;
	private java.math.BigDecimal chargeUtile= BigDecimal.ZERO;
	private java.math.BigDecimal individuelChauf1 = BigDecimal.ZERO;
	private java.math.BigDecimal individuelChauf2 = BigDecimal.ZERO;
	private java.math.BigDecimal individuelChauf3 = BigDecimal.ZERO;
	private java.math.BigDecimal reduction = BigDecimal.ZERO;
	private String optionIndCh;
	private int dureeContrat;
	private int ageVehicule;
	private short nbreTransporte;
	private short nbrecarte;
	private short nbrePlaceCab;
	private short nbrePlaceHorscab;

//	private double prime = 0;

	/*---------------determination de la prime li�e aux garanties----------------------------------*/

	/*------------Determine la valeur de la prime de base------------------*/
	public java.math.BigDecimal getPrimeBase() {

		 primeBase = BigDecimal.ZERO;
		if (getChargeUtile().doubleValue() <= 1) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(118965);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(113017);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(107069);
		}

		if (getChargeUtile().intValue() > 1 & getChargeUtile().intValue() <= 3) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(155190);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(147431);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(139671);
		}

		if (getChargeUtile().intValue() > 3 & getChargeUtile().intValue() <= 5) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(189715);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(180229);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(170744);
		}
		
		if (getChargeUtile().intValue() > 5 & getChargeUtile().intValue() <= 8) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(244617);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(232386);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(220155);
		}
		
		if (getChargeUtile().intValue() > 8 & getChargeUtile().intValue() <= 11) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(260925);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(247879);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(234833);
		}
		
		if (getChargeUtile().intValue() > 11 & getChargeUtile().intValue() <= 13) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(273407);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(259737);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(246066);
		}
		
		if (getChargeUtile().intValue() > 13 & getChargeUtile().intValue() <= 15) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(329405);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(312935);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(296465);
		}
		
		if (getChargeUtile().intValue() > 15) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(431327);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(409761);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(388194);
		}
		
		if(getTypeVehicule().equals("VAT")){
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(463925);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(440729);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(418692);
			
		}
		
		
		
		
		return primeBase;
	}

	/*---------------	calcul de la prime RC-------------------------------*/
	public java.math.BigDecimal getPrimeRc() {
		java.math.BigDecimal red = BigDecimal.ZERO;
		primeRc = getPrimeBase();
		if (dureePermis <= 2) {
			classe = "classe1";
		}
		if (dureePermis > 2) {
			classe = "classe2";
		}

		if (classe.equals("classe2")) {
			//primeRc = primeRc.multiply(BigDecimal.valueOf(0.95));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)));
		}

		if (statut.equals("a") || statut.equals("b") || statut.equals("c")) {
		//	primeRc = primeRc.multiply(BigDecimal.valueOf(0.95));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)));
		}

		if (statut.equals("d") || statut.equals("e")) {
			//primeRc = primeRc.multiply(BigDecimal.valueOf(0.90));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.1)));
		}
		
		if(getTypeVehicule().equals("VAT")){
			
			
		}else{
			
			if (remorque == true) {
				//primeRc = primeRc.multiply(BigDecimal.valueOf(1.2));
				primeRemorque = primeRemorque.add(primeBase.multiply(BigDecimal.valueOf(0.2)));
			
			}
		}
		
		reduction = red;
		//calcul de la surprime
		surprimes=BigDecimal.ZERO;
		nbreTransporte = (short) (nbrePlaceCab + nbrePlaceHorscab-3);
		if(nbreTransporte>0){
		surprimes=surprimes.add(BigDecimal.valueOf((double)nbreTransporte*2500));
		}
		if(typeTransporte.equalsIgnoreCase("TE")||typeTransporte.equalsIgnoreCase("TEM")){
			
			surprimes=surprimes.add(primeBase.multiply(BigDecimal.valueOf(0.15)));	
		}
		if(typeTransporte.equalsIgnoreCase("TH")||typeTransporte.equalsIgnoreCase("TA")){
			
			surprimes=surprimes.add(primeBase.multiply(BigDecimal.valueOf(0.10)));	
		}
		
		primeRc = primeRc.add(primeRemorque).add(surprimes).subtract(reduction);
		return primeRc;
	}

	/*------------determination de la prime en defense recours--------------------------------*/
	public java.math.BigDecimal getDefenseRecours() {
		defenseRecours = BigDecimal.valueOf(7950);
		return defenseRecours;
	}

	public java.math.BigDecimal getDefenseRecoursDommage() {
		defenseRecoursDommage = BigDecimal.valueOf(4240);
		return defenseRecoursDommage;
	}

	/*-------------------determination de la prime en immobilisation--------------------*/
	public java.math.BigDecimal getImmobilisation() {
		immobilisation = BigDecimal.valueOf(17000);
		return immobilisation;
	}

	/*-------------------determination de la prime en remboursement anticipe--------------------*/
	public java.math.BigDecimal getRemboursemmentAnticipe() {
		if(dureeContrat<12){
		remboursemmentAnticipe = BigDecimal.valueOf(15000);
		}else{
		remboursemmentAnticipe = BigDecimal.valueOf(10000);
		}
		return remboursemmentAnticipe;
	}

	/*-------------------determination de la prime en brise de glace--------------------*/
	public java.math.BigDecimal getBrisGlaceRC() {
		
		brisGlaceRC = getValeurNeuve().multiply(BigDecimal.valueOf(0.003));
		return brisGlaceRC;
	}
	
	public java.math.BigDecimal getBrisGlaceRNC1() {
		
		brisGlaceRNC1 = getValeurNeuve().multiply(BigDecimal.valueOf(0.0047));
		return brisGlaceRNC1;
	}
	public java.math.BigDecimal getBrisGlaceRNC2() {
		
		brisGlaceRNC2 = getValeurNeuve().multiply(BigDecimal.valueOf(0.004));
		return brisGlaceRNC2;
	}

	/*-------------------determination de la prime en dommage--------------------*/
	public java.math.BigDecimal getDommage() {
		dommage = getValeurNeuve().multiply(BigDecimal.valueOf(0.12));
		return dommage;
	}
	
	public java.math.BigDecimal getCollision() {
		collision = getValeurNeuve().multiply(BigDecimal.valueOf(0.05));
		
		return collision;
	}

	/*-------------------determination de la prime en vol � main arm�e--------------------*/

	public java.math.BigDecimal getVolMain() {
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 10000000) {
			volMain = getValeurVenale().multiply(BigDecimal.valueOf(0.015));
		}
		if (getValeurVenale().intValue() > 1000000) {
			volMain = getValeurVenale().multiply(BigDecimal.valueOf(0.025));
		}
		return volMain;
	}

	/*-------------------determination de la prime en vol accessoires--------------------*/
	public java.math.BigDecimal getVolAccessoires() {
		volAccessoires = BigDecimal.ZERO;
		return volAccessoires;
	}
	/*-------------------determination de la prime en vol vandalisme--------------------*/
	public java.math.BigDecimal getVolVandalisme() {
		volVandalisme = BigDecimal.ZERO;
		return volVandalisme;
	}

	/*-------------------determination de la prime en incendie--------------------*/

	public java.math.BigDecimal getIncendie() {
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 10000000) {
			incendie = getValeurVenale().multiply(BigDecimal.valueOf(0.007));
		}
		if (getValeurVenale().intValue() >= 10000001) {
			incendie = getValeurVenale().multiply(BigDecimal.valueOf(0.5));
		}
		return incendie;
	}

	/*-------------------determination de la prime en securit�--------------------*/
	public java.math.BigDecimal getSecuriteRoutiere1() {
		securiteRoutiere1 = BigDecimal.ZERO;
		return securiteRoutiere1;
	}
	
	public java.math.BigDecimal getSecuriteRoutiere2() {
		securiteRoutiere2 = BigDecimal.ZERO;
		return securiteRoutiere2;
	}
	public java.math.BigDecimal getSecuriteRoutiere3() {
		securiteRoutiere3 = BigDecimal.ZERO;
		return securiteRoutiere3;
	}
	
	public java.math.BigDecimal getIndividuelChauf1(){
		individuelChauf1 = BigDecimal.valueOf(10000);
		return individuelChauf1;
	}
	
	public java.math.BigDecimal getIndividuelChauf2(){
		individuelChauf2 = BigDecimal.valueOf(15000);
		return individuelChauf2;
	}
	
	public java.math.BigDecimal getIndividuelChauf3(){
		individuelChauf3 = BigDecimal.valueOf(19250);
		return individuelChauf3;
	}

	/*----------les Setters --------------------------------------------------------------*/

	public void setPrimeRc(java.math.BigDecimal primeRc) {
		this.primeRc = primeRc;
	}


	/*--------------autres Getter and setter------------------------------*/
	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public java.math.BigDecimal getPuissFisc() {
		return puissFisc;
	}

	public void setPuissFisc(java.math.BigDecimal puissFisc) {
		this.puissFisc = puissFisc;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isRemorque() {
		return remorque;
	}

	public void setRemorque(boolean remorque) {
		this.remorque = remorque;
	}

	public int getDureePermis() {
		return dureePermis;
	}

	public void setDureePermis(int dureePermis) {
		this.dureePermis = dureePermis;
	}

	public void setValeurNeuve(java.math.BigDecimal valeurNeuve) {
		this.valeurNeuve = valeurNeuve;
	}

	public java.math.BigDecimal getMontantAccessoires() {
		return montantAccessoires;
	}

	public void setMontantAccessoires(java.math.BigDecimal montantAccessoires) {
		this.montantAccessoires = montantAccessoires;
	}

	public String getOptionSR() {
		return optionSR;
	}

	public void setOptionSR(String optionSR) {
		this.optionSR = optionSR;
	}

	public java.math.BigDecimal getValeurVenale() {
		return valeurVenale;
	}

	public void setValeurVenale(java.math.BigDecimal valeurVenale) {
		this.valeurVenale = valeurVenale;
	}

	public java.math.BigDecimal getValeurNeuve() {
		return valeurNeuve;
	}

	public void setPrimeBase(java.math.BigDecimal primeBase) {
		this.primeBase = primeBase;
	}


	public String getOptionIndCh() {
		return optionIndCh;
	}

	public void setOptionIndCh(String optionIndCh) {
		this.optionIndCh = optionIndCh;
	}


	
	public BigDecimal getPuissReel() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public void setPuissReel(BigDecimal puissReel) {
		// TODO Auto-generated method stub
		
	}


	public String getTypeVehicule() {
		return typeVehicule;
	}


	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}



	public int getDureeContrat() {
		// TODO Auto-generated method stub
		return dureeContrat;
	}



	public void setDureeContrat(int dureeContrat) {
		// TODO Auto-generated method stub
		this.dureeContrat = dureeContrat;
	}



	public int getAgeVehicule() {
		// TODO Auto-generated method stub
		return ageVehicule;
	}


	
	public void setAgeVehicule(int ageVehicule) {
		// TODO Auto-generated method stub
		this.ageVehicule = ageVehicule;
	}


	public java.math.BigDecimal getReduction() {
		return reduction;
	}
	public void setReduction(java.math.BigDecimal reduction) {
		this.reduction = reduction;
	}

	public java.math.BigDecimal getPrimeRemorque() {
		return primeRemorque;
	}

	public void setPrimeRemorque(java.math.BigDecimal primeRemorque) {
		this.primeRemorque = primeRemorque;
	}

	public java.math.BigDecimal getChargeUtile() {
		return chargeUtile;
	}

	public void setChargeUtile(java.math.BigDecimal chargeUtile) {
		this.chargeUtile = chargeUtile;
	}
	public java.math.BigDecimal getSurprimes() {
		return surprimes;
	}
	public void setSurprimes(java.math.BigDecimal surprimes) {
		this.surprimes = surprimes;
	}

	public String getTypeTransporte() {
		return typeTransporte;
	}

	public void setTypeTransporte(String typeTransporte) {
		this.typeTransporte = typeTransporte;
	}

	public short getNbreTransporte() {
		return nbreTransporte;
	}

	public void setNbreTransporte(Short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
	}

	public short getNbrePlaceCab() {
		return nbrePlaceCab;
	}

	public void setNbrePlaceCab(short nbrePlaceCab) {
		this.nbrePlaceCab = nbrePlaceCab;
	}

	public short getNbrePlaceHorscab() {
		return nbrePlaceHorscab;
	}

	public void setNbrePlaceHorscab(short nbrePlaceHorscab) {
		this.nbrePlaceHorscab = nbrePlaceHorscab;
	}

	public short getNbrecarte() {
		return nbrecarte;
	}

	public void setNbrecarte(short nbrecarte) {
		this.nbrecarte = nbrecarte;
	}

	public void setNbreTransporte(short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
