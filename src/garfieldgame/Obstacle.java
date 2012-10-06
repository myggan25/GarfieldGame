package garfieldgame;

public class Obstacle implements BoardObject {
	private int height, width, xCoord, yCoord, xCoordMap;
	private boolean inBoard;
	
	
	public Obstacle(int height, int width, int xCoordMap, int yCoord){
		this.height=height;
		this.width=width;
		//this.xCoord=xCoord;
		this.yCoord=yCoord;
		this.xCoordMap=xCoordMap;
		this.inBoard = false;
	}
	
	public void moveLeft(){
		//Flytta hindret �t v�nster
	}
	
	/*
	 * Skapa eventuellt hinder som r�r p� sig i fler riktiningar
	 */
	
	/*
	 * Skapa eventuellt olika f�rger
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
	
	public int getXCoordMap(){
		return xCoordMap;
	}
	
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
	
	public void setXCoordMap(int xCoordMap){
		this.xCoordMap=xCoordMap;
	}
	
	public void setInBoard(){
		this.inBoard=true;
	}
	

	
}
