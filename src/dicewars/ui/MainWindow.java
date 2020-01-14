package dicewars.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Baptiste MONGAI
 * @version 1.0
 */
public class MainWindow extends JFrame{

	/**
     * Construct the method MainWindow
     * @version 1.0
     */
	private static void MainWindow(){
		
		//Création de la frame
	    JFrame frame = new JFrame("Dicewars");
	    
	    frame.setSize(1920, 1200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    
	    //Création des boutons
	    JButton quit = new JButton("Quitter");
	    quit.setPreferredSize(new Dimension(100,70));
	    quit.setMinimumSize(new Dimension(100,70));
	    quit.setMaximumSize(new Dimension(100,70));
	    JButton multi = new JButton("Multijoueur");
	    multi.setPreferredSize(new Dimension(250,100));
	    multi.setMinimumSize(new Dimension(250,100));
	    multi.setMaximumSize(new Dimension(250,100));
	    JButton solo = new JButton("Hors ligne");
	    solo.setPreferredSize(new Dimension(250,100));
	    solo.setMinimumSize(new Dimension(250,100));
	    solo.setMaximumSize(new Dimension(250,100));
	    
	    //Création les panneaux
	    JPanel pannel = new JPanel();
	    JPanel pannel2 = new JPanel();
	    JPanel pannel3 = new JPanel();
	    
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
	    pannel2.setLayout(new BoxLayout(pannel2, BoxLayout.LINE_AXIS));
	    pannel2.add(solo);
	    pannel2.add(Box.createRigidArea(new Dimension(100,0)));
	    pannel2.add(multi);
	    
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
	    pannel3.setLayout(new BoxLayout(pannel3, BoxLayout.LINE_AXIS));
	    pannel3.add(quit);

	    //On positionne maintenant les deux lignes en colonne
	    pannel.setLayout(new BoxLayout(pannel, BoxLayout.PAGE_AXIS));
	    pannel.add(Box.createRigidArea(new Dimension(0,300)));
	    pannel.add(pannel2);
	    pannel.add(Box.createRigidArea(new Dimension(0,100)));
	    pannel.add(pannel3);


	    frame.setContentPane(pannel);
	    frame.setVisible(true);
	  }

	/**
     * Construct the method main
     * @version 1.0
     */
	public static void main(String[] args) {
		MainWindow();

	}
	

}
