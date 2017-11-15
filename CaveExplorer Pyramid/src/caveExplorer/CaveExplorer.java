package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][][] caves = new CaveRoom[3][][];;
	public static Scanner in;//user input
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		startExploring();
	}

	public static void print(String s) {
		System.out.println(s);
	}
	
	private static void startExploring() {
		while(playing) {
			moveNPCs();
			System.out.println("\033[3mText goes here\033[0m");

			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("Current Floor is "+currentRoom.getFloor());
			print("You health is "+inventory.getHp()+"!");
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
