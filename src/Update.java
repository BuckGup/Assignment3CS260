import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Update {
    /**
     * For Update, we are not updating the HRID, and therefore do not need to worry about updating the Human Resources
     * superclass as well. We are fine only updating the values within the specified table, because the HRID should
     * remain constant.
     * Something about not having to worry about changing types.
     */


    //As a transaction
    public void callSQLUpdate() {
        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();




        //UPDATE ExampleTable
        //SET ExampleColumn = 'ExampleValue'
        //WHERE _____


        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        System.out.println("Check the database, because hopefully this is deleting rows.");

        //dao.executeSQLQuery("INSERT INTO HumResource(HRID) VALUES (999999)");
        //dao.executeSQLQuery("INSERT INTO Food VALUES (999999, 'Distributor', 69420, 'frozen, black licorice coffee') ");

        dao.executeSQLQuery("DELETE * FROM Food WHERE HRID = 999999");
        //dao.executeSQLQuery("DELETE * FROM HumResource WHERE HRID = 999999");


        //resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();
        //System.out.println("This is the result set: " + resultSetStr);

        //("'UPDATE " + tableLoc + " SET " + rowName + " = '" + updateValue + "' WHERE HRID = " + deleteHRID + "'");
    }
}
