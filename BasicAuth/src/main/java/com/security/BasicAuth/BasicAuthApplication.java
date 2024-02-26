package com.security.BasicAuth;

import com.security.BasicAuth.dto.CreateUserRequest;
import com.security.BasicAuth.model.Role;
import com.security.BasicAuth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner{

	private final UserService userService;
	private final BCryptPasswordEncoder passwordEncoder;

    public BasicAuthApplication(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("ker")
				.username("kar")
				.password("admin")
				.authorities(Set.of(Role.ROLE_USER))
				.build();

		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("seda")
				.username("admin")
				.password("admin")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();

		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("ilayda")
				.username("admin1")
				.password("admin1")
				.authorities(Set.of(Role.ROLE_MOD))
				.build();

		userService.createUser(request3);
	}
}
