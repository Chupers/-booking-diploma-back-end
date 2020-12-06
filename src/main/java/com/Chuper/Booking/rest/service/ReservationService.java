package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Reservation;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationService {
    List<Reservation> getReservationListByRoom(Long roomId);
    void addReservation(Long roomId, String checkId,String checkOut,String passportNumber);
}
