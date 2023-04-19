package EXAMEN.colecciones_Hec.interfaces_tienda;

import EXAMEN.colecciones_Hec.componentesTienda.Producto;

public interface Tienda_I {
    
    boolean insertarProducto(Producto producto);

    String mostrarProductosPorNombre();

    String mostrarProductosPorId();

    Producto buscarProducto(int id);

    double obtenerCuentaTotal();
}
