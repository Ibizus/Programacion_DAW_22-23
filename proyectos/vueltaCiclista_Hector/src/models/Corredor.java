package models;

public class Corredor extends Ciclista implements Comparable<Corredor>{
 
    // ATTRIBUTES:
    private Integer dorsal;
    private Integer tiempo;


    // CONSTRUCTOR:
    public Corredor(Ciclista c, Integer dorsal){

        super(c.nombre, c.codigoEquipo, c.peso, c.pais);
        this.dorsal = dorsal;
    }

    // METHODS:
    @Override
    public int compareTo(Corredor c)
    {
        return (this.dorsal-c.dorsal);
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public Integer getTiempo() {
        return tiempo;
    }
        
}
