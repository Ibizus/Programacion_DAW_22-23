import java.util.ArrayList;

public class GrupoAlumnos extends ArrayList<Alumno>{
    

    // ATRIBUTOS:
    private ArrayList<Alumno> clase;

    // CONSTRUCTOR:
    public GrupoAlumnos()
    {
        this.clase = new ArrayList<>();
    }

    // METODOS:
    public double mediaEdades()
    {
        double edadMedia = 0.0;

        for (Alumno alumno : this.clase) {
            
            edadMedia+= alumno.getEdad();
        }

        return edadMedia/this.clase.size();
    }

    public int cantidadAlumnos()
    {
        return this.clase.size();
    }

    public int numeroSuspensos()
    {
        int numero = 0;

        for (Alumno alumno : this.clase)
        {
            if(alumno.getCalificacion().equalsIgnoreCase("suspenso"))
            {
                numero++;
            }
        }
        return numero;
    }

    public int numeroMujeres()
    {
        int mujeres = 0;

        for (Alumno alumno : this.clase)
        {
            if(alumno.getSexo().equalsIgnoreCase("mujer"))
            {
                mujeres++;
            }
        }
        return mujeres;
    }

    public int numMujeresSuspensas()
    {
        int suspendida = 0;

        for (Alumno alumno : this.clase)
        {
            if(alumno.getSexo().equalsIgnoreCase("mujer") && alumno.getCalificacion().equalsIgnoreCase("suspenso"))
            {
                suspendida++;
            }
        }
        return suspendida;
    }
}
