public class LinkedList {

    private ListItem front = null;
    private int count = 0;

    public void add(int id, String name) {
        ListItem newItem = new ListItem(id, name);
        if(count == 0)
            front = newItem;
        else
            getLast().next = newItem;
        count++;
    }

    public void add(int id, String name, int index) {
        index--;
        ListItem item = elementAt(index);
        ListItem item2 = elementAt(index + 1);
        if(item2.id != -1 && item2.name != null) {
            item.next = new ListItem(id, name);
            item.next.next = item2;
            count++;
        }
    }

    public void remove(int index) {
        index--;
        elementAt(index).next = elementAt(index + 2);
        count--;
    }

    public void removeById(int id) {
        ListItem item = front;
        ListItem last = front;
        while(item.id != id) {
            last = item;
            item = item.next;
        }
        if(item == front)
            front = item.next;
        else
            last.next = item.next;
        if(id == count) {
            item.next = null;
        }
        count--;
    }

    public ListItem getLast() {
        ListItem item = front;
        while(item.next != null) {
            item = item.next;
        }
        return item;
    }

    public ListItem elementAt(int index) {
        index--;
        ListItem item = front;
        for(int i = 0; i < index; i++) {
            if(item.next == null) {
                System.out.println("Index not valid");
                return new ListItem(-1, null);
            }
            item = item.next;
        }
        return item;
    }

    public void listAll() {
        ListItem item = front;
        while(item != null) {
            System.out.println("ID: " + item.id + " | Name: " + item.name);
            item = item.next;
        }
    }
}
