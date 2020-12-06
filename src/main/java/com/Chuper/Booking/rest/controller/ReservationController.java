package com.Chuper.Booking.rest.controller;


import com.Chuper.Booking.rest.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/organization")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reserv")
    public void reserveRoom(@RequestParam(name = "roomId") Long roomId,
                            @RequestParam(name = "checkIn") String checkIn,
                            @RequestParam(name = "checkOut") String checkOut,
                            @RequestParam(name = "passportNumber") String passportNumber){
        reservationService.addReservation(roomId,checkIn,checkOut,passportNumber);
    }
}
