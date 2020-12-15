package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.entity.Characteristic;
import com.Chuper.Booking.entity.Room;
import com.Chuper.Booking.rest.repository.AccommodationInfoRepository;
import com.Chuper.Booking.rest.repository.CharacteristicRepository;
import com.Chuper.Booking.rest.service.AccommodationService;
import com.Chuper.Booking.rest.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl  implements SearchService {

    private final AccommodationInfoRepository accommodationInfoRepository;
    private final AccommodationService accommodationService;
    private final CharacteristicRepository characteristicRepository;

    public SearchServiceImpl(AccommodationInfoRepository accommodationInfoRepository, AccommodationService accommodationService, CharacteristicRepository characteristicRepository) {
        this.accommodationInfoRepository = accommodationInfoRepository;
        this.accommodationService = accommodationService;
        this.characteristicRepository = characteristicRepository;
    }

    @Override
    public List<AccommodationInfo> getAccommodationInfo() {
        return accommodationInfoRepository.findAll();
    }

    @Override
    public List<Characteristic> getCharacteristic() {
        return null;
    }

    @Override
    public List<Characteristic> getFirstFiveCharacteristic() {
        return null;
    }

    @Override
    public List<Accommodation> filterAccommodationByBasicFilter() {
        return null;
    }

    @Override
    public List<Accommodation> filterAccommodationByAccommodationInfo(String info) {
        List<Accommodation> accommodationList = accommodationService.findAllAvailableAccommodation();
        return accommodationList.stream().filter(accommodation ->
                accommodation.getAccommodationInfo().getAccommodationCity().toUpperCase().contains(info.toUpperCase())
                || accommodation.getAccommodationInfo().getAccommodationCountry().toUpperCase().contains(info.toUpperCase())
                || accommodation.getAccommodationInfo().getAccommodationName().toUpperCase().contains(info.toUpperCase())).collect(Collectors.toList());

    }

    @Override
    public Set<String> getCityList() {
        List<String> cityList  = new ArrayList<>();
        for (AccommodationInfo accommodationInfo : getAccommodationInfo()){
            cityList.add(accommodationInfo.getAccommodationCity());
        }
        return new HashSet<>(cityList);

    }

    @Override
    public List<Accommodation> findByDetailsFilter(Integer minPrice, Integer maxPrice, Integer countStar, String value) {
        List<Accommodation> accommodationList;
        if(countStar!=null){
            accommodationList = filterAccommodationByAccommodationInfo(value).stream().filter(
                    accommodation -> accommodation.getAccommodationInfo().getCountStar().equals(countStar))
                    .collect(Collectors.toList());
        }
        else {
            accommodationList = filterAccommodationByAccommodationInfo(value);
        }

        if(maxPrice != null){
            accommodationList = accommodationList.stream().filter(accommodation -> filterByMaxPrice(accommodation,maxPrice)).collect(Collectors.toList());
        }
        if(maxPrice != null){
            accommodationList = accommodationList.stream().filter(accommodation -> filterByMinPrice(accommodation,minPrice)).collect(Collectors.toList());
        }
        return accommodationList;
    }

    private Boolean filterByMaxPrice(Accommodation accommodation,Integer maxPrice){
        for (Room room: accommodation.getRooms()){
            if(room.getRoomCost() < maxPrice)
                return true;
        }
        return false;
    }

    private Boolean filterByMinPrice(Accommodation accommodation,Integer minPrice){
        for (Room room: accommodation.getRooms()){
            if(room.getRoomCost() > minPrice)
                return true;
        }
        return false;
    }

    @Override
    public List<Accommodation> getAccommodationList() {
        return accommodationService.findAllSubmitAccommodation();
    }

}
