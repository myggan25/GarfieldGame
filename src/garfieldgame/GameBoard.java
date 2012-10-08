package garfieldgame;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class GameBoard {
	private final int width, height;
	private Player garfield;
	private ArrayList<BoardListener> boardListeners;
	private Map map;
        private ArrayList<Obstacle> obstacles;
        private ArrayList<Powerbottle> powerbottles;
	
	public GameBoard(int width, int height){
            boardListeners = new ArrayList<BoardListener>();
            this.width=width;
            this.height=height;
            this.map = new Map(width*50, height, width);
            obstacles = new ArrayList<Obstacle>();
            powerbottles = new ArrayList<Powerbottle>();
		
		/*Tilldela h�jd och bredd p� spelplanen
		 * 
		 * Skapa en ny lista med boardlisteners
		 * 
		 * Skapa spelplanen och Gustaf
		 */
	}
	
	public void tick(){
		//anropa GameHandlers tick f�r att �ndra spelet, dvs flytta spelplanen framm�t
		map.moveMapLeft();
                moveObjectsOnBoard();
                moveObstacleFromMapToBoard();
                moveBottleFromMapToBoard();
		notifyListeners();
	}
        
        private void moveObjectsOnBoard(){
            for(Obstacle obstacle : obstacles){
                    obstacle.moveLeft();
                }
            for(Powerbottle bottle : powerbottles){
                    bottle.moveLeft();
                    
                }
        }
	
	public void addBoardListener(BoardListener bl){
		boardListeners.add(bl);
		
	}

	private void notifyListeners(){
		if(boardListeners!=null){
			for (BoardListener listener : boardListeners) {
				listener.boardChanged();
			}
		}
	}
	
        private void moveObstacleFromMapToBoard(){
            Obstacle tempObs;
            tempObs = map.ifInBoardGetObstacle();
            if(tempObs!=null){
                obstacles.add(tempObs);
            }
        }
        private void moveBottleFromMapToBoard(){
            Powerbottle tempBottle;
            tempBottle = map.ifInBoardGetPowerbottle();
            if(tempBottle!=null){
                powerbottles.add(tempBottle);
            }
        }
        
        public ArrayList<Obstacle> getObstacles(){
            return obstacles;
        }
        public ArrayList<Powerbottle> getPowerBottles(){
            return powerbottles;
        }
        
	/*---------
	 * SETTERS
	 ---------*/
	
	private void addPlayer(Player player){
		garfield = player;
	}
	
	/*---------
	 * GETTERS
	 ---------*/
	public Map getMap(){
		return map;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Player getPlayer(){
		//H�mta player fr�n Player
		return garfield;
	}
	/*public Obstacle getCurrentObstacle(){
		//ska nog �ndras till en funktion som returnerar en lista med alla nuvarande hinder p� banan
		return map.getObstacle();
	}
	public Powerbottle getCurrentPowerbottle() {
		//ska nog �ndras till en funktion som returnerar en lista med alla nuvarande energiflaskor p� banan
		return map.getPowerbottle();
	}*/
	
	/*--------------
	 * BOARDCHANGERS 
	 ---------------*/
	
	/*public void moveObjects(){
		//flytta alla object i spelplanen lika mycket
	}*/	

	
}
