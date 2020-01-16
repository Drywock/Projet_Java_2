package dicewars.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author Baptiste MONGAI 
 * @version 1.1
 */
public class MainWindow extends JFrame{

	/**
     * Construct the method MainWindow
     * @version 1.1
     */
	private static void MainWindow(){
		
		//Cr�ation de la frame
	    JFrame frame = new JFrame("Dicewars");
	    
	    frame.setSize(1920, 1200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    
	    //Cr�ation des boutons
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
	    JButton back = new JButton("Retour");
	    back.setPreferredSize(new Dimension(100,70));
	    back.setMinimumSize(new Dimension(100,70));
	    back.setMaximumSize(new Dimension(100,70));
	    JButton back2 = new JButton("Retour");
	    back2.setPreferredSize(new Dimension(100,70));
	    back2.setMinimumSize(new Dimension(100,70));
	    back2.setMaximumSize(new Dimension(100,70));
	    //JButton nbBots = new JButton("Choisir le nombre de d'ordi :");
	    //nbBots.setPreferredSize(new Dimension(300,70));
	    //nbBots.setMinimumSize(new Dimension(300,70));
	    //nbBots.setMaximumSize(new Dimension(300,70));
	    
	    //Cr�e un liste d�roulante
	    JComboBox liste1;
	    Object[] nbJoueurs = new Object[]{"1 ordi", "2 ordi", "3 ordi", "4 ordi", "5 ordi ", "6 ordi", "7 ordi"};
	    liste1 = new JComboBox(nbJoueurs);
	    
		//Cr�ation les panneaux
	    JPanel panel = new JPanel();
	    JPanel panel2 = new JPanel();
	    JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	    JPanel panel5 = new JPanel();

	    JPanel panelSolo = new JPanel();
	    JPanel panelMulti = new JPanel();
	    

	    
	    //On d�finit le layout en lui indiquant qu'il travaillera en ligne
	    panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
	    panel2.add(solo);
	    panel2.add(Box.createRigidArea(new Dimension(100,0)));
	    panel2.add(multi);
	    
	    //On d�finit le layout en lui indiquant qu'il travaillera en ligne
	    panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
	    panel3.add(quit);
	    
	    //On d�finit le layout en lui indiquant qu'il travaillera en ligne
	    panel4.setLayout(new BoxLayout(panel4, BoxLayout.LINE_AXIS));
	    panel4.add(back);
	    
	    //On d�finit le layout en lui indiquant qu'il travaillera en ligne
	    panel5.setLayout(new BoxLayout(panel5, BoxLayout.LINE_AXIS));
	    panel5.add(back2);
	    
	    
	    //On positionne maintenant les deux lignes en colonne
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	    panel.add(Box.createRigidArea(new Dimension(0,300)));
	    panel.add(panel2);
	    panel.add(Box.createRigidArea(new Dimension(0,100)));
	    panel.add(panel3);
	    
	    //On positionne maintenant les deux lignes en colonne
	    panelSolo.setLayout(new FlowLayout());
	    panelSolo.add(Box.createRigidArea(new Dimension(0,700)));
	    panelSolo.add(panel4);
	    //panelSolo.add(nbBots);
	    //Cr�e une zone de texte et pas un bouton
	    panelSolo.add(new JTextField("Nombre de d'ordi :"));
	    panelSolo.add(liste1);
	    
	    

	    //On positionne maintenant les deux lignes en colonne
	    panelMulti.setLayout(new BoxLayout(panelMulti, BoxLayout.PAGE_AXIS));
	    panelMulti.add(panel5);
	    
	   
	    
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);


	    solo.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.repaint();
	        	frame.setContentPane(panelSolo);
	        	frame.setVisible(true);
	      }
	      });
	    
	    back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.repaint();
		        frame.setContentPane(panel);
		        frame.setVisible(true);
	  }
	    });
	    
	    multi.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.repaint();
		        frame.setContentPane(panelMulti);
		        frame.setVisible(true);
	  }
	    });
	    back2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.repaint();
		        frame.setContentPane(panel);
		        frame.setVisible(true);
	         } });

	}

	/**
     * Construct the method main
     * @version 1.0
     */
	public static void main(String[] args) {
		MainWindow();

	}
	
}
