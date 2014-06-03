package mineplicity.hub.database.player;

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
public class PlayerDatabase {

    DB db;

    public PlayerDatabase() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 1234);
            db = mongoClient.getDB("Players");

        } catch(UnknownHostException e) {
        	System.out.println("Unknown host.");
        }
    }

    public PowPlayer getPlayer(UUID id) {
        DBCursor search = db.getCollection("Players").find(new BasicDBObject("uuid", id.toString()));
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
            String[] cs = new String[] {player.get("cards").toString()};
            p.cards.setCards(new Deck.Card[] {Deck.Card.valueOf(cs[0]), Deck.Card.valueOf(cs[1]), Deck.Card.valueOf(cs[2])});
            return p;
        }
    }

    public void savePlayer(PowPlayer p) {
        UUID id = p.getId();
        DBCursor search = db.getCollection("Players").find(new BasicDBObject("uuid", id.toString()));
        DBObject player = null;

        while(search.hasNext()) {
            DBObject current = search.next();
            if(current.get("uuid").toString().equals(id)) {
                player = current;
                break;
            }
        }

        if(!(Integer.parseInt(player.get("coins").toString()) == p.getCoins())) {
            player.removeField("coins");
            player.put("coins", p.getCoins());
            db.getCollection("Players").save(player);
        }

        String[] cs = new String[] {player.get("cards").toString()};
        Deck.Card[] cards = new Deck.Card[] {Deck.Card.valueOf(cs[0]), Deck.Card.valueOf(cs[1]), Deck.Card.valueOf(cs[2])};

        if(!(cards[0] == p.cards.getCard1()
                && cards[1] == p.cards.getCard2()
                && cards[2] == p.cards.getCard3())) {

            player.removeField("cards");
            cs[0] = p.cards.getCard1().toString();
            cs[1] = p.cards.getCard2().toString();
            cs[2] = p.cards.getCard3().toString();

            player.put("cards", cs.toString());
            db.getCollection("Players").save(player);
        }
    }
}
