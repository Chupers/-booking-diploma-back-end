package com.Chuper.Booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CharacteristicChild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String iconName;

    private String childName;

    @JsonIgnore
    @ManyToOne
    private Characteristic characteristic;

    public CharacteristicChild() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }
}
