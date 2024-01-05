package it.betacom.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.betacom.entity.User;
import it.betacom.model.UsernameManager;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SessionFactory sessionFactory;

	static { // viene eseguito solo una volta
		try {
			// Inizializzazione della sessionFactory da hibernate.cfg.xml
			Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Inizializzazione SessionFactory fallita: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// salva i dati del form
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String cellulare = request.getParameter("cellulare");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dataNascitaString = request.getParameter("data");

		// Genera Username
		String generatedUsername = UsernameManager.generateUsername(nome, cognome, dataNascitaString);

		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				// verifica username
				String finalUsername = UsernameManager.checkUsername(generatedUsername, session);

				if (finalUsername != null) {

					// se username non esiste, crea oggetto User
					User user = new User();
					user.setNome(nome);
					user.setCongome(cognome);
					user.setCellulare(cellulare);
					user.setEmail(email);
					user.setPassword(password);
					user.setDataNascita(new Date());

					user.setUsername(generatedUsername);

					// salva sul db
					session.save(user);

					transaction.commit();

					System.out.println("Utente inserito con successo nel database");
				} else {

					System.out.println("Utente già inserito nel database");
				}

			} catch (Exception e) {
				if (transaction != null && transaction.isActive()) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}

		// Reindirizzare alla pagina di login
		response.sendRedirect("login.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
