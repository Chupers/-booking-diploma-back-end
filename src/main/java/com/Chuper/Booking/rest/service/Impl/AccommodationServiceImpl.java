package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.rest.repository.AccommodationInfoRepository;
import com.Chuper.Booking.rest.repository.AccommodationRepository;
import com.Chuper.Booking.rest.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final AccommodationInfoRepository accommodationInfoRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, AccommodationInfoRepository accommodationInfoRepository) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationInfoRepository = accommodationInfoRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository.findByAccommodationId(id);
    }

    @Override
    public List<Accommodation> findByEmployerId(Long id) {
        return null;
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation updateBasicInfo(Long accommodationId, AccommodationInfo accommodationInfo) {
        Accommodation accommodation = findById(accommodationId);
        accommodation.setAccommodationInfo(accommodationInfo);
        saveBasicInfo(accommodationInfo);
        return save(accommodation);
    }

    @Override
    public void saveBasicInfo(AccommodationInfo accommodationInfo) {
         accommodationInfoRepository.save(accommodationInfo);
    }

}
