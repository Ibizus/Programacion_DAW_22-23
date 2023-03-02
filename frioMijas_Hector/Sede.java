package frioMijas_Hector;

public class Sede {

    public enum Frigorifico{MINIBAR, FRIGORIFICO, ARCON, CAMARA};
    

    // ATRIBUTOS:
    private String ciudad;
    private String direccion;
    private int cp;
    private int codigoSede;
    private Jefe jefeSede;
    private Empleado[] empleados_Sede;
    private Frigorifico[] equipos_Sede;

    static private int cod_Incremental;


    // CONSTRUCTORES:
    public Sede(String ciudad, String direccion, int cp)
    {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cp = cp;
        this.codigoSede = cod_Incremental+1;
    }

    public Sede(String ciudad, String direccion, int cp, Jefe jefeSede)
    {
        this(ciudad, direccion, cp);
        this.jefeSede = jefeSede;
    }
    


    // METODOS:

    /**
     * Inserta un empleado al final del array
     * @param nuevoEmpleado
     */
    public void addEmpleado(Empleado nuevoEmpleado)
    {
        Empleado[] nuevo = new Empleado[this.empleados_Sede.length+1];

        for (int i = 0; i < this.empleados_Sede.length; i++)
        {
            nuevo[i] = this.empleados_Sede[i];
        }

        nuevo[nuevo.length-1] = nuevoEmpleado;

        this.empleados_Sede = nuevo;
    }

    public void setJefe(Jefe jefeSede) {
        this.jefeSede = jefeSede;
    }
    
    

}
