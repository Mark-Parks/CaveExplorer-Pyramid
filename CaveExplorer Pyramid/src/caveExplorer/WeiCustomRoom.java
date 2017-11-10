package caveExplorer;

import java.util.Scanner;

import WeixiongTristanMinigame.Buyables;

public class WeiCustomRoom extends NPCRoom {
	private static Scanner in;
	private int size;
	private String[] relics = new String[10];
	
	public WeiCustomRoom(String description, int size) {
		super(description);
		in = new Scanner(System.in);
	}
	
	public void grabItem() {
		System.out.println("As you walk into the room, " + size + " relics lie in front of them.");
	}
	
	private void printRelics() {
		
	}
}
