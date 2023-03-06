package frioMijas_Hector.Material;

public class Frigorifico extends Equipo {
 
    
    // ATRIBUTOS:


    // CONSTRUCTORES:
    public Frigorifico(double alto, double ancho, double profundo, double frigorias, String marca)
    {
        super(alto, ancho, profundo, frigorias, marca);
    }

    
    // METODOS:
    public double getVolumen()
    {
        return (super.getAlto()*super.getAncho()*super.getProfundidad());
    }

    public double getConsumo()
    {
        return super.getFrigorias()*3;
    }
}
