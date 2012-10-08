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
	private int jumpCounter=0;
	private int fallCounter=0;
	private boolean jumping = false;
	private boolean falling = false;
	private boolean crouching = false;
	private boolean standing = true;
	private boolean unCrouch = false;
	
	public GameBoard(int width, int height){
            boardListeners = new ArrayList<BoardListener>();
            this.width=width;
            this.height=height;
            this.map = new Map(width*50, height, width);
            Player player = new Player(50, 50, width/2, 650); 
            addPlayer(player);
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
		if (jumping){
			jumpCounter = garfield.jump(jumpCounter);
			if(jumpCounter==0){
				jumping = false;
				falling = true;
			}
		}
		else if (falling){
			fallCounter = garfield.land(fallCounter);
			if (fallCounter ==0){
				falling=false;
			}
		}
		else if (crouching){
			standing = garfield.crouch(standing);
		}
		else if (unCrouch){
			standing = garfield.unCrouch(standing);
		}
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
	
	public void setJump(boolean jump){
		jumping = jump;
	}
	
	public void setCrouch(boolean crouch){
		crouching = crouch;
	}
	
	public void setUnCrouch(boolean unCrouched){
		unCrouch = unCrouched;
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
