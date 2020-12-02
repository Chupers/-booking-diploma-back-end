package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.rest.repository.EmployerRepository;
import com.Chuper.Booking.rest.service.EmployerService;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final UserService userService;

    public EmployerServiceImpl(EmployerRepository employerRepository, UserService userService) {
        this.employerRepository = employerRepository;
        this.userService = userService;
    }

    @Override
    public Employee save(Employee employee) {
        return employerRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employerRepository.findByEmployerId(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployerByOrg() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee currentEmployer = userService.findByUserName(userName).getEmployee();
        return currentEmployer.getOrganization().getEmployeeList();
    }
}
