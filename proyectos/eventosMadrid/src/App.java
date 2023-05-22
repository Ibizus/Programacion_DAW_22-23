import java.util.ArrayList;

import models.Evento;
import utils.ManejoFicheros;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        System.out.println("Hello, World!");

        ArrayList<Evento> listaEventosCsv = ManejoFicheros.leerFicheroEventos("206974-0-agenda-eventos-culturales-100.csv");
        
        System.out.println(listaEventosCsv);

        System.out.println(listaEventosCsv.size());
    }
}
