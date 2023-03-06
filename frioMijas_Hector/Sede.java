package frioMijas_Hector;

import frioMijas_Hector.Material.Equipo;
import frioMijas_Hector.Personal.Empleado;
import frioMijas_Hector.Personal.Jefe;

public class Sede {

    // ATRIBUTOS:
    static private int cod_Incremental;

    private String ciudad;
    private String direccion;
    private int cp;
    private int codigoSede;
    private Jefe jefeSede;
    private Empleado[] empleados_Sede;
    private Equipo[] equipos_Sede;


    // CONSTRUCTORES:
    public Sede(String ciudad, String direccion, int cp)
    {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cp = cp;
        cod_Incremental++;
        this.codigoSede = cod_Incremental;
        this.empleados_Sede = new Empleado[0];
        this.equipos_Sede = new Equipo[0];
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
    
    @Override
    public String toString()
    {
        String resultado = "";

        resultado+= "Sede con código " + this.codigoSede + ", ubicada en: " + this.direccion + ", CP:" + this.cp + " (" + this.ciudad + ") " +
                    "\nJefe: " + this.jefeSede.toString();

                    for (int i = 0; i < this.empleados_Sede.length; i++)
                    {
                        resultado+= this.empleados_Sede[i].toString();
                    }

                    resultado+= "\nEquipos de la sede:";

                    for (int i = 0; i < equipos_Sede.length; i++)
                    {
                        resultado+= this.equipos_Sede[i].toString();
                    }

        return resultado;
    }

}
