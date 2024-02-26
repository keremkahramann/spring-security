package com.security.BasicAuth.service;

import com.security.BasicAuth.dto.CreateUserRequest;
import com.security.BasicAuth.model.User;
import com.security.BasicAuth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername (String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(CreateUserRequest request){
        User newUser = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .accountNonExpired(true)
                .authorities(request.authorities())
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        userRepository.save(newUser);
    }
}
