package matrix_Hector;

public class Smith extends Persona{

    // ATRIBUTOS:
    private int infeccion;

    // CONSTRUCTOR:
    protected Smith(String nombre, String ciudad)
    {
        super(nombre, ciudad);

        infeccion = (int)(Math.random()*3)+1;
    }

    @Override
    public void mostrarInformacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarInformacion'");
    }
    
}
