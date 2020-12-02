package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.Room;
import com.Chuper.Booking.rest.repository.RoomRepository;
import com.Chuper.Booking.rest.service.AccommodationService;
import com.Chuper.Booking.rest.service.RoomService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final AccommodationService accommodationService;

    public RoomServiceImpl(RoomRepository roomRepository, AccommodationService accommodationService) {

        this.roomRepository = roomRepository;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Room> findByAccommodationId(Long id) {
        return roomRepository.findAllByAccommodation_AccommodationId(id);
    }

    @Transactional
    @Override
    public Accommodation save(Room room,Long accommodationId) {
        Accommodation accommodation = accommodationService.findById(accommodationId);
        room.setAccommodation(accommodation);
        roomRepository.save(room);
        accommodation.getRooms().add(room);
        return accommodation;
    }
}
