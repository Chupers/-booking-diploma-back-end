package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.Accommodation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccommodationRepository extends CrudRepository<Accommodation,Long> {

    Accommodation findByAccommodationId(Long id);
    List<Accommodation> findAll();
    List<Accommodation> findAllByAccommodationName(String name);
}
