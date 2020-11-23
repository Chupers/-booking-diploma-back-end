package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.AccommodationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationInfoRepository extends CrudRepository<AccommodationInfo,Long> {
}
