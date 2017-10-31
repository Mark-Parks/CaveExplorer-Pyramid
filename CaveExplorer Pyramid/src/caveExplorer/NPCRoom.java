package caveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC npc;
	
	public NPCRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public boolean canenter() {
		return npc == null;
	}
	
	public void enterNPC(NPC n) {
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null;
	}
	
	public boolean containsNPC() {
		return npc != null;
		
	}
	
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to perform an action");
	}

	public String validMoves() {
		return "wdsae";
	}
	
	private void performAction(int direction) {
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return npc.getSymbol();
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && npc.isActive()) 
			return super.getDescription()+"\n"+npc.getDescription();
		else if(containsNPC() && !npc.isActive())
			return super.getDescription()+"\n"+npc.getInactiveDescription();
		else
			return super.getDescription();
			
	}
	
}
