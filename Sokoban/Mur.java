package Sokoban;

import Sokoban.Immobile;

public class Mur extends Immobile{
	//attributs
    protected int largeur;
    protected int hauteur;
    
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
    }

    /*void Mur::dessiner(QPainter * p)const{
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
       p->drawPixmap(pt.getX()*30,pt.getY()*30+60,largeur,hauteur,QPixmap(":/Mur/PNG/Wall_Brown.png"));
    }*/

    public int getType(){
        return 1;
    }
}
