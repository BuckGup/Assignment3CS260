import java.util.Scanner;
import java.io.*;
import java.sql.*;

/**
 *The databaseDriver class contains the main method, which does most of the printing to the terminal and user interface
 */
public class databaseDriver {

    /**
     * The main method prints to the console and gathers information to send to the 3 "action" classes
     */
    public static void main(String args[]) {
        Delete DeleteStatement = new Delete();  //instantiating Delete class
        Insert InsertStatement = new Insert();  //instantiating Insert class
        Update UpdateStatement = new Update();  //instantiating Update class
        HRIDMax hridMax = new HRIDMax();        //variable used to find the largest current HRID in HumResource

        Scanner userInput = new Scanner(System.in); //creates a Scanner instance to read information from the console
        String action;      //one of the 3 actions available to the user (INSERT, UPDATE, or DELETE)
        String tableLoc;    //the name of the table in which actions are being taken (FOOD, WATER, or MEDICALCENTER)
        int HRID = 1009;    //starts HRID at the highest starting value + 1


        while (true) {      //continue looping the prompts until the user types "exit" at an appropriate time

            System.out.println("What action do you want to take? (INSERT, UPDATE, or DELETE)" +
                    "\nor type \"EXIT\" to exit the program");     //assumes the user inputs one of these values

            action = userInput.nextLine().toUpperCase();        //grabs the input from the user and stores it

            if (action.equalsIgnoreCase("EXIT")) {
                return;     //causes the while loop to end, ending the program
            }

            System.out.println("In which table do you want to " + action + "? (Food, Water, MedicalCenter)");
            tableLoc = userInput.nextLine().toUpperCase();


            /**
             * This is where we generate different SQL insert, update, and delete values based on userInput.
             * In each case, we need to account for 3 separate individual cases (Food, Water, MedicalCenter).
             * This accounts for a total of 9 innermost if loops, or 3 sets of 3.
             */
            if (action.equals("INSERT")) {      //---------------------------------------------------------------------------------INSERT---------------------------------
                String insertValues = "";

                insertValues += HRID;       //the first value in insertValues is HRID


                if (tableLoc.equals("MEDICALCENTER")) {
                    int NumBeds;                //stores user input
                    int EmergencyRoomCapacity;  //stores user input
                    int NumDoctors;             //stores user input
                    int NumNurses;              //stores user input

                    System.out.println("Insert NumBeds (int):");
                    NumBeds = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert EmergencyRoomCapacity (int):");
                    EmergencyRoomCapacity = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert NumDoctors (int):");
                    NumDoctors = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert NumNurses (int):");
                    NumNurses = userInput.nextInt();
                    userInput.nextLine();

                    //make insertValues a list separated by commas
                    insertValues += ", " + NumBeds + ", " + EmergencyRoomCapacity + ", " + NumDoctors + ", " + NumNurses;

                } else if (tableLoc.equals("FOOD")) {
                    String FType;           //stores user input
                    int FMealsAvailable;    //stores user input
                    String FSpecificDesc;   //stores user input

                    System.out.println("Insert FType (String):");
                    FType = userInput.nextLine();

                    System.out.println("Insert FMealsAvailable (int):");
                    FMealsAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert FSpecificDesc (String):");
                    FSpecificDesc = userInput.nextLine();

                    //make insertValues a list separated by commas
                    insertValues += ", '" + FType + "', " + FMealsAvailable + ", '" + FSpecificDesc + "'";

                } else if (tableLoc.equals("WATER")) {
                    int Num10OzBottlesAvailable;        //stores user input
                    int NumHalfLiterBottlesAvailable;   //stores user input
                    int Num5GallonJugsAvailable;        //stores user input

                    System.out.println("Insert Num10OzBottlesAvailable (int):");
                    Num10OzBottlesAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert NumHalfLiterBottlesAvailable (int):");
                    NumHalfLiterBottlesAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Insert Num5GallonJugsAvailable (int):");
                    Num5GallonJugsAvailable = userInput.nextInt();

                    //make insertValues a list separated by commas
                    insertValues += ", " + Num10OzBottlesAvailable + ", " + NumHalfLiterBottlesAvailable + ", " + Num5GallonJugsAvailable;
                }


                //Call a method in Insert class with the proper parameters
                InsertStatement.callSQLInsert(tableLoc, insertValues, HRID);

            } else if (action.equals("UPDATE")) { //---------------------------------------------------------------------------------UPDATE-------------------------------
                String updateValues = "";       //stores values, used to concatenate all the data into one string
                System.out.println("Which HRID row in " + tableLoc + " do you want to update?");
                HRID = userInput.nextInt();
                userInput.nextLine();

                //TODO: give the user a table to view of the possible rows to update (??)

                if (tableLoc.equals("MEDICALCENTER")) {
                    int NumBeds;                //number of beds, stores user input
                    int EmergencyRoomCapacity;  //capacity, stores user input
                    int NumDoctors;             //number of doctors, stores user input
                    int NumNurses;              //number of nurses, stores user input

                    //Prompt the user for the necessary values and store their responses
                    System.out.println("Update value for NumBeds (int):");
                    NumBeds = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for EmergencyRoomCapacity (int):");
                    EmergencyRoomCapacity = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for NumDoctors (int):");
                    NumDoctors = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for NumNurses (int):");
                    NumNurses = userInput.nextInt();
                    userInput.nextLine();

                    updateValues = NumBeds + " " + EmergencyRoomCapacity + " " + NumDoctors + " " + NumNurses;

                } else if (tableLoc.equals("FOOD")) {
                    String FType;           //stores user input
                    int FMealsAvailable;    //stores user input
                    String FSpecificDesc;   //stores user input


                    System.out.println("Update value for FType (String):");
                    FType = userInput.nextLine();

                    System.out.println("Update value for FMealsAvailable (int):");
                    FMealsAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for FSpecificDesc (String):");
                    FSpecificDesc = userInput.nextLine();

                    updateValues = FType + " " + FMealsAvailable + " " + FSpecificDesc;


                } else if (tableLoc.equals("WATER")) {
                    int Num10OzBottlesAvailable;
                    int NumHalfLiterBottlesAvailable;
                    int Num5GallonJugsAvailable;

                    System.out.println("Update value for Num10OzBottlesAvailable (int):");
                    Num10OzBottlesAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for NumHalfLiterBottlesAvailable (int):");
                    NumHalfLiterBottlesAvailable = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Update value for Num5GallonJugsAvailable (int):");
                    Num5GallonJugsAvailable = userInput.nextInt();
                    userInput.nextLine();

                    updateValues = Num10OzBottlesAvailable + " " + NumHalfLiterBottlesAvailable + " " + Num5GallonJugsAvailable;

                }


                //Call a method in Update class with the proper parameters
                UpdateStatement.callSQLUpdate(tableLoc, updateValues, HRID);

            } else if (action.equals("DELETE")) {   //------------------------------------------------------------------------------DELETE--------------------------------
                //show all the HRID available?
                int deleteHRID;             //stores user input for which HRID to delete from the table
                System.out.println("What HRID do you want to delete?");
                deleteHRID = userInput.nextInt();
                userInput.nextLine();


                //Call a method in Delete class with the proper parameters
                DeleteStatement.callSQLDelete(tableLoc, deleteHRID);
            }
            HRID++;
        }
    }
}
