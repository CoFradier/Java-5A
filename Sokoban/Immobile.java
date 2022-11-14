package Sokoban;

import Sokoban.Coordonnees;

public class Immobile {
	
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

	private int getY(){
	    return pt.getY();
	}
}
