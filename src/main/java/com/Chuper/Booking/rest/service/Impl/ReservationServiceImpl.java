package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Reservation;
import com.Chuper.Booking.rest.service.ReservationService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Override
    public List<Reservation> getReservationListByRoom(Long roomId) {
        return null;
    }

    @Override
    public void addReservation(Long accommodationId, Timestamp checkId, Timestamp checkOut) {

    }
}
