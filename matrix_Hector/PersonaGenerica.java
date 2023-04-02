package matrix_Hector;

public class PersonaGenerica extends Persona{


    // ATRIBUTOS:
    private int probabilidadMuerte;


    // CONTRUCTOR:
    protected PersonaGenerica(String nombre, String ciudad)
    {
        super(nombre, ciudad);
        probabilidadMuerte = (int)(Math.random()*100)+1;
    }

    // METODOS:
    @Override
    public void mostrarInformacion()
    {
       
    }

    public int getProbabilidadMuerte() {
        return probabilidadMuerte;
    }

    

    
}
