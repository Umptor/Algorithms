public class Main {
    public static void main(String args[]) {

        VListe<String> vListe = new VListe<>();

        vListe.add("hallo");
        vListe.add("hallo2");
        vListe.add("hallo3");
        vListe.add("hallo4");
        System.out.println(vListe.delete(0));
        vListe.print();
        System.out.println(" _ ");
        vListe.add("I");
        vListe.add("am");
        vListe.add("a");
        vListe.add("potato");
        vListe.add("melon");
        vListe.print();
        System.out.println("");
        vListe.add("baby", 0);
        vListe.print();
        System.out.println("");
        vListe.delete(6);
        vListe.print();
        System.out.println("");
        while(vListe.getFront().isExists())
            vListe.delete(0);
        vListe.print();
        vListe.add("hallo");
        vListe.add("bye");
        vListe.delete("hallo");
        vListe.add("IT'S RAAAWWWW");
        vListe.print();
        System.out.println("");
    }
}


