/**
 * 
 */
package dicewars.game;

import java.util.HashSet;

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
		final int STARTING_DICES = 10;
		
		this.players = players;
		this.currentPlayer = 0;
		this.map = new Map();
		this.map.generate(this.players);
		
		for(Player p : this.players) {
			HashSet<Territory> ts = new HashSet<Territory>(p.getTerritories());
			for(int i = 0; i < STARTING_DICES; i++) {
				Territory t = (Territory) Map.pickRandomInSet(ts);
				try {
					t.addDice();
				} catch(IllegalArgumentException e) {
					i--;
					ts.remove(t);
				}
				if(ts.isEmpty())
					i = STARTING_DICES;
			}
		}
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
		Player current = getCurrentPlayer();
		
		// Distribue les dès en fin de tour
		int dicesToAdd = current.getTerritories().size();
		HashSet<Territory> ts = new HashSet<Territory>(current.getTerritories());
		for(int i = 0; i < dicesToAdd; i++) {
			Territory t = (Territory) Map.pickRandomInSet(ts);
			try {
				t.addDice();
			} catch (IllegalArgumentException e) {
				ts.remove(t);
				i--;
			} catch(NullPointerException e) {
				i = dicesToAdd;
			}
		}
		
		// Transitione vers le joueur suivant
		if(this.currentPlayer < this.players.length -1)
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
			if (attacker.rollDices(false) > defender.rollDices(true)) {
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
