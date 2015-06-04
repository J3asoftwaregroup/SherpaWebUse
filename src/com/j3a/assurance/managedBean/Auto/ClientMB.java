package com.j3a.assurance.managedBean.Auto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.converter.ComboSexes;
import com.j3a.assurance.model.Conducteur;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Etre;
import com.j3a.assurance.model.EtreId;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.PersonneNationalite;
import com.j3a.assurance.model.PersonneNationaliteId;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.Sexe;
import com.j3a.assurance.model.TypePersonne;
import com.j3a.assurance.model.Ville;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.ClientView;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ClientMB implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static final String SUCCESS = "success";
		private static final String ERROR = "error";
		
		@Autowired
	    ObjectService objectService;
		
		private Personne maPersonne= new Personne() ;
		private ComboSexes comboSexe;
		
		@Autowired
		IdGenerateur idGenerateur;
		
		private String slctsexe;
		private List<Sexe> sexeList;
		private Conducteur conducteur=new Conducteur();
		private Morale maMorale = new Morale();
		
		private Physique monPhysique = new Physique();
		private Personne client = new Personne() ;
		private TypePersonne typePersonne = new TypePersonne();
		private Etre etre = new Etre();
		private EtreId etrePk = new EtreId();
		private PersonneNationalite personneNationalite = new PersonneNationalite();
		private PersonneNationaliteId personneNationalitePk = new PersonneNationaliteId();
		private TypePersonne objTypePersonne = new TypePersonne();
		private Contrat monContrat = new Contrat();
		private String situationMatrimoniale;
		private String nomClient;
		private String tittre;
		private String profession;
		private String typePiece;
		private Etre etreType = new Etre();
		private Personne personne;
		private Physique physique;
		private Morale morale = new Morale();
		private String nom;
		private String numSouscripteur;
		private String categorieProfession;
		private StringBuffer identiteSouscripteur = new StringBuffer();
		private String identiteClient;
		private boolean etatEngSouscripteur = false;
		private boolean etatClient=false;
		//Gestion des champs du formulaire
		//Physique
		private InputText nomInputText = new InputText();
		private InputText prenomInputText = new InputText();
		private InputMask dateNaisInputMask = new InputMask();
		private InputText lieuNaisInputText = new InputText();
		private SelectOneMenu professionOneMenu = new SelectOneMenu();
		private SelectOneMenu titreSelectOneMenu = new SelectOneMenu();
		private SelectOneMenu sexeOneMenu = new SelectOneMenu();
		private SelectOneMenu sitationMatOneMenu = new SelectOneMenu();
		private SelectOneMenu nationaliteOneMenu = new SelectOneMenu();
		private SelectOneMenu typepieceOneMenu = new SelectOneMenu();
		private InputText numInputText = new InputText();
		private SelectOneMenu categProfOneMenu = new SelectOneMenu();
		private Dialog dialogSous;

		public void chargeClient(){
			ClientView cv = new ClientView();
			for(Physique ph: cv.getListClients()){
				if(ph.getNomRaisonSociale().equalsIgnoreCase(getMaPersonne().getNomRaisonSociale())){
					getMonPhysique().setDateNaissPers(ph.getDateNaissPers());
					getMaPersonne().setNomRaisonSociale(ph.getNomRaisonSociale());
					getMonPhysique().setPrenomPers(ph.getPrenomPers());
					getMonPhysique().setProfession(ph.getProfession());
					getMonPhysique().setLieuNaissPers(ph.getLieuNaissPers());
					getMonPhysique().setSituationMatPers(ph.getSituationMatPers());
					getMaPersonne().setEmail(ph.getEmail());
					getMonPhysique().setNumPiecePers(ph.getNumPiecePers());
					getMaPersonne().setTelephone(ph.getTelephone());
					getMonPhysique().setTypePiece(ph.getTypePiece());
					getMaPersonne().setAdresse(ph.getAdresse());	
				}else{
					//viderPersonne(getMaPersonne());
					viderPhysique(getMonPhysique());
				}
			}
		}
		
		
		public void addPersonnePhysique() {	
			
			try {
				setPersonne(maPersonne);
				getPersonne();//Attribuer un code au client
				personne.setAdresse(maPersonne.getAdresse());
				personne.setDatePers(Calendar.getInstance().getTime());//Date création client
				
				//Renseigner l'objet Physique
				setPhysique(monPhysique);
				physique.setPersonne(personne);//Attribuer le code de pers à physique
				physique.setNomRaisonSociale(getMaPersonne().getNomRaisonSociale());
				physique.setDatePers(personne.getDatePers());

				//Ajouter l'adresse
				physique.setAdresse(maPersonne.getAdresse());
				physique.setTelephone(maPersonne.getTelephone());
				physique.setEmail(maPersonne.getEmail());
				physique.setFax(maPersonne.getFax());
				physique.setAdresseGeo(maPersonne.getAdresseGeo());
				
				//Affecter la valeur des combos
				
				Sexe sexe= new Sexe();
				//Integer.getInteger(getSlctsexe()).intValue()
				sexe.setCodeSexe(1);
				physique.setSexe(sexe);
				
				
					//Reseigner Personne_Nationalite
				personneNationalitePk.setNumSouscripteur(personne.getNumSouscripteur());
				personneNationalitePk.setCodeNationalite(1);
				personneNationalite.setId(personneNationalitePk);
				personneNationalite.setDateNationalite(Calendar.getInstance().getTime());
							
					//Renseigner EtreType (client)
				typePersonne=(TypePersonne) getObjectService().getObjectById(1, "TypePersonne");
				etrePk.setCodeTypePers(typePersonne.getCodeTypePers());
				etrePk.setNumSouscripteur(personne.getNumSouscripteur());
				etre.setId(etrePk);
				etre.setDatePers(Calendar.getInstance().getTime());
				
					//Enregistrement en basse
				getObjectService().addObject(personne);
				getObjectService().addObject(physique);
				getObjectService().addObject(etre);
				getObjectService().addObject(personneNationalite);
				personne.setLoginPers(personne.getNomRaisonSociale());
				personne.setMotPassePers(personne.getNomRaisonSociale());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Enregistrement effectué"));		
		}
       
		public void majconducteur(){
			
				getConducteur().setNonCond(getMaPersonne().getNomRaisonSociale());
				getConducteur().setDateNaissCond(getMaPersonne().getDatePers());
				String lieunaiss = null, prenom = null;
				
				getConducteur().setPrenomsCond(prenom);
				getConducteur().setLieuNaisCond(lieunaiss);
				String numpiece = null;
				
				getConducteur().setNumCond(numpiece);
				getConducteur().setDureepermiscond((short) 0);
				
			}
			
			


		public void addConducteur(){
		String id=getIdGenerateur().getIdConducteur(getMaPersonne());
		getConducteur().setNumCond(id);
		getObjectService().addObject(conducteur);	
		
		}

		public void viderPhysique(Physique objPhyq) {
			// Vider l'objet physique de l'affichage
			objPhyq.setNumSouscripteur(null);
			objPhyq.setDatePers(null);
			//objPhyq.setTitre(null);
			//objPhyq.setNationalites(null);
			objPhyq.setNomRaisonSociale(null);
			objPhyq.setPrenomPers(null);
			objPhyq.setDatePers(null);
			objPhyq.setDateNaissPers(null);
			objPhyq.setLieuNaissPers(null);
			objPhyq.setSituationMatPers(null);
			objPhyq.setProfession(null);
			objPhyq.setNumPiecePers(null);
			objPhyq.setTitre(null);
			//inserer le type ici
			objPhyq.setNumPiecePers(null);
			
			objPhyq.setDatePers(null);
			objPhyq.setAdresse(null);
			objPhyq.setAdresseGeo(null);
			objPhyq.setTelephone(null);
			objPhyq.setFax(null);
			objPhyq.setEmail(null);
			
		}

		public void viderPersonne(Personne objPersonne){
			objPersonne.setNumSouscripteur(null);
			objPersonne.setNomRaisonSociale(null);
			objPersonne.setDatePers(null);
			objPersonne.setAdresse(null);
			objPersonne.setAdresseGeo(null);
			objPersonne.setTelephone(null);
			objPersonne.setFax(null);
			objPersonne.setEmail(null);
			objPersonne.setContrats(null);
			//objPersonne.setTypePersonnes(null);
			//objPersonne.setNationalites(null);
			
		}
		

		public void messageEmptyField() {
			RequestContext.getCurrentInstance().execute("empty_field.show();");
		}
		//**************************ACCESSEURS********************************************//

		public Personne getPersonne() {

			Random rdm = new Random();
			int y = 64;
			while (!(64 < y && y < 91)) {
				y = rdm.nextInt(100);
			}

			char V = (char) y;
			String l = Character.toString(V);

			String key = getObjectService().getCodeTable("Perso", 5, 4, "personne",
					"NUM_SOUSCRIPTEUR");

			personne.setNumSouscripteur(key);
			return personne;
		}

		public void setPersonne(Personne personne) {
			this.personne = personne;
		}

		public Physique getPhysique() {
			return physique;
		}

		public void setPhysique(Physique physique) {
			this.physique = physique;
		}

		public Morale getMorale() {
			return morale;
		}

		public void setMorale(Morale morale) {
			this.morale = morale;
		}

		public Etre getEtreType() {
			return etreType;
		}

		public void setEtreType(Etre etreType) {
			this.etreType = etreType;
		}

		

		

		public ObjectService getObjectService() {
			return objectService;
		}

		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}

		
		

		public String redirectEnregClient() {
			return "redEngClient";

		}



		public Morale getMaMorale() {
			return maMorale;
		}

		public void setMaMorale(Morale maMorale) {
			this.maMorale = maMorale;
		}

		public Physique getMonPhysique() {
			return monPhysique;
		}

		public void setMonPhysique(Physique monPhysique) {
			this.monPhysique = monPhysique;
		}

		
		public Contrat getMonContrat() {
			return monContrat;
		}

		public void setMonContrat(Contrat monContrat) {
			this.monContrat = monContrat;
		}

		
		
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getNumSouscripteur() {
			return numSouscripteur;
		}

		public void setNumSouscripteur(String numSouscripteur) {
			this.numSouscripteur = numSouscripteur;
		}



		public Personne getMaPersonne() {
			return maPersonne;
		}



		public void setMaPersonne(Personne maPersonne) {
			this.maPersonne = maPersonne;
		}


		public TypePersonne getTypePersonne() {
			return typePersonne;
		}



		public void setTypePersonne(TypePersonne typePersonne) {
			this.typePersonne = typePersonne;
		}



		public Etre getEtre() {
			return etre;
		}



		public void setEtre(Etre etre) {
			this.etre = etre;
		}



		public EtreId getEtrePk() {
			return etrePk;
		}



		public void setEtrePk(EtreId etrePk) {
			this.etrePk = etrePk;
		}

		/*public ComboClient getComboClient() {
			return comboClient;
		}

		public void setComboClient(ComboClient comboClient) {
			this.comboClient = comboClient;
		}*/

		public PersonneNationalite getPersonneNationalite() {
			return personneNationalite;
		}

		public void setPersonneNationalite(PersonneNationalite personneNationalite) {
			this.personneNationalite = personneNationalite;
		}

		public PersonneNationaliteId getPersonneNationalitePk() {
			return personneNationalitePk;
		}

		public void setPersonneNationalitePk(PersonneNationaliteId personneNationalitePk) {
			this.personneNationalitePk = personneNationalitePk;
		}




		public TypePersonne getObjTypePersonne() {
			return objTypePersonne;
		}



		public void setObjTypePersonne(TypePersonne objTypePersonne) {
			this.objTypePersonne = objTypePersonne;
		}



		public String getSituationMatrimoniale() {
			return situationMatrimoniale;
		}



		public void setSituationMatrimoniale(String situationMatrimoniale) {
			this.situationMatrimoniale = situationMatrimoniale;
		}


		public ComboSexes getComboSexe() {
			return comboSexe;
		}


		public void setComboSexe(ComboSexes comboSexe) {
			this.comboSexe = comboSexe;
		}


		

		public String getTittre() {
			return tittre;
		}


		public void setTittre(String tittre) {
			this.tittre = tittre;
		}


		public String getProfession() {
			return profession;
		}


		public void setProfession(String profession) {
			this.profession = profession;
		}


		public String getTypePiece() {
			return typePiece;
		}


		public void setTypePiece(String typePiece) {
			this.typePiece = typePiece;
		}



		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}


		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}


		

		public InputText getNomInputText() {
			return nomInputText;
		}


		public void setNomInputText(InputText nomInputText) {
			this.nomInputText = nomInputText;
		}


		public InputText getPrenomInputText() {
			return prenomInputText;
		}


		public void setPrenomInputText(InputText prenomInputText) {
			this.prenomInputText = prenomInputText;
		}


		public InputMask getDateNaisInputMask() {
			return dateNaisInputMask;
		}


		public void setDateNaisInputMask(InputMask dateNaisInputMask) {
			this.dateNaisInputMask = dateNaisInputMask;
		}


		public InputText getLieuNaisInputText() {
			return lieuNaisInputText;
		}


		public void setLieuNaisInputText(InputText lieuNaisInputText) {
			this.lieuNaisInputText = lieuNaisInputText;
		}


		public SelectOneMenu getProfessionOneMenu() {
			return professionOneMenu;
		}


		public void setProfessionOneMenu(SelectOneMenu professionOneMenu) {
			this.professionOneMenu = professionOneMenu;
		}


		public SelectOneMenu getTitreSelectOneMenu() {
			return titreSelectOneMenu;
		}


		public void setTitreSelectOneMenu(SelectOneMenu titreSelectOneMenu) {
			this.titreSelectOneMenu = titreSelectOneMenu;
		}


		public SelectOneMenu getSitationMatOneMenu() {
			return sitationMatOneMenu;
		}


		public void setSitationMatOneMenu(SelectOneMenu sitationMatOneMenu) {
			this.sitationMatOneMenu = sitationMatOneMenu;
		}


		public SelectOneMenu getSexeOneMenu() {
			return sexeOneMenu;
		}


		public void setSexeOneMenu(SelectOneMenu sexeOneMenu) {
			this.sexeOneMenu = sexeOneMenu;
		}


		public SelectOneMenu getNationaliteOneMenu() {
			return nationaliteOneMenu;
		}


		public void setNationaliteOneMenu(SelectOneMenu nationaliteOneMenu) {
			this.nationaliteOneMenu = nationaliteOneMenu;
		}


		public SelectOneMenu getTypepieceOneMenu() {
			return typepieceOneMenu;
		}


		public void setTypepieceOneMenu(SelectOneMenu typepieceOneMenu) {
			this.typepieceOneMenu = typepieceOneMenu;
		}


		public InputText getNumInputText() {
			return numInputText;
		}


		public void setNumInputText(InputText numInputText) {
			this.numInputText = numInputText;
		}


		public String getCategorieProfession() {
			return categorieProfession;
		}


		public void setCategorieProfession(String categorieProfession) {
			this.categorieProfession = categorieProfession;
		}


		public SelectOneMenu getCategProfOneMenu() {
			return categProfOneMenu;
		}


		public void setCategProfOneMenu(SelectOneMenu categProfOneMenu) {
			this.categProfOneMenu = categProfOneMenu;
		}


		public StringBuffer getIdentiteSouscripteur() {
			return identiteSouscripteur;
		}


		public void setIdentiteSouscripteur(StringBuffer identiteSouscripteur) {
			this.identiteSouscripteur = identiteSouscripteur;
		}


		public String getIdentiteClient() {
			return identiteClient;
		}


		public void setIdentiteClient(String identiteClient) {
			this.identiteClient = identiteClient;
		}


		public Dialog getDialogSous() {
			return dialogSous;
		}


		public void setDialogSous(Dialog dialogSous) {
			this.dialogSous = dialogSous;
		}


		public boolean isEtatEngSouscripteur() {
			return etatEngSouscripteur;
		}


		public void setEtatEngSouscripteur(boolean etatEngSouscripteur) {
			this.etatEngSouscripteur = etatEngSouscripteur;
		}

	


	public String validerClient() {
		try {
			setClient(getMaPersonne());
			nomClient = getMaPersonne().getNomRaisonSociale()+" "+getMonPhysique().getPrenomPers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "vehicule";
	}






	public boolean isEtatClient() {
		return etatClient;
	}



	public void setEtatClient(boolean etatClient) {
		this.etatClient = etatClient;
	}



	public Conducteur getConducteur() {
		return conducteur;
	}



	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public List<Sexe> getSexeList() {
		List<Sexe> A = new ArrayList<Sexe>();
		for (Object c : getObjectService().getObjects("Sexe")) {  
			A.add((Sexe) c);  
            } 
		
		return A;
	}

	public void setSexeList(List<Sexe> sexeList) {
		this.sexeList = sexeList;
	}

	public String getSlctsexe() {
		return slctsexe;
	}

	public void setSlctsexe(String slctsexe) {
		this.slctsexe = slctsexe;
	}


	public Personne getClient() {
		return client;
	}


	public void setClient(Personne client) {
		this.client = client;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

}
