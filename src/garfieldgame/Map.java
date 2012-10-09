package garfieldgame;

import java.util.ArrayList;

public class Map {
	private final int lowDefaultXCoordObstacle, highDefaultXCoordObstacle, groundXCoord;
	private final int mapLength;
	private final int mapHeight;
	private Obstacle obstacle;
	private Powerbottle alcohol;
	private int leftBorder, rightBorder;
        private ArrayList<Obstacle> obstacles;
        private ArrayList<Powerbottle> powerbottles;
	
	
	public Map(int length, int height,int visibleWidth){
		this.mapHeight=height;
		this.mapLength=length;
                lowDefaultXCoordObstacle=height-100;
                highDefaultXCoordObstacle=height-160;
                groundXCoord=height;
		leftBorder=0;
		rightBorder=visibleWidth;
                obstacles = new ArrayList<Obstacle>();
		powerbottles = new ArrayList<Powerbottle>();
		
		/****************************
		 * Dessa saker �r i testsyfte
		 ****************************/
                createMap1();
                
                
		//obstacle = new Obstacle(100, 100, 500, lowDefaultXCoordObstacle);
		//alcohol = new Powerbottle(20, 10, 500, 500);
	}
	
	public void moveMapLeft(){
		//leftBorder+=4;
		//rightBorder+=4;
                for(Obstacle obstacle : obstacles){
                    //obstacle.setXCoord(obstacle.getXCoord()-4);
                    obstacle.moveLeft();
                }
                for(Powerbottle bottle : powerbottles){
                    bottle.moveLeft();
                    //bottle.setXCoord(alcohol.getXCoord()-4);
                }
	}
	
	public void createMap1(){
		//Skapa bana 1
            powerbottles.add(new Powerbottle(20, 10, 200, 300));
            powerbottles.add(new Powerbottle(20, 10, 500, 300));
            powerbottles.add(new Powerbottle(20, 10, 700, 300));
            powerbottles.add(new Powerbottle(20, 10, 1200, 300));
            powerbottles.add(new Powerbottle(20, 10, 1400, 300));
                
            //obstacles.add(new Obstacle(100, 100, 400, highDefaultXCoordObstacle));
            //obstacles.add(new Obstacle(100, 500, 700, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 1000, highDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 1300, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 1600, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2000, highDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2100, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2500, highDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 500, 2900, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3500, highDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3600, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3800, lowDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 4000, highDefaultXCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 4100, lowDefaultXCoordObstacle));
	}
	
	/*public boolean checkIfObstacleOnScreen(){
		//Kolla om det finns n�got hinder p� sk�rmen just d�
		return false;
	}*/
	
	public boolean checkIfPowerbottleOnScreen(){
		//Kolla om det finns n�gon powerup p� sk�mrne just d�
		return false;
	}
	
	/*---------
	 * GETTERS
	 ---------*/
	
	public int getMapLength(){
		return mapLength;
	}
	
	public Obstacle getObstacle(){
		//H�mta obstacle fr�n Obstacle
		return obstacle;
	}
        public int getLeftBorder(){
            return leftBorder;
        }
	
	/*public ArrayList<Obstacle> getObstaclesInBoard(){
		//H�mta obstacle om den �r i gameBoard
            ArrayList<Obstacle> returnObjects = new ArrayList<Obstacle>();
            if(obstacles!=null){
                    for (Obstacle obstacle : obstacles) {
                            if(obstacle.getXCoordMap()<rightBorder){
                                returnObjects.add(obstacle);
                                obstacles.remove(obstacle);
                            }
                    }
            }
            return returnObjects;
	}*/
        public Obstacle ifInBoardGetObstacle(){
            Obstacle tempObs;
            if(obstacles!=null){
                    for (Obstacle obstacle : obstacles) {
                            if(obstacle.getXCoord()<rightBorder){
                                tempObs = obstacle;
                                obstacles.remove(obstacle);
                                return tempObs;
                            }
                    }
            }
            return null;
        }
        public Obstacle getObstacleInBoard(){
		//H�mta powerbottle om den �r i gameBoard
		return obstacle;
	}
	
	public Powerbottle getPowerbottle(){
		//H�mta powerbottle fr�n Powerbottle
		return alcohol;
	}
	
	public Powerbottle getPowerbottleInBoard(){
		//H�mta powerbottle om den �r i gameBoard
		return alcohol;
	}
        public Powerbottle ifInBoardGetPowerbottle(){
            Powerbottle tempBottle;
            if(powerbottles!=null){
                    for (Powerbottle bottle : powerbottles) {
                            if(bottle.getXCoord()<rightBorder){
                                tempBottle = bottle;
                                powerbottles.remove(bottle);
                                return tempBottle;
                            }
                    }
            }
            return null;
        }
	
	/*---------
	 * SETTERS
	 ---------*/


	/*public void setObstacleInGameBoard(){
		obstacle.setInBoard();
	}
	
	public void setPowerbottleInGameBoard(){
		alcohol.setInBoard();
	}*/
	
	public void addObstacle(Obstacle obs){
		//ska egentligen l�gga in i en array
		obstacle = obs;
	}
	
	public void addPowerbottle(Powerbottle pb){
		//ska egentligen l�gga in i en array
		alcohol = pb;
	}

}
