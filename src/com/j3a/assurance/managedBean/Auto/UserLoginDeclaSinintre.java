package com.j3a.assurance.managedBean.Auto;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.j3a.assurance.model.Personne;
import com.j3a.assurance.objetService.ObjectService;

/**
 * 
 * @author PCALekerand
 *
 */
@Component
public class UserLoginDeclaSinintre {
	
	private String login;
	private String motPass;
	
	//Injection spring
	@Autowired
	private ObjectService objectService;
	

@Transactional
	public String loginConnexion() {
		FacesMessage message = null;
			 Personne personne = new Personne();
			personne = getObjectService().personneByLogin(login, motPass);
			if (personne == null) {
				
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Désolé! Paramètres de connexion incorrectes","");
				FacesContext.getCurrentInstance().addMessage(null, message);
				
			}else {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienenu(e)! Vous êtes connecté","");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "OKSINSTRE";
			}
			return"";
		
    }  
	
	
	public void leverConnexion() {
			System.out.println("----->> method called");
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        RequestContext.getCurrentInstance().openDialog("connexionText", options, null);
    }
	
	
	

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}


	public String getMotPass() {
		return motPass;
	}


	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
   
}
