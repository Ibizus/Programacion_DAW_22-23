package models;

import java.util.ArrayList;

import utils.ManejoFicheros;

public class Ferreteria {
    
    // ATTRIBUTES:
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;
    
    // CONSTRUCTOR:
    public Ferreteria(){
        
        this.clientes = ManejoFicheros.leeListaClientesFromJson("clientes.json");
        this.productos = ManejoFicheros.leerFicheroProductos("productos.csv");
        this.ventas = ManejoFicheros.leeListaVentasFromJson("ventas.json");
    }
    

    // METHODS:
    public String facturacionPorCliente(){
        
        String salida = "";

        for (Cliente cliente : this.clientes)
        {
            double totalCliente = 0;
            salida += "\n" + cliente.getNombre() + "(cod:" + cliente.getCodigo() + "): ";

            for (Venta venta : this.ventas)
            {
                if(venta.getCodigoCliente() == cliente.getCodigo())
                {
                    for (Linea linea : venta.getLineas())
                    {
                        Producto buscado = buscaProducto(linea.getCodigoProducto());
                        double importe = buscado.getPrecio();
                        totalCliente += importe * linea.getCantidad();
                    }
                }
            }
            salida += totalCliente + "€";    
        }
        return salida;
    }

    public Producto buscaProducto(int codigo)
    {
        Producto buscado = null;

        for (Producto producto : this.productos)
        {
            if(producto.getCodigo() == codigo)
            {
                buscado = producto;
            }    
        }
        return buscado;
    }

    public String productosVendidos()
    {
        String salida = "";

        for (Producto producto : this.productos)
        {
            salida += "\n" + producto.getNombre() + " (cod: " + producto.getCodigo() + "): ";
            int cantidad = 0;

            for (Venta venta : this.ventas)
            {
                for (Linea linea : venta.getLineas())
                {
                    if(producto.getCodigo() == linea.getCodigoProducto())
                    {
                        cantidad += Integer.valueOf(linea.getCantidad());
                    }
                }
            } 
            salida += cantidad + " cantidades";      
        }
        return salida;
    }

    // no me ha dado tiempo:
    public double facturacionTotal()
    {
        double total = 0;

        for (Venta venta : this.ventas)
        {
            for (Linea linea : venta.getLineas())
            {
                total += Integer.valueOf(linea.getCantidad()) * buscaProducto(linea.getCodigoProducto()).getPrecio();
            }
        } 
        return total;
    }


    // GETTERS Y SETTERS:
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

}
