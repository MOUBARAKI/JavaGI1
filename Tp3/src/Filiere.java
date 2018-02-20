import java.util.ArrayList;

public class Filiere implements Collection {
    public ArrayList<Etudiant> etudiants;
    private Integer  numeroSection;
    private Professeur chefSection;

    public Filiere () {
        this.etudiants=new ArrayList();
    }



    public Integer getNumeroSection() {
        return numeroSection;
    }

    public void setNumeroSection(Integer numeroSection) {
        this.numeroSection = numeroSection;
    }

    public Professeur getChefSection() {
        return chefSection;
    }

    public void setChefSection(Professeur chefSection) {
        this.chefSection = chefSection;
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
