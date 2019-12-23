/**
 * 
 */
package dicewars.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Thomas LINTANF
 *
 */
public class Map {
	private Set<Territory> territories;
	private Set<Tile> tiles;
	
	/**
	 * Construct the Map class
	 */
	public Map() {
		this.territories = new HashSet<Territory>();
		this.tiles = new HashSet<Tile>();
	}
	
	private Object pickRandomInSet(Set s) {
		int rd = new Random().nextInt(s.size());
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
	 */
	public void generete(Player[] players) {
		final int NBLINES = 50;
		final int NBROWS = 20;
		final int NBPLAYERTERRITORIES = 5;
		final int TERRITORYSIZE = 5;
		
		// Creation of the Tiles grid
		Tile origin = new Tile();
		this.tiles.add(origin);
		
		
		Tile current = origin;
		
		for(int i = 0; i < NBROWS; i++) {
			for(int j = 0; j < NBLINES - i % 2; j++) {
				Tile newTile = new Tile();
				current.setAdjacent(newTile, Side.RIGHT);
				newTile.setAdjacent(current, Side.LEFT);
				if(i > 0) {
					newTile.setAdjacent(current.getAdjacent(Side.UPRIGHT), Side.UPLEFT);
					newTile.setAdjacent(current.getAdjacent(Side.UPRIGHT).getAdjacent(Side.RIGHT),Side.UPRIGHT);
					newTile.getAdjacent(Side.UPLEFT).setAdjacent(newTile, Side.DOWNRIGHT);
					newTile.getAdjacent(Side.UPRIGHT).setAdjacent(newTile, Side.DOWNLEFT);
				}
				this.tiles.add(newTile);
				current = newTile;
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
			for(int i; i < TERRITORYSIZE; i++) {
				Tile t = (Tile) this.pickRandomInSet(available);
				t.setTerritory(territory);
				available.remove(t);
				available.addAll(t.getEmptyAdjacent())
			}
		}
	}

	/**
	 * @return the territories
	 */
	public Set<Territory> getTerritories() {
		return territories;
	}

	/**
	 * @return the tiles
	 */
	public Set<Tile> getTiles() {
		return tiles;
	}
	
}
