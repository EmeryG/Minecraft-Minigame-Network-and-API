package minepow.hubapi.minigameapi.arenas;

import java.util.ArrayList;

import minepow.hubapi.Main;
import minepow.hubapi.minigameapi.player.PlayerData;

import org.bukkit.entity.Player;

public class ArenaManager {

	static Main plugin;
	private static ArrayList<Arena> arenas;

	public ArenaManager(Main plugin) {
		ArenaManager.plugin = plugin;
		arenas = new ArrayList<Arena>();
	}

	public static void createArena(String name, ArenaType arenaType) {
		if (name == null)
			return;
		switch (arenaType) {
		
		case SURVIVALGAMES_ARENA:
			SurvivalGamesArena arena = new SurvivalGamesArena(name, plugin);
			arenas.add(arena);
		}
		return;
	}

	public static void setupArenas() {

	}

	public static Arena getArena(String name) {
		for (Arena a : arenas) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	public static Arena getArena(Player player) {
		for (Arena a : arenas) {
			for (PlayerData p : a.getPlayers()) {
				if (player.getName().equals(p.getPlayer().getName())) {
					return a;
				}
			}
		}
		return null;
	}

	public static boolean isInArena(Player player) {
		if (getArena(player) != null)
			return true;
		return false;
	}

	public static void stop(final Arena arena) {
		for (PlayerData data : arena.getPlayers()) {
			data.restorePlayer();
		}
		arena.restoreArena();
	}

	public static boolean start(final Arena arena) {
		if (!canStart(arena))
			return false;
		arena.setHasStarted(true);
		arena.start();
		return true;
	}

	public static boolean canStart(Arena arena) {
		if (arena.getCurrentPlayers() > arena.getMinPlayers() || arena.getSpawns().keySet().size() > arena.getMinPlayers())
			return true;
		return false;
	}

	public static void restoreAllArenas() {
		for (Arena a : arenas) {
			stop(a);
		}
	}

	public static void deleteArena(String name) {
		Arena a = getArena(name);
		stop(a);
		plugin.getConfig().set("arenas." + name, null);
		plugin.saveConfig();
	}

	public static ArrayList<Arena> getArenas() {
		return arenas;
	}

	public static void setArenas(ArrayList<Arena> arenas) {
		ArenaManager.arenas = arenas;
	}

}
