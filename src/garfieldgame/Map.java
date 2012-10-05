package garfield;

public class Map {
	private final int lowDefaultXCoordObstacle=600, highDefaultXCoordObstacle=300;
	private final int mapLength;
	private final int mapHeight;
	private Obstacle obstacle;
	private Powerbottle alcohol;
	private int leftBorder, rightBorder;
	
	
	public Map(int length, int height,int visibleWidth){
		this.mapHeight=height;
		this.mapLength=length;
		leftBorder=0;
		rightBorder=visibleWidth;
		
		
		/****************************
		 * Dessa saker är i testsyfte
		 ****************************/
		obstacle = new Obstacle(100, 100, 500, lowDefaultXCoordObstacle);
		alcohol = new Powerbottle(20, 10, 500, 500);
	}
	
	public void moveMapLeft(){
		leftBorder--;
		rightBorder--;
		obstacle.setXCoordMap(obstacle.getXCoordMap()-1);
		alcohol.setXCoordMap(alcohol.getXCoordMap()-1);
	}
	
	public void createMap(){
		//Skapa banan
	}
	
	public boolean checkIfObstacleOnScreen(){
		//Kolla om det finns något hinder på skärmen just då
		return false;
	}
	
	public boolean checkIfPowerbottleOnScreen(){
		//Kolla om det finns någon powerup på skämrne just då
		return false;
	}
	
	/*---------
	 * GETTERS
	 ---------*/
	
	public int getMapLength(){
		return mapLength;
	}
	
	public Obstacle getObstacle(){
		//Hämta obstacle från Obstacle
		return obstacle;
	}
	
	public Obstacle getObstacleInBoard(){
		//Hämta obstacle om den är i gameBoard
		return obstacle;
	}
	
	public Powerbottle getPowerbottle(){
		//Hämta powerbottle från Powerbottle
		return alcohol;
	}
	
	public Powerbottle getPowerbottleInBoard(){
		//Hämta powerbottle om den är i gameBoard
		return alcohol;
	}
	
	/*---------
	 * SETTERS
	 ---------*/


	public void setObstacleInGameBoard(){
		obstacle.setInBoard();
	}
	
	public void setPowerbottleInGameBoard(){
		alcohol.setInBoard();
	}
	
	public void addObstacle(Obstacle obs){
		//ska egentligen lägga in i en array
		obstacle = obs;
	}
	
	public void addPowerbottle(Powerbottle pb){
		//ska egentligen lägga in i en array
		alcohol = pb;
	}

}
