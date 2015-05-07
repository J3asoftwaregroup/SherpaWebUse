package com.j3a.assurance.objetDao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao implements IDao {

	//Injection par Spring
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addObject(Object objet) {
		
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
	@Transactional
	public String getCodeTable(String pseudo, int taillCar, int taillChifr,
			String nomTable, String nomCOL) {
		// Methode cr�ation d'un id code alphanumrique chronologique d'une
				// ligne de table ds la BD
				

				String query = "SELECT MAX(CAST(SUBSTRING(" + nomCOL + " FROM "
						+ (taillCar + 1) + " FOR " + (taillChifr)
						+ ") AS UNSIGNED )) AS NUMBER FROM " + nomTable + " WHERE "+nomCOL+" LIKE '"+pseudo+"%'";
				Integer v = null;
				try {
					v = (Integer) getSessionFactory().getCurrentSession()
							.createSQLQuery(query)
							.addScalar("NUMBER", StandardBasicTypes.INTEGER).uniqueResult();
					
					String tC = String.valueOf(taillChifr);
					if (v == null) {
						//int numOrdT = i+1;
						String numOrd= String.format("%0"+tC+"d", 1);
						System.out.println("///////Verification requette V null");
						System.out.println("///////Verification requette V null et pseudo = "+pseudo);
						String s = pseudo + numOrd;
						System.out.println("///////Verification requette V null et pseudo + numrd = "+s);
						return s;
					} else {
						v++;
						String numOrd= String.format("%0"+tC+"d", v);
						System.out.println("///////Verification requette V non null");
						String s = pseudo + numOrd;
						return s;
					}
				} catch (HibernateException e) {
					e.printStackTrace();
					return "blag aaa";
				}
				// sess.close();

	}
	@Override
	public List<Object> getListGarantieByRisque(String codeRisque)
			throws HibernateException {
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" from Garantie where CODE_RISQUE='" + codeRisque
								+ "' order by Id ASC").list();
		return list;
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
