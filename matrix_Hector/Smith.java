package matrix_Hector;

public class Smith extends Personaje{

    // ATRIBUTOS:
    private int infeccion;
    private int iteracionDeCreaccion;

    // CONSTRUCTOR:
    protected Smith()
    {
        super();
        this.nombre = "SMITH";

        infeccion = (int)(Math.random()*3)+1;
    }

    // METODOS:
    @Override
    public void mostrarInformacion()
    {
        System.out.println("Smith-> id: " + super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad());
    }

    public int getInfeccion() {
        return infeccion;
    }

    public int getIteracionDeCreaccion() {
        return iteracionDeCreaccion;
    }

}
