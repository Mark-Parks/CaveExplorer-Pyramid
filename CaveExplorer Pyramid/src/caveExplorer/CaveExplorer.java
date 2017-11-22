package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][][] caves = new CaveRoom[3][][];;
	public static Scanner in = new Scanner(System.in);//user input
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	public static int numKeys;
	
	
	public static void main(String[] args) {
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		inventory.setHp(100);
		startExploring();
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	private static void startExploring() {
		while(playing) {
			moveNPCs();
			print(inventory.getDescription());
			print(currentRoom.getDirections());
			print(currentRoom.getDescription());
			print("HP : "+inventory.getHp());
			print("KEYS : "+inventory.getKeys());
			currentRoom.printValidMoves();
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
		}
	}

	private static void moveNPCs() {
		for(NPC n: npcs) {
			n.autoMove();
		}
		inventory.updateMap();
	}
}
