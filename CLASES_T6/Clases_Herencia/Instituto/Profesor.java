package CLASES_T6.Clases_Herencia.Instituto;

public abstract class Profesor extends Persona{
    

    // ATRIBUTOS:
    protected double salarioBase;
    protected String materia;
    protected boolean esTutor;
    
    // CONSTRUCTORES:
    public Profesor(String nombre)
    {
        super(nombre);
    }
    public Profesor(String nombre, String tlf, String mail)
    {
        super(nombre, tlf, mail);
    }

    // METODOS:
    abstract double getSalario();

}
