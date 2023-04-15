package matrix_Hector;

import java.util.ArrayList;
import java.util.Collections;
import matrix_Hector.personajes.*;

public class Matrix {

    // CONSTANTES DE ESTILO:
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_WHITE_BG = "\u001B[47m";
    static final String ANSI_GREEN_BG = "\u001B[42m"; 
    static final String ANSI_RED_BG = "\u001B[41m";
    static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        
    // Creamos una colección de 200 personas genéricas:
    ArrayList<Personaje> listadoPersonas = new ArrayList<>();

    // La rellenamos:
    listadoPersonas = factoriaDePersonas(200);
    System.out.println(ANSI_YELLOW + "LA RESERVA DE PERSONAS GENÉRICAS ESTÁ LISTA:" + ANSI_RESET);
    System.out.println(listadoPersonas);

    // Inicializamos el mundo de MATRIX:
    ArrayList<Personaje> matrix = new ArrayList<>();

    // Inicializo el cementerio de Smiths:
    ArrayList<Smith> cementerio = new ArrayList<>();

    // Lo lleno con 23 Personas Genéricas:
    for (int i = 0; i < 23; i++)
    {
        añadePersona(listadoPersonas, matrix);
    }

    // Introduzco en posiciones aleatorias a Neo y un Smith:
    Neo neo = new Neo();
    matrix.add((int)(Math.random()*matrix.size()), neo);
    matrix.add((int)(Math.random()*matrix.size()), new Smith());

    // Mostramos el contenido de Matrix:
    System.out.println(mensajeBienvenida());
    System.out.println(mensajeMatrix());
    System.out.println("\t\t\tMUNDO MATRIX ESTÁ LISTO:");
    estadoMatrix(matrix);

    // EMPIEZA LA PARTIDA:
    boolean hayPersonasSanas = true;
    int index = 1;
    
    while(index < 301 && hayPersonasSanas) // mientras queden personas y no llegue a 300 iteraciones
    {
        System.out.println(ANSI_YELLOW + "Iteración: " + index + ":" + ANSI_RESET);

        // En cada iteracion evalúo la posibilidad de morir de cada Persona:
        evaluaPersonas(listadoPersonas, matrix);

        /****** LOS SMITH ENTRAN EN ACCION ******/
        if((index%2)==0)
        {
            System.out.println(ANSI_RED_BG + "Los Smith están causando estragos" + ANSI_RESET);

            // Primero hay que buscar los Smith: (solo los creados antes de esta iteracion)
            for (Personaje personaje : matrix)
            {
                if(personaje != null && personaje.getClass().equals(Smith.class)) // Encuentro un Smith
                {
                    // Casteo el Personaje smith encontrado a Smith
                    Smith virus = (Smith)personaje;

                    // Compruebo que es anterior a la iteraccion actual para que pueda infectar
                    if(virus.getIteracionDeCreaccion() < index) 
                    {
                        infectaPersonas(virus, matrix, index);
                    }
                } 
            }
        }// Fin Smith   


        /****** TURNO DE NEO ******/
        if((index%5)==0)
        {
            // random para ver si NEO se lo cree o no:
            int neoCree = (int)(Math.random()*2);

            if(neoCree == 0)
            {
                neo.setElegido(false);
                System.out.println(ANSI_WHITE_BG + "Neo está de capa caída hoy, como mustio, parace que no saldrá a cazar" + ANSI_RESET);
            }
            else 
            {
                neo.setElegido(true);
            }

            if(neo.isElegido())
            {
                System.out.println(ANSI_GREEN_BG + "¡¡NEO ENTRA EN ACCIÓN!!" + ANSI_RESET);

                // Genera capacidad de destrucción:
                int destruccion = (int)(Math.random()*neo.getPoder())+1;

                destruyeVirus(matrix, index, destruccion, cementerio);

                // Neo se cambia de posición;
                neoCambiaPosicion(neo, matrix, cementerio);

                // Ordeno el cementerio:
                Collections.sort(cementerio);

                // Mostramos el contenido de Matrix:
                System.out.println(ANSI_YELLOW + "\t\t\tMATRIX:" + ANSI_RESET);
                estadoMatrix(matrix);
            }
        }// Fin NEO



        /****** APARECEN 5 PERSONAJES NUEVOS EN MATRIX ******/
        if((index%10)==0)
        {
            // Array de posiciones de nulos:
            ArrayList<Integer> posicionesVacias = new ArrayList<>();

            // Busco espacios libres (NULOS)
            for (Personaje personaje : matrix)
            {
                // Guardo las posiciones
                if(personaje == null)
                {
                    posicionesVacias.add(matrix.indexOf(personaje));
                }    
            }

            // Bucle para sustituir 5 de esas posiciones:
            int sustituidos = 0;
            while (posicionesVacias.size()>0 && sustituidos<5)
            {
                // selecciona posicion aleatoria:
                int aleatoria = (int)(Math.random()*posicionesVacias.size());

                // Sustituye null por persona nueva de la lista:
                sustituyeNull(listadoPersonas, matrix, posicionesVacias.get(aleatoria));

                // Borro la posicion usada de posicionesVacias para no volver a seleccionarla:
                posicionesVacias.remove(aleatoria);

                sustituidos++;
            }
        } // Fin 10 iteraciones


        /****** NUEVA PERSONA EN LA LISTA DE PERSONAS GENERICAS ******/
        if((index%30)==0)
        {
            // Creo nueva PersonaGenérica y lo añado a la lista de Personas
            listadoPersonas.add(new PersonaGenerica());
        }// Fin 30 iteraciones


        //Actualizo condiciones Bucle:
        hayPersonasSanas = quedanPersonas(matrix);
        index++;
    }// Fin bucle PARTIDA


    System.out.println(mensajeGameOver());

    // Mostramos el listado de Virus muertos:
    Collections.sort(cementerio);
    System.out.println(ANSI_YELLOW + "\t\t\tCEMENTERIO:" + ANSI_RESET);
    System.out.println(cementerio);

    // Mostramos el contenido de Matrix:
    System.out.println(ANSI_YELLOW + "\t\t\tMATRIX:" + ANSI_RESET);
    estadoMatrix(matrix);

    }


    // METODOS:
    
    /**
     * 
     * @param cantidad
     * @return
     */
    public static ArrayList<Personaje> factoriaDePersonas(int cantidad)
    {
        ArrayList<Personaje> nuevaColeccion = new ArrayList<>();

        for (int i = 0; i < cantidad; i++)
        {
            nuevaColeccion.add(new PersonaGenerica());    
        }

        return nuevaColeccion;
    }

    /**
     * 
     * @param lista
     */
    public static void estadoMatrix(ArrayList<Personaje> lista)
    {
        String resultado = "";
        String letra = "";

        for (Personaje personaje : lista)
        {
            if(personaje == null)
            {
                letra = " ";
            }
            else if(personaje.getClass().equals(PersonaGenerica.class))
            {
                letra = ANSI_PURPLE + "P" + ANSI_RESET;
            }
            else if (personaje.getClass().equals(Neo.class))
            {
                letra = ANSI_GREEN_BG + "N" + ANSI_RESET;
            }
            else if(personaje.getClass().equals(Smith.class))
            {
                letra = ANSI_RED_BG + "S" + ANSI_RESET;
            }

            resultado+= "[" + letra + "]";
        }
        System.out.println(resultado);
    }


    /**
     * Añade una Persona a la lista de destino (matrix), borrándola 
     * de la lista de origen (factoria) o informa en caso de
     * que ya no queden personas disponibles en origen.
     * @param origen
     * @param destino
     */
    public static void añadePersona(ArrayList<Personaje> origen, ArrayList<Personaje> destino)
    {
        if(origen.size()>0)
        {
            Personaje nuevo = origen.get(0);
            origen.remove(0);
            destino.add(nuevo);
        }
        else
        {
            System.out.println("No quedan personas en la lista de reserva");
        }
    }

    /**
     * Sustituye en la lista de destino (matrix) un Null por una persona 
     * de la lista de origen (factoriaPersonas), borrándola de origen o 
     * informa en caso de que ya no queden personas disponibles en origen.
     * @param origen
     * @param destino
     * @param posicion
     */
    public static void sustituyeNull(ArrayList<Personaje> origen, ArrayList<Personaje> destino, int posicion)
    {
        if(origen.size()>0)
        {
            Personaje nuevo = origen.get(0);
            origen.remove(0);
            destino.set(posicion, nuevo);
        }
        else
        {
            System.out.println("No quedan más personas para sustituir Nulls");
        }
    }


    /**
     * Evalua la probabilidad de morir de una persona para sustituirla por otra
     * o reducirle su probabilidad de muerte
     * @param origen
     * @param destino
     */
    public static void evaluaPersonas(ArrayList<Personaje> lista, ArrayList<Personaje> matrix)
    {
        // Evalúo cada Personaje:
        for (Personaje persona : matrix)
        {
            // Actuamos en el caso de que sea PersonaGenerica:
            if(persona != null && persona.getClass().equals(PersonaGenerica.class))
            {
                // Si es menor de 30 muere:
                if(((PersonaGenerica)persona).getProbabilidadMuerte() < 30) 
                {
                    // Lo machaco con un Personaje de la lista:
                    sustituyePersona(persona, lista, matrix);
                }
                else // En otro caso le resto 10
                {
                    ((PersonaGenerica)persona).setProbabilidadMuerte(((PersonaGenerica)persona).getProbabilidadMuerte()-10);
                }
            }
        }
    }

    /**
     * 
     * @param persona
     * @param lista
     * @param matrix
     */
    public static void sustituyePersona(Personaje persona, ArrayList<Personaje> lista, ArrayList<Personaje> matrix)
    {
        if(lista.size()>0) // Valido que me sigan quedando personas en la lista:
        {
            // Localizo su posición en el arrayList:
            int posicionCambiada = matrix.indexOf(persona);

            // Saco al primero de la lista:
            PersonaGenerica nuevo = (PersonaGenerica)lista.get(0);

            // Lo elimino de lista:
            lista.remove(0);

            // Muestro la persona que muere:
            System.out.println(ANSI_PURPLE + "Muere el ciudadano" + ANSI_RESET + " " + persona + " y será sutituído:");

            // Machaco la posición de Matrix con el nuevo Personaje:
            matrix.set(posicionCambiada, nuevo);
        }

    }

    /**
     * Utiliza el poder de infección del Smith encontrado para infectar a las personas
     * que están a su alrededor en Matrix y machaca la persona infectada por el Smith
     * @param virus
     * @param matrix
     * @param index
     * @return Smith
     */
    public static void infectaPersonas(Smith virus, ArrayList<Personaje> matrix, int index)
    {
        // Guardo su posición y su poder de infección:
        int infeccion = virus.getInfeccion();
        int posicionInicialDeInfeccion = matrix.indexOf(virus)-infeccion;
        int posicionFinalDeInfeccion = matrix.indexOf(virus)+infeccion;

        // Desde posición inicial a final
        while (posicionInicialDeInfeccion <= posicionFinalDeInfeccion)
        {
            // Mientras que el inicio y el final no se salgan del rango de Matrix:
            if (posicionInicialDeInfeccion>=0 && posicionFinalDeInfeccion<matrix.size())
            {
                if(matrix.get(posicionInicialDeInfeccion) != null && matrix.get(posicionInicialDeInfeccion).getClass().equals(PersonaGenerica.class))
                {
                    // Saco la persona infectada para usar sus datos:
                    Personaje infectada = matrix.get(posicionInicialDeInfeccion);
                    System.out.println(ANSI_PURPLE + "Persona infectada:" + ANSI_RESET + " " + infectada);

                    // Creo un nuevo Smith con los datos de la persona infectada:
                    Smith nuevoSmith = new Smith(infectada.getId(), infectada.getCreacion(), infectada.getCiudad(), index);

                    // Le paso la infección del otro Smith:
                    nuevoSmith.setInfeccion(infeccion);

                    matrix.set(posicionInicialDeInfeccion, nuevoSmith);
                }
            }
            posicionInicialDeInfeccion++;
        }
    }

    /**
     * Utiliza el poder de destrucción de Neo para destruir los Smith
     * que están a su alrededor en Matrix y pone un null en su lugar
     * @param virus
     * @param matrix
     * @param index
     */
    public static void destruyeVirus(ArrayList<Personaje> matrix, int index, int destruccion, ArrayList<Smith> cementerio)
    {
        // Guardo las posiciones entre las que me voy a mover:
        int posicionInicialDestruccion = index-destruccion;
        int posicionFinalDestruccion = index+destruccion;

        // Desde posición inicial a final
        while (posicionInicialDestruccion <= posicionFinalDestruccion)
        {
            // Mientras que el inicio y el final no se salgan del rango de Matrix:
            if (posicionInicialDestruccion>=0 && posicionFinalDestruccion<=matrix.size())
            {
                if(matrix.get(posicionInicialDestruccion)!= null && matrix.get(posicionInicialDestruccion).getClass().equals(Smith.class))
                {
                    // Mando al Smith al cementeriio
                    cementerio.add((Smith)matrix.get(posicionInicialDestruccion));

                    System.out.println(ANSI_RED_BG + "Virus aniquilado" + ANSI_RESET + " " + ((Smith)matrix.get(posicionInicialDestruccion)).mostrarInformacion());

                    // Pongo un NULL en su lugar
                    matrix.set(posicionInicialDestruccion, null);
                }
            }
            posicionInicialDestruccion++;
        }
    }


    /**
     * Neo se mueve a una posición aleatoria de Matrix y se intercambia por una persona
     * o mata a un Smith según lo que haya en esa posición
     * @param neo
     * @param matrix
     * @param cementerio
     */
    public static void neoCambiaPosicion(Neo neo, ArrayList<Personaje> matrix, ArrayList<Smith> cementerio)
    {
        // Posicion inicial de NEO:
        int posicionInicial = matrix.indexOf(neo);

        // Genero la posición aleatoria:
        int posicion = (int)(Math.random()*matrix.size());

        // Compruebo lo que hay en esa posición y actuo:
        if(matrix.get(posicion) == null || matrix.get(posicion).getClass().equals(PersonaGenerica.class))
        {
            Collections.swap(matrix, posicionInicial, posicion);
        }
        else if(matrix.get(posicion).getClass().equals(Smith.class))
        {
            // En ese caso manda al Smith al cementerio
            cementerio.add((Smith)matrix.get(posicion));

            // Lo machaco con NEO:
            matrix.set(posicion, neo);

            // Pongo NULL en su lugar original
            matrix.set(posicionInicial, null);
        }
    }

    public static boolean quedanPersonas(ArrayList<Personaje> matrix)
    {
        boolean quedanPersonas = false;

        for (Personaje persona : matrix)
        {
            if(persona != null && persona.getClass().equals(PersonaGenerica.class))
            {
                quedanPersonas = true;
            }
        }
        return quedanPersonas;
    }



    // MÉTODOS DE ESTILO: (DEVUELVEN MENSAJES UTILIZADOS EN EL PROGRAMA)
    public static String mensajeBienvenida()
    {
        return ANSI_PURPLE +   
        "######   ###  #######  #     #  #     #  #######  #     #  ###  ######   #######         #   \n" + 
        "#     #   #   #        ##    #  #     #  #        ##    #   #   #     #  #     #        # #  \n" + 
        "#     #   #   #        # #   #  #     #  #        # #   #   #   #     #  #     #       #   # \n" + 
        "######    #   #####    #  #  #  #     #  #####    #  #  #   #   #     #  #     #      #     #\n" + 
        "#     #   #   #        #   # #   #   #   #        #   # #   #   #     #  #     #      #######\n" + 
        "#     #   #   #        #    ##    # #    #        #    ##   #   #     #  #     #      #     #\n" + 
        "######   ###  #######  #     #     #     #######  #     #  ###  ######   #######      #     #\n" + ANSI_RESET;
    }

    public static String mensajeMatrix()
    {
        return ANSI_GREEN +
        "\t::::    ::::      :::     ::::::::::: :::::::::  ::::::::::: :::    :::\n" +
        "\t+:+:+: :+:+:+   :+: :+:       :+:     :+:    :+:     :+:     :+:    :+:\n" +
        "\t+:+ +:+:+ +:+  +:+   +:+      +:+     +:+    +:+     +:+      +:+  +:+\n" +
        "\t+#+  +:+  +#+ +#++:++#++:     +#+     +#++:++#:      +#+       +#++:+\n" +
        "\t+#+       +#+ +#+     +#+     +#+     +#+    +#+     +#+      +#+  +#+\n" + 
        "\t#+#       #+# #+#     #+#     #+#     #+#    #+#     #+#     #+#    #+#\n" +
        "\t###       ### ###     ###     ###     ###    ### ########### ###    ###\n" +
        ANSI_RESET;
    }

    public static String mensajeGameOver()
    {
        return ANSI_RED +
        "\t #####     #    #     # #######      ####### #     # ####### ###### \n" + 
        "\t#     #   # #   ##   ## #            #     # #     # #       #     #\n" + 
        "\t#        #   #  # # # # #            #     # #     # #       #     #\n" + 
        "\t#  #### #     # #  #  # #####        #     # #     # #####   ###### \n" + 
        "\t#     # ####### #     # #            #     #  #   #  #       #   #  \n" + 
        "\t#     # #     # #     # #            #     #   # #   #       #    # \n" + 
        "\t #####  #     # #     # #######      #######    #    ####### #     #\n" + 
        ANSI_RESET;
    }
}
