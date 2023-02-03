package com.raphael.coursemanagementsystems.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    private String id;
    private Integer houseNumber;
    private String street;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private Integer zipcode;

    public Address(Integer houseNumber, String street, String landmark, String city, String state, String country, Integer zipcode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}
