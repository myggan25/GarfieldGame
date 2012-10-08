package garfieldgame;

public class Player implements BoardObject {
	private int height, width, xCoord, yCoord;
	//int balansm�tare, skapa en balansm�tare
	
	
	public Player(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
	}
	
	public int jump(int jumpCounter){
		//�ndra hur objectet hoppar
		if(jumpCounter < 100){
			this.yCoord = this.yCoord - 4;
			jumpCounter+=2;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			jumpCounter=0;
			//Sl� ig�ng "landa" funktionen
		}
		return jumpCounter;
	}

	
	//Ev en funktion f�r att f� objectet att r�ra sig ned�t igen
	public int land(int fallCounter){
		if(fallCounter < 100){
			this.yCoord += 4;
			fallCounter+=2;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			fallCounter=0;
			//Sl� ig�ng "landa" funktionen
		}
		return fallCounter;
		
	}
	
	public boolean crouch(boolean standing){
		if (standing){
			this.height = this.height/2;
			this.yCoord = this.yCoord + this.height;
			standing=false;
		}
		return standing;
		//komprimera objectet
	}
	
	public boolean unCrouch(boolean standing){
		if (!standing){
			this.height = this.height*2;
			standing = true;
		}
		return standing;
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
