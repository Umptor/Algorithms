import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int total = 0;
        int[] nums = new int[2000000];
        int count = 0;

        Arrays.fill(nums, 0);
        scanner.nextLine();

        for(int i = 0; i < a; i++) {
            int d = Integer.parseInt(scanner.next());
            count++;
            if(d == 0)
                continue;
            if(d > b)
                continue;
            if (b % d == 0) {
                int x = b / d;
                total += nums[x];
                nums[d]++;
            }
            else
                nums[d]++;
        }
        if(b== 0)
            System.out.println(count);
        else
        System.out.println(total);
    }
}