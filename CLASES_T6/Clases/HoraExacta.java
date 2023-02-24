package CLASES_T6.Clases;

public class HoraExacta extends Hora2{
    
    //ATRIBUTOS:
    protected int segundos;
    

    // CONTRUCTOR:
    public HoraExacta(int hora, int minuto, int segundo)
    {
        super(hora, minuto);
        this.segundos = segundo;
    }


    // METODOS:
    public boolean setSegundo2(int segundo)
    {
        boolean setSeg = false;

        if(segundo>=0 && segundo<60)
        {
            this.segundos = segundo;
            setSeg = true;
        }

        return setSeg;
    }

    public void inc()
    {
        this.segundos++;

        if(this.segundos>=60)
        {
            this.minutos++;

            this.segundos-=60;
        }
    }

    public boolean comparaHoras(HoraExacta hora)
    {
        /* Tengo que poner los atributos private para que no pueda 
        acceder desde aqui a los atributos del padre, si no que tengo
        que llamar a la funcion equals del padre*/
        /* Falta definir el equals de Hora2 */

        boolean iguales = true;

        if(!(this.hora == hora.hora))
        {
            iguales = false;
        }
        else if(!(this.minutos == hora.minutos))
        {
            iguales = false;
        }
        else if(!(this.segundos == hora.segundos))
        {
            iguales = false;
        }

        return iguales;
    }

    @Override
    public String toString()
    {
        return super.toString() + ":" + this.minutos;
    }
}
