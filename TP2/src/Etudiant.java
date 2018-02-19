public class Etudiant extends Personne {

    private int numEtudiant;

    public Etudiant() {

    }

    public Etudiant(String nom, int numEtudiant, String email) {
       super(nom,email);
        this.numEtudiant = numEtudiant;

    }



    public int getNumEtudiant() {
        return numEtudiant;
    }





    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
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
