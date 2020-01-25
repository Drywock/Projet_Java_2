/**
 * 
 */
package dicewars.ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

/**
 * @author Thomas LINTANF
 *
 */
public class MenuButton extends JButton {
	
	public MenuButton(String label) {
		super(label);
		this.setPreferredSize(new Dimension(400,75));
	    this.setMinimumSize(new Dimension(400,75));
	    this.setMaximumSize(new Dimension(400,75));
	    this.setAlignmentX(CENTER_ALIGNMENT);
	    Font f =  new Font("Tahoma", Font.ITALIC + Font.BOLD ,20);
	    this.setFont(f);
	}

}
