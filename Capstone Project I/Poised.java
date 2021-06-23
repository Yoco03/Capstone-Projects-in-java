package Poised;

import java.util.Objects;
import java.util.Scanner;
import java.util.Objects;
import java.util.Scanner;

import static Poised.contractorProject.*; //import class contractorProject to use external class
    // Attributes
public class Poised {
        String projectNumber;
        String projectName;
        String building;
        String address;
        int eftNum;
        double totalFee;
        double totalAmount;
        String deadline;

        // Methods Constructor
        public poised(String projectNumber, String projectName, String building, String address,
                      int eftNum, double totalFee, double totalAmount, String deadline)
        {
            this.projectNumber = projectNumber;
            this.projectName = projectName;
            this.building = building;
            this.address = address;
            this.eftNum = eftNum;
            this.totalFee = totalFee;
            this.totalAmount = totalAmount;
            this.deadline = deadline;


            //methode toString()
            public String toString ()
            {
                String output = "Project number: " + projectNumber;
                output += "\nProject name:" + projectName;
                output += "\nWhat type of building is being designed? \n E.g. House, apartment block or" +
                        "store, etc:" + building;
                output += "\nERF number:" + eftNum;
                output += "\nThe total fee being charged for the project:" + totalFee;
                output += "\nThe total amount paid to date:" + totalAmount;
                output += "\nDeadline for the project:" + deadline;

                return output;
            }

            public static void newProject () //methode newProject()
            {
                Scanner input = new Scanner(System.in);

                System.out.println("Enter Project number: ");
                String projectNumber = input.nextLine();

                System.out.println("Enter Project name: ");
                String projectName = input.nextLine();

                System.out.println("Enter type of building is being designed?: E.g. House, apartment block or store, ect: ");
                String building = input.nextLine();

                System.out.println("Please enter address: ");
                String address = input.nextLine();

                System.out.println("Please enter your EFT number: ");
                int eftNum = input.nextInt();

                System.out.println("Enter The total fee being charged for the project: ");
                double totalFee = input.nextDouble();

                System.out.println("Enter The total amount paid to date: ");
                double totalAmount = input.nextDouble();

                System.out.println("Deadline for the project: ");
                String deadline = input.nextLine();

                System.out.println("\nYour new project is: \n");
                Poised project = new Poised(projectNumber, projectName, building, address, eftNum, totalFee, totalAmount, deadline);
                System.out.println(project.toString());

            }
            public static void MainMenu ()

            {
                Scanner input = new Scanner(System.in);
                // Menu for Project
                System.out.println("Choose from these choices\n" +
                        "-------------------------\n" +
                        "1 - Create new Project\n" +
                        "2 - Create new Person: \n" +
                        "3 - Change deadline in Project\n" +
                        "4 - Change total amount paid to date in Project\n" +
                        "5 - Finalise project\n" +
                        "6 - Quit");
                // if else input statement for "inputMenu"
                int inputMenu = input.nextInt();
            }

            public static void getdeadline () //methode getdeadline()
            {
                Scanner input = new Scanner(System.in);
                System.out.print("Please change deadline");
                String inputdeadline = input.next();

            }

            public static void getTotalAmount () //methode getTotalAmount()
            {
                Scanner inputAmount = new Scanner(System.in);
                System.out.print("Please change total amount of the fee paid to date.");
                String total = inputAmount.nextLine();

            }
            public static void getfinalize () //methode getTotalAmount()
            {

                Scanner input = new Scanner(System.in);
                System.out.print("Is project finalize Yes or No answer?: ");
                String Pfinal = input.nextLine();
                // import "import java.util.Objects;"
                if (Objects.equals(Pfinal, "Yes"))
                    System.out.print("Complete");
                else
                    System.out.print("Incomplete");
            }
        }
    }
