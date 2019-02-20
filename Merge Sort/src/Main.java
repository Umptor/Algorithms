import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static <E extends Comparable> ArrayList<E> merge(ArrayList<E> arr) {

        ArrayList<E> sorted = new ArrayList<>();
        ArrayList<E> first = new ArrayList<>();
        ArrayList<E> second = new ArrayList<>();
        int length = arr.size();

        for(int i = 0; i < length/2; i++)
            first.add(arr.get(i));
        for(int i = 0; i < arr.size() - arr.size()/2; i++)
            second.add(arr.get(arr.size() - i - 1));
        if(first.size() > 1)
            first = merge(first);
        if(second.size() > 1)
            second = merge(second);

        int pnt1 = 0;
        int pnt2 = 0;
        while(pnt1 + pnt2 != arr.size()) {
            if(first.get(pnt1).compareTo(second.get(pnt2)) < 0) {
                sorted.add(first.get(pnt1));
                pnt1++;
            }
            else {
                sorted.add(second.get(pnt2));
                pnt2++;
            }
            if(pnt1 == first.size()) {
                while(pnt2 != second.size()) {
                    sorted.add(second.get(pnt2));
                    pnt2++;
                }
                break;
            }
            if(pnt2 == second.size()) {
                while(pnt1 != first.size()) {
                    sorted.add(first.get(pnt1));
                    pnt1++;
                }
                break;
            }
        }
        return sorted;
    }

    // 5 6 8 8 9 7 8 4 6

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String num : first)
            arr.add(Integer.parseInt(num));

        arr = merge(arr);

        for (Integer item : arr)
            System.out.println(item);

    }
}
