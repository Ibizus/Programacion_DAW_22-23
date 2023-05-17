import utils.ManejoFicheros;

public class App {
    public static void main(String[] args) throws Exception {


        String nombreFichero = "asi se va a llamar";
        // ANTES DE EMPEZAR A ESCRIBIR EN EL FICHERO DE SALIDA TENGO QUE VER SI EXISTE Y BORRARLO PARA NO REPETIR LAS SALIDAS GUARDADAS:
        String nombreFicheroSalida = nombreFichero.replace(" ", "");
        ManejoFicheros.borraFichero("src/resources/" + nombreFicheroSalida + ".txt");









        
    }
}
