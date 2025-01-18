package com.workloom.workloom_plataform.domain.users;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class Address {
    
    private String streetName;

    private int streetNumber;

    private String city;

    private String state;

    private long zipCode;

   
}
