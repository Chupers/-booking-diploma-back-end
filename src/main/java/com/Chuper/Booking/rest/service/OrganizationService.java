package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Employee;
import com.Chuper.Booking.entity.Organization;

public interface OrganizationService {

    void save(String organizationName, Employee employee);
    Organization findById(Long id);
}
