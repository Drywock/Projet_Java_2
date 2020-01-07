/**
 * 
 */
package dicewars.game;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Camille Vinet, Thomas LINTANF
 * @version 1.1
 */
public class Territory {
	
	private int dicesCount;
	private Player owner;
	private Set<Territory> neighbors;
	
	/**
	 * Constructs the class Territory
	 * @version 1.1
	 */
	public Territory() {
		this.dicesCount = 1;
		this.owner = null;
		this.neighbors = new HashSet<Territory>();
	}

	/**
	 * 
	 * @return The count of dices for this territory
	 * @version 1.0
	 */
	public int getDicesCount() {
		return dicesCount;
	}

	/**
	 * Set the count of dices for this territory
	 * @param dicesCount
	 * @throws IllegalArgumentException
	 * @version 1.1
	 */
	public void setDicesCount(int dicesCount) 
			throws IllegalArgumentException {
		if(dicesCount > 0 && dicesCount <= 8)
			this.dicesCount = dicesCount;
		else
			throw new IllegalArgumentException("DicesCount value must be between 1 and 8");
	}

	/**
	 * Add a dice to the count of dices 
	 * @version 1.1
	 */
	public void addDice() throws IllegalArgumentException{
		if(this.dicesCount < 8)
			this.dicesCount ++;
		else
			throw new IllegalArgumentException("DicesCount value must be between 1 and 8");
	}
	
	/**
	 * 
	 * @return The connected territories
	 * @version 1.1
	 */
	public Set<Territory> getNeighbors() {
		return neighbors;
	}

	/**
	 * Add a connected territory
	 * @param newNeighbour
	 * @version 1.1
	 */
	public void addNeighbor(Territory newNeighbour) {
		this.neighbors.add(newNeighbour);
		
	}
	

	/**
	 * Set the territory's owner
	 * @param player
	 * @version 1.0
	 */
	public void setOwner(Player player) {
		this.owner = player;
	}

	/**
	 * 
	 * @return The territory's owner
	 * @version 1.0
	 */
	public Player getOwner() {
		return owner;
	}
	public int rollDices(){
		int total = 0;
		for(int i = 0; i < dicesCount; i ++) {
			total += 1 + (int)(Math.random()*6);
		}
		return total;
		
		
	}
}
