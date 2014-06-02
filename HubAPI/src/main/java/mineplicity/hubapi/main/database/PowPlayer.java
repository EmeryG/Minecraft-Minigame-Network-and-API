package mineplicity.hubapi.main.database;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class PowPlayer {

    @Setter @Getter
    UUID id;

    @Getter @Setter
    int coins;

    public Deck cards = new Deck();
}
