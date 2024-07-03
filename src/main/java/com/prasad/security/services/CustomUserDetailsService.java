package com.prasad.security.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.prasad.models.User;
import com.prasad.repositories.UserRepository;
import com.prasad.security.models.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }
        logger.info(user.get().getPassword());
        return new CustomUserDetails(user.get());
    }
}
