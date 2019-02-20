import java.util.ArrayList;

public class BinaryTree {

    Node root = null;

    public void add(int id, String info) {
        Node element = root;
        if(element == null) {
            root = new Node(id, info);
            return;
        }

        while(true) {
            if(id > element.id) {
                if(element.right == null) {
                    element.right = new Node(id, info, element);
                    break;
                }
                else
                    element = element.right;

            }
            else {
                if(element.left == null) {
                    element.left = new Node(id, info, element);
                    break;
                }
                else
                    element = element.left;
            }
        }
    }

    public void listAll() {
        if(root == null) {
            System.out.println("No Elements");
            return;
        }
        ArrayList<Node> nodes;
        nodes = listTraverse(root, new ArrayList<>());
        for(Node n: nodes)
            System.out.println(n.id + "  |  " + n.info);
    }

    private ArrayList<Node> listTraverse(Node e, ArrayList<Node> nodes) {
        nodes.add(e);
        if(e.left != null)
            nodes = listTraverse(e.left, nodes);

        if(e.right != null)
            nodes = listTraverse(e.right, nodes);
        return nodes;
    }

    public void delete(int id) {
        Node found = find(id, root);
        if(!found.exists)
            System.out.println("Item not Found");
        Node parent = found.parent;
        int dir = 0;

        if(parent.right.id == found.id)
            dir = 1;
        else
            dir = 0;


        Node left = new Node(false);

        if(found.left != null)
            left = found.left;
        else {
            if(dir == 1)
                parent.right = null;
            if(dir == 0)
                parent.left = null;
            return;
        }



        while(left.right != null) {
            left = found.right;
        }

        if(dir == 1)
            parent.right = left;
        else
            parent.left = left;


        //return getGreatestNode(found, (int)Double.POSITIVE_INFINITY);

        //return found;
    }

    public Node getGreatestNode(Node e, int biggest) {
        Node left = new Node(e.id);
        Node right = new Node(e.id);
        if(e.left != null)
            left = getGreatestNode(e.left, biggest);
        if(e.right != null)
            right = getGreatestNode(e.right, biggest);

        biggest = Math.max(Math.max(left.id, right.id), biggest);
        if(biggest == e.id)
            return e;
        if(biggest == left.id && left.exists)
            return left;
        if(right.exists)
            return right;
        return e;
    }

    public Node find(int id, Node e) {
        if(id == e.id)
            return e;

        if(id < e.id)
            if(e.left != null) {
                Node left = find(id, e.left);

                if(left.exists)
                    return left;
            }

        if(id > e.id)
            if(e.right != null) {
                Node right = find(id, e.right);

                if(right.exists)
                    return right;
            }


        return new Node(false);
    }



    /*

    public void delete(int id) {
        if(!deleteTraverse(id, root))
            System.out.println("Item not Found");
    }

    private boolean deleteTraverse(int id, Node e, boolean deleted, int dir) {
        if(deleted)
            return deleted;
        if(id > e.id) {
            deleted = deleteTraverse(id, e.right, deleted, 1);
        }
        else if(id < e.id) {
            deleted = deleteTraverse(id, e.left, deleted, 0);
        }
        else if(id == e.id) {
            if(dir == 1) {
                if(e.left != null)
                    e.parent.right = e.left;
                else if(e.right != null)
                    e.parent.right = e.right;
                else
                    e.parent.right = null;
                return true;
            }
            else {
                if(e.left != null)
                    e.parent.left = e.left;
                else if(e.right != null)
                    e.parent.left = e.right;
                else
                    e.parent.left = null;
                return true;
            }
        }

        return deleted;
    }
    */





}
