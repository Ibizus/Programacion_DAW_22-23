package INTERFACES.jugadoresFutbol;

public class JugadoresSpain {
        
    public static void main(String[] args) {



        // Declaramos los equipos:
        Equipo betis = new Equipo("Real Betis Balompie Sala");
        Equipo malaga = new Equipo("Málaga Club de Futbol Sala");


        // VAMOS A CONVOCAR A 5 JUGADORES DE CADA EQUIPO PARA EL PARTIDO:

        // Los convocamos usando el método que los crea, comprueba si están, y los añade al array:
        betis.convocaJugador(5);


        // Convocamos 5 jugadores para el equipo contrario
        malaga.convocaJugador(5);


        System.out.println(betis);

        System.out.println("-----------------------------------------");

        System.out.println(malaga);


        





        // jugadoresSpain[0].compareTo(jugadoresSpain[1]);

        // JugadorComparatorGoles comparatorGoles = new JugadorComparatorGoles();

        // comparatorGoles.compare(jugadoresSpain[0], jugadoresSpain[1]);

        // Arrays.sort(jugadoresSpain, comparatorGoles);

        // System.out.println(jugadoresSpain);

        // Arrays.sort(jugadoresSpain, (j1,j2)->j1.getGoles()-j2.getGoles());



        // sc.close();
    }

    // METODOS:


    
}
