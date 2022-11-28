package Sokoban;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class FenetrePrincipale extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.setBounds(224, 99, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Régles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(224, 143, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("SOKOBAN", SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setBounds(0, 10, 512, 34);
		getContentPane().add(lblNewLabel);
		//contentPane = new JPanel();
		
	}
}
