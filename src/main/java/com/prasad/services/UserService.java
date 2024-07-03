package com.prasad.services;

import com.prasad.dtos.UserDTO;
import com.prasad.exceptions.UserNotFoundException;
import com.prasad.exceptions.WrongPasswordException;
import com.prasad.models.Token;
import com.prasad.models.User;
import com.prasad.repositories.TokenRepository;
import com.prasad.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setIsEmailVerified(false);

        return userRepository.save(user);
    }

    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with email " + email + " not found");
        }

        User user = optionalUser.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())){
            throw new WrongPasswordException("Wrong password");
        }
        Token token = generateToken(user);
        return tokenRepository.save(token);
    }

    private Token generateToken(User user) {
        Token token = new Token();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 60 * 24 * 30L);
        String value = RandomStringUtils.randomAlphanumeric(128);
        token.setToken(value);
        token.setExpiryAt(expiryDate);
        token.setUser(user);
        return token;
    }
}
