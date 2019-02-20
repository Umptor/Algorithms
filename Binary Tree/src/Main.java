public class Main {

    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();


        tree.add(3, "bob");
        tree.add(1, "I");
        tree.add(10, "am");
        tree.add(4, "gee");
        tree.add(7, "your");
        tree.add(1, "phone");
        tree.add(5, "yogurt");
        tree.add(2, "Potato");
        tree.add(8, "Maydonoz");
        tree.add(11, "Worm");

        tree.listAll();

        tree.delete(5);




        tree.listAll();

        //System.out.println(swap("Hallo"));
    }

    static public String swap(String str) {
        if(str.length() == 1)
            return str;

        return swap(str.substring(1, str.length())) + str.substring(0,1);

    }
}


