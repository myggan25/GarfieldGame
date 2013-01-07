package garfieldgame;


public class Player implements BoardObject {
    private int velocity = 10;
    private int height, width, xCoord, yCoord;

    private int jumpCounter = 0;
    private int fallCounter = 0;
    private PlayerStatus status;
    private PlayerCrouchStatus crouchStatus;
    private int score;
    private int numberOfPowerBottles;

    //Values for how much the player is wobbling
    private int drunkValue;
    private int wobbleValue;
    private int wobbleCounter;
    private PlayerWobble wobble;


    public Player(int height, int width, int xCoord, int yCoord) {
        this.height = height;
        this.width = width;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        status = PlayerStatus.STANDING;
        crouchStatus = PlayerCrouchStatus.STANDING;
        score = 0;
        drunkValue = 1;
        wobbleValue = 0;
        wobbleCounter = 0;
        wobble = PlayerWobble.FORWARDFRONT;

    }

    /**
     * Increases score and wobble values
     * Perform the action according to the playerstatus and playercrouchstatus
     */
    public void takeAction() {
        increaseScore();
        increaseWobble();
        if (status.equals(PlayerStatus.JUMPING)) {
            jump();
        } else if (status.equals(PlayerStatus.SUPERJUMPING)) {
            superJump();
        } else if (status.equals(PlayerStatus.FALLING)) {
            fall();
<<<<<<< HEAD
        }
        if (status.equals(PlayerCrouchStatus.CROUCHING)) {
            crouch();
=======
>>>>>>> Fixat kompletteringen
        }
    }


    public void superJump() {
<<<<<<< HEAD
        status = PlayerStatus.SUPERJUMPING;
        if (jumpCounter < 50) {
            //This is to create a "softer" jump motion
=======
        final int SUPERJUMP_DURATION = 50;
        status = PlayerStatus.SUPERJUMPING;
        if (jumpCounter < SUPERJUMP_DURATION) {
            //This is to create a "softer" jump motion where the numeber are between 0 and SUPERJUMP_DURATION 
            //and each number represents a place where the velocity lessens
>>>>>>> Fixat kompletteringen
            if (jumpCounter == 10 || jumpCounter == 20 || jumpCounter == 30 || jumpCounter == 40) {
                velocity -= 2;
            }
            this.yCoord -= velocity;
            jumpCounter += 1;
        } else {
            jumpCounter = 0;
            status = PlayerStatus.FALLING;
        }
    }

    public void jump() {
        status = PlayerStatus.JUMPING;
<<<<<<< HEAD
        if (jumpCounter < 25) {
            //This is to create a "softer" jump motion
=======
        final int JUMP_DURATION = 25;
        if (jumpCounter < JUMP_DURATION) {
            //This is to create a "softer" jump motion where the numeber are between 0 and JUMP_DURATION 
            //and each number represents a place where the velocity lessens
>>>>>>> Fixat kompletteringen
            if (jumpCounter == 7 || jumpCounter == 15 || jumpCounter == 12 || jumpCounter == 22) {
                velocity -= 2;
            }
            this.yCoord -= velocity;
            jumpCounter += 1;
        } else {
            jumpCounter = 0;
            status = PlayerStatus.FALLING;
        }
    }

    public void fall() {
        status = PlayerStatus.FALLING;
<<<<<<< HEAD
        //This is to create a "softer" fall motion
=======
        //This is to create a "softer" fall motion where the numeber are between 0 and SUPERJUMP_DURATION 
        //and each number represents a place where the velocity gets greater
>>>>>>> Fixat kompletteringen
        if (fallCounter == 10 || fallCounter == 20 || fallCounter == 30 || fallCounter == 40) {
            velocity += 2;
        }
        this.yCoord += velocity;
        fallCounter += 1;
    }

    public void crouch() {
        if (crouchStatus.equals(PlayerCrouchStatus.STANDING)) {
            this.height = this.height / 2;
            this.yCoord = this.yCoord + this.height;
            crouchStatus = PlayerCrouchStatus.CROUCHING;
        }
    }

    public void unCrouch() {
        if (crouchStatus.equals(PlayerCrouchStatus.CROUCHING)) {
            this.yCoord -= this.height;
            this.height = this.height * 2;
            crouchStatus = PlayerCrouchStatus.STANDING;
        }
    }
<<<<<<< HEAD

    /**
     * Makes the player land on an object with a specific distance left
     * @param distanceToObject
     */
    public void landOnObject(int distanceToObject) {
        jumpCounter = 0;
        fallCounter = 0;
        this.yCoord += distanceToObject;
        velocity = 10;
        status = PlayerStatus.STANDING;
    }

    public void goLeft() {
        //The limit 0 is because you should not be able to go outside the board
        if (wobbleValue + xCoord > 0) {
            wobbleValue -= 5;
        }
    }

    public void goRight() {
        //The limit 500 is because you should not be able to go too far right
        if (wobbleValue + xCoord < 500) {
            wobbleValue += 5;
        }
    }

    public void increasPowerbottlesCaught() {
        drunkValue++;
        numberOfPowerBottles++;
    }

    //Increase the players totalpoint
    private void increaseScore() {
        score += drunkValue;
    }

    /**
     * After the drunkvalue is more than 5 the players starts to wobble
     * The player will move back and forward according to the drunkvalue
     */
    private void increaseWobble() {
        //If wobbleCounter exceeds drunkValue change status so it goes the other direction
        if (wobbleCounter >= drunkValue || wobbleCounter <= -drunkValue) {
            if (wobble == PlayerWobble.FORWARDFRONT) {
                wobble = PlayerWobble.BACKWARDFRONT;
            } else if (wobble == PlayerWobble.BACKWARDBACK) {
                wobble = PlayerWobble.FORWARDFRONT;
            }
        }
        //If wobbleCounter gets to 0 then change relative value seen from startposition
        else if (wobbleCounter == 0) {
            if (wobble == PlayerWobble.BACKWARDFRONT) {
                wobble = PlayerWobble.BACKWARDBACK;
            } else if (wobble == PlayerWobble.FORWARDBACK) {
                wobble = PlayerWobble.FORWARDFRONT;
            }
        }
        //If drunkValue is larger than 5 increase the wobblecounter in the right direction.
        if (drunkValue > 5) {
            if (wobble == PlayerWobble.FORWARDFRONT || wobble == PlayerWobble.FORWARDBACK) {
                wobbleCounter++;
                wobbleValue++;
            } else if (wobble == PlayerWobble.BACKWARDFRONT || wobble == PlayerWobble.BACKWARDBACK) {
                wobbleCounter--;
                wobbleValue--;
            }
        }
=======

    /**
     * Makes the player land on an object with a specific distance left
     * @param distanceToObject
     */
    public void land(int distanceToObject) {
        jumpCounter = 0;
        fallCounter = 0;
        this.yCoord += distanceToObject;
        velocity = 10;
        status = PlayerStatus.STANDING;
    }
    /**
     * checks the players distance from the ground
     *
     * @param board
     * @return the distance in pixels to the ground below
     *         If more than 15 it returns -1
     */
     public int testLandOnGround(int mapHeight) {
        int LIMIT_FROM_GROUND = 15;
        if (getYCoord() + getHeight() + LIMIT_FROM_GROUND >= mapHeight &&
                getYCoord() + getHeight() <= mapHeight) {
            return -(getYCoord() + getHeight() - mapHeight);
        } else {
            return -1;
        }
    }
    

    public void goLeft() {
        final int MIN_X = 0;
        //The limit 0 is because you should not be able to go outside the board
        if (wobbleValue + xCoord > MIN_X) {
            wobbleValue -= 5;
        }
    }

    public void goRight() {
        final int MAX_X = 500;
        //The limit 500 is because you should not be able to go too far right
        if (wobbleValue + xCoord < MAX_X) {
            wobbleValue += 5;
        }
    }

    public void increasPowerbottlesCaught() {
        drunkValue++;
        numberOfPowerBottles++;
    }

    //Increase the players totalpoint
    private void increaseScore() {
        score += drunkValue;
    }

    /**
     * After the drunkvalue is more than 5 the players starts to wobble
     * The player will move back and forward according to the drunkvalue
     */
    private void increaseWobble() {
        final int START_WOBBLE_LIMIT = 5;
        final int NO_WOBBLE = 0;
        //If wobbleCounter exceeds drunkValue change status so it goes the other direction
        if (wobbleCounter >= drunkValue || wobbleCounter <= -drunkValue) {
            if (wobble == PlayerWobble.FORWARDFRONT) {
                wobble = PlayerWobble.BACKWARDFRONT;
            } else if (wobble == PlayerWobble.BACKWARDBACK) {
                wobble = PlayerWobble.FORWARDFRONT;
            }
        }
        //If wobbleCounter gets to 0 then change relative value seen from startposition
        else if (wobbleCounter == NO_WOBBLE) {
            if (wobble == PlayerWobble.BACKWARDFRONT) {
                wobble = PlayerWobble.BACKWARDBACK;
            } else if (wobble == PlayerWobble.FORWARDBACK) {
                wobble = PlayerWobble.FORWARDFRONT;
            }
        }
        //If drunkValue is larger than 5 increase the wobblecounter in the right direction.
        if (drunkValue > START_WOBBLE_LIMIT) {
            if (wobble == PlayerWobble.FORWARDFRONT || wobble == PlayerWobble.FORWARDBACK) {
                wobbleCounter++;
                wobbleValue++;
            } else if (wobble == PlayerWobble.BACKWARDFRONT || wobble == PlayerWobble.BACKWARDBACK) {
                wobbleCounter--;
                wobbleValue--;
            }
        }
>>>>>>> Fixat kompletteringen
    }

    /*----------
      * GETTERS
      **********/
    public int getPowerbottles() {
        return numberOfPowerBottles;
    }

    public int getScore() {
        return score;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public PlayerCrouchStatus getCrouchStatus() {
        return crouchStatus;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXCoord() {
        return xCoord + wobbleValue;
    }

    public int getYCoord() {
        return yCoord;
    }

    /*----------
      * SETTERS
      **********/

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

<<<<<<< HEAD
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