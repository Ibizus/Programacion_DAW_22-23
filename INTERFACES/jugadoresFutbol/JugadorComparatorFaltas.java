package INTERFACES.jugadoresFutbol;

import java.util.Comparator;

public class JugadorComparatorFaltas implements Comparator{
    

    @Override
    public int compare(Object arg0, Object arg1)
    {
        Jugador j1 = (Jugador)arg0;
        Jugador j2 = (Jugador)arg1;

        int dif = 0;

        if(j1.getFaltas() < j2.getFaltas())
        {
            dif = -1;
        }
        else if(j1.getFaltas() > j2.getFaltas())
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
