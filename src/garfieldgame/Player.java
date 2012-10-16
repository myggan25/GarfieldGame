package garfieldgame;

        
public class Player implements BoardObject {
	private int velocity=10;
        private int height, width, xCoord, yCoord;
        
        private int jumpCounter=0;
	private int fallCounter=0;
        private PlayerStatus status;
        private PlayerCrouchStatus crouchStatus;
        private int score;
        private int numberOfPowerBottles;
        
        //Värden för hur mycket spelaren vinglar
        private int drunkValue;
        private int wobbleValue;
        private int wobbleCounter;
        private PlayerWobble wobble;
	
	
	public Player(int height, int width, int xCoord, int yCoord){
            this.height=height;
            this.width=width;
            this.xCoord=xCoord;
            this.yCoord=yCoord;
            status=PlayerStatus.STANDING;
            crouchStatus=PlayerCrouchStatus.STANDING;
            score = 0;
            drunkValue = 1;
            wobbleValue = 0;
            wobbleCounter = 0;
            wobble=PlayerWobble.FORWARDFRONT;
                
        }   
        
        public void takeAction(){
            increaseScore();
            increaseWobble();
            if (status.equals(PlayerStatus.JUMPING)){
		jump();
            }
            else if (status.equals(PlayerStatus.SUPERJUMPING)){
		superJump();
            }
            else if (status.equals(PlayerStatus.FALLING)){
                fall();
            }
            if (status.equals(PlayerCrouchStatus.CROUCHING)){
                crouch();
            }
        }

        public void superJump(){
            status=PlayerStatus.SUPERJUMPING;
            if(jumpCounter < 50){
                //Detta är för att skapa ett mjukare hopp
		if(jumpCounter == 10 || jumpCounter==20 || jumpCounter==30 || jumpCounter==40){
                    velocity-=2;
                }
			this.yCoord -= velocity;
			jumpCounter +=1;
		}
		else{
                    jumpCounter =0;
                    status=PlayerStatus.FALLING;
		}
	}
        public void jump(){
            status=PlayerStatus.JUMPING;
            if(jumpCounter < 25){
                //Detta är för att skapa ett mjukare hopp
		if(jumpCounter == 7 || jumpCounter==15 || jumpCounter==12 || jumpCounter==22 ){
                    velocity-=2;
                }
			this.yCoord -= velocity;
			jumpCounter +=1;
		}
		else{
                    jumpCounter =0;
                    status=PlayerStatus.FALLING;
		}
	}
        
	public void fall(){
            status=PlayerStatus.FALLING;
            if(fallCounter == 10 || fallCounter==20 || fallCounter==30 || fallCounter==40){
                velocity+=2;
            }
            this.yCoord += velocity;
            fallCounter +=1;
	}
	
	public void crouch(){
            if (crouchStatus.equals(PlayerCrouchStatus.STANDING)){
                this.height = this.height/2;
                this.yCoord = this.yCoord + this.height;
                crouchStatus=PlayerCrouchStatus.CROUCHING;
            }
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
            status=PlayerStatus.STANDING;
        }
	
	public void goLeft(){
            //gränsen 0 är för att man inte ska kunna åka utanför planen
            if(wobbleValue+xCoord>0){
                wobbleValue-=5;
            }
	}
	
	public void goRight(){
            //gränsen 500 är för att man inte ska kunna gå för långt å höger
            if(wobbleValue+xCoord<500){
                wobbleValue+=5;
            }
	}
        
        public void increasPowerbottlesCaught(){
            drunkValue++;
            numberOfPowerBottles++;
        }
        
        //Öka spelarens totalpoäng
        private void increaseScore(){
            score+=drunkValue;
        }
        private void increaseWobble(){
            if(wobbleCounter>=drunkValue || wobbleCounter <=-drunkValue ){
                if(wobble==PlayerWobble.FORWARDFRONT){
                    wobble=PlayerWobble.BACKWARDFRONT;
                }
                else if(wobble==PlayerWobble.BACKWARDBACK){
                    wobble=PlayerWobble.FORWARDFRONT;
                }
            }
            else if(wobbleCounter==0){
                if(wobble==PlayerWobble.BACKWARDFRONT){
                    wobble=PlayerWobble.BACKWARDBACK;
                }
                else if(wobble==PlayerWobble.FORWARDBACK){
                    wobble=PlayerWobble.FORWARDFRONT;
                }
            }
            if(drunkValue>5){
                if(wobble==PlayerWobble.FORWARDFRONT || wobble==PlayerWobble.FORWARDBACK){
                    wobbleCounter++;
                    wobbleValue++;
                }
                else if(wobble==PlayerWobble.BACKWARDFRONT || wobble==PlayerWobble.BACKWARDBACK){
                    wobbleCounter--;
                    wobbleValue--;
                }
            }
        }

	/*----------
	 * GETTERS
	 **********/
        public int getPowerbottles(){
            return numberOfPowerBottles;
        }
        public int getScore(){
            return score;
        }
        public PlayerStatus getStatus(){
            return status;
        }
        public PlayerCrouchStatus getCrouchStatus(){
            return crouchStatus;
        }
	public int getWidth(){
            return width;
	}
	public int getHeight(){
            return height;
	}
	
	public int getXCoord(){
            return xCoord+wobbleValue;
	}
	
	public int getYCoord(){
            return yCoord;
	}
	
	/*----------
	 * SETTERS
	 **********/
        
        public void setStatus(PlayerStatus status){
            this.status = status;
        }
        
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
