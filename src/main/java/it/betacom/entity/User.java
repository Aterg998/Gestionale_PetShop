package it.betacom.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtente;
	

	private String nome;
	private String congome;
	private String username;
	private String cellulare;
	private String email;
	private String password;
	private char ruolo;
	private char stato;
	private int login_rimanenti;
	private Date dataNascita;
	
	public User() {
		
	}
	
	public User(int idUtente, String nome, String congome, String username, String cellulare, String email,
			String password, char ruolo, char stato, int login_rimanenti, Date dataNascita) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.congome = congome;
		this.username = username;
		this.cellulare = cellulare;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
		this.dataNascita = dataNascita;
	}


	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCongome() {
		return congome;
	}

	public void setCongome(String congome) {
		this.congome = congome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getRuolo() {
		return ruolo;
	}

	public void setRuolo(char ruolo) {
		this.ruolo = ruolo;
	}

	public char getStato() {
		return stato;
	}

	public void setStato(char c) {
		this.stato = c;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int getLogin_rimanenti() {
		return login_rimanenti;
	}

	public void setLogin_rimanenti(int login_rimanenti) {
		this.login_rimanenti = login_rimanenti;
	}
}
