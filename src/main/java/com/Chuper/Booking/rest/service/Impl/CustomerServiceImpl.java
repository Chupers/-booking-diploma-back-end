package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Customer;
import com.Chuper.Booking.rest.repository.CustomerRepository;
import com.Chuper.Booking.rest.service.CustomerService;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;

    public CustomerServiceImpl(CustomerRepository customerRepository, UserService userService) {
        this.customerRepository = customerRepository;
        this.userService = userService;
    }

    @Override
    public Customer save(Customer customer) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        customer.setUserFacade(userService.findByUserName(userName));
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public List<Customer> findAllByName(String name) {
        return null;
    }
}
