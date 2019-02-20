public class Node {

    int id;
    String info;


    Node parent = null;
    Node left = null;
    Node right = null;
    boolean exists = true;


    public Node(int id, String info) {
        this.id = id;
        this.info = info;
    }
    public Node(int id) {
        this.id = id;
        exists = false;
    }

    public Node(int id, String info, Node parent) {
        this.id = id;
        this.info = info;
        this.parent = parent;
    }
    public Node(boolean exists) {
        this.exists = exists;
    }






}
