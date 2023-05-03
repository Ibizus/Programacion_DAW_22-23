import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("HELLO, MÁLAGA!\nLISTADO DE POBLACION CENSADA POR MUNICIPIO");

        /*
        *   Realiza los pasos necesarios para sacar la siguiente información:
        *   
        *   Ordenar los municipios por nombre y año (ascendente ambos)
        *   Información de Mijas en 2022
        *   Incremento de la población de Fuengirola del año 2016 al 2022
        *   Incremento de la población de Mijas del año 2016 al 2022
        *   Municipio menos poblado en 2021
        *   
        *   Vuelca toda esta información en un ficheros de texto llamado: salida.txt
        */

        ArrayList<Municipio> listaMunicipios = LeerInformacion.leerFicheroMunicipio(null);


        // Ordenar los municipios por nombre y año (ascendente ambos)
        Collections.sort(listaMunicipios);
        System.out.println(listaMunicipios);


        // Información de Mijas en 2022
        Municipio mijas22 = LeerInformacion.buscarMunicipio(listaMunicipios, "Mijas", 2022);
        System.out.println("\n" + mijas22);


        // Incremento de la población de Fuengirola del año 2016 al 2022
        HashMap<String, Integer> incrementos_16_22 = LeerInformacion.incrementoPoblacion(listaMunicipios, 2016, 2022);

        int incrementoFuengi16_22 = buscaIncremento(incrementos_16_22, "Fuengirola");
        System.out.println("El incremento de la población de Fuengirola del 2016 al 2022 es de: " + incrementoFuengi16_22 + " habitantes");


        // Incremento de la población de Mijas del año 2016 al 2022
        int incrementoMijas16_22 = buscaIncremento(incrementos_16_22, "Mijas");
        System.out.println("\nEl incremento de la población de Mijas del 2016 al 2022 es de: " + incrementoMijas16_22 + " habitantes");


        // Municipio menos poblado en 2021
        ArrayList<Municipio> listaMunicipios_21 = LeerInformacion.leerFicheroMunicipio(2021);

        Collections.sort(listaMunicipios_21, new Comparator<Municipio>() {

            @Override
            public int compare(Municipio arg0, Municipio arg1) {
                return arg0.getPoblacion()-arg1.getPoblacion();
            }
        });

        System.out.println("\nMunicipio menos poblado en 2021 -> " + listaMunicipios_21.get(0));
    }







    // METODOS:
    private static int buscaIncremento(HashMap<String, Integer> mapaIncrementos, String nombreCiudad)
    {
        ArrayList<String> claves = new ArrayList<>();
        claves.addAll(mapaIncrementos.keySet());

        int incremento = 0;
        for (String ciudad : claves)
        {
            if(ciudad.equals(nombreCiudad))
            {
                incremento = mapaIncrementos.get(ciudad);
            }
        }
        return incremento;
    }

}
