package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import Sokoban.Immobile;

public class Mur extends Immobile{
	//attributs
    protected int largeur;
    protected int hauteur;
    protected ImageIcon m;
    
    //méthodes
    public Mur(){
    	super();
        largeur=0;
        hauteur=0;
    }

    public Mur(int x, int y, int l, int h){
    	super(x,y);
        this.largeur=l;
        this.hauteur=h;
        m = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\Wall_Brown.png");
    }

    public void dessiner(Graphics g){
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
       g.drawImage(m.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
    }

    public int getType(){
        return 1;
    }
}
