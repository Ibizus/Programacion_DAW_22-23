package INTERFACES.jugadoresFutbol;

public class Jugador implements Jugar_I, Comparable<Jugador>{
    

    // ATRIBUTOS:
    protected String nombreCompleto;
    protected String apodo;
    protected int licencia;
    protected int numGoles;
    protected int numFaltas;

    static private int contadorLicencia;


    // CONSTRUCTORES:
    public Jugador(String nombre, String apodo)
    {
        this.nombreCompleto = nombre;
        this.apodo = apodo;

        contadorLicencia++;
        this.licencia = contadorLicencia;
    }

    public Jugador(String nombre, String apodo, int goles, int faltas)
    {
        this(nombre, apodo);
        this.numGoles = goles;
        this.numFaltas = faltas;
    }


    // METODOS:
    @Override
    public String toString()
    {
        return "\n" + this.nombreCompleto + " (" + this.apodo + ") - Goles " +
        this.numGoles + " - Faltas " + this.numFaltas;
    }

    
    @Override
    public boolean equals(Object objeto)
    {
        boolean iguales = false;

        Jugador comparado = (Jugador)objeto;
        
        if(this.licencia == comparado.licencia)
        {
            iguales = true;
        }

        return iguales;
    }


    @Override
    public void hacerGol()
    {
        this.numGoles++;
        System.out.println("Gooooooooool de " + this.apodo + "!!");
    }


    @Override
    public void cometerFalta()
    {
        this.numFaltas++;
        System.out.println("Terrible falta de " + this.apodo + "!");
    }


    @Override
    public int compareTo(Jugador j)
    {
        
        int diferencia = this.licencia - j.licencia;
        
        return diferencia;
    }

    // GETTERS:
    public String getNombre() {
        return nombreCompleto;
    }

    public String getApodo() {
        return apodo;
    }

    public int getLicencia() {
        return licencia;
    }

    public int getGoles() {
        return numGoles;
    }

    public int getFaltas() {
        return numFaltas;
    }

}
