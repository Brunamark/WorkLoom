package com.workloom.workloom_plataform.domain.users.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private int streetNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private long zipCode;

    public Address() {
    }

    public Address(String streetName, int streetNumber, String city, String state, long zipCode) {
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
    }

}
