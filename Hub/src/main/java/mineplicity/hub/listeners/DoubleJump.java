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

public class DoubleJump implements Listener {

    private int force = 2;
    private boolean allowDoubleJump = true;

    public DoubleJump(Main p) {
        Main.plugin = p;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent e) {
        //When a player walks
        Player p = e.getPlayer();
        //If they can double jump
        if (allowDoubleJump) {
            //Checks the main world
            if (p.getWorld() == Bukkit.getWorld(Main.config.getString("Spawn.world"))) {
                //If the player is in creative or is on the group
                if (p.getGameMode() != GameMode.CREATIVE && p.isOnGround()) {
                    p.setAllowFlight(true);
                }
            }
        }
        return;
    }

    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        //If the entity is a player
        if (e.getEntity() instanceof Player) {
            //If the cause of damage is a fall
            if (e.getCause() == DamageCause.FALL) {
                //Cancels event
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
        //If the player is allowed to double jump
        if (allowDoubleJump) {
            //Checks the main world
            Player p = e.getPlayer();
            if (p.getWorld() == Bukkit.getWorld(Main.config.getString("Spawn.world"))) {

                //If they are in creative
                if (p.getGameMode() == GameMode.CREATIVE)
                    return;
                e.setCancelled(true);

                p.setAllowFlight(false);
                p.setFlying(false);

                // Vectors
                p.setVelocity(new Vector(p.getLocation().getX(), 1.00, p.getLocation().getZ()));
                p.setVelocity(p.getLocation().getDirection().multiply(force));

                // Sounds
                p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 0.2F, 1F);
                Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ());
                p.getWorld().playEffect(loc, Effect.GHAST_SHOOT, 1);

            }
        }
    }
}
