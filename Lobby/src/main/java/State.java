import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ali on 08/06/2014.
 */
public class State {

    @Getter
    int maxPlayers;

    @Getter
    int currentPlayers;

    @Getter
    boolean lazy;

    public State(int currentPlayers, int maxPlayers, boolean l){
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        lazy = l;
    }
}
