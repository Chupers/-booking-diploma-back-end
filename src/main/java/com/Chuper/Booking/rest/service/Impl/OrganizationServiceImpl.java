package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.entity.Organization;
import com.Chuper.Booking.entity.UserFacade;
import com.Chuper.Booking.rest.repository.OrganizationRepository;
import com.Chuper.Booking.rest.service.EmployerService;
import com.Chuper.Booking.rest.service.OrganizationService;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final EmployerService employerService;
    private final UserService userService;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, EmployerService employerService, UserService userService) {
        this.organizationRepository = organizationRepository;
        this.employerService = employerService;
        this.userService = userService;
    }


    @Override
    public void save(String organizationName, Employee employee) {
        Organization organization = new Organization();
        organization.setOrganizationName(organizationName);
        organizationRepository.save(organization);
        UserFacade userFacade = userService.getCurrentUser();
        employee.setOrganization(organization);
        employee.setUserFacade(userFacade);
        employerService.save(employee);
        userFacade.setEmployee(employee);
        userService.save(userFacade);
    }

    @Override
    public Organization findById(Long id) {
        return null;
    }
}
