package garfield;

public class GameHandler {

	public boolean checkIfFalling(){
		//Kolla om spelaren har något "fast" under sig
		return false;
	}
	
	public void fall(){
		//Gör så att spelaren faller
	}
	
	public void checkIfHitOnBoard(Player player, Obstacle obstacle, Powerbottle powerbottle){
		//Gör kontinuerligt kollar för att kolla om det uppstår en kollision
	}
	
	/*****************************************
	 *SANNINGSVÄRDEN FÖR KOLLISION MED HINDER*
	 *****************************************/
	
	private boolean hitObstacle(Player player, Obstacle obstacle){
		//Kör kollisionskoll för alla värden
		//Använder sig av nedanstående metoder
		return false;
	}
	
	private boolean hitObstacleUp(Player player, Obstacle obstacle){
		//Skapa sanningsvärde för om spelaren hoppar in i ett object
		return false;
	}
	private boolean hitObstacleRight(Player player, Obstacle obstacle){
		//Skapa sanningsvärde för om spelaren springer in i ett object
		return false;
	}
	private boolean hitObstacleDown(Player player, Obstacle obstacle){
		//Skapa sannisgsvärde för om spelaren landar på ett object
		return false;
	}
		

	/*******************************************
	 *SANNINGSVÄRDEN FÖR KOLLISION MED POWERUPS*
	 *******************************************/
	
	private boolean hitPowerbottle(Player player, Powerbottle powerbottle){
		//Kör kollisionskoll för alla värden
		//Använder sig av nedanstående metoder
		return false;
	}
	
	private boolean hitPowerbottleUp(Player player, Powerbottle powerbottle){
		//Skapa sanningsvärde för om spelaren hoppar in i en powerup
		return false;
	}
	private boolean hitPowerbottleRight(Player player, Powerbottle powerbottle){
		//Skapa sanningsvärde för om spelaren springer in i en powerup
		return false;
	}
	private boolean hitPowerbottleDown(Player player, Powerbottle powerbottle){
		//Skapa sannisgsvärde för om spelaren landar på en powerup
		return false;
	}
	
	/*******************************
	 *HANTERING AV ALLA KOLLISIONER*
	 *******************************/
	
	private void performObstacleHit(){
		//Skriv vad som händer om man träffar ett hinder
	}
	
	private void performObstacleLand(){
		//Skriv vad som händer när spelaren landar på ett hinder
	}
	
	private void performPowerbottleHit(){
		//Skriv vad som händer om man träffar en powerbottle
	}

}
