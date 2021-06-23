package poisedPackage;

/**
 * Project Management System for Poised.
 * NewPerson is a  child class/ subclass that creates and displays a person object.
 * <p>
 * It has attributes for variables for this class 'NewPerson'
 * It has an constructor to create objects for the person.
 * It has an method to display the created person.
 * The MainMenu class calls on methods from this class to add new projects to 'completedProject.txt'.
 * @author Yorick Cockrell
 */
public class NewPerson
{
    // Attribute variables for this class.
    // These are set to 'private' for weak coupling between classes.
    private String personType;
    private String name;
    private int number;
    private String email;
    private String address;

    /**
     * Project Management System for Poised.
     * NewPerson constructor has 5 parameters which information needs to be passed in to create a new person as an object.
     * <p>
     * A NewPerson object will consist of (personType,name,number,email and address).
     * @param personType personType (e.g. customer, contractor or architect )
     * @param name name full name.
     * @param number contact number.
     * @param email email address.
     * @param address physical address.
     */
    public NewPerson(String personType, String name, int number, String email, String address)
    {
        this.personType = personType;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;  // Person object constructed with variable attributes.
    }

    /**
     * 'ViewPerson()' method will view all the attributes of the new person in the format below.
     * @return returns a string output with all new person information.
     */
    public String ViewPerson()
    {
        System.out.println(" Details for :\n" + personType );
        String output = "Title: " + personType;
        output += "\nName: " + name;
        output += "\nNumber: " + number;
        output += "\nEmail Address: " + email;
        output += "\nPhysical Address: " + address;

        return output;  // Output string returned.
    }
}
