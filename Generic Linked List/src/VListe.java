// Alp Akyuz 160503134 INF203

import java.util.ArrayList;

public class VListe<E> {

    private Node<E> front = new Node<>();
    private Node<E> last = new Node<>();
    private int total = 0;

    public VListe() {
        front = new Node<>();
    }


    public void add(E e) {
        /*
        The first if is to check whether the list is empty
        If empty it creates a front item for the list, which is the front and currently also the end of the list
        If not empty then it gets the last item in the list and sets it's next item to be the new item with element E
        */

        if(!front.isExists()) {
            front = new Node<>(e, front);
            front.getParent().setNext(front);
            last = front;
            total = 1;
            return;
        }
        Node<E> item = front.getParent();
        while(item.getNext().isExists())
            item = item.getNext();

        item.setNext(new Node<>(e, item));
        last = item.getNext();

        total++;
        return;
    }

    public int add(E e, int index) {
        /*
        If the index == total then it means it needs to be added to the end, so it sends the item to the other function
        if index > total then the index is invalid because there aren't enough nodes
        If index == 0 then a new front is needed, so front is changed
        Else the algorithm is as follows:
            It finds the item at index (item) and the child of that (item2)
            Then it sets the next item after that to be the new item
            Then it sets the new item's child to be item2
            Hence adding the new item between item and item 2
            Then it fixes item2's parent
        */
        if(index == total) {
            add(e);
            return 1;
        }
        if(index > total) {
            return -1;
        }
        if(index == 0) {
            Node<E> item = new Node<>(e, front.getParent());
            item.setNext(front);
            item.getParent().setNext(item);
            front.setParent(item);
            front = item;
            total++;
            return 1;
        }
        Node<E> item = elementAt(index);
        Node<E> item2 = elementAt(index + 1);
        item.setNext(new Node<>(e, item));
        item.getNext().setNext(item2);
        item2.setParent(item.getNext());
        total++;
        return 1;
    }

    public Node<E> elementAt(int index) {
        /*
        If index > total - 1 then the index is after the last element and if it is < 0 then it will never exist
        It creates an item that starts at the front and goes to it's next item index times, AKA goes to the index. item
        */
        if(index > total - 1 || index < 0)
            return new Node<>();

        Node<E> item = front.getParent();
        for(int i = 0; i < index; i++)
            item = item.getNext();

        return item;
    }

    public void print() {
        /*
        It calls listTraverse which returns an ArrayList with all the nodes in it
        Then it prints them out starting with index = 0
        */
        ArrayList<Node<E>> arr = new ArrayList<>();
        arr = listTraverse(front, arr);

        for(Node<E> e: arr)
            System.out.println(e.getElement());
    }

    public ArrayList<Node<E>> listTraverse(Node item, ArrayList<Node<E>> arr) {
        /*
        While there is another element after the current one it adds the current item to the list then checks the next item
        At the end because the end item doesn't have a next element it is added after the while loop
        */
        while(item.getNext().isExists()) {
            arr.add(item);
            item = item.getNext();
        }
        if(item.isExists())
            arr.add(item);
        return arr;
    }

    public int delete(int index) {
        /*
        The general logic is this. The list in order is as follows:
        parent item child
        if I want to delete item then the next item of parent becomes child and the parent of child becomes parent

        The first if is to check for valid indices
        The next is to check to see if the last item is being deleted
            If so, then
            If the last item is also the last item then
                the last and first item are set to an empty item and the imaginary item before the real front need a child update
            If they aren't the same then parent's child becomes the empty item after last.  This is done separately from the next section to make it an O(1) operation

        After these checks the item and the child are found
        And the parent's next is set to the child and the child's parent is set to the item's parent.  AKA cutting item from the List

        If the deleted item was at the end, then last must change
        If the deleted item was at the front then front mus change
        */

        if(index > total - 1 || index < 0)
            return -1;
        else if(index == total - 1) {
            if(last.getId() == front.getId()) {
                last = new Node<>();
                front.getParent().setNext(last);
                front = last;
                return 1;
            }
            last.getParent().setNext(last.getNext());
            return 1;
        }

        Node<E> item = elementAt(index + 1);
        Node<E> child = item.getNext();

        item.getParent().setNext(child);
        child.setParent(item.getParent());

        if(index == total) {
            last = item.getParent();
        }
        if(index == 0) {
            front = item.getNext();
        }

        return 1;
    }

    public int delete(E e) {
        /*
        this delete finds the index of the item and sends it to the delete above
        */
        Node<E> item = front.getParent();
        int index = -1;
        while(item.getNext().isExists() && item.getElement() != e) {
            item = item.getNext();
            index++;
        }
        return delete(index);
    }

    public Node<E> getFront() {
        return front;
    }
}
