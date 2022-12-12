package Sokoban;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grille {
	//attribus
	private List<Immobile> grille;
	private List<Mobile> grilleM;
    private int dim;
    private int hauteur;
    private int largeur;
    private File file;
    private List<Integer> entiers;
    private Scanner scan;
    
    //méthodes
    public Grille(){
        // nous avons décider de creer ce constructeur par defaut avec que des cases néant et le joueur en haut à gauche
        hauteur=18;
        largeur=20;
        dim=1;
        grille = new ArrayList<Immobile>();
        grilleM = new ArrayList<Mobile>();
        // remplit la grille d'immobile de case néant
        for(int j=0;j<hauteur;j++){
            for(int i=0;i<largeur;i++){
                grille.add(new Neant(i,j,30,30));
            }
        }
        // remplit la grille de mobile avec le joueur en haut à gauche
        grilleM.add(new Joueur(0,0,30,30,false));
    }

    public Grille(String nomLevel) throws FileNotFoundException{
	    entiers = new ArrayList<Integer>();
	    // on utilise File et Scan pour lire le fichier
	    try (Scanner scan = new Scanner(new File(nomLevel))) {
		    while (scan.hasNextInt()){
		     entiers.add(scan.nextInt());
		    }
		    // on recupére hauteur,largeur et la dimension de la grille de mobile
		    hauteur = entiers.get(0);
		    largeur = entiers.get(1);
		    dim = entiers.get(2);
		    // on remplit les grille d'immobile et de mobile en fonction du type
		    grille = new ArrayList<Immobile>();
		    grilleM = new ArrayList<Mobile>();
		    int cpt = 3;
		    int mot;
		    for(int j=0;j<hauteur;j++){
		        for(int i=0;i<largeur;i++){
		            mot = entiers.get(cpt);
		            cpt += 1;
		            switch(mot){
		                case 1 : grille.add(new Mur(i,j,30,30));
		                        break;
		                case 2 : grille.add(new Case_vide(i,j,30,30,false));
		                        break;
		                case 3 : grille.add(new Case_vide(i,j,30,30,false));
		                         grilleM.add(new Caisse(i,j,30,30,false));
		                        break;
		                case 4 : grille.add(new Case_vide(i,j,30,30,true));
		                        break;
		                case 5 : grille.add(new Case_vide(i,j,30,30,true));
		                        grilleM.add(new Caisse(i,j,30,30,true));
		                        break;
		                case 6 : grille.add(new Case_vide(i,j,30,30,false));
		                         grilleM.add(new Joueur(i,j,30,30,false));
		                        break;
		                case 0 : grille.add(new Neant(i,j,30,30));
		                        break;
		            }
		        }
		    }
	    }
    }

    public void dessiner(Graphics g){
        // dessine la grille d'immobile
        for(int i=0;i<hauteur*largeur;i++){
            grille.get(i).dessiner(g);
        }
        //met par dessus la grille d'immobile les élèments mobiles au bon endroit
        for(int i=0;i<dim;i++){
            grilleM.get(i).dessiner(g);
        }
    }

    public int getDim(){
        return dim;
    }

    public int getHauteur(){
        return hauteur;
    }
    public int getLargeur(){
        return largeur;
    }
    public List<Immobile> getGrille(){
        return grille;
    }
    public List<Mobile> getGrilleM(){
        return grilleM;
    }

    public int getJoueurGrilleM(){
        int val=0;
        //val permet de récupérer la position du joueur dans la grille de mobile
        for(int i=0;i<dim;i++){
            if(grilleM.get(i).getType()==6){
                val=i;
           }
        }
        return val;
    }

    public int getJoueurGrille(){
        int val=getJoueurGrilleM(),val2=0;

        //grâce à val on met dans jx et jy les coordonnees correspondantes du joueur
        int jx=grilleM.get(val).getX();
        int jy=grilleM.get(val).getY();
        // on récupére ensuite dans val2 la position du joueur dans la grille d'immobile
        for(int i=0;i<hauteur*largeur;i++){
            if((grille.get(i).getX()==jx) && (grille.get(i).getY()==jy)){
                val2=i;
           }
        }
        return val2;
    }

    public int getVoisine(int dir){
        int val2=getJoueurGrille(),val3=-1;

        // on récupére dans val3 s'il y a une caisse en dir du joueur sa position sinon val3=-1
        for(int i=0;i<dim;i++){
            if((grille.get(val2+dir).getX()==grilleM.get(i).getX()) && (grille.get(val2+dir).getY()==grilleM.get(i).getY())){
                val3=i;
             }
       }
       return val3;
    }

    boolean getLibre(int dir){
        int val2=getJoueurGrille(),val3=getVoisine(dir);

        // on verifie que la case en dir à coté du joueur n'est pas un mur ou une caisse
         if(!(grille.get(val2+dir).getType()==1) && !((val3!=-1) && (grilleM.get(val3).getType()==3 || grilleM.get(val3).getType()==5)))
            return true;
            else
                return false;
    }

    boolean getCaisse(int dir){
        int val3=getVoisine(dir);

        // on verifie que val3 est bien une caisse
         if((val3!=-1) && (grilleM.get(val3).getType()==3 || grilleM.get(val3).getType()==5))
             return true;
         else
             return false;
    }

}
