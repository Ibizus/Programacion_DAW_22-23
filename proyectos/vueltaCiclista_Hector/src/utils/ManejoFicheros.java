package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Ciclista;
import models.Equipo;

public class ManejoFicheros {
    
    public static ArrayList<Equipo> leerFicheroEquipos(String nombreArchivo)
    {
        String nombreFichero = nombreArchivo;
        String path = "src/resources/";
        
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path+nombreFichero)))
        {
            String linea = br.readLine();
            // saltamos primera linea:
            linea = br.readLine();
            
            while(linea!=null)
            {
                try
                {
                    String[] trozosLinea = linea.split(",");

                    listaEquipos.add(new Equipo(trozosLinea[0], trozosLinea[1], trozosLinea[2], Integer.valueOf(trozosLinea[3]))); 
                } 
                catch (Exception ex) 
                {
                    // System.out.println(ex.getMessage());
                }

                //actualiza concidion bucle:
                linea = br.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("No se ha podido leer el fichero");
            System.out.println(e.getMessage());
        }

        return listaEquipos;
    }

	public static ArrayList<Ciclista> leeListaCiclistasFromJson(String relativePathFile)
	{
		File fileCiclistas = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		ArrayList<Ciclista> listaCiclistas = null;

		try {
            listaCiclistas = objectMapper.readValue(fileCiclistas, new TypeReference<ArrayList<Ciclista>>(){});
        } 
        catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaCiclistas;
	}

    public static void borraFichero(String path) throws Exception
    {
        try
        {
            File fichero = new File(path);

            if(fichero.exists())
            {
                fichero.delete();
            }
        }
        catch (Exception e)
        {

        }
    }

}
