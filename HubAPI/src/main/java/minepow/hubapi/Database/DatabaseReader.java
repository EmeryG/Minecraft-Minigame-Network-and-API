package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseReader {

    public void database() {
        RethinkDB r = RethinkDB.r;
        RethinkDBConnection con = r.connect();

        r.db("MinePow").tableCreate("Players");
        con.use("MinePow");
    }
}
