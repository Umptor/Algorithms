public class Main {


    public static void main(String args[]) {

        LinkedList arr = new LinkedList();
        arr.add(1, "Bob");
        arr.add(2, "Bill");
        arr.add(3, "Joe");
        arr.add(4, "Jane");
        arr.add(6, "Rick", 5);
        System.out.println(arr.elementAt(5).name);
        /*
        arr.removeById(4);
        arr.add(5, "Gill");
        arr.add(121, "Fageline");
        arr.removeById(121);
        */
        arr.listAll();
    }


}
