package dicewars.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
/**
 * @author Baptiste MONGAI
 *  @version 1.0
 */
public class Test extends JPanel {
 
    private Image image = null;
 
    /**
     * Constructeur
     * @param file nom du fichier
     */
    public Test(String file) {
        this.image = getToolkit().getImage(file);
        
        //On crée les boutons
        JButton quit = new JButton("Quitter");
	    quit.setPreferredSize(new Dimension(250,100));
	    quit.setMinimumSize(new Dimension(250,100));
	    quit.setMaximumSize(new Dimension(250,100));
	    JButton multi = new JButton("Multijoueur");
	    multi.setPreferredSize(new Dimension(250,100));
	    multi.setMinimumSize(new Dimension(250,100));
	    multi.setMaximumSize(new Dimension(250,100));
	    JButton solo = new JButton("Hors ligne");
	    solo.setPreferredSize(new Dimension(250,100));
	    solo.setMinimumSize(new Dimension(250,100));
	    solo.setMaximumSize(new Dimension(250,100));
	
	    //On ajoute les images
	    add(Box.createRigidArea(new Dimension(0,900)));
        add(solo);
        add(multi);
        add(quit);
   
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
 
    /**
     * Exemple : jPanelImage dans un JFrame
     * @param args
     */
    public static void main(String[] args) {
    	
        Test imagePanel = new Test("C:/Users/BaptisteM/Desktop/Projets/Java-2/FD.png");        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(imagePanel);
        frame.setSize(1920, 1200);
        frame.setVisible(true);
        
    }
}
