package com.Chuper.Booking.rest.service;
import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findByAccommodationId(Long id);
    Accommodation save(Room room, Long accommodationId);
    Room findRoomById(Long id);
}