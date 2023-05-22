package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direccion {
    
    // ATTRIBUTES:
    private Area area;


    // CONSTRUCTOR:
    public Direccion(){

    }

    // METHODS:
    public String toString(){

        return area.toString();
    }

    // GETTERS & SETTERS:
    public Direccion(Area area){

        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
