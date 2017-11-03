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
		System.out.println("Hello, I am a Moogle, kupo. Here are some items I have on sale. Press 'l' to leave at anytime");
		startShopping();
	}
	
	private void startShopping() {
		in = 
	}

	public void purchaseItem(int itemNum) {
		Buyables currentItem = shop[itemNum];
		
	}
}
