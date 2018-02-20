/**
 * Cette classe represente  une case contenue de la grille du bataille
 *
 * @author Amine
 */
public class Case {
    /**
     * L'état d'une case prend la valeur true si elle a fait l'objet d'un tir et false sinon
     */
    private boolean etat;
    private Bateau bateau;


    /**
     * Le constructeur par defaut de la classe Case
     * oû l'état est fausse
     */
    public Case() {
        this.etat = false;
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
    public void setBateau(Bateau bateau)
    {this.bateau=bateau;}

}
