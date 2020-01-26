/**
 * 
 */
package dicewars.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Thomas LINTANF
 * @version 1.3
 */
public class Map {
	private Set<Territory> territories;
	private Set<Tile> tiles;
	private Tile origin;
	
	/**
	 * Construct the Map class
	 * @version 1.0
	 */
	public Map() {
		this.territories = new HashSet<Territory>();
		this.tiles = new HashSet<Tile>();
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 * @version 1.0
	 */
	public static Object pickRandomInSet(Set<?> s) {
		int size = s.size();
		int rd = 0;
		if (size != 0)
			rd = new Random().nextInt(size);
		int cpt = 0;
		Object res = null;
		for(Object o : s) {
			if(cpt == rd)
				res = o;
			cpt ++;
		}
		return res;
	}
	/**
	 * 
	 * @param players
	 * @version 1.2
	 */
	public void generate(Player[] players) {
		final int NBCOLUMNS = 35;
		final int NBROWS = 19;
		final int NBPLAYERTERRITORIES = 5;
		final int TERRITORYSIZE = 15;
		
		// Creation of the Tiles grid
		this.origin = new Tile();
		this.tiles.add(origin);
		
		
		Tile firstInRow = origin;
		for(int i = 0; i < NBROWS; i++) {
			Tile current = firstInRow;
			// Building the row
			for(int j = 1; j < NBCOLUMNS ; j++) {
				Tile newTile = new Tile();
				current.setAdjacent(Tile.Side.RIGHT, newTile);
				newTile.setAdjacent(Tile.Side.LEFT, current);
				if(i > 0) {
					
					Tile upLeft = current.getAdjacent(Tile.Side.UPRIGHT);
					Tile upRight = null;
					if(upLeft != null)
						upRight = upLeft.getAdjacent(Tile.Side.RIGHT);
					newTile.setAdjacent(Tile.Side.UPLEFT, upLeft);
					newTile.setAdjacent(Tile.Side.UPRIGHT, upRight);
					if(upLeft != null)
						upLeft.setAdjacent(Tile.Side.DOWNRIGHT, newTile);
					if(upRight != null)
						upRight.setAdjacent(Tile.Side.DOWNLEFT, newTile);
				}
				this.tiles.add(newTile);
				current = newTile;
			}
			
			// Transition to next row
			if(i < NBROWS - 1) {
				Tile newTile = new Tile();
				if( i % 2 == 0)
				{
					firstInRow.setAdjacent(Tile.Side.DOWNLEFT, newTile);
					newTile.setAdjacent(Tile.Side.UPRIGHT, firstInRow);
				}
				else {
					firstInRow.setAdjacent(Tile.Side.DOWNRIGHT, newTile);
					newTile.setAdjacent(Tile.Side.UPLEFT, firstInRow);
					firstInRow.getAdjacent(Tile.Side.RIGHT).setAdjacent(Tile.Side.DOWNLEFT, newTile);
					newTile.setAdjacent(Tile.Side.UPRIGHT, firstInRow.getAdjacent(Tile.Side.RIGHT));
				}
				firstInRow = newTile;
			}
		}
		
		// Creation of the territories
		for(Player player : players) {
			for(int i = 0; i < NBPLAYERTERRITORIES; i++) {
				Territory t = new Territory();
				t.setOwner(player);
				this.territories.add(t);
			}
		}
		
		// map generation
		Set<Tile> available = new HashSet<Tile>();
		available.add(origin);
		for(Territory territory : this.territories) {
			Set<Tile> availableForTerritory = new HashSet<Tile>();
			for(int i = 0; i < TERRITORYSIZE; i++) {
				Tile t;
				if(i == 0)
					t = (Tile) Map.pickRandomInSet(available);
				else 
					t = (Tile) Map.pickRandomInSet(availableForTerritory);
				if(t != null) {
					t.setTerritory(territory);
					available.remove(t);
					available.addAll(t.getEmptyAdjacents());
					availableForTerritory.remove(t);
					availableForTerritory.addAll(t.getEmptyAdjacents());
				}
			}
		}
		
		firstInRow = origin;
		for(int i = 0; i < NBROWS; i ++) {
			Tile current = firstInRow;
			for(int j = 1; j < NBCOLUMNS - i % 2; j++) {
				Territory t = current.getTerritory();
				Territory t_r = current.getAdjacent(Tile.Side.RIGHT).getTerritory();
				Territory t_dr = current.getAdjacent(Tile.Side.DOWNRIGHT).getTerritory();
				Territory t_dl = current.getAdjacent(Tile.Side.DOWNLEFT).getTerritory();
				
				if(t != t_r && t_r != null) {
					t.addNeighbor(t_r);
					t_r.addNeighbor(t);
				}
				
				if(t != t_dr && t_dr != null) {
					t.addNeighbor(t_dr);
					t_dr.addNeighbor(t);
				}
				if(t != t_dl && t_dl != null) {
					t.addNeighbor(t_dl);
					t_dl.addNeighbor(t);
				}
			}
		}
	}

	/**
	 * @return the territories
	 * @version 1.0
	 */
	public Set<Territory> getTerritories() {
		return territories;
	}

	/**
	 * @return the tiles
	 * @version 1.0
	 */
	public Set<Tile> getTiles() {
		return tiles;
	}
	
	/**
	 * 
	 * @return true if the entire map territories are owned by the same player
	 * @version 1.0
	 */
	public boolean isControlled() {
		Player precedent = null;
		for(Territory current : this.territories) {
			if(current.getOwner() != precedent)
				if (precedent != null)
					return false;
			precedent = current.getOwner();
		}
		
		return true;
	}
	
	public Player getWinner() {
		if(isControlled())
			return ((Territory)territories.toArray()[0]).getOwner();
		else
			return null;
	}

	/**
	 * @return the orgin
	 * @version 1.0
	 */
	public Tile getOrigin() {
		return origin;
	}
}
