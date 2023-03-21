package INTERFACES.jugadoresFutbol;

public class Delantero extends Jugador{
    

        // ATRIBUTOS:
        private int regate;


        // CONSTRUCTOR:
        public Delantero(String nombre, String apodo)
        {
            super(nombre, apodo);
            regate = 70;
        }
        
        
        // METODOS:
        public int getRegate()
        {
            return this.regate;
        }

    }