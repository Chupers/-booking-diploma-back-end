package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;

public interface EmployerService {
    Employee save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAllByName(String name);
}
