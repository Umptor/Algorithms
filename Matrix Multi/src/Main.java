import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> dimensions = new ArrayList<>();

    static int m(int i, int j) {
        if(j - i <= 1)
            return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for(int x = i + 1; x < j; x++) {
            nums.add(m(i, x) + m(x, j) + dimensions.get(i) + dimensions.get(x) + dimensions.get(j));
        }
        return Collections.min(nums);
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int n = 0;
        while(n < 5) {
            dimensions.add(scanner.nextInt());
            n++;
        }
        System.out.println(m(0,n));
    }

}
