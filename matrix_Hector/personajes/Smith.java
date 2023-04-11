package matrix_Hector.personajes;

public class Smith extends Personaje{

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



    // METODOS:
    @Override
    public String mostrarInformacion()
    {
        return super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad();
    }

    public int getInfeccion() {
        return infeccion;
    }

    public int getIteracionDeCreaccion() {
        return iteracionDeCreaccion;
    }

    public void setIteracionDeCreaccion(int iteracionDeCreaccion) {
        this.iteracionDeCreaccion = iteracionDeCreaccion;
    }

    
}
