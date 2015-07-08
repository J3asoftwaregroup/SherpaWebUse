package com.j3a.assurance.managedBean.EspaceUser;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.j3a.assurance.model.Personne;

@Component
@Transactional
public class RequeteUtilisateur {
	private static Logger logger = Logger.getLogger(RequeteUtilisateur.class);
	@Autowired
	private SessionFactory sessionFactory;

	// private Utilisateur utilisateur = new Utilisateur();

	/**
	 * Méthode pour l'utilisateur de la session
	 * 
	 * @return utilisateur
	 * @throws HibernateException
	 */
	public Personne RecupererUtilisateurCourrant() throws HibernateException {
		// Recupération du login de l'utilisateur courant
		String paramLogin = "";
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getUserPrincipal() != null) {
			paramLogin = FacesContext.getCurrentInstance().getExternalContext()
					.getUserPrincipal().getName();
			
		}
		String query = "SELECT * FROM personne WHERE LOGIN_PERS='"
				+ paramLogin + "'";
		System.out.println("LA requete de recuperation de PERSONNE"+query);
		Personne connected = null;
		try {

			connected = (Personne) getSessionFactory().getCurrentSession()
					.createSQLQuery(query).addEntity(Personne.class)
					.uniqueResult();
		} catch (Exception e) {
			logger.error(" Erreur sur la recupération de l'utilisateur");
		}
		return connected;
	}

/*	public boolean chercherLogin(String paramLogin) {
		boolean etat;
		String str = paramLogin;
		etat = false;
		try {

			String query = "SELECT * FROM `utilisateur` WHERE `LOGIN_UTILISATEUR`='"
					+ str + "'";
			List list = (List) getSessionFactory().getCurrentSession()
					.createSQLQuery(query).addEntity(Utilisateur.class).list();
			if (list.size() >= 1) {
				etat = true;
			}
			System.out.println("Etat de la requête:" + etat);
		} catch (Exception e) {
			logger.error(" Problème de Base de données", e);
		}
		return etat;
	}*/

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
