import java.util.Random;

/**
 * Cette classe represente  un Joueur robot (oridinateur)
 *
 * @author Amine
 */
public class JoueurOrdi extends Joueur {
    /**
     * le constructeur par defaut de la classe Destroyeur
     */
    public JoueurOrdi() {
        super("Ordinateur");
    }

    /**
     * la methode placementBateaux  utilise la methode palaceBateaux
     * cette methode est dedié a un joueur robot car elle utilise Random
     */
    @Override
    public void placementBateaux() {
        Random random = new Random();
        int error=0;
        for (Bateau bateau : this.bateaux)
            do{
            error=super.placeBateaux(random.nextInt(9), random.nextInt(9), random.nextBoolean(), bateau);
    }while(error==1);}

    /**
     * la methode tir qui utilise la methode tir pour attaquer l'adversaire
     * cette methode est dedié a un joueur robot car elle utilise Random
     */
    @Override
    public void tir(Grille grilleAdversaire) {
        Random random = new Random();
        int x = random.nextInt(9);
        int y = random.nextInt(9);
        grilleAdversaire.tir(x, y);
    }
}
