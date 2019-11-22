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

        databaseObjectAccessor dao = new databaseObjectAccessor();

        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        dao.executeSQLQuery("DELETE FROM " + tableLoc + " WHERE HRID = " + deleteHRID);
        dao.executeSQLQuery("DELETE FROM HumResource WHERE HRID = " + deleteHRID);

        dao.commit();
        dao.disconnect();

        System.out.println("The program has DELETED the given row from the database!\n\n-----------------------------------------\n");
    }


}
