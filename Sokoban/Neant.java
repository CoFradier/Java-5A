package Sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Sokoban.Immobile;

public class Neant extends Immobile{
	
	//attributs
    protected int largeur;
    protected int hauteur;
    
    //méthodes
    public Neant(){
    	super();
        largeur=0;
        hauteur=0;
    }

    public Neant(int x, int y, int l, int h){
        super(x,y);
    	this.largeur=l;
        this.hauteur=h;
    }

    public void dessiner(Graphics g){
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
    	g.setColor(Color.BLACK);
        g.fillRect(pt.getX()*30,pt.getY()*30+60,largeur,hauteur);
       
    }

    public int getType(){
        return 0;
    }
}
