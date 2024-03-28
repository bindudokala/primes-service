package edu.se.primesservice.controller;


import edu.se.primesservice.model.Customer;
import edu.se.primesservice.service.AuthenticationService;
import edu.se.primesservice.service.IAuthenticationService;
import edu.se.primesservice.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    private final IAuthenticationService iAuthenticationService ;
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationController(IAuthenticationService iAuthenticationService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.iAuthenticationService = iAuthenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer){
        try{
            return iAuthenticationService.register(customer);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customer.getUsername(),customer.getPassword()
                )
        );
        return tokenService.generateToken(authentication);
    }
}
