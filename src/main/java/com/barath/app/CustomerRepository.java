package com.barath.app;

import com.barath.app.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Long>{

    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);

}