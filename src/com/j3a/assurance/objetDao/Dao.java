package com.j3a.assurance.objetDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao implements IDao {

	//Injection par Spring
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveObject(Object objet) {
		
		getSessionFactory().getCurrentSession().save(objet);
		// TODO Auto-generated method stub
		 
	}

	@Override
	public Object getObject(int id, String objet) {
		Session session= getSessionFactory().getCurrentSession();
		String query= "from" +" "+ objet + " "+ " where id =?";
		  List liste = session.createQuery(query).setParameter(0,id).list();
		  if (liste.size()==0){
		   return null;}
		return liste.get(0);
	}

	@Override
	public Object getObject(String id, String objet) {
		Session session= getSessionFactory().getCurrentSession();
		String query= "from" +" "+ objet + " "+ " where id =?";
		  List liste = session.createQuery(query).setParameter(0,id).list();
		  if (liste.size()==0){
		   return null;}
		
		return liste.get(0);
	}

	@Override
	@Transactional
	public void updateObject(Object objet) {
		// TODO Auto-generated method stub
	getSessionFactory().getCurrentSession().update(objet);
	}

	@Override
	@Transactional
	public void deleteObject(Object objet) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(objet);
	}

	@Override
	public List getObjects(String objet) {
		Session session= getSessionFactory().getCurrentSession();
		String query = "from"+" "+objet;
		List list = session.createQuery(query).list();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Object> getojects(Object object) {
		Session session= getSessionFactory().getCurrentSession();
	List list = session.createQuery("from"+" "+object).list();
		// TODO Auto-generated method stub
		return list ;
	}

	//getters et setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;}
	
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    
}
