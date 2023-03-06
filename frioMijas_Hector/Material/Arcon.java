package frioMijas_Hector.Material;

public class Arcon extends Equipo{
    

    // ATRIBUTOS:
    private String apertura;

    // CONSTRUCTORES:
    public Arcon(double alto, double ancho, double profundo, double frigorias, String marca, String apertura)
    {
        super(alto, ancho, profundo, frigorias, marca);
        this.apertura = apertura;
    }



    // METODOS:
    public String getApertura()
    {
        return apertura;
    }

    public double getConsumo()
    {
        return super.getFrigorias()*2;
    }

    

}
