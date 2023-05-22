package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Area;
import models.Direccion;
import models.Evento;


public class ManejoFicheros {
    


    public static ArrayList<Evento> leerFicheroEventos(String nombreArchivo)
    {
        String nombreFichero = nombreArchivo;
        String path = "src/resources/";
        
        ArrayList<Evento> listaEventos = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path+nombreFichero)))
        {
            String linea = br.readLine();
            // saltamos primera linea:
            linea = br.readLine();
            
            while(linea!=null)
            {
                try
                {
                    String[] trozosLinea = linea.split(";");

                    listaEventos.add(new Evento(trozosLinea[0], trozosLinea[1], trozosLinea[3].equals("1"), 
                                    new Direccion(new Area(trozosLinea[22])), trozosLinea[13])); 
                } 
                catch (Exception ex) 
                {
                    // System.out.println("Problema al leer la línea: " + linea);
                    System.out.println(ex.getMessage());
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

        return listaEventos;
    }



	public static List<Ciclista> leeListaCiclistasFromJson(String relativePathFile)
	{
		File fileCiclistas = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		List<Ciclista> listaCiclistas = null;

		try {
            listaCiclistas = objectMapper.readValue(fileCiclistas, new TypeReference<List<Ciclista>>(){});
        } 
        catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaCiclistas;
	}



    public static Map<Integer, Integer> leeTiemposEtapaFromJson(String relativePathFile)
	{
		File fileTiempos = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		Map<Integer, Integer> mapaTiempos = null;

		try {
            mapaTiempos = objectMapper.readValue(fileTiempos, new TypeReference<Map<Integer, Integer>>(){});
        } 
        catch (IOException e) {
            
            e.printStackTrace();
        }

		return mapaTiempos;
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



    public static void escribeEnFichero(String fileName, String output) throws Exception
    {

        String nombreFichero = fileName + ".txt";
        String path = "src/resources/";
        
        FileWriter fileWriter = null;
        BufferedWriter bWriter = null;
        
        try
        {
            fileWriter = new FileWriter(path+nombreFichero, true);
            bWriter = new BufferedWriter(fileWriter);
            
            bWriter.append(output);
            bWriter.newLine();
        } 
        catch (Exception e) 
        {
            //System.out.println("Algo ha fallado");
        }
        finally
        {
            try 
            {
                if(bWriter != null)
                {
                    bWriter.close();
                }
                if(fileWriter != null)
                {
                    fileWriter.close();
                }
            } 
            catch (Exception e) 
            {

            }
        }
    }
}
