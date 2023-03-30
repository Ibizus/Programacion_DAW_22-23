package INTERFACES.jugadoresFutbol;

import java.util.Arrays;
import INTERFACES.jugadoresFutbol.Comparator.JugadorComparatorGoles;

public class JugadoresSpain {
        
    // FINALS:
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN_BG = "\u001B[42m";
    private static final String ANSI_CYAN_BG = "\u001B[46m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {


        // Declaramos los equipos:
        Equipo malaga = new Equipo(ANSI_CYAN_BG + "Málaga Club de Futbol Sala" + ANSI_RESET);
        Equipo betis = new Equipo(ANSI_GREEN_BG + "Real Betis Balompie Sala" + ANSI_RESET);


        /*** VAMOS A CONVOCAR A 5 JUGADORES DE CADA EQUIPO PARA EL PARTIDO: ***/

        // Los convocamos usando el método que los crea, comprueba si están, y los añade al array:
        malaga.convocaJugador(5);

        // Convocamos 5 jugadores para el equipo contrario
        betis.convocaJugador(5);

        // Mostramos la plantilla de ambos equipos:
        System.out.println(ANSI_YELLOW + "¡¡AQUÍ TENEMOS LA ALINEACION DE AMBOS EQUIPO PARA EL PARTIDO DE HOY!!" + ANSI_RESET);
        System.out.println(malaga);
        System.out.println("----------------------------------------------------");
        System.out.println(betis);


        /******** ENFRENTAMOS A LOS EQUIPOS PARA GENERAR GOLES Y FALTAS: ********/

        System.out.println(bienvenida());

        // PARTIDO:
        final int pelotaAlCentro = 2;
        int posicionPelota = pelotaAlCentro; // Empieza el partido en el centro del campo. (posicion 3 de las 5 que tenemos)
        int jugadas = 0;

        // Enfrentamiento jugadores:
        while (jugadas<= 100) // Voy a dar 30 regates por partido para no hacerlo muy largo
        {
            // genero mi valor de enfrentamiento según la posición en la que está pelota
            int enfrentamiento = choque(malaga.getJugadores()[posicionPelota], betis.getJugadores()[posicionPelota]);

            if (enfrentamiento >= 0 && enfrentamiento < 20) // gana el regate el equipo local (y no hay falta)
            {
                if(posicionPelota == 4) // Si estamos en la portería visitante hacemos gol y sacamos del centro otra vez
                {
                    malaga.getJugadores()[4].hacerGol();
                    malaga.actualizaGoles();
                    posicionPelota = pelotaAlCentro;
                    muestraMarcador(malaga, betis);
                }
                else 
                {
                    posicionPelota++;
                    System.out.println(pelota(posicionPelota));
                }

            }
            else if (enfrentamiento < 0 && enfrentamiento > -20) // gana el regate el equipo visitante (y no hay falta)
            {

                if(posicionPelota == 0) // Si estamos en la portería local
                {
                    betis.getJugadores()[0].hacerGol();
                    betis.actualizaGoles();
                    posicionPelota = pelotaAlCentro;
                    muestraMarcador(malaga, betis);
                }
                else 
                {
                    posicionPelota--;
                    System.out.println(pelota(posicionPelota));
                }

            }
            else if (enfrentamiento >= 20 || enfrentamiento <= -20) // HAY FALTA
            {
                System.out.println("¡¡ARBITRO!!");

                if (enfrentamiento > 0) // falta del equipo local
                {
                    malaga.getJugadores()[posicionPelota].cometerFalta();
                    malaga.actualizaFaltas();
                }
                else // falta del equipo visitante
                {
                    betis.getJugadores()[posicionPelota].cometerFalta();
                    betis.actualizaFaltas();
                }
                posicionPelota = pelotaAlCentro;
            }
            jugadas++;
        }
        System.out.println(ANSI_YELLOW + "\n\t¡¡¡ FIN DEL PARTIDO !!!\n¡EL ARBITRO PITA EL FINAL Y ESTO SE ACABA SEÑORES!" + ANSI_RESET);
        muestraMarcador(malaga, betis);

        System.out.println(ANSI_YELLOW + "\nPASAMOS CON LAS ESTADÍSTICAS DE LOS JUGADORES" + ANSI_RESET);


        /*** MOSTRAR JUGADORES ORDENADOS POR NUMERO DE LICENCIA: ***/
        System.out.println("\n - - - - - Jugadores ordenados por licencia: - - - - - \n");

        System.out.println(malaga.getNombre());
        Arrays.sort(malaga.getJugadores());
        System.out.println(malaga);

        System.out.println(betis.getNombre());
        Arrays.sort(betis.getJugadores());
        System.out.println(betis);


        /*** MOSTRAR JUGADORES ORDENADOS POR NUMERO DE GOLES: ***/
        System.out.println("\n - - - - - Jugadores ordenados por goles: - - - - - \n");

        JugadorComparatorGoles comparatorGoles = new JugadorComparatorGoles();

        System.out.println(malaga.getNombre());
        Arrays.sort(malaga.getJugadores(), comparatorGoles);
        System.out.println(malaga);


        /*** MOSTRAR JUGADORES ORDENADOS POR NUMERO DE FALTAS:  ( CON LAMBDA )  ***/  
        System.out.println("\n - - - - - Jugadores ordenados por faltas: - - - - - \n");

        System.out.println(malaga.getNombre());
        Arrays.sort(malaga.getJugadores(), (j1,j2)->j1.getGoles()-j2.getGoles());
        System.out.println(malaga);

        System.out.println(betis.getNombre());
        Arrays.sort(betis.getJugadores(), (j1,j2)->j1.getGoles()-j2.getGoles());
        System.out.println(betis);


        // Arrays.sort(jugadoresSpain, (j1,j2)->j1.getGoles()-j2.getGoles());

    }


    // METODOS:

    /**
     * Devuelve el mensaje de presentación del partido de futbol
     * @return mensajeBienvenida
     */
    public static String bienvenida()
    {
        return (ANSI_YELLOW + "\nBIENVENIDO AL PARTIDO DE LA TEMPORADA\n" +
        "El Málaga, que hoy juega en casa, necesita afianzar una racha tres victorias consecutivas para salir" +
        "\ndel profundo pozo en el que se encuentra, pero nuestro visitante, el Betis, no está dispuesto" +
        "\n a vender su piel puesto que se se acerca a los grandes y este curso aspiran a lo máximo." +
        "\n\t\t¡¡NOS ESPERA UN DUELO DE TITANES!!" + ANSI_RESET + "\n\nEMPIEZA EL PARTIDO:");
    }

    /**
     * Devuelve un String indicando donde se está jugando el partido dependiendo de 
     * la que posición del array en que se esté produciendo el enfrentamiento de jugadores
     * @param posicionPelota
     * @return StringPosicion
     */
    public static String pelota(int posicionPelota)
    {
        String salida = "";

        switch(posicionPelota)
        {
            case 0:
                salida = "¡¡Tiro a puerta de los visitantes!!";
                break;
            case 1:
                salida = "¡¡Estamos en el área local!!";
                break;
            case 2:
                salida = "Se juega la pelota en el medio campo";
                break;
            case 3:
                salida = "¡¡Atacan los locales!!";
                break;
            case 4:
                salida = "¡¡Contra las cuerdas el equipo visitante!!";
                break;
            default:
        }
        return salida;
    }

    /**
     * Me devuelve un entero como resultado del enfrentamiento de dos jugadores, 
     * positivo si gana el primer jugador o jugador local 
     * y negativo si gana el segundo jugador o jugador visitante
     * @param local
     * @param visitante
     * @return resultadoChoque
     */
    public static int choque(Jugador local, Jugador visitante)
    {
        int ataque_J1 = (int)(Math.random()*(100-local.getRegate())) + local.getRegate();
        int ataque_J2 = (int)(Math.random()*(100-visitante.getRegate())) + visitante.getRegate();

        return ataque_J1 - ataque_J2;
    }

    /**
     * Imprime el resultado actual del partido
     */
    public static void muestraMarcador(Equipo e1, Equipo e2)
    {
        System.out.println("\n\n\t MARCADOR \n" + e1.getNombre() + " -\t " + e1.getGoles() + "\n" + e2.getNombre() + " -\t " + e2.getGoles() + "\n\n");
    }
}
