package INTERFACES.jugadoresFutbol;

import java.util.Comparator;

public class JugadorComparatorNombre implements Comparator<Jugador>{

    @Override
    public int compare(Jugador j1, Jugador j2)
    {

        int dif = j1.getNombre().compareTo(j2.getNombre());

        return dif;
    }
    
}
