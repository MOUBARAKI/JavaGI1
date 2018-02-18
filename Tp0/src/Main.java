import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.sqrt;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        //System.out.println(SommeHarmonique());
        //TriangleIsocele();
        //ArrayList<Integer> myList= RandoSerie();
        //System.out.println("this is the list :"+myList);
        //System.out.println(EcarType(myList));
        System.out.println(java.lang.System.currentTimeMillis());
        Date d = new Date();
        System.out.println(d);
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        SimpleDateFormat f = new SimpleDateFormat("dd MMMMM yyyy HH:mm");
        System.out.println("maintenant: " + f.format(d));

    }

    public static double SommeHarmonique (){
        Scanner n = new Scanner(System.in);
        int m;
        m =n.nextInt(1000);
        double sum=0;
        double i=1;


        while (i <= m) {
            sum = sum + 1/i;
            i++;
        }
        return sum;
    }

    public static void TriangleIsocele () {
        Scanner h = new Scanner(System.in);
        int hauteur =h.nextInt();
        int i=1;
        while(i<=hauteur){
            int j=i;

            while(j>0){
                System.out.print("*");
                j--;
            }
            i++;
            System.out.println("");
        }
    }
    public static ArrayList<Integer> RandoSerie()
    { ArrayList<Integer> list=new ArrayList() ;
        Random r = new Random();
        int n = r.nextInt(1000);
        while(n>0) { Random s = new Random();
                   list.add(s.nextInt(1000));
                   n--;


      }
      return list;

    }
    public static double Moyenne(ArrayList<Integer> list )
    { int i;
      double moyenne=0;

        for(i=0;i<list.size();i++){
            moyenne=moyenne+list.get(i);

        }
        moyenne=moyenne/(list.size());
      return (moyenne);
    }
    public static  double EcarType(ArrayList<Integer> list){

      int i;
      double moyCarre=0;
      double ecarType=0;
        for(i=0;i<list.size();i++){
            moyCarre=moyCarre+((list.get(i))*(list.get(i)));
            }
            moyCarre=moyCarre/(list.size());
            System.out.println("on a "+moyCarre);

            ecarType=sqrt(moyCarre-(Moyenne(list))*(Moyenne(list)));

            return ecarType;


    }
}
