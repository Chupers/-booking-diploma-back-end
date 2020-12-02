package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Customer;
import com.Chuper.Booking.entity.Employee;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAllByName(String name);
}
