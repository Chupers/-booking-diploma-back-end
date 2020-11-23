package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.entity.Characteristic;
import com.Chuper.Booking.entity.CharacteristicChild;
import com.Chuper.Booking.rest.repository.AccommodationInfoRepository;
import com.Chuper.Booking.rest.repository.AccommodationRepository;
import com.Chuper.Booking.rest.repository.CharacteristicChildRepository;
import com.Chuper.Booking.rest.repository.CharacteristicRepository;
import com.Chuper.Booking.rest.service.AccommodationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final AccommodationInfoRepository accommodationInfoRepository;
    private final CharacteristicChildRepository characteristicChildRepository;
    private final CharacteristicRepository characteristicRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, AccommodationInfoRepository accommodationInfoRepository, CharacteristicChildRepository characteristicChildRepository, CharacteristicRepository characteristicRepository) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationInfoRepository = accommodationInfoRepository;
        this.characteristicChildRepository = characteristicChildRepository;
        this.characteristicRepository = characteristicRepository;
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

    public void submit(Long accommodationId){
        Accommodation accommodation = findById(accommodationId);
        accommodation.setSubmit(true);
        accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation updatePhotoId(String photoId, Long accommodationId) {
        Accommodation accommodation = findById(accommodationId);
        accommodation.setImageId(photoId);
        return accommodationRepository.save(accommodation);
    }

    @Transactional
    @Override
    public void characteristicSave(Long accommodationId, List<Characteristic> characteristicList) {
        Accommodation accommodation = findById(accommodationId);
        for (Characteristic characteristic: characteristicList){
            characteristic.setAccommodation(accommodation);
            characteristicRepository.save(characteristic);
            for(CharacteristicChild characteristicChild : characteristic.getCharacteristicChildren()){
                characteristicChild.setCharacteristic(characteristic);
                characteristicChildRepository.save(characteristicChild);
            }
        }
    }

}
