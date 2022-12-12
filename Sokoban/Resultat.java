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
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Resultat extends JDialog {

	private final MonPanelResultat contentPanel;
	private int niv;
	private ImageIcon f;
	private JTextField pseudo;
	private String nom;

	/**
	 * Create the dialog.
	 */
	public Resultat(int niv, Niveau n, int compteur) {
		contentPanel = new MonPanelResultat(this);
		contentPanel.setBounds(0, 0, 436, 263);
		this.niv = niv;
		setBounds(570, 300, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		f = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\bleu.png");
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bien joué!!", SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 416, 39);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 253, 436, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
		{
			JButton btnNewButton = new JButton("Niveau suivant");
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						n.dispose();
						on_NiveauSuivant_clicked(e);
						appelBDD(nom,niv,compteur);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(248, 176, 123, 21);
		}
		{
			JButton btnNewButton_1 = new JButton("Recommencer");
			contentPanel.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						n.dispose();
						on_Restart_clicked(e);
						appelBDD(nom,niv,compteur);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_1.setBounds(47, 176, 126, 21);
		}
		
		pseudo = new JTextField();
		contentPanel.add(pseudo);
		pseudo.setBounds(214, 95, 96, 19);
		pseudo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pseudo");
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(111, 92, 77, 27);
		contentPanel.add(lblNewLabel_1);
	}
	
	public void dessiner(Graphics gr) {
	    Graphics bufferImage;
	    Image offscreen;
	    offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	    bufferImage = offscreen.getGraphics();
	    bufferImage.drawImage(f.getImage(), 0, 0,450, 300, this);
		gr.drawImage(offscreen,0,0,null);
	}
	
	public void on_Restart_clicked(ActionEvent e) throws FileNotFoundException
	{
		nom = pseudo.getText();
	    //efface la grille en cours
		dispose();
	    //dessine le fichier du niveau en cours
	    Niveau n = new Niveau(niv);
		n.setVisible(true);
	}
	
	public void on_NiveauSuivant_clicked(ActionEvent e) throws FileNotFoundException
	{
		nom = pseudo.getText();
	    //efface la grille en cours
	    //this.reject();
	    //verifie que le niveau 12 n'est pas atteint et affiche le niveau suivant
	    //si le niveau 12 et atteint alors il affichera le niveau 1
	    if(niv==12){
	    	dispose();
	    	Niveau n = new Niveau(1);
			n.setVisible(true);
	    }
	    else{
	    	dispose();
	    	Niveau n = new Niveau(niv+1);
			n.setVisible(true);
	    }
	}
	
	public void appelBDD(String nom, int niv, int compteur) {
		String BDD = "Sokoban";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "";
        // L'essaie de connexion à votre base de donées
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stm=conn.createStatement();
            System.out.println("Connecter");
            String query = "INSERT INTO resultat (`Pseudo`,`Niveau`, `NbCoups`) " + "VALUES ('"+nom+"',"+String.valueOf(niv)+","+String.valueOf(compteur)+")";
	        stm.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
	}
}
