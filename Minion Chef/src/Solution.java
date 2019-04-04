import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int[] piles;
    static int[] gg;
    static int closest2 = 1;
    static int maxStack;
    static int c = 0;


    static int findTime(int speed) {
        int sum = 0;
        for(int i: piles) {
            sum += i / speed;
            if(i % speed != 0)
                sum += 1;
        }
        return sum;
    }

    static int search(int maxTime) {
        int[] a = new int[c];
        int b = 0;
        Arrays.fill(a, 1);
        for(int i = 0; i < c; i++) {
            int oldb = b;
            b += (int)Math.pow(2, c - 1 - i);
            if(findTime(b) <= maxTime) {
                b = oldb;
                a[i] = 0;
            }
            else {
                a[i] = 1;
            }
        }
        int r = 0;
        for(int i = c - 1; i >= 0; i--) {
            r += a[i] * Math.pow(2, c - 1 - i);
        }
        return r;
    }

    static void findClosest2() {
        int a = maxStack;
        while(closest2 < a) {
            closest2 *= 2;
            c++;
        }
        gg = new int[c];
    }

    public static void main(String[] args) {

        String[] arr = scanner.nextLine().split(" ");
        int[] g = new int[2];
        g[0] = Integer.parseInt(arr[0]);
        g[1] = Integer.parseInt(arr[1]);
        piles = new int[g[0]];
        int maxTime = g[1];

        for(int i = 0; i < g[0]; i++) {
            int a = scanner.nextInt();
            piles[i] = a;
            if(a > maxStack)
                maxStack = a;
        }
        findClosest2();
        System.out.println(search(maxTime));
    }
}
