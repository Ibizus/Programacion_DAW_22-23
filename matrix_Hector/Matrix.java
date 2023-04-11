package matrix_Hector;

import java.util.ArrayList;


public class Matrix {
    public static void main(String[] args) {
        

    // Creamos una colección de 200 personas genéricas:
    ArrayList<Personaje> listadoPersonas = new ArrayList<>();

    // La rellenamos:
    listadoPersonas = factoriaDePersonas(200);
    System.out.println(listadoPersonas);


    // Inicializamos el mundo de MATRIX:
    ArrayList<Personaje> matrix = new ArrayList<>(25);

    // Compruebo tamaño arrayList
    int tamaño = matrix.size();
    System.out.println(tamaño);

    // Introduzco en posiciones aleatorias a Neo y un Smith:
    matrix.add((int)(Math.random()*matrix.size()), new Neo());
    matrix.add((int)(Math.random()*matrix.size()), new Smith());

    
    // Compruebo tamaño arrayList    
    int tamaño2 = matrix.size();
    System.out.println(tamaño2);
    
    // Rellenamos el resto de posiciones con Personas genéricas de la lista:

    
    // Mostramos el contenido de Matrix:
    System.out.println("MATRIX:");
    estadoMatrix(matrix);


    }


    // METODOS:
    
    public static ArrayList<Personaje> factoriaDePersonas(int cantidad)
    {
        ArrayList<Personaje> nuevaColeccion = new ArrayList<>();

        for (int i = 0; i < cantidad; i++)
        {
            nuevaColeccion.add(new PersonaGenerica());    
        }

        return nuevaColeccion;
    }


    public static void estadoMatrix(ArrayList<Personaje> lista)
    {
        String resultado = "";
        String letra = "";

        for (Personaje personaje : lista)
        {
            if(personaje.getClass().equals(PersonaGenerica.class))
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
            else
            {
                letra = " ";
            }

            resultado+= "[" + letra + "]";
        }

        System.out.println(resultado);
    }

}
