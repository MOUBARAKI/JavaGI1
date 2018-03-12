/**
 * Cette classe represente  un porteAvion
 *
 * @author Amine
 */

public class PorteAvions extends Bateau {
    /**
     * le constructeur par defaut de la classe PorteAvion
     */

    public PorteAvions() {
        super(4);
    }

    /**
     * la methode getSymbol
     *
     * @return "P" comme symbol d'un porte_avions
     */
    @Override
    public String getSymbol() {
        return ("P");
    }
}
