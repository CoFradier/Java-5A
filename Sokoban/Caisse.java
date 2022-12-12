package Sokoban;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import Sokoban.Mobile;

public class Caisse extends Mobile{
	
	//attributs
    protected int largeur;
    protected int hauteur;
    protected boolean place;
    protected ImageIcon c1;
    protected ImageIcon c2;
    
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
        c1 = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\CrateDark_Black.png");
        c2 = new ImageIcon("C:\\Users\\28070\\eclipse-workspace\\Sokoban\\PNG\\Crate_Gray.png");
    }

    public void dessiner(Graphics g){
        //on place au bond endroit les x et y dans la grille avec les pixels
        //on multiplie x par 30 et pareil pour y puis on ajoute 60 parce qu'on laisse une marge en haut
        if(place)
            g.drawImage(c1.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
        else
            g.drawImage(c2.getImage(),pt.getX()*30,pt.getY()*30+60,largeur,hauteur,null);
    }

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
