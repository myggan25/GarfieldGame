package garfieldgame;

import java.util.ArrayList;

public class Map {
    private final int mapHeight;
    private int rightBorder;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Powerbottle> powerbottles;

    public Map(int height, int visibleWidth) {
        this.mapHeight = height;
        rightBorder = visibleWidth;
        obstacles = new ArrayList<Obstacle>();
        powerbottles = new ArrayList<Powerbottle>();

        // Choose a map to run with a number between 1 and 5.
        //createMap(3);
        //CreateMap.createMap(this,3);
    }

    public void moveMapLeft() {
        for (Obstacle obstacle : obstacles) {
            obstacle.moveLeft();
        }
        for (Powerbottle bottle : powerbottles) {
            bottle.moveLeft();
        }
    }

    public boolean obstaclesLeft() {
        if (obstacles.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /*---------
      * GETTERS
      ---------*/

    /**
     * If an obstacle is about to move into the gameboard,
     * return it and remove it from the obstacle array
     */
    public Obstacle ifInBoardGetObstacle() {
        Obstacle tempObs;
        if (obstacles != null) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle.getXCoord() < rightBorder) {
                    tempObs = obstacle;
                    obstacles.remove(obstacle);
                    return tempObs;
                }
            }
        }
        return null;
    }

    /**
     * If a powerbottle is about to move into the gameboard,
     * return it and remove it from the powerbottle array
     */
    public Powerbottle ifInBoardGetPowerbottle() {
        Powerbottle tempBottle;
        if (powerbottles != null) {
            for (Powerbottle bottle : powerbottles) {
                if (bottle.getXCoord() < rightBorder) {
                    tempBottle = bottle;
                    powerbottles.remove(bottle);
                    return tempBottle;
                }
            }
        }
        return null;
    }

    public void addPowerbottle(Powerbottle bottle){
        powerbottles.add(bottle);
    }
    
    public void addObstacle(Obstacle obstacle){
        obstacles.add(obstacle);
    }
    public int getHeight(){
        return mapHeight;
    }

    

}
