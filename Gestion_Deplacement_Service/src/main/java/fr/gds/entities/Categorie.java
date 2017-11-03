package fr.gds.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Categorie implements Serializable{
	
	 @Id @GeneratedValue
	private Long id;
	private String nomcategorie;
	public Categorie(String nomcategorie) {
		super();
		this.nomcategorie = nomcategorie;
	}
	public Categorie() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomcategorie() {
		return nomcategorie;
	}
	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}
	
	

}
