package Sokoban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Regle extends JDialog {

	private final MonPanelRegle contentPanel;
	private ImageIcon f;

	/**
	 * Create the dialog.
	 */
	public Regle() {
		contentPanel = new MonPanelRegle(this);
		setBounds(500, 150, 610, 610);
		f = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\regle.png");
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 596, 573);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Règles", SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.white);
			lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
			lblNewLabel.setBounds(0, 6, 586, 55);
			contentPanel.add(lblNewLabel);
		}
		
		JTextPane texteRegle = new JTextPane();
		contentPanel.add(texteRegle);
		texteRegle.setText("Le Sokoban consiste à ranger des “caisses” à l’intérieur d’un entrepôt en les poussant sur les emplacements marqués au sol. Pour remplir l’objectif, un joueur doit déplacer les caisses dans l’entrepôt avec l’aide des boutons:\r\n"
				+ "	- K pour aller vers la gauche\r\n"
				+ "	- M pour aller vers la droite\r\n"
				+ "	- O pour aller vers le haut\r\n"
				+ "	- L pour aller vers la bas\r\n"
				+ "Cependant, le joueur a des actions restreintes:\r\n"
				+ "	- On ne peut pousser qu’une seule caisse à la fois.\r\n"
				+ "	- On ne peut pas traverser les murs.\r\n"
				+ "	- On ne peut pas passer par-dessus des caisses.\r\n"
				+ "	- On peut seulement pousser les caisses.\r\n"
				+ "Chaque niveau, l’entrepôt  possède une architecture différente généralement plus difficile.");
		texteRegle.setBounds(103, 144, 413, 291);
		{
			JButton cancelButton = new JButton("Retour");
			contentPanel.add(cancelButton);
			cancelButton.setBounds(508, 10, 78, 21);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					FenetrePrincipale f = new FenetrePrincipale();
					f.setVisible(true);
				}
			});
			cancelButton.setActionCommand("Retour");
		}
		
	}
	
	public void dessiner(Graphics gr) {
	    Graphics bufferImage;
	    Image offscreen;
	    offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	    bufferImage = offscreen.getGraphics();
		bufferImage.drawImage(f.getImage(), 0, 0,600,600, this);
		gr.drawImage(offscreen,0,0,null);
	}
}
