package COLECCIONES;

import java.util.ArrayList;
import java.util.HashSet;

public class ejercicio1 {
    public static void main(String[] args) {
        

        ArrayList<Integer> lista = new ArrayList<>();


        for (int i = 0; i <= 20; i++)
        {
            lista.add((int)(Math.random()*10)+1);
        }

        System.out.println(lista);


        HashSet<Integer> conjunto = new HashSet<>();

        conjunto.addAll(lista);
    }
}
