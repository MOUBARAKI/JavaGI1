abstract class Personne {
    public String nom;
    public String email;

    public Personne() {
    }

    public Personne(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {

        return email;
    }

    public String getNom() {

        return nom;
    }
}
