<h1>Minigame API Usage</h1>

<h2>Listeners</h2>

<p>For listening to voting selection and player option selections in the lobby do something like this:</p>
```java
public class PlayerEntryListener extends PlayerInput {

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

<p>Then register Bukkit and custom listeners with the api like so:</p>
```java
LobbyMain.registerListener(PlayerInput listener)
LobbyMain.registerListener(org.bukkit.event.Listener listener)
```

<h3>For listening to when the server changes states:</h3>
<p>This is the most important class to make your Minigame go round:</p>
```java
public class StateListener extends States {

    @Override
	public void onLobby() {
	    // code
	}
	
	@Override
	public void onMinigame() {
	    // code
	}
	
	@Override
	public void onEnd(ArrayList<Player> winners) {
	    // code
	}
	
}
```
<p>Basically, when these events trigger, you do stuff in your minigame. So when it goes ooLobby(), add listeners to Lobby accordingly and add selections and such. Or when it goes ooMinigame() you have to add your threads and listeners to the minigame and do your minigame init. Or onEnd, you award the winners and clean up any mess that you made via maps.</p>

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

<h2>Config</h2>
```java
// To get all Maps:
Set<String> maps = Config.getMapInfo().keySet();

// To get Map:
HashMap<String, HashMap<Integer, Location>> map = Config.getMapInfo().get(mapName);

// To get a Map Point Set: 
HashMap<Integer, Location> pointSet = Config.getMapInfo().get(mapName).get(pointType);

// To get a Map Point: 
Location point = Config.getMapInfo().get(mapName).get(pointType).get(pointNumber);
```

<h2>Selections</h2>
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

<h2>Adding listeners and threads to the Minigame</h2>
```java
MinigameMain.registerThread(org.bukkit.scheduler.BukkitRunnable thread)
MinigameMain.registerListener(org.bukkit.event.Listener listener)
```

<h2>Ending the minigame</h2>
```java
MinigameMain.finish(ArrayList<Player> winners)
```
<p>You can put on player in the arraylist, or several, it doesn't matter, but this will automatically unregister all your threads and listeners that you entered for the minigame.</p>
