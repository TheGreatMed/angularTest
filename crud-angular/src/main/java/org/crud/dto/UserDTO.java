package org.crud.dto;

import org.crud.entities.User;
import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

	private Long idUser;
	private String nom;
	private String prenom;
	private String email;
	private Boolean active;

	public static UserDTO convert(User user) {
		return new UserDTO(user.getIdUser(), user.getNom(), user.getPrenom(), user.getEmail(),user.getActive());
	}
	
	
}
