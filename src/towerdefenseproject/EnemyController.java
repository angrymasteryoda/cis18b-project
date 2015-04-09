
package towerdefenseproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enemy Controller (Manager)
 * @author Chris
 */
public class EnemyController implements Serializable {
	
	/**
	 * Custom Link List setup
	 * <p>
	 * maxEnemies is our hard coded value for maximum amount of enemies allowed to exist at one time,
	 * enemyCounter allows us a quicker way to get a head count instead of looping through the list or array.
	 */
	public static final int maxEnemies = 300;	// Hardcoded max amount of enemies allowed in a game
	private static EnemyIds enemyLLHead;
	private static EnemyIds enemyLLTail;
	private static int enemyCounter = maxEnemies;
	public static boolean initializeEnemies = false; 
	
	/**
	 * Custom Link List used to check in and out enemy id's
	 */
	public static class EnemyIds {
		int value;
		EnemyIds previous;
		EnemyIds next;
		
		public EnemyIds (int value,EnemyIds previous,EnemyIds next){
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
		public EnemyIds getPrevious(){
			return previous;
		}
		
		public EnemyIds getNext(){
			return next;
		}

		public String toString(){
			return value + "";
		}
	}
	
	/**
	 * Check In Link
	 * @param num	The ID number to return to the list
	 */
	private static void addLink(int num){
		// Create a new link object
		if (enemyLLHead==null){
			EnemyIds tmp = new EnemyIds (num,null,null);
			enemyLLHead = tmp;
		} else if (enemyLLTail==null) {
			EnemyIds tmp = new EnemyIds (num,enemyLLHead,null);
			enemyLLTail = tmp;
		} else {
			EnemyIds tmp = new EnemyIds (num,enemyLLTail,null);
			enemyLLTail.next = tmp;
			enemyLLTail = tmp;
		}
	}
	
	/**
	 * Check Out Link
	 * @return	A number that is >= 0. If all ID's are gone -1 is sent back
	 */
	public static int grabLink(){
		int tmp;
		if (enemyLLHead!=null){
			if (enemyLLTail==null){
				tmp = enemyLLHead.value;
				enemyLLHead = null;
			} else if (enemyLLTail.previous!=enemyLLHead) {
				tmp = enemyLLTail.value;
				enemyLLTail.previous.next = null;
				enemyLLTail = enemyLLTail.previous;
			} else {
				tmp = enemyLLTail.value;
				enemyLLTail.previous.next = null;
				enemyLLTail = null;
			}
		} else {
			tmp = -1;
		}
		return tmp;
	}
	
	/**
	 * Check Out Enemy ID
	 * <p>
	 * Attempt to grab a link with {@link #grabLink()} that should contain a free ID number.
	 * @return	With a number >= 0 if a link was found, else the list is depleted return -1 instead
	 */
	public static int enemyCheckout(){
		int id = grabLink();
		if (id>=0){
			enemyCounter--;		// Keep track of amount of enemies we have the easy way
		}
		return id;
	}
	
	/**
	 * Check In Enemy ID
	 * <p>
	 * Send back the ID number to {@link #addLink(int)} to be added back into the linked list
	 * @param num	The ID number you are checking back in 
	 */
	public static void enemyCheckin(int num){
		enemyCounter++;		// Update enemy counts
		addLink(num);
	}
	
	/**
	 * Create Enemy ID's
	 * <p>
	 * This must be called at the start of every new game! Not every round, just once per new game
	 */
	public static void initializeEnemies(){
		if (initializeEnemies==false){
			for (int x=0;x<maxEnemies;x++){
				addLink (x);
			}
			initializeEnemies = true;
			//
			int id;
			for (int x=1;x<maxEnemies;x++){
				id = enemyCheckout();
				new Enemy(id,x,x,x,x,x,x,x);
			}
		}
	}
}