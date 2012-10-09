package garfieldgame;

public class GameHandler {

    
    public static void tick(GameBoard board){
        board.moveWholeBoard();
        if(!board.getObstacles().isEmpty()){
            //System.out.println("ej tom");
            for(Obstacle obstacle : board.getObstacles()){
                if(intersects(board.getPlayer(),obstacle)){
                    System.out.println("träff obstacle");
                }
            }
        }
        if(!board.getPowerbottles().isEmpty()){
            for(Powerbottle bottle : board.getPowerbottles()){
                if(intersects(board.getPlayer(),bottle)){
                    System.out.println("träff bottle");
                }
            }
        }
    }
	public static boolean checkIfFalling(){
		//Kolla om spelaren har n�got "fast" under sig
		return false;
	}

	
	public void fall(){
		//G�r s� att spelaren faller
	}
	
	public static void checkIfHitOnBoard(Player player, Obstacle obstacle, Powerbottle powerbottle){
		//G�r kontinuerligt kollar f�r att kolla om det uppst�r en kollision
            /*if(hitObstacleDown(player, obstacle)){
                System.out.println("träff");
            }*/
	}
	    
	/*****************************************
	 *SANNINGSV�RDEN F�R KOLLISION MED HINDER*
	 *****************************************/
	
        private static boolean intersects(BoardObject obj1,BoardObject obj2){
                     int obj1Left,obj1Right,obj1Bottom,obj1Top,obj2Top,obj2Left,obj2Right,obj2Bottom;
            obj1Left=obj1.getXCoord();
            obj1Right=obj1.getXCoord()+obj1.getWidth();
            obj1Bottom=obj1.getYCoord()+obj1.getHeight();
            obj1Top=obj1.getYCoord();
            obj2Left=obj2.getXCoord();
            obj2Right=obj2.getXCoord()+obj2.getWidth();
            obj2Top=obj2.getYCoord();
            obj2Bottom=obj2.getYCoord()+obj2.getHeight();
            //System.out.println(obstacle.getXCoord());
            //System.out.println(playerRight +">" + obstacleLeft);
            //System.out.println(playerTop +"<" + obstacleBottom);
            //System.out.println(playerBottom +">" + obstacleTop);
            if(obj1Right>=obj2Left && obj1Top<=obj2Bottom && obj1Bottom>=obj2Top && obj1Left<=obj2Right){
                return true;
            }
            return false;   
        }
        
        
	private static boolean hitObstacle(Player player, Obstacle obstacle){
		//K�r kollisionskoll f�r alla v�rden
		//Anv�nder sig av nedanst�ende metoder
		return false;
	}
	
	private static boolean hitObstacleUp(Player player, Obstacle obstacle){
		//Skapa sanningsv�rde f�r om spelaren hoppar in i ett object
            
		return false;
	}
	private static boolean hitObstacleRight(Player player, Obstacle obstacle){
		//Skapa sanningsv�rde f�r om spelaren springer in i ett object
            //System.out.println(obstacle.getWidth());   
            int playerLeft,playerRight,playerBottom,playerTop,obstacleTop,obstacleLeft,obstacleRight,obstacleBottom;
            playerLeft=player.getXCoord();
            playerRight=player.getXCoord()+player.getWidth();
            playerBottom=player.getYCoord()+player.getHeight();
            playerTop=player.getYCoord();
            obstacleLeft=obstacle.getXCoord();
            obstacleRight=obstacle.getXCoord()+obstacle.getWidth();
            obstacleTop=obstacle.getYCoord();
            obstacleBottom=obstacle.getYCoord()+obstacle.getHeight();
            //System.out.println(obstacle.getXCoord());
            //System.out.println(playerRight +">" + obstacleLeft);
            //System.out.println(playerTop +"<" + obstacleBottom);
            //System.out.println(playerBottom +">" + obstacleTop);
            if(playerRight>=obstacleLeft && playerTop<=obstacleBottom && playerBottom>=obstacleTop){
                return true;
            }
            return false;
	}
	private static boolean hitObstacleDown(Player player, Obstacle obstacle){
		//Skapa sannisgsv�rde f�r om spelaren landar p� ett object
            int playerLeft,playerRight,playerBottom,playerTop,obstacleTop,obstacleLeft,obstacleRight,obstacleBottom;
            playerLeft=player.getXCoord();
            playerRight=player.getXCoord()+player.getWidth();
            playerBottom=player.getYCoord()+player.getHeight();
            playerTop=player.getYCoord();
            obstacleLeft=obstacle.getXCoord();
            obstacleRight=obstacle.getXCoord()+obstacle.getWidth();
            obstacleTop=obstacle.getYCoord();
            obstacleBottom=obstacle.getYCoord()+obstacle.getHeight();
            //System.out.println(obstacle.getXCoord());
            //System.out.println(playerRight +">" + obstacleLeft);
            //System.out.println(playerTop +"<" + obstacleBottom);
            //System.out.println(playerBottom +">" + obstacleTop);
            if(playerRight>=obstacleLeft && playerLeft<=obstacleRight &&
                    playerTop<=obstacleBottom && playerBottom>=obstacleTop){
                return true;
            }
            return false;
	}
		

	/*******************************************
	 *SANNINGSV�RDEN F�R KOLLISION MED POWERUPS*
	 *******************************************/
	
	private boolean hitPowerbottle(Player player, Powerbottle powerbottle){
		//K�r kollisionskoll f�r alla v�rden
		//Anv�nder sig av nedanst�ende metoder
		return false;
	}
	
	private boolean hitPowerbottleUp(Player player, Powerbottle powerbottle){
		//Skapa sanningsv�rde f�r om spelaren hoppar in i en powerup
		return false;
	}
	private boolean hitPowerbottleRight(Player player, Powerbottle powerbottle){
		//Skapa sanningsv�rde f�r om spelaren springer in i en powerup
		return false;
	}
	private boolean hitPowerbottleDown(Player player, Powerbottle powerbottle){
		//Skapa sannisgsv�rde f�r om spelaren landar p� en powerup
		return false;
	}
	
	/*******************************
	 *HANTERING AV ALLA KOLLISIONER*
	 *******************************/
	
	private void performObstacleHit(){
		//Skriv vad som h�nder om man tr�ffar ett hinder
	}
	
	private void performObstacleLand(){
		//Skriv vad som h�nder n�r spelaren landar p� ett hinder
	}
	
	private void performPowerbottleHit(){
		//Skriv vad som h�nder om man tr�ffar en powerbottle
	}

}
