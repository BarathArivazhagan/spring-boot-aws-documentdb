package com.barath.app;

import com.barath.app.Customer;
import com.barath.app.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){

        this.customerService=customerService;

    }

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer createSCustomer(@RequestBody Customer customer) throws Exception {

       Optional<Customer>   cust= Optional.ofNullable(Optional.ofNullable(customer).orElseThrow(() -> new Exception("Customer cannot be saved")));
       if(cust.isPresent()){
         return customerService.saveCustomer(customer);
       }
       return cust.get();
    }

    @GetMapping(value="/get/{customerName}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomerByFirstName(@PathVariable String customerName) throws Exception{

        if(!StringUtils.isEmpty(customerName)){
           return customerService.getCustomer(customerName);
        }
        throw new Exception("Customer with customer first name "+customerName+" not found");

    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }
}