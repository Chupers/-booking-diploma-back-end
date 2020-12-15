package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.Accommodation;
import com.Chuper.Booking.entity.AccommodationInfo;
import com.Chuper.Booking.entity.Characteristic;

import java.util.List;
import java.util.Set;

public interface SearchService {

    List<AccommodationInfo> getAccommodationInfo();

    List<Characteristic> getCharacteristic();

    List<Characteristic> getFirstFiveCharacteristic();

    List<Accommodation> filterAccommodationByBasicFilter();

    List<Accommodation> filterAccommodationByAccommodationInfo(String info);

    Set<String> getCityList();

    List<Accommodation> findByDetailsFilter(Integer minPrice,Integer maxPrice,Integer countStar,String value);

    List<Accommodation> getAccommodationList();
}
