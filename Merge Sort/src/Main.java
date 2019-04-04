import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> nums = new ArrayList<Integer>();

    static class Set{
        ArrayList<Integer> subSet1;
        ArrayList<Integer> subSet2;


        public Set(ArrayList<Integer> set) {

        }
    }

    static Set set1;

    public static void main(String args[]) {



        int num = scanner.nextInt();
        for(int i = 0; i < num; i++) {
            nums.add(scanner.nextInt());
        }
        set1 = new Set(nums);

    }
}
