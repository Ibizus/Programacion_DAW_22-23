package INTERFACES.jugadoresFutbol;

import java.util.Scanner;

public class JugadoresSpain {
        
    public static void main(String[] args) {
        
        Jugador[] jugadoresSpain = new Jugador[0];
        Scanner sc = new Scanner(System.in);

        // PEDIMOS NUMERO DE JUGADORES A CREAR:
        System.out.println("¿Cuantos jugadores quieres crear? (Introduce un número mayor o igual a 5)");
        int numJugadores = sc.nextInt();

        // COMPROBAMOS LA CANTIDAD DE JUGADORES:
        while(numJugadores<5)
        {
            System.out.println("Cantidad incorrecta, introduce otra");
            numJugadores = sc.nextInt();
        }

        // LOS CREAMOS E INTRODUCIMOS EN EL ARRAY COMPROBANDO QUE NO ESTÁN YA:
        for (int i = 0; i < numJugadores; i++)
        {
            Jugador jugadorAl = UtilesJugadores.generaJugadorAleatorio();


            while(!insertaJugador(jugadoresSpain, jugadorAl))
            {
                jugadorAl = UtilesJugadores.generaJugadorAleatorio();

                insertaJugador(jugadoresSpain, jugadorAl);
            }
        }

        sc.close();
    }

    // METODOS:
    
    /**
     * Inserta un Jugador en el array comprobando que no esté ya anteriormente
     * @param array
     * @param player
     * @return insertado
     */
    static boolean insertaJugador(Jugador[] array, Jugador player)
    {
        boolean insertado = false;

        if(!compruebaJugador(array, player))
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
