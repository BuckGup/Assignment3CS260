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




            //System.out.println("What column would you like to " + action + "?");    //TODO: This prompt needs to be different depending on which action they take
            //rowName = userInput.nextLine();


            //This is where we generate different SQL insert values based on userInput
            if (action.equals("INSERT")) {
                String insertValues = "";


                //TODO make a method that finds the highest HRID value in HumResource
                    //Connect to the database
                    //SELECT max HRID from HumResource
                    //set the variable HRID = (that number + 1)
                System.out.println("For now, insert a HRID to use in the table:");
                HRID = userInput.nextInt();
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


                //Call a method in Insert class with the proper parameters
                InsertStatement.callSQLInsert(tableLoc, insertValues, HRID);

            } else if (action.equals("UPDATE")) {
                String updateValues = "";


                //Call a method in Update class with the proper parameters
                UpdateStatement.callSQLUpdate(tableLoc, updateValues, HRID);

            } else if (action.equals("DELETE")) {



                //Call a method in Delete class with the proper parameters
                DeleteStatement.callSQLDelete(tableLoc, HRID);
            }

            //--------------------------------------------------------------------------------------------------------------

        }

    }

}
