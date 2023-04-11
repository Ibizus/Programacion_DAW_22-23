package BASES_DATOS;

import java.sql.*;
import java.util.Scanner;

public class Crud2 {

    static Scanner sc = new Scanner(System.in);
    static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        // CONEXION CON BASE DE DATOS:
        String nombre;
        String apellidos;
        String telefono;
        Connection conexion ;
        Statement st;
        ResultSet rs;
        System.setProperty("jdbc.drivers", "com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/people";
        String user = "admin";
        String pass = "admin";
        String consulta = "select nombre, apellidos, telefono from people where dni = ";
        String dni;

        try
        {
        conexion = DriverManager.getConnection(url ,user, pass);
        System.out.println("Connection success.");
        st=conexion.createStatement();
        rs=st.executeQuery(consulta);
        rs.next();
        nombre = rs.getString("nombre");
        apellidos = rs.getString("apellidos");
        telefono = rs.getString("telefono");
        System.out.println("nombre -> " + nombre);
        System.out.println("apellidos -> " + apellidos);
        System.out.println("telefono -> " + telefono);


        }
        catch (SQLException sqle)
        {
        System.out.println(sqle.getMessage());
        }

    /*

        // VARIABLES:
        boolean salir = false;
        int opcion = 0;


        // BUCLE MENU:
        do
        {
            opcion = menu();

            switch(opcion)
            {
                case 1:
                    consulta();
                    break;

                case 2:
                    alta();
                    break;

                case 3:
                    baja();
                    break;

                case 4:
                    modificaDatos();
                    break;

                case 0:
                    salir = true;
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opción incorrecta, vuelve a intentarlo");
            }

            System.out.println();

        }while(!salir); */

    }

    // FUNCIONES:

    static int menu()
    {
        System.out.println("\n\t" + ANSI_GREEN_BACKGROUND + "BIENVENIDO AL MENU DE CLIENES" + ANSI_RESET + "\n");
        System.out.println("1 - Consulta de datos");
        System.out.println("2 - Alta nueva");
        System.out.println("3 - Baja de persona");
        System.out.println("4 - Modificar datos");
        System.out.println("0 - Salir");
        System.out.println("---------------------------------------------");
        System.out.println(" Indique una opción:\n");

        int opcion = sc.nextInt();
        return opcion;
    }

    static void consulta()
    {
        System.out.println("Inserta el DNI de la persona:");
        String dniBuscado = sc.nextLine();
    }

    static void alta()
    {
        System.out.println("Inserta el DNI de la persona:");
        String dniBuscado = sc.nextLine();
    }

    static void baja()
    {
        System.out.println("Inserta el DNI de la persona:");
        String dniBuscado = sc.nextLine();
    }

    static void modificaDatos()
    {
        System.out.println("Inserta el DNI de la persona:");
        String dniBuscado = sc.nextLine();
    }



}
