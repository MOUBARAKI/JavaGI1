import java.util.ArrayList;

public class Departement implements Collection{
    private String nom;
    private Professeur chefDepartement;
    private ArrayList<Personne> personnes;

    public Departement() {
        this.personnes = new ArrayList();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Professeur getChefDepartement() {
        return chefDepartement;
    }

    public void setChefDepartement(Professeur chefDepartement) {
        this.chefDepartement = chefDepartement;
    }

    public Float sommeSalaire() {
        Float somme = Float.valueOf(0);
        for (Personne personne : personnes) {
            if (personne instanceof Professeur)
                somme += ((Professeur) personne).calculSalaire();
            else somme += ((Doctorant) personne).calculSalaire();
        }
        return somme;
    }

    public Boolean addObject(Object o, int i) {
        return true;
    }

    public Boolean removeObject(Object o, int i) {
        return true;
    }

    public Object getObject(int i) {
        return null;
    }

}
