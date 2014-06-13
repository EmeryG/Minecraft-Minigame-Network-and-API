/**
 * Created by Ali on 08/06/2014.
 */
public class Slots {

    public int maxPlayers;
    public int currentPlayers;

    public Slots(int maxPlayers, int currentPlayers){
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public int getMaxPlayers(){
        return maxPlayers;
    }

    public int getCurrentPlayers(){
        return currentPlayers;
    }

    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }
}
