package mineplicity.hubapi.main.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import lombok.Getter;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/1/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    @Getter
    DB players;

    public Database() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 1234);
            players = mongoClient.getDB("Players");

        } catch(UnknownHostException e) {

        }
    }
}
