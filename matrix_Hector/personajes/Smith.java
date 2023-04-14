package matrix_Hector.personajes;

import java.time.LocalDateTime;

public class Smith extends Personaje implements Comparable<Smith>{

    // ATRIBUTOS:
    private int infeccion;
    private int iteracionDeCreaccion;

    // CONSTRUCTOR:
    public Smith()
    {
        super();
        this.nombre = "SMITH";

        infeccion = (int)(Math.random()*3)+1;
        iteracionDeCreaccion = 0;
    }

    public Smith(int id, LocalDateTime fecha, String ciudad, int index)
    {
        this.id = id;
        this.iteracionDeCreaccion = index;
        this.creacion = fecha;
        this.nombre = "SMITH";
        this.ciudad = ciudad;
        Personaje.personajesCreados--;
    }

    
    // METODOS:
    @Override
    public String mostrarInformacion()
    {
        return super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad();
    }

    @Override
    public int compareTo(Smith o)
    {
        return this.creacion.compareTo(o.creacion);
    }

    // GETTERS Y SETTERS:
    public int getInfeccion() {
        return infeccion;
    }

    public int getIteracionDeCreaccion() {
        return iteracionDeCreaccion;
    }

    public void setIteracionDeCreaccion(int iteracionDeCreaccion) {
        this.iteracionDeCreaccion = iteracionDeCreaccion;
    }

    public void setInfeccion(int infeccion) {
        this.infeccion = infeccion;
    }

}
