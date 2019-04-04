import java.io.*;
import java.util.*;



public class Main {

    public static int factorial(int a) {
        int result = 1;
        if(a == 1)
            return result;
        result *= factorial(a-1);

        return result;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(0);
        arr2.add(0);
        arr2.add(2);
        arr2.add(1);
        System.out.println(1*5*3*(factorial(2) * factorial(1)));
    }
}
