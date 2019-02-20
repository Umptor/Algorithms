public class Node<E> {

    private Node<E> next = null;
    private E element;
    private Node<E> parent = null;
    private boolean exists = true;
    private int id = 0;
    private static int num = 0;

    // Represents the front of the List
    public Node(E element) {
        this.element = element;
        id = num;
        num++;
        next = new Node<>();
        parent = new Node<>();
    }

    // Any old element in the list
    public Node(E e, Node<E> parent) {
        this.element = e;
        this.parent = parent;
        id = num;
        num++;
        next = new Node<>();
    }

    // Empty element used only when an element must be created but does not actually represent anything, e.g. when a return value is needed
    public Node() {
        exists = false;
        next = new Node<E>(false);
        parent = next;
    }

    private Node(boolean exists) {
        this.exists = false;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getParent() {
        return parent;
    }

    public boolean isExists() {
        if(element == null)
            return false;
        return exists;
    }

    public int getId() {
        return id;
    }
}