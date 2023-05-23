import java.util.ArrayList;
import java.util.HashMap;

import models.Evento;
import models.ListaEventos;
import utils.ManejoFicheros;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Eventos Madrid!");

        // Leo los eventos de CSV, aplico los métodos y vuelco la salida en ficheros:
        ArrayList<Evento> listaEventosCsv = ManejoFicheros.leerFicheroEventos("206974-0-agenda-eventos-culturales-100.csv");
        
        System.out.println(listaEventosCsv);
        System.out.println("Número de eventos listados en el archivo CSV: " + listaEventosCsv.size());

        
        
        // ArrayList<Evento> listaEventosGratis = extraeListaEventosGratuitos(listaEventosCsv);
        // System.out.println(listaEventosGratis);

        // ArrayList<Evento> listaEventosGratis28009 = extraeListaEventosPorCP(listaEventosCsv, "28009");
        // System.out.println(listaEventosGratis28009);

        HashMap<String, Integer> diccionarioNumEventos = diccionarioNumEventosPorCP(listaEventosCsv);
        System.out.println(diccionarioNumEventos);

        
        // ListaEventos listaEventosJson = ManejoFicheros.leeListaEventosJson("206974-0-agenda-eventos-culturales-100.json");

        // System.out.println(listaEventosJson);
        // System.out.println(listaEventosJson.getGraph().size());
        

        // System.out.println(" - - - - - - - - - - - - - ");


    }



    // METHODS:

    /**
     * Se le pasa una lista de eventos y devuelve otra con los que son gratuitos
     * @param lista
     * @return
     */
    public static ArrayList<Evento> extraeListaEventosGratuitos(ArrayList<Evento> lista){

        ArrayList<Evento> nuevaLista = new ArrayList<>();

        for (Evento evento : lista) 
        {
            if(evento.getFree().equals("1"))
            {
                nuevaLista.add(evento);
            }
        }

        if(nuevaLista.size()>0)
        {
            return nuevaLista;
        }
        else 
        {
            return null;
        }
    }


    /**
     * Se le pasa una lista de eventos y un Codigo Postal y devuelve la lista de eventos
     * de ese codigo postal indicado
     * @param lista
     * @param cp
     * @return
     */
    public static ArrayList<Evento> extraeListaEventosPorCP(ArrayList<Evento> lista, String cp){

        ArrayList<Evento> nuevaLista = new ArrayList<>();

        for (Evento evento : lista) 
        {
            if(evento.getAddress().getArea().getPost_code().equals(cp))
            {
                nuevaLista.add(evento);
            }
        }

        if(nuevaLista.size()>0)
        {
            return nuevaLista;
        }
        else 
        {
            return null;
        }
    }


    /**
     * Se le pasa una lista de eventos y devuelve un diccionario con los códigos postales como
     * clave y el numero de eventos encontrados para ese codigo postal como valor
     * @param lista
     * @return
     */
    public static HashMap<String, Integer> diccionarioNumEventosPorCP(ArrayList<Evento> lista){

        HashMap<String, Integer> diccionario = new HashMap<>();

        for (Evento evento : lista) 
        {
            String cpBuscado = evento.getAddress().getArea().getPost_code();

            if(!diccionario.containsKey(cpBuscado))
            {
                int cantidad = extraeListaEventosPorCP(lista, cpBuscado).size();

                diccionario.put(cpBuscado, cantidad);
            }
        }

        if(diccionario.size()>0)
        {
            return diccionario;
        }
        else 
        {
            return null;
        }

    }
}
