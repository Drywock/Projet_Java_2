package dicewars.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dicewars.game.Game;
import dicewars.game.Player;


/**
 * @author Baptiste MONGAI, Thomas LINTANF
 * @version 2.0
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame{

	private Player[] allPlayer;
	private JComboBox<String> liste2;
	/**
	 * Contruct the class MainWindow
	 * @version 2.0
	 */
	public MainWindow(){
		//Création de la frame
		super("DiceWars");
		this.setSize(1282, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);


		//Création des boutons
		JButton quit = new MenuButton("Quitter");
		JButton multi = new MenuButton("Multijoueur");
		JButton solo = new MenuButton("Solo");
		JButton back = new MenuButton("Retour");
		JButton back2 = new MenuButton("Retour");
		JButton playSolo = new MenuButton("Jouer");
		JButton playMulti = new MenuButton("Jouer");


		//Crée un liste déroulante
		final int NB_MAX_PLAYER = 6;
		
		String[] optOrdi = new String[NB_MAX_PLAYER - 1];
		for (int i = 1;i < NB_MAX_PLAYER; i++)
			optOrdi[i-1] = String.format("%d ordi",i);
		JComboBox<String> liste1 = new JComboBox<String>(optOrdi);
		
		String[] optJoueurs = new String[NB_MAX_PLAYER-1];
		for (int i = 2;i <= NB_MAX_PLAYER; i++)
			optJoueurs[i-2] = String.format("%d joueurs",i);
		this.liste2 = new JComboBox<String>(optJoueurs);


		//Création les panneaux
		JPanel panel = new MenuPanel("./background.png");
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panelSolo = new MenuPanel("./background.png");
		JPanel panelMulti = new MenuPanel("./background.png");

		//On définit le layout en lui indiquant qu'il travaillera en ligne
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.LINE_AXIS));
		panel4.add(back);

		//On définit le layout en lui indiquant qu'il travaillera en ligne
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.LINE_AXIS));
		panel5.add(back2);


		//On positionne maintenant les deux lignes en colonne
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0,250)));
		panel.add(solo);
		panel.add(Box.createRigidArea(new Dimension(0,50)));
		panel.add(multi);
		panel.add(Box.createRigidArea(new Dimension(0,50)));
		panel.add(quit);

		//On positionne maintenant les boutons et la zone de texte avec un FlowLayout
		panelSolo.setLayout(new FlowLayout());
		panelSolo.add(Box.createRigidArea(new Dimension(0,900)));
		panelSolo.add(panel4);

		//Crée une zone de texte et pas un bouton
		panelSolo.add(new JLabel("Nombre de d'ordi :"));

		panelSolo.add(liste1);
		panelSolo.add(playSolo);

		//On positionne maintenant les boutons et la zone de texte avec un FlowLayout
		panelMulti.setLayout(new FlowLayout());
		panelMulti.add(Box.createRigidArea(new Dimension(0,900)));
		panelMulti.add(panel5);

		//Crée une zone de texte et pas un bouton
		panelMulti.add(new JTextField("Nombre de joueurs :"));

		panelMulti.add(liste2);
		panelMulti.add(playMulti);

		ActionListener goBackListener = new SwitchPanelActionListener(panel);
		ActionListener goToSoloListener = new SwitchPanelActionListener(panelSolo);
		ActionListener goToMultiListener = new SwitchPanelActionListener(panelMulti);

		solo.addActionListener(goToSoloListener);
		back.addActionListener(goBackListener);
		multi.addActionListener(goToMultiListener);
		back2.addActionListener(goBackListener);
		
		
		
		this.allPlayer = new Player[6];
		
		allPlayer[0] = new Player(0, String.format("Player %d", 0), Color.red);
		allPlayer[1] = new Player(1, String.format("Player %d", 1), Color.blue);
		allPlayer[2] = new Player(2, String.format("Player %d", 2), Color.yellow);
		allPlayer[3] = new Player(3, String.format("Player %d", 3), Color.green);
		allPlayer[4] = new Player(4, String.format("Player %d", 4), Color.magenta);
		allPlayer[5] = new Player(5, String.format("Player %d", 5), Color.cyan);
		
		
		
		playMulti.addActionListener(new StartGameActionListener());
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.dispatchEvent(new WindowEvent(MainWindow.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		this.setContentPane(panel);
		this.setVisible(true);

	}
	
	public class SwitchPanelActionListener implements ActionListener{
		private JPanel panel;
		
		public SwitchPanelActionListener(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainWindow.this.setContentPane(panel);
			MainWindow.this.repaint();
			MainWindow.this.revalidate();;
		}
		
	}
	
	public class StartGameActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String value = (String) liste2.getSelectedItem();
			String s[] = value.split(" ");
			int nbJoueurs = Integer.parseInt(s[0]);
			
			Player[] p = new Player[nbJoueurs];
			for(int i =0; i < nbJoueurs; i++)
				p[i] = allPlayer[i];
				
			Game g = new Game(p);
			GamePanel gamePanel = new GamePanel(g);
			
			MainWindow.this.setContentPane(gamePanel);
			MainWindow.this.repaint();
			MainWindow.this.revalidate();;
		}
	}

}
