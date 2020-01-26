/**
 * 
 */
package dicewars.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dicewars.game.Game;
import dicewars.game.Territory;
import dicewars.game.Tile;

/**
 * @author Thomas LINTANF
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private Game game;
	private Territory attackingT;
	private Territory defendingT;
	private CurrentPlayerBox currentPlayerBox;
	
	public GamePanel(Game game) {
		super();
		this.game = game;
		this.attackingT = null;
		this.defendingT = null;
		this.currentPlayerBox = new CurrentPlayerBox(game.getCurrentPlayer());
		
		MapView m = new MapView(game.getMap(), new SelectionListener());
		JButton attack = new JButton("Attaquer !");
		JButton nextPlayer = new JButton("Joueur suivant");
		
		attack.addActionListener(new AttackListener());
		nextPlayer.addActionListener(new NextPlayerListener());
		
		Box buttonBar = Box.createHorizontalBox();
		
		buttonBar.add(currentPlayerBox);
		buttonBar.add(nextPlayer);
		buttonBar.add(attack);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(m);
		this.add(buttonBar);
	}

	class SelectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TileView tv = (TileView) e.getSource();
			Tile t = tv.getTile();
			Territory ter = t.getTerritory();
			if(game.getCurrentPlayer() == ter.getOwner()) {
				attackingT = ter;
			} else if(attackingT != null) {
				if( attackingT.getNeighbors().contains(ter))
					defendingT = ter;
			}
			
		}
		
	}
	
	class AttackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				game.attack(attackingT, defendingT);
				GamePanel.this.repaint();
				GamePanel.this.revalidate();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(game.getMap().isControlled()) {
				JDialog dial = new JDialog();
				dial.setLayout(new FlowLayout());
				dial.setModal(true);
				String str = String.format("Le gagant est le joueur : %d", game.getCurrentPlayer().getId() + 1);
				dial.add(new JLabel(str));
				dial.setVisible(true);
			}

		}

	}
	
	class NextPlayerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.nextPlayer();
			attackingT = null;
			defendingT = null;
			currentPlayerBox.setPlayer(game.getCurrentPlayer());
			GamePanel.this.repaint();
			GamePanel.this.revalidate();
		}
		
	}
}
