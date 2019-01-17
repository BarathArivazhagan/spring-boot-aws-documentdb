package com.barath.app;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {
   
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;

    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer createCustomer(@RequestBody @NotNull Customer customer) throws Exception {

         return customerService.saveCustomer(customer);
    }

    @GetMapping(value="/customer/{customerName}")
    public Customer getCustomerByFirstName(@PathVariable String customerName) throws Exception{

        if(!StringUtils.isEmpty(customerName)){
           return customerService.getCustomer(customerName);
        }
        throw new Exception("Customer with customer first name "+customerName+" not found");

    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }
}