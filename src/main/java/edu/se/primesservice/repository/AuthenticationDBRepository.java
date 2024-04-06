package edu.se.primesservice.repository;

import edu.se.primesservice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDBRepository extends CrudRepository<Customer,String> {

    Customer findByUsername(String username);
}
