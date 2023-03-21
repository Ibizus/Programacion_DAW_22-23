package INTERFACES.jugadoresFutbol;

public class Portero extends Jugador{


    // ATRIBUTOS:
    private int defensa;


    // CONSTRUCTOR:
    public Portero(String nombre, String apodo)
    {
        super(nombre, apodo);
        defensa = 50;
    }
    
            
    // METODOS:
    public int getDefensa()
    {
        return this.defensa;
    }


}
