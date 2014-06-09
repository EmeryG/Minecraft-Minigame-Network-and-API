package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;
import com.rethinkdb.model.MapObject;

import java.util.UUID;

abstract public class DatabaseWriter {

    static RethinkDBConnection con;
    static RethinkDB r;

    public static void init() {
        r = RethinkDB.r;
        con = r.connect("107.170.74.107", 28015, "", 10000);
        con.use("MinePow");
    }

    public static void updateMoney(UUID player, int money) {
        r.table("Players").filter(user->user.field("uuid").eq(player.toString()))
                .update(new MapObject().with(("money"), money)).run(con);
    }

    public static void addPlayer(UUID player, int money) {
        r.table("Players").insert(
                        new MapObject().with("uuid", player.toString()).with("money", money)
                ).run(con);
    }
}
