package garfieldgame;

import java.util.ArrayList;


public class GameBoard {
    private final int width, height, groundHeight;
    private Player player;
    private ArrayList<BoardListener> boardListeners;
    private Map map;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Powerbottle> powerbottles;
    private Boolean gameOver;

    public GameBoard(int width, int height) {
        //Creates an array with listeners to the GameBoard
        boardListeners = new ArrayList<BoardListener>();
        this.width = width;
        this.height = height;
        this.groundHeight = height / 10;
        this.reset();
    }

    /**
     * resets the GameBoard if the game starts or restarts
     */
    public void reset() {
        this.map = new Map(height, width);
        CreateMap.createMap(this.map, 3);
        player = new Player(100, 60, 50, 500);
        obstacles = new ArrayList<Obstacle>();
        powerbottles = new ArrayList<Powerbottle>();
        gameOver = false;
    }

    /**
     * Sends a gameboard to the gamehandler to move the gameboard forward
     */
    public void tick() {
        GameHandler.tick(this);
        notifyListeners();
    }

    public void addBoardListener(BoardListener bl) {
        boardListeners.add(bl);
    }

    private void notifyListeners() {
        if (boardListeners != null) {
            for (BoardListener listener : boardListeners) {
                listener.boardChanged();
            }
        }
    }

    /**
     * Checks if there are any obstacles visible on the gameboard
     */
    private boolean obstaclesLeftOnBoard() {
        if (obstacles.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /*---------
      * SETTERS
      ---------*/

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    /*---------
      * GETTERS
      ---------*/
    public boolean isGameOver() {
        return gameOver;
    }

    public int getGroundHeight() {
        return groundHeight;
    }

    public Map getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public ArrayList<Powerbottle> getPowerbottles() {
        return powerbottles;
    }

    /*--------------
      * BOARDCHANGERS
      ---------------*/

    /**
     * Moves all the objects on the gameboard to the left, except the player
     */
    public void moveWholeBoard() {
        map.moveMapLeft();
        moveObjectsOnBoard();
        moveObstacleFromMapToBoard();
        moveBottleFromMapToBoard();
        removeObstacleFromBoard();
        removeFirstBottleFromBoard();
        ifEndOfMapCreateNew();
    }

    private void moveObjectsOnBoard() {
        for (Obstacle obstacle : obstacles) {
            obstacle.moveLeft();
        }
        for (Powerbottle bottle : powerbottles) {
            bottle.moveLeft();

        }
    }

    /**
     * Moves obstacles from the map to gameboard to make them visible
     */
    private void moveObstacleFromMapToBoard() {
        Obstacle tempObs;
        tempObs = map.ifInBoardGetObstacle();
        if (tempObs != null) {
            obstacles.add(tempObs);
        }
    }

    /**
     * When the obstacles move outside the gameboard to the left, remove them from the gameboard
     */
    private void removeObstacleFromBoard() {
        if (!obstacles.isEmpty() && (obstacles.get(0).getXCoord() + obstacles.get(0).getWidth()) < 0) {
            obstacles.remove(0);
        }
    }

    /**
     * Moves powerbottles from the map to gameboard to make them visible
     */
    private void moveBottleFromMapToBoard() {
        Powerbottle tempBottle;
        tempBottle = map.ifInBoardGetPowerbottle();
        if (tempBottle != null) {
            powerbottles.add(tempBottle);
        }
    }

    /**
     * When the powerbottles move outside the gameboard to the left, remove them from the gameboard
     */
    private void removeFirstBottleFromBoard() {
        if (!powerbottles.isEmpty() && (powerbottles.get(0).getXCoord() + powerbottles.get(0).getWidth()) < 0) {
            powerbottles.remove(0);
        }
    }

    /**
     * Removes a specific powerbottle from the gameboard
     */
    public void removeBottleFromBoard(Powerbottle bottle) {
        if (!powerbottles.isEmpty()) {
            powerbottles.remove(bottle);
        }
    }

    private void ifEndOfMapCreateNew() {
        if (!obstaclesLeftOnBoard() && !map.obstaclesLeft()) {
            map = new Map(height, width);
        }
    }


}
