package EXAMEN.colecciones_Hec;

public class Producto implements Comparable<Producto>{


    public enum Categoria{ELECTRONICA, MODA, HOGAR, DEPORTES};


    // ATRIBUTOS:
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;

    private static int idAutoIncremental;

    // CONSTRUCTOR:
    public Producto(String nombre, String descripcion, double precio, String categoria)
    {
        Producto.idAutoIncremental++;
        this.id = idAutoIncremental;
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = Categoria.valueOf(categoria.toUpperCase());
    }


    // METODOS:

    @Override
    public int compareTo(Producto o)
    {
        int diferencia = this.id - o.id;

        return diferencia;
    }

    @Override
    public boolean equals(Object objeto)
    {
        boolean iguales = false;

        Producto comparado = (Producto)objeto;
        
        if(this.nombre == comparado.nombre)
        {
            iguales = true;
        }

        return iguales;
    }

    public String toString()
    {
        return "Producto{id="+id+", nombre='"+nombre+"', descripción='"+descripcion+"', precio="+precio+", categoria='"+categoria+"'}";
    }


    // GETTERS:

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
