package CLASES_T6.Clases;

public class Hora2 {
    
    // ATRIBUTOS:
    protected int hora;
    protected int minutos;


    // CONSTRUCTORES:
    public Hora2(int h, int minutos)
    {
        if(hora>=0 && hora<=23)
        {
            this.hora = h;
        }
        else 
        {
            this.hora = 0;
        }

        if(minutos>=0 && minutos<60)
        {
            this.minutos = minutos;
        }
        else 
        {
            this.minutos = 0;
        }
    }


    // METODOS:
    public int getHora2()
    {
        return hora;
    }

    public void inc()
    {
        this.minutos++;

        if(this.minutos>=60)
        {
            this.hora++;

            this.minutos-=60;
        }
    }

    public boolean setHora2(int hora)
    {

        boolean setHora = false;

        if(hora<=23)
        {
            this.hora = hora;
            setHora = true;
        }

        return setHora;
    }

    public boolean setMinutos2(int minutos)
    {
        
        boolean setMin = false;

        if(minutos<60 && minutos>=0)
        {
            this.minutos = minutos;
            setMin = true;
        }

        return setMin;
    }

    @Override
    public String toString()
    {
        String horaActual = hora + ":" + minutos;
        
        return horaActual;
    }

}
