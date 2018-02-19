public class Module {
    private String libelle;
    private int coefficient;
    private int nbrHeure;
    private Professeur professeur;

    public Module() {
    }

    public Module(String libelle, int coefficient, int nbrHeure, Professeur professeur) {
        this.libelle = libelle;
        this.coefficient = coefficient;
        this.nbrHeure = nbrHeure;
        this.professeur = professeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getNbrHeure() {
        return nbrHeure;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setNbrHeure(int nbrHeure) {
        this.nbrHeure = nbrHeure;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "Module{" +
                "libelle='" + libelle + '\'' +
                ", coefficient=" + coefficient +
                ", nbrHeure=" + nbrHeure +
                ", professeur=" + professeur +
                '}';
    }
}
