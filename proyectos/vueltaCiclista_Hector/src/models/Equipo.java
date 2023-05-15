package models;

public class Equipo {
    
    // ATTRIBUTES:
    private String codigo;
    private String nombre;
    private String nacionalidad;
    private int presupuesto;

    // CONSTRUCTOR:
    public Equipo(String codigo, String nombre, String nacionalidad, int presupuesto){

        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.presupuesto = presupuesto;
    }

}
