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