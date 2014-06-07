package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseWriter {

    RethinkDBConnection con;
    RethinkDB r;

    public void init() {
        r = RethinkDB.r;
        con = RethinkDB.r.connect("localhost", 2000);

        r.db("MinePow");
        con.use("MinePow");
    }
}
