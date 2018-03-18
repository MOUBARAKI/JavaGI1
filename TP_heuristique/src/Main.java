public class Main {
    public static void  main(String[] args){
        GrapheComplet graphDescente=new GrapheComplet() ;
        GrapheComplet graphRecuitSimule=new GrapheComplet() ;
        GrapheComplet graphTabou=new GrapheComplet() ;
        GrapheComplet graphGenetique=new GrapheComplet() ;



        graphDescente.affiche();
        graphDescente.descente();
        graphRecuitSimule.recuitSimule();
        graphTabou.tabou();
        graphGenetique.genetique();

    }

}
