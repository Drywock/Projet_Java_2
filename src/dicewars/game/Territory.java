/**
 * 
 */
package dicewars.game;

/**
 * @author Thomas LINTANF
 *
 */
public class Territory {
	
	//Instances  
	private int dicesCount;
	private int owner;
	private Territory neighbours[];
	
	//constructor
	public Territory() {
					
}

	public int getDicesCount() {
		return dicesCount;
	}

	public void setDicesCount(int dicesCount) {
		  if(dicesCount > 0 && dicesCount <= 8){
              this.dicesCount = dicesCount;
		  }
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
		 if(this.dicesCount < 8){
             this.dicesCount ++;
      }
	}
}
