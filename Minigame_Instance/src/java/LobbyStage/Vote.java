package LobbyStage;

import org.bukkit.Material;

/**
 * Created by Ali on 15/06/2014.
 */
public class Vote {

    public int votedFor;
    public String name;
    public Material displayItem;

    public Vote(String name, Material displayItem){
        votedFor = 0;
        this.name = name;
        this.displayItem = displayItem;
    }

}
