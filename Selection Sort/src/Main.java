import java.util.Scanner;

public class Main {

    public static <E extends Comparable> E[] selectionSort(E[] arr) {

        for(int i = 0; i < arr.length; i++) {
            E min = arr[i];
            int index = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[index]) <= 0) {
                    index = j;
                }
            }
            arr[i] = arr[index];
            arr[index] = min;
        }
        return arr;
    }

    // 5 6 8 8 9 7 8 4 6

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        Integer arr[] = new Integer[first.length];
        for(int i = 0; i < first.length; i++) {
            arr[i] = Integer.parseInt(first[i]);
        }
        selectionSort(arr);
        for (Integer item : arr) {
            System.out.println(item);
        }
    }
}
