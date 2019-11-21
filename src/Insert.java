public class Insert {
    /**
     * When inserting, we need to use the HRID to insert into both the specified table (F, W, MC) AND the Human Resources
     * table. All three (F, W, MC) tables are subclasses of Human Resources, so the value will need to be inserted
     * into a total of 2 tables.
     * Also, we don't need to worry about changing types.
     */

    //As a transaction
    public void callSQLInsert(String tableLoc, String TableRow, String InsertValues, int insertHRID) {

        //INSERT INTO ExampleTable
        //VALUES(rowName, etc.)
        //WHERE

        //  ("'INSERT INTO " + tableLoc + " VALUES (" + InsertValues + ") WHERE HRID = " + insertHRID + "'")

    }
}
