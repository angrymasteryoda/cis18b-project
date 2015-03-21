/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefenseproject;

/**
 *
 * @author Michael
 */
public abstract class GameObject {
    private final int id;
    private int health;

	protected GameObject( int health ) {
		this( 0, health );
	}

	protected GameObject( int id, int health ) {
		this.id = id;
		this.health = health;
	}

	abstract boolean canBeDamaged();

	abstract boolean damage( int amount );

	public int getHealth() {
		return health;
	}

	public void setHealth( int health ) {
		this.health = health;
	}

	public int getId() {
		return id;
	}
}
