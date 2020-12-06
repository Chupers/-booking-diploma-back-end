package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.entity.Characteristic;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccommodationService {

    List<Accommodation> findAll();
    Accommodation findById(Long id);
    List<Accommodation> findByEmployerId(Long id);
    Accommodation save(Accommodation accommodation);
    Accommodation updateBasicInfo(Long accommodationId,AccommodationInfo accommodationInfo);
    void saveBasicInfo(AccommodationInfo accommodationInfo);
    Accommodation updatePhotoId(MultipartFile file, Long accommodationId);
    void characteristicSave(Long accommodationId, List<Characteristic> characteristics);
    void submit(Long accommodationId);
    List<Accommodation> findAllSubmitAccommodation();
    List<Accommodation> findAllAvailableAccommodation();

}
