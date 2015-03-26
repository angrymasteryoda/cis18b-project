
package llhw;

public class EnemyController {
	
	// LINK LIST
	public static final int maxEnemies = 500;	// Hardcoded max amount of enemies allowed in a game
	private static EnemyIds enemyLLHead;
	private static EnemyIds enemyLLTail;
	private static int enemyCounter = maxEnemies;
	public static boolean initializeEnemies = false; 
	
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
	
	public static int enemyCheckout(){
		int id = grabLink();
		if (id>=0){
			enemyCounter--;
		}
		// id returns -1 if you are out of ID's
		return id;
	}
	
	public static void enemyCheckin(int num){
		enemyCounter++;
		addLink(num);
	}
	
	// THIS MUST BE CALLED AT THE START OF A GAME!
	public static void initializeEnemies(){
		if (initializeEnemies==false){
			for (int x=0;x<maxEnemies;x++){
				addLink (x);
			}
			initializeEnemies = true;
		}
	}
}