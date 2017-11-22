package caveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC npc;
	
	public NPCRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public boolean canenter() {
		return getNpc() == null;
	}
	
	public void enterNPC(NPC n) {
		this.setNpc(n);
	}
	
	public void leaveNPC() {
		this.setNpc(null);
	}
	
	public boolean containsNPC() {
		return getNpc() != null;
		
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to inspect your surroundings.");
	}

	public String validMoves() {
		return "wdsae";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(getNpc() != null && getNpc().isActive()) {
				getNpc().interact();
			}else {
				CaveExplorer.print("Nothing but ancient dust and sand.");
			}
		}else {
			CaveExplorer.print("There is nothing to interact with.");
		}
	}
	
	
	public String getContents() {
		if(containsNPC() && getNpc().isActive()) {
			return getNpc().getSymbol();
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && getNpc().isActive()) 
			return super.getDescription()+"\n"+getNpc().getDescription();
		else if(containsNPC() && !getNpc().isActive())
			return super.getDescription()+"\n"+getNpc().getInactiveDescription();
		else
			return super.getDescription();
			
	}

	public NPC getNpc() {
		return npc;
	}

	public void setNpc(NPC npc) {
		this.npc = npc;
	}
	
}
