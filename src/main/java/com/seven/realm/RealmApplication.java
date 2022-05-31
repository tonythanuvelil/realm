package com.seven.realm;

import com.seven.realm.entities.Role;
import com.seven.realm.entities.User;
import com.seven.realm.examples.FooService;
import com.seven.realm.services.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
@Slf4j
public class RealmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealmApplication.class, args);
	}

	@GetMapping
	public String index() {
		return "<h2>Welcome to The Realm!</h2>";
	}

//	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "user123", "1234","Some user", "user1234@mail.io", new ArrayList()));
			userService.saveUser(new User(null, "user124", "1234","Some user1", "user11234@mail.io", new ArrayList()));

			userService.addRoleToUser("user123", "ROLE_USER");
			userService.addRoleToUser("user124", "ROLE_SUPER_ADMIN");
		};
	}

	// Example: DI using @Autowired
	@Bean
	String printFoo(FooService fooService) {
		log.info(fooService.getFormatter().format());
		return "print foo";
	}

}


