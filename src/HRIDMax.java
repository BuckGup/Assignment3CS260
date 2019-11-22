import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class HRIDMax {


    public String callMaxHRID() {

        Connection conn = null;            // JDBC connection
        ResultSet rset = null;            // result set for queries
        int returnValue;

        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();

        String query = "SELECT MAX HRID FROM HumResource";

        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        dao.executeSQLQuery("SELECT MAX HRID FROM HumResource");

        dao.commit();
        dao.disconnect();

        return dao.processResultSet();
    }
}
