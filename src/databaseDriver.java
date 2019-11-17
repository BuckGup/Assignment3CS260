import java.io.*;
import java.util.Scanner;


public class databaseDriver {
    public static void main(String args[]) {


        Scanner userInput = new Scanner(System.in);
        String action;
        String tableLoc;
        String rowName;

        System.out.println("What action do you want to take? (INSERT, UPDATE, or DELETE)");     //assumes the user inputs one of these values
        action = userInput.nextLine();

        System.out.println("What table do you want to " + action + "?");
        tableLoc = userInput.nextLine();

        //TODO Gather all of the row titles in the tableLoc table from SQL
        //Prompt user with list of all the rows in tableLoc
        System.out.println("Here are the rows in " + tableLoc +
                            ": \n-----------------\n"
                            // + all rows in the table
                            + "-----------------");

        System.out.println("What row would you like to " + action + "?");
        rowName = userInput.nextLine();



        //TODO: This is where we generate different SQL statements based on the userInput gathered above
        if (action.equals("INSERT")) {
            //INSERT INTO ExampleTable
            //VALUES(rowName, etc.)
            //WHERE
        } else if (action.equals("UPDATE")) {
            //UPDATE ExampleTable
            //SET ExampleColumn = 'ExampleValue'
            //WHERE _____
        } else if (action.equals("DELETE")) {
            //
        }



    }

/** TODO: Pseucode!
 * Gather all of the row titles in the tableLoc table
 * Figure out a way to deal with HRID
 *      --What does this mean? How do we use this and manipulate the data in both the HR table and the specified table
 *
 */



    /**
     * readEntry - read input string from console (no GUI)
     * Creation date: (10/7/2002 10:55:56 AM)

    public static String readEntry(String prompt)
    {
        try
        {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while (c != '\n' && c != -1)    // while not newline or EOF
            {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        }
        catch (IOException e)
        {
            return "";
        }
    }     // --- end - readEntry method

*/

}
