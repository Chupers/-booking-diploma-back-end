package com.Chuper.Booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organizationName;

    @JsonIgnore
    @OneToMany(mappedBy = "organization",fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "organization",fetch = FetchType.LAZY)
    private List<Accommodation> accommodations;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Employee> getEmployeeList() {
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Accommodation> getAccommodations() {
        if(accommodations == null){
            accommodations = new ArrayList<>();
        }
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }


}
