package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;

import java.util.List;

public interface AccommodationService {

    List<Accommodation> findAll();
    Accommodation findById(Long id);
    List<Accommodation> findByEmployerId(Long id);
    Accommodation save(Accommodation accommodation);
    Accommodation updateBasicInfo(Long accommodationId,AccommodationInfo accommodationInfo);
    void saveBasicInfo(AccommodationInfo accommodationInfo);
}
