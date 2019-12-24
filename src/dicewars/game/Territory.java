/**
 * 
 */
package dicewars.game;

/**
 * @author Thomas LINTANF
 *
 */
public class Territory {
	
	//instances
	int dicesCount;
	int owner;
	Territory neighbours[];
	
	//constructor
	public Territory(int owner, int dicesCount, Territory neighbours[]) {
		this.owner = owner;
		this.dicesCount = dicesCount;
		this.neighbours = neighbours;
		
		
	
}

	public int getDicesCount() {
		return dicesCount;
	}

	public void setDicesCount(int dicesCount) {
		this.dicesCount = dicesCount;
	}

	public Territory[] getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Territory[] neighbours) {
		this.neighbours = neighbours;
	}

	public void addNeighbours(Territory newNeighbour) {
		this.neighbours[this.neighbours.length] = newNeighbour;
		
	}
	public void addDice() {
		this.dicesCount ++;
	}
}
