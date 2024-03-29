package utils;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import modelo.Address;
import modelo.Coche;
import modelo.Employee;
import modelo.People;
import modelo.Person;

public class jsonUtils {

	// METODOS PARA COCHE:

	public static Coche LeerCocheFromJsonFile(String relativePathFile)
    {
		Coche car = null;
		try {
			
			//File ficheroEmpleado = new File("src/recursos/employee.txt");
			File ficheroCoche = new File(relativePathFile);
			//byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
			
			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			try {
				car = objectMapper.readValue(ficheroCoche, Coche.class);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			
		}
			
        System.out.println("Car Object\n"+car);
        return car;
    }

	public static List<Coche> LeerListCochesFromJsonFile(String relativePathFile)
	{
		File ficheroCoche = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		List<Coche> listaCoches = null;
		try {
            listaCoches = objectMapper.readValue(ficheroCoche,  new TypeReference<List<Coche>>(){});
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaCoches;
	}

	/**
	 * Convierte un objeto en un Json
	 */
    public static void convertCarToJson(List<Coche> array)
    {
        try 
        {
            ObjectMapper objectMapper = new ObjectMapper();

            //configure Object mapper for pretty print
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
            
			//Puedo imprimirlo por consola 
            //writing to console, can write to any output stream such as file
            //StringWriter stringEmp = new StringWriter();
            //Sacar por consola el Json
            //objectMapper.writeValue(stringEmp, emp1);
            //System.out.println("Employee JSON is\n"+stringEmp);

			//Puedo guardarlo en un fichero
            File fileCar1 = new File("src/recursos/cochesTodos.json");
            objectMapper.writeValue(fileCar1, array);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

	
	// METODOS PARA DICCIONARIO DNI:
	public static HashMap<String, Person> LeerMapaDniFromJsonFile(String relativePathFile)
	{
		File ficheroMapa = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		HashMap<String, Person> mapaDniHashMap = null;
		try {
            mapaDniHashMap = objectMapper.readValue(ficheroMapa,  new TypeReference<HashMap<String, Person>>(){});
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return mapaDniHashMap;
	}



	// METODOS PARA PERSONAS:
	public static People LeerPeopleFromJsonFile(String relativePathFile)
    {
		People gentes = null;
		try {
			
			//File ficheroEmpleado = new File("src/recursos/employee.txt");
			File personasTodo = new File(relativePathFile);
			//byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
			
			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			try {
				gentes = objectMapper.readValue(personasTodo, People.class);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			
		}
			
        return gentes;
    }
	/**
	 * Convierte un objeto en un Json
	 */
    public static void convertPeopleToJson(People clasePeople)
    {
        try 
        {
            ObjectMapper objectMapper = new ObjectMapper();

            //configure Object mapper for pretty print
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);


			//Puedo guardarlo en un fichero
            File filePeople = new File("src/recursos/persona24.json");
            objectMapper.writeValue(filePeople, clasePeople);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }



	// METODOS PARA EMPLEADOS:

    public static Employee LeerEmpleadoFromJsonFile(String relativePathFile)
    {

        //File ficheroEmpleado = new File("src/recursos/employee.txt");
		File ficheroEmpleado = new File(relativePathFile);
        //byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		Employee emp = null;
        try {
            emp = objectMapper.readValue(ficheroEmpleado, Employee.class);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("Employee Object\n"+emp);
        return emp;
    }



	public static List<Employee> LeerListEmpleadoFromJsonFile(String relativePathFile)
	{
		File ficheroEmpleado = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		List<Employee> listaEmpleados = null;
		try {
            listaEmpleados = objectMapper.readValue(ficheroEmpleado,  new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaEmpleados;
	}

	/**
	 * Convierte un objeto en un Json
	 */
    public static void convertToJson()
    {
        try 
        {
            ObjectMapper objectMapper = new ObjectMapper();
            //convert Object to json string
            Employee emp1 = createEmployee();
            //configure Object mapper for pretty print
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
            
			//Puedo imprimirlo por consola 
            //writing to console, can write to any output stream such as file
            //StringWriter stringEmp = new StringWriter();
            //Sacar por consola el Json
            //objectMapper.writeValue(stringEmp, emp1);
            //System.out.println("Employee JSON is\n"+stringEmp);

			//Puedo guardarlo en un fichero
            File fileEmp1 = new File("src/recursos/empleado1.txt");
            objectMapper.writeValue(fileEmp1, emp1);
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static Employee createEmployee() {

		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Alfonso");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		emp.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Los Angeles");
		cities.add("New York");
		emp.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1000 Rs");
		props.put("age", "28 years");
		emp.setProperties(props);

		return emp;
	}
    /*
    	
		//writing to console, can write to any output stream such as file
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(stringEmp, emp1);
		System.out.println("Employee JSON is\n"+stringEmp);
		
		
		//converting json to Map
		byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
		Map<String,String> myMap = new HashMap<String, String>();
		
		myMap = objectMapper.readValue(mapData, HashMap.class);
		System.out.println("Map is: "+myMap);
		//another way
		myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
		System.out.println("Map using TypeReference: "+myMap);
		
		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = "+idNode.asInt());
		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}
		
		//update JSON data
		((ObjectNode) rootNode).put("id", 500);
		//add new key value
		((ObjectNode) rootNode).put("test", "test value");
		//remove existing key
		((ObjectNode) rootNode).remove("role");
		((ObjectNode) rootNode).remove("properties");
		objectMapper.writeValue(new File("updated_emp.txt"), rootNode);
        */
    
}
