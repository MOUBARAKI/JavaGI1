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

    /**
     * Le constructeur par defaut de la classe Grille
     */
    public Grille() {
        grille = new Case[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case();
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
                    s = " ";
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
    public void tir (int x, int y) {
        grille[x][y].setState(true);
    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public void place(Bateau bateau, int posx, int posy) {
        Boolean horizontal = bateau.horizontal;
        if (horizontal && posx + bateau.getTaille() < this.getGrille().length) {
            for (int i = 0; i < bateau.getTaille(); i++) {
                if (bateau.getCases() != null)
                    bateau.removeCase(bateau.getCases().get(i));

                bateau.ajouteCase(this.getGrille()[posx + i][posy]);
            }
        } else if (!horizontal && posx + bateau.getTaille() < this.getGrille()[posx].length) {
            for (int i = 0; i < bateau.getTaille(); i++) {
                if (bateau.getCases() != null)
                    bateau.removeCase(bateau.getCases().get(i));
                bateau.ajouteCase(this.getGrille()[posx][posy + i]);
            }
        }


    }
}
