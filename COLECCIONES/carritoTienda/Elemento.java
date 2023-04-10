package COLECCIONES.carritoTienda;

public class Elemento {
    
    // ATRIBUTOS:
    private String nombre;
    private double precio;
    private Integer cantidad;

    // CONSTRUCTOR:
    public Elemento (String nombre, double precio, Integer cantidad)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // METODOS:
    @Override
    public String toString()
    {
        return this.nombre + " PVP: " + this.precio + " Unidades: " + this.cantidad + " Subtotal: " + (this.precio*this.cantidad);
    }

    @Override
    public boolean equals(Object obj)
    {
        Elemento nuevoElemento = (Elemento)obj;
        boolean iguales = false;

        if(this.nombre.equals(nuevoElemento.getNombre()) && this.precio == nuevoElemento.getPrecio())
        {
            iguales = true;
        }

        return iguales;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
}
