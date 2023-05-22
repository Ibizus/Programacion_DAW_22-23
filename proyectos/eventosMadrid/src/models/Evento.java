package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
    

    // ATTRIBUTES:
    private String id;
    private String title;
    private boolean free;
    private double price;
    private Address address;
    private String link;

    // CONSTRUCTOR:
    public Evento(){

    }

    public Evento(String id, String title, boolean free, double price, Address address, String link){

        this.id = id;
        this.title = title;
        this.free = free;
        this.price = price;
        this.address = address;
        this.link = link;
    }





}
