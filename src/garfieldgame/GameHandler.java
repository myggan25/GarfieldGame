package garfieldgame;

public class GameHandler {

    
    public static void tick(GameBoard board){
        board.moveWholeBoard();
        Powerbottle tempBottle = null;
        int distanceFromObject,distanceFromGround;
        if(!board.getObstacles().isEmpty()){
            //System.out.println("ej tom");
            for(Obstacle obstacle : board.getObstacles()){
                distanceFromObject = landOnObject(board.getPlayer(), obstacle);
                if(distanceFromObject!=-1 && board.getPlayer().getStatus()==PlayerStatus.FALLING){
                    System.out.println("avstånd: " + distanceFromObject);
                    board.getPlayer().landOnObject(distanceFromObject);
                }
                /*else if(emptyUnder(board.getPlayer(), obstacle) && board.getPlayer().getStatus()==PlayerStatus.STANDING){
                    board.getPlayer().setStatus(PlayerStatus.FALLING);
                }*/
                if(intersects(board.getPlayer(),obstacle)){
                    //System.out.println("dö");
                    
                    //board.getPlayer().setStatus(PlayerStatus.STANDING);
                    //board.getPlayer().landOnObject();
                }
            }
        }
        distanceFromGround = landOnGround(board);
        if(distanceFromGround!=-1 && board.getPlayer().getStatus()==PlayerStatus.FALLING){
            board.getPlayer().landOnObject(distanceFromGround);
        }
        if(!emptyUnder(board) && board.getPlayer().getStatus()==PlayerStatus.STANDING){
            board.getPlayer().fall();
        }
        
        if(!board.getPowerbottles().isEmpty()){
            for(Powerbottle bottle : board.getPowerbottles()){
                if(intersects(board.getPlayer(),bottle)){
                    System.out.println("träff bottle");
                    tempBottle = bottle;
                    //board.removeBottleFromBoard(bottle);
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
         * If more than 10 it returns -1
         */
        private static int landOnObject(BoardObject player, BoardObject object){
            //System.out.println((player.getYCoord()+player.getHeight()));
            //System.out.println(object.getYCoord());
            if(player.getXCoord()<=object.getXCoord()+object.getWidth() && player.getXCoord()+player.getWidth()>=object.getXCoord() &&
                    player.getYCoord()+player.getHeight()+10>=object.getYCoord() && player.getYCoord()+player.getHeight()<=object.getYCoord()){
                //System.out.println(-(player.getYCoord()+player.getHeight()-object.getYCoord()));
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
                return true;
            
            /*for(Obstacle obstacle : board.getObstacles()){
                if(player.getXCoord()<=obstacle.getXCoord()+obstacle.getWidth() && player.getXCoord()+player.getWidth()>=obstacle.getXCoord() &&
                        player.getYCoord()+player.getHeight()>=obstacle.getYCoord()){
                    System.out.println("träff");
                    return false;
                }
            }
            if(player.getYCoord()+player.getHeight()==board.getHeight()){
                System.out.println("player " + (player.getYCoord()+player.getHeight()));
                System.out.println("board " + board.getHeight());
                if(player.getYCoord()+player.getHeight()>=board.getHeight()){
                    //System.out.println("ok");
                }
                return false;
            }
            return true;*/
        }
         /***
         * Returns the distance in pixels to the ground below
         * If more than 10 it returns -1
         */
        private static int landOnGround(GameBoard board){
            if(board.getPlayer().getYCoord()+board.getPlayer().getHeight()+10>=board.getHeight() &&
                    board.getPlayer().getYCoord()+board.getPlayer().getHeight()<=board.getHeight()){
                return -(board.getPlayer().getYCoord()+board.getPlayer().getHeight()-board.getHeight());
            }
            else{
              return -1;  
            }
        }

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
            if(obj1Right>=obj2Left && obj1Top<=obj2Bottom && obj1Bottom>=obj2Top && obj1Left<=obj2Right){
                return true;
            }
            return false;   
        }

}
