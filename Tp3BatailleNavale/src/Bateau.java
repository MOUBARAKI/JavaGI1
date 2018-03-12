import java.util.ArrayList;
import java.util.HashSet;


/**
 * Cette classe abstraite represente  un bateau
 *
 * @author Amine
 */
abstract public class Bateau {
    /**
     * Chaque bateau a une taille , un nombre de cases et une orientation true si horizontal false si vertical
     */
    private int taille;
    private HashSet<Case> cases;
    public Boolean horizontal;

    /**
     * Constructeur de la classe Bateau
     */
    public Bateau(int taille) {
        this.taille = taille;
        this.cases = new HashSet<Case>();


    }

    /**
     * la methode estCoule qui informe sur l'etat d'un bateau si ecoulé
     *
     * @return true si le bateau est ecoulé
     */
    public Boolean estCoule() {
        Boolean ecoule = false;
        for (Case box : cases) {
            if (!box.isState())
                ecoule = box.isState();
        }
        return ecoule;
    }
    /**
     * Ajoute une case a l'ensemble des cases occupees par le bateau
     *
     * @param c La case a ajouter
     * @exception ToutesCasesAffecteesException si toutes les cases du bateau on ete assignee
     */
    public void ajouteCase(Case c) throws ToutesCasesAffecteesException {
        if (cases.size() == taille) throw new ToutesCasesAffecteesException();
        c.setBateau(this);
        cases.add(c);
    }



    /**
     * la methode removeCase qui supprime une case de la liste des cases occupée par le bateau
     */
    public void removeCase(Case c) {
        c.setBateau(null);
        cases.remove(c);
    }

    /**
     * le getter de la taile d'un bateau
     *
     * @return la taille du bateau
     */
    public int getTaille() {
        return taille;
    }

    /**
     * le setter de la taille d'un bateau
     *
     * @param taille
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    public HashSet<Case> getCases() {
        return cases;
    }

    public void setCases(HashSet<Case> cases) {
        this.cases = cases;
    }

    public Boolean getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * declaration de la methode abstraite getSymbol qui sera utilisée pour retourner le symbol de chaque type de bateau
     */
    abstract public String getSymbol();
    /**
     * Une exception indiquant que toutes les cases d'un bateau ont ete affectees
     *
     * @author HAFIDI IMAD
     */
    public class ToutesCasesAffecteesException extends Exception {

        /**
         * Un constructeur
         */
        public ToutesCasesAffecteesException() {
            super("Toutes les cases du bateau ont deja ete affectees");
        }
    }


}
