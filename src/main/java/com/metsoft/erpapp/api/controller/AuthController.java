package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.model.dbModel.User;
import com.metsoft.erpapp.dto.LoginDto;
import com.metsoft.erpapp.repository.UserRepository;
import com.metsoft.erpapp.security.auth.TokenManager;
import com.metsoft.erpapp.service.interfaces.UserService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/auth/")
@RestController
public class AuthController {
    private BCryptPasswordEncoder passEncoder;
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private TokenManager tokenManager;


    @Autowired
    public AuthController(BCryptPasswordEncoder passEncoder, UserRepository userRepository, UserService userService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.passEncoder = passEncoder;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }


    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenManager.generateToken(authentication);
        return ResponseEntity.ok(token);

    }


    @PostMapping("register")
    public ResponseEntity<Response> register(@RequestBody User user){
        user.setPassword(passEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.save(user));
    }

}
