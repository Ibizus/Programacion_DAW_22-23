package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
    

    // ATTRIBUTES:
    private String id;
    private String title;
    private boolean free;
    private Direccion address;
    private String link;

    // CONSTRUCTOR:
    public Evento(){

    }

    public Evento(String id, String title, boolean free, Direccion address, String link){

        this.id = id;
        this.title = title;
        this.free = free;
        this.address = address;
        this.link = link;
    }


    // METHODS:
    public String toString(){

        return "\nid: " + id + " - Actividad: " + title + "\ngratis: " + ((free)? "SI" : "NO") + "\nCP: " + address.toString() + "\nEnlace: " + link;
    }

    // GETTERS & SETTERS:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Direccion getAddress() {
        return address;
    }

    public void setAddress(Direccion address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
