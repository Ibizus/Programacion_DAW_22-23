import java.io.BufferedReader;
import java.io.FileReader;

import javax.print.PrintException;

public class App {
    public static void main(String[] args) throws Exception {
        

        GrupoAlumnos daw1 = new GrupoAlumnos();


        BufferedReader br = null;
        String linea = null;

        try 
        {
            br = new BufferedReader(new FileReader("src/recursos/ficheroAlumnos"));
            linea = br.readLine();
            // Me salto la primera línea:
            linea = br.readLine();


            while(linea!=null)
            {

                String[] trozosLinea = linea.split(" ".trim());
                System.out.println("tamaño array de campos: " + trozosLinea.length);
                
                // para cada linea creo un alumnos que va a recoger cada campo de la linea:
                Alumno nuevo = new Alumno();
                
                for (int i = 0; i < trozosLinea.length; i++)
                {
                    // hago un swith para tratar cada campo como un atributo de alumno:
                    switch(i)
                    {
                        case 0: // SEXO
                            try
                            {
                                nuevo.setSexo(trozosLinea[i]);
                            }
                            catch (Exception e) {
                                e.getMessage();
                            }    
                            break;

                        case 1: // EDAD
                            try
                            {
                                nuevo.setEdad(Integer.valueOf(trozosLinea[i]));
                            }
                            catch (Exception e1) {
                                e1.getMessage();
                            }  

                            break;
                        case 2: // ESTATURA
                            try
                            {
                                nuevo.setAltura(Double.valueOf(trozosLinea[i]));
                            }
                            catch (Exception e2) {
                                e2.getMessage();
                            }  

                            break;
                        case 3: // NOTA 1
                            try
                            {
                                nuevo.setNota1(Integer.valueOf(trozosLinea[i]));
                            }
                            catch (Exception e3) {
                                e3.getMessage();
                            }  

                            break;
                        case 4: // NOTA 2
                            try
                            {
                                nuevo.setNota2(Integer.valueOf(trozosLinea[i]));
                            }
                            catch (Exception e4) {
                                e4.getMessage();
                            }  

                            break;
                        case 5: // CALIFICACION
                            try
                            {
                                nuevo.setCalificacion(trozosLinea[i]);
                            }
                            catch (Exception e5) {
                                e5.getMessage();
                            }    
                            break;
                        default:
                            break;
                    }
                }
                daw1.add(nuevo);

                // actualizo variables:
                linea = br.readLine();
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            System.out.println(ex.getStackTrace());
        }
        finally 
        {
            if(br!=null)
            {
                br.close();
            }
        }
        System.out.println(daw1.toString());
    }

    
}
