package matrix_Hector;

public class Neo extends Personaje{

    // ATRIBUTOS:
    private boolean elegido;
    private int poder;


    // CONSTRUCTOR:
    protected Neo()
    {
        super();
        super.nombre = "NEO";

        elegido = true;
        poder = (int)(Math.random()*3)+1;
    }


    @Override
    public void mostrarInformacion()
    {
        System.out.println("Neo-> id: " + super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad());
    }
    
}
