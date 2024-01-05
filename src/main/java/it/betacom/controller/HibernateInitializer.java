package it.betacom.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInitializer implements ServletContextListener {

	private static SessionFactory sessionFactory;
	
	public void inizializzazioneContesto(ServletContextEvent sce) {
		//la servlet context è come se fosse un posto in cui inserire gli oggetti che voglio condividere a tutto il codice
		
		try {
		//creazione configurazione hibernate
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//creazione session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//memorizzare la SessionFactory come attributo dell'applicazione
        sce.getServletContext().setAttribute("sessionFactory", sessionFactory);
    	
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Errore durante l'inizializzaione di Hibernate. ", e);
	}
		
	}
	
	public void distruzioneContesto(ServletContextEvent sce) {
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}
