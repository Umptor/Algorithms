import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Integer> arr = new ArrayList<>();

    static Scanner s = new Scanner(System.in);

    public static int[] recBub(int[] arr, int j,  int arrSize) {
        if(j == arrSize)
            return arr;

        arr = inner(arr, 0);

        return recBub(arr, j + 1, arrSize);
    }

    public static int[] inner(int[] arr, int i) {
        if(i == arr.length - 1)
            return arr;

        if(arr[i] > arr[i + 1]) {
            int a = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = a;
        }

        return inner(arr, i + 1);
    }



    public static void main(String[] args) {

        /*
        int a = 10101101;
        int b = 10101111;
             //101011100
        String[] bob= (" " + Integer.toString(a + b)).split("");
        int[] bobInt = new int[bob.length];
        for(int i = 1; i < bobInt.length; i++)
            bobInt[i] = Integer.parseInt(bob[i]);

        for(int i = bob.length - 1; i > 0; i--) {
            int n = bobInt[i] - 2;
            if(n > -1) {
                bobInt[i] = n;
                bobInt[i - 1] += 1;
            }
        }
        for(int i: bobInt)
            System.out.print(i);
        */


        String a = s.nextLine();

        String[] sArr = a.split(" ");

        int[] iArr = new int[sArr.length];

        for(int i = 0; i < sArr.length; i++)
            iArr[i] = Integer.parseInt(sArr[i]);

        int arrSize = iArr.length;

        int[] bob = recBub(iArr,0, arrSize);
        for(int i: bob)
            System.out.println(i + " ");

    }


}
