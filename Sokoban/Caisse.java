package Sokoban;

import Sokoban.Mobile;

public class Caisse extends Mobile{
	
	//attributs
    protected int largeur;
    protected int hauteur;
    protected boolean place;
    
    //méthodes
    public Caisse(){
    	super();
        largeur=0;
        hauteur=0;
        place=false;
    }

    public Caisse(int x, int y, int l, int h,boolean place){
    	super(x,y);
        this.largeur=l;
        this.hauteur=h;
        this.place=place;
    }

    /*void Caisse::dessiner(QPainter * p)const{
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
        if(place)
            p->drawPixmap(pt.getX()*30,pt.getY()*30+60,largeur,hauteur,QPixmap(":/Caisse/PNG/CrateDark_Black.png"));
        else
            p->drawPixmap(pt.getX()*30,pt.getY()*30+60,largeur,hauteur,QPixmap(":/Caisse/PNG/Crate_Gray.png"));
    }*/

    public int getType(){
        if(!place)
            return 3;
        else
            return 5;
    }

    public void setPlace(boolean pl){
        if(pl==true)
            place=true;
        else
            place=false;
    }
}
