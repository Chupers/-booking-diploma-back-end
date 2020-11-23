package com.Chuper.Booking.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "characteristic",fetch = FetchType.LAZY)
    private List<CharacteristicChild> characteristicChildren;

    @ManyToOne
    private Accommodation accommodation;

    public Characteristic() {
    }

    public Long getId() {
        return id;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacteristicChild> getCharacteristicChildren() {
        return characteristicChildren;
    }

    public void setCharacteristicChildren(List<CharacteristicChild> characteristicChildren) {
        this.characteristicChildren = characteristicChildren;
    }
}
