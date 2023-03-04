package frioMijas_Hector;

class Password {
    

    // ATRIBUTOS:
    private int longitud;
    private String contraseña;


    // CONSTRUCTORES:
    public Password()
    {
        this.longitud = 8;
        generaPassword();
    }

    public Password(int longitud)
    {
        this.longitud = longitud;
        generaPassword(longitud);
    }


    // METODOS:
    public void generaPassword()
    {
        boolean passOk = false;
        int longitud = this.getLongitud();

        String newPass = "";
        do
        {
            // newPass = ""; // reseteo contraseña para volver a crearla

            for (int i = 0; i < longitud-1; i++)
            {
                int tipo = (int)(Math.random()*3+1);

                switch(tipo)
                {
                    case 1:
                        newPass += addCapital();
                        break;
                    
                    case 2:
                        newPass += addNumber();
                        break;

                    case 3:
                        newPass += addLower();
                        break;
                    default:
                }
            }

            passOk = esFuerte(newPass);

        }while(!passOk);

        this.contraseña = newPass;
    }

    private String addCapital()
    {
        int upperValue = (int)(Math.random()*(90-65+1)+65);

        String add = Character.toString(upperValue);

        return add;
    }

    private String addLower()
    {
        String add = addCapital().toLowerCase();

        return add;
    }

    private String addNumber()
    {
        String add = "" + (int)(Math.random()*10);

        return add;
    }

    public boolean esFuerte(String contraseña)
    {
        int capitalCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        boolean fuerte = false;

        longitud = contraseña.length();

        for (int i = 0; i < longitud-1; i++)
        {
            int valorAscii = Integer.valueOf(contraseña.charAt(i));


            if((valorAscii>=48)&&(valorAscii<=57))
            {
                numberCount++;
            }
            else if((valorAscii>=65)&&(valorAscii<=90))
            {
                capitalCount++;
            }
            else if((valorAscii>=97)&&(valorAscii<=122))
            {
                lowerCount++;
            }
        }

        if(numberCount>=5 && capitalCount >= 2 && lowerCount >= 1)
        {
            fuerte = true;
        }
        
        return fuerte;
    }

    public void generaPassword(int longitud)
    {
        setLongitud(longitud);

        generaPassword();
    }

    private int getLongitud()
    {
        return longitud;
    }

    private void setLongitud(int longitud)
    {
        this.longitud = longitud;
    }

    public String getContraseña()
    {
        return contraseña;
    }

}
