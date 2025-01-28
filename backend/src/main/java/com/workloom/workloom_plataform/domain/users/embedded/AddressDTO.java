package com.workloom.workloom_plataform.domain.users.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String streetName;
    private int streetNumber;
    private String city;
    private String state;
    private long zipCode;

    public AddressDTO() {}

    /* 
    public void setAddresses(AddressDTO addressDTO){
        this.streetName = addressDTO.getStreetName();
        this.streetNumber = addressDTO.getStreetNumber();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
        
    }*/
    public AddressDTO(String streetName, int streetNumber, String city, String state, long zipCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
