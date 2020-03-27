package org.crud;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.crud.dto.UserDTO;
import org.crud.entities.User;
import org.crud.form.UserForm;
import org.crud.repositories.UserRepository;
import org.crud.services.IUserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTests {

	@Autowired
	IUserService userService;

	@Autowired
	UserRepository userRespository;

	@Test
	public void contextLoads() {
		assertThat(userRespository).isNotNull();
		assertThat(userService).isNotNull();
	}
	
	@BeforeEach
	public void CleanRepository() {
		userRespository.deleteAll();
		User user =new User("zekriti","said","said@gmail.com");
		this.userRespository.save(user);
	}
	
	@Test
	public void createUser() {
		String nom="mohamed", prenom="ibn hicham",
				email="mohamed@gmail.com";	
		UserDTO user=userService.saveUser(new UserForm(nom,prenom,email));
		assertThat(user.getNom()).isEqualTo(nom);
		assertThat(user.getEmail()).isEqualTo(email);
		
	}
	
	@Test
	public void retrieveAllUsers() {
		List<UserDTO> users=userService.retrieveAllUser();
		assertThat(users.size()).isGreaterThanOrEqualTo(1);
		assertThat(users.get(0).getIdUser()).isNotNull();
	}
	
	@Test
	public void retrieveUserById() {
		User user = userRespository.save(new User("ibn hicham","mohamed","mohamed"));
		UserDTO userOutput=userService.retrieveUserById(user.getIdUser());
		assertThat(userOutput.getIdUser()).isEqualTo(user.getIdUser());
		assertThat(userOutput.getEmail()).isNotEmpty();
	}
	
	@Test
	public void removeUserById() {
		User user = userRespository.save(new User("ibn hicham","mohamed","mohamed@gmail.com"));
		assertThat(user.getIdUser()).isNotNull();
		userService.removeUserById(user.getIdUser());
		assertThat(userRespository.existsById(user.getIdUser())).isEqualTo(false);
		
	}
	
	@Test
	public void updateUser() {
		Long idUser=userRespository.save(new User("ibn hicham","mohamed","mohamed@gmail.com")).getIdUser();
		UserDTO userOutput=userService.updateUser(idUser, new UserForm("nom","prenom","email"));
		assertThat(userOutput.getIdUser()).isEqualTo(idUser);
		assertThat(userOutput.getNom()).isEqualTo("nom");
		assertThat(userOutput.getPrenom()).isEqualTo("prenom");
		assertThat(userOutput.getEmail()).isEqualTo("mohamed@gmail.com");
		
	}
	
	@Test
    public void isExistByEmail() {
		User user = userRespository.save(new User("ibn hicham","mohamed","mohamed@gmail.com"));
		boolean isExist=userService.isExistByEmail(user.getEmail());
		assertThat(isExist).isEqualTo(true);
		boolean isNotExist=userService.isExistByEmail("email");
		assertThat(isNotExist).isEqualTo(false);
		
	}

}
