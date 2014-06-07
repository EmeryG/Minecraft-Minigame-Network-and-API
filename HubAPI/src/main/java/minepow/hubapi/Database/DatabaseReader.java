package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class DatabaseReader {

    static RethinkDBConnection con;
    static RethinkDB r;

    public static void init() {
        r = RethinkDB.r;
        con = RethinkDB.r.connect("localhost", 2000);

        r.db("MinePow");
        con.use("MinePow");
    }

    public static int getMoney(UUID player) {
        List<Map<String,Object>> results = (List<Map<String,Object>>) r.table("Players").filter(r.row().field("uuid")
                .eq(player.toString())).pluck("money").run(con);
        return Integer.parseInt(results.get(0).get("money").toString());
    }
}
