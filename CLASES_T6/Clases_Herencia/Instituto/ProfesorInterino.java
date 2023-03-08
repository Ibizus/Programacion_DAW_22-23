package CLASES_T6.Clases_Herencia.Instituto;

public class ProfesorInterino extends Profesor{
    

    // CONSTRUCTOR:
    public ProfesorInterino(String nombre, double salario, String materia, boolean tutor)
    {
        super(nombre, salario, materia, tutor);
    }

    public ProfesorInterino(String nombre, String tlf, String mail, double salario, String materia, boolean tutor)
    {
        super(nombre, tlf, mail, salario, materia, tutor);
    }

    @Override
    double getSalario()
    {
        int extraTutor = (this.esTutor?25:0);

        return (this.salarioBase + extraTutor);
    }


}
