package com.j3a.assurance.utilitaires.hybride;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.j3a.assurance.model.AssureIa;
import com.j3a.assurance.model.AssureIaSinistre;
import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Garantie;
import com.j3a.assurance.model.GarantieChoisieIa;
import com.j3a.assurance.model.GarantieGarantieChoisieIa;
import com.j3a.assurance.model.ListeAssureIa;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Quittance;
import com.j3a.assurance.model.Sinistre;
import com.j3a.assurance.model.Victime;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.Garanties;
import com.j3a.assurance.utilitaire.IdGenerateur;





@Transactional
@Component 
@Scope("session")
public class ManagedSinistreIA {
	
	
	private String numPolice;
	private Personne numSouscripteur;
	private Contrat slctdContrat;
	private Avenant lastAvenant = new Avenant();
	private Avenant currAvenant = new Avenant();
	private List<Sinistre> sinistreList = new ArrayList<Sinistre>();
	private List<AssureRow> assurRwList = new ArrayList<AssureRow>();
	private AssureRow slctdAssurIA;
	private AssureIaSinistre assurIASin = new AssureIaSinistre(new AssureIaSinistreId(new Sinistre(), new AssureIa()));
	private Date dateSurvnce;
	private boolean showNav = false; 
	//protected MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
	private BigDecimal totalPrimeNet=BigDecimal.ZERO, totalPrimeEncaiss=BigDecimal.ZERO, solde=BigDecimal.ZERO;
	private String WarnMsg,etatVictime;
	private Victime v ;
	
	
	
	@Autowired
	private ObjectService objectService;	
	
	@Autowired
	private IdGenerateur idGenerateur;
	
	@Autowired
	InfoAvenantContrat infoAvenantContrat;

	public ManagedSinistreIA(){
		
	}
	
	public void retriveContrat() {
		System.out.println("Après Requête...........................");
		Contrat Ctrat = (Contrat) getObjectService()
				.getObjectById(getNumPolice(), "Contrat");
		System.out.println("Après Requête...........................");
		// 1Recupéré en Base le contrat dont le numéro a été saisit par
		// l'utilisateur
		// Si (le contrat existe){
		// Si (Le contrat est valide -Verification de la validité du Contrat-){
		// Recupération du Souscripteur Physique / Morale
		// Récupération des véhicules(VehiculeRow) en cours dans la flotte
		// }Sinon{
		// Alerter l'utilisateur que le Contrat a un bleme de validité avec des
		// détails sur le pbe
		// }
		// }Sinon{
		// Alerter L'utilisateur que Ce Contrat n'existe pas
		// }
		//

		if (Ctrat != null) {
			setLastAvenant(getInfoAvenantContrat()
					.DernierAvenant(Ctrat.getNumPolice()));

			System.out.println("Dernier Avenant..........................."
					+ getLastAvenant().getNumAvenant());

			if (isValidCtra(getLastAvenant())) {
				setSlctdContrat(Ctrat);
				setNumSouscripteur(Ctrat.getPersonne());
				setAssurRwList(loadAssureList(Ctrat));
				setSinistreList( new ArrayList<Sinistre>(Ctrat.getSinistres()));
				getAssurIASin().setDateSinistreIa(Calendar.getInstance().getTime());
				setShowNav(true);
			} else {
				setShowNav(false);
				System.out.println("Test Bte Dlg...........................");
				RequestContext.getCurrentInstance().execute("NoSlctd.show();");
			}

		}else {
			setShowNav(false);
			setWarnMsg("Ce contrat n'existe pas en BD");
			RequestContext.getCurrentInstance().execute("NoSlctd.show();");
		}
	}

	
	public void checkDatSurv(){
		setCurrAvenant(findCurrAvenant(getSlctdContrat()));
		if(getCurrAvenant()==null){
			setWarnMsg("La date de survenance ne correspond pas à une periode de validité du contrat");
			setDateSurvnce(null);
			RequestContext.getCurrentInstance().execute("NoSlctd.show();");
		}else{
			if (getAssurIASin().getDateSinistreIa().before(getDateSurvnce())){
				setWarnMsg("La date de déclaration ne peut être inférieure ou égale à la date de survenance. ");
				getAssurIASin().getId().getCodeSinistre().setDateDeclaration(null);
				RequestContext.getCurrentInstance().execute("NoSlctd.show();");
			}else{
			getAssurIASin().getId().setCodeSinistre().setNumPolice(getSlctdContrat());
			getAssurIASin().getId().setCodeSinistre(getIdGenerateur().getIdSinistre(getSlctdContrat()));
			getAssurIASin().getId().getCodeSinistre().setDateSurvenance(getDateSurvnce());
			
			}
			
		}
	}
	
	
	public void checkDatDecl(){
		System.out.println("getAssurIASin().getId().getCodeSinistre().getDateDeclaration()..........................."+getAssurIASin().getId().getCodeSinistre().getDateDeclaration());
		
		if (getAssurIASin().getDateSinistreIa().before(getDateSurvnce())){
			setWarnMsg("La date de déclaration ne peut être inférieure ou égale à la date de survenance ");
			getAssurIASin().getId().getCodeSinistre().setDateDeclaration(null);
			RequestContext.getCurrentInstance().execute("NoSlctd.show();");
		}
	}
	
	
	
	
	public void prepareRecord(){
		//Sinistre --->OK
		getAssurIASin().getId().getCodeSinistre().setDateDeclaration(getAssurIASin().getDateSinistreIa());
		getAssurIASin().getId().getCodeSinistre().setCirconstance(getAssurIASin().getCirconstancesSinistre());
		
		//AssureIASin
		getAssurIASin().getId().setNumIdentification(getSlctdAssurIA().getAssure());
		//Victime
		v = new Victime(getIdGenerateur().getIdVictime(getAssurIASin().getId().getCodeSinistre()));
		v.setNomVictime(getSlctdAssurIA().getAssure().getNomAssIa());
		v.setPrenomVictime(getSlctdAssurIA().getAssure().getPrenomAssIa());
		v.setDateNaissVictime(getSlctdAssurIA().getAssure().getDatenaissAssIa());
		v.setAdresseVictime(getSlctdAssurIA().getAssure().getAdresseAssIa());
		v.setProfessionVictime(getSlctdAssurIA().getAssure().getProfessionAssIa());
		v.setEtatVictime(getEtatVictime());
		v.setSommePrejudice(BigDecimal.ZERO);
		v.setEtatIndemniser(false);
		v.setSinistre(getAssurIASin().getId().getCodeSinistre());
		
	}
	


	
	public String validerAndHome(){
		///Recording First
		try {
			getObjectService().addObject(getAssurIASin().getId().getCodeSinistre());
			getObjectService().addObject(getAssurIASin());
			getObjectService().addObject(getV());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("managedSinistreIA");
		sessionMap.remove("objectService");
		sessionMap.remove("idGenerateur");
		sessionMap.remove("infoAvenantContrat");

		return "/pages/IndivAccident/sinistre/menuIa?faces-redirect=true";
	}
	
	public String validerAndNew(){
		///Recording First
		try {
			getObjectService().addObject(getAssurIASin().getId().getCodeSinistre());
			getObjectService().addObject(getAssurIASin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("managedSinistreIA");
		sessionMap.remove("objectService");
		sessionMap.remove("idGenerateur");
		sessionMap.remove("infoAvenantContrat"); 
		
		return "/pages/IndivAccident/sinistre/declarerSinistreIA?faces-redirect=true";
	}
	
	
	public List<AssureRow> loadAssureList(Contrat ctra) {
		//AssureIa a = new AssureIa();
		List<AssureRow> Y = new ArrayList<AssureRow>();
		List<AssureIa> X = new ArrayList<AssureIa>();
		for(Avenant avn : ctra.getAvenants()){
			for (ListeAssureIa c : avn.getListeAssureIas()) {
				System.out.println("Inside Parcours de toutes les ListeAssureIA ...........................");
				for (AssureIa d : c.getAssureIas()) {
					System.out.println("Inside Parcours de AssureIA d'une ListeAssureIA...........................");
					if (d.getStatutassureia().equalsIgnoreCase("En Flotte") && (!X.contains(d))) {
						System.out.println("Got one Assure satisfying the conditions loading...........................");
						X.add(d);
					}
				}
			}
		}
		
		for (AssureIa e : X) {
			System.out
					.println("Building the AssureRow list...........................");
			AssureRow x = new AssureRow();
			//x.setConduHab(e.getConducteurs().iterator().next());
			x.setnOrdr(Y.size() + 1);
			x.setAssure(e);
			GarantieChoisieIa gcIa = LoadLastGarChoisi(e); 
			List<Garantie> garantieliste = new ArrayList<Garantie>(gcIa.getGaranties());
			List<Garanties> garantielistes = new ArrayList<Garanties>();
			for(Garantie gar:garantieliste){
				Garanties garantie = new Garanties();
				garantie.setId(gar.getId());
				garantie.setLibelleGarantie(gar.getLibelleGarantie());
				garantie.setCapitalGarantie(gar.getCapitalGarantie());
				garantie.setFranchise(gar.getFranchise());
				garantielistes.add(garantie);
			}
			//Garanties garanties = new Garanties();
			x.setListegarantiesIa(garantielistes);
			x.setGcIa(gcIa);
			x.setgGcIa(loadAssurGarGarChx(gcIa));
			
			Y.add(x);
			System.out.println("...........................Building the AssureRow list well done!!!!!!!!!!");
		}
			return Y;
		}

	
	private List<GarantieGarantieChoisieIa> loadAssurGarGarChx(GarantieChoisieIa a){
		List<GarantieGarantieChoisieIa> lGgcIA = new ArrayList<GarantieGarantieChoisieIa>();
		
		for(Garantie g : a.getGaranties()){
			GarantieGarantieChoisieIaPK ggcIAPk = new GarantieGarantieChoisieIaPK(a, g);
			GarantieGarantieChoisieIa ggcIa = (GarantieGarantieChoisieIa) getObjectService().getObjectById(ggcIAPk, "GarantieGarantieChoisieIa");
			lGgcIA.add(ggcIa);
		}
		
		return lGgcIA;
	}

	
	private GarantieChoisieIa LoadLastGarChoisi(AssureIa a) {
		GarantieChoisieIa GcIa = null;
		
		Object[] X = a.getGarantieChoisieIas().toArray();
		  Arrays.sort(X, new java.util.Comparator(){ 
		       public int compare(Object o1, Object o2){ 
		           return compareGarChoisi(o1,o2); 
		          }//compare 
		        } )  ;
		  GcIa=(GarantieChoisieIa) X[X.length-1];
		return GcIa;
	}
	
	
	public int compareGarChoisi(Object o1, Object o2){ 
		    // doit rendre 
		    // -1 si o1 "plus petit que" o2 
		    // 0 si o1 "égal à" o2 
		    // +1 si o1 "plus grand que" o2 
		    GarantieChoisieIa g1=(GarantieChoisieIa)o1; 
		    GarantieChoisieIa g2=(GarantieChoisieIa)o2;  
		    long d1=g1.getDateGarantieChoisieIa().getTime(); 
		    long d2=g2.getDateGarantieChoisieIa().getTime(); 
		    int a=0;
		    if(d1<d2) a=(-1); 
		    if (d1==d2)a=(0);
		    if(d1>d2) a=(1);
			return a; 
		  }//compare1 


	
	
	protected Avenant findCurrAvenant(Contrat ctrat){
		Avenant avn = null; //= new Avenant();
		List<Avenant> X = new ArrayList<Avenant>();
		for (Avenant a :ctrat.getAvenants()){
			System.out.println("aven"+a.getId()+"//"+"DateSurven"+getDateSurvnce());
			
			if (isValidCtra(a) && ( a.getEffet().before(getDateSurvnce())&&a.getEcheance().after(getDateSurvnce()) )){
				X.add(a);
			}
		}
		if(!X.isEmpty()){
			avn = mostRecentAven(X);
			processPrimeSolde(getSlctdContrat(), avn);
		}
		
		
		return avn;
	}
	
	
	private Avenant mostRecentAven(List<Avenant> Y) {
		Object[] X = Y.toArray();
		  Arrays.sort(X, new java.util.Comparator(){ 
		       public int compare(Object o1, Object o2){ 
		           return compareAven(o1,o2); 
		          }//compare 
		        } )  ;
		  Avenant a=(Avenant) X[X.length-1];
		return a;
	}
	
	
	public int compareAven(Object o1, Object o2){ 
		    // doit rendre 
		    // -1 si o1 "plus petit que" o2 
		    // 0 si o1 "égal à" o2 
		    // +1 si o1 "plus grand que" o2 
		    Avenant a1=(Avenant)o1; 
		    Avenant a2=(Avenant)o2;  
		    long d1=a1.getEffet().getTime(); 
		    long d2=a2.getEffet().getTime(); 
		    int a=0;
		    if(d1<d2) a=(-1); 
		    if (d1==d2)a=(0);
		    if(d1>d2) a=(1);
			return a; 
		  }//compare1
	
	private void processPrimeSolde(Contrat ctra, Avenant avn){
		setTotalPrimeNet(BigDecimal.ZERO);
		for(Avenant a : ctra.getAvenants()){
			//on ne prend en compte que les quittances des avenants dt la date d'effet est avant la date deffet de l'avenant courant
			if(a.getEffet().before(avn.getEffet())||a.getEffet().equals(avn.getEffet())){
				System.out.println("aven"+a.getId()+"//"+"DateSurven"+getDateSurvnce()+"///"+a.getQuittances());
				Quittance q =new ArrayList<>(a.getQuittances()).get(0);
				 
				setTotalPrimeNet(getTotalPrimeNet().add(q.getPrimeNette()));
				if(q.getEtatQuittance().equalsIgnoreCase("SOLDEE")){
					setTotalPrimeEncaiss(getTotalPrimeEncaiss().add(q.getPrimeNette()));
				}
			}
		}
	}
	
	public String handleflow(FlowEvent event) {

		String oldStep = event.getOldStep();
		String newStep = event.getNewStep();
		String a = newStep;
		// TRAITEMENT POUR LE PASSAGE DE CONTRAT A VEHICULE
		if (newStep.equalsIgnoreCase("ongletDeclaration")
				&& oldStep.equalsIgnoreCase("ongletContrat")) {

		}

		// TRAITEMENT POUR LE PASSAGE Des assure A la QUITTANCE
		if (newStep.equalsIgnoreCase("ongletValidation")
				&& oldStep.equalsIgnoreCase("ongletDeclaration")) {
			
			prepareRecord();
		
		}
		return a;
	}	
	
	public boolean isValidCtra(Avenant avn) {
		boolean ctraEchu, ctraResilie, ctraAnnule, qtcesolde, risqOK;
		setWarnMsg("Contrat invalide Causes:&lt;br /&gt;");
		ctraEchu = avn.getEcheance().before(Calendar.getInstance().getTime());
		if (ctraEchu)
			setWarnMsg(getWarnMsg().concat("Contrat Echu&lt;br /&gt;"));
		
		ctraResilie = avn.getMouvement().equalsIgnoreCase("resiliation");
		if (ctraResilie)
			setWarnMsg(getWarnMsg().concat("Contrat Résilié&lt;br /&gt;"));
		
		ctraAnnule = avn.getMouvement().equalsIgnoreCase("annulation");
		if (ctraAnnule)
			setWarnMsg(getWarnMsg().concat("Contrat Annulé&lt;br /&gt;"));
		
		qtcesolde = isSoldeAvenant(avn);
		if (!qtcesolde)
			setWarnMsg(getWarnMsg().concat("Quittance non soldée&lt;br /&gt;"));
		
		risqOK = avn.getNumPolice().getCodeRisque().getId().equalsIgnoreCase("8");
		if (!risqOK)
			setWarnMsg(getWarnMsg().concat("La police ne correspond pas au risque INDIVIDUEL ACCIDENT"));

		String X = StringEscapeUtils.unescapeXml(getWarnMsg());
		setWarnMsg(X);
		
		return !ctraEchu && !ctraResilie && !ctraAnnule && qtcesolde && risqOK;

	}

	public boolean isSoldeAvenant(Avenant avn) {
		boolean chckr = true;
		for (Quittance x : avn.getQuittances()) {
			if (x.getEtatQuittance().equalsIgnoreCase("NON SOLDEE")){
				chckr = false;
				break;
			}
		}

		return chckr;

	}


	public String getNumPolice() {
		return numPolice;
	}


	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}


	public Personne getNumSouscripteur() {
		return numSouscripteur;
	}


	public void setNumSouscripteur(Personne numSouscripteur) {
		this.numSouscripteur = numSouscripteur;
	}


	public Contrat getSlctdContrat() {
		return slctdContrat;
	}


	public void setSlctdContrat(Contrat slctdContrat) {
		this.slctdContrat = slctdContrat;
	}


	public boolean isShowNav() {
		return showNav;
	}


	public void setShowNav(boolean showNav) {
		this.showNav = showNav;
	}


	public String getWarnMsg() {
		return WarnMsg;
	}


	public void setWarnMsg(String warnMsg) {
		WarnMsg = warnMsg;
	}


	public ObjectService getObjectService() {
		return objectService;
	}


	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}


	public IdGenerateur getIdGenerateur() {
		return idGenerateur;
	}


	public void setIdGenerateur(IdGenerateur idGenerateur) {
		this.idGenerateur = idGenerateur;
	}


	public InfoAvenantContrat getInfoAvenantContrat() {
		return infoAvenantContrat;
	}


	public void setInfoAvenantContrat(InfoAvenantContrat infoAvenantContrat) {
		this.infoAvenantContrat = infoAvenantContrat;
	}


	public Avenant getCurrAvenant() {
		return currAvenant;
	}


	public void setCurrAvenant(Avenant currAvenant) {
		this.currAvenant = currAvenant;
	}

	public BigDecimal getTotalPrimeNet() {
		return totalPrimeNet;
	}

	public void setTotalPrimeNet(BigDecimal totalPrimeNet) {
		this.totalPrimeNet = totalPrimeNet;
	}

	public BigDecimal getTotalPrimeEncaiss() {
		return totalPrimeEncaiss;
	}

	public void setTotalPrimeEncaiss(BigDecimal totalPrimeEncaiss) {
		this.totalPrimeEncaiss = totalPrimeEncaiss;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public Avenant getLastAvenant() {
		return lastAvenant;
	}

	public void setLastAvenant(Avenant lastAvenant) {
		this.lastAvenant = lastAvenant;
	}

	public Date getDateSurvnce() {
		return dateSurvnce;
	}

	public void setDateSurvnce(Date dateSurvnce) {
		this.dateSurvnce = dateSurvnce;
	}

	public List<Sinistre> getSinistreList() {
		return sinistreList;
	}

	public void setSinistreList(List<Sinistre> sinistreList) {
		this.sinistreList = sinistreList;
	}



	public List<AssureRow> getAssurRwList() {
		return assurRwList;
	}

	public void setAssurRwList(List<AssureRow> assurRwList) {
		this.assurRwList = assurRwList;
	}

	
	public AssureRow getSlctdAssurIA() {
		return slctdAssurIA;
	}

	public void setSlctdAssurIA(AssureRow slctdAssurIA) {
		this.slctdAssurIA = slctdAssurIA;
	}

	public AssureIaSinistre getAssurIASin() {
		return assurIASin;
	}

	public void setAssurIASin(AssureIaSinistre assurIASin) {
		this.assurIASin = assurIASin;
	}

	public String getEtatVictime() {
		return etatVictime;
	}

	public void setEtatVictime(String etatVictime) {
		this.etatVictime = etatVictime;
	}

	public Victime getV() {
		return v;
	}

	public void setV(Victime v) {
		this.v = v;
	}

	
	

	

}
