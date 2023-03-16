package INTERFACES.jugadoresFutbol;

import java.util.Comparator;

public class JugadorComparatorNombre implements Comparator{

    @Override
    public int compare(Object arg0, Object arg1)
    {
        Jugador j1 = (Jugador)arg0;
        Jugador j2 = (Jugador)arg1;

        int dif = j1.getNombre().compareTo(j2.getNombre());

        return dif;
    }
    
}
