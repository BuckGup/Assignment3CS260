import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Delete {
    /**
     * When deleting, we need to use the HRID to delete from both the specified table (F, W, MC) AND the Human Resources
     * table. All three (F, W, MC) tables are subclasses of Human Resources, so the value will need to be deleted
     * from a total of 2 tables.
     * Also, we don't need to worry about changing types.
     */

    //As a transaction
    public void callSQLDelete(/*String tableLoc, String rowName, int deleteHRID*/) {
        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();

        //DELETE value
        //FROM table
        //WHERE _____


        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        System.out.println("Check the database, this is deleting rows!");


        dao.executeSQLQuery("DELETE * FROM Food WHERE HRID = 999999");
        dao.executeSQLQuery("DELETE * FROM HumResource WHERE HRID = 999999");


        resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();
        //System.out.println("This is the result set: " + resultSetStr);

        //("'UPDATE " + tableLoc + " SET " + rowName + " = '" + updateValue + "' WHERE HRID = " + deleteHRID + "'");



        //DELETE __row__
        //FROM ExampleTable
        //WHERE deleteValue





        //  something.callInSQL("'DELETE " + rowName + " FROM " + tableLoc + " WHERE HRID = " + deleteHRID + "'");


    }


}
