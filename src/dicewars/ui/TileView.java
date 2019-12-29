/**
 * 
 */
/**
 * @author Baptiste MONGAI
 *
 */

package dicewars.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TileView {
	
	private int positionX;
	private int positionY;
	private boolean isSelect;

    public static void main(String[] args) {
        new TileView(0,0);
    }

    public TileView(int posX, int posY) {
   
    	this.positionX = posX;
    	this.positionY = posY;
    	//affichage
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

	public class TestPane extends JPanel {

//  **   private Shape hexagon;
        private List<Shape> cells = new ArrayList<>(6);  //cotés des hexagones

        private Shape highlighted;

        public TestPane() {                                   //pour surligner quand on passe la souris sur les hexagones
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    highlighted = null;
                    for (Shape cell : cells) {
                        if (cell.contains(e.getPoint())) {
                            highlighted = cell;
                            break;
                        }
                    }
                    repaint();
                }
            });
        }

        @Override
        public void invalidate() {
            super.invalidate();
            updateHoneyComb();
        }

        protected void updateHoneyComb() {
            GeneralPath path = new GeneralPath();

            double rowHeight = ((getHeight() * 1.14f) / 3f);
            double colWidth = getWidth() / 3f;

            double size = Math.min(rowHeight, colWidth) / 2d;

            double centerX = size / 2d;
            double centerY = size / 2d;

            double width = Math.sqrt(3d) * size;
            double height = size * 2;
            for (float i = 0; i < 6; i++) {
                float angleDegrees = (60f * i) - 30f;
                float angleRad = ((float) Math.PI / 180.0f) * angleDegrees;

                double x = centerX + (size * Math.cos(angleRad));
                double y = centerY + (size * Math.sin(angleRad));

                if (i == 0) {
                    path.moveTo(x, y);
                } else {
                    path.lineTo(x, y);
                }
            }
            path.closePath();

            cells.clear();
            double yPos = size / 2d;
            for (int row = 0; row < 3; row++) {  //c est pas ca
                double offset = (width / 2d);
                int colCount = 1;   //avant 2         //nombre de colonne
                if (row % 2 == 0) {         //selon s'il y a un nombre pair ou non d'hexagone sur la ligne emboite bien les hexagones
                    offset = 0;
                    colCount = 0;  //avant 3
                }
                double xPos = offset;
                for (int col = 0; col < colCount; col++) {
                    AffineTransform at = AffineTransform.getTranslateInstance(xPos + (size * 0.38), yPos);
                    Area area = new Area(path);
                    area = area.createTransformedArea(at);
                    cells.add(area);
                    xPos += width;
                }
                yPos += height * 0.75;
            }

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (highlighted != null) {                        //si on passe la souris dessus
                g2d.setColor(Color.RED);                     //surligne en bleu l'hexagone
                g2d.fill(highlighted);
            }
            g2d.setColor(Color.BLACK);          //couleur du contour
            for (Shape cell : cells) {
                g2d.draw(cell);
            }
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }
	
	 public boolean isSelect() {
			return isSelect;
		}

		public void setSelect(boolean isSelect) {
			this.isSelect = isSelect;
		}

}
	
	
	