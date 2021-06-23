package poisedPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project Management System for Poised.
 * ExistingProjects is a subclass / child that inherits methods from the InputChecks superclass / Parent.
 * <p>
 * This class contains methods to find, and view on projects in the Poised Management System.
 * The Poised MainMenu class, which runs the main program, calls on methods from this class to perform various
 * methods on projects managed by the Company.
 * @author Yorick Cockrell
 */
public class ExistingProjects extends InputChecks
{
    /**
     * The viewProjects method calls CurrentProjects.txt and split them into a String array for the
     * file to be display.
     * <p>
     * The projects are each displayed onto the console in an easy-to-read format.
     */
    public void viewProjects()
    {
        // 'searchFile' will hold the object 'currentProject.txt'
        // Scanner class will input the object 'searchFile' to 'projectFile' which will be used to scan the text file

        // A file object is created and a while loop used to run through each line / iterate in the CurrentProjects.txt file.
        // String array will store an array as info
        // the object that holds the currentProject.txt, projectFile will call nextLine() methode to iterate through
        // and as it iterate through it will call the methode split() and search for
        // Each line in the file by splitting it by (", ") with the info stored in the set string array.
        // Each index in the array is assigned to a variable e.g. info[0] = projectNum.

        try
        {
            File searchFile = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(searchFile);

            while (projectFile.hasNextLine())
            {
                String[] info = projectFile.nextLine().split(", ");
                String projectNum = info[0];
                String projectName = info[1];
                String buildingType = info[2];
                String address = info[3];
                String erfNum = info[4];
                String totalFee = info[5];
                String amountPaid = info[6];
                String deadline = info[7];
                String Completion = info[8];
                String Status = info[9];

                // System will print each line which is assigned to array String info
                System.out.println("" +
                        "\nProject Number: " + projectNum +
                        "\nProjectName: " + projectName +
                        "\nBuilding Type: " + buildingType +
                        "\nPhysical Address: " + address +
                        "\nERF Number: " + erfNum +
                        "\nTotal Fee: R" + totalFee +
                        "\nAmount Paid: R" + amountPaid +
                        "\nDeadline: " + deadline +
                        "\nCompletion Date: " + Completion +
                        "\nProject Status: " + Status);
            }
        }

        catch (FileNotFoundException e)
        {  // Try-catch block used to handle errors.
            System.out.println("Error.");
        }
    }
    /**
     * Find project method runs through project info in the CurrentProjects.txt file to locate a particular
     * project object needed.
     * <p>
     * It takes in one parameter with string info related to the project and returns an integer to indicate the line
     * number of the project being located.
     * @param projectInfo either a project number or project name to identify the project object
     * @return returns an integer lineCount to indicate the line number of the project in the text file
     */
    public int findProject(String projectInfo)
    {
        String [] info; // String array declared to stored project info from each line in the external text file.
        int lineCount = 1;  // A line count set to run through the text file to find the project.

        try
        {
            File searchFile = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(searchFile);

            while (projectFile.hasNextLine())
            {  // A new file object is created and a while loop used iterate through lines in the "CurrentProjects.txt"

                info = projectFile.nextLine().split(", "); // Line info is then split and stored in the array.

                if ((info[0].equalsIgnoreCase(projectInfo)) || (info[1].equalsIgnoreCase(projectInfo)))
                {
                    break; // While loop is exited if the first or second index in the array is equal to the projectInfo parameter,
                    // i.e. the project number or project name must match that of the text file line.
                }

                else
                    {
                    lineCount++; // Line count incremented whilst match not made.
                    }
            }
        }
        catch (FileNotFoundException e)
        {  // Try-catch block used to handle errors.
            System.out.println("Error.");
        }
        return lineCount;  // Integer line count returned.
    }
}
