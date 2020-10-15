package com.nls.security.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class NlsSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlsSecurityAppApplication.class, args);
	}

	@GetMapping("/hello")
	public String helloPage() {
		return "hello";
	}

	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}

	@GetMapping("/users")
	public String userListPage() {
		return "user/user-list";
	}

	@GetMapping("/users/form")
	public String userFormPage() {
		return "user/user-form";
	}
}