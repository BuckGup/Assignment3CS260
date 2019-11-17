import java.io.*;
import java.util.Scanner;


public class databaseDriver {
    public static void main(String args[]) {
        System.out.println("hello world \nI wanna die");



        Scanner userInput = new Scanner(System.in);
        String action;
        String tableLoc;

        System.out.println("What action do you want to take? (INSERT, UPDATE, or DELETE)");     //assumes the user inputs one of these values
        action = userInput.nextLine();

        System.out.println("What table do you want to " + action + "?");
        tableLoc = userInput.nextLine();

        if (action.equals("INSERT")) {

        } else if (action.equals("UPDATE")) {

        } else if (action.equals("DELETE")) {

        }



    }





    /**
     * readEntry - read input string from console (no GUI)
     * Creation date: (10/7/2002 10:55:56 AM)
     */
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


}
