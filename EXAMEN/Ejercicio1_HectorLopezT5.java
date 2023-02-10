package EXAMEN;

import java.util.Arrays;

public class Ejercicio1_HectorLopezT5 {
    public static void main(String[] args) {

        int[] array = {4, 6, 8, 4, 2, 3, 6, 9, 11, 6, 5, 9, 10, 13, 8, 3, 6, 5, 2, 1, 6, 6, 8, 4};




        System.out.println(Arrays.toString(array));

        array = modificaRepetido(array);

        System.out.println(Arrays.toString(array));



    }

    // FUNCIONES:

    /**
     * Busca y modifica los valores que se repiten
     * @param array
     * @return nuevo
     */
    static int[] modificaRepetido(int[] array)
    {
        // for (int i = 0; i < array.length; i++) // Este bucle me marca la posicion que voy a comparar con el resto del array
        // {



        //     for (int j = 0; j < array.length; j++) // Recorro todo el array buscando el valor de la posición i
        //     {
        //         if(array[i] == array[j])
        //         {
        //             int maximo = calculaMaximo(array);

        //             array[j] = maximo+1;
        //         }
        //     }
        // }

        int index = 0;

        int valorBuscado = array[index];

        int[] repetidos = buscaRepetidos(array, valorBuscado);

        while(repetidos.length > 1) // Si repetidos tiene más de un valor (hay repeticiones)
        {
            int maximo = calculaMaximo(array);

            for (int i = 0; i < repetidos.length-1; i++)
            {
                int posicionRepetida = repetidos[repetidos.length-1];

                array[posicionRepetida] = maximo+1;
            }
        }

        return array;


    }

    /**
     * Devuelve el valor maximo de un array
     * @param array
     * @return maximo
     */
    static int calculaMaximo(int[] array)
    {
        int maximo = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if(array[i]>maximo)
            {
                maximo = array[i];
            }
        }
        return maximo;
    }

    /**
     * Devuelve un array con las posiciones de los numeros repetidos
     * @param array
     * @return posiciones
     */
    static int[] buscaRepetidos(int[] array, int elemento)
    {
        int[] posicionesRepetidas = new int[0];

        for (int i = 0; i < array.length; i++)
        {
           if(array[i] == elemento)
           {
                posicionesRepetidas = insertarAlFinal(posicionesRepetidas, i);
           }
        }

        return posicionesRepetidas;
    }

    /**
     * Inserta un elemento al final del array
     * @param array,elemento
     * @return nuevo
     */
    static int[] insertarAlFinal(int[] array, int elemento)
    {
        int[] nuevo = new int[array.length+1];

        for (int i = 0; i < array.length; i++)
        {
            nuevo[i] = array[i];
        }

        nuevo[nuevo.length-1] = elemento;

        return nuevo;
    }

}
