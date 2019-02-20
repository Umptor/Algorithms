import java.util.Scanner;

public class Main {

    public static int[] Insertion(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while(j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }

    // 8 9 7 5 4 6 8 2

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String first[] = a.split(" ");
        int arr[] = new int[first.length];
        for(int i = 0; i < first.length; i++) {
            arr[i] = Integer.parseInt(first[i]);
        }
        Insertion(arr);
        for (int item : arr) {
            System.out.println(item);
        }

    }
}
