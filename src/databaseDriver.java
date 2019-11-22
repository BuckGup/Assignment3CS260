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
            System.out.println("Here are the rows in " + tableLoc + ":" + tableRowList);


            System.out.println("What row would you like to " + action + "?");
            rowName = userInput.nextLine();


            //TODO: This is where we generate different SQL statements based on the userInput gathered above
            if (action.equals("INSERT")) {
                //ask what they want to insert into
                //InsertStatement.callSQLInsert(tableLoc, rowName, HRID);
            } else if (action.equals("UPDATE")) {
                UpdateStatement.callSQLUpdate();

            } else if (action.equals("DELETE")) {
                DeleteStatement.callSQLDelete(tableLoc, HRID);
            }

            //--------------------------------------------------------------------------------------------------------------


        }


    }


}
