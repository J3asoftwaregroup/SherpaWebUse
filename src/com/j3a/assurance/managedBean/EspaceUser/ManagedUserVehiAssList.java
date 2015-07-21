package com.j3a.assurance.managedBean.EspaceUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Personne;
import com.j3a.assurance.utilitaires.ContratRw;
import com.j3a.assurance.utilitaires.VehiAssur;

@Component
public class ManagedUserVehiAssList {

	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	
	public ManagedUserVehiAssList() {
		// TODO Auto-generated constructor stub
	}
    
    @PostConstruct
    public void init() {
    	
    }
 
    private Personne cntedPerson;
    private List<VehiAssur> listVehiAssur = new ArrayList<VehiAssur>();
    private List<VehiAssur> fltrdVehiLst = new ArrayList<VehiAssur>();
    /*private List<String> risqLibList = new ArrayList<String>();*/
    private VehiAssur slctdVehiAss;
    
   
    /**/
    
    

    
    public void consultVehiAss(){
    	
    }
    public void viewVehiSin(){
    	
    }
    
    public void onRowToggle(ToggleEvent event) {
        
        setSlctdVehiAss((VehiAssur) event.getData());
    }
    
    
    public void callListSinistre(){
		System.out.println("INSIDE callGraphStat////////////////////////////////////////");
		Map<String,Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", true);
		options.put("contentHeight", 900);
		options.put("contentWidth", 1300);
		
		RequestContext.getCurrentInstance().openDialog ("graphStatListEmiss", options, null);
		
		//RequestContext.getCurrentInstance().execute("PF('Alert').show();");
		System.out.println("AFTER callGraphStat////////////////////////////////////////");
	}
    
    
    


	public RequeteUtilisateur getRequeteUtilisateur() {
		return requeteUtilisateur;
	}

	public void setRequeteUtilisateur(RequeteUtilisateur requeteUtilisateur) {
		this.requeteUtilisateur = requeteUtilisateur;
	}

	public Personne getCntedPerson() {
		return cntedPerson;
	}

	public void setCntedPerson(Personne cntedPerson) {
		this.cntedPerson = cntedPerson;
	}

	public List<VehiAssur> getListVehiAssur() {
		return listVehiAssur;
	}

	public void setListVehiAssur(List<VehiAssur> listVehiAssur) {
		this.listVehiAssur = listVehiAssur;
	}

	public List<VehiAssur> getFltrdVehiLst() {
		return fltrdVehiLst;
	}

	public void setFltrdVehiLst(List<VehiAssur> fltrdVehiLst) {
		this.fltrdVehiLst = fltrdVehiLst;
	}

	public VehiAssur getSlctdVehiAss() {
		return slctdVehiAss;
	}

	public void setSlctdVehiAss(VehiAssur slctdVehiAss) {
		this.slctdVehiAss = slctdVehiAss;
	}

    
    
	
    
    
    
    
}
