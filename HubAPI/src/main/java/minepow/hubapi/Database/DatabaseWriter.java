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

    public static void init() {
        r = RethinkDB.r;
        con = RethinkDB.r.connect("localhost", 2000);

        r.db("MinePow");
        con.use("MinePow");
    }

    public void updateMoney(UUID player, int money) {
        r.table("Players").filter(r.row().field("uuid").eq(player.toString()))
                .update(new MapObject().with(("money"), money)).run(con);
    }

    public void addPlayer(UUID player, int money) {
        r.table("Players").insert(
                        new MapObject().with("uuid", player.toString()),
                        new MapObject().with("money", money)
                ).run(con);
    }
}
