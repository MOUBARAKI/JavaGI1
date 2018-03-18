import java.lang.reflect.Array;
import java.util.*;
import java.util.Comparator;


import static java.lang.Math.*;

public class GrapheComplet {

    public static int n =8;
    private int matrice[][];
    private int ordre[];


    public GrapheComplet() {
        Random r = new Random();
        matrice = new int[n][n];
        ordre = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrice[i][j] = 0;
                } else if (i < j) {
                    matrice[i][j] = r.nextInt(100);
                } else {
                    matrice[i][j] = matrice[j][i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ordre[i] = i;
        }

    }

    public void affiche() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrice[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void descente() {
        System.out.println("Start of Descente");
        double tempDescenteStart=System.currentTimeMillis();

        int oldCost = this.cout(this.ordre);
        int newOrdre[];
        int newCost = 0;
        int k = 0;
        do {

            for (int i = 0; i < 100; i++) {

                newOrdre = this.swap2(this.ordre);

                newCost = cout(newOrdre);

                if (newCost < oldCost) {


                    for (int j = 0; j < n; j++) {
                        this.ordre[j] = newOrdre[j];
                        System.out.print(ordre[j]);
                    }
                    oldCost = this.cout(this.ordre);
                    System.out.println(" " + oldCost);
                    break;
                }


            }


            k++;
        } while (k < 150 || oldCost - newCost > 0);
        double tempDescenteStop=System.currentTimeMillis();
        System.out.println(tempDescenteStop-tempDescenteStart);

        System.out.println("End of Descente");
    }

    public void recuitSimule() {
        System.out.println("Start of Recuit Simule");
        double tempRecuitSimuleStart=System.currentTimeMillis();


        int oldCost = this.cout(this.ordre);
        int newOrdre[];
        int newCost = 0;
        double T = pow(2, 100);
        int k = 0;
        Random rand = new Random();
        double r;

        do {
            r = rand.nextDouble();
            newOrdre = this.swap2(this.ordre);
            newCost = cout(newOrdre);
            if (exp((oldCost - newCost) / T) > r) {
                for (int j = 0; j < n; j++) {
                    this.ordre[j] = newOrdre[j];
                    System.out.print(ordre[j]);
                }
                oldCost = this.cout(this.ordre);
                System.out.println(" " + oldCost);

            }

            T = T / 2;
            k++;
        } while ((k < 150 || oldCost - newCost > 0) && T > 0);
        double tempRecuitSimuleStop=System.currentTimeMillis();
        System.out.println(tempRecuitSimuleStop-tempRecuitSimuleStart);
        System.out.println("End of Recuit Simule");
    }


    public void tabou() {
        double tempTabouStart=System.currentTimeMillis();

        System.out.println("Start of  Tabou");
        Queue<int[]> q = new LinkedList<>();
        int oldCost = this.cout(this.ordre);
        int newOrdre[];
        int newCost = 0;
        int k = 0;
        int testOrdre[];
        Iterator it = q.iterator();
        newOrdre = this.swap2(this.ordre);
        do {
            newOrdre = this.swap2(newOrdre);
            for (int i = 0; i < 100; i++) {

                testOrdre = this.swap2(newOrdre);
                newCost = cout(testOrdre);
                if (newCost < cout(newOrdre) && !identiqueArrayInQueue(q, testOrdre)) {
                    newOrdre = testOrdre;
                    if (q.size() > 14) {
                        q.remove();
                    }
                    q.add(testOrdre);
                }
            }
            k++;
        } while (k < 50);

        System.out.println("List elements:");
        for (int[] array : q
                ) {
            for (int i = 0; i < n; i++) {
                System.out.print(array[i]);
            }
            System.out.println("\t" + cout(array));

        }
        double tempTabouStop=System.currentTimeMillis();
        System.out.println(tempTabouStop-tempTabouStart);
        System.out.println("End of Tabou");
    }

    public void genetique() {
        System.out.println("Start of Genetique");
        double tempGenetiqueStart=System.currentTimeMillis();

        int oldCost = this.cout(this.ordre);
        int population[][];
        ArrayList<int[]> list = new ArrayList<int[]>();
        int newCost = 0;
        population = new int[n / 2][n];
        ArrayList<int[]> newPopulation = new ArrayList<int[]>();
        int k = 0;
        System.out.println("population initiale");
        for (int i = 0; i < n / 2; i++) {
            population[i] = randomOrde();
            for (int j = 0; j < n; j++) {
                System.out.print(population[i][j]);
            }
            System.out.println(" " + cout(population[i]));
            list.add(population[i]);
            Collections.sort(list, COUT);
        }
        do {
            newPopulation.clear();

            newPopulation.add(mutation(list.get(0)));
            newPopulation.add(mutation(list.get(1)));
            newPopulation.add(crossOver(list.get(0), list.get(1)));
            newPopulation.add(crossOver(list.get(1), list.get(0)));
            Collections.sort(newPopulation, COUT);

            if (!identiqueArrayInArrayList(list, newPopulation.get(0))) {
                list.add(newPopulation.get(0));
            }
            if (!identiqueArrayInArrayList(list, newPopulation.get(1))) {
                list.add(newPopulation.get(1));
            }
            Collections.sort(list, COUT);
            while (list.size() > 4) {
                list.remove(list.get(list.size() - 1));
            }

            k++;
        } while (k < 10);
        System.out.println("population finale");
        for (int[] element : list
                ) {
            for(int a=0;a<n;a++){
                System.out.print(element[a]);
            }
            System.out.println(" "+cout(element));
        }
        double tempGenetiqueStop=System.currentTimeMillis();
        System.out.println(tempGenetiqueStop-tempGenetiqueStart);
        System.out.println("End of Genetique");


    }

    public int cout(int tab[]) {
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            c = c + this.matrice[tab[i]][tab[i + 1]];
        }
        return c;
    }

    public int[] swap2(int tab1[]) {
        int tab[] = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = tab1[i];
        }
        Random r1 = new Random();
        int x = r1.nextInt(n);
        int y = r1.nextInt(n);
        if (x != y) {
            tab[x] = tab[x] + tab[y];
            tab[y] = tab[x] - tab[y];
            tab[x] = tab[x] - tab[y];
        }
        return tab;

    }

    public boolean identiqueArrayInQueue(Queue<int[]> q, int[] tab) {
        for (int[] array : q
                ) {
            if (identiqueArrays(array, tab)) return true;


        }
        return false;
    }

    public boolean identiqueArrayInArrayList(ArrayList<int[]> list, int[] tab) {
        for (int[] array : list
                ) {
            if (identiqueArrays(array, tab)) return true;


        }
        return false;
    }

    public boolean identiqueArrays(int[] tab1, int[] tab2) {
        int ident = 0;
        for (int i = 0; i < n; i++) {
            if (tab1[i] != tab2[i]) {
                return false;
            }
        }
        return true;

    }

    public int[] randomOrde() {
        int tab[] = new int[n];
        Random r = new Random();
        Boolean match;
        for (int i = 0; i < n; i++) {
            do {
                match = false;
                tab[i] = r.nextInt(n);
                for (int j = 0; j < i; j++) {
                    if (tab[i] == tab[j]) {
                        match = true;
                        break;
                    }
                }
            } while (match == true);
        }
        return tab;
    }


    public int[] getOrdre() {
        return ordre;
    }


    public int[] mutation(int[] tab1) {

        return swap2(tab1);
    }

    public int[] crossOver(int[] tab1, int[] tab2) {
        Random r = new Random();
        int child[] = new int[n];

        int rand;
        boolean exist1=false;
        boolean exist2=false;
        for (int i = 0; i < n; i++) {
            do {
                if (i%2==0) {
                    if (i==0){child[i] = tab1[i];
                    }
                    else{
                    rand=r.nextInt(n);
                    if(isexist(tab1[i],child,i)){
                        exist1=isexist(rand,child,i);
                        child[i]=rand;

                    }
                    else { child[i]=tab1[i]; }
                    }


                }
                else if(i%2==1){
                    rand=r.nextInt(n);
                    if(isexist(tab2[i],child,i)){
                        exist2=isexist(rand,child,i);
                        child[i]=rand;

                    }
                    else { child[i]=tab2[i]; }
                }

            }while((exist1 && i%2==0) || (exist2 && i%2==1) );
        }
        return child;
    }
    public boolean isexist(int x,int [] tab,int n){
        for(int i=0;i<n;i++){
            if (x==tab[i]) return true;
        }
        return false;
    }

    public Comparator<int[]> COUT = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return cout(o1) - cout(o2);
        }
    };

}

