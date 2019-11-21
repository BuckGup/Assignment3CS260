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

        System.out.println("Creating the statement...");


        dao.executeSQLQuery("SELECT * FROM Food");


        resultSetStr = dao.processResultSet();
        dao.commit();
        dao.disconnect();
        System.out.println("This is the result set: " + resultSetStr);

        //("'UPDATE " + tableLoc + " SET " + rowName + " = '" + updateValue + "' WHERE HRID = " + deleteHRID + "'");
    }
}
