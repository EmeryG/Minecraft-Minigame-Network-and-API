package minepow.hubapi.minigameapi.arenas;

public enum ArenaType {

	SURVIVALGAMES_ARENA("survivalgames");
	
	private String type;
	
	private ArenaType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
