public class Etudiant {
    private String nom;
    private int numEtudiant;
    private String email;

    public Etudiant() {

    }

    public Etudiant(String nom, int numEtudiant, String email) {
        this.nom = nom;
        this.numEtudiant = numEtudiant;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", numEtudiant=" + numEtudiant +
                ", email='" + email + '\'' +
                '}';
    }
}
