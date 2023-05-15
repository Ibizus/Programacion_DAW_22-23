package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carrera {
    
    // ATTRIBUTES:
    ArrayList<Equipo> equipos;
    ArrayList<Corredor> corredores;
    String nombre;


    // CONSTRUCTOR:
    public Carrera(List<Ciclista> inscritos, String nombre){

        int dorsal = 0;
        this.nombre = nombre;

        for (Ciclista ciclista : inscritos) 
        {
            dorsal++;

            if(!this.corredores.contains(ciclista))
            {
                this.corredores.add(new Corredor(ciclista, dorsal));
            }
        }
    }

    
    // METHODS:
    private void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void añadeEquiposCarrera(ArrayList<Equipo> lista)
    {
        this.setEquipos(lista);
    }

    public void insertarTiemposEtapa(Map<Integer, Integer> tiempos){

    }

    public void ordenarCorredoresPorTiempo(){

    }

    public Corredor buscarCorredorPorDorsal(int dorsal){

        return null;
    }

    public Integer posicionCorredor(Corredor c){

        return null;
    }

    public String clasificacionCompleta(){

        // dorsal – NombreCiclista (codEquipo) : tiempo

        return null;
    }

    public String clasificacionPorEquipos(){

        return null;
    }

    public String podium(){

        return null;
    }

}
