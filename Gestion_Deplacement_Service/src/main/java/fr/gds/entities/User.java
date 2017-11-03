package fr.gds.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String trigramme;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	public User(String trigramme,String nom, String prenom, String email, String password) {
		super();
		this.trigramme=trigramme;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public String getTrigramme() {
		return trigramme;
	}
	public void setTrigramme(String trigramme) {
		this.trigramme = trigramme;
	}
	
	

}
