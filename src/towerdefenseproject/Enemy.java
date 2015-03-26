
package llhw;

public class Enemy {

	public static final Enemy[] enemyArray = new Enemy[EnemyController.maxEnemies];
	
	int id;
	int name;
	int type;
	int speed;
	int attack;
	int health;
	int shield;
	int reward;

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
	}

	public void minusAttack (int num){
		int tmp = this.attack + num;
		// Always have a bit of attack value
		if (tmp<100){
			tmp = 100;
		}
		this.attack = tmp;
	}

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

	// Only call if you specifily are attacking the shield. A special weapon for example.
	// Any excess will not carry over into the health, use minusHealth() for that effect
	public void minusShield (int num){
		int tmp = this.shield - num;
		// Dont save negative shield
		if (tmp<0){
			tmp = 0;
		}
		this.shield = tmp;
	}

	public void minusReward (int num){
		int tmp = this.reward - num;
		// Always reward a little something
		if (tmp<50){
			tmp = 50;
		}
		this.reward = tmp;
	}

	public void addAttack (int num){
		this.attack = this.attack + num;
	}

	public void addHealth (int num){
		this.health = this.health + num;
	}

	public void addShield (int num){
		this.shield = this.shield + num;
	}

	public void addReward (int num){
		this.reward = this.reward + num;
	}
}