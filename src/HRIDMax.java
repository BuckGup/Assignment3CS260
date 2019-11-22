import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class HRIDMax {


    public void callMaxHRID() {

        String resultSetStr = null;
        databaseObjectAccessor dao = new databaseObjectAccessor();


        dao.connect();      //connect to the database
        dao.setAutoCommit(false);


        dao.executeSQLQuery("SELECT MAX HRID FROM HumResource");


        dao.commit();
        dao.disconnect();


    }
}
