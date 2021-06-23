package poisedPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project Management System for Poised.
 * NewProject / child inherits InputChecks / Parent which is a superclass.
 * <p>
 * This will be used to add a new project to the Poised Management System for Posied.
 * MainMenu class calls on methods from this class to add new projects.
 * @author Yorick Cockrell
 */

public class NewProject extends InputChecks
{ // attributes for the 'NewProject' class.

    private int projectNumber;
    private String projectName;
    private String buildingType;
    private String address;
    private String erfNumber;
    private double totalFee;
    private double amountPaid;
    private String deadline;
    private String Completion;
    private String Status;

    /**
     * Project Management System for Poised.
     * <p>
     * Will ask user to enter information displaying from the console.
     * After each entry 'addProject()' methode will call the Parent class from InputChecks to check each entry if
     * its correct.
     * 'addProject()' will then displays the new project that was created on the console to the user.
     * At the same time 'addProject()' will also write the info to "CurrentProjects.txt" text file.
     */
    public void addProject()
    {

        // User prompted for input regarding project information.
        System.out.println("\nPlease enter project number (Only numbers): ");
        projectNumber = intInput("project number");

        System.out.println("Please enter project name: ");
        projectName = stringInput("project name");

        System.out.println("Please enter building type (E.g. House, apartment block or store, etc. : ");
        buildingType = stringInput("building type");

        System.out.println("Please enter physical address for the project: ");
        address = stringInput("physical address");

        System.out.println("Please enter ERF number: ");
        erfNumber = stringInput("ERF number");

        System.out.println("Please enter total fee charged for the project (Only numbers): ");
        totalFee = doubleInput("total fee");

        System.out.println("Please enter total amount paid to date (Only numbers): ");
        amountPaid = doubleInput("total amount");

        System.out.println("Please enter project deadline in this format dd/mm/yy (e.g. dd/mm/yy: 3 November 2020) : ");
        deadline = stringInput("project deadline");

        // Completion and Status variables set to negative as this is a newly added project.
        Completion = "Not complete";
        Status = "Not finalised";

        // New project object displayed to the user.
        System.out.println("" +
                "\nProject Number: " + projectNumber +
                "\nProjectName: " + projectName +
                "\nBuilding Type: " + buildingType +
                "\nPhysical Address: " + address +
                "\nERF Number: " + erfNumber +
                "\nTotal Fee: R" + totalFee +
                "\nAmount Paid: R" + amountPaid +
                "\nDeadline: " + deadline +
                "\nCompletion Date: " + Completion +
                "\nProject Status: " + Status);

        String projectInfo =  // Writing the string 'projectInfo' to the CurrentProjects.txt file in one line
                projectNumber + ", "
                + projectName + ", "
                + buildingType + ", "
                + address + ", "
                + erfNumber + ", "
                + totalFee + ", "
                + amountPaid + ", "
                + deadline + ", "
                + Completion + ", "
                + Status;


        // Try-catch block to test for error handling.
        try
        {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("CurrentProjects.txt", true));

            out.write(projectInfo + "\r\n");
            out.close();
            System.out.println("Your project was successfully added.");
        }
        catch (IOException e)
        {
            System.out.println("Error" + e);
        }
    }
}
