package caveExplorer;

import java.util.Scanner;

public class WeiCustomRoom extends NPCRoom {
	private static Scanner in;
	private String[] relics = new String[10];
	
	public WeiCustomRoom(String description, int size) {
		super(description);
		this.relics = new String[size];
	}
	
	public void grabItem() {
		System.out.println("As you walk into the room, " + size + " relics lie in front of them.");
	}
	
	private void printRelics() {
		
	}
}
