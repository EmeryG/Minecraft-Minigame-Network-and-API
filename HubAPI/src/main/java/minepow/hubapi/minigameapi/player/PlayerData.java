package minepow.hubapi.minigameapi.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerData {

	private Location pLoc;
	private ItemStack[] inv;
	private ItemStack[] aInv;
	private Player player;
	
	public PlayerData(Player player){
		this.player = player;
		pLoc = player.getLocation();
		inv = player.getInventory().getContents();
		aInv = player.getInventory().getArmorContents();
	}
	
	public Location getLocation() {
		return pLoc;
	}
	public void setLocation(Location pLoc) {
		this.pLoc = pLoc;
	}
	
	public ItemStack[] getInventory() {
		return inv;
	}
	
	public void setInventory(ItemStack[] inv) {
		this.inv = inv;
	}
	
	public ItemStack[] getArmorInventory() {
		return aInv;
	}
	
	public void setArmorInventory(ItemStack[] aInv) {
		this.aInv = aInv;
	}
	
	public Player getPlayer(){
		return player;
	}

	public void restorePlayer() {
		getPlayer().teleport(pLoc);
		getPlayer().getInventory().setArmorContents(aInv);
		getPlayer().getInventory().setContents(inv);
	}
	
}
