package utils;

import java.util.ArrayList;

import models.Actor;
import models.ListaActores;
import models.ListaPeliculas;
import models.Pelicula;


public class Menu {

    // CONSTANTES DE ESTILO:
    final static String ANSI_GREEN_BG = "\u001B[42m";
    final static String ANSI_RESET = "\u001B[0m";
    
    // SCANNER ESTÁTICO:
    static LecturaTeclado lc = new LecturaTeclado();


    /**
     * Función que contiene el menú principal del programa y hace las llamadas
     * al resto de funciones del menú
     */
    static public void ejecutarMenu()
    {
        // VARIABLES:
        boolean salir = false;
        int opcion = 0;
        
        // BUCLE MENU
        while (!salir)
        {
            
            imprimirMenuPrincipal();
            opcion = lc.leerInteger();
    
            switch (opcion)
            {
                case 1:
                    System.out.println("Introduce el título de la película...");
                    String tituloBuscado = lc.leerCadena();
                    ListaPeliculas resultado = usoApi.leerPeliculasFromTMDB(tituloBuscado);
                    
                    ArrayList resul = resultado.getListaPeliculas();
                    imprimeListaResultados(resul);

                    submenuInformacionDetallada(resul);
                    break;
    
                case 2:
                    System.out.println("Introduce el nombre por el que quieres buscar...");
                    String nombreBuscado = lc.leerCadena();
                    ListaActores resultado2 = usoApi.leerActoresFromTMDB(nombreBuscado);
                    
                    ArrayList result = resultado2.getListaActores();
                    imprimeListaResultados(result);

                    submenuInformacionDetallada(result);
                    break;
    
                case 3:
                    salir = true;
                    System.out.println("Hasta pronto");
                    break;
                
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }



    /**
     * Función que muestra el menú que permite elegir una posición del array
     * mostrado para acceder a ese objeto y mostrar su información completa
     * @param array
     */
    private static void submenuInformacionDetallada(ArrayList array)
    {
        // VARIABLES:
        boolean salir = false;

        // BUCLE MENU
        while (!salir)
        {
            if(array.isEmpty()) // compruebo que no se ha pasado un array vacío para inciar el sub-menú
            {
                salir=true;
            }
            else 
            {
                System.out.println("\nIntroduce un número para ver la información completa ó pulsa 0 para volver al menú principal");
                Integer numero = lc.leerInteger();
        
                if(numero > 0 && numero <= array.size())
                {
                    var t = array.get(numero-1);
        
                    muestraPelicula_o_Actor(t, true);
                    salir=true;
                }
                else if(numero == 0)
                {
                    salir=true;
                }
                else 
                {
                    System.out.println("El valor introducido no corresponde con niguna opción mostrada");
                }
            }
        }
    }




    /**
     * Función a la que se la pasa un arraylist (raw) e imprime sus 10 primeras 
     * posiciones ó las que tenga si el tamaño es menor
     * @param result
     */
    private static void imprimeListaResultados(ArrayList result)
    {
        if(result.size() < 1)
        {
            System.out.println("No se han obtenido resultados para esta búsqueda");
        }
        else if(result.size() > 10)
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.print((i+1) + " -> "); 
                
                var t = result.get(i);
                
                muestraPelicula_o_Actor(t, false);
            }
        }
        else 
        {
            for (var t : result) 
            {
                System.out.print(result.indexOf(t)+1 + " -> ");

                muestraPelicula_o_Actor(t, false);
            }
        }
    }



    /**
     * Función a la que se le pasa un objeto y comprueba si es de clase pelicula o Actor,
     * lo castea e imprime sólo su nombre si se le pasa false como parámetro, o toda
     * su información completa en caso de pasarle true.
     * @param t
     * @param completo
     */
    private static void muestraPelicula_o_Actor(Object t, boolean completo)
    {
        if (t instanceof Pelicula)
        {
            Pelicula peli = (Pelicula)t;

            if(completo)
            {
                System.out.println(peli);
            }
            else 
            {
                System.out.println(peli.getTitulo());
            }
        }
        else 
        {
            Actor actor = (Actor)t;

            if(completo)
            {
                System.out.println(actor);
            }
            else 
            {
                System.out.println(actor.getNombre());
            }
        }
    }



    /**
     * Función que imprime el menú inicial
     */
    private static void imprimirMenuPrincipal()
    {
        System.out.println("\n"+ANSI_GREEN_BG + "BIENVENIDO A THE MOVIE DB" + ANSI_RESET+"\n");
    
        System.out.println("Elige la opción que quieres realizar:");
        System.out.println("\t1 -> Buscar Película");
        System.out.println("\t2 -> Buscar Actor/director");
        System.out.println("\t3 -> para SALIR");
    }


}
