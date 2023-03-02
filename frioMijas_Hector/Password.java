package frioMijas_Hector;

public class Password {
    

    // ATRIBUTOS:
    private int longitud;
    private String contraseña;


    // CONSTRUCTORES:
    public Password()
    {
        this.longitud = 8;
        this.contraseña = generaPassword();
    }

    public Password(int longitud)
    {
        this.longitud = longitud;
        this.contraseña = generaPassword(longitud);
    }


    // METODOS:
    public boolean esFuerte()
    {

    }

    public String generaPassword()
    {

    }

    public String generaPassword(int longitud)
    {

    }

    public int getLongitud()
    {
        return longitud;
    }

    public void setLongitud(int longitud)
    {
        this.longitud = longitud;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    
}
