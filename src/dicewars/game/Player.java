/**
 * 
 */
package dicewars.game;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Thomas LINTANF
 * @version 1.0
 */
public class Player {

  
	private int id;
	private String name;
	private Set<Territory> territories;
	private Color color;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param color
	 * @version 1.0
	 */
	public Player(int id, String name, Color color) {
		this.id = id;
		this.name = name;
		this.territories = new HashSet<Territory>();
		this.color = color;
	}

	/**
	 * @return the name
	 * @version 1.0
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 * @version 1.0
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 * @version 1.0
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the territories
	 * @version 1.0
	 */
	public Set<Territory> getTerritories() {
		return territories;
	}

	/**
	 * 
	 * @param territory
	 * @version 1.0
	 */
	public void addTerritories(Territory territory) {
		this.territories.add(territory);
	}
	
	/**
	 * 
	 * @param territory
	 * @version 1.0
	 */
	public void removeTerritory(Territory territory) {
		this.territories.remove(territory);
	}

	/**
	 * @return the color
	 * @version 1.0
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 * @version 1.0
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
