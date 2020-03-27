package org.crud.controllers;

import java.util.List;

import org.crud.dto.UserDTO;
import org.crud.form.UserForm;
import org.crud.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping
	public List<UserDTO> getUsers() {
		return userService.retrieveAllUser();
	}
	@GetMapping("/list")
	public Page<UserDTO> getPageUsers(@RequestParam(defaultValue="0") int page){
		return userService.pageUsers(page);
	}

	@PostMapping
	public UserDTO saveUser(@RequestBody UserForm userForm) {
		return userService.saveUser(userForm);
	}

	@PutMapping("/user/{idUser}")
	public UserDTO updateUser(@PathVariable Long idUser, @RequestBody UserForm userForm) {
		return userService.updateUser(idUser, userForm);
	}

	@DeleteMapping("/{idUser}")
	public boolean deleteUser(@PathVariable Long idUser) {
		return userService.removeUserById(idUser);
	}

	@PostMapping("/exist")
	public boolean isExistByEmail(@RequestBody String email) {
		return userService.isExistByEmail(email);
	}
	
	@PostMapping("/{idUser}/enable")
	public UserDTO enable(@PathVariable Long idUser) {
		return userService.enable(idUser);
	}
	
	@PostMapping("/{idUser}/disable")
	public UserDTO disable(@PathVariable Long idUser) {
		return userService.disable(idUser);
	}
}
