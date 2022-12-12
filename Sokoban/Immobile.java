package Sokoban;

import java.awt.Graphics;

import Sokoban.Coordonnees;

public abstract class Immobile {
	
	//attributs
	protected Coordonnees pt;
	
	//méthodes
	public Immobile(){
	    Coordonnees c = new Coordonnees();
	    pt=c;
	}

	public Immobile(int x, int y){
	    Coordonnees c = new Coordonnees(x,y);
	    pt=c;
	}

	public int getX(){
	    return pt.getX();
	}

	public int getY(){
	    return pt.getY();
	}
	
	public  abstract  void dessiner(Graphics g);
	
	public  abstract  int getType();
}
