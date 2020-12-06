package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Customer;
import com.Chuper.Booking.entity.Reservation;
import com.Chuper.Booking.entity.Room;
import com.Chuper.Booking.rest.repository.ReservationRepository;
import com.Chuper.Booking.rest.service.ReservationService;
import com.Chuper.Booking.rest.service.RoomService;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final RoomService roomService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public List<Reservation> getReservationListByRoom(Long roomId) {
        return null;
    }

    @Transactional
    @Override
    public void addReservation(Long roomId, String checkIn, String checkOut, String passportNumber) {
        Reservation reservation = new Reservation();
        Customer customer = userService.getCurrentUser().getCustomer();
        Room room = roomService.findRoomById(roomId);
        if(customer != null){
            reservation.setRoom(room);
            reservation.setCheckIn(convertStringDate(checkIn));
            reservation.setCheckOut(convertStringDate(checkOut));
            reservation.setPassportNumber(passportNumber);
            reservation.setCustomer(customer);
            reservationRepository.save(reservation);
        }

    }


    private Timestamp convertStringDate(String date){
        try{

            DateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFormat = format.parse(date);
            return new Timestamp(dateFormat.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
