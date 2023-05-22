package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Area {


    // ATTRIBUTES:
    @JsonProperty("postal-code")
    private String postal_code;


    // CONSTRUCTOR.
    public Area(){

    }

    public Area(String postal_code){

        this.postal_code = postal_code;
    }
}
