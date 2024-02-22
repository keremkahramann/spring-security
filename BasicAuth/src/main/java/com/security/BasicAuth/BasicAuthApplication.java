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
public class BasicAuthApplication {

	private final UserService userService;
	private final BCryptPasswordEncoder passwordEncoder;

    public BasicAuthApplication(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}


	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("ker")
				.username("kar")
				.password(passwordEncoder.encode("admin"))
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
	}
}
