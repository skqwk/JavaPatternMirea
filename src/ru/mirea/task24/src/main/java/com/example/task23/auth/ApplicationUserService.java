package com.example.task23.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = new ApplicationUser(userRepository.findUserByUsername(username));
        if (applicationUser.getUser() == null) {
            throw new UsernameNotFoundException(String.format("Username: %s not found", username));
        }
        return applicationUser;
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findUserByUsername(user.getUsername()) != null;
        if (userExists) {
            throw new IllegalStateException(String.format("User with username %s exists", user.getUsername()));
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
        return "login";
    }
}
