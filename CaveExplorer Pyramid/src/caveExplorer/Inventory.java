package caveExplorer;

import WeixiongTristanMinigame.*;

public class Inventory {

	private int[] artifactCount;
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
		for(int i = 0; i < CaveExplorer.caves[0].length - 1; i++){
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
		return hp;
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
	public int[] getArtifactCount(){
		return artifactCount;
	}
}
