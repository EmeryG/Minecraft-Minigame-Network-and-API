package minepow;

import lombok.Getter;
import minepow.listeners.States;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class StageManager {

    // State Management
    @Getter
    static State state;

    public enum State {
        PRE,
        DURING,
        AFTER
    }

    public static void toLobby() {
        state = State.PRE;
        for(States listener : stateListeners) {
            listener.onLobby();
        }
    }

    public static void toMinigame() {
        for(States listener : stateListeners) {
            listener.onMinigame();
        }
    }

    public static void toEnd(ArrayList<Player> winners) {
        for(States listener : stateListeners) {
            listener.onEnd(winners);
        }
    }

    // State Listeners
    static ArrayList<States> stateListeners = new ArrayList<States>();

    public static void registerListener(States listener) {
        stateListeners.add(listener);
    }

}
