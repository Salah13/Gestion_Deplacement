package fr.gds.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deplacement implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String user;
	private String client;
	private Date dateDeplacement;
	private byte[] file;
	
	public Deplacement() {
		super();
	}
	public Deplacement(String user, String client, Date dateDeplacement, byte[] file) {
		super();
		this.user = user;
		this.client = client;
		this.dateDeplacement = dateDeplacement;
		this.file = file;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getDateDeplacement() {
		return dateDeplacement;
	}
	public void setDateDeplacement(Date dateDeplacement) {
		this.dateDeplacement = dateDeplacement;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	



}
