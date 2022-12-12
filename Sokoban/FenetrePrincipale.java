package Sokoban;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class FenetrePrincipale extends JFrame {
	private final MonPanelFenetrePrincipale contentPane;
	private ImageIcon f;// = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\Sample_Sokoban.png");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
			FenetrePrincipale frame = new FenetrePrincipale();
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
		}
		}
	});
	}
	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		contentPane = new MonPanelFenetrePrincipale(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 610, 610);
		f = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\bleu.png");
		getContentPane().add(contentPane);
		getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Jouer j = new Jouer();
				j.setVisible(true);
			}
		});
		btnNewButton.setBounds(245, 138, 85, 21);
		getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Régles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Regle r = new Regle();
				r.setVisible(true);
		
				
			}
		});
		btnNewButton_1.setBounds(245, 234, 85, 21);
		getContentPane().add(btnNewButton_1);
		JLabel lblNewLabel = new JLabel("SOKOBAN", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 10, 586, 34);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
;			}
		});
		btnNewButton_2.setBounds(245, 327, 85, 21);
		getContentPane().add(btnNewButton_2);
	}
	
	public void dessiner(Graphics gr) {
	    Graphics bufferImage;
	    Image offscreen;
	    offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	    bufferImage = offscreen.getGraphics();
		bufferImage.drawImage(f.getImage(), 0, 0,610,610, this);
		gr.drawImage(offscreen,0,0,null);
	}
}
