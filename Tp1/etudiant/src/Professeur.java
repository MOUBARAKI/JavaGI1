public class Professeur {
    private String nom;
    private int numSomme;
    private String email;
    private String grade;

    public Professeur() {
    }

    public Professeur(String nom, int numSomme, String email, String grade) {
        this.nom = nom;
        this.numSomme = numSomme;
        this.email = email;
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public int getNumSomme() {
        return numSomme;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumSomme(int numSomme) {
        this.numSomme = numSomme;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
