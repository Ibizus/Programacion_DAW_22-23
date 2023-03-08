package CLASES_T6.Clases_Herencia.Instituto;

public class ProfesorInterino extends Profesor{
    

    // CONSTRUCTOR:
    public ProfesorInterino(double salario, String materia)
    {
        this.salarioBase = salario;
        this.materia = materia;
        this.esTutor = false;
    }

    public ProfesorInterino(double salario, String materia, boolean tutor)
    {
        this(salario, materia);
        this.esTutor = tutor;
    }

    @Override
    double getSalario()
    {
        int extraTutor = (this.esTutor?25:0);

        return (this.salarioBase + extraTutor);
    }


}
