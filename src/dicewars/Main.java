/**
 * 
 */
package dicewars;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import dicewars.game.Game;
import dicewars.game.Map;
import dicewars.game.Player;
import dicewars.ui.MapView;

/**
 * @author Thomas LINTANF
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Player[] p = new Player[6];
		
		p[0] = new Player(0, String.format("Player %d", 0), Color.red);
		p[1] = new Player(1, String.format("Player %d", 1), Color.blue);
		p[2] = new Player(2, String.format("Player %d", 2), Color.yellow);
		p[3] = new Player(3, String.format("Player %d", 3), Color.green);
		p[4] = new Player(4, String.format("Player %d", 4), Color.magenta);
		p[5] = new Player(5, String.format("Player %d", 5), Color.cyan);
		
		Game g = new Game(p);
		Map m = g.getMap();
		
		MapView panel = new MapView(m);
		
		JFrame f = new JFrame();
		f.setSize(new Dimension(1280,720));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(panel);
		f.setVisible(true);
	}

}
