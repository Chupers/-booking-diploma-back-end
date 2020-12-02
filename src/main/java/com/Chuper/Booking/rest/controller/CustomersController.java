package com.Chuper.Booking.rest.controller;

import com.Chuper.Booking.entity.Customer;
import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.rest.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/customer")
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Long saveEmployer(@RequestBody Customer customer){
        return customerService.save(customer).getId();
    }
}
