package INTERFACES.jugadoresFutbol;

import java.util.Arrays;

public class Equipo<T extends Comparable<Jugador> >{
    

    // ATRIBUTOS:
    private String nombre;
    private T[] jugadores;
    private int goles;
    private int faltas;

    

    // CONSTRUCTOR:
    public Equipo(String nombre, T[] entrada)
    {
        this.nombre = nombre;
        jugadores = entrada;
    }


    // METODOS:
    public void añadeJugador(T nuevo)
    {
        T[] listaNueva = Arrays.copyOf(jugadores, jugadores.length+1);

        listaNueva[listaNueva.length-1] = nuevo;

        jugadores = listaNueva;
    }




    public void ordenar()
    {
        Arrays.sort(jugadores);
    }



    public void actualizaGoles()
    {
        int totalGoles = 0;

        for (int i = 0; i < jugadores.length; i++)
        {
            totalGoles += ((Jugador)jugadores[i]).getGoles();
        }
        
        this.goles = totalGoles;
    }


    public void actualizaFaltas()
    {
        int totalFaltas = 0;

        for (int i = 0; i < jugadores.length; i++)
        {
            totalFaltas += ((Jugador)jugadores[i]).getFaltas();
        }
        
        this.faltas = totalFaltas;
    }



    public String toString()
    {
        return "\tEQUIPO: " + this.nombre + "\nJugadores: " + Arrays.toString(jugadores);
    } 


}
