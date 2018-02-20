
public class Professeur extends Personne implements Salarie,Collection {
    private int numSomme;
    private String grade;
    private Module module[];

    public Professeur() {
    }

    public Professeur(String nom, int numSomme, String email, String grade) {

        super(nom, email);
        this.module = new Module[4];
        this.numSomme = numSomme;

        this.grade = grade;
    }

    public Module[] getModule() {
        return module;
    }

    public void setModule(Module[] module) {
        this.module = module;
    }

    public int getNumSomme() {
        return numSomme;
    }


    public String getGrade() {
        return grade;
    }


    public void setNumSomme(int numSomme) {
        this.numSomme = numSomme;
    }


    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "nom='" + nom + '\'' +
                ", numSomme=" + numSomme +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Float calculSalaire(Integer nbrHeures) {

        if (nbrHeures < 32) return Float.valueOf(400 * nbrHeures * (1 - (34 / 100)) + 5000);
        else return Float.valueOf((((nbrHeures - 32) * 600) * (1 - (34 / 100)) + (32 * 400) * (1 - (17 / 100))) + 5000);
    }

    public Float calculSalaire() {
        Integer nbrHeures = 0;
        for (int i = 0; i < module.length; i++)
            nbrHeures += this.module[i].getNbrHeure();
        return calculSalaire(nbrHeures);

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

    @Override
    public Float calculVacances(Integer nbrJours) {
        return Float.valueOf(nbrJours / 10);
    }

}
