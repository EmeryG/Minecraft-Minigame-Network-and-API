import lilypad.client.connect.api.Connect;
import lombok.Getter;
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

    @Getter
    static Main main;

    Connect connect = this.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    public void onEnable() {
        this.main = this;
    }
    public void onDisable() {

    }

}
