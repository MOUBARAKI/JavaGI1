public class Etudiant extends Personne implements Collection {

    private int numEtudiant;
    private Module module[];

    public Etudiant() {

    }

    public Etudiant(String nom, int numEtudiant, String email) {
        super(nom, email);
        this.module = new Module[6];
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
