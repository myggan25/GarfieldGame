package garfieldgame;

public class Player implements BoardObject {
	private int height, width, xCoord, yCoord;
	//int balansmï¿½tare, skapa en balansmï¿½tare
	
	
	public Player(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
	}
	
	public int jump(int jumpCounter){
		//ï¿½ndra hur objectet hoppar
		if(jumpCounter < 100){
			this.yCoord = this.yCoord - 1;
			jumpCounter++;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			jumpCounter=0;
			//Slå igång "landa" funktionen
		}
		return jumpCounter;
	}

	
	//Ev en funktion fï¿½r att fï¿½ objectet att rï¿½ra sig nedï¿½t igen
	public int land(int fallCounter){
		if(fallCounter < 100){
			this.yCoord = this.yCoord + 1;
			fallCounter++;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			fallCounter=0;
			//Slå igång "landa" funktionen
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
		//balanskorrigera ï¿½t vï¿½nster, dvs fï¿½ objectet att luta ï¿½t vï¿½nster
	}
	
	public void balanceRight(){
		//balanskorrigera ï¿½t hï¿½ger, dvs fï¿½ objectet att luta ï¿½t hï¿½ger
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
