package minepow.hubapi.minigameapi.arenas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import minepow.hubapi.Main;

public class SurvivalGamesArena extends Arena{

	private int gracePeriod = 10;
	
	private boolean graceOn;

	public SurvivalGamesArena(String name, Main plugin) {
		super(name);
		this.plugin = plugin;
		this.name = name;
	}

	public int getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public boolean isGraceOn() {
		return graceOn;
	}

	public void setGraceOn(boolean graceOn) {
		this.graceOn = graceOn;
	}

	public boolean start() {
		setGraceOn(true);
		msgPlayers(ChatColor.GOLD + "Good Luck!");
		msgPlayers(ChatColor.GOLD + "Grace period has been turned on for " + getGracePeriod() + " seconds!");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			public void run() {
				setGraceOn(false);
				msgPlayers(ChatColor.GOLD + "Grace Period has been removed!");
			}
		}, getGracePeriod() * 20);

		return true;
	}

}
