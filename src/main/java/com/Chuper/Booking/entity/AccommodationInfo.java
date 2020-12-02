package com.Chuper.Booking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccommodationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accommodationInfoId;

    private String accommodationName;
    private String accommodationCountry;
    private String accommodationCity;
    private String accommodationStreet;
    private String accommodationDesc;
    private Integer countStar;


    public int getCountStar() {
        return countStar;
    }

    public void setCountStar(int countStar) {
        this.countStar = countStar;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

    public String getAccommodationCountry() {
        return accommodationCountry;
    }

    public void setAccommodationCountry(String accommodationCountry) {
        this.accommodationCountry = accommodationCountry;
    }

    public String getAccommodationCity() {
        return accommodationCity;
    }

    public void setAccommodationCity(String accommodationCity) {
        this.accommodationCity = accommodationCity;
    }

    public String getAccommodationStreet() {
        return accommodationStreet;
    }

    public void setAccommodationStreet(String accommodationStreet) {
        this.accommodationStreet = accommodationStreet;
    }

    public String getAccommodationDesc() {
        return accommodationDesc;
    }

    public void setAccommodationDesc(String accommodationDesc) {
        this.accommodationDesc = accommodationDesc;
    }

    public AccommodationInfo() {
    }

    public Long getAccommodationInfoId() {
        return accommodationInfoId;
    }

    public void setAccommodationInfoId(Long accommodationInfoId) {
        this.accommodationInfoId = accommodationInfoId;
    }
}
