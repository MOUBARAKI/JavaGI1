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
    private String nom;
    private Grille grille;
    private ArrayList<Bateau> bateaux;

    /**
     * Le constructeur par defaut de la classe Joueur
     *
     * @param nom le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille();
    }

    /**
     * Getter de l'attribut nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut grille
     */
    public Grille getGrille() {
        return grille;
    }

    public void placementBateaux() {
        for (Bateau bateau : this.bateaux
                ) {
            Scanner scan = new Scanner(System.in);
            System.out.println("donner l'orientation H ou V");
            if (scan.nextLine().equals("H"))
                bateau.horizontal = true;
            else bateau.horizontal = false;

            System.out.println("donner posx");
            int posx = scan.nextInt();
            System.out.println("donner posy");
            int posy = scan.nextInt();
            this.grille.place(bateau, posx, posy);

        }
    }

    public Boolean aPerdu() {
        for (Bateau bateau : this.bateaux
                ) {
            if (!bateau.estCoule())
                return false;



        }
        return  true;
    }


}
