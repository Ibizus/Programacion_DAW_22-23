package utils;

import models.Actor;
import models.ListaActores;
import models.ListaPeliculas;
import models.Pelicula;

public class Menu {
    
    final static String ANSI_GREEN_BG = "\u001B[42m";
    final static String ANSI_RESET = "\u001B[0m";

    static public void ejecutarMenu()
    {
        // VARIABLES:
        boolean salir = false;
        int opcion = 0;
        LecturaTeclado lc = new LecturaTeclado();
        

        // BUCLE MENU
        while (!salir)
        {
            imprimir();
            opcion = lc.leerInteger();
    
            switch (opcion)
            {
                case 1:
                    System.out.println("Introduce el título de la película...");
                    String tituloBuscado = lc.leerCadena();
                    ListaPeliculas resultado = usoApi.leerPeliculasFromTMDB(tituloBuscado);
                    
                    if(resultado.getListaPeliculas().size() < 1)
                    {
                        System.out.println("No se han obtenido resultados para esta búsqueda");
                    }
                    else if(resultado.getListaPeliculas().size() > 10)
                    {
                        for (int i = 0; i < 10; i++)
                        {
                            System.out.println((i+1) + " -> " + resultado.getListaPeliculas().get(i).getTitulo());    
                        }
                    }
                    else 
                    {
                        for (Pelicula peli : resultado.getListaPeliculas())
                        {
                            System.out.println(resultado.getListaPeliculas().indexOf(peli)+1 + " -> " + peli.getTitulo());
                        }
                    }

                    break;
    
                case 2:
                    System.out.println("Introduce el nombre por el que quieres buscar...");
                    String nombreBuscado = lc.leerCadena();
                    ListaActores resultado2 = usoApi.leerActoresFromTMDB(nombreBuscado);
                    

                    if(resultado2.getListaActores().size() < 1)
                    {
                        System.out.println("No se han obtenido resultados para esta búsqueda");
                    }
                    else if(resultado2.getListaActores().size() > 10)
                    {
                        for (int i = 0; i < 10; i++)
                        {
                            System.out.println((i+1) + " -> " + resultado2.getListaActores().get(i).getNombre());    
                        }
                    }
                    else 
                    {
                        for (Actor persona : resultado2.getListaActores())
                        {
                            System.out.println(resultado2.getListaActores().indexOf(persona)+1 + " -> " + persona.getNombre());
                        }
                    }

                    break;
    
                case 3:
                
                default:
                    salir = true;
                    System.out.println("Hasta pronto");
            }
        }
        lc.finalizarlectura();
    }





    private static void imprimir()
    {
        System.out.println("\n"+ANSI_GREEN_BG + "BIENVENIDO A THE MOVIE DB" + ANSI_RESET+"\n");
    
        System.out.println("Elige la opción que quieres realizar:");
        System.out.println("\t1 -> Buscar Película");
        System.out.println("\t2 -> Buscar Actor/director");
        System.out.println("\t3 -> para SALIR");
    }




}
