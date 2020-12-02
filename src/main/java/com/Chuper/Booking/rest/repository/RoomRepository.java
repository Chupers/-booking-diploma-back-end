package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
    List<Room> findAllByAccommodation_AccommodationId(Long id);
}
