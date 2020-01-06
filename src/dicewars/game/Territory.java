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
	
	//Constructor
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
	public int rollDices(){
		int total = 0;
		for(int i = 0; i < dicesCount; i ++) {
			total += 1 + (int)(Math.random()*6);
		}
		return total;
		
		
	}
}
