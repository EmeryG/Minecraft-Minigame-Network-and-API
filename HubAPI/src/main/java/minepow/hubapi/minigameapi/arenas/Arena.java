package minepow.hubapi.minigameapi.arenas;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Random;

import minepow.hubapi.Main;
import minepow.hubapi.minigameapi.player.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public abstract class Arena {

	public Main plugin;
	public Random rand = new Random();

	public HashMap<Integer, Location> spawns = new HashMap<Integer, Location>();
	public HashMap<Player, Location> pSpawns = new HashMap<Player, Location>();
	public ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	public HashMap<Location, Material> materials = new HashMap<Location, Material>();
	public HashMap<Location, Byte> bytes = new HashMap<Location, Byte>();

	public int currentPlayers;
	public int maxPlayers = 24;
	public int minPlayers = 1;

	public String name;

	public boolean hasStarted;

	public Arena(String name) {
		this.name = name;
		this.plugin = ArenaManager.plugin;
	}

	public HashMap<Location, Material> getMaterials() {
		return materials;
	}

	public HashMap<Location, Byte> getBytes() {
		return bytes;
	}

	public void announceWin() {
		msgPlayers(ChatColor.BOLD + getWinner().getDisplayName() + ChatColor.RESET + "" + ChatColor.GOLD + " has won the game!");
	}

	public Player getWinner() {
		if (currentPlayers == 1) {
			return players.get(0).getPlayer();
		}
		return null;
	}

	public void msgPlayers(String message) {
		for (PlayerData data : players) {
			data.getPlayer().sendMessage(message);
		}
	}

	public void removePlayer(Player player) {
		for (PlayerData data : players) {
			if (data.getPlayer() == player) {
				data.restorePlayer();
				players.remove(data);
				setCurrentPlayers(getCurrentPlayers() - 1);
				return;
			}
		}
		if(players.size() == 1){
			msgPlayers(players.get(0).getPlayer().getDisplayName() + "Won the game!");
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				public void run() {
					ArenaManager.stop(ArenaManager.getArena(getName()));
				}
			},20 * 5);
		}
	}

	public boolean addPlayer(Player player) {
		//checking if there is too much players
		if (getCurrentPlayers() >= maxPlayers)
			return false;
		PlayerData data = new PlayerData(player);
		players.add(data);
		player.getInventory().clear();
		pSpawns.put(player, getRandomSpawn());
		player.teleport(pSpawns.get(player));
		setCurrentPlayers(getCurrentPlayers() + 1);
		return true;
	}

	public Location getRandomSpawn() {
		Location loc = spawns.get(rand.nextInt(24));
		while (pSpawns.containsValue(loc) || loc == null) {
			loc = spawns.get(rand.nextInt(24));
		}
		return loc;
	}

	public void removeSpawn(int num) {
		spawns.remove(num);
	}

	public void addSpawn(Location location, int num) {
		spawns.put(num, location);
		//config stuff
		plugin.getConfig().set("arenas." + getName() + ".locations." + num + ".x", location.getX());
		plugin.getConfig().set("arenas." + getName() + ".locations." + num + ".y", location.getY());
		plugin.getConfig().set("arenas." + getName() + ".locations." + num + ".z", location.getZ());
		plugin.getConfig().set("arenas." + getName() + ".locations." + num + ".world", location.getWorld().getName());
		plugin.saveConfig();
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public boolean isHasStarted() {
		return hasStarted;
	}

	public void setHasStarted(boolean hasStarted) {
		this.hasStarted = hasStarted;
	}

	public int getCurrentPlayers() {
		return currentPlayers;
	}

	public void setCurrentPlayers(int currentPlayers) {
		this.currentPlayers = currentPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<PlayerData> getPlayers() {
		return players;
	} 

	public void setPlayers(ArrayList<PlayerData> players) {
		this.players = players;
	}

	@SuppressWarnings("deprecation")
	public void addBlockChange(Block block) {
		materials.put(block.getLocation(), block.getType());
		bytes.put(block.getLocation(), block.getData());
	}

	public void addBlockChange(Location loc, Material mat, byte Byte) {
		materials.put(loc, mat);
		bytes.put(loc, Byte);
	}

	@SuppressWarnings("deprecation")
	public void restoreArena() {
		setHasStarted(false);
		for (Location loc : materials.keySet()) {
			loc.getBlock().setType(materials.get(loc));
			loc.getBlock().setData(bytes.get(loc));
		}
		try{
			for (PlayerData data : players) {
				removePlayer(data.getPlayer());
			}
		}catch(ConcurrentModificationException e){
			return;
		}
	}

	public HashMap<Integer, Location> getSpawns() {
		return spawns;
	}

	public void setSpawns(HashMap<Integer, Location> spawns) {
		this.spawns = spawns;
	}
	
	public abstract boolean start();
		
}
