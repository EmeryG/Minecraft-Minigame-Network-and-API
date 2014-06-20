<h1>Minigame API Usage</h1>
<h2>Listeners</h2>
<p>For listening to voting selection and player option selections in the lobby do something like this:</p>
```
public class PlayerEntryListener {

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
