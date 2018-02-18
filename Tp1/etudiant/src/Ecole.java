public class Ecole {
    public static void main(String[] args) {
        Etudiant moi = new Etudiant("Amine MOUBARAKI", 29, "aminemoubaraki.3@gmail.com");
        Professeur hafidi = new Professeur("Imade HAFIDI", 1, "hafidi@gmail.com", "chef departement");
        Module java = new Module("java", 5, 6, hafidi);
        System.out.println(moi.toString());
        System.out.println(hafidi.toString());
        System.out.println(java.toString());

    }
}
