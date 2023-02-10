package EXAMEN;

public class Ejercicio3_HectorLopezT5 {

    // Tengo un fallo en el bucle que llama a la funcion que modifica Fila, 
    // he conseguido para el bucle infinito actualizando las dos condiciones de entrada del bucle While:

    // while(sumaArray != 24 && numCeros>0)
    // {
    //     completaFila(arrayBi[i]);

    //     numCeros = contarCeros(arrayBi[i]); // actualizo condiciones
    //     sumaArray = sumaFila(arrayBi[i]); 
    // }

    // Pero ahora no llega a 24 o se pasa, cuando en el otro caso siempre se clava en 24 para todas las filas,
    // pero no consigo que pare.

    // No me ha dado tiempo a Debugear más hasta encontrar el fallo.

    
    public static void main(String[] args) {
        
        int[][] matriz = new int[5][10];

        rellenarArrayBi(matriz);

        mostrarMatriz(matriz);
    
        rellenaHasta24(matriz);

        System.out.println("\nMATRIZ ACTUALIZADA:");
        mostrarMatriz(matriz);
    }

    /**
     * Llena el array con numeros aleatorios de 0 a 4 comprobando que no se pase de 24
     * @param arrayBi
     */
    static void rellenarArrayBi(int[][] arrayBi)
    {
        for (int i = 0; i < arrayBi.length; i++)
        {
            for (int j = 0; j < arrayBi[i].length; j++)
            {
                arrayBi[i][j] = (int)(Math.random()*5);
            }
        }
    }

    /**
     * Devuelve un array con las posiciones de los ceros encontrados
     * @param array
     * @return posiciones
     */
    static int contarCeros(int[] array)
    {
        int numCeros = 0;

        for (int i = 0; i < array.length; i++)
        {
           if(array[i] == 0)
           {
                numCeros++;
           }
        }

        return numCeros;
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

    /**
     * Modifica el array hasta que sume 24
     * @param array
     */
    static void completaFila(int[] array)
    {

        int numCeros = contarCeros(array);
        int sumaFila = sumaFila(array);

        if(numCeros <1)
        {
            System.out.println("Las filas sin ceros no se modifican");
        }
        else 
        {
            if(sumaFila<24) //caso de tener que sumar a los ceros
            {
                boolean encontrado = false;
                int i = 0;

                while(!encontrado)
                {
                    if(array[i] == 0)
                    {
                        if(((24 - sumaFila) / numCeros) > 4)
                        {
                            array[i] = 4;
                        }
                        else 
                        {
                            array[i] = (int)((24 - sumaFila) / numCeros);
                        }
                        encontrado = true;
                    }
                    i++;
                }
            }
            else if(sumaFila>24) // caso de tener que restar
            {
                boolean encontrado = false;
                int i = 0;

                while(!encontrado)
                {
                    if(array[i] == 0)
                    {
                        if(((sumaFila-24) / numCeros) > 4)
                        {
                            array[i] = -4;
                        }
                        else 
                        {
                            array[i] = (int)((sumaFila-24) / numCeros);
                        }
                        encontrado = true;
                    }
                    i++;
                }
            }
        }

    }


    /**
     * Cambia los valores de toda la matriz
     * @param arrayBi
     */
    static void rellenaHasta24(int[][] arrayBi)
    {
        for (int i = 0; i < arrayBi.length; i++) // Selecciona la fila a recorrer
        {

            int numCeros = contarCeros(arrayBi[i]);
            int sumaArray = sumaFila(arrayBi[i]);

            while(sumaArray != 24 && numCeros>0)
            {
                completaFila(arrayBi[i]);

                numCeros = contarCeros(arrayBi[i]); // actualizo condiciones
                sumaArray = sumaFila(arrayBi[i]); 
            }
        }
    }

    /**
     * Suma los valores de un array
     * @param array
     * @return sumaFila
     */
    static int sumaFila(int[] array)
    {
        int sumaFila = 0;

        for (int i = 0; i < array.length; i++)
        {
            sumaFila = sumaFila + array[i];
        }

        return sumaFila;
    }


    /**
     * Muestra la tabla segun el formato solicitado
     * @param arrayBid
     */
    static void mostrarMatriz(int[][] arrayBid)
    {

        // arrayBid.length es igual al numero de filas
        // Bucle que recorre cada una de las filas
        for (int i = 0; i < arrayBid.length; i++)
        {
            int sumaFila = 0 ;

            System.out.print("Fila " + (i+1) + ":\t");
            // por cada fila recorro sus columnas
            for (int j = 0; j < arrayBid[i].length; j++)
            {
                System.out.print(arrayBid[i][j] + "\t");

                sumaFila = sumaFila + arrayBid[i][j];
            }
            System.out.println("| == " + sumaFila);

        }

        // Bucle que imprime el sumatorio de las columnas:
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("\t");
        for (int j = 0; j < arrayBid[0].length; j++)
        {
            int sumaColumna = 0;
            for (int i = 0; i < arrayBid.length; i++)
            {
                sumaColumna = sumaColumna + arrayBid[i][j];
            }
            System.out.print(sumaColumna + "\t");
        }
        System.out.println("");
    }
}
