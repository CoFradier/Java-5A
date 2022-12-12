package Sokoban;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
@SuppressWarnings("serial")
class MonPanelResultat extends JPanel {
 // Réference sur la fenêtre niveau
	private Resultat monResultat;

	public MonPanelResultat(Resultat resultat) {
		monResultat = resultat;
	}
 
	 /**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
		 monResultat.dessiner(g);
	 }

}
