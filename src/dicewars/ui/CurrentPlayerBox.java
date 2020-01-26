/**
 * 
 */
package dicewars.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

import dicewars.game.Player;

/**
 * @author Thomas LINTANF
 *
 */
@SuppressWarnings("serial")
public class CurrentPlayerBox extends JComponent {
	private Player player;
	
	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}


	public CurrentPlayerBox(Player p) {
		player = p;
		setMaximumSize(new Dimension(30, 30));
	}

	
	protected void paintComponent(Graphics g) {
		g.setColor(player.getColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		String str = String.format("%d", player.getId() + 1);
		g.drawString(str, getWidth() *3/8, getHeight()*5/8);
	}
}
