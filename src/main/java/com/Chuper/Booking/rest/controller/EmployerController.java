package com.Chuper.Booking.rest.controller;

import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.rest.service.EmployerService;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;
    private final UserService userService;

    public EmployerController(EmployerService employerService, UserService userService) {
        this.employerService = employerService;
        this.userService = userService;
    }

    @GetMapping("/findById")
    public Employee findEmployeeById(@RequestParam("id") Long id){
        return employerService.findById(id);
    }

    @PostMapping("/save")
    public Long saveEmployer(@RequestBody Employee employee){
        return employerService.save(employee).getEmployerId();
    }

    @GetMapping("/getCurrentEmployer")
    public Employee getCurrentEmployer(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByUserName(userName).getEmployee();
    }
}
