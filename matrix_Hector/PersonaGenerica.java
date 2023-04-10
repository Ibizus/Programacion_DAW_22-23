package matrix_Hector;

public class PersonaGenerica extends Personaje{


    // ATRIBUTOS:
    private int probabilidadMuerte;


    // CONTRUCTOR:
    protected PersonaGenerica()
    {
        super();
        probabilidadMuerte = (int)(Math.random()*100)+1;
    }

    // METODOS:
    @Override
    public void mostrarInformacion()
    {
        System.out.println("id: " + super.getId() + ", nombre: " + super.getNombre() + ", ciudad: " + super.getCiudad());
    }

    public int getProbabilidadMuerte() {
        return probabilidadMuerte;
    }

}
