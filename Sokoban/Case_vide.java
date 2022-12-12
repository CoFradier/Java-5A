package Sokoban;

import java.awt.Graphics;


import javax.swing.ImageIcon;

import Sokoban.Immobile;

public class Case_vide extends Immobile{
	
	//atributs
    protected int largeur;
    protected int hauteur;
    protected boolean marque;
    protected ImageIcon cv;
    protected ImageIcon p;
    
    //méthodes
    public Case_vide(){
    	super();
        largeur=0;
        hauteur=0;
        marque=false;
    }

    public Case_vide(int x, int y, int l, int h, boolean marq){
        super(x,y);
    	this.largeur=l;
        this.hauteur=h;
        this.marque=marq;
        cv = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\GroundGravel_Sand.png");
        p = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\EndPoint_Red.png");
    }

    public void dessiner(Graphics g){
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
        if(!marque)
            g.drawImage(cv.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
        else{
            g.drawImage(cv.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
            g.drawImage(p.getImage(),pt.getX()*30+largeur/4,(pt.getY()*30+60)+hauteur/4,largeur/2,hauteur/2,null);
           }
    }

    public int getType(){
        if(!marque)
            return 2;
        else
            return 4;
    }
}

