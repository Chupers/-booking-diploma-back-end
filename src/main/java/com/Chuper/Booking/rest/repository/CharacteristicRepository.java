package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.Characteristic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends CrudRepository<Characteristic,Long> {
    Characteristic findAllById (Long id);
}
