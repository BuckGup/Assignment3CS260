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
    public void callSQLInsert(/*String tableLoc, String TableRow, String InsertValues, int insertHRID*/) {

        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();


        //INSERT INTO ExampleTable
        //VALUES(rowName, etc.)
        //WHERE

        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        System.out.println("Check the database, because hopefully this is deleting rows.");

        dao.executeSQLQuery("INSERT INTO HumResource(HRID) VALUES (9999)");
        dao.executeSQLQuery("INSERT INTO Food VALUES (9999, 'Distributor', 69420, 'frozen, black licorice coffee') ");



        //resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();
        //System.out.println("This is the result set: " + resultSetStr);


        //  ("'INSERT INTO " + tableLoc + " VALUES (" + InsertValues + ") WHERE HRID = " + insertHRID + "'")








    }
}
