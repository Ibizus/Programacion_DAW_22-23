package matrix_Hector.personajes;

public class Neo extends Personaje{

    // ATRIBUTOS:
    private boolean elegido;
    private int poder;


    // CONSTRUCTOR:
    public Neo()
    {
        super();
        super.nombre = "NEO";

        elegido = true;
        poder = (int)(Math.random()*3)+1;
    }


    @Override
    public String mostrarInformacion()
    {
        return "Neo-> id: " + super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad();
    }
    
}
