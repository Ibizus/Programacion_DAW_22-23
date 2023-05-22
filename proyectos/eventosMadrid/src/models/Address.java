package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    

    // ATTRIBUTES:
    private Area area;

    // CONSTRUCTOR:
    public Address(){

    }
}
