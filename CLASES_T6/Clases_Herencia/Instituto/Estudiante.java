package CLASES_T6.Clases_Herencia.Instituto;

public class Estudiante extends Persona{
    

    // ATRIBUTOS:
    private int numCarnetEstudiante;
    private int notaMedia;

    // CONTRUCTOR:
    public Estudiante(String nombre, String tlf, String mail)
    {
        super(nombre, tlf, mail);
    }
    
    public Estudiante(String nombre, String tlf, String mail, int num, int media)
    {
        this(nombre, tlf, mail);
        this.numCarnetEstudiante = num;
        this.notaMedia = media;
    }


    // METODOS:
    public int getNumCarnetEstudiante() {
        return numCarnetEstudiante;
    }

    public int getNotaMedia() {
        return notaMedia;
    }

    @Override
    public String toString()
    {
        return "\nEstudiante: " + super.toString() + " con número de carnet " + this.getNumCarnetEstudiante() + " y nota media: " + this.getNotaMedia();
    }
    
}
