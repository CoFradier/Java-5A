package Sokoban;

import java.util.HashMap;

public class Grille {
	//attribus
    private HashMap<Coordonnees,Immobile>grille;
    private HashMap<Coordonnees,Mobile>grilleM;
    private int dim;
    private int hauteur;
    private int largeur;
    
    //méthodes
    public Grille(){
        // nous avons décider de creer ce constructeur par defaut avec que des cases néant et le joueur en haut à gauche
        hauteur=18;
        largeur=20;
        dim=1;
        // remplit la grille d'immobile de case néant
        for(int j=0;j<hauteur;j++){
            for(int i=0;i<largeur;i++){
                grille.put(new Coordonnees(i,j), new Neant(i,j,30,30));
            }
        }
        // remplit la grille de mobile avec le joueur en haut à gauche
        grilleM.push_back(new Joueur(0,0,30,30,false));
    }

    Grille::Grille(QString nomLevel){
        // on utilise QFile pour ouvrir le fichier
        QFile fichier(nomLevel);
        int mot;
        if(fichier.open(QIODevice::ReadOnly | QIODevice::Text)){
            QTextStream flux(&fichier);
            // on recupére hauteur,largeur et la dimension de la grille de mobile
            flux>>hauteur;
            flux>>largeur;
            flux>>dim;
            // on remplit les grille d'immobile et de mobile en fonction du type
            for(int j=0;j<hauteur;j++){
                for(int i=0;i<largeur;i++){
                    flux>>mot;
                    switch(mot){
                        case 1 : grille.push_back(new Mur(i,j,30,30));
                                break;
                        case 2 : grille.push_back(new Case_vide(i,j,30,30,false));
                                break;
                        case 3 : grille.push_back(new Case_vide(i,j,30,30,false));
                                 grilleM.push_back(new Caisse(i,j,30,30,false));
                                break;
                        case 4 : grille.push_back(new Case_vide(i,j,30,30,true));
                                break;
                        case 5 : grille.push_back(new Case_vide(i,j,30,30,true));
                                grilleM.push_back(new Caisse(i,j,30,30,true));
                                break;
                        case 6 : grille.push_back(new Case_vide(i,j,30,30,false));
                                 grilleM.push_back(new Joueur(i,j,30,30,false));
                                break;
                        case 0 : grille.push_back(new Neant(i,j,30,30));
                                break;
                    }
                }
            }
            fichier.close();
         }
         else{
                    cerr<<"impossible d'ouvrir le fichier";
         }
    }

    Grille::~Grille(){
        grille.clear();
        grilleM.clear();
    }

    void Grille::dessiner(QPainter * p) const{
        // dessine la grille d'immobile
        for(int i=0;i<hauteur*largeur;i++){
            grille[i]->dessiner(p);
        }
        //met par dessus la grille d'immobile les élèments mobiles au bon endroit
        for(int i=0;i<dim;i++){
            grilleM[i]->dessiner(p);
        }
    }

    int Grille:: getDim() const{
        return dim;
    }

    int Grille::getHauteur()const{
        return hauteur;
    }
    int Grille::getLargeur()const{
        return largeur;
    }
    vector<Immobile*> Grille::getGrille()const{
        return grille;
    }
    vector<Mobile*> Grille::getGrilleM()const{
        return grilleM;
    }

    int Grille ::getJoueurGrilleM() const{
        int val=0;
        //val permet de récupérer la position du joueur dans la grille de mobile
        for(int i=0;i<dim;i++){
            if(grilleM[i]->getType()==6){
                val=i;
           }
        }
        return val;
    }

    int Grille::getJoueurGrille() const{
        int val=getJoueurGrilleM(),val2=0;

        //grâce à val on met dans jx et jy les coordonnees correspondantes du joueur
        int jx=grilleM[val]->getX();
        int jy=grilleM[val]->getY();
        // on récupére ensuite dans val2 la position du joueur dans la grille d'immobile
        for(int i=0;i<hauteur*largeur;i++){
            if((grille[i]->getX()==jx) && (grille[i]->getY()==jy)){
                val2=i;
           }
        }
        return val2;
    }

    int Grille::getVoisine(int dir) const{
        int val2=getJoueurGrille(),val3=-1;

        // on récupére dans val3 s'il y a une caisse en dir du joueur sa position sinon val3=-1
        for(int i=0;i<dim;i++){
            if((grille[val2+dir]->getX()==grilleM[i]->getX()) && (grille[val2+dir]->getY()==grilleM[i]->getY())){
                val3=i;
             }
       }
       return val3;
    }

    bool Grille::getLibre(int dir) const{
        int val2=getJoueurGrille(),val3=getVoisine(dir);

        // on verifie que la case en dir à coté du joueur n'est pas un mur ou une caisse
         if(!(grille[val2+dir]->getType()==1) && !((val3!=-1) && (grilleM[val3]->getType()==3 || grilleM[val3]->getType()==5)))
            return true;
            else
                return false;
    }

    bool Grille::getCaisse(int dir) const{
        int val3=getVoisine(dir);

        // on verifie que val3 est bien une caisse
         if((val3!=-1) && (grilleM[val3]->getType()==3 || grilleM[val3]->getType()==5))
             return true;
         else
             return false;
    }

}
