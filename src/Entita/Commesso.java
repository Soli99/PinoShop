package Entita;

import java.awt.Image;
import java.util.Date;

public class Commesso {
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String mail;
	private Date dataNascita;
	private Image foto;
	
	public Commesso(String nome,String cognome,String username,String password,Date dataNascita,Image foto,String mail) {
		setNome(nome);
		setCognome(cognome);
		setUsername(username);
		setPassword(password);
		setMail(mail);
		setDataNascita(dataNascita);
		setFoto(foto);
		
	}

	
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataDiNascita) {
		this.dataNascita = dataDiNascita;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}

	
	
}
