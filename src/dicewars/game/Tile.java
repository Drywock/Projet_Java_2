/**
 * 
 */
package dicewars.game;

/**
 * @author Thomas LINTANF
 *
 */
public class Tile {
	
	//Instances
	Territory territory;
	Tile adjacent;
	
	//Constructor
	public Tile(Territory territory, Tile adjacent) {
		this.adjacent = adjacent;
		this.territory = territory;
	}

	public enum Side{
		UPLEFT,
		UPRIGHT,
		RIGHT,
		DOWNRIGHT,
		DOWNLEFT,
		LEFT;
	}
	public Territory getTerritory() {
		return territory;
	}
	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	public Tile getAdjacent(Side side) {
		return adjacent;
	}
	public void setAdjacent(Tile adjacent , Side side) {
		this.adjacent = adjacent;
	}
	//Testing of the different functions 
	/*public static void main(String[] args) {
		Territory t1 = new Territory(1,3,null);
		Territory t2 = new Territory(2,4,null);
		t1.addNeighbours(t2);
		Tile Tile1 = new Tile(t1,null);
		Tile Tile2 = new Tile(t2,Tile1);
		Tile1.adjacent = Tile2;
		
		System.out.println("Owner: "+ t1.owner + "\nDices Count: "+ t1.dicesCount);
		
		System.out.println("Owner: "+ Tile1.territory.owner + "\nDices Count: "+ Tile1.territory.dicesCount);
		
		Tile1.setTerritory(t2);
		
		System.out.println("Owner: "+ Tile1.adjacent.territory.owner + "\nDices Count: "+ Tile1.adjacent.territory.dicesCount);
	}*/
	

}
