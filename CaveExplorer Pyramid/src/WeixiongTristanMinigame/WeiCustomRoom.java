package WeixiongTristanMinigame;

import caveExplorer.NPCRoom;
import java.util.Scanner;

public class WeiCustomRoom extends NPCRoom {
	private Buyables[] shop = new Buyables[1];
	private static Scanner in;
	
	public WeiCustomRoom(String description) {
		super(description);
		in = new Scanner(System.in);
		shop[0] = new Buyables("Potion", 2, 20);
	}
	
	public void enter() {
		System.out.println("Hello, I am a Moogle, kupo. Here are some items I have on sale. Press 'l' to leave at anytime. Press an integer to buy an item in the shop.");
		printInventory(shop);
		startShopping();
	}
	
	private void printInventory(Buyables[] shop) {
		for(int i = 0; i < shop.length; i++) {
			System.out.println(i + 1);
		}
	}

	private void startShopping() {
		String response = in.nextLine();
		while(response.toLowerCase().equals("leave")) {
			if(response > shop.length) {
				
			}
		}
	}

	public void purchaseItem(int itemNum) {
		Buyables currentItem = shop[itemNum];
		
	}
}
