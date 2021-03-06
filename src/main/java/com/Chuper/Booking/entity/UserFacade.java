package com.Chuper.Booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class UserFacade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    private String userName;

    private String userRole;

    @NotNull
    private String password;

    @JsonIgnore
    @OneToOne
    private Employee employee;

    private String confirmHash;

    @JsonIgnore
    @OneToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public List<String> getRoleList(){
        if(this.userRole.length() > 0){
            return Arrays.asList(this.userRole.split(","));
        }
        return new ArrayList<>();
    }

    public UserFacade(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }
    public UserFacade(){
    }

    public String getConfirmHash() {
        return confirmHash;
    }

    public void setConfirmHash(String confirmHash) {
        this.confirmHash = confirmHash;
    }
}
