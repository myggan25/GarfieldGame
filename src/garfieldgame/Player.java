package garfield;

public class Player implements BoardObject {
	private int height, width, xCoord, yCoord;
	//int balansmätare, skapa en balansmätare
	
	public Player(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
	}
	
	public void jump(){
		//ändra hur objectet hoppar
	}
	
	//Ev en funktion för att få objectet att röra sig nedåt igen
	public void land(){
		
	}
	
	public void crouch(){
		//komprimera objectet
	}
	
	public void balanceLeft(){
		//balanskorrigera åt vänster, dvs få objectet att luta åt vänster
	}
	
	public void balanceRight(){
		//balanskorrigera åt höger, dvs få objectet att luta åt höger
	}

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
	
	
}
