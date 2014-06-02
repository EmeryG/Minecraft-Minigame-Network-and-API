package mineplicity.hub.database;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/1/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    DB players;

    public Database() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 1234);
            players = mongoClient.getDB("Players");

        } catch(UnknownHostException e) {

        }
    }

    public PowPlayer getPlayer(UUID id) {
        DBCursor search = players.getCollection("Players").find(new BasicDBObject("uuid", id.toString()));
        DBObject player = null;

        while(search.hasNext()) {
            DBObject current = search.next();
            if(current.get("uuid").toString().equals(id)) {
                player = current;
                break;
            }
        }

        if(player.equals(null)) {
            return null;
        } else {
            PowPlayer p = new PowPlayer();
            p.setId(id);
            p.setCoins(Integer.parseInt(player.get("coins").toString()));
            return p;
        }
    }

    public void savePlayer(PowPlayer p) {

    }
}
