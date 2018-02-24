/**
 * Cette classe represente  un Destroyeur
 *
 * @author Amine
 */
public class Destroyeur extends Bateau {
    /**
     * le constructeur par defaut de la classe Destroyeur
     */

    public Destroyeur() {
        super(2);
    }

    /**
     * la methode getSymbol
     *
     * @return "D" comme symbol d'un destroyeur
     */
    @Override
    public String getSymbol() {
        return ("D");
    }
}
