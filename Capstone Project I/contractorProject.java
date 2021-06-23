package Poised;
import java.util.Scanner;
public class contractorProject {

        String contractName;
        int contractTelNum;
        String contractEmail;
        String contractAddress;

    // Methods Constructor
        public contractorProject(String contractName, int contractTelNum, String contractEmail, String contractAddress)
        {
            this.contractName = contractName;
            this.contractTelNum = contractTelNum;
            this.contractEmail = contractEmail;
            this.contractAddress = contractAddress;

        }
    //methode toString()
        public String toString() {
            String output = "Contract name: " + contractName;
            output += "\nContract number: " + contractTelNum;
            output += "\nContract email address " + contractEmail;
            output += "\nContract physical address:" + contractAddress;

            return output;
        }
    public static void getContractorMenu() //methode getContractorMenu() to display Menu for Person for Contractor ect...
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices\n" +
                "-------------------------\n" +
                "1 - Create new Contractor: \n"+
                "2 - Change Contractor person telephone number: \n");

        int inputMenu = input.nextInt();

        if( inputMenu == 1) { newContract(); }
        else if (inputMenu == 2) { getnumber(); }
    }
        public static void newContract() //methode newContract() to create a new contract
        {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter Contract name: ");
            String contractName = input.nextLine();
            System.out.print("Enter Contractor telephone number: ");
            int contractTelNum = input.nextInt();
            System.out.print("Enter Contractor email address: ");
            String contractEmail = input.next();
            System.out.print("Enter Contractor physical address: ");
            String contractAddress = input.next();
            System.out.print("\nThank you for creating a new Contractor person for this project\n");
            contractorProject project = new contractorProject(contractName,contractTelNum, contractEmail,contractAddress);
            System.out.println(project.toString());
        }
        public static void getnumber() //methode newContract() to change telephone number
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Please change telephone number: ");
            String getnumber = input.next();
        }
    /*public static void changeContract() //not sure if it's all contact details or just the telephone number??
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Change Contract name: ");
        String Cname = input.nextLine();
        System.out.print("Change Contractor telephone number: ");
        int Cnum = input.nextInt();
        System.out.print("Change Contractor email address: ");
        String Cemail = input.next();
        System.out.print("Change Contractor physical address: ");
        String Caddress= input.next();
        System.out.print("\nThank you for creating a new Contract person");*/

}
