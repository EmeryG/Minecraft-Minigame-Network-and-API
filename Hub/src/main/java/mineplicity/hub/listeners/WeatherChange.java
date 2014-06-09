package mineplicity.hub.listeners;

import mineplicity.hub.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener {

    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent e) {

        //If Weather Lock enabled
        if (Main.config.getBoolean("WeatherLock.enabled")) {
            //Cancel event
            e.setCancelled(true);
        }
    }
}
