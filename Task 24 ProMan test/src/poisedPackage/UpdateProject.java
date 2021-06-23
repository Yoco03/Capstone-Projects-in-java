package poisedPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class UpdateProject
{
    /**
     * Project Management System for Poised.
     * The UpdateProject class for 'updateProject()' method is used to edit project information.
     * By entering / selecting project object number or name in CurrentProjects.txt file.
     * <p>
     * From the MainMenu class your input value will pass in (int enterEditNum = intInput("edit choice");) which will check from
     * superclass InputChecks if value is correct after that
     * (updateProject(int editChoice, int lineCount) method from UpdateProject class
     * will locate a project and update the selected information based on the option you entered.
     * @param editChoice integer choice made by the user in the main menu (either 1 or 2)
     * @param lineCount integer lineCount returned by the findProject function to locate the project
     * @author Yorick Cockrell
     */
    public static void updateProject(int editChoice, int lineCount)
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
                infoArray.add(projectFile.nextLine());  // Each line added to the infoArray.

            }

        }

        catch (FileNotFoundException e)
        {  // try-catch block for errors.
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

                else if (findLine != lineCount)
                {  // Line count incremented if match is not made.
                    findLine++;
                }
            }

        }

        catch (FileNotFoundException e)
        {
            System.out.println("Error.");
        }

        /* When user enter '1' to edit date they will be granted to input a new date.
         * Index number 7 will be updated in the info array for that project,
         * Updating your previous information with new information.
         * Info array will convert into a string, with extra characters removed (i.e. '[' trailing characters).
         * The finalised string 'newLine' is then inserted into the correct index of the infoArray ArrayList (i.e. lineCount -1).
         * The same for entry '2' to edit new total amount in index number 6 which is replaced at index 6 in the info array.
         */
        if (editChoice == 1)
        {
            System.out.println("Please enter a new project due date in this format dd/mm/yy (e.g. dd/mm/yy: 3 November 2020): ");
            String newDeadline = InputChecks.stringInput("due date");
            info[7] = newDeadline;
            String newInfo = Arrays.toString(info);
            String changeLine = newInfo.replace("[", "");
            String newLine = changeLine.replace("]", "");
            infoArray.set(lineCount-1, newLine);
        }

        else if (editChoice == 2)
        {
            System.out.println("Please enter a new total amount of the fee paid to date:");
            double newAmount = InputChecks.doubleInput("new total amount");
            info[6] = Double.toString(newAmount);
            String newInfo = Arrays.toString(info);
            String changeLine = newInfo.replace("[", "");
            String newLine = changeLine.replace("]", "");
            infoArray.set(lineCount-1, newLine);
        }

        // Each element, or line of project info, of the updated array
        // is then re-written to the CurrentProjects.txt file.
        try
        {
            Formatter F = new Formatter("CurrentProjects.txt");
            for (String element : infoArray)
            {
                F.format("%s", element + "\r\n");
            }
            System.out.println("Project successfully updated.");  // Successful message displayed.
            F.close();
        }

        catch (Exception e)
        {
            System.out.println("Error.");  // try-catch block used to handle errors.
        }
    }
}
