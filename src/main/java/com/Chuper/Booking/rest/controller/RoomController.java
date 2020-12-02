package com.Chuper.Booking.rest.controller;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.Room;
import com.Chuper.Booking.rest.service.RoomService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/save")
    public Accommodation saveRoom(@RequestParam(name = "id") Long accommodationId, @RequestBody Room room){
        return roomService.save(room,accommodationId);
    }

    @GetMapping("/getById")
    public List<Room> getRoomById(@RequestParam(name = "id") Long accommodationId){
         return roomService.findByAccommodationId(accommodationId);
    }
}
