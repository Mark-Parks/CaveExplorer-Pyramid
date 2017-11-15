package WeixiongTristanMinigame;

public interface TristanSupport {
	//makes the backend interpretation of the maze
	void createMaze();
	//gets maze from backend
	Block[][] getMaze();
}
