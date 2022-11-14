package Sokoban;

public class Coordonnees {
	//attributs
    private int x;
	private int y;
	
	//méthodes
	public Coordonnees()
	{
	    x=0;
	    y=0;
	}

	public Coordonnees(int x,int y){
	    this.x=x;
	    this.y=y;
	}
	public int getX(){
	    return x;
	}

	public int getY(){
	    return y;
	}

	public void deplacerDe(int dx, int dy){
	    x+=dx;
	    y+=dy;
	}
}
