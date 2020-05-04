package net.codejava.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.codejava.model.User;
import net.codejava.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
