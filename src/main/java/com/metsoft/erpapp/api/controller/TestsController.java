package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.model.dbModel.User;
import com.metsoft.erpapp.model.dto.LoginDto;
import com.metsoft.erpapp.repository.UserRepository;
import com.metsoft.erpapp.security.auth.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
@RestController
public class TestsController {

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManager tokenManager;

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
    public String register(@RequestBody User user){
       user.setPassword(passEncoder.encode(user.getPassword()));
       userRepository.save(user);
       return "kayıt edildi";
    }



    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newPage(){
        return "Hello, this is admin";
    }



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(){
        return "Hello, this homepage";
    }

}
