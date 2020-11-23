package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employee,Long> {

    Employee findByEmployerId(Long id);
    Employee findByUserFacadeUserId(Long id);
}
