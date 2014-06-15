package LobbyStage;

import org.bukkit.Material;

import java.util.ArrayList;

/**
 * Created by Ali on 15/06/2014.
 */
public class Selection {

    ArrayList<String> names;
    ArrayList<Material> ids;
    Material categoryItem;
    String category;

    public Selection(String category, Material categoryItem, ArrayList<String> names, ArrayList<Material> Ids){

        this.names = names;
        this.ids = Ids;
        this.categoryItem = categoryItem;
        this.category = category;

    }

}
