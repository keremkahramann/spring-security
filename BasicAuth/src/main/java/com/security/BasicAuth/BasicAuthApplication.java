package com.security.BasicAuth;

import com.security.BasicAuth.dto.CreateUserRequest;
import com.security.BasicAuth.model.Role;
import com.security.BasicAuth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication {
/*
	private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }*/


    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {

	}

	private void CreateDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("ker")
				.username("kar")
				.password("kerkar")
				.authorities(Set.of(Role.ROLE_USER))
				.build();

		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("seda")
				.username("kera")
				.password("sedakera")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();

		userService.createUser(request2);
	}*/
}
