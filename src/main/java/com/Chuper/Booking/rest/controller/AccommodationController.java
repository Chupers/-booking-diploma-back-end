package com.Chuper.Booking.rest.controller;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.rest.service.AccommodationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping("/save")
    public Long saveAccommodation(){
        return accommodationService.save(new Accommodation()).getAccommodationId();
    }

    @GetMapping("/getAll")
    public List<Accommodation> getAllAccommodation(){
        return accommodationService.findAll();
    }

    @PutMapping("/loadBasicInfo")
    public Accommodation accommodation(@RequestBody AccommodationInfo accommodationInfo, @RequestParam(name = "id") Long id){
        return accommodationService.updateBasicInfo(id,accommodationInfo);
    }

}
