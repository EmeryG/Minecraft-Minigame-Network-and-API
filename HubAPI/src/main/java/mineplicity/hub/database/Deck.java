package mineplicity.hub.database;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ervin on 6/1/2014.
 */
public class Deck {
    @Getter @Setter
    Card card1 = Card.FIREBALL;

    @Getter @Setter
    Card card2 = Card.FIREBALL;

    @Getter @Setter
    Card card3 = Card.FIREBALL;

    public enum Card {
        X2("X2"),
        X4("X4"),
        X6("X6"),
        INVERSE("Inverse"),
        STEAL("Steal"),
        PICK("Pick"),
        FIREBALL("Fireball");

        private final String Stringilized;

        Card(String stringilized) {
            Stringilized = stringilized;
        }
    }
}
