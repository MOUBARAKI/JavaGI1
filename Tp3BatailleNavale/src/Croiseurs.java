/**
 * Cette classe represente  un Croiseur
 *
 * @author Amine
 */
public class Croiseurs extends Bateau {
    /**
     * le constructeur par defaut de la classe croiseur
     */
    public Croiseurs() {
        super(3);
    }

    /**
     * la methode getSymbol
     *
     * @return "C" comme symbol d'un croiseur
     */
    @Override
    public String getSymbol() {
        return ("C");
    }
}
