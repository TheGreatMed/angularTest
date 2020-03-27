package org.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.crud.dto.UserDTO;
import org.crud.entities.User;
import org.crud.form.UserForm;
import org.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO saveUser(UserForm userForm) {
		User user = UserForm.extract(userForm);
		user = userRepository.save(user);
		return UserDTO.convert(user);

	}

	@Override
	public List<UserDTO> retrieveAllUser() {
		Sort sortByName = Sort.by(Sort.Direction.ASC, "nom");
		List<User> users = userRepository.findAll(sortByName);
		List<UserDTO> filtredUsers = new ArrayList<>();
		users.forEach(user -> {
			filtredUsers.add(UserDTO.convert(user));
		});
		return filtredUsers;
	}

	@Override
	public UserDTO retrieveUserById(Long idUser) {
		Optional<User> opt = userRepository.findById(idUser);
		return UserDTO.convert(opt.get());
	}

	@Override
	public Boolean removeUserById(Long idUser) {
		if (userRepository.existsById(idUser)) {
			userRepository.deleteById(idUser);
			return true;
		}
		return false;
	}

	@Override
	public UserDTO updateUser(Long idUser, UserForm userFrom) {
		Optional<User> opt = userRepository.findById(idUser);
		User user = opt.get();
		String email = user.getEmail();
		user.setData(userFrom);
		user.setEmail(email);
		userRepository.save(user);
		return UserDTO.convert(user);
	}

	@Override
	public boolean isExistByEmail(String email) {
		User user = userRepository.isExistByEmail(email);
		if (user != null) {
			UserDTO userDTO = UserDTO.convert(user);
			if (userDTO != null) {
				return true;
			}
			return false;
		}
		return false;
	}

	public UserDTO convertDTO(User user) {
		return UserDTO.convert(user);
	}

	@Override
	public Page<UserDTO> pageUsers(int page) {
		Sort sortByName = Sort.by(Sort.Direction.ASC, "nom");
		Pageable pageable = PageRequest.of(page, 5, sortByName);
		Page<User> users = userRepository.findAll(pageable);
		Page<UserDTO> usersDTO = users.map(this::convertDTO);
		return usersDTO;
	}

	@Override
	public UserDTO enable(Long idUser) {
		Optional<User> opt = userRepository.findById(idUser);
		User user = opt.get();
		user.setActive(true);
		userRepository.save(user);
		return UserDTO.convert(user);
	}

	@Override
	public UserDTO disable(Long idUser) {
		Optional<User> opt = userRepository.findById(idUser);
		User user = opt.get();
		user.setActive(false);
		userRepository.save(user);
		return UserDTO.convert(user);
	}

}
