/**
 * 
 */
package dicewars.game;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Camille Vinet, Thomas LINTANF
 * @version 1.1
 */
public class Tile {
	public enum Side{
		UPLEFT,
		UPRIGHT,
		RIGHT,
		DOWNRIGHT,
		DOWNLEFT,
		LEFT;
	}
	
	private Territory territory;
	private Map<Side, Tile> adjacents;
	
	/**
	 * Contructs the class Tile
	 * @version 1.1
	 */
	public Tile() {
		this.territory = null;
		this.adjacents = new HashMap<Side, Tile>();
	}

	/**
	 * 
	 * @return The correspondent territory
	 * @version 1.0
	 */
	public Territory getTerritory() {
		return territory;
	}
	
	/**
	 * Set the correspondent territory
	 * @param territory
	 * @version 1.0
	 */
	public void setTerritory(Territory territory) {
		this.territory = territory;
	}


	/**
	 * 
	 * @param side
	 * @return the adjacent Tile on the specified side
	 * @version 1.1
	 */
	public Tile getAdjacent(Side side) {
		return adjacents.get(side);
	}

	/**
	 * Set the adjacent tile on the specified side
	 * @param side
	 * @param tile
	 * @version 1.1
	 */
	public void setAdjacent(Side side, Tile tile) {
		this.adjacents.put(side, tile);
	}
}
