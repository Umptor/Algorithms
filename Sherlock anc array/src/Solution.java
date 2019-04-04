import java.util.Scanner;

public class Solution {
    static Scanner scanner =  new Scanner(System.in);


    static int[] sum;

    static int getSum(int a, int b) {
        int c = sum[b] - sum[a];
        return c;
    }

    static boolean findequal() {
        int n = sum.length - 1;
        for(int i = 0; i < n - 1; i++) {
            if(getSum(n - i, n) == getSum(0, n - i - 1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for(int b = 0; b < t; b++) {
            int n = scanner.nextInt();
            sum = new int[n + 1];
            sum[0] = 0;
            for(int i = 1; i <= n; i++) {
                int a = scanner.nextInt();
                sum[i] += sum[i-1] + a;
            }
            if(n == 1) {
                System.out.println("YES");
                continue;
            }
            if(findequal())
                System.out.println("YES");
            else
                System.out.println("NO");
            scanner.nextLine();
        }
    }
}
