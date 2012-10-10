package garfieldgame;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private final int lowDefaultYCoordObstacle, highDefaultYCoordObstacle, midDefaultYCoordObstacle, groundXCoord;
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
                lowDefaultYCoordObstacle=height-100;
                highDefaultYCoordObstacle=height-300;
                midDefaultYCoordObstacle=height-160;
                groundXCoord=height;
		leftBorder=0;
		rightBorder=visibleWidth;
                obstacles = new ArrayList<Obstacle>();
		powerbottles = new ArrayList<Powerbottle>();
		
		/****************************
		 * Dessa saker �r i testsyfte
		 ****************************/
                createMap3();
                
                
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
            for(int i=0;i<300;i++){
                powerbottles.add(new Powerbottle(20, 10, 950+i*300, 300));
            }
            
            for(int i=0;i<100;i++){
                obstacles.add(new Obstacle(100, 100, i*900+1300, lowDefaultYCoordObstacle));
            }
            for(int i=0;i<100;i++){
                obstacles.add(new Obstacle(100, 100, i*900+1600, midDefaultYCoordObstacle));
            }
            for(int i=0;i<100;i++){
                obstacles.add(new Obstacle(100, 100, i*900+1900, highDefaultYCoordObstacle));
            }
            
            
	}
        public void createMap2(){
            powerbottles.add(new Powerbottle(20, 10, 1300, 300));
            powerbottles.add(new Powerbottle(20, 10, 1500, 300));
            powerbottles.add(new Powerbottle(20, 10, 1700, 300));
            powerbottles.add(new Powerbottle(20, 10, 2000, 300));
            powerbottles.add(new Powerbottle(20, 10, 2400, 300));
                
            
            obstacles.add(new Obstacle(100, 100, 1600, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 1900, highDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2200, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2400, midDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 2700, highDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 500, 3000, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3500, highDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3600, midDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 3800, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 4500, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 4900, midDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 5300, highDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 5400, lowDefaultYCoordObstacle));
        }
        private Obstacle createObstacle(int xCoord){
            Random generator = new Random();
            int height = 50+generator.nextInt(100);
            return new Obstacle(height,50+generator.nextInt(100),xCoord,generator.nextInt(this.mapHeight-height));
        }
        private Powerbottle createPowerbottle(int xCoord){
            Random generator = new Random();
            return new Powerbottle(20, 10, xCoord, generator.nextInt(this.mapHeight));
        }
        public void createMap3(){
            for(int i=0;i<300;i++){
                powerbottles.add(createPowerbottle(i*120+1200));
            }
            for(int i=0;i<300;i++){
                obstacles.add(createObstacle(i*170+1000));
            }
            
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
