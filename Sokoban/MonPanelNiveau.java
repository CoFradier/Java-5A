package Sokoban;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
@SuppressWarnings("serial")
class MonPanelNiveau extends JPanel {
 // Réference sur la fenêtre niveau
	private Niveau monNiveau;

	public MonPanelNiveau(Niveau niveau) {
		monNiveau = niveau;
	}
 
	 /**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
		 monNiveau.dessiner(g);
	 }
	 
}
