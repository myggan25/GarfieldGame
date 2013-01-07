package garfieldgame;

public class Powerbottle implements BoardObject {
    private int height, width, xCoord, yCoord;

    public Powerbottle(int height, int width, int xCoord, int yCoord) {
        this.height = height;
        this.width = width;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void moveLeft() {
        //Move the powerbottle left
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

<<<<<<< HEAD
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
=======

>>>>>>> Fixat kompletteringen
}
