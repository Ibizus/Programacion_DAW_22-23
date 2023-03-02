package frioMijas_Hector;

public class Empleado {
    

    // ATRIBUTOS:
    private String nombre;
    private String apellidos;
    private int edad;
    private double salario;
    private String dni;
    private int codigo;
    
    static private int codigoIncremental;


    // CONTRUCTORES:
    public Empleado(String nombre, String apellido, int edad, double salario, String dni)
    {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.edad = edad;
        this.salario = salario;
        this.dni = dni;
        this.codigo = codigoIncremental+1;
    }


    // METODOS:
    public double getSalario() {
        return salario;
    }

}
