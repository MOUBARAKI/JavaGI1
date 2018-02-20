public class Doctorant extends Etudiant implements Salarie {
    private String sujetThese;
    Professeur encadrant = new Professeur();

    public Doctorant() {
    }

    public String getSujetThese() {
        return sujetThese;
    }

    public void setEncadrant(Professeur encadrant) {
        this.encadrant = encadrant;
    }

    public void setSujetThese(String sujetThese) {

        this.sujetThese = sujetThese;
    }

    public Professeur getEncadrant() {
        return encadrant;
    }

    public Float calculSalaire(Integer nbrHeures) {
        if (nbrHeures < 32) return Float.valueOf(400 * nbrHeures * (1 - (34 / 100)));
        else return Float.valueOf((((nbrHeures - 32) * 600) * (1 - (34 / 100)) + (32 * 400) * (1 - (17 / 100))));
    }
    public Float calculSalaire() {
        Integer nbrHeures=0;
        for(int i=0;i<4;i++){
            nbrHeures+=this.encadrant.getModule()[i].getNbrHeure();
        }
        if (nbrHeures < 32) return Float.valueOf(400 * nbrHeures * (1 - (34 / 100)));
        else return Float.valueOf((((nbrHeures - 32) * 600) * (1 - (34 / 100)) + (32 * 400) * (1 - (17 / 100))));
    }

    public Float calculVacances(Integer nbrJours) {
        return Float.valueOf(nbrJours / 10);
    }
}
