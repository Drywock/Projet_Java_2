/**
 * 
 */
package dicewars.ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import dicewars.game.Map;
import dicewars.game.Tile;
import dicewars.game.Tile.Side;

/**
 * @author Thomas LINTANF
 *
 */
public class MapView extends JPanel{
	
	
	private Map map;
	private Set<TileView> tileViews;
	
	public MapView(Map m) {
		super();
		map = m;
		tileViews = new HashSet<TileView>();
		this.setLayout(null);
		Tile headOfRow = map.getOrigin();
		int cpt = 0;
		
		Insets insets = this.getInsets();
		
		while(headOfRow != null) {
			Tile current = headOfRow;
			int c = 0;
			while(current != null) {
				TileView tv = new TileView(current);
				this.add(tv);
				Dimension size = tv.getPreferredSize();
				tv.setBounds(( 2 * c + (cpt % 2) )* size.width *1/2 + insets.left, cpt * size.width + insets.top, size.width, size.height);
				current = current.getAdjacent(Side.RIGHT);
				c++;
			}
			if(cpt % 2 == 0)
				headOfRow = headOfRow.getAdjacent(Side.DOWNRIGHT);
			else
				headOfRow = headOfRow.getAdjacent(Side.DOWNLEFT);
			cpt++;
		}
	}

}
