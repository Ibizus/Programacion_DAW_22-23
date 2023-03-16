package INTERFACES.jugadoresFutbol;

import java.util.Comparator;

public class JugadorComparatorApodo implements Comparator{
    

    @Override
    public int compare(Object arg0, Object arg1)
    {
        Jugador j1 = (Jugador)arg0;
        Jugador j2 = (Jugador)arg1;

        int dif = j1.getApodo().compareTo(j2.getApodo());

        if(dif == 0)
        {
            dif = new JugadorComparatorNombre().compare(j1, j2);
        }

        return dif;
    }
    
}
