package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Joueur extends Mobile{
	
	//attributs
	protected int largeur;
	protected int hauteur;
	protected boolean place;
	protected ImageIcon j1;
	protected ImageIcon j2;
	
	public Joueur(){}

	public Joueur(int x, int y,int largeur, int hauteur,boolean place){
		super(x,y);
	    this.hauteur=hauteur;
	    this.largeur=largeur;
	    this.place=place;
	    j1 = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\Character4.png");
	    j2 = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\Character11.png");
	    
	}
	
	
	public void dessiner(Graphics g){
	    //on place au bond endroit les x et y dans la grille avec les pixels
	    //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
	   if(place==false)
	       g.drawImage(j1.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
	   else
	       g.drawImage(j2.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
	}

	public int getType(){
	    return 6;
	}

	public void setPlace(boolean pl){
	    if(pl==true)
	        place=true;
	    else
	        place=false;

	}
	
	

}
