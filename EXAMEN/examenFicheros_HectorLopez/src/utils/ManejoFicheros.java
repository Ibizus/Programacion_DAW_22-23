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
    
    public static String leeClaseFromJson(String relativePathFile)
    {
		String pokemon = null;
		try {
			
            // Create File
			File oneClassFile = new File(relativePathFile);
			
			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			try {
				pokemon = objectMapper.readValue(oneClassFile, String.class);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			
		}
        return pokemon;
    }


	public static List<String> leeListaClaseFromJson(String relativePathFile)
	{
		File fileName = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		List<String> listaName = null;

		try {
            listaName = objectMapper.readValue(fileName, new TypeReference<List<String>>(){});
        } 
        catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaName;
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

    public static void escribeEnFichero(String arg) throws Exception
    {

        String nombreFichero = arg + ".txt";
        String path = "src/resources/";
        
        FileWriter fileWriter = null;
        BufferedWriter bWriter = null;
        
        try
        {
            fileWriter = new FileWriter(path+nombreFichero, true);
            bWriter = new BufferedWriter(fileWriter);
            
            bWriter.append(arg);
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
