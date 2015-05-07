package com.j3a.assurance.managedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Pays;
import com.j3a.assurance.objetService.ObjectService;


@Component
public class ManagedPays {
	@Autowired
	ObjectService objectService;
	
	private Pays pays = new Pays();

	public void enregistrerPays(){
		getObjectService().addObject(pays);
		System.out.println("Enregistrement effectué");
		
	}


	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}


	public Pays getPays() {
		return pays;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}

}
