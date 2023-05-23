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
    

    public static ArrayList<T> leerFichero_CSV(String nombreArchivo)
    {
        String nombreFichero = nombreArchivo;
        String path = "src/resources/";
        
        ArrayList<T> listaT = new ArrayList<>();
        
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

                    // se sacan las variables necesarias:
                    int stock = Integer.valueOf(trozosLinea[3]);

                    // lanza excepcion personalizada:
                    if (stock == 0)
                    {
                        throw new ExcepcionNueva("para1", "param2");
                    }
                    else
                    {
                        listaT.add(new T(trozosLinea[0], trozosLinea[1], trozosLinea[2], stock)); 
                    }
                }
                catch (ExcepcionNueva e1) 
                {
                    System.out.println(e1.getMessage());
                }
                catch (Exception ex) 
                {
                    System.out.println("Error al leer la línea " + linea);
                    // System.out.println(ex.getMessage());
                }
                //actualiza concidion bucle:
                linea = br.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error al leer el fichero");
            System.out.println(e.getMessage());
        }

        return listaT;
    }

	public static List<T> leeLista_Json(String relativePathFile)
	{
		List<T> lista = null;
        
		try {
            File fileName = new File(relativePathFile);
            ObjectMapper objectMapper = new ObjectMapper();

            lista = objectMapper.readValue(fileName, new TypeReference<List<T>>(){});
        } 
        catch (IOException e) {
            

            e.printStackTrace();
        }
        
		return lista;
	}
    
    public static T lee_FromJson(String relativePathFile)
    {
        T listaNueva = null;
        
        try {
            File fileName = new File(relativePathFile);
            ObjectMapper objectMapper = new ObjectMapper();

            listaNueva = objectMapper.readValue(fileName, new TypeReference<T>(){});
        }
        catch (IOException e) {
            
            e.printStackTrace();
        }
        return listaNueva;
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
            System.out.println("Error al borrar el fichero");
        }
    }

    public static void escribeEnFichero(String fileName, String output) throws Exception
    {
        String nombreFichero = fileName + ".txt";
        String path = "src/resources/";
        
        try(FileWriter fileWriter = new FileWriter(path+nombreFichero, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);)
        {
            bWriter.append(output);
            bWriter.newLine();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al escribir el fichero " + fileName);
        }
    }


}
