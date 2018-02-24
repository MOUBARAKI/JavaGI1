import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe represente le joueur de la bataille
 *
 * @author Amine
 */
public class Joueur {
    /**
     * Le joueur est définie par son nom
     * et une grille
     */
    public String nom;
    private Grille grille;
    protected ArrayList<Bateau> bateaux = new ArrayList<Bateau>();
    ;
    public int NB_CROISEURS = 1;
    public int NB_DESTROYEURS = 1;
    public int NB_PORTEAVIONS = 1;

    /**
     * Le constructeur par defaut de la classe Joueur
     *
     * @param nom le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille();
        for (int i = 0; i < NB_PORTEAVIONS; i++) {
            PorteAvions porteAvion = new PorteAvions();
            this.bateaux.add(porteAvion);
        }
        for (int i = 0; i < NB_CROISEURS; i++) {
            Croiseurs croiseur = new Croiseurs();
            this.bateaux.add(croiseur);
        }
        for (int i = 0; i < NB_DESTROYEURS; i++) {
            Destroyeur destroyeur = new Destroyeur();
            this.bateaux.add(destroyeur);
        }

    }

    /**
     * Getter de l'attribut nom
     *
     * @return nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut grille
     *
     * @return grille du joueur
     */
    public Grille getGrille() {
        return grille;
    }

    /**
     * la methode placeBateaux qui deplace un bateau
     *
     * @param posx       cordonnee x du nouveau emplacement du bateau
     * @param posy       cordonnee y du nouveau emplacement du bateau
     * @param horizontal l'orientation du bateau true pour horizontal et false pour vertical
     * @param bateau     le bateau qu'on veut deplacer
     */


    public void placeBateaux(int posx, int posy, Boolean horizontal, Bateau bateau) {


        if (horizontal)
            bateau.horizontal = true;
        else
            bateau.horizontal = false;


        this.grille.place(bateau, posx, posy);

    }

    /**
     * la methode placementBateaux  utilise la methode palaceBateaux
     * cette methode est dedié a un joueur oridinaire car elle utilise Scanner
     */

    public void placementBateaux() {
        for (Bateau bateau : this.bateaux
                ) {
            Scanner scan = new Scanner(System.in);

            System.out.println("donner posx");
            int posx = scan.nextInt();
            System.out.println("donner posy");
            int posy = scan.nextInt();
            System.out.println("donner l'orientation");
            int horizontal = scan.nextInt();
            Boolean horizontale;
            if (horizontal == 1) {
                horizontale = true;
            } else {
                horizontale = false;
            }

            placeBateaux(posx, posy, horizontale, bateau);
        }
    }

    /**
     * la methode aPerdu
     *
     * @return une valeur vrai si le joueur a perdu
     */

    public Boolean aPerdu() {
        for (Bateau bateau : this.bateaux
                ) {
            if (!bateau.estCoule())
                return false;


        }
        return true;
    }

    /**
     * la methode tir qui utilise la methode tir pour attaquer l'adversaire
     * cette methode est dedié a un joueur oridinaire car elle utilise Scanner
     */
    public void tir(Grille grilleAdversaire) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        grilleAdversaire.tir(x, y);

    }


}
