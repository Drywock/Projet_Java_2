/**
 * 
 */
package dicewars.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Thomas LINTANF
 *
 */
public class MenuPanel extends JPanel {
	private Image image;
	
	public MenuPanel(String backgroundPath) {
		try {
    		this.image = ImageIO.read(new File(backgroundPath));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
     * Surcharger le dessin du composant
     * @param g canvas
     */
    protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        width = this.getWidth();
        height = this.getHeight();
        
        //On étire le l'image sur le Panel
        g.drawImage(this.image, x, y, width, height, this);
    }
}
