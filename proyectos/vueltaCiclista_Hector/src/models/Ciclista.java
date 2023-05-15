package models;

public class Ciclista {
    
    //ATTRIBUTES:
    protected String nombre;
    protected String codigoEquipo;
    protected int peso;
    protected String pais;


    // CONSTRUCTORS:
    public Ciclista(){

    }

    public Ciclista(String nombre, String codigoEquipo, int peso, String pais){

        this.nombre = nombre;
        this.codigoEquipo = codigoEquipo;
        this.peso = peso;
        this.pais = pais;
    }

    // METHODS:
    public String toString(){

        return this.nombre + " (" + this.codigoEquipo + ")";
    }


    // GETTERS & SETTERS:
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCodigoEquipo() {
        return codigoEquipo;
    }


    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }


    public int getPeso() {
        return peso;
    }


    public void setPeso(int peso) {
        this.peso = peso;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }

    
}
