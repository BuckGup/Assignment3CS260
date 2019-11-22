import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class databaseObjectAccessor {
//TODO add comments to all of our work before we turn it in

    private Connection conn = null;            // JDBC connection
    private ResultSet rset = null;            // result set for queries
    private int returnValue;                // return value for all other commands

    // --- connect() - connect to the Oracle database





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

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException sqle) {
            System.err.println("DAO, commit() - error in commit");
            System.err.println(sqle.getMessage());
        }
    }    // end - method commit()


    public void rollback() {
        try {
            conn.rollback();
        } catch (SQLException sqle) {
            System.err.println("DAO, rollback() - error in rollback");
            System.err.println(sqle.getMessage());
        }
    }    // end - method rollback()

    public void disconnect() {
        // --- 5) disconnect from database
        try {
            if (conn != null) {
                conn.close();
            }
            if (rset != null) {
                rset = null;

            }
        } catch (SQLException sqle) {
            System.err.println("Error in closing database connection");
            System.err.println(sqle.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlerb) {
                    conn = null;
                }
            }
            if (rset != null) {
                try {
                    rset = null;
                } catch (Exception e) {
                    rset = null;
                }
            }
        }
    }    // end - method disconnect


    public void setAutoCommit(boolean flag) {
        try {
            conn.setAutoCommit(flag);
        } catch (SQLException sqle) {
            System.err.println("DAO, setAutoCommit() - error in setting");
            System.err.println(sqle.getMessage());
        }
    }    // end - method setAutoCommit()


    public void connect() {
        // --- set the username and password
        String user = "STRECKSH8883";
        String pass = "2C43J5R9";

        // --- 1) get the Class object for the driver
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.println ("Could not get class object for Driver");
        }

        // --- 2) connect to database
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@alfred.cs.uwec.edu:1521:csdev",user,pass);
        }
        catch (SQLException sqle) {
            System.err.println ("Could not make connection to database");
            System.err.println(sqle.getMessage());
        }
    }	// end - method connect

    public void executeSQLQuery (String sqlQuery) {
        // --- 3a) execute SQL query
        Statement stmt = null;		// SQL statement object
        rset = null;				// initialize result set

        try	{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sqlQuery);
        }
        catch (SQLException sqle) {
            System.err.println("Could not execute SQL statement: >" + sqlQuery + "<");
            System.err.println(sqle.getMessage());
            // rollback
            rollback();
        }
    }	// end - method executeSQLQuery

    public int executeSQLNonQuery (String sqlCommand) {
        // --- 3b) execute SQL non-query command
        Statement stmt = null;		// SQL statement object
        returnValue = -1;			// initialize return value
        try	{
            stmt = conn.createStatement();
            returnValue = stmt.executeUpdate(sqlCommand);
        }
        catch (SQLException sqle) {
            System.err.println("Could not execute SQL command: >" + sqlCommand + "<");
            System.err.println("Return value: " + returnValue);
            System.err.println(sqle.getMessage());
            // rollback
            rollback();
        }
        return returnValue;
    }	// end - method executeSQLNonQuery



    public String processResultSet () {
        // --- 4) process result set, only applicable if executing an SQL SELECT statement
        ResultSetMetaData rsmd = null;		// result set metadata object
        int columnCount = -1;				// column count
        String resultString = "";			// result string

        try {
            rsmd = rset.getMetaData();

            // get number of columns from result set metadata
            columnCount = rsmd.getColumnCount();

            // row processing of result set
            while (rset.next()) {
                for (int index = 1; index <= columnCount; index++) {
                    resultString += rset.getString(index) + "  ";
                }
                resultString += "\n";
            }
        }
        catch (SQLException sqle) {
            System.err.println("Error in processing result set");
            System.err.println(sqle.getMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("DAO, processResultSet() - no result set generated");
            System.err.println(npe.getMessage());
        }
        return resultString;
    }	// end - method processResultSet


}
