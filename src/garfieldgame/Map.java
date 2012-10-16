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
	
	
	public Map(int length, int height, int visibleWidth){
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
                
                /***
                 * Välj en bana som ska köras med ett nummer mellan 1 och 5.
                 * */
                createMap(3);
	}
	
	public void moveMapLeft(){
                for(Obstacle obstacle : obstacles){
                    obstacle.moveLeft();
                }
                for(Powerbottle bottle : powerbottles){
                    bottle.moveLeft();
                }
	}
        
        public boolean obstaclesLeft(){
            if(obstacles.isEmpty()){
                return false;
            }
            else{
                return true;
            }
        }
	
	/*---------
	 * GETTERS
	 ---------*/
        
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
        
        /*-------------------------------
         * Funktioner för att skapa testbanor
         * ----------------------------*/
        
        /**
         * Funktion i testsyfte för att välja bana
         */
        
        private void createMap(int mapNumber){
            switch(mapNumber){
                case 1:
                    createMap1();
                    break;
                case 2:
                    createMap2();
                    break;
                case 3:
                    createMap3();
                    break;
                case 4:
                    createMap4();
                    break;
                case 5:
                    createMap5();
                    break;
                default:
                    createMap3();
                    break;
            }
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
	
	private void createMap1(){
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
        private void createMap2(){
            powerbottles.add(new Powerbottle(20, 10, 1300, 300));
            powerbottles.add(new Powerbottle(20, 10, 1500, 300));
            powerbottles.add(new Powerbottle(20, 10, 1700, 300));
            powerbottles.add(new Powerbottle(20, 10, 2000, 300));
            powerbottles.add(new Powerbottle(20, 10, 2400, 300));
            powerbottles.add(new Powerbottle(20, 10, 2700, 300));
            powerbottles.add(new Powerbottle(20, 10, 2900, 300));
            powerbottles.add(new Powerbottle(20, 10, 3300, 300));
            powerbottles.add(new Powerbottle(20, 10, 3400, 300));
            powerbottles.add(new Powerbottle(20, 10, 3700, 300));
            powerbottles.add(new Powerbottle(20, 10, 4000, 300));
            powerbottles.add(new Powerbottle(20, 10, 4300, 300));
            powerbottles.add(new Powerbottle(20, 10, 4600, 300));
            powerbottles.add(new Powerbottle(20, 10, 4900, 300));
            powerbottles.add(new Powerbottle(20, 10, 5300, 300));
            powerbottles.add(new Powerbottle(20, 10, 5700, 300));
                
            
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
            obstacles.add(new Obstacle(100, 100, 5600, lowDefaultYCoordObstacle));
        }

        private void createMap3(){
            for(int i=0;i<300;i++){
                powerbottles.add(createPowerbottle(i*120+1200));
            }
            for(int i=0;i<300;i++){
                obstacles.add(createObstacle(i*170+1000));
            }
            
        }
        private void createMap4(){
            powerbottles.add(new Powerbottle(20, 10, 1300, 300));
            powerbottles.add(new Powerbottle(20, 10, 1500, 300));
            powerbottles.add(new Powerbottle(20, 10, 1700, 300));
            powerbottles.add(new Powerbottle(20, 10, 2000, 300));
            powerbottles.add(new Powerbottle(20, 10, 2400, 300));
                
            
            obstacles.add(new Obstacle(100, 100, 1600, lowDefaultYCoordObstacle));
            obstacles.add(new Obstacle(100, 100, 1900, highDefaultYCoordObstacle));
        }
        private void createMap5(){
            for(int i=0;i<300;i++){
                obstacles.add(new Obstacle(100, 100, i*300, highDefaultYCoordObstacle+10));
            }
            for(int i=0;i<300;i++){
                powerbottles.add(new Powerbottle(20,10,i*300,500));
            }
        }

}
