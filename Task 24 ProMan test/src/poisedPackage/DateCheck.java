package poisedPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateCheck
{
    /**
     * Project Management System for Poised.
     * DateCheck class for dateCheck() method will select if a project is incomplete or overdue
     * Which will displays those listed projects.
     * <p>
     * It will scan and hold either 'overdue' or 'incomplete' projectType string, searches through the project in
     * CurrentProjects.txt file, and view a list of overdue or complete projects.
     * @param projectType string type to specify projects listed (either 'overdue' or incomplete')
     * @throws ParseException If a date string is in the wrong format to be parsed
     * @author Yorick Cockrell
     */
    public static void dateCheck(String projectType) throws ParseException
    {
        /* First String array is created to store project info from split lines in the CurrentProjects.txt file.
         * Then we use a integer array to store numbers 1 to 12, which scan the number of months in the year.
         * Then we use our second String array is created to store months of the year to get date information on a project.
         * An integer 'monthNum' is set to 0.
         */

        int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] monthsofYear = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int monthNum = 0;

        /* A try-catch block is used to scan through 'CurrentProjects.txt'.
         * Each line of the String array for variable 'info' is split by (", ") when found.
         * Then we will further split variable 'info' from index 7 (String deadline = info[7];)
         * as String[] dateInfo = deadline.split(" ");
         * So that we can get specific date e.g 3 December 2021.
         * Our first index from String array variable 'dateInfo' (dateInfo[0]) is stored and parse into a 'day' integer variable.
         * Our second index from String array variable 'dateInfo' (dateInfo[1]) is stored into a 'monthInfo' String variable.
         * A string 'month' is set using the first three letters of dateInfo[1], which would be the full month name e.g. 'December'.
         * Our third index from String array variable 'dateInfo' (dateInfo[2]) is stored into a 'year' integer variable.
         */

        try
        {
            File projects = new File("CurrentProjects.txt");
            Scanner projectFile = new Scanner(projects);

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
                String Completion = info[8];
                String finalise = info[9];
                String deadline = info[7];
                String[] dateInfo = deadline.split(" ");
                int day = Integer.parseInt(dateInfo[0]);
                String monthInfo = dateInfo[1];
                String month = (monthInfo.substring(0,2));
                int year = Integer.parseInt(dateInfo[2]);

                /* We then use a for loop
                 * which compare the substring variable 'month' with variable 'monthsofYear' string array.
                 * If it does equal to each other with an abbreviated month of the year,
                 * the corresponding number from the integer array 'months'
                 * is stored in the 'monthNum' variable, for use as date info.
                 */
                for (int index = 0; index < monthsofYear.length ; index++)
                {
                    if (month.equalsIgnoreCase(monthsofYear[index]))
                    {
                        monthNum = months[index];
                    }
                }
                String current = "" + java.time.LocalDate.now();  // Getting the current date and storing it as a string.

                // Creating a object 'date' as pattern ('yyyy-MM-dd') format.
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

                // the variable we create for 'd1' in object 'date'
                // Where 'date' will call the method parse and insert parameter for variable 'current'
                // To get current date
                // We the use variable 'd2'
                // with 'd2' we use the format we can assign our variables from the object we created from 'date'.
                // and date info gathered from the file above.

                Date d1 = date.parse(current);
                Date d2 = date.parse(day + "-" + monthNum + "-" + year);

                // Setting a string to view project details.
                String projectDetails =
                        "\nProject Number: " + projectNum +
                        "\nProjectName: " + projectName +
                        "\nBuilding Type: " + buildingType +
                        "\nPhysical Address: " + address +
                        "\nERF Number: " + erfNum +
                        "\nTotal Fee: R" + totalFee +
                        "\nAmount Paid: R" + amountPaid +
                        "\nDeadline: " + deadline +
                        "\nCompletion Date: " + Completion +
                        "\nProject Status: " + finalise;

                // If the current date is before the deadline date and the user has chosen to view 'incomplete' projects,
                // Those specific projects from each line of the text file are viewed
                if ((d1.compareTo(d2) > 0) && (projectType.equalsIgnoreCase("incomplete")))
                {
                    System.out.println(projectDetails);

                    // Otherwise, if the current date is past the deadline and the user has chosen to view 'overdue' projects,
                    // Those specific projects from each line of the text file are displayed.
                }

                else if ((d1.compareTo(d2) < 0) && (projectType.equalsIgnoreCase("overdue")))
                {
                    System.out.println(projectDetails);
                }
            }
        }

        catch (FileNotFoundException e)
        {  // try-catch block for errors.
            System.out.println("Error.");
        }
    }
}
