package org.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.crud.form.UserForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Long idUser;
	private String nom;
	private String prenom;
	private String email;
	private Boolean active = true;

	public User(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public void setData(UserForm userFrom) {
		setNom(userFrom.getNom());
		setPrenom(userFrom.getPrenom());
		setEmail(userFrom.getEmail());
	}

}
