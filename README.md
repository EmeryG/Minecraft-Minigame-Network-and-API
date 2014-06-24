<h1>Minigame API Usage</h1>

<h2>Lobby Registration</h2>

<p>For listening to voting selection and player option selections in the lobby do something like this:</p>
```java
public class PlayerEntryListener implements PlayerInput {

    @Override
	public void onVoteFinish(String category, String mostVotedFor) {
	    // code
	}
	
	@Override
	public void onSelect(Player p, String category, String selection) {
	    // code
	}
	
}
```

<p>Then register Threads, Bukkit listeners, and custom listeners with the api like so:</p>
```java
LobbyMain.registerListener(PlayerInput listener)
LobbyMain.registerListener(org.bukkit.event.Listener listener)
LobbyMain.registerThread(org.bukkit.scheduler.BukkitRunnable thread)
```

<h3>For listening to when the server changes states:</h3>
<p>This is the most important class to make your Minigame go round:</p>
```java
public class StateListener implements States {

    @Override
	public void onLobby() {
	    // add lobby listeners
		// code
	}
	
	@Override
	public void onMinigame() {
	    // add minigame listeners
		// code
	}
	
	@Override
	public void onEnd(ArrayList<Player> winners) {
	    // give winner(s) an award
		// code
	}
	
}
```
<p>Basically, when these events trigger, you do stuff in your minigame. So when it goes onLobby(), add listeners to Lobby accordingly and add selections and such. Or when it goes onMinigame() you have to add your threads and listeners to the minigame and do your minigame init. Or onEnd, you award the winners and clean up any mess that you made via maps.</p>

<p>Add a state listener (always register this in your onEnable()) like so:</p>
```java
StageManager.registerListener(States listener)
```

<h2>Spectators</h2>
<p>So, you can set and get spectators.</p>
```java
ArrayList<Player> MinigameMain.getSpecators()
MinigameMain.setSpectator(player)
```

<h2>Maps</h2>
```java
// To get all Maps:
ArrayList<String> maps = Config.getMaps();

// To get Map:
HashMap<String, HashMap<Integer, Location>> map = Config.getMapInfo().get(mapName);

// To get a Map Point Set: 
HashMap<Integer, Location> pointSet = Config.getMapInfo().get(mapName).get(pointType);

// To get a Map Point: 
Location point = Config.getMapInfo().get(mapName).get(pointType).get(pointNumber);
```

<h2>Config</h2>
```java
// To get the config
FileConfiguration config = Config.getConfig();

// To save the config
Config.saveConfig();

// When first running your minigame, this is to check if configuration options for your own minigame is there
Config.contains(String thing);
```

<h2>Votes/Selections</h2>
<p>So you can make votes and selections to the Lobby to get what the player wants to play, such as maps, kits, etc. A selection is an individual thing where players can select what they want to play with such as a kit. But voting is where all players contribute to one choice, like a map.</p>
```java
// To add a selection:
LobbyMain.getSelectionManager().selections.add(new Selection(String category, Material categoryItem, ArrayList<String> names, ArrayList<Material> Ids));
/* 
    The catagory item is item is shown in the inventory before the player clicks it, and the category is it's item name.
    The ids are the items for selection, and names, of course, are their item names. 
    Make sure that items that are named a specific something are at the same place on both lists.
*/

// To add a vote:
LobbyMain.getVoteManager().votes.add(new Vote(String category, Material categoryItem, ArrayList<String> names, ArrayList<Material> Ids));
/* 
    Votes have the same property as collections, so everything said about votes are the same. 
	But, you don't get the results of the vote every time a player votes, only when the voting time is up or when all players vote.
*/
```

<h2>Minigame Registration</h2>
```java
MinigameMain.registerThread(org.bukkit.scheduler.BukkitRunnable thread, Long delay)
MinigameMain.registerThread(org.bukkit.scheduler.BukkitRunnable thread, Long delay, Long ticksBetweenRunning)
MinigameMain.registerListener(org.bukkit.event.Listener listener)
```

<h2>Ending the minigame</h2>
```java
MinigameMain.finish(ArrayList<Player> winners)
```
<p>You can put on player in the arraylist, or several, it doesn't matter, but this will automatically unregister all your threads and listeners that you entered for the minigame.</p>

<h2>Util</h2>
```java
// Spawn a player randomly
Location dropped = Util.spawnPlayerRandomly(Player p, Location borderPoint1, Location borderPoint2);

// Spawn all players randomly
spawnPlayersRandomly(Player p, Location borderPoint1, Location borderPoint2)

// Drop an itemstack randomly
Location dropped = Util.dropItemRandonmly(Location borderPoint1, Location borderPoint2, ItemStack item)
```