package Sokoban;

import Sokoban.Coordonnees;

public class Mobile {
	
	//attributs
	protected Coordonnees pt;
	
	//méthodes
	public Mobile(){
	    Coordonnees c = new Coordonnees();
	    pt=c;
	}

	public Mobile(int x, int y){
	    Coordonnees c= new Coordonnees(x,y);
	    pt=c;
	}

	public int getX(){
	    return pt.getX();
	}

	public int getY(){
	    return pt.getY();
	}

	public void deplacerDe(int dx, int dy){
	    pt.deplacerDe(dx,dy);
	}

}
