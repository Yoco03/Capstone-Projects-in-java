package poisedPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FinaliseProject
{
    /**
     * Project Management System for Poised.
     * FinaliseProject class for finaliseProject() method
     * Will generating an invoice, if requirements are met
     * and marking the project as finalised
     * by adding a completion date to the project info.
     * <p>
     * From the CurrentProjects.txt file, will determine whether an invoice must be generated
     * After that it will mark project as finalised and adds a completion date.
     * Finalised project will be stored in a new text file called CompletedProjects.txt.
     * @param lineCount integer lineCount determined by the findProject method.
     * @author Yorick Cockrell
     */
    public static void finaliseProject(int lineCount)
    {
        // We will use ArrayList to store each line / project from the text file out of current projects.
        // We will use String array to store elements from a split line in the array.
        // A findLine integer variable is set to match the lineCount for the specified file.
        ArrayList<String> infoArray = new ArrayList<String>();
        String[] info = new String[10];
        int findLine = 1;

        // A file object (projects) is created.
        // A while loop is used to run through each line of the text file by calling hasNextLine() .
        // Each line of project information is added to the ArrayList.
        // Reason why we do this is because when one project is updated, that line of info can be replaced in the array.
        // The updated array can then be re-written to the CurrentProjects.txt file.
        try
        {
            File projects = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(projects);

            while (projectFile.hasNextLine())
            {
                infoArray.add(projectFile.nextLine());
            }

        }

        catch (FileNotFoundException e)
        {
            System.out.println("Error.");
        }

        // We will use try-catch block to handle errors if file is not found.
        // Each line of the text will iterate through the text file until text is found,
        // example: 'lineCount' needs to be equal to 'findLine' variable,
        // When line info is found then info is split.
        // Otherwise error from the try-catch block.
        // That specific split line info is then stored in the info string array.

        try
        {
            File projects = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(projects);

            while (projectFile.hasNextLine())
            {
                if (findLine == lineCount)
                {
                    info = projectFile.nextLine().split(", ");
                }

                else
                    {
                    findLine++;   // Line count incremented if match is not made.
                    }
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("Error.");
        }

        // Will then assign each split element from each index to a new variable.
        // These variables describe project info.

        String projectNum = info[0];
        String projectName = info[1];
        String buildingType = info[2];
        String address = info[3];
        String erfNum = info[4];
        String deadline = info[7];
        String Completion;
        String Status = "Finalised";  // Status of project set to 'finalised'.

        // The totalFee and amountPaid indexed variables are parsed for comparison if invoice must be generated or not.
        double totalFee = Double.parseDouble(info[5]);
        double amountPaid = Double.parseDouble(info[6]);

        // If the project has been paid in full, no invoice is generated
        // when 'totalFee' is equal to 'amountPaid'.
        // The user will be asked to enter completion date for the project.
        // A Check will be checked calling the methode stringInput in InputChecks superclass / Parent class
        // to see if data type is correct other wise your parameter for returnType will be passed in.

        if (totalFee == amountPaid )
        {
            System.out.println("The project has been paid in full. No invoice generated.");
            System.out.println("Please add a completion date for this project (e.g. day, month, year, 3 December 2020): ");

            Completion = InputChecks.stringInput("completion date");

            // If amount is outstanding, the user will be asked to enter customer details to generate an invoice.
            // The user will be asked to enter completion date for the project.
        }

        else
            {
            System.out.println("Your invoice will be generated: ");
            System.out.println("\nPlease enter customer's full name: ");

            String customer = InputChecks.stringInput("customer's full name");
            String personType2 = "Customer";

            System.out.println("\nPlease enter customer's contact number: ");
            int number2 = InputChecks.intInput("customer's contact number");

            System.out.println("\nPlease enter customer's email address: ");
            String email2 = InputChecks.stringInput("customer's email address");

            System.out.println("\nPlease enter customer's physical address: ");
            String address2 = InputChecks.stringInput("customer's physical address");

            System.out.println("Please add a completion date for this project (e.g. day, month, year, 3 December 2020): ");
            Completion = InputChecks.stringInput("completion date");

            // A new person object is created with the gathered info.
            // This object is then displayed to the user with the DisplayPerson() method.
            NewPerson customer1 = new NewPerson(personType2, customer, number2, email2, address2);

            System.out.println("\nPlease view your invoice details below: ");
            System.out.println(customer1.ViewPerson());
            System.out.println("\nAmount still owed: R" + (totalFee - amountPaid) + "\n");
            }

        // Finalised project details also displayed to the user in a clear format.
        System.out.println("Finalised Project Details: " +
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

        infoArray.remove(lineCount-1);  // This methode from ArrayList will remove project from current project and
        // update infoArray which will then write to the CurrentProjects.txt file.

        try
        {
            Formatter F = new Formatter("CurrentProjects.txt");

            for (String element : infoArray)
            {
                F.format("%s", element + "\r\n");
            }

            System.out.println("Project successfully finalised.");  // Successful message displayed.
            F.close();

        }

        catch (Exception e)
        {
            System.out.println("Error.");  // try-catch block for errors.
        }
        String projectComplete =
                projectNum + ", "
                + projectName + ", "
                + buildingType + ", "
                + address + ", "
                + erfNum + ", "
                + totalFee + ", "
                + amountPaid + ", "
                + deadline + ", "
                + Completion + ", "
                + Status;

        // File is created to store the completed / finalised projects, if it does not already exist.
        // Will check if file exists
        try
        {
            File newFile = new File("CompletedProjects.txt");

            if (newFile.createNewFile())
            {
                System.out.println("File created: " + newFile.getName());
            }

            else
                {
                System.out.println("File already exists.");
                }

        }

        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // After that, the string of project completed info is written to the CompletedProjects.txt file in append mode.

        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter("CompletedProjects.txt", true));  // Please specify the file path for your desired output.
            out.write(projectComplete + " \r\n");
            out.close();
            System.out.println("Project successfully finalised.");  // Successful message displayed.
        }

        catch (IOException e)
        {
            System.out.println("Error occurred" + e);
        }
    }
}
