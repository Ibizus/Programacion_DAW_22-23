package INTERFACES.jugadoresFutbol;

import java.util.Comparator;

public class JugadorComparatorGoles implements Comparator{


    @Override
    public int compare(Object arg0, Object arg1)
    {
        Jugador j1 = (Jugador)arg0;
        Jugador j2 = (Jugador)arg1;

        int dif = 0;

        if(j1.getGoles() < j2.getGoles())
        {
            dif = -1;
        }
        else if(j1.getGoles() > j2.getGoles())
        {
            dif = 1;
        }
        else 
        {
            dif = new JugadorComparatorNombre().compare(j1, j2);
        }

        return dif;
    }
    
}
