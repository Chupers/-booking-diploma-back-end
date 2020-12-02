package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,Long> {
    Organization findAllById(Long id);
}
