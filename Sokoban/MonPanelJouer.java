package Sokoban;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
@SuppressWarnings("serial")
class MonPanelJouer extends JPanel {
 // Réference sur la fenêtre niveau
	private Jouer monJouer;

	public MonPanelJouer(Jouer jouer) {
		monJouer = jouer;
	}
 
	 /**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
		 monJouer.dessiner(g);
	 }

}
