package org.crud.services;

import java.util.List;

import org.crud.dto.UserDTO;
import org.crud.form.UserForm;
import org.springframework.data.domain.Page;

public interface IUserService {

	public UserDTO saveUser(UserForm userForm);

	public List<UserDTO> retrieveAllUser();

	public UserDTO retrieveUserById(Long idUser);

	public UserDTO updateUser(Long idUser, UserForm userFrom);

	public Boolean removeUserById(Long idUser);

	public boolean isExistByEmail(String email);

	public Page<UserDTO> pageUsers(int page);

	public UserDTO enable(Long idUser);

	public UserDTO disable(Long idUser);

}
