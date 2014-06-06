package mineplicity.hub.TeamData;

import java.util.UUID;
import org.bukkit.entity.Player;

/**
 * @author Blackveiled
 * Created by Blackeiled (Adam Canfield) on 6/6/2014.
 */
public interface Joinable {

    /**
     * Will return the player's team data who's
     * name matches the parameters.  It is possible
     * to retrieve the Player entity through the TeamPlayer
     * class.
     *
     * @param Name
     * @return org.bukkit.entity.Player
     */
    public TeamPlayer getTeamPlayer(String Name);
    /**
     * Will return all players inside of this
     * joinable team.
     *
     * @return org.bukkit.entity.Player[]
     */
    public Player[] getPlayers();

    /**
     * Sends an invitation request to the
     * online player whose UUID matches the
     * UUID in the parameters.
     *
     * @param uuid
     * @return False if the player is already in a group.
     */
    public boolean addPlayer(UUID uuid);

    /**
     * If the player is inside the group, they will
     * be kicked from the group.
     *
     * @param uuid
     * @throws java.lang.NullPointerException
     * @return
     */
    public boolean kickPlayer(UUID uuid);

    /**
     * Sets this team's leader to the online player
     * whose UUID matches the provided parameters.
     *
     * @param uuid
     * @throws java.lang.NullPointerException
     * @return
     */
    public boolean setLeader(UUID uuid);

    /**
     * Get the Player who is the leader of the team.
     * @return
     */
    public Player getLeader();

    /**
     * Invoking this method will disband the team,
     * removing all players from the team.
     *
     * @return
     */
    public void disband();

    /**
     * Checks the team if the team contains a player
     * with the UUID provided.
     *
     * @param uuid
     * @return True if the player is in this team.  False if otherwise.
     */
    public boolean hasPlayer(UUID uuid);

    /**
     * Checks the team if the team contains a player
     * with the name provided.
     *
     * @param name
     * @return True if the player is in this team.  False if otherwise.
     */
    public boolean hasPlayer(String name);

}
