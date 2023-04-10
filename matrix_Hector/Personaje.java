package matrix_Hector;

import java.time.LocalDateTime;

public abstract class Personaje {
    
    // ATRIBUTOS:
    protected int id;
    protected String nombre;
    protected String ciudad;
    protected LocalDateTime creacion;

    static private int personajesCreados;


    // CONSTRUCTOR:
    protected Personaje()
    {
        personajesCreados++;
        this.id = personajesCreados;

        this.nombre = nombreAleatorio();
        this.ciudad = ciudadAleatoria();

        this.creacion = LocalDateTime.now();
    }

    public abstract void mostrarInformacion();

    public String ciudadAleatoria()
    {
        String[] ciudades = {"Madrid", "New York", "Pekin", "Leganés", "Londres", "Paris", "Fuengirola", "Dublin", "Bagdad", "Texas", "Caracas"};

        int aleatorio = (int)(Math.random()*ciudades.length);

        return ciudades[aleatorio];
    }

    public String nombreAleatorio()
    {
        String[] nombres = {"Juan", "Pedro", "María", "Ana", "Luis", "Carlos", "Sofía", "Lucía", "Elena", "Miguel", "Pablo", "David", "Miriam", "Jesús", "Carmen", "Alicia", "Antonio"};

        int aleatorio = (int)(Math.random()*nombres.length);

        return nombres[aleatorio];
    }
    
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
