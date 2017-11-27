package caveExplorer;


public class Inventory {

	private int[] artifactCount = {0,0,0,0};
	private String map;
	private int hp;
	private CaveRoom[][] level;
	private static int keys;


	public Inventory() {
		updateMap();
	}

	public void updateMap() {
		level = CaveExplorer.caves[CaveExplorer.currentRoom.getFloor()];
		map = " ";
		for(int i = CaveExplorer.currentRoom.getFloor()*2; i < CaveExplorer.caves[0].length - 1; i++){
			map+= "____";
		}
		map +="___\n";
			for(CaveRoom[] row: level) {
				for(int i = 0; i < 3; i++) {
					String text = "";
					for(CaveRoom cr: row) {
						if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()) {
							text += " ";
						}else {
							text += "|";
						}
						if(i == 0) {
							text += "   ";
						}else if (i == 1) {
							text += " "+ cr.getContents()+" ";
						}else if (i == 2) {
							if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()) {
								text += "   ";
							}else {
								text += "___";
							}
						}
					}
					text += "|";
					map += text + "\n";
				
			}
		}
	}
	
	public String getDescription() {
		return map;
	}
	public int getHp() {
		if(hp < 1) {
			CaveExplorer.print("You have died, GAME OVER");
			CaveExplorer.playing = false;
			return hp;
		}else return hp;
	}
	public void setHp(int x) {
		hp = x;
	}
	public int getKeys() {
		return keys;
	}
	public void addKey() {
		keys = keys + 1;
	}
	public void useKey() {
		keys = keys - 1;
	}
	public void addArtifact(int RANK) {
		artifactCount[RANK] = artifactCount[RANK] + 1;
	}
	public int getArtifactCount(){
		return artifactCount[0]+artifactCount[1]+artifactCount[2]+artifactCount[3];
	}

	public int getFinalScore() {
		if(CaveExplorer.currentRoom.getFloor() == 0)
			return 1000 + (artifactCount[0]*10) + (artifactCount[1]*25) + (artifactCount[2]*50)+(artifactCount[3]*100)+hp;
		if(CaveExplorer.currentRoom.getFloor() == 1)
			return 20000 + (artifactCount[0]*10) + (artifactCount[1]*25) + (artifactCount[2]*50)+(artifactCount[3]*100)+hp;
		if(CaveExplorer.currentRoom.getFloor() == 2)
			return 300000 + (artifactCount[0]*10) + (artifactCount[1]*25) + (artifactCount[2]*50)+(artifactCount[3]*100)+hp;
		else return (artifactCount[0]*10) + (artifactCount[1]*25) + (artifactCount[2]*50)+(artifactCount[3]*100)+hp;
	}
}
