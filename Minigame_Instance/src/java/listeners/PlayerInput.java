package listeners;

import org.bukkit.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PlayerInput {
    public void onVoteFinish(String category, String winner);
    public void onSelect(Player p, String category, String selection);
}
