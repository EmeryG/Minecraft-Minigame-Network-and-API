package mineplicity.hub.listeners;

import mineplicity.hub.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

/**
 * Created by erezcsillag on 6/2/14.
 */

public class DoubleJump implements Listener {

	Main plugin;

	private int force = 2;
	private boolean allowDoubleJump = true;

	public DoubleJump(Main p) {
		plugin = p;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerWalk(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (allowDoubleJump) {
			if (p.getWorld() == Bukkit.getWorld(plugin.getConfig().getString("Spawn.world"))) {
				if (p.getGameMode() != GameMode.CREATIVE && p.isOnGround()) {
					p.setAllowFlight(true);
				}
			}
		}
		return;
	}

	@EventHandler
	public void onPlayerFall(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getCause() == DamageCause.FALL) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
		if (allowDoubleJump) {
			Player p = e.getPlayer();
			if (p.getWorld() == Bukkit.getWorld(plugin.getConfig().getString("Spawn.world"))) {

				if (p.getGameMode() == GameMode.CREATIVE)
					return;
				e.setCancelled(true);

				p.setAllowFlight(false);
				p.setFlying(false);

				// vectors
				p.setVelocity(new Vector(p.getLocation().getX(), 1.00, p.getLocation().getZ()));
				p.setVelocity(p.getLocation().getDirection().multiply(force));

				// sounds
				p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 0.2F, 1F);
				Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ());
				p.getWorld().playEffect(loc, Effect.GHAST_SHOOT, 1);

			}
		}
	}

}
