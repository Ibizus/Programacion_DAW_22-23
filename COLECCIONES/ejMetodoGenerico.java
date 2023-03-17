package COLECCIONES;

public class ejMetodoGenerico {
    
    public static void main(String[] args) {
        







    }

    // METODOS:

    static <U> int numeroDeNulos (U[] tabla)
    {
        int cont = 0;

        for (U e : tabla)
        {
            if (e == null)  
            {
                cont++;
            }  
        }
        return cont;
    }

    static <T> T[] insrteObjeto(T[] tabla, T objeto)
    {

        return tabla;
    }

}
