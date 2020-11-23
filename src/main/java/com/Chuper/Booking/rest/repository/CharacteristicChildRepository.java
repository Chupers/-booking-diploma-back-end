package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.CharacteristicChild;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicChildRepository extends CrudRepository<CharacteristicChild,Long> {
}
