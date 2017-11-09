package caveExplorer;

import WeixiongTristanMinigame.*;
import TheoDevinMinigame.*;
import MarkWillFloor1.*;

public class CaveRoom {

	private String description;
	private String directions;// what doors can be used
	private String contents;//when in room
	private String defaultContents;//when not in room
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	private int floor;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * For every door in doors[] 
	 * this method appends a String to "directions" describing door and where
	 * if there are no doors that are not null this sets
	 *	"There is no way out"
	 */
	
	private void setDirections() {
		directions = "";
		boolean doorFound = false;
		//to check null
		//doors[0] == null
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+toDirection(i)+". "+doors[i].getDetails()+"\n";			
			}
		}
		if(!doorFound) {
			directions = "You are trapped.";
		}
	}

	public static String toDirection(int dir) {
		String[] direction = {"the North","the East","the South","the West"};
		//when no long if-else
		//use this
		return direction[dir];
	}
	
	
	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	//
	//CONNECTS ROOMS
	//
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction,anotherRoom,door);
		anotherRoom.addRoom(oppositeDirection(direction),this,door);
	}
	
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates
	}

	public void interpretInput(String input) {
		while(!isValid(input)){
			printValidMoves();
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if(direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
	}
	
	private void performAction(int direction) {
		CaveExplorer.print("That key does nothing");
	}

	//
	//PLAYER INPUT OPTIONS
	//
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a'.");
	}

	public String validMoves() {
		return "wdsa";
	}
	
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	
	//
	//MAKES THE LEVEL
	//
	public static void setUpCaves() {
		//
		//PYRAMID PAREMETERS
		//
		CaveRoom[][][] c = CaveExplorer.caves;
		c[0] = new NPCRoom[7][7];
		c[1] = new NPCRoom[5][5];
		c[2] = new NPCRoom[3][3];
		
		//
		//GENERATES PYRAMID
		//
		for(int flr = 0; flr < c.length; flr++) {
			for(int row = 0; row < c[flr].length; row++) {
				for(int col = 0; col < c[flr][row].length; col ++) {
					c[flr][row][col] = new NPCRoom("This cave has coordinates "+flr+","+row+","+col);
					c[flr][row][col].setFloor(flr);
				}
			}
		}
		
		//
		//CUSTOM NPCS
		//
		CaveExplorer.npcs = new NPC[1];
		
		Mummy mummy1 = new Mummy();
		mummy1.setPosition(0,1,3);
		CaveExplorer.npcs[0] = mummy1;
		
		//
		//CUSTOM ROOMS
		//
		c[0][0][3] = new WilliamStairwayRoom("There is a staircase leading to the second floor.");
		c[0][3][3] = new TristanRoom("Text");
		c[0][3][0] = new WeiCustomRoom("A Moogle appears in front of you as you enter the room");
		c[0][0][0] = new TheoRoom("asdf");
		c[0][0][6] = new DYroom("mhm");
		
		
		//
		//STARTING PLAYER POSITION
		//
		CaveExplorer.currentRoom = c[0][6][3];	
		CaveExplorer.currentRoom.enter();
		
		//
		//ALL THE HALLWAYS AND CONNECTIONS TO EACH ROOM
		//
		c[0][0][0].setConnection(EAST, c[0][0][1], new Door());
		c[0][0][1].setConnection(EAST, c[0][0][2], new Door());
		c[0][0][2].setConnection(SOUTH, c[0][1][2], new Door());
		c[0][0][3].setConnection(SOUTH, c[0][1][3], new Door());
		c[0][0][3].doors[SOUTH].setOpen(false);
		c[0][0][3].doors[SOUTH].setLocked(true);
		c[0][0][4].setConnection(EAST, c[0][0][5], new Door());
		c[0][0][4].setConnection(SOUTH, c[0][1][4], new Door());
		c[0][0][5].setConnection(EAST, c[0][0][6], new Door());
		c[0][0][6].setConnection(EAST, c[0][1][6], new Door());
		c[0][1][0].setConnection(EAST, c[0][1][1], new Door());
		c[0][1][1].setConnection(EAST, c[0][1][2], new Door());
		c[0][1][2].setConnection(EAST, c[0][1][3], new Door());
		c[0][1][2].setConnection(SOUTH, c[0][2][2], new Door());
		c[0][1][3].setConnection(EAST, c[0][1][4], new Door());
		c[0][1][3].setConnection(SOUTH, c[0][2][3], new Door());
		c[0][1][4].setConnection(EAST, c[0][1][5], new Door());
		c[0][1][4].setConnection(SOUTH, c[0][2][4], new Door());
		c[0][1][5].setConnection(EAST, c[0][1][6], new Door());
		c[0][2][0].setConnection(SOUTH, c[0][3][0], new Door());
		c[0][2][2].setConnection(EAST, c[0][2][3], new Door());
		c[0][2][2].setConnection(SOUTH, c[0][3][2], new Door());
		c[0][2][3].setConnection(EAST, c[0][2][4], new Door());
		c[0][2][3].setConnection(SOUTH, c[0][3][3], new Door());
		c[0][2][4].setConnection(SOUTH, c[0][3][4], new Door());
		c[0][2][6].setConnection(SOUTH, c[0][3][6], new Door());
		c[0][3][0].setConnection(EAST, c[0][3][1], new Door());
		c[0][3][0].setConnection(SOUTH, c[0][4][0], new Door());
		c[0][3][1].setConnection(EAST, c[0][3][2], new Door());
		c[0][3][2].setConnection(EAST, c[0][3][3], new Door());
		c[0][3][2].setConnection(SOUTH, c[0][4][2], new Door());
		c[0][3][3].setConnection(EAST, c[0][3][4], new Door());
		c[0][3][3].setConnection(SOUTH, c[0][4][3], new Door());
		c[0][3][4].setConnection(EAST, c[0][3][5], new Door());
		c[0][3][4].setConnection(SOUTH, c[0][4][4], new Door());
		c[0][3][5].setConnection(EAST, c[0][3][6], new Door());
		c[0][3][6].setConnection(SOUTH, c[0][4][6], new Door());
		c[0][4][2].setConnection(EAST, c[0][4][3], new Door());
		c[0][4][2].setConnection(SOUTH, c[0][5][2], new Door());
		c[0][4][3].setConnection(EAST, c[0][4][4], new Door());
		c[0][4][3].setConnection(SOUTH, c[0][5][3], new Door());
		c[0][4][4].setConnection(SOUTH, c[0][5][4], new Door());
		c[0][5][0].setConnection(EAST, c[0][5][1], new Door());
		c[0][5][1].setConnection(EAST, c[0][5][2], new Door());
		c[0][5][2].setConnection(EAST, c[0][5][3], new Door());
		c[0][5][3].setConnection(EAST, c[0][5][4], new Door());
		c[0][5][3].setConnection(SOUTH, c[0][6][3], new Door());
		c[0][5][3].doors[SOUTH].setOpen(false);
		c[0][5][3].doors[SOUTH].setLocked(true);
		c[0][5][4].setConnection(EAST, c[0][5][5], new Door());
		c[0][5][5].setConnection(EAST, c[0][5][6], new Door());
		c[0][6][0].setConnection(EAST, c[0][6][1], new Door());
		c[0][6][1].setConnection(EAST, c[0][6][2], new Door());
		c[0][6][2].setConnection(EAST, c[0][6][3], new Door());
		c[0][6][3].setConnection(EAST, c[0][6][4], new Door());
		c[0][6][4].setConnection(EAST, c[0][6][5], new Door());
		c[0][6][5].setConnection(EAST, c[0][6][6], new Door());
	}
	
	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen()){	
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		} else {
			System.err.println("You can't do that!");
		}
	}
	
	public static int oppositeDirection(int dir) {
		return (dir + 2) % 4;
	}

	public void setDefaultContents(String defaultsContents) {
		this.defaultContents = defaultsContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Door getDoor(int direction) {
		return doors[direction];
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int x) {
		this.floor = x;
	}
}
