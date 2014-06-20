package minepow.LobbyStage;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ali on 15/06/2014.
 */
public class Vote extends Selection {
    HashMap<String, Integer> votes = new HashMap<String, Integer>();
    int total = 0;

    public Vote(String category, Material categoryItem, ArrayList<String> names, ArrayList<Material> Ids) {
        super(category, categoryItem, names, Ids);
        for(String vote : names) {
            votes.put(vote, 0);
        }
    }

}
