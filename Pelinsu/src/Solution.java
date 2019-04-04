import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int dif = 0;
        int[] nums = new int[b + 1];
        int[] min = new int[b + 1];
        int[] lastMin = new int[b + 1];
        int[] max = new int[b + 1];
        int[] lastMax = new int[b + 1];
        int max = 0;
        int min = -1;



        for (int i = 1; i <= a; i++) {
            int c = scanner.nextInt();
            if(i <= b) {
                if(c > nums[max]) {
                    lastMax[c] = max;
                    max = i;
                }
                else if(c < nums[min] || min == -1) {
                    lastMin[c] = min;
                    min = i;
                }

                nums[c] = c;
                continue;
            }
            int top =

        }

    }
}