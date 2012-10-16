package garfieldgame;

public class GameHandler {

    public GameHandler(){}
    
 /***
  * Utför alla händelser på spelplanen
  */
    public static void tick(GameBoard board){
        int distanceFromGround;
        board.moveWholeBoard();
        board.getPlayer().takeAction();
        landOrCollideWithObstacle(board);
        distanceFromGround = landOnGround(board);
        ifOnGroundLand(board, distanceFromGround);
        fallFromObstacle(board, distanceFromGround);
        hitPowerbottle(board);
    }
    
    /***
     * Undersök för alla hinder om spelaren krockar med det.
     * Om den krockar med det åvanifrån så se till att den landar,
     * annars vid krock från övriga ställen se till så den dör.
     */
    private static void landOrCollideWithObstacle(GameBoard board){
        int distanceFromObject;
        if(!board.getObstacles().isEmpty()){
            for(Obstacle obstacle : board.getObstacles()){
                distanceFromObject = landOnObject(board.getPlayer(), obstacle);
                if(distanceFromObject!=-1 && board.getPlayer().getStatus()==PlayerStatus.FALLING){
                    board.getPlayer().landOnObject(distanceFromObject);
                }
                if(intersects(board.getPlayer(),obstacle)){
                    //Spelaren dör
                    board.setGameOver(true);
                }
            }
        }
    }
    
    private static void ifOnGroundLand(GameBoard board, int distanceFromGround){
       // int distanceFromGround = landOnGround(board);
        if(distanceFromGround!=-1 && board.getPlayer().getStatus()==PlayerStatus.FALLING){
            board.getPlayer().landOnObject(distanceFromGround);
        }
    }
    
    private static void fallFromObstacle(GameBoard board, int distanceFromGround){
        if(emptyUnder(board) && board.getPlayer().getStatus()==PlayerStatus.STANDING){
            if(distanceFromGround!=-1){
                board.getPlayer().landOnObject(distanceFromGround);
            }
            else{
                board.getPlayer().fall();
            }
        }
    }
    
    private static void hitPowerbottle(GameBoard board){
        Powerbottle tempBottle = null;
        if(!board.getPowerbottles().isEmpty()){
            for(Powerbottle bottle : board.getPowerbottles()){
                if(intersects(board.getPlayer(),bottle)){
                    board.getPlayer().increasPowerbottlesCaught();
                    tempBottle = bottle;
                }
            }
            board.removeBottleFromBoard(tempBottle);
        }
    }
	    
	/*****************************************
	 *SANNINGSV�RDEN F�R KOLLISION MED HINDER*
	 *****************************************/
        
	/***
         * Returns the distance in pixels to an object below.
         * If more than 15 it returns -1
         */
        private static int landOnObject(BoardObject player, BoardObject object){
            if(player.getXCoord()<=object.getXCoord()+object.getWidth() && player.getXCoord()+player.getWidth()>=object.getXCoord() &&
                    player.getYCoord()+player.getHeight()+15>=object.getYCoord() && player.getYCoord()+player.getHeight()<=object.getYCoord()){
                return -(player.getYCoord()+player.getHeight()-object.getYCoord()+1);
            }
            else{
                return -1;
            }
        }
        private static boolean emptyUnder(GameBoard board){
            Player player = board.getPlayer();
            for(Obstacle obstacle : board.getObstacles()){
                if(player.getXCoord()<=obstacle.getXCoord()+obstacle.getWidth() && player.getXCoord()+player.getWidth()>=obstacle.getXCoord() &&
                        player.getYCoord()+player.getHeight()+10>=obstacle.getYCoord() && player.getYCoord()+player.getHeight()<=obstacle.getYCoord()){
                    return false;
                }
            }
            if(player.getYCoord()+player.getHeight()==board.getHeight()){
                return false;
            }
            return true;
        }
        
         /***
         * Returns the distance in pixels to the ground below
         * If more than 15 it returns -1
         */
        private static int landOnGround(GameBoard board){
            if(board.getPlayer().getYCoord()+board.getPlayer().getHeight()+15>=board.getHeight() &&
                    board.getPlayer().getYCoord()+board.getPlayer().getHeight()<=board.getHeight()){
                return -(board.getPlayer().getYCoord()+board.getPlayer().getHeight()-board.getHeight());
            }
            else{
              return -1;  
            }
        }

        private static boolean intersects(BoardObject obj1, BoardObject obj2){
            int obj1Left,obj1Right,obj1Bottom,obj1Top,obj2Top,obj2Left,obj2Right,obj2Bottom;
            obj1Left=obj1.getXCoord();
            obj1Right=obj1.getXCoord()+obj1.getWidth();
            obj1Bottom=obj1.getYCoord()+obj1.getHeight();
            obj1Top=obj1.getYCoord();
            obj2Left=obj2.getXCoord();
            obj2Right=obj2.getXCoord()+obj2.getWidth();
            obj2Top=obj2.getYCoord();
            obj2Bottom=obj2.getYCoord()+obj2.getHeight();
            if(obj1Right>=obj2Left && obj1Top<=obj2Bottom && obj1Bottom>=obj2Top && obj1Left<=obj2Right){
                return true;
            }
            return false;   
        }
}
