<h1>Minigame API Usage</h1>

<h2>Listeners</h2>

<p>For listening to voting selection and player option selections in the lobby do something like this:</p>
```java
public class PlayerEntryListener extends PlayerInput {

    @Override
	public void onVoteFinish(String category, String winner) {
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
<p>Basically, when these events trigger, you do stuff in your minigame. So when it goes toLobby(), add listeners to Lobby accordingly and add selections and such. Or when it goes toMinigame() you have to add your threads and listeners to the minigame and do your minigame init. Or toEnd, you award the winners and clean up any mess that you made via maps.</p>

<p>Add a state listener (always register this in your onEnable()) like so:</p>
```java
State<amager.registerListener(States listener)
```

<h2>onLobby Recommendations</h2>
