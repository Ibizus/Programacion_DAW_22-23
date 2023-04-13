package matrix_Hector;

import java.util.ArrayList;
import java.util.Collections;

import matrix_Hector.personajes.*;

public class Matrix {
    public static void main(String[] args) {
        

    // Creamos una colección de 200 personas genéricas:
    ArrayList<Personaje> listadoPersonas = new ArrayList<>();

    // La rellenamos:
    listadoPersonas = factoriaDePersonas(200);
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
    System.out.println("\t\t\tMATRIX:");
    estadoMatrix(matrix);


    // EMPIEZA LA PARTIDA:
    int index = 1;
    
    while(index < 301 && listadoPersonas.size()>0) // mientras queden personas y no llegue a 300 iteraciones
    {
        // En cada iteracion evalúo la posibilidad de morir de cada Persona:
        evaluaPersonas(listadoPersonas, matrix);

        if((index%2)==0) // Smith entra en acción
        {
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
                        System.out.println("LOS SMITH ESTÁN INFECTANDO PERSONAS");
                    }
                } 
            }
        }// Fin aparición Smith   


        if((index%5)==0) // Turno de NEO
        {
            // random para ver si NEO se lo cree o no:
            int neoCree = (int)(Math.random()*2);

            if(neoCree == 0)
            {
                neo.setElegido(false);
            }
            else 
            {
                neo.setElegido(true);
            }

            if(neo.isElegido())
            {
                System.out.println("NEO ENTRA EN ACCIÓN");

                // Genera capacidad de destrucción:
                int destruccion = (int)(Math.random()*neo.getPoder())+1;

                destruyeVirus(matrix, index, destruccion, cementerio);

                // Neo se cambia de posición;
                neoCambiaPosicion(neo, matrix);

                // Ordeno el cementerio:
                Collections.sort(cementerio);

                // Mostramos el contenido de Matrix:
                System.out.println("\t\t\tMATRIX:");
                estadoMatrix(matrix);
            }
        }// Fin acción NEO


        if((index%10)==0) // Aparecen 5 personajes nuevos en Matrix
        {

        }

        if((index%30)==0) // Se genera un nuevo personaje en la Lista de Personas Genéricas
        {

        }

    }// Fin bucle PARTIDA


    // Mostramos el contenido de Matrix:
    System.out.println("\t\t\tMATRIX:");
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
                letra = "P";
            }
            else if (personaje.getClass().equals(Neo.class))
            {
                letra = "N";
            }
            else if(personaje.getClass().equals(Smith.class))
            {
                letra = "S";
            }

            resultado+= "[" + letra + "]";
        }

        System.out.println(resultado);
    }

    /**
     * 
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
            System.out.println("No quedan personas en la lista");
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
        // Localizo su posición en el arrayList:
        int posicionCambiada = matrix.indexOf(persona);

        // Saco al primero de la lista:
        PersonaGenerica nuevo = (PersonaGenerica) lista.get(0);

        // Lo elimino de lista:
        lista.remove(0);

        // Machaco la posición de Matrix con el nuevo Personaje:
        matrix.set(posicionCambiada, nuevo);
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
            if (posicionInicialDeInfeccion>=0 && posicionFinalDeInfeccion<=matrix.size())
            {
                if(matrix.get(posicionInicialDeInfeccion) != null && matrix.get(posicionInicialDeInfeccion).getClass().equals(PersonaGenerica.class))
                {
                    Smith nuevoSmith = (Smith)matrix.get(posicionInicialDeInfeccion);

                    nuevoSmith.setIteracionDeCreaccion(index);

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
     * @return Smith
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
}
