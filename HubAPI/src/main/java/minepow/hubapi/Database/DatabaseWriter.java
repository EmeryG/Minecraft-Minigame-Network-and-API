package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;
import com.rethinkdb.model.MapObject;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class DatabaseWriter {

    static RethinkDBConnection con;
    static RethinkDB r;

    static public void init() {
        r = RethinkDB.r;
        con = RethinkDB.r.connect("localhost", 2000);

        r.db("MinePow");
        con.use("MinePow");
    }

    public void updateMoney(UUID player, int money) {
        r.table("Players").filter(r.table("uuid").eq(player.toString()))
                .update(new MapObject().with(("money"), money));
    }
}
