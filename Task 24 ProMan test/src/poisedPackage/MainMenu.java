package poisedPackage;

//Project manger Task 24 for Poised - Capstone Project III.
// You will need two text files to run this program: 'CurrentProjects.txt' and 'CompletedProjects.txt'.

import java.util.Scanner;
import java.text.ParseException;
import java.io.*;

/**
 * Project Management System for Poised.
 * This is the MainMenu class and runs the main program method and calls other methods from the
 * NewProject, NewPerson and ExistingProjects classes.
 * It displays a main menu to the user with options for the Poised Management System.
 * <p>
 * MainMenu is a subclass that inherits methods from the InputCheck superclass.
 * @author Yorick Cockrell
 */

public class MainMenu extends InputChecks
{  // Class declaration.
    /**
     * This is the main method which runs the Poised Management System program.
     * <p>
     * @param args java command line arguments
     * @throws ParseException occurs if a date string is in the wrong format to be parsed
     */
    public static void main(String[] args) throws ParseException
    {  // Main method declaration.

        /* Will display a project management message
         * if text file 'CurrentProjects.txt.' was not yet created then the program will create the file
         * to store the project info, if it does not exist already.
         */

        System.out.println("Project Management System for Poised\n");

        try
        {
            File newFile = new File("CurrentProjects.txt");

            if (newFile.createNewFile())
            {
                System.out.println("File created: " + newFile.getName());
            }

            else
                {
                System.out.println(" Text file present.");
                }
        }

        catch (IOException e)
        {
            System.out.println("An error with file occurred.");
            e.printStackTrace();
        }

        /* Main menu is then displayed.
         * The methode 'fileCheck()' will start to determine if there are existing projects and,
         * if not 'fileCheck()' will ask the user
         * to choose option '2' to create a new project object.
         * Only if a project exist as an text file then only can the user use option 1 to view projects.
         * Here we will use methods from the the classes we created
         * NewProject, NewPerson, ExistingProjects,(UpdateProject,FinaliseProject,DateCheck,InputChecks)
         * each class will be called depends on user selection.
         * each option that is selected will return to the main menu when methode is completed.
         * unless user select option 8 which will exit the program.
         */

        while (true)
        {
            System.out.println("\nPlease enter a number from 1 - 8 to access the menu list below: "
                    + "\n1. View Projects"
                    + "\n2. Add a New Project"
                    + "\n3. Update Existing Project "
                    + "\n4. Finalize a Project"
                    + "\n5. View Incomplete Projects"
                    + "\n6. View Overdue Projects"
                    + "\n7. Find a Project"
                    + "\n8. Exit program");

            int selectNum = intInput("menu choice");
            // When option is selected then
            // selection will call 'intInput()' from the InputChecks class methode to check if value is correct
            // if not returnType will pass value into parameter of 'intInput()' from the InputChecks class
            // and display a message to retype entry.
            boolean projects = fileSearch();
            // projects is the variable that checks the methode fileSearch() in the MainMenu class
            // if the project is true or false

            if ((projects == false) && ((selectNum == 1) || (selectNum == 3) || (selectNum == 4) || (selectNum == 5)
                    || (selectNum == 6) || (selectNum == 7) ))
            {
                System.out.println("There are no existing projects. \nPlease choose option '2' from the menu to add a new project.");
            }

            else if ((projects == true) && (selectNum == 1))
            {  // Option 1 will view projects.
                ExistingProjects view = new ExistingProjects();
                view.viewProjects(); //view access methode viewProjects() from class ExistingProjects
            }

            else if (selectNum == 2)
            {  // Option 2 will add a new project.
                NewProject addNew = new NewProject();
                addNew.addProject(); //addNew access methode addProject() from class NewProject
            }

            else if ((projects == true) && (selectNum == 3))
            {
                // Option 3 will edit a project in current projects.
                // By displaying option 3 submenu first to enter project name or number
                // After entering a valid value for 'enterEditNum'
                // display edit due date or amount paid by selecting 1 or 2
                // 'findUpdateProject' will access methode findProject in class ExistingProjects
                // Once project found 'findUpdateProject' access updateProject(with parameters)

                System.out.println("Please enter the project number or name of the project you want to update: \n");
                String projectInfo = stringInput("project number");
                System.out.println("Would you like to:" +
                        "\n1. Edit the project due date or" + // edit due date
                        "\n2. Edit the total amount paid of the fee to date?" +  // Edit .
                        "\nChoose 1 or 2");

                int enterEditNum = intInput("edit choice");
                ExistingProjects findUpdateProject = new ExistingProjects();
                int lineCount = findUpdateProject.findProject(projectInfo);
                UpdateProject.updateProject(enterEditNum, lineCount);  // findProject() and updateProject() methods called on from ExistingProjects class.
            }

            else if ((projects == true) &&  (selectNum == 4))
            {
                // Option 4 will finalise a project.
                // Finalised projects are stored in a new text file 'CompletedProjects.txt'.

                System.out.println("Please enter the project number or name of the project you want to finalise: \n");
                String projectInfo = stringInput("project name or number"); //same occurs statement in "menu choice"
                ExistingProjects obj2 = new ExistingProjects();
                int lineCount = obj2.findProject(projectInfo);
                FinaliseProject.finaliseProject(lineCount);
            }

            else if ((projects == true) && (selectNum == 5))
            {
                // Option 5 will view incomplete projects in class DateCheck.
                DateCheck viewIncompleteProjects = new DateCheck();
                DateCheck.dateCheck("incomplete");
            }

            else if ((projects == true) && (selectNum == 6))
            {
                // Option 6 will view overdue projects in class DateCheck.
                DateCheck viewOverdueProjects = new DateCheck();
                DateCheck.dateCheck("overdue");
            }

            else if ((projects == true) && (selectNum == 7))
            {
                // Option 7 allows the user to find a project to view.
                // 'projectInfo' is the input value for data type String
                // 'findCurrentProject' will call 'findProject()' methode in ExistingProjects class.

                System.out.println("Please enter the name or project number of the project you want to find: ");
                String projectInfo = stringInput("project name OR number");
                ExistingProjects findCurrentProject = new ExistingProjects();
                int lineCount = findCurrentProject.findProject(projectInfo);  // This method returns a line count integer for the project.

                String[] info = new String[10];  // Setting a string array to store info from the project's line in the text file.
                int findLine = 0;  // Setting an integer variable to match the returned line count value.

                try
                {
                    File searchFile = new File("CurrentProjects.txt");
                    Scanner projectFile = new Scanner(searchFile);

                    while (projectFile.hasNextLine())
                    {  // Searching for the correct project in the file by line count.

                        if (findLine == lineCount)
                        {
                            info = projectFile.nextLine().split(", ");  // Storing the correct line info into the array.

                        }

                        else
                            {
                            findLine++;
                            }
                    }

                }

                catch (FileNotFoundException e)
                {
                    System.out.println("Error.");
                }

                // Now storing each element of the built array into separate variables.
                // These will be used to display project information.
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

                // Project information displayed in clear format.
                System.out.println("\nProject Number: " + projectNum + "\nProjectName: " + projectName
                        + "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNum + "\nTotal Fee: R"
                        + totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);

            }

            else if (selectNum == 8)
            { // Option 8 allows the user to exit the program.
                System.out.println("Successfully exit the program.");  // Successful logout message displayed.
                break;
            }
        }
    }
    /**
     * The fileSearch method is run to check for existing projects in the CurrentProjects.txt file.
     * <p>
     * It guides the user's menu choices, depending on whether there are existing projects in the text file.
     * @return returns the boolean value for projectCheck
     */
    public static boolean fileSearch()
    {

        boolean projectCheck = false;  // Setting boolean value to check the file contents.

        try
        {
            File projects = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(projects);

            if (projectFile.hasNextLine())
            {  // If the file contains contents for a project, projectCheck is 'true'.
                projectCheck = true;

            }

            else
                {
                projectCheck = false;  // If the file does not contain projects, projectCheck is 'false'.
                }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("Error.");
        }
        return projectCheck;  // boolean value returned.
    }
}
