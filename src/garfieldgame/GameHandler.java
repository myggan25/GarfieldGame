package garfieldgame;

public class GameHandler {

    public GameHandler() {
    }

    /**
     * Perform all events on the GameBoard
     *
     * @param board
     */
    public static void tick(GameBoard board) {
        int distanceFromGround;
        board.moveWholeBoard();
        board.getPlayer().takeAction();
        landOrCollideWithObstacle(board);
        distanceFromGround = board.getPlayer().testLandOnGround(board.getHeight());//landOnGround(board);
        ifOnGroundLand(board, distanceFromGround);
        fallFromObstacle(board, distanceFromGround);
        hitPowerbottle(board);
    }

    /**
     * For all obstacle, check if the player hit it.
     * If hit happens from above, make sure it lands.
     * If hit from other direction make sure the player dies.
     *
     * @param board
     */
    private static void landOrCollideWithObstacle(GameBoard board) {
        int distanceFromObject;
        if (!board.getObstacles().isEmpty()) {
            for (Obstacle obstacle : board.getObstacles()) {
                distanceFromObject = landOnObject(board.getPlayer(), obstacle);
                if (distanceFromObject != -1 && board.getPlayer().getStatus() == PlayerStatus.FALLING) {
<<<<<<< HEAD
                    board.getPlayer().landOnObject(distanceFromObject);
=======
                    board.getPlayer().land(distanceFromObject);
>>>>>>> Fixat kompletteringen
                }
                if (intersects(board.getPlayer(), obstacle)) {
                    //Spelaren dör
                    board.setGameOver(true);
                }
            }
        }
    }

    /**
     * Checks if the player is about to land while he is falling.
     * If the player is close enough to the ground it makes the player land
     */
    private static void ifOnGroundLand(GameBoard board, int distanceFromGround) {
        if (distanceFromGround != -1 && board.getPlayer().getStatus() == PlayerStatus.FALLING) {
<<<<<<< HEAD
            board.getPlayer().landOnObject(distanceFromGround);
=======
            board.getPlayer().land(distanceFromGround);
>>>>>>> Fixat kompletteringen
        }
    }

    /**
     * Checks if the player has anything underneath while he is standing, if not he starts to fall
     */
    private static void fallFromObstacle(GameBoard board, int distanceFromGround) {
        if (emptyUnder(board) && board.getPlayer().getStatus() == PlayerStatus.STANDING) {
            if (distanceFromGround != -1) {
<<<<<<< HEAD
                board.getPlayer().landOnObject(distanceFromGround);
=======
                board.getPlayer().land(distanceFromGround);
>>>>>>> Fixat kompletteringen
            } else {
                board.getPlayer().fall();
            }
        }
    }

    /**
     * function that check if player hits powerbottle, if it does remove the bottle
     *
     * @param board
     */
    private static void hitPowerbottle(GameBoard board) {
        Powerbottle tempBottle = null;
        if (!board.getPowerbottles().isEmpty()) {
            for (Powerbottle bottle : board.getPowerbottles()) {
                if (intersects(board.getPlayer(), bottle)) {
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

    /**
     * @param player
     * @param object
     * @return the distance in pixels to an object below.
     *         If more than 15 it returns -1
     */
    private static int landOnObject(BoardObject player, BoardObject object) {
        if (player.getXCoord() <= object.getXCoord() + object.getWidth() && player.getXCoord() + player.getWidth() >= object.getXCoord() &&
                player.getYCoord() + player.getHeight() + 15 >= object.getYCoord() && player.getYCoord() + player.getHeight() <= object.getYCoord()) {
            return -(player.getYCoord() + player.getHeight() - object.getYCoord() + 1);
        } else {
            return -1;
        }
    }

    /**
     * @param board
     * @return true if there is no object under
     */
    private static boolean emptyUnder(GameBoard board) {
        Player player = board.getPlayer();
        for (Obstacle obstacle : board.getObstacles()) {
            if (player.getXCoord() <= obstacle.getXCoord() + obstacle.getWidth() && player.getXCoord() + player.getWidth() >= obstacle.getXCoord() &&
                    player.getYCoord() + player.getHeight() + 10 >= obstacle.getYCoord() && player.getYCoord() + player.getHeight() <= obstacle.getYCoord()) {
                return false;
            }
        }
        if (player.getYCoord() + player.getHeight() == board.getHeight()) {
            return false;
<<<<<<< HEAD
        }
        return true;
    }

    /**
     * checks the players distance from the ground
     *
     * @param board
     * @return the distance in pixels to the ground below
     *         If more than 15 it returns -1
     */
    private static int landOnGround(GameBoard board) {
        if (board.getPlayer().getYCoord() + board.getPlayer().getHeight() + 15 >= board.getHeight() &&
                board.getPlayer().getYCoord() + board.getPlayer().getHeight() <= board.getHeight()) {
            return -(board.getPlayer().getYCoord() + board.getPlayer().getHeight() - board.getHeight());
        } else {
            return -1;
        }
    }

    /**
     * @param obj1
     * @param obj2
     * @return true if the objects intersects with each other
     *         else returns false
     */
    private static boolean intersects(BoardObject obj1, BoardObject obj2) {
        int obj1Left, obj1Right, obj1Bottom, obj1Top, obj2Top, obj2Left, obj2Right, obj2Bottom;
        obj1Left = obj1.getXCoord();
        obj1Right = obj1.getXCoord() + obj1.getWidth();
        obj1Bottom = obj1.getYCoord() + obj1.getHeight();
        obj1Top = obj1.getYCoord();
        obj2Left = obj2.getXCoord();
        obj2Right = obj2.getXCoord() + obj2.getWidth();
        obj2Top = obj2.getYCoord();
        obj2Bottom = obj2.getYCoord() + obj2.getHeight();
        if (obj1Right >= obj2Left && obj1Top <= obj2Bottom && obj1Bottom >= obj2Top && obj1Left <= obj2Right) {
            return true;
        }
=======
        }
        return true;
    }

    /**
     * checks the players distance from the ground
     *
     * @param board
     * @return the distance in pixels to the ground below
     *         If more than 15 it returns -1
     */
    /*private static int landOnGround(GameBoard board) {
        if (board.getPlayer().getYCoord() + board.getPlayer().getHeight() + 15 >= board.getHeight() &&
                board.getPlayer().getYCoord() + board.getPlayer().getHeight() <= board.getHeight()) {
            return -(board.getPlayer().getYCoord() + board.getPlayer().getHeight() - board.getHeight());
        } else {
            return -1;
        }
    }*/

    /**
     * @param obj1
     * @param obj2
     * @return true if the objects intersects with each other
     *         else returns false
     */
    private static boolean intersects(BoardObject obj1, BoardObject obj2) {
        int obj1Left, obj1Right, obj1Bottom, obj1Top, obj2Top, obj2Left, obj2Right, obj2Bottom;
        obj1Left = obj1.getXCoord();
        obj1Right = obj1.getXCoord() + obj1.getWidth();
        obj1Bottom = obj1.getYCoord() + obj1.getHeight();
        obj1Top = obj1.getYCoord();
        obj2Left = obj2.getXCoord();
        obj2Right = obj2.getXCoord() + obj2.getWidth();
        obj2Top = obj2.getYCoord();
        obj2Bottom = obj2.getYCoord() + obj2.getHeight();
        if (obj1Right >= obj2Left && obj1Top <= obj2Bottom && obj1Bottom >= obj2Top && obj1Left <= obj2Right) {
            return true;
        }
>>>>>>> Fixat kompletteringen
        return false;
    }
}
