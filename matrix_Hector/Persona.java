package matrix_Hector;

import java.time.LocalDateTime;

public abstract class Persona {
    
    // ATRIBUTOS:
    protected int id;
    protected String nombre;
    protected String ciudad;
    protected LocalDateTime creacion;

    static private int personajesCreados;


    // CONSTRUCTOR:
    protected Persona(String nombre, String ciudad)
    {
        personajesCreados++;
        this.id = personajesCreados;

        this.nombre = nombre;
        this.ciudad = ciudad;

        this.creacion = LocalDateTime.now();
    }

    public abstract void mostrarInformacion();

    
    // GETTERS:
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDateTime getCreacion() {
        return creacion;
    }

    public static int getCreados() {
        return personajesCreados;
    }


}
