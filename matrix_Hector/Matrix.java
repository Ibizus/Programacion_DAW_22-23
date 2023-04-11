package matrix_Hector;

import java.util.ArrayList;
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

    // Lo lleno con 23 Personas Genéricas:
    for (int i = 0; i < 23; i++)
    {
        añadePersona(listadoPersonas, matrix);
    }

    // Introduzco en posiciones aleatorias a Neo y un Smith:
    matrix.add((int)(Math.random()*matrix.size()), new Neo());
    matrix.add((int)(Math.random()*matrix.size()), new Smith());

    
    // Mostramos el contenido de Matrix:
    System.out.println("\t\t\tMATRIX:");
    estadoMatrix(matrix);


    // EMPIEZA LA PARTIDA:
    int index = 0;
    
    while(index < 300 && listadoPersonas.size()>0) // mientras queden personas y no llegue a 300 iteraciones
    {
        // En cada iteracion evalúo la posibilidad de morir de una Persona:
        evaluaPersona(listadoPersonas, matrix);

        if((index%2)==0) // Smith entra en acción
        {
            // Primero hay que buscar los Smith: (solo los creados antes de esta iteracion)
            for (Personaje personaje : matrix)
            {
                if(personaje.getClass().equals(Smith.class)) // Encuentro un Smith
                {
                    Smith virus = (Smith)personaje;

                    if(virus.getIteracionDeCreaccion() < index) // Compruebo que es anterior a la iteraccion actual
                    {
                        // Guardo su posición y su poder de infección:
                        int infeccion = virus.getInfeccion();
                        int posicion = matrix.indexOf(virus);

                        // Bucle para las posiciones siguientes a la del Smith
                        for (int i = posicion; i <= posicion+infeccion && i < matrix.size(); i++)
                        {
                            if(matrix.get(i).getClass().equals(PersonaGenerica.class))
                            {
                                Smith nuevoSmith = (Smith)matrix.get(i);

                                nuevoSmith.setIteracionDeCreaccion(index);

                                int prueba = nuevoSmith.getInfeccion();
                                System.out.println("prueba: "+ prueba);
                            }
                        }

                        // Bucle para las posiciones anteriores a la del Smith
                        for (int i = posicion; i >= posicion-infeccion && i > 0; i--)
                        {
                            if(matrix.get(i).getClass().equals(PersonaGenerica.class))
                            {
                                
                            }
                        }
                    }
                }    
            }




        }

        if((index%5)==0) // Turno de NEO
        {

        }

        if((index%10)==0) // Aparecen 5 personajes nuevos en Matrix
        {

        }

        if((index%30)==0) // Se genera un nuevo personaje en la Lista de Personas Genéricas
        {

        }

    }



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
    public static void evaluaPersona(ArrayList<Personaje> lista, ArrayList<Personaje> matrix)
    {
        int posicionAleatoria = (int)(Math.random()*matrix.size());

        Personaje persona = matrix.get(posicionAleatoria);

        if(persona.getClass().equals(PersonaGenerica.class))
        {
            if(((PersonaGenerica)persona).getProbabilidadMuerte() < 30) // Si es menor de 30 muere
            {
                // Lo machaco con un Personaje de la lista:
                sustituyePersona(persona, lista, matrix);
                // NO LO USO AQUI // intercambiaPersona(persona, lista, matrix); 
            }
            else // En otro caso le resto 10
            {
                ((PersonaGenerica)persona).setProbabilidadMuerte(((PersonaGenerica)persona).getProbabilidadMuerte()-10);
            }
        }
        else
        {
            // si no es persona es que es Neo o Smith y tengo que buscar a otra persona
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
     * 
     * @param persona
     * @param lista
     * @param matrix
     */
    public static void intercambiaPersona(Personaje persona, ArrayList<Personaje> lista, ArrayList<Personaje> matrix)
    {
        // casteo y guardo la perosna a sustituir:
        PersonaGenerica intercambiado = (PersonaGenerica) persona;

        // Localizo su posición en el arrayList:
        int posicionCambiada = matrix.indexOf(persona);

        // Saco al primero de la lista:
        PersonaGenerica nuevo = (PersonaGenerica) lista.get(0);

        // Lo elimino de lista:
        lista.remove(0);

        // Machaco la posición de Matrix con el nuevo Personaje:
        matrix.set(posicionCambiada, nuevo);

        // Anado el sustituído a la lista de reserva:
        lista.add(intercambiado);
    }
}
