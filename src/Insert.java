import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Insert {
    /**
     * When inserting, we need to use the HRID to insert into both the specified table (F, W, MC) AND the Human Resources
     * table. All three (F, W, MC) tables are subclasses of Human Resources, so the value will need to be inserted
     * into a total of 2 tables.
     * Also, we don't need to worry about changing types.
     */

    //As a transaction
    public void callSQLInsert(String tableLoc, String insertValues, int insertHRID) {


        //String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();
        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        System.out.println("The program is INSERTING the given information into the database!");

        //
        dao.executeSQLQuery("INSERT INTO HumResource (HRID) VALUES (" + insertHRID + ")");       //insert
        //dao.executeSQLQuery("INSERT INTO Food VALUES (999999, 'Distributor', 69420, 'frozen, black licorice coffee') ");
        dao.executeSQLQuery("INSERT INTO " + tableLoc + " VALUES (" + insertValues + ")");

        //

        //resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();
        //System.out.println("This is the result set: " + resultSetStr);


        //  ("INSERT INTO " + tableLoc + " VALUES (" + InsertValues + ") WHERE HRID = " + insertHRID)


    }
}
