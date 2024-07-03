package com.prasad.controllers;

import com.prasad.dtos.LoginRequestDTO;
import com.prasad.dtos.UserDTO;
import com.prasad.models.Token;
import com.prasad.models.User;
import com.prasad.security.services.CustomUserDetailsService;
import com.prasad.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        logger.info("Login request: {}", loginRequestDTO);
        Token token = userService.login(loginRequestDTO.getUsername(),
                 loginRequestDTO.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
