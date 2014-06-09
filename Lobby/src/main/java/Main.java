import lilypad.client.connect.api.Connect;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/7/14
 * Time: 7:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JavaPlugin{

    InstanceListener messageListener = new InstanceListener();
    Connect connect = this.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    public void onEnable() {
        connect.registerEvents(messageListener);
    }
    public void onDisable() {
        connect.unregisterEvents(messageListener);
    }

}
