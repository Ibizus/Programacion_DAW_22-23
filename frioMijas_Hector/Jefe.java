package frioMijas_Hector;

public class Jefe extends Empleado{
    
    // ATRIBUTOS:
    private Password clave;


    // CONSTRUCTORES:
    public Jefe(String nombre, String apellido, int edad, double salario, String dni)
    {
        super(nombre, apellido, edad, salario, dni);

        this.clave = new Password();
    }


    // METODOS:
    public void generaPassword()
    {
        this.clave.generaPassword();
    }

    public void generaPassword(int i)
    {
        this.clave.generaPassword(i);
    }

    @Override
    public String toString()
    {
        return super.toString() + " Jefe con contraseña: " + this.clave.getContraseña();
    }
}
