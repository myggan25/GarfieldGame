package garfieldgame;

public class Obstacle implements BoardObject {
    private int height, width, xCoord, yCoord;

    public Obstacle(int height, int width, int xCoord, int yCoord) {
        this.height = height;
        this.width = width;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void moveLeft() {
        //Move obstacle left
        xCoord -= 2;

    }

    /*----------
      * GETTERS
      **********/
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    /*----------
      * SETTERS
      **********/
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}