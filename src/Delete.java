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
    public void callSQLDelete(String tableLoc, int deleteHRID) {

        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();

        //DELETE value
        //FROM table
        //WHERE _____

        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        System.out.println("The program is deleting");

        dao.executeSQLQuery("DELETE * FROM " + tableLoc + " WHERE HRID = " + deleteHRID);
        dao.executeSQLQuery("DELETE * FROM " + tableLoc + " WHERE HRID = " + deleteHRID);

        resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();



    }


}
