import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;


public class App {
    public static void main(String[] args) throws Exception {
        
        // EMPIEZA EL PROGRAMA DECLARANDO EL GRUPO DE ALUMNOS Y CARGANDO SUS DATOS LEYENDO DESDE EL FICHERO 
        // QUE NOS ADJUNTAN Y TENEMOS EN SRC/RECURSOS:

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

                String[] trozosLinea = linea.split(" ");

                // Le hago un trim a cada fragmento:
                for (int index = 0; index < trozosLinea.length; index++)
                {
                    trozosLinea[index] = trozosLinea[index].trim();
                }

                
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
                                nuevo.setAltura(Double.valueOf(trozosLinea[i].replace(",", ".")));
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
                daw1.getGrupo().add(nuevo);
                

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
        // MUESTRO MI CLASE GRUPO DE ALUMNOS CON SU COLECCIÓN RELLENA A PARTIR DEL FICHERO:
        System.out.println("\nLISTADO DE ALUMNOS CREADO:");
        System.out.println(daw1.getGrupo().toString());


        /* PRUEBO LOS MÉTODOS CREADOS: */
        System.out.println("\n - - - - - - PRUEBA DE MÉTODOS - - - - - - ");
        System.out.println("\nCOLECCIÓN ORDENADA POR EDAD:");

        Collections.sort(daw1.getGrupo());
        System.out.println(daw1.getGrupo());


        double edadMedia = daw1.mediaEdades();
        System.out.println("\nMEDIA DE LAS EDADES: " + edadMedia);


        int numAlumnos = daw1.cantidadAlumnos();
        System.out.println("\nCANTIDAD DE ALUMNOS: " + numAlumnos);


        int numSuspensos = daw1.numeroSuspensos();
        System.out.println("\nCANTIDAD DE SUSPENSOS: " + numSuspensos);


        int numMujeres = daw1.numeroMujeres();
        System.out.println("\nCANTIDAD DE MUJERES: " + numMujeres);


        int suspensas = daw1.numMujeresSuspensas();
        System.out.println("\nCANTIDAD DE SUSPENSAS: " + suspensas);
        
    }
}
