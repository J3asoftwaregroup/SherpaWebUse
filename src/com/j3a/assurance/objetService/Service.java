package com.j3a.assurance.objetService;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.j3a.assurance.objetDao.IDao;

@org.springframework.stereotype.Service
@Transactional(readOnly=true)
public class Service implements ObjectService {

	@Autowired
	IDao dao;
 
 
	@Override
	@Transactional(readOnly=false)
	public void addObject(Object objet) {
		
		// TODO Auto-generated method stub
		getDao().addObject(objet);
	}

	@Override
	public Object getObject(int id, String objet) {
		// TODO Auto-generated method stub
	return	getDao().getObject(id, objet);
		 
	}

	@Override
	public Object getObject(String id, String objet) {
		// TODO Auto-generated method stub
		return getDao().getObject(id, objet);
		 
	}
	
	
	@Transactional(readOnly=false)
	@Override
	public void updateObject(Object objet) {
		// TODO Auto-generated method stub
		getDao().updateObject(objet);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void deleteObject(Object objet) {
		// TODO Auto-generated method stub
		getDao().deleteObject(objet);
	}
	
	
	public String getCodeTable(String pseudo, int taillCar, int taillChifr,
			String nomTable, String nomCOL){
		return getDao().getCodeTable(pseudo, taillCar, taillChifr, nomTable, nomCOL);
	}

	@Override
	public List getObjects(String objet) {
		// TODO Auto-generated method stub
	return	getDao().getObjects(objet);
		 
	}

	@Override
	public List<Object> getojects(Object object) {
		// TODO Auto-generated method stub
	return	getDao().getojects(object);
		 
	}
	/**
	 * Get Object List Garantie by Code Risque
	 * 
	 */

	public List<Object> getListGarantieByRisque(String codeRisque)
			throws HibernateException {
		return getDao().getListGarantieByRisque(codeRisque);
	}

	//getter et setter de Idao qui a été injecté
	
	public IDao getDao() {
		return dao;
		}
	
	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
