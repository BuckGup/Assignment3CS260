import java.io.*;
import java.util.Scanner;
import java.sql.*;
import java.util.StringTokenizer;

public class Update {
    /**
     * For Update, we are not updating the HRID, and therefore do not need to worry about updating the Human Resources
     * superclass as well. We are fine only updating the values within the specified table, because the HRID should
     * remain constant.
     *
     * This class updates values in one row, updating all values in that row.
     */

    //As a transaction
    public void callSQLUpdate(String tableLoc, String insertValues, int insertHRID) {

        databaseObjectAccessor dao = new databaseObjectAccessor();

        dao.connect();      //connect to the database
        dao.setAutoCommit(false);

        StringTokenizer st = new StringTokenizer(insertValues);
        if (tableLoc.equals("MEDICALCENTER")) {
            //4 times nextToken
            dao.executeSQLQuery("UPDATE " + tableLoc +
                    " SET NumBeds = '" + st.nextToken() +
                    "', EmergencyRoomCapacity = '" + st.nextToken() +
                    "', NumDoctors = '" + st.nextToken() +
                    "', NumNurses = '" + st.nextToken() +
                    "' WHERE HRID  = " + insertHRID);

        } else if (tableLoc.equals("FOOD")) {

            dao.executeSQLQuery("UPDATE " + tableLoc +
                    " SET FType = '" + st.nextToken() +
                    "', FMealsAvailable = '" + st.nextToken() +
                    "', FSpecificDesc = '" + st.nextToken() +
                    "' WHERE HRID  = " + insertHRID);

        } else if (tableLoc.equals("WATER")) {
            dao.executeSQLQuery("UPDATE " + tableLoc +
                    " SET Num10OzBottlesAvailable = '" + st.nextToken() +
                    "', NumHalfLiterBottlesAvailable = '" + st.nextToken() +
                    "', Num5GallonJugsAvailable = '" + st.nextToken() +
                    "' WHERE HRID  = " + insertHRID);

        }

        System.out.println("Successfully updated the row in the database. (Hopefully)\n------------------------------------\n");

        dao.commit();
        dao.disconnect();

    }
}
