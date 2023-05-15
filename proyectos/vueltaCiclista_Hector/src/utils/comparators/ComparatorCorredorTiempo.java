package utils.comparators;

import java.util.Comparator;

import models.Corredor;

public class ComparatorCorredorTiempo implements Comparator<Corredor>{

    @Override
    public int compare(Corredor c1, Corredor c2)
    {
        int dif = c1.getTiempo().compareTo(c2.getTiempo());

        return dif;
    }
    
}
