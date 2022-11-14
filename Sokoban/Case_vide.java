package Sokoban;

import Sokoban.Immobile;

public class Case_vide extends Immobile{
	
	//atributs
    protected int largeur;
    protected int hauteur;
    protected boolean marque;
    
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
    }

    /*void Case_vide::dessiner(QPainter * p)const{
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
        if(!marque)
            p->drawPixmap(pt.getX()*30,pt.getY()*30+60,largeur,hauteur,QPixmap(":/Case_vide/PNG/GroundGravel_Sand.png"));
        else{
            p->drawPixmap(pt.getX()*30,pt.getY()*30+60,largeur,hauteur,QPixmap(":/Case_vide/PNG/GroundGravel_Sand.png"));
            p->drawPixmap(pt.getX()*30+largeur/4,(pt.getY()*30+60)+hauteur/4,largeur/2,hauteur/2,QPixmap(":/Marque/PNG/EndPoint_Red.png"));
           }
    }*/

    public int getType(){
        if(!marque)
            return 2;
        else
            return 4;
    }
}

