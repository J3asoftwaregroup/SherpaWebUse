package com.j3a.assurance.managedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Pays;
import com.j3a.assurance.objetDao.Dao;
import com.j3a.assurance.objetService.IService;


@Component
public class ManagedPays {
	@Autowired
	IService service;
	
	private Pays pays = new Pays();

	public void enregistrerPays(){
		getService().saveObject(pays);
		System.out.println("Enregistrement effectué");
		
	}


	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}


	public Pays getPays() {
		return pays;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}

}
