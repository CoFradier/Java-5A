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
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Jouer extends JDialog {

	private final MonPanelJouer contentPanel;
	private ImageIcon f;

	/**
	 * Create the dialog.
	 */
	public Jouer() {
		contentPanel = new MonPanelJouer(this);
		contentPanel.setBounds(0, 0, 609, 573);
		f = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\bleu.png");
		setBounds(500, 150, 610, 610);
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					on_pB_clicked(e,1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(43, 139, 85, 21);
		contentPanel.add(btnNewButton);
		{
			JButton btnNewButton_1 = new JButton("2");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,2);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_1.setBounds(246, 139, 85, 21);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("3");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,3);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setBounds(447, 139, 85, 21);
			contentPanel.add(btnNewButton_2);
		}
		{
			JButton btnNewButton_3 = new JButton("4");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,4);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_3.setBounds(43, 247, 85, 21);
			contentPanel.add(btnNewButton_3);
		}
		{
			JButton btnNewButton_4 = new JButton("5");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,5);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_4.setBounds(246, 247, 85, 21);
			contentPanel.add(btnNewButton_4);
		}
		{
			JButton btnNewButton_5 = new JButton("6");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,6);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_5.setBounds(447, 247, 85, 21);
			contentPanel.add(btnNewButton_5);
		}
		{
			JButton btnNewButton_6 = new JButton("7");
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,7);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_6.setBounds(43, 355, 85, 21);
			contentPanel.add(btnNewButton_6);
		}
		{
			JButton btnNewButton_7 = new JButton("8");
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,8);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_7.setBounds(246, 355, 85, 21);
			contentPanel.add(btnNewButton_7);
		}
		{
			JButton btnNewButton_8 = new JButton("9");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,9);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_8.setBounds(447, 355, 85, 21);
			contentPanel.add(btnNewButton_8);
		}
		{
			JButton btnNewButton_9 = new JButton("10");
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,10);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_9.setBounds(43, 469, 85, 21);
			contentPanel.add(btnNewButton_9);
		}
		{
			JButton btnNewButton_10 = new JButton("11");
			btnNewButton_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,11);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_10.setBounds(246, 469, 85, 21);
			contentPanel.add(btnNewButton_10);
		}
		{
			JButton btnNewButton_11 = new JButton("12");
			btnNewButton_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						on_pB_clicked(e,12);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_11.setBounds(447, 469, 85, 21);
			contentPanel.add(btnNewButton_11);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 553, 586, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
		{
			JLabel lblNewLabel = new JLabel("Niveaux",SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
			lblNewLabel.setForeground(Color.white);
			lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
			lblNewLabel.setBounds(0, 10, 586, 57);
		}
		{
			JButton cancelButton = new JButton("Retour");
			contentPanel.add(cancelButton);
			cancelButton.setBounds(489, 10, 87, 21);
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
		bufferImage.drawImage(f.getImage(), 0, 0,610,610, this);
		gr.drawImage(offscreen,0,0,null);
	}
	
	public void on_pB_clicked(ActionEvent e, int niv) throws FileNotFoundException
	{
		Niveau n = new Niveau(niv);
		n.setVisible(true);
	}
	

}
