/**
 * Cette classe represente la Grille de bataille
 * Chaque joueur à sa  Grille personnelle
 *
 * @author Amine
 */
public class Grille {
    /**
     * La grille est composé de 100 cases
     */
    private Case[][] grille;
    public int NB_LIGNES = 10;
    public int NB_COLONNES = 10;


    /**
     * Le constructeur par defaut de la classe Grille
     */
    public Grille() {
        grille = new Case[NB_LIGNES][NB_COLONNES];
        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                grille[i][j] = new Case(false);
            }
        }
    }

    /**
     * La methode afficheTirs qui affiche dans le terminal le caractère 'o' pour toutes cases
     * ayant fait l'objet d'un tir et ' ' pour les autres cases
     */
    public void afficheTirs() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                String s = "";
                if (grille[i][j].isState())
                    s = "o";
                else
                    s = "~";
                System.out.print(s);


            }
            System.out.println();
        }
    }

    /**
     * la methode tir affect à une case (x,y) la valeur  vrai
     *
     * @param x le cordonné x de la case
     * @param y le cordonné y de la case
     */
    public void tir(int x, int y) throws TirCaseInexistante {
        if (x > NB_LIGNES || y > NB_COLONNES) throw new TirCaseInexistante();
        grille[x][y].setState(true);
    }

    /**
     * la methode getGrille
     *
     * @return la grille de l'objet
     */

    public Case[][] getGrille() {
        return grille;
    }

    /**
     * la Setter de la grille
     *
     * @param grille la grille qu'on souhaite saisir
     */

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    /**
     * la methode place pour définir les cases necessaire pour un bateau
     *
     * @param bateau le bateau qu'on veut deplacer
     * @param posx   cordonnee x du nouveau emplacement du bateau
     * @param posy   cordonnee y du nouveau emplacement du bateau
     */

    public int place(Bateau bateau, int posx, int posy) throws DebordementPlaceBateau {
        int error = 0;
        int checkpointh = 0;
        int checkpointv = 0;
        int intersection = 0;
        Boolean horizontal = bateau.horizontal;
        if (horizontal && (posx + bateau.getTaille()) < this.getGrille().length) {

            for (int i = 0; i < bateau.getTaille(); i++) {

                if (this.getGrille()[posx + i][posy].isOccupe() == false) {
                    try {
                        bateau.ajouteCase(this.getGrille()[posx + i][posy]);
                        this.getGrille()[posx + i][posy].setOccupe(true);
                    } catch (Bateau.ToutesCasesAffecteesException ex) {
                        System.out.println("Erreur : Vous avez essaye d'affecter trop de cases");
                    }

                } else {
                    System.out.println("intersection !");
                    intersection = 1;
                    error = 1;
                    checkpointh = i;
                    break;

                }
            }
        } else if (!horizontal && (posx + bateau.getTaille()) < this.getGrille()[posx].length) {
            for (int i = 0; i < bateau.getTaille(); i++) {

                if (this.getGrille()[posx][posy + i].isOccupe() == false) {
                    try {
                        bateau.ajouteCase(this.getGrille()[posx][posy + i]);
                        this.getGrille()[posx][posy + i].setOccupe(true);
                    } catch (Bateau.ToutesCasesAffecteesException ex) {
                        System.out.println("Erreur : Vous avez essaye d'affecter trop de cases");
                    }
                } else {
                    System.out.println("intersection !");
                    intersection = 2;
                    error = 1;
                    checkpointv = i;
                    break;
                }
            }
        } else {
            error = 1;
            throw new DebordementPlaceBateau();
        }
        if (intersection == 1) {
            System.out.println("fixing intersection");
            for (int i = 0; i < checkpointh; i++) {
                this.getGrille()[posx + i][posy].setOccupe(false);
            }

        } else if (intersection == 2) {
            System.out.println("fixing intersection");

            for (int i = 0; i < checkpointv; i++) {
                this.getGrille()[posx][posy + i].setOccupe(false);
            }

        }


        return error;
    }


    /**
     * la methode affiche pour afficher une grille
     */

    public void affiche() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                String s = "";
                if (grille[i][j].isState())
                    s = "o";
                else {
                    if (grille[i][j].getBateau() == null) s = " ";
                    else {
                        s = grille[i][j].getBateau().getSymbol();
                    }
                }
                System.out.print(s);


            }
            System.out.println();
        }
    }

    /**
     * Une exception indiquant que le tir a été effectue sur une case inexistante
     *
     * @author MOUBARAKI Amine
     */
    public class TirCaseInexistante extends Exception {

        /**
         * Un constructeur
         */
        public TirCaseInexistante() {
            super("cette case n'existe pas!");
        }
    }
    /**
     * Une exception indiquant un debordement lors du placement d'un bateau
     *
     * @author MOUBARAKI Amine
     */

    public class DebordementPlaceBateau extends Exception {

        /**
         * Un constructeur
         */
        public DebordementPlaceBateau() {
            super("Debordement de grille lors du placement !");
        }
    }
    /**
     * Une exception indiquant un chevauchement lors du placement d'un bateau
     *
     * @author MOUBARAKI Amine
     */

    public class ChevauchementPlaceBateau extends Exception {

        /**
         * Un constructeur
         */
        public ChevauchementPlaceBateau() {
            super("Chevauchement  lors du placement !");
        }
    }
}
