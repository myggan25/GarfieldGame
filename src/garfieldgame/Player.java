package garfield;

public class Player implements BoardObject {
	private int height, width, xCoord, yCoord;
	//int balansm�tare, skapa en balansm�tare
	
	public Player(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
	}
	
	public void jump(){
		//�ndra hur objectet hoppar
	}
	
	//Ev en funktion f�r att f� objectet att r�ra sig ned�t igen
	public void land(){
		
	}
	
	public void crouch(){
		//komprimera objectet
	}
	
	public void balanceLeft(){
		//balanskorrigera �t v�nster, dvs f� objectet att luta �t v�nster
	}
	
	public void balanceRight(){
		//balanskorrigera �t h�ger, dvs f� objectet att luta �t h�ger
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