/**
 * Cette classe represente  une case contenue dans la grille du bataille
 *
 * @author Amine
 */
public class Case {
    /**
     * L'état d'une case prend la valeur true si elle a fait l'objet d'un tir et false sinon
     */
    public boolean etat;
    private Bateau bateau;
    private boolean occupe;


    /**
     * Le constructeur par defaut de la classe Case
     * oû l'état est fausse
     */
    public Case() {
        this.etat = false;
        this.occupe=false;
    }

    /**
     * Le 2 eme constructeur de la classe Case
     * dont l'état est fausse ou vrai
     *
     * @param etat l'état de la case
     */
    public Case(boolean etat) {
        this.etat = etat;
    }

    /**
     * methode qui renvoie l'état de la case
     */
    public boolean isState() {
        return etat;
    }

    /**
     * methode qui définie l'état de la case
     */
    public void setState(boolean etat) {
        this.etat = etat;
    }

    /**
     * la methode qui affecte un bateau a une case
     */
    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    /**
     * la methode getBateau
     *
     * @return le bateau qui occupe la case
     */

    public Bateau getBateau() {
        return bateau;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public boolean isOccupe() {
        return occupe;
    }
}
