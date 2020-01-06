/**
 * 
 */
package dicewars.game;

/**
 * @author Thomas LINTANF
 * @version 1.0
 */
public class Game {
	
	
	private Player players[];
	private Map map;
	private int currentPlayer;
	
	/**
	 * Constructs the Game class
	 * @param players
	 * @version 1.0
	 */
	public Game(Player players[]) {
		this.players = players;
		this.currentPlayer = 0;
		this.map = new Map();
		this.map.generate(this.players);
	}
	
	/**
	 * 
	 * @return The current Player
	 * @version 1.0
	 */
	public Player getCurrentPlayer() {
		return players[currentPlayer];
	}
	
	/**
	 * Move the game to the next Player
	 * @version 1.0
	 */
	public void nextPlayer() {
		if(this.currentPlayer < this.players.length)
			this.currentPlayer++;
		else
			this.currentPlayer = 0;
	}
	
	/**
	 * Execute an attack from one Territory from another
	 * @param attacker
	 * @param defender
	 * @return true if attack succeed false otherwise
	 * @throws Exception
	 * @version 1.0
	 */
	public boolean attack(Territory attacker, Territory defender) throws Exception {
		if(attacker.getOwner() != getCurrentPlayer())
			throw new Exception();
		else if(attacker.getDicesCount() <= 1)
			throw new Exception();
		else if(attacker.getOwner() == defender.getOwner())
			throw new Exception();
		else {
			if (attacker.rollDice() > defender.rollDice()) {
				defender.setOwner(getCurrentPlayer());
				defender.setDicesCount(attacker.getDicesCount() - 1);
				attacker.setDicesCount(1);
				return true;
			}
			else {
				attacker.setDicesCount(1);
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return The map
	 * @version 1.0
	 */
	public Map getMap() {
		return this.map;
	}
}
