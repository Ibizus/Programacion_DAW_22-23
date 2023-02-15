package TRENES.Maquinaria;

import TRENES.Personal.Maquinista;

public class Tren {
 
    // ATRIBUTOS:
    private Locomotora locomotora;
    private Vagon[] vagones;
    private Maquinista responsable;

    // CONSTRUCTOR:
    public Tren(Locomotora locomotora, Maquinista responsable)
    {
        this.locomotora = locomotora;
        this.responsable = responsable;
    }

    // METODOS:
    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    private Vagon[] getVagones() {
        return vagones;
    }

    private void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }

    public Maquinista getResponsable() {
        return responsable;
    }

    public void setResponsable(Maquinista responsable) {
        this.responsable = responsable;
        
    }

    public Tren enganchaVagon(int max, int carga, String descripcion)
    {
        if(carga <= max)
        {
            Vagon nuevo = new Vagon(max, carga, descripcion);

            this.vagones = añadeVagon(vagones, nuevo);

        }
        else 
        {
            System.out.println("No se puede enganchar, supera la carga máxima");

        }
        
        return null;
    }
    
    /**
     * Inserta un elemento al final del array
     * @param array,elemento
     * @return nuevo
     */
    public static Vagon[] añadeVagon(Vagon[] array, Vagon nuevoVagon)
    {
        if(array.length < 5) // Comprobamos que se puede anganchar el vagón
        {
            Vagon[] nuevo = new Vagon[array.length+1];

            for (int i = 0; i < array.length; i++)
            {
                nuevo[i] = array[i];
            }
    
            nuevo[nuevo.length-1] = nuevoVagon;
            
            return nuevo;
        }
        else
        {
            System.out.println("No se puede encganchar, ya hay 5 vagones");

            return array;
        }


    }

}
