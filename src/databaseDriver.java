import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class databaseDriver {
//TODO add comments to all of our work before we turn it in

    private Connection conn = null;            // JDBC connection
    private ResultSet rset = null;            // result set for queries
    private int returnValue;                // return value for all other commands

    // --- connect() - connect to the Oracle database

    public static void main(String args[]) {
        Delete myDelete = new Delete();//declaration of the classes
        Insert myInsert = new Insert();
        Update myUpdate = new Update();

        Scanner userInput = new Scanner(System.in);
        String action;
        String tableLoc;
        String rowName;

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
                Insert InsertStatement = new Insert();
                InsertStatement.callSQLInsert();
            } else if (action.equals("UPDATE")) {
                Update UpdateStatement = new Update();
                UpdateStatement.callSQLUpdate();
            } else if (action.equals("DELETE")) {
                Delete DeleteStatement = new Delete();
                DeleteStatement.callSQLDelete();
            }

            //--------------------------------------------------------------------------------------------------------------


        }



    }




/** TODO: Pseudocode!
 * Gather all of the row titles in the tableLoc table
 * Figure out a way to deal with HRID
 *      --What does this mean? How do we use this and manipulate the data in both the HR table and the specified table
 *
 */


    /**
     * readEntry - read input string from console (no GUI)
     * Creation date: (10/7/2002 10:55:56 AM)
     */
    public static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while (c != '\n' && c != -1)    // while not newline or EOF
            {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }     // --- end - readEntry method

    public void commit () {
        try {
            conn.commit();
        }
        catch (SQLException sqle) {
            System.err.println("DAO, commit() - error in commit");
            System.err.println(sqle.getMessage());
        }
    }	// end - method commit()


    public void rollback () {
        try {
            conn.rollback();
        }
        catch (SQLException sqle) {
            System.err.println("DAO, rollback() - error in rollback");
            System.err.println(sqle.getMessage());
        }
    }	// end - method rollback()

    public void disconnect () {
        // --- 5) disconnect from database
        try {
            if (conn != null) {
                conn.close();
            }
            if (rset != null) {
                rset = null;
            }
        }
        catch (SQLException sqle) {
            System.err.println ("Error in closing database connection");
            System.err.println(sqle.getMessage());
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException sqlerb) {
                    conn = null;
                }
            }
            if (rset != null) {
                try {
                    rset = null;
                }
                catch (Exception e) {
                    rset = null;
                }
            }
        }
    }	// end - method disconnect


    public void setAutoCommit (boolean flag) {
        try {
            conn.setAutoCommit(flag);
        }
        catch (SQLException sqle) {
            System.err.println("DAO, setAutoCommit() - error in setting");
            System.err.println(sqle.getMessage());
        }
    }	// end - method setAutoCommit()

    public Connection connect() throws SQLException {
        // --- set the username and password
        String user = "STRECKSH8883";
        String pass = "2C43J5R9";

        // --- 1) get the Class object for the driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Could not get class object for Driver");
        }

        // --- 2) connect to database
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@alfred.cs.uwec.edu:1521:csdev", user, pass);
        } catch (SQLException sqle) {
            System.err.println("Could not make connection to database");
            throw new SQLException();
        }
        return conn;
    }    // end - method connect


}
