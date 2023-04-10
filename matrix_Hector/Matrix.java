package matrix_Hector;

import java.util.ArrayList;
import java.util.Collection;

public class Matrix {
    public static void main(String[] args) {
        

    // Inicializamos el mundo de MATRIX:
    ArrayList<Personaje> matrix = new ArrayList<>(25);


    // Introduzco en posiciones aleatorias a Neo y un Smith:
    matrix.add((int)(Math.random()*matrix.size()), new Neo());
    matrix.add((int)(Math.random()*matrix.size()), new Smith());

    // Rellenamos el resto de posiciones con Personas genéricas de la lista:
    

    
    // Mostramos el contenido de Matrix:
    System.out.println("MATRIX:");
    estadoMatrix(matrix);


    }


    // METODOS:
    
    public static Collection<Personaje> factoriaDePersonas(int cantidad)
    {
        Collection<Personaje> nuevaColeccion = new ArrayList<>();

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
            else if()
            {
                letra = " ";
            }

            resultado+= "[" + letra + "]";
        }

        System.out.println(resultado);
    }

}
