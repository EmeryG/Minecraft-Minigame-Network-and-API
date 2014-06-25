import minepow.PlayingStage.MinigameMain;
import minepow.listeners.States;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Ali on 24/06/2014.
 */
public class StatesListener implements States{
    @Override
    public void onLobby() {

    }

    @Override
    public void onMinigame() {
        MinigameMain.registerListener(new GameListener());
    }

    @Override
    public void onEnd(ArrayList<Player> players) {

    }
}
