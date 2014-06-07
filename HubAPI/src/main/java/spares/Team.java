package spares;

import org.bukkit.Bukkit;

import java.lang.Runnable;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Blackeiled
 * Created by Blackeiled (Adam Canfield) on 6/6/2014.
 */

/**
 * Creates a spares.Team class with a preset and unchangeable
 * type and maximum amount of players that can join the
 * spares.Team of that type.
 */
public enum Team implements Joinable {

//    /**
//     * This team can hold a maximum of 4 players.
//     */
//    PARTY("Party", 4),
//    /**
//     * This team can hold a maximum of 10 players.
//     */
//    GROUP("GROUP", 10),
//    /**
//     * This team can hold a maximum of 20 players.
//     */
//    RAID("RAID", 20);
//
//    private static List<Team> teams = new ArrayList<>();
//    private List<TeamPlayer> teamPlayers = new ArrayList<>();
//    private final Integer maxPlayers;
//    private final String type;
//
//    public class TeamPlayer implements Invitable {
//        protected PendingInvitation pendingInvitation;
//        private final String uuid;
//        private final String name;
//        private boolean leader = false;
//        private boolean moderator = false;
//        private Date;
//        private invitation=0;
//
//        public TeamPlayer(UUID uuid) {
//            this.uuid = Bukkit.getPlayer(uuid).getUniqueId().toString();
//            name = Bukkit.getPlayer(uuid).getName();
//        }
//
//        public int acceptInvite() {
//            return 1;
//        }
//
//        public int declineInvite() {
//            return -1;
//        }
//
//        public void invitePlayer() {
//            return 0;
//        }
//
//        public class PendingInvitation implements Runnable {
//
//            public void run() {
//
//            }
//
//            public PendingInvitation() {
//
//            }
//        }
//
//    }
//
//    private Team(String Type, Integer maxJoinable) {
//        type = Type;
//        maxPlayers = maxJoinable;
//    }
//
//    private Team() {
//
//    }
//
//
//    public static Team getTeam(int i) {
//        return Team.teams.get(i);
//    }
//
//    /**
//     * ABSTRACT METHODS TO OVERRIDE
//     */
//
//    //
//    @Override
//    public TeamPlayer[] getPlayers() {
//        return this.teamPlayers.toArray();
//    }
//
//    @Override
//    public boolean addPlayer(UUID uuid) {
//        if (getPlayers().length >= maxPlayers()) return false;
//        Iterator<Team> iterator = teams.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().hasPlayer(uuid)) return false;
//        }
//        this.teamPlayers().add(uuid);
//        return true;
//    }
//
//    @Override
//    public boolean kickPlayer(UUID uuid) {
//        for (int i = 0; i < getPlayers().length; i++) {
//            return getPlayers()[i].uuid.equals(uuid.toString());
//        }
//        return true;
//    }
//
//    @Override
//    public boolean setLeader(UUID uuid) {
//        return false;
//    }
//
//    @Override
//    public TeamPlayer getLeader() {
//        return null;
//    }
//
//    @Override
//    public void disband() {
//
//    }
//
//    @Override
//    public boolean hasPlayer(UUID uuid) {
//        return false;
//    }
//
//    @Override
//    public boolean hasPlayer(String name) {
//        return false;
//    }
}
