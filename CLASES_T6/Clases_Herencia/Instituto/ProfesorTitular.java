package CLASES_T6.Clases_Herencia.Instituto;

public class ProfesorTitular extends Profesor{
 
    // ATRIBUTOS:
    private int antiguedad;

    // CONSTRUCTOR:
    public

    public ProfesorTitular(double salario, String materia)
    {
        this.salarioBase = salario;
        this.materia = materia;
        this.esTutor = false;
    }

    public ProfesorTitular(double salario, String materia, boolean tutor)
    {
        this(salario, materia);
        this.esTutor = tutor;
    }

    public ProfesorTitular(double salario, String materia, boolean tutor, int antiguedad)
    {
        this(salario, materia, tutor);
        this.antiguedad = antiguedad;
    }

    @Override
    public double getSalario()
    {
        int extraTutor = (this.esTutor?30:0);

        return (this.salarioBase + (10*this.antiguedad) + extraTutor);
    }

    @Override
    public String toString()
    {
        return "\nProfesor Titular: " + super.toString() + ". Imparte " + this.materia + ", y tiene " + this.antiguedad + " años de antiguedad.";
    }
    
}
