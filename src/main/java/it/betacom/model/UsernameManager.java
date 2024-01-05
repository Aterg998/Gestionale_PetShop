package it.betacom.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.query.Query;
import org.hibernate.Session;

import it.betacom.entity.User;

//import it.betacom.connection.DBHandler;

public class UsernameManager {

	public static String generateUsername(String nome, String cognome, String dataNascita) {

		if (nome == null || cognome == null || dataNascita == null || nome.isEmpty() || cognome.isEmpty()
				|| dataNascita.isEmpty()) {
			throw new IllegalArgumentException("I parametri inseriti non possono essere nulli o vuoti");
		}

		// prendi le prime due lettere (se è più corto restituisce nome e non da errore)
		String inizialiNome = nome.substring(0, Math.min(2, nome.length())); // assicura che stiamo prendendo il numero
																				// di caratt disponibili in nome
		String inizialiCognome = cognome.substring(0, Math.min(2, nome.length()));

		// converti stringa in date e prendi l'anno
		LocalDate annoNascita = LocalDate.parse(dataNascita, DateTimeFormatter.ofPattern("dd/mm/yyyy"));
		int anno = annoNascita.getYear();

		// forma il nome
		String generatedUsername = inizialiNome.toUpperCase() + inizialiCognome.toUpperCase() + anno;

		return generatedUsername;

	}

	public static String checkUsername(String generatedUsername, Session session) {

		if (!isUsernameExist(generatedUsername, session)) {
			return generatedUsername;
		} else {
			int counter = 1;
			String usernameProgressivo;
			do {
				usernameProgressivo = generatedUsername + "_" + counter++;

			} while (isUsernameExist(usernameProgressivo, session));

			return usernameProgressivo;
		}
	}

	public static boolean isUsernameExist(String username, Session session) {
		Query<User> query = session.createQuery("FROM utenti WHERE username = :username", User.class); //User.class: Specifica il tipo di risultato che ci si aspetta dalla query
		query.setParameter("username", username);
		User userEsistente = query.uniqueResult();
		return userEsistente != null;
	}

}
