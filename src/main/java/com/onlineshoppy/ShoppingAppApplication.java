package com.onlineshoppy;

import com.onlineshoppy.entity.user.Role;
import com.onlineshoppy.entity.user.User;
import com.onlineshoppy.entity.user.UserRole;
import com.onlineshoppy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ShoppingAppApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		try {
//
//
//
////
//			User user = new User();
//
//			user.setFirstName("Mohd");
//			user.setLastName("Nazim");
//			user.setUsername("nazim@gmail.com");
//			user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//			user.setEmail("nazim@@gmail.com");
//
//
//			Role role1 = new Role();
//			role1.setRoleId(44L);
//			role1.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//
//			userRole.setRole(role1);
//
//			userRole.setUser(user);
//
//			userRoleSet.add(userRole);
//
//			User user1 = this.userService.createUser(user, userRoleSet);
//			System.out.println(user1.getUsername());
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//
//		}

		System.out.println("starting code");
	}

}
