package COLECCIONES.academicosLengua;

public class Academico implements Comparable<Academico>{
    
    // ATRIBUTOS:
    public String nombre;
    public int ingreso;
    

    // CONSTRUCTOR:
    public Academico(String nombre, int año)
    {
        this.nombre = nombre;
        ingreso = año;
    }


    // METODOS:
    public String getNombre() {
        return nombre;
    }

    public int getIngreso() {
        return ingreso;
    }

    @Override
    public int compareTo(Academico o) {

        return this.nombre.compareTo(o.getNombre());
    }

}
