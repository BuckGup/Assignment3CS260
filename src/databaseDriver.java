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
        int HRID = 0;

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


            //TODO: This is where we generate different SQL statements based on the userInput gathered above
            if (action.equals("INSERT")) {
                //TODO: make HRID a user input, so they can insert an HRID (also check the Insert class to implement HRID)
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
