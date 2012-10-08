package garfieldgame;

public class Powerbottle implements BoardObject {
	private int height, width, xCoord, yCoord;//, xCoordMap;
	private boolean inBoard;
	//skapa olika effekter f�r olika powerbottles 
	
	public Powerbottle(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		//this.xCoord=xCoordMap;
		this.yCoord=yCoord;
		this.inBoard=false;
	}
	
	public void moveLeft(){
            xCoord-=4;
		//Flytta flaskan �t v�nster
	}
	
	
	/*
	 * Skapa eventuellt flaskor som r�r p� sig i fler riktiningar
	 */
	
	/*
	 * Skapa olika flaskor som ger olika effekt
	 */

	/**********
	 * GETTERS
	 **********/
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getXCoord(){
		return xCoord;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
	/*public int getXCoordMap(){
		return xCoordMap;
	}*/
	
	/**********
	 * SETTERS
	 **********/
	public void setWidth(int width){
		this.width=width;
	}
	
	public void setHeight(int height){
		this.height=height;
	}
	
	public void setXCoord(int xCoord){
		this.xCoord=xCoord;
	}
	
	public void setYCoord(int yCoord){
		this.yCoord=yCoord;
	}
	
	/*public void setXCoordMap(int xCoordMap){
		this.xCoordMap=xCoordMap;
	}
	public void setInBoard(){
		this.inBoard=true;
	}*/
	
}
