package garfieldgame;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class GameBoard {
	private final int width, height, groundHeight;
	private Player player;
	private ArrayList<BoardListener> boardListeners;
	private Map map;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Powerbottle> powerbottles;

        
	
	public GameBoard(int width, int height){
            boardListeners = new ArrayList<BoardListener>();
            this.width=width;
            this.height=height;
            this.groundHeight=height/10;
            this.map = new Map(width*50, height, width);
            player  = new Player(100, 60, 50, 500); 
            //addPlayer(player);
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
		GameHandler.tick(this);
                player.takeAction();   
                //System.out.println((player.getYCoord()+player.getHeight()));
                //System.out.println((height));
		notifyListeners();
	}
        public void moveWholeBoard(){
                map.moveMapLeft();
                moveObjectsOnBoard();
		moveObstacleFromMapToBoard();
		moveBottleFromMapToBoard();
                removeObstacleFromBoard();
                removeBottleFromBoard();
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
        private void removeObstacleFromBoard(){
            if(!obstacles.isEmpty() && (obstacles.get(0).getXCoord()+obstacles.get(0).getWidth())<0){
                obstacles.remove(0);
            }
        }
        private void moveBottleFromMapToBoard(){
            Powerbottle tempBottle;
            tempBottle = map.ifInBoardGetPowerbottle();
            if(tempBottle!=null){
                powerbottles.add(tempBottle);
            }
        }
        private void removeBottleFromBoard(){
            if(!powerbottles.isEmpty() && (powerbottles.get(0).getXCoord()+powerbottles.get(0).getWidth())<0){
                powerbottles.remove(0);
            }
        }
        public void removeBottleFromBoard(Powerbottle bottle){
            if(!powerbottles.isEmpty()){
                powerbottles.remove(bottle);
            }
        }
                
        
        public ArrayList<Obstacle> getObstacles(){
            return obstacles;
        }
        public ArrayList<Powerbottle> getPowerbottles(){
            return powerbottles;
        }
        
	/*---------
	 * SETTERS
	 ---------*/
	
	private void addPlayer(Player player){
		this.player = player;
	}
	
	/*---------
	 * GETTERS
	 ---------*/
        public int getGroundHeight(){
            return groundHeight;
        }
        
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
		return player;
	}
	
	/*--------------
	 * BOARDCHANGERS 
	 ---------------*/
	
	/*public void moveObjects(){
		//flytta alla object i spelplanen lika mycket
	}*/	

	
}
