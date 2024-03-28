package edu.se.primesservice.repository;

import edu.se.primesservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {

    boolean save(Customer customer) throws IOException;
    Customer findByUsername(String username) throws IOException;


}
