package com.Chuper.Booking.rest.controller;


import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.rest.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/save")
    public void saveEmployer(@RequestBody Employee employee, @RequestParam(name = "orgName") String name){
        organizationService.save(name,employee);
    }
}
