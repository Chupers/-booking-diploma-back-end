package com.Chuper.Booking.rest.controller;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.entity.Characteristic;
import com.Chuper.Booking.rest.service.AccommodationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/loadPhotoByIdGoogle")
    public Accommodation loadPhoto(@RequestParam Long id, @RequestParam MultipartFile file){
        return accommodationService.updatePhotoId(file, id);
    }
    @PutMapping("/loadPhotoById")
    public Accommodation loadPhoto(@RequestParam(name = "id") Long id, @RequestParam(name = "photoId") String photoId){
        return accommodationService.loadPhoto(id,photoId);
    }
    @PostMapping("/saveCharacteristic")
    public void
    saveCharacteristic(@RequestParam(name = "id") Long id, @RequestBody List<Characteristic> characteristics){
        accommodationService.characteristicSave(id,characteristics);
    }
    @PostMapping("/submit")
    public void submitAccommodation(@RequestParam(name = "id") Long id){
        accommodationService.submit(id);
    }

    @GetMapping("/getSubmits")
    public List<Accommodation> getAllAvailableAccommodation(){
        return accommodationService.findAllSubmitAccommodation();
    }

    @GetMapping("/getById")
    public Accommodation getAccommodationById(@RequestParam(name = "id") Long id){
        return accommodationService.findById(id);
    }

}
