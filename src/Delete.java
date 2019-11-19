public class Delete {
    /**
     * When deleting, we need to use the HRID to delete from both the specified table (F, W, MC) AND the Human Resources
     * table. All three (F, W, MC) tables are subclasses of Human Resources, so the value will need to be deleted
     * from a total of 2 tables.
     * Also, we don't need to worry about changing types.
     */

    public void callSQLDelete() {
        //DELETE __row__
        //FROM ExampleTable
        //WHERE ______
    }


}
