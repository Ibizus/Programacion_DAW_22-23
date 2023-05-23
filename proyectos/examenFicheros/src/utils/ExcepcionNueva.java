package utils;

public class ExcepcionNueva extends Exception{


    public ExcepcionNueva(String param1, String param2)
    {
        super("Mensaje con " + param1 + " y con " + param2);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
