public class ListItem {

    int id;
    String name;
    ListItem next = null;

    public ListItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
