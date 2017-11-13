package WeixiongTristanMinigame;

public class WeixiongBackEnd implements TristanSupport{

	private WeixiongSupport frontend;
	private Object[][] maze;
	
	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		
	}
}
