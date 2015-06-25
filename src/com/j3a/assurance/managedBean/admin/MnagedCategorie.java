package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import com.j3a.assurance.model.Categorie;
import com.j3a.assurance.model.Risque;
import com.j3a.assurance.objetService.ObjectService;

public class MnagedCategorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Autowired
	 ObjectService objectService;

	 private String id;
	 private String libelleCategorie;
	 
	 private List<SelectItem> elements;
	 private List<Categorie> CategorieList;
	 
	 private UIComponent buttonadd;
	 private UIComponent buttonupdate;
	 private UIComponent buttondelete;
	 private Categorie CategorieSup = new Categorie();
	 private String slctRisque;
	 private List<Risque> risqueList;
	

	 public ObjectService getObjectService() {
		 return objectService;
	 }

	 public void setObjectService(ObjectService objectService) {
		 this.objectService = objectService;
	 }
	 
	public String getId() {
		 
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public List<Categorie> getCategoriList() {	
		CategorieList = new ArrayList<Categorie>();
		List<Object> listObject = getObjectService().getObjects("Categorie");			
		for (Iterator it = listObject.iterator(); it.hasNext();) {
			Categorie categorie = (Categorie) it.next();
			try {
				CategorieList.add(categorie);
			} catch (Exception e) {
			}
	
		}
		return CategorieList;
	}		

	
	
		

	public void setButtonadd(UIComponent buttonadd) {
	        this.buttonadd = buttonadd;
	    }
	
	    public UIComponent getButtonadd() {
	        return buttonadd;
	    }
	 
	
	public UIComponent getButtonupdate() {
		return buttonupdate;
	}
	public void setButtonupdate(UIComponent buttonupdate) {
		this.buttonupdate = buttonupdate;
	}
	
	public UIComponent getButtondelete() {
		return buttondelete;
	}
	public void setButtondelete(UIComponent buttondelete) {
		this.buttondelete = buttondelete;
	}
	
	/**
	  * Reset Fields
	  *
	  */
	public void reset() {
		this.setId("");
		this.setLibelleCategorie("");
	}
	
	public String validateadd() { 
	    String key = getObjectService().getCodeTable("Categorie", 5, 3,"categorie", "CODE_CATEGORIE");
	    Categorie categorie = new Categorie();
	    categorie.setCodeCategorie(key);
	    categorie.setLibelleCategorie(getLibelleCategorie());
	    Risque risque=new Risque();
	    risque.setCodeRisque(getSlctRisque());
	    categorie.setRisque(risque);
	    //Enregistrement en base
	    getObjectService().addObject(categorie);
	    viderCategorie();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
       		(FacesMessage.SEVERITY_INFO,"Gestion des Categorie", "Categorie enregistr�e!"));  
       
      // org.primefaces.context.RequestContext.getCurrentInstance().update("growl");
       System.out.println("Enregistremen ok!");//Clean after
		return null;

	}
	
	
	public void affecterCategorie(){
		setLibelleCategorie(getCategorieSup().getLibelleCategorie());
		
	}
	
	
	public void viderCategorie(){
		setLibelleCategorie("");
	}
	
	
	public String validateupdate() {
		CategorieSup.setLibelleCategorie(libelleCategorie);
		getObjectService().updateObject(CategorieSup);
		viderCategorie();
		 FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO,"Succ�s"," Modification eff�ctu�");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
	}
	
	   
	public void validatedelete()  {
		try {
			getObjectService().deleteObject(CategorieSup);
		} catch ( org.springframework.dao.DataIntegrityViolationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
	        		(FacesMessage.SEVERITY_ERROR,"Erreur", "Cette Cat�gorie ne peut �tre suprim�e"));
		}
		viderCategorie();
	}

	

	public List<Categorie> getCategorieList() {
		getCategoriList();
		return CategorieList;
	}

	public void setCategorieList(List<Categorie> categorieList) {
		CategorieList = categorieList;
	}

	public Categorie getCategorieSup() {
		return CategorieSup;
	}

	public void setCategorieSup(Categorie categorieSup) {
		CategorieSup = categorieSup;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public String getSlctRisque() {
		return slctRisque;
	}

	public void setSlctRisque(String slctRisque) {
		this.slctRisque = slctRisque;
	}

	public List<Risque> getRisqueList() {
		List<Risque> A = new ArrayList<Risque>();
		for (Object c : getObjectService().getObjects("Risque")) {  
			A.add((Risque) c);  
            } 
		
		return A;
	}

	public void setRisqueList(List<Risque> risqueList) {
		this.risqueList = risqueList;
	}
	
public List<SelectItem> getElements() {
		
		if (elements == null) {
			 elements = new ArrayList<SelectItem>();
			 for (Object obj : getObjectService().getObjects("Risque")) {
		
		        	elements.add(new SelectItem(  ((Risque) obj).getCodeRisque(),   ((Risque) obj).getLibelleRisque()));
		        
			 }
		    }
		return elements;
	}

	public void setElements(List<SelectItem> elements) {
		this.elements = elements;
	}

}
