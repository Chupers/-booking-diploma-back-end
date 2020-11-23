package com.Chuper.Booking.entity;

import com.Chuper.Booking.entity.enums.AccommodationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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



    @JsonIgnore
    @OneToMany(mappedBy = "accommodation",fetch = FetchType.LAZY)
    private List<Employee> employeeList;

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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public AccommodationInfo getAccommodationInfo() {
        return accommodationInfo;
    }

    public void setAccommodationInfo(AccommodationInfo accommodationInfo) {
        this.accommodationInfo = accommodationInfo;
    }
}
