import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static <E extends Comparable> E[] bubble(E[] arr) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    E temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        Integer arr[] = new Integer[first.length];
        for(int i = 0; i < first.length; i++) {
            arr[i] = Integer.parseInt(first[i]);
        }
        bubble(arr);
        for (Integer item : arr) {
            System.out.println(item);
        }

    }
}
