package garfieldgame;

        
public class Player implements BoardObject {
	private int velocity=10;
        private int height, width, xCoord, yCoord;
        
        private int jumpCounter=0;
	private int fallCounter=0;
        private PlayerStatus status;
        private PlayerCrouchStatus crouchStatus;
	//int balansm�tare, skapa en balansm�tare
	
	
	public Player(int height, int width, int xCoord, int yCoord){
                this.height=height;
		this.width=width;
		this.xCoord=xCoord;
		this.yCoord=yCoord;
                status=PlayerStatus.STANDING;
                crouchStatus=PlayerCrouchStatus.STANDING;
        }    
        public void setStatus(PlayerStatus status){
            this.status = status;
        }
        
        public void takeAction(){
            System.out.println(status);
            if (status.equals(PlayerStatus.JUMPING)){
		jump();
		/*if(jumpCounter==0){
                    status=PlayerStatus.FALLING;
		}*/
            }
            else if (status.equals(PlayerStatus.FALLING)){
                fall();
                /*if (fallCounter ==0){
                    status=PlayerStatus.STANDING;
                }*/
            }
            if (status.equals(PlayerCrouchStatus.CROUCHING)){
                crouch();
            }
            /*else if (status.equals(PlayerCrouchStatus.UNCROUCHING)){
                unCrouch();
            }*/
        }
        public void jump(){
		//�ndra hur objectet hoppar
            status=PlayerStatus.JUMPING;
            if(jumpCounter < 50){
		if(jumpCounter == 10 || jumpCounter==20 || jumpCounter==30 || jumpCounter==40){
                    velocity-=2;
                }
			this.yCoord -= velocity;
			jumpCounter +=1;
			//Fixa en mjukare funktion om det finns tid
		}
		else{
                    jumpCounter =0;
                    //velocity = 0;
			status=PlayerStatus.FALLING;
			//Sl� ig�ng "landa" funktionen
		}
	}

	
	//Ev en funktion f�r att f� objectet att r�ra sig ned�t igen
	public void fall(){
            status=PlayerStatus.FALLING;
                    if(fallCounter == 10 || fallCounter==20 || fallCounter==30 || fallCounter==40){
                        velocity+=2;
                    }
			this.yCoord += velocity;
			fallCounter +=1;

		
	}
	
	public void crouch(){
		if (crouchStatus.equals(PlayerCrouchStatus.STANDING )){
			this.height = this.height/2;
			this.yCoord = this.yCoord + this.height;
                        crouchStatus=PlayerCrouchStatus.CROUCHING;
                        System.out.println("okokok");
		}
		//komprimera objectet
	}
	
	public void unCrouch(){
		if (crouchStatus.equals(PlayerCrouchStatus.CROUCHING)){
                    this.yCoord -= this.height;
                    this.height = this.height*2;
                    crouchStatus=PlayerCrouchStatus.STANDING;
		}
	}
        
        public void landOnObject(int distanceToObject){
            jumpCounter=0;
            fallCounter=0;
            this.yCoord+=distanceToObject;
            velocity=10;
            //if(status.equals(PlayerStatus.FALLING)){
            status=PlayerStatus.STANDING;
            //}
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
        public PlayerStatus getStatus(){
            return status;
        }
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
