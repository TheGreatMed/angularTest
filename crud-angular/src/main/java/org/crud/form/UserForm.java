package org.crud.form;

import org.crud.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

	private String nom;
	private String prenom;
	private String email;

	public static User extract(UserForm userForm) {
		User user = new User();
		user.setData(userForm);
		return user;
	}

}
