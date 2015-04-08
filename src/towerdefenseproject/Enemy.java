
package towerdefenseproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enemy Objects
 * @author Chris
 */
public class Enemy implements Serializable {

	/**
	 * Array to hold created enemy objects (enemy information)
	 * <p>
	 * This array has a hard coded limit that is supplied from EnemyController.maxEnemies
	 * EnemyCntroller.enemyCheckout() insures we do not pass that limit or crash the game with to many enemies.
	 */
	private Enemy[] enemyArray = new Enemy[EnemyController.maxEnemies];
	
	// LOOK UP ENUM's for some of these
	int id;
	int name;
	int type;
	int speed;
	int attack;
	int health;
	int shield;
	int reward;

	/**
	 * Creates a new Enemy object
	 * @param id		Id number checked out from the EnemyController.java
	 * @param name		Name of enemy. Eventually will be am Enum value
	 * @param type		Type, air or ground, of an enemy. Eventually will be an Enum value
	 * @param speed		Speed at which an enemy moves through the level
	 * @param attack	How much damage an enemy will do upon making it to the players HQ
	 * @param health	How much health the enemy has currently
	 * @param shield	How much shield the enemy has currently protecting its health
	 * @param reward	How much money a player is rewarded upon killing the enemy
	 */
	public Enemy (int id, int name,int type,int speed,int attack,int health,int shield,int reward){
		this.id = id;
		this.name = name;
		this.type = type;
		this.speed = speed;
		this.attack = attack;
		this.health = health;
		this.shield = shield;
		this.reward = reward;
		enemyArray[id] = this;
		serialize();
	}

	/**
	 * Weaken an enemies attack via a special weapon
	 * @param num	Amount to remove from the enemies current health
	 */
	public void minusAttack (int num){
		int tmp = this.attack + num;
		// Always have a bit of attack value
		if (tmp<100){
			tmp = 100;
		}
		this.attack = tmp;
	}
	
	@Override
	public String toString(){
		return "Enemy ["+id+","+name+","+ type+","+ speed+","+ attack+","+ health+","+ shield+","+reward+"]";
	}
	
	/**
	 * Register a damage hit on an enemy, calculate health and shield
	 * <p>
	 * The return type may be removed from this in the future. We can handle the death here in this function instead.
	 * <p>
	 * This function auto manages shield subtraction and overflow into heath.
	 * @param num	How much damage the enemy was hit with
	 * @return		Flag. True means enemy is now considered dead. False is alive 
	 */
	public boolean minusHealth (int num){
		// Also manages shield for us
		boolean flag;
		int tmp;
		// Do we have a shield?
		if (this.shield<=0){
			// No shield, go straight to health
			tmp = this.health - num;
			if (tmp<0){
				// Enemy is dead
				this.health = 0;
				this.attack = 0;	// Just in case it reaches the tower before being destroyed
				flag = true;
			} else {
				// Update health
				this.health = tmp;
				flag = false;
			}
		} else {
			int result = this.shield - num;
			// Is their shield gone?
			if (result<0){
				this.shield = 0;
				tmp = this.health + result;
				// Do this hit wipe out their health too?
				if (tmp<0){
					// Enemy is dead
					this.health = 0;
					this.attack = 0;	// Just in case it reaches the tower before being destroyed
					flag = true;
				} else {
					// Update health
					this.health = tmp;
					flag = false;
				}
			} else {
				// Only the shield took a hit
				this.shield = result;
				flag = false;
			}
		}
		// False is alive, True is dead
		return flag;
	}

	/**
	 * Weaken an enemies shield via a special weapon
	 * <p>
	 * This should be called as the result of a special weapon or power up. Any excess damage is not carried over to the enemies health.
	 * @param num	The amount to be taken out of the enemies current shield
	 */
	public void minusShield (int num){
		int tmp = this.shield - num;
		// Dont save negative shield
		if (tmp<0){
			tmp = 0;
		}
		this.shield = tmp;
	}

	/**
	 * Reduce the players reward from killing this enemy
	 * @param num	Amount to reduce the enemies current reward by
	 */
	public void minusReward (int num){
		int tmp = this.reward - num;
		// Always reward a little something
		if (tmp<50){
			tmp = 50;
		}
		this.reward = tmp;
	}

	/**
	 * Add attack strength to an enemy
	 * @param num	Amount of strength to add to the enemies current attack
	 */
	public void addAttack (int num){
		this.attack = this.attack + num;
	}

	/**
	 * Add health to an enemy
	 * @param num	Amount of health to add to an enemies current health
	 */
	public void addHealth (int num){
		this.health = this.health + num;
	}

	/**
	 * Add shield strength to an enemy
	 * @param num	Amount of shield to add to the enemies current shield
	 */
	public void addShield (int num){
		this.shield = this.shield + num;
	}

	/**
	 * Increase the reward for killing this enemy
	 * @param num	Amount to increase the enemies current reward by
	 */
	public void addReward (int num){
		this.reward = this.reward + num;
	}
	
	public void serialize(){
		try {
			FileOutputStream fileOut = new FileOutputStream("log/test.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			// Do work here
			out.writeObject(enemyArray);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(EnemyController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(EnemyController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}