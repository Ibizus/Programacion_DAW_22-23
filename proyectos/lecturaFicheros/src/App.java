import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {


        System.out.println("Leo con FileReader");
        FileReader fr = null;
    
        try 
        {
            fr = new FileReader("src/recursos/fichero1.txt");

            int caracterLeido = fr.read();

            while (caracterLeido != -1)
            {
                System.out.println((char)caracterLeido);
                caracterLeido = fr.read();
            }
            
        }
        catch (FileNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        finally
        {
            if(fr != null)
            {
                fr.close();
            }
        }


    }
}
