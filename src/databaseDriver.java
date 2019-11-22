import java.util.Scanner;
import java.io.*;
import java.sql.*;
public class databaseDriver {

    public static void main(String args[]) {

        Delete DeleteStatement = new Delete();
        ;//declaration of the classes
        Insert InsertStatement = new Insert();
        Update UpdateStatement = new Update();

        Scanner userInput = new Scanner(System.in);
        String action;
        String tableLoc;
        String rowName;
        int HRID = 9999;

        while (true) {

            System.out.println("What action do you want to take? (INSERT, UPDATE, or DELETE)" +
                    "\nor type \"EXIT\" to exit the program");     //assumes the user inputs one of these values

            action = userInput.nextLine().toUpperCase();

            if (action.equalsIgnoreCase("EXIT")) {
                return;
            }

            System.out.println("In which table do you want to " + action + "?");
            tableLoc = userInput.nextLine().toUpperCase();


            //Prompt user with list of all the rows in tableLoc
            //TODO: Do we need to have HRID visible to the user?
            String tableRowList = "\n--------------------";
            if (tableLoc.equals("MEDICAL CENTER")) {
                tableRowList += "\nHRID";
                tableRowList += "\nNumBeds";
                tableRowList += "\nEmergencyRoomCapacity";
                tableRowList += "\nNumDoctors";
                tableRowList += "\nNumNurses";
            } else if (tableLoc.equals("FOOD")) {
                tableRowList += "\nHRID";
                tableRowList += "\nFType";
                tableRowList += "\nFMealsAvailable";
                tableRowList += "\nFSpecificDesc";
            } else if (tableLoc.equals("WATER")) {
                tableRowList += "\nHRID";
                tableRowList += "\nNum10OzBottlesAvailable";
                tableRowList += "\nNumHalfLiterBottlesAvailable";
                tableRowList += "\nNum5GallonJugsAvailable";
            }
            tableRowList += "\n--------------------";
            System.out.println("Here are the columns in " + tableLoc + ":" + tableRowList);





            System.out.println("What column would you like to " + action + "?");    //TODO: This prompt needs to be different depending on which action they take
            rowName = userInput.nextLine();


            //This is where we generate different SQL insert values based on userInput
            if (action.equals("INSERT")) {
                String insertValues = "";


                //TODO make a method that finds the highest HRID value in HumResource
                    //Connect to the database
                    //SELECT max HRID from HumResource
                    //set the variable HRID = (that number + 1)
                insertValues += HRID;


                if (tableLoc.equals("MEDICAL CENTER")) {
                    int NumBeds;
                    int EmergencyRoomCapacity;
                    int NumDoctors;
                    int NumNurses;

                    System.out.println("Insert NumBeds (int):");
                    NumBeds = userInput.nextInt();
                    System.out.println("Insert EmergencyRoomCapacity (int):");
                    EmergencyRoomCapacity = userInput.nextInt();
                    System.out.println("Insert NumDoctors (int):");
                    NumDoctors = userInput.nextInt();
                    System.out.println("Insert NumNurses (int):");
                    NumNurses = userInput.nextInt();

                    insertValues += ", " + NumBeds + ", " + EmergencyRoomCapacity + ", " + NumDoctors + ", " + NumNurses;

                } else if (tableLoc.equals("FOOD")) {
                    String FType;
                    int FMealsAvailable;
                    String FSpecificDesc;

                    System.out.println("Insert FType (String):");
                    FType = userInput.nextLine();
                    System.out.println("Insert FMealsAvailable (int):");
                    FMealsAvailable = userInput.nextInt();
                    System.out.println("Insert FSpecificDesc (String):");
                    FSpecificDesc = userInput.nextLine();

                    insertValues += ", " + FType + ", " + FMealsAvailable + ", " + FSpecificDesc;

                } else if (tableLoc.equals("WATER")) {
                    int Num10OzBottlesAvailable;
                    int NumHalfLiterBottlesAvailable;
                    int Num5GallonJugsAvailable;

                    System.out.println("Insert Num10OzBottlesAvailable (int):");
                    Num10OzBottlesAvailable = userInput.nextInt();
                    System.out.println("Insert NumHalfLiterBottlesAvailable (int):");
                    NumHalfLiterBottlesAvailable = userInput.nextInt();
                    System.out.println("Insert Num5GallonJugsAvailable (int):");
                    Num5GallonJugsAvailable = userInput.nextInt();

                    insertValues += ", " + Num10OzBottlesAvailable + ", " + NumHalfLiterBottlesAvailable + ", " + Num5GallonJugsAvailable;

                }




                InsertStatement.callSQLInsert(tableLoc, rowName, HRID);


            } else if (action.equals("UPDATE")) {
                //TODO: deal with this after we get delete and insert working!
                UpdateStatement.callSQLUpdate();


            } else if (action.equals("DELETE")) {
                //TODO: again, ask the user for variable names
                DeleteStatement.callSQLDelete(tableLoc, HRID);
            }

            //--------------------------------------------------------------------------------------------------------------

        }

    }

}
