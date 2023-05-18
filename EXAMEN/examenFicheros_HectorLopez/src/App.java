import models.Ferreteria;
import utils.ManejoFicheros;

public class App {
    public static void main(String[] args) throws Exception {

        Ferreteria nuevaFerreteria = new Ferreteria();

        // Muestro salida de la lectura:
        System.out.println(nuevaFerreteria.getClientes());
        System.out.println(nuevaFerreteria.getProductos());
        System.out.println(nuevaFerreteria.getVentas());


        nuevaFerreteria.buscaProducto(12);
        System.out.println(nuevaFerreteria.buscaProducto(12));


        // ANTES DE EMPEZAR A ESCRIBIR EN EL FICHERO DE SALIDA TENGO QUE VER SI EXISTE Y BORRARLO PARA NO REPETIR LAS SALIDAS GUARDADAS:
        String nombreFichero = "FacturacionClientes.txt";
        ManejoFicheros.borraFichero("src/resources/" + nombreFichero);
        String salida1 = nuevaFerreteria.facturacionPorCliente();
        ManejoFicheros.escribeEnFichero(salida1);


        String nombreFichero2 = "ProductosVendidos.txt";
        ManejoFicheros.borraFichero("src/resources/" + nombreFichero2);
        String salida2 = nuevaFerreteria.productosVendidos();
        ManejoFicheros.escribeEnFichero(salida2);


        String nombreFichero3 = "FacturacionTotal.txt";
        ManejoFicheros.borraFichero("src/resources/" + nombreFichero3);
        String salida3 = nuevaFerreteria.facturacionTotal();
        ManejoFicheros.escribeEnFichero(salida3);

    }
}
