package Sokoban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;

public class Niveau extends JDialog {

	private final MonPanelNiveau contentPanel;
	private int niv;
    private boolean enCours;
    private Grille g;
    private ImageIcon f;
    private int compteur;
    
	/**
	 * Create the dialog.
	 * @throws FileNotFoundException 
	 */
	public Niveau(int niv) throws FileNotFoundException {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				formKeyPressed(e);
			}
		});
		contentPanel = new MonPanelNiveau(this);
		f = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\bleu.png");
		contentPanel.setBounds(0, 0, 607, 610);
		contentPanel.setFocusable(false);
		this.niv=niv;
	    enCours=true;
	    g = new Grille("Java-5A\\Niveau\\niveau"+String.valueOf(niv)+".txt");
		setBounds(500, 150, 610, 600);
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Niveau", SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.white);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(197, 0, 215, 62);
		{
			JButton cancelButton = new JButton("Retour");
			contentPanel.add(cancelButton);
			cancelButton.setFocusable(false);
			cancelButton.setBounds(505, 10, 81, 21);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Jouer j = new Jouer();
					j.setVisible(true);
				}
			});
			cancelButton.setActionCommand("Retour");
		}
		
		JButton btnNewButton = new JButton("Recommencer");
		contentPanel.add(btnNewButton);
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					on_Restart_clicked(e);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 10, 130, 21);
	}
	
	public void dessiner(Graphics gr) {
	    Graphics bufferImage;
	    Image offscreen;
	    offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	    bufferImage = offscreen.getGraphics();
	    bufferImage.drawImage(f.getImage(), 0, 0,610,610, this);
		g.dessiner(bufferImage);
		gr.drawImage(offscreen,0,0,null);
	}
	
	public void formKeyPressed(KeyEvent evt)  {
	    int val,val2,val3;
	    
	    //on recupere dans val l'indice du joueur dans grilleM
	    val=g.getJoueurGrilleM();
	    //on recupere dans val2 l'indice du joueur dans grille
	    val2=g.getJoueurGrille();
	    //on utilise les boutons k,l,m,o pour déplacer le joueur et les caisses
	    switch(evt.getKeyCode()){
	        case KeyEvent.VK_K : //on recupere la voisine du joueur s'il existe dans grilleM
	        				compteur +=1;
	                        val3=g.getVoisine(-1);
	                        //on regarde si la voisine du joueur est une caisse
	                         if(g.getCaisse(-1)){
	                             //on regarde si la voisine de la voisine du joueur est libre
	                             if(g.getLibre(-2)){
	                                //on déplace la caisse et le joueur
	                                g.getGrilleM().get(val3).deplacerDe(-1,0);
	                                g.getGrilleM().get(val).deplacerDe(-1,0);
	                                //on verifie si la caisse devient placé ou non placé
	                                if(g.getGrille().get(val2-2).getType()==4){
	                                    g.getGrilleM().get(val3).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2-2).getType()==2){
	                                    g.getGrilleM().get(val3).setPlace(false);
	                                }
	                                //on verifie si le joueur devient placé ou non placé
	                                if(g.getGrille().get(val2-1).getType()==4){
	                                    g.getGrilleM().get(val).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2-1).getType()==2){
	                                    g.getGrilleM().get(val).setPlace(false);
	                                }
	                              }
	                         }
	                         //on regarde si la case voisine du joueur est libre
	                         if(g.getLibre(-1)){
	                             //on déplace le joueur
	                             g.getGrilleM().get(val).deplacerDe(-1,0);
	                             //on verifie si le joueur devient placé ou non placé
	                             if(g.getGrille().get(val2-1).getType()==4){
	                                 g.getGrilleM().get(val).setPlace(true);
	                             }
	                             if(g.getGrille().get(val2-1).getType()==2){
	                                 g.getGrilleM().get(val).setPlace(false);
	                             }
	                         }
	                        break;
	        case KeyEvent.VK_M : //on recupere la voisine du joueur s'il existe dans grilleM
	        				compteur +=1;
	                        val3=g.getVoisine(+1);
	                        //on regarde si la voisine du joueur est une caisse
	                        if(g.getCaisse(+1)){
	                            //on regarde si la voisine de la voisine du joueur est libre
	                            if(g.getLibre(+2)){
	                                //on déplace la caisse et le joueur
	                                g.getGrilleM().get(val3).deplacerDe(1,0);
	                                g.getGrilleM().get(val).deplacerDe(1,0);
	                                //on verifie si la caisse devient placé ou non placé
	                                if(g.getGrille().get(val2+2).getType()==4){
	                                    g.getGrilleM().get(val3).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2+2).getType()==2){
	                                    g.getGrilleM().get(val3).setPlace(false);
	                                }
	                                //on verifie si le joueur devient placé ou non placé
	                                if(g.getGrille().get(val2+1).getType()==4){
	                                    g.getGrilleM().get(val).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2+1).getType()==2){
	                                    g.getGrilleM().get(val).setPlace(false);
	                                }
	                            }
	                        }
	                        //on regarde si la case voisine du joueur est libre
	                        if(g.getLibre(+1)){
	                            //on déplace le joueur
	                            g.getGrilleM().get(val).deplacerDe(1,0);
	                            //on verifie si le joueur devient placé ou non placé
	                            if(g.getGrille().get(val2+1).getType()==4){
	                                g.getGrilleM().get(val).setPlace(true);
	                            }
	                            if(g.getGrille().get(val2+1).getType()==2){
	                                g.getGrilleM().get(val).setPlace(false);
	                            }
	                        }
	                        break;
	        case KeyEvent.VK_O ://on recupere la voisine du joueur s'il existe dans grilleM
	        				compteur +=1;
	                        val3=g.getVoisine(-20);
	                        //on regarde si la voisine du joueur est une caisse
	                       if(g.getCaisse(-20)){
	                           //on regarde si la voisine de la voisine du joueur est libre
	                           if(g.getLibre(-40)){
	                                //on déplace la caisse et le joueur
	                                g.getGrilleM().get(val3).deplacerDe(0,-1);
	                                g.getGrilleM().get(val).deplacerDe(0,-1);
	                                //on verifie si la caisse devient placé ou non placé
	                                if(g.getGrille().get(val2-40).getType()==4){
	                                    g.getGrilleM().get(val3).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2-40).getType()==2){
	                                    g.getGrilleM().get(val3).setPlace(false);
	                                }
	                                //on verifie si le joueur devient placé ou non placé
	                                if(g.getGrille().get(val2-20).getType()==4){
	                                    g.getGrilleM().get(val).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2-20).getType()==2){
	                                    g.getGrilleM().get(val).setPlace(false);
	                                }
	                            }
	                        }
	                       //on regarde si la case voisine du joueur est libre
	                        if(g.getLibre(-20)){
	                            //on déplace le joueur
	                            g.getGrilleM().get(val).deplacerDe(0,-1);
	                            //on verifie si le joueur devient placé ou non placé
	                            if(g.getGrille().get(val2-20).getType()==4){
	                                g.getGrilleM().get(val).setPlace(true);
	                            }
	                            if(g.getGrille().get(val2-20).getType()==2){
	                                g.getGrilleM().get(val).setPlace(false);
	                            }
	                        }
	                        break;
	        case KeyEvent.VK_L ://on recupere la voisine du joueur s'il existe dans grilleM
	        				compteur +=1;
	                        val3=g.getVoisine(+20);
	                        //on regarde si la voisine du joueur est une caisse
	                       if(g.getCaisse(+20)){
	                           //on regarde si la voisine de la voisine du joueur est libre
	                           if(g.getLibre(+40)){
	                                //on déplace la caisse et le joueur
	                                g.getGrilleM().get(val3).deplacerDe(0,1);
	                                g.getGrilleM().get(val).deplacerDe(0,1);
	                                //on verifie si la caisse devient placé ou non placé
	                                if(g.getGrille().get(val2+40).getType()==4){
	                                    g.getGrilleM().get(val3).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2+40).getType()==2){
	                                    g.getGrilleM().get(val3).setPlace(false);
	                                }
	                                //on verifie si le joueur devient placé ou non placé
	                                if(g.getGrille().get(val2+20).getType()==4){
	                                    g.getGrilleM().get(val).setPlace(true);
	                                }
	                                if(g.getGrille().get(val2+20).getType()==2){
	                                    g.getGrilleM().get(val).setPlace(false);
	                                }
	                            }
	                        }
	                       //on regarde si la case voisine du joueur est libre
	                        if(g.getLibre(+20)){
	                            //on déplace le joueur
	                            g.getGrilleM().get(val).deplacerDe(0,1);
	                            //on verifie si le joueur devient placé ou non placé
	                            if(g.getGrille().get(val2+20).getType()==4){
	                                g.getGrilleM().get(val).setPlace(true);
	                            }
	                            if(g.getGrille().get(val2+20).getType()==2){
	                                g.getGrilleM().get(val).setPlace(false);
	                            }
	                        }
	                        break;
	    }
	    //on redessine la grille
	    this.repaint();
	    // si toutes les caisses sont placées on affiche résultat
	    if (getEnCours()){
	        if(testerSiGagner()){
	            enCours=false;
	            estGagner();
	        }
	   }
	}

	public boolean testerSiGagner(){
	    int cpt=0;
	    // on calcule le nombre de caisses placées
	    for( int i=0;i<g.getDim();i++){
	        if(g.getGrilleM().get(i).getType()==5)
	            cpt+=1;
	    }
	    return (cpt==g.getDim()-1);
	}
	
	private void estGagner(){
		Resultat r = new Resultat(niv, this, compteur);
		r.setVisible(true);
	}

	boolean getEnCours(){
	    return enCours;
	}
	
	public void on_Restart_clicked(ActionEvent e) throws FileNotFoundException
	{
	    //on crré la grille de départ puis on la dessine
	    g=new Grille("Java-5A\\Niveau\\niveau"+String.valueOf(niv)+".txt");
	    this.repaint();
	}
}
