package INTERFACES.jugadoresFutbol;

import java.util.Arrays;
import java.util.Scanner;

import INTERFACES.jugadoresFutbol.Comparator.JugadorComparatorGoles;

public class JugadoresSpain {
        
    public static void main(String[] args) {

        // Instancio el array plantilla para cada coleccion Equipo:
        Jugador[] plantillaJugadoresB = new Jugador[0];
        Jugador[] plantillaJugadoresM = new Jugador[0];

        // Declaramos los equipos:
        Equipo<Jugador> betis = new Equipo<Jugador>("Real Betis Balompie Sala", plantillaJugadoresB);
        Equipo<Jugador> malaga = new Equipo<Jugador>("Málaga Club de Futbol Sala", plantillaJugadoresM);


        // Vamos a convocar a 5 jugadores de cada equipo para el partido
        // LOS CREAMOS E INTRODUCIMOS EN EL ARRAY COMPROBANDO QUE NO ESTÁN YA:
        for (int i = 0; i <= 5; i++)
        {

        }



        jugadoresSpain[0].compareTo(jugadoresSpain[1]);

        JugadorComparatorGoles comparatorGoles = new JugadorComparatorGoles();

        comparatorGoles.compare(jugadoresSpain[0], jugadoresSpain[1]);

        Arrays.sort(jugadoresSpain, comparatorGoles);

        System.out.println(jugadoresSpain);

        Arrays.sort(jugadoresSpain, (j1,j2)->j1.getGoles()-j2.getGoles());



        sc.close();
    }

    // METODOS:
    
    /**
     * Crea un jugador aleatorio, comprueba si está para insertarlo en el array, 
     * o crea uno nuevo si está repetido hasta que pueda insertarlo
     * @param array
     * @param player
     * @return
     */
    static void fichaJugador(Jugador[] array)
    {
        Jugador jugadorAl = UtilesJugadores.generaJugadorAleatorio();

        // Mientras no se pueda insertar al jugador genera otro aleatorio y lo inserta:
        while(!insertaJugador(array, jugadorAl))
        {
            jugadorAl = UtilesJugadores.generaJugadorAleatorio();

            insertaJugador(array, jugadorAl);
        }

    }



    /**
     * Inserta un Jugador en el array comprobando que no esté ya anteriormente
     * @param array
     * @param player
     * @return insertado
     */
    static boolean insertaJugador(Jugador[] array, Jugador player)
    {
        boolean insertado = false;

        if(!compruebaJugador(array, player)) // llama a la función comprueba jugador
        {
            Jugador[] nuevo = new Jugador[array.length+1];

            for (int i = 0; i < nuevo.length; i++)
            {
                nuevo[i] = array[i];
            }
            nuevo[nuevo.length-1] = player;

            array = nuevo;

            insertado = true;
        }
        else 
        {
            System.out.println("Este jugador ya está apuntado");
        }
        return insertado;
    }


    /**
     * Comprueba si el jugador está en el array por su nombre completo
     * @param array
     * @param player
     * @return yaEsta
     */
    static boolean compruebaJugador(Jugador[] array, Jugador player)
    {
        boolean yaEsta = false;

        for (int i = 0; i < array.length; i++)
        {
            if(array[i].getNombre().equals(player.getNombre()))
            {
                yaEsta = true;
            }
        }
        return yaEsta;
    }
}
