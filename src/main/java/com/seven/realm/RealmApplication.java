package com.seven.realm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RealmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealmApplication.class, args);
	}

	@GetMapping
	public String index() {
		return "<h2>Welcome to The Realm!</h2>";
	}

}
