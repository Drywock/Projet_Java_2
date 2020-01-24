package dicewars.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JButton;
import dicewars.game.Tile;

/**
 * @author Baptiste MONGAI, Thomas LINTANF
 * @version 1.4
 */
public class TileView extends JButton  {
	
	
	private final int N= 6;
	private double angle;
	private Polygon hexagon;
	private boolean isSelected;
	private Tile tile;
	
    /**
     * Construct the class TileView the Tile t
     * @param t
     * @version 1.4
     */
    public TileView(Tile t) {
    	super();
    	Dimension size = new Dimension(30, 30);
    	setPreferredSize(size);
    	setContentAreaFilled(false);
    	
    	tile = t;
    	angle = 2*Math.PI/N;
    	hexagon = null;
    	isSelected = false;
    	this.addMouseListener(null);
    	this.addMouseMotionListener(null);
    }
    
    /**
     * Update the hexagon
     * @version 1.1
     */
    private void updateHexagon() {
    	int [] x = new int[N];
    	int [] y = new int[N];
        int x0 = getSize().width/2;
        int y0 = getSize().height/2;
        for(int i=0; i < N; i++) {
            double v = i*angle + Math.PI/2;
            x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
            y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
        }
        this.hexagon = new Polygon(x,y,N);
    }
    
    /**
     * @version 1.0
     */
    protected void paintComponent(Graphics g) {
    	if(tile.getTerritory() != null)
    		g.setColor(tile.getTerritory().getOwner().getColor());
    	else
    		g.setColor(Color.white);
    	updateHexagon();
        g.fillPolygon(hexagon);
        super.paintComponent(g);
    }
    
    /**
     * @verion 1.0
     */
    protected void paintBorder(Graphics g) {
        if (this.getModel().isSelected())
        	g.setColor(Color.white);
        else
        	g.setColor(Color.black);
        g.drawPolygon(hexagon);
    }
     
    /**
     * @version 1.0
     */
    public boolean contains(int x1, int y1) {
        if(this.hexagon == null)
        	return false;
        else
        	return hexagon.contains(x1,y1);
    }
    
    /**
	 * @return the isSelected
	 * @version 1.0
	 */
	public boolean isSelected() {
		return isSelected;
	}


	/**
	 * @param isSelected the isSelected to set
	 * @version 1.0
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * @return the Tile
	 * @version 1.0
	 */
	public Tile getTile() {
		return tile;
	}
 
}
