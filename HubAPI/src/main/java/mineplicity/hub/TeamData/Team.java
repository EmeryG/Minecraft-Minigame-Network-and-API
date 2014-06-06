package mineplicity.hub.TeamData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author Blackeiled
 * Created by Blackeiled (Adam Canfield) on 6/6/2014.
 */

/**
 * Creates a Team class with a preset and unchangeable
 * type and maximum amount of players that can join the
 * Team of that type.
 */
public enum Team implements Joinable {

    /**
     * This team can hold a maximum of 4 players.
     */
    PARTY("Party", 4),
    /**
     * This team can hold a maximum of 10 players.
     */
    GROUP("GROUP", 10),
    /**
     * This team can hold a maximum of 20 players.
     */
    RAID("RAID", 20);

    private final Integer maxPlayers;
    private final String type;

    public class TeamPlayer implements Invitable {

        private final String uuid;
        private final String name;

        public TeamPlayer(UUID uuid)    {
            this.uuid = Bukkit.getPlayer(uuid).getUniqueId().toString();
            name = Bukkit.getPlayer(uuid).getName();
        }

        @Override
        public int invite() {
            return 0;
        }
    }

    private Team(String Type, Integer maxJoinable)  {
        type = Type;
        maxPlayers = maxJoinable;
    }

    //

    /**
     *
     *  ABSTRACT METHODS TO OVERRIDE
     *
     */

    //

    @Override
    public Player[] getPlayers() {
        return new Player[0];
    }

    @Override
    public int invitePlayer(UUID uuid) {
        return 0;
    }

    @Override
    public boolean kickPlayer(UUID uuid) throws NullPointerException {
        return false;
    }

    @Override
    public boolean setLeader(UUID uuid) throws NullPointerException {
        return false;
    }

    @Override
    public Player getLeader() {
        return null;
    }

    @Override
    public void disband() {

    }

    @Override
    public boolean hasPlayer(UUID uuid) {
        return false;
    }

    @Override
    public boolean hasPlayer(String name) {
        return false;
    }
}
