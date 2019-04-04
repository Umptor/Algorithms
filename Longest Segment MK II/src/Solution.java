import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int[] nums;
    static int[] ST;

    static int query(int ind, int start, int end, int a, int b) {
        if((start > b && end > b)  || (start < a && end < a))
            return 0;
        if(start >= a && end <= b)
            return ST[ind];
        int l = query(2 * ind, start, (start + end) / 2, a, b);
        int r = query(2 * ind + 1, (start + end) / 2 + 1, end, a, b);
        return r + l;
    }

    static int fill(int ind, int start, int end) {
        if(start == end) {
            ST[ind] = nums[start];
            return ST[ind];
        }
        int l = fill(2*ind, start, (start + end) / 2);
        int r = fill(2*ind + 1, (start + end) / 2 + 1, end);
        ST[ind] = l + r;
        return ST[ind];

    }

    public static void main(String[] args) {
        int a = scanner.nextInt();
        nums = new int[a + 1];
        ST = new int[2 * a];

        for(int i = 1; i <= a; i++)
            nums[i] = scanner.nextInt();
        Arrays.sort(nums);
        fill(1, 1, a);
        System.out.println(query(1, 1, a, 1, 6));

    }
}
