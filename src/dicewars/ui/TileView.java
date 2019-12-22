/**
 * 
 */
/**
 * @author Baptiste MONGAI
 *
 */
package dicewars.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileView extends JFrame {

	private boolean isSelect;
	static JButton hexagon = new JButton("test");
	static JPanel panel = new JPanel();
	
	public TileView(int positionX, int positionY) {
		
		//taille au lancement du panel
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pour avoir un affichage du panel
		setVisible(true);
		//pour afficher le boutton
		getContentPane().add(hexagon);
		//pour que l'hexagone soit dans un panneau et pas juste l'afficher lui,
		//au quel cas il n'y aurait plus aucune utilité à lui donner une position
		getContentPane().add(panel);
		//on défini la taille du boutton
		hexagon.setSize(120, 30);
		//on défini la position du boutton
		hexagon.setLocation(positionX, positionY);	
	}
	
	//exemple pour voir si ca marché
	public static void main(String[] args) {
		new TileView(0, 0);
	}
	
	boolean isSelect() {
		return isSelect;
	}
	
	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
	
}
	
	
	