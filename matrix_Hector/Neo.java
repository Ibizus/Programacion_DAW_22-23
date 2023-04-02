package matrix_Hector;

public class Neo extends Persona{

    // ATRIBUTOS:
    private boolean elegido;
    private int poder;


    // CONSTRUCTOR:
    protected Neo(String nombre, String ciudad)
    {
        super(nombre, ciudad);

        elegido = true;
        poder = (int)(Math.random()*3)+1;
    }



    @Override
    public void mostrarInformacion()
    {

    }
    
}
