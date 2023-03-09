package EXAMEN.examenClases_HectorLopez;

import java.time.LocalDate;

import EXAMEN.examenClases_HectorLopez.material.Avion;
import EXAMEN.examenClases_HectorLopez.material.Paracaidas;
import EXAMEN.examenClases_HectorLopez.personal.Cliente;
import EXAMEN.examenClases_HectorLopez.personal.Piloto;

public class Vuelo {
    

    // ATRIBUTOS:
    private int numeroSalto;
    static private int contadorSaltos;

    private Cliente[] saltadores;
    private Paracaidas[] asignados;
    private Piloto piloto;
    private Avion avion;
    private LocalDate fechaSalto;


    // CONSTRUCTOR:
    public Vuelo(Avion avion, Piloto piloto)
    {
        this.avion = avion;
        this.piloto = piloto;
        this.saltadores = new Cliente[0];
        this.asignados = new Paracaidas[0];
        LocalDate fechaSalto = LocalDate.now();

        this.numeroSalto = contadorSaltos+1;
        contadorSaltos++;
    }

    // METODOS:

    public void addSaltador(Cliente cliente, Paracaidas para1, Paracaidas para2)
    {
        // Comprobamos si caben mas saltadores:
        if(this.saltadores.length >= this.avion.getCapacidad())
        {
            System.out.println("No caben mas saltadores dentor del avion");
        }
        else
        {
            // Comprobamos si el cliente ya está en el avion:
            boolean yaEsta = false;
            for (int i = 0; i < this.saltadores.length; i++)
            {
                if(cliente.equals(this.saltadores[i]))
                {
                    yaEsta = true;
                }
            }

            // En caso contrario creamos el nuevo array y añadimos al cliente
            if(yaEsta)
            {
                System.out.println("Este saltador ya se encuentra dentro del avión");
            }
            else
            {
                Cliente[] nuevo = new Cliente[this.saltadores.length+1];

                for (int i = 0; i < this.saltadores.length; i++)
                {
                    nuevo[i] = this.saltadores[i];
                }
        
                nuevo[nuevo.length-1] = cliente;
        
                this.saltadores = nuevo;

                // Una vez asignado el cliente asignamos los dos paracaidas usados:
                addParacaidas(para1);
                addParacaidas(para2);
            }
        }


    }

    public void addParacaidas(Paracaidas para)
    {
        Paracaidas[] nuevo = new Paracaidas[this.asignados.length+1];

        for (int i = 0; i < this.asignados.length; i++)
        {
            nuevo[i] = this.asignados[i];
        }

        nuevo[nuevo.length-1] = para;

        this.asignados = nuevo;
    }


    public void salto()
    {
        Cliente saltador = null;

        if(this.saltadores.length>0)
        {
            Cliente[] nuevoArray = new Cliente[this.saltadores.length-1];

            for (int i = 0; i < nuevoArray.length; i++)
            {
                nuevoArray[i] = this.saltadores[i];    
            }
    
            saltador = this.saltadores[this.saltadores.length-1];
    
            this.saltadores = nuevoArray;

            System.out.println("El saltador " + saltador.informacion() + " ha saltado");
        }
        else 
        {
            System.out.println("No quedan saltadores en el avion");
        }
    }

    public String saltadores()
    {
        String resultado = "Saltadores\n";

        for (int i = 0; i < saltadores.length; i++)
        {
            resultado += saltadores[i].informacion();
        }
        return resultado;
    }

    public String informacionVuelo()
    {
        String resultado = "\n\n----- Vuelo -------\n";

        resultado += "Codigo: " + this.numeroSalto + this.piloto + this.avion + "\nFecha del vuelo: " +
         this.fechaSalto + "\nSaltadores: " + this.saltadores.length + 
         "\n-------------------------------------------------\n";

        resultado+= saltadores();

        return resultado;
    }

    public String ordenSalto()
    {
        String resultado = "";

        for (int i = saltadores.length-1; i >=0 ; i--)
        {
            resultado += saltadores[i].getNombre() + " (" + saltadores[i].getAlturaSalto() + ")  |  ";
        }

        return resultado;
    }

}
