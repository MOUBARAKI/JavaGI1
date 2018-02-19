
public class Professeur extends Personne implements Salarie{
    private int numSomme;
    private String grade;

    public Professeur() {
    }

    public Professeur(String nom, int numSomme, String email, String grade) {
       super(nom,email);
        this.numSomme = numSomme;

        this.grade = grade;
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
        if (nbrHeures < 32) return Float.valueOf(400 * nbrHeures * (1 - (34 / 100))+5000);
        else return Float.valueOf((((nbrHeures - 32) * 600) * (1 - (34 / 100)) + (32 * 400) * (1 - (17 / 100)))+5000);
    }

    @Override
    public Float calculVacances(Integer nbrJours) {
        return Float.valueOf(nbrJours / 10);
    }

}
