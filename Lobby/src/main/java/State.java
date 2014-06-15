import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ali on 08/06/2014.
 */
public class State {

    @Getter @Setter
    int maxPlayers;

    @Getter @Setter
    int currentPlayers;

    @Getter @Setter
    boolean lazy;

    public State(int currentPlayers, int maxPlayers, boolean l){
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        lazy = l;
    }
}
