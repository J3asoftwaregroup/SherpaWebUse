package com.j3a.sherpawebuser.prime.categorie;

import java.math.BigDecimal;

public class PrimeCategorie3 implements PrimeCategorieInterface {
	private String energie;
	private String typeVehicule;
	private java.math.BigDecimal puissFisc = BigDecimal.ZERO;
	private java.math.BigDecimal puissReel = BigDecimal.ZERO;
	private String categorie;
	private String zone;
	private String classe;
	private String statut;
	private java.math.BigDecimal primeBase = BigDecimal.ZERO;
	private boolean remorque;
	private java.math.BigDecimal primeRemorque = BigDecimal.ZERO;
	private java.math.BigDecimal surprimes = BigDecimal.ZERO;
	private String typeTransporte;
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

	/*---------------determination de la prime li�e aux garanties----------------------------------*/

	/*------------Determine la valeur de la prime de base------------------*/
	public java.math.BigDecimal getPrimeBase() {

		 primeBase = BigDecimal.ZERO;
		if (getChargeUtile().intValue() <= 1) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(133500);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(126825);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(120170);
		}

		if (getChargeUtile().intValue() > 1 && getChargeUtile().intValue() <= 3) {
			if (zone.equals("zone1"))
				// setPrimeBase(66885);
				primeBase = BigDecimal.valueOf(171300);
			if (zone.equals("zone2"))
				// setPrimeBase(63541);
				primeBase = BigDecimal.valueOf(162735);
			if (zone.equals("zone3"))
				// setPrimeBase(60197);
				primeBase = BigDecimal.valueOf(154170);
		}

		if (getChargeUtile().intValue() > 3 && getChargeUtile().intValue() <= 5) {
			if (zone.equals("zone1"))
				// setPrimeBase(73415);
				primeBase = BigDecimal.valueOf(215000);
			if (zone.equals("zone2"))
				// setPrimeBase(69744);
				primeBase = BigDecimal.valueOf(204250);
			if (zone.equals("zone3"))
				// setPrimeBase(66074);
				primeBase = BigDecimal.valueOf(193500);
		}
		if (getChargeUtile().intValue() > 5 && getChargeUtile().intValue() <= 9) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(269700);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(256215) ;
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(242730);
		}
		if (getChargeUtile().intValue() > 9 && getChargeUtile().intValue() <= 12) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(339400);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(322430);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(305460);
		}
		if (getChargeUtile().intValue() > 12 && getChargeUtile().intValue() <= 15) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(444500);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(422275);
			if (zone.equals("zone3"))
				// setPrimeBase(116152);
				primeBase = BigDecimal.valueOf(400050);
		}
		
		if (getChargeUtile().intValue() > 15|| getTypeVehicule().equalsIgnoreCase("VAT")) {
			if (zone.equals("zone1"))
				primeBase = BigDecimal.valueOf(489000);
			if (zone.equals("zone2"))
				primeBase = BigDecimal.valueOf(464500);
			if (zone.equals("zone3"))
				primeBase = BigDecimal.valueOf(440100);
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
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)) );
		}

		if (statut.equals("a") || statut.equals("b") || statut.equals("c")) {
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)));
		}

		if (statut.equals("d") || statut.equals("e")) {
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.10)));
		}

		if (remorque == true) {
			primeRemorque = primeRemorque.add(primeBase.multiply(BigDecimal.valueOf(0.1)));
		}
		
		reduction = red;
		//calcul de la surprime
		surprimes=BigDecimal.ZERO;
		if(typeTransporte.equalsIgnoreCase("TH")||typeTransporte.equalsIgnoreCase("TA")){
			
			surprimes=surprimes.add(primeBase.multiply(BigDecimal.valueOf(0.10)));	
		}
		
		
		primeRc = primeRc.add(primeRemorque).add(surprimes).subtract(reduction);

		return primeRc;
	}

	/*------------determination de la prime en defense recours--------------------------------*/
	public java.math.BigDecimal getDefenseRecours() {
		defenseRecours = primeRc.multiply(BigDecimal.valueOf(0.10));
		return defenseRecours;
	}

	public java.math.BigDecimal getDefenseRecoursDommage() {
		defenseRecoursDommage = BigDecimal.ZERO;
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
		dommage = getValeurNeuve().multiply(BigDecimal.valueOf(0.1235));
		return dommage;
	}
	
	public java.math.BigDecimal getCollision() {
		collision = getValeurNeuve().multiply(BigDecimal.valueOf(0.075));
		
		return collision;
	}

	/*-------------------determination de la prime en vol � main arm�e--------------------*/

	public java.math.BigDecimal getVolMain() {
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 4000000) {
			if(getAgeVehicule()<=2){
				volMain = volMain.add(BigDecimal.valueOf(18400));
			}else{
				volMain = volMain.add(BigDecimal.valueOf(9130));
			}
			
		}
		if (getValeurVenale().intValue() > 4000000 & getValeurVenale().intValue() <= 6000000) {
			if(getAgeVehicule()<=2){
				volMain = volMain.add(BigDecimal.valueOf(30690));
			}else{
				volMain = volMain.add(BigDecimal.valueOf(15410));
			}
		}
		if (getValeurVenale().intValue() > 6000000 & getValeurVenale().intValue() <= 10000000) {
			if(getAgeVehicule()<=2){
				volMain = volMain.add(BigDecimal.valueOf(49100));
			}else{
				volMain = volMain.add(BigDecimal.valueOf(24550));
			}
		}
		
		if (getValeurVenale().intValue() > 10000000 & getValeurVenale().intValue() <= 16000000) {
			if(getAgeVehicule()<=2){
				volMain = volMain.add(BigDecimal.valueOf(79780));
			}else{
				volMain = volMain.add(BigDecimal.valueOf(39960));
			}
		}

		if (getValeurVenale().intValue() > 16000000) {
			if(getAgeVehicule()<=2){
				volMain = volMain.add(BigDecimal.valueOf(122750));
			}else{
				volMain = volMain.add(BigDecimal.valueOf(61370));
			}
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
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 4000000) {
			if(getAgeVehicule()<=2){
				incendie = incendie.add(BigDecimal.valueOf(50015));
			}else{
				incendie = incendie.add(BigDecimal.valueOf(24815));
			}
			
		}
		if (getValeurVenale().intValue() > 4000000 & getValeurVenale().intValue() <= 6000000) {
			if(getAgeVehicule()<=2){
				incendie = incendie.add(BigDecimal.valueOf(83860));
			}else{
				incendie = incendie.add(BigDecimal.valueOf(41875));
			}
		}
		if (getValeurVenale().intValue() > 6000000 & getValeurVenale().intValue() <= 10000000) {
			if(getAgeVehicule()<=2){
				incendie = incendie.add(BigDecimal.valueOf(133380));
			}else{
				incendie = incendie.add(BigDecimal.valueOf(66690));
			}
		}
		
		if (getValeurVenale().intValue() > 10000000 & getValeurVenale().intValue() <= 16000000) {
			if(getAgeVehicule()<=2){
				incendie = incendie.add(BigDecimal.valueOf(216740));
			}else{
				incendie = incendie.add(BigDecimal.valueOf(108565));
			}
		}

		if (getValeurVenale().intValue() > 16000000) {
			if(getAgeVehicule()<=2){
				incendie = incendie.add(BigDecimal.valueOf(333445));
			}else{
				incendie = incendie.add(BigDecimal.valueOf(166725));
			}
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
		return individuelChauf1;
	}
	
	public java.math.BigDecimal getIndividuelChauf2(){
		return individuelChauf2;
	}
	
	public java.math.BigDecimal getIndividuelChauf3(){
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

	public String getTypeVehicule() {
		return typeVehicule;
	}


	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
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

	public void setNbreTransporte(short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
	}

	public short getNbrecarte() {
		return nbrecarte;
	}

	public void setNbrecarte(short nbrecarte) {
		this.nbrecarte = nbrecarte;
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

	public java.math.BigDecimal getPuissReel() {
		return puissReel;
	}

	public void setPuissReel(java.math.BigDecimal puissReel) {
		this.puissReel = puissReel;
	}

	public int getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(int dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public int getAgeVehicule() {
		return ageVehicule;
	}

	public void setAgeVehicule(int ageVehicule) {
		this.ageVehicule = ageVehicule;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
