import java.util.ArrayList;

public  class Bateau {
    private int taille;
    private ArrayList<Case> cases;
    public Boolean horizontal;

    public Bateau(int taille) {
        this.taille=taille;
        this.cases=new ArrayList<>();


    }



    public Boolean estCoule() {
        Boolean ecoule = false;
        for (Case box : cases) {
            if (!box.isState())
                ecoule = box.isState();
        }
        return ecoule;
    }

    public void ajouteCase(Case c) {
        c.setBateau(this);
        cases.add(c);
    }
    public void removeCase(Case c){
        c.setBateau(null);
        cases.remove(c);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }

    public Boolean getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Boolean horizontal) {
        this.horizontal = horizontal;
    }
}
