package minepow.hubapi.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;
import com.rethinkdb.model.MapObject;

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

    RethinkDBConnection con;
    RethinkDB r;

    public void init() {
        r = RethinkDB.r;
        con = RethinkDB.r.connect("localhost", 2000);

        r.db("MinePow");
        con.use("MinePow");
    }

    public int getMoney(UUID player) {
        List<Map<String,Object>> results = (List<Map<String,Object>>) r.table("Players").filter(r.row().field("uuid")
                .eq(player.toString())).pluck("money").run(con);
        return Integer.parseInt(results.get(0).get("money").toString());
    }
}
