package com.Chuper.Booking.entity;

import com.Chuper.Booking.entity.enums.AccommodationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accommodationId;

    @OneToOne
    private AccommodationInfo accommodationInfo;

    @Enumerated
    private AccommodationType accommodationType;

    private String imageId;

    private Boolean isAvailable;

    private Boolean isSubmit;

    @OneToMany(mappedBy = "accommodation",fetch = FetchType.LAZY)
    private List<Characteristic> characteristicList;

    @JsonIgnore
    @ManyToOne
    private Organization organization;

    @OneToMany(mappedBy = "accommodation",fetch = FetchType.LAZY)
    private List<Room> rooms;


    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }

    public void addToCharacteristicList(Characteristic characteristic){
        if(characteristicList == null){
            characteristicList = new ArrayList<>();
        }
        this.characteristicList.add(characteristic);
    }

    public void setCharacteristicList(List<Characteristic> characteristicList) {
        this.characteristicList = characteristicList;
    }

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }


    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public AccommodationInfo getAccommodationInfo() {
        return accommodationInfo;
    }

    public void setAccommodationInfo(AccommodationInfo accommodationInfo) {
        this.accommodationInfo = accommodationInfo;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getSubmit() {
        return isSubmit;
    }

    public void setSubmit(Boolean submit) {
        isSubmit = submit;
    }

    public Organization getOrganization() {
        return organization;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
