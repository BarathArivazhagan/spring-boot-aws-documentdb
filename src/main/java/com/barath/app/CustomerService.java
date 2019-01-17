package com.barath.app;

import com.barath.app.Customer;
import com.barath.app.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepo=customerRepository;
    }


    public Customer saveCustomer(Customer customer){

        if(logger.isInfoEnabled()){
            logger.info("Saving the customer with customer details {}",customer.toString());
        }
       
        return this.customerRepo.save(customer);

    }

    public Customer getCustomer(String customerName){
        if(logger.isInfoEnabled()){
            logger.info("Getting the customer with customer name {}",customerName);
        }
        Customer customer=this.customerRepo.findByFirstName(customerName);

        if(customer ==null){
            throw new RuntimeException("Customer with customer name "+customerName+" not found");
        }

        return customer;

    }

    public List<Customer> getCustomers(){
        if(logger.isInfoEnabled()){
            logger.info("Getting all the customers ");
        }
        return 	this.customerRepo.findAll();

    }

    public boolean isCustomerExists(Customer customer){

        return this.customerRepo.findByFirstName(customer.getFirstName()) !=null ? true:  false;
    }

    @PostConstruct
    public void init(){

        this.saveCustomer(new Customer(1L,"Barath","Arivazhagan",25));
    }

}