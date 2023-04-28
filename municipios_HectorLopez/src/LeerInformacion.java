import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeerInformacion {
    
    


    
    public ArrayList<Municipio> leerFicheroMunicipio(Integer año)
    {
        String nombreFichero = "PoblacionMunicipiosMalaga.csv";
        String path = "src/resources/";
        
        ArrayList<Municipio> municipios = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path+nombreFichero)))
        {
            String linea = br.readLine();

            // me salto la primera línea:
            linea = br.readLine();

            while(linea!=null)
            {
                try 
                {
                    String[] trozosLinea = linea.split(";");

                    if(!trozosLinea[0].equals("29 Málaga") && trozosLinea[1].equals("Total"))
                    {
                        if(año == null)
                        {
                            String[] cpCiudad = trozosLinea[0].split(" ", 2);

                            municipios.add(new Municipio(cpCiudad[0], cpCiudad[1], , ));
                        }
                        else 
                        {

                        }
                    }

                } 
                catch (Exception e) 
                {
                
                }
            }









        } 
        catch (Exception e) 
        {
            System.out.println("No se ha podido leer el fichero");
            System.out.println(e.getMessage());
        }



        return null;
    }
}
