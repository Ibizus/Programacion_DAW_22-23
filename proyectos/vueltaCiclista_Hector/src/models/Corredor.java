package models;

public class Corredor extends Ciclista{
 
    // ATTRIBUTES:
    private Integer dorsal;
    private Integer tiempo;



    // CONSTRUCTOR:
    public Corredor(Ciclista c, Integer dorsal){

        super(c.nombre, c.codigoEquipo, c.peso, c.pais);
        this.dorsal = dorsal;
    }

    
}
