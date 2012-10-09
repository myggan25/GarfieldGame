package garfieldgame;

        
public class Player implements BoardObject {
	private int height, width, xCoord, yCoord;
        
        private int jumpCounter=0;
	private int fallCounter=0;
        private PlayerStatus status;
/*	private boolean jumping = false;
	private boolean falling = false;
	private boolean crouching = false;
	private boolean standing = true;
	private boolean unCrouch = false;*/
	//int balansm�tare, skapa en balansm�tare
	
	
	public Player(int height, int width, int xCoord, int yCoord){
		this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
                status=PlayerStatus.STANDING;
        }    
        public void setStatus(PlayerStatus status){
            this.status = status;
        }
        
        public void takeAction(){
            System.out.println(status);
            if(status.equals(PlayerStatus.STANDING)){
                
                return;
            }
            else if (status.equals(PlayerStatus.JUMPING)){
		jump();
		if(jumpCounter==0){
                    status=PlayerStatus.FALLING;
		}
            }
            else if (status.equals(PlayerStatus.FALLING)){
                land();
                if (fallCounter ==0){
                    status=PlayerStatus.STANDING;
                }
            }
            else if (status.equals(PlayerStatus.CROUCHING)){
                crouch();
            }
            else if (status.equals(PlayerStatus.UNCROUCHING)){
                unCrouch();
            }
        }
        public void jump(){
		//�ndra hur objectet hoppar
            status=PlayerStatus.JUMPING;
		if(jumpCounter < 100){
			this.yCoord -= 4;
			jumpCounter +=2;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			status=PlayerStatus.FALLING;
			//Sl� ig�ng "landa" funktionen
		}
	}

	
	//Ev en funktion f�r att f� objectet att r�ra sig ned�t igen
	public void land(){
            status=PlayerStatus.FALLING;
		if(fallCounter < 100){
			this.yCoord += 4;
			fallCounter+=2;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
			status=PlayerStatus.STANDING;
			//Sl� ig�ng "landa" funktionen
		}
		
	}
	
	public void crouch(){
		if (status.equals(PlayerStatus.STANDING)){
			this.height = this.height/2;
			this.yCoord = this.yCoord + this.height;
                        status=PlayerStatus.CROUCHING;
		}
		//komprimera objectet
	}
	
	public void unCrouch(){
		if (status.equals(PlayerStatus.CROUCHING)){
                    this.yCoord -= this.height;
                    this.height = this.height*2;
                    status=PlayerStatus.STANDING;
		}
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
