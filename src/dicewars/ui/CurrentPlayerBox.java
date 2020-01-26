/**
 * 
 */
package dicewars.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * @author Thomas LINTANF
 *
 */
public class CurrentPlayerBox extends JComponent {
	private Color color;
	
	public CurrentPlayerBox(Color color) {
		setColor(color);
		setMaximumSize(new Dimension(30, 30));
		setAlignmentY(CENTER_ALIGNMENT);
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
	}
}
