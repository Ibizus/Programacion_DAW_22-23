package modelo;


public class Person {
    

    // ATRIBUTOS:
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String number;


    // CONSTRUCTOR:
    public Person()
    {

    }

    public Person(String firstName, String lastName, String gender, int age, String number)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.number = number;
    }

    
    
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }

    // GETTERS Y SETTERS:
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    
}
