package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.rest.repository.EmployerRepository;
import com.Chuper.Booking.rest.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
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
}
