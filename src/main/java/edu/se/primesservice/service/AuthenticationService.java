package edu.se.primesservice.service;


import edu.se.primesservice.model.Customer;
import edu.se.primesservice.repository.IAuthenticationRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class AuthenticationService implements IAuthenticationService, UserDetailsService {

    IAuthenticationRepository iAuthenticationRepository;

    public AuthenticationService(IAuthenticationRepository iAuthenticationRepository) {
        this.iAuthenticationRepository = iAuthenticationRepository;
    }

    @Override
    public boolean register(Customer customer) throws IOException {
        System.out.println(customer);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(customer.getPassword());
        customer.setPassword(passwordEncoded);
        return iAuthenticationRepository.save(customer);
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
            try{
                Customer customer = iAuthenticationRepository.findByUsername(username);
                if(customer==null){
                    throw new UsernameNotFoundException("");
                }
                return User
                        .withUsername(username)
                        .password(customer.getPassword())
                        .build();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }

    }
}
