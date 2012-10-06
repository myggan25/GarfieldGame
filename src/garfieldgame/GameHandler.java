package garfieldgame;

public class GameHandler {

	public boolean checkIfFalling(){
		//Kolla om spelaren har n�got "fast" under sig
		return false;
	}
	
	public void fall(){
		//G�r s� att spelaren faller
	}
	
	public void checkIfHitOnBoard(Player player, Obstacle obstacle, Powerbottle powerbottle){
		//G�r kontinuerligt kollar f�r att kolla om det uppst�r en kollision
	}
	
	/*****************************************
	 *SANNINGSV�RDEN F�R KOLLISION MED HINDER*
	 *****************************************/
	
	private boolean hitObstacle(Player player, Obstacle obstacle){
		//K�r kollisionskoll f�r alla v�rden
		//Anv�nder sig av nedanst�ende metoder
		return false;
	}
	
	private boolean hitObstacleUp(Player player, Obstacle obstacle){
		//Skapa sanningsv�rde f�r om spelaren hoppar in i ett object
		return false;
	}
	private boolean hitObstacleRight(Player player, Obstacle obstacle){
		//Skapa sanningsv�rde f�r om spelaren springer in i ett object
		return false;
	}
	private boolean hitObstacleDown(Player player, Obstacle obstacle){
		//Skapa sannisgsv�rde f�r om spelaren landar p� ett object
		return false;
	}
		

	/*******************************************
	 *SANNINGSV�RDEN F�R KOLLISION MED POWERUPS*
	 *******************************************/
	
	private boolean hitPowerbottle(Player player, Powerbottle powerbottle){
		//K�r kollisionskoll f�r alla v�rden
		//Anv�nder sig av nedanst�ende metoder
		return false;
	}
	
	private boolean hitPowerbottleUp(Player player, Powerbottle powerbottle){
		//Skapa sanningsv�rde f�r om spelaren hoppar in i en powerup
		return false;
	}
	private boolean hitPowerbottleRight(Player player, Powerbottle powerbottle){
		//Skapa sanningsv�rde f�r om spelaren springer in i en powerup
		return false;
	}
	private boolean hitPowerbottleDown(Player player, Powerbottle powerbottle){
		//Skapa sannisgsv�rde f�r om spelaren landar p� en powerup
		return false;
	}
	
	/*******************************
	 *HANTERING AV ALLA KOLLISIONER*
	 *******************************/
	
	private void performObstacleHit(){
		//Skriv vad som h�nder om man tr�ffar ett hinder
	}
	
	private void performObstacleLand(){
		//Skriv vad som h�nder n�r spelaren landar p� ett hinder
	}
	
	private void performPowerbottleHit(){
		//Skriv vad som h�nder om man tr�ffar en powerbottle
	}

}
