package poisedPackage;

import java.util.Scanner;

/**
 * Project Management System for Poised.
 * InputChecks is an superclass for the Poised project management program.
 * <p>
 * InputCheck class has three check methods for different user inputs.
 * intInput(), stringInput(), doubleInput()
 * These methods are inherited by the three subclasses.
 * We use this methode to check each input value of the Scanner class.
 * subclass: ExistingProjects, NewProject, MainMenu
 * @author Yorick Cockrell
 */
public class InputChecks
{  // Main class
    /**
     * InputChecks class of 'stringInput()' methode check user input when asked to enter an word or letters.
     * @param returnType returnType describes the input required for the user to enter
     * @return returns the verified user input
     */
    public static String stringInput(String returnType)
    {
        while(true)
        {  // While loop will iterate through until correct data type is entered.
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();

            if ((input == null) || (input.length() > 120))
            {  // checking for correct input that is default "null" or length bigger then 120 letters / char values
                System.out.println("Please re-enter the " + returnType + ": \n");

            }

            else
                {
                return input;  // Returning the user's correctly inputed string.
                }
        }
    }

    /**
     * InputChecks class of 'intInput()' methode check user input when asked to enter an number / integer.
     * @param returnType returnType describes the input required for the user to enter
     * @return returns the verified output integer
     */
    public static int intInput(String returnType)
    {

        while(true)
        {  // While loop will iterate through until correct data type is entered.
            Scanner numInput = new Scanner(System.in);
            String num = numInput.nextLine();

            try
            {
                int output = Integer.parseInt(num);  // checking for correct input that is parse for Int
                return output;
            }

            catch (NumberFormatException ex)
            {
                System.out.println("Please re-enter the " + returnType + ": \n");  // Error message displayed.
            }
        }
    }

    /**
     * InputChecks class of 'doubleInput()' methode check user input when asked to enter an double, number, decimal number or integer.
     * @param returnType returnType describes the input required for the user to enter
     * @return returns the verified output double
     */
    public static double doubleInput(String returnType)
    {

        while(true)
        {  // While loop will iterate through until correct data type is entered.
            Scanner doubleInput = new Scanner(System.in);
            String number = doubleInput.nextLine();

            try
            {
                double output = Double.parseDouble(number);  // checking for correct input that is parse for double
                return output;
            }

            catch (NumberFormatException ex)
            {
                System.out.println("Incorrect entry. Please re-enter the " + returnType + ": \n");  // Error message displayed if parsing is not possible.
            }
        }
    }
}
