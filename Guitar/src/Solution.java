import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int moveDown(int a, int b) {
        int m = 0;
        while(max[a] > b) {
            if(max[a] == 0 && b == 0)
                return m;
            else if(max[a] == 0)
                return m++;
            int c = max[a];
            max[a] = s[a][max[a]];
            s[a][c] = 0;
            m++;
        }
        if(max[a] == 0 && b == 0)
            return m;
        else
            return ++m;
    }

    static Scanner scanner = new Scanner(System.in);

    static int[][] s = new int[10][3000000];
    static int[] max = new int[3000000];


    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = 0;

        for(int i = 0; i < a; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(y == max[x])
                continue;
            else if(y > max[x]) {
                s[x][y] = max[x];
                max[x] = y;
                m++;
            }
            else {
                m+= moveDown(x, y);
            }
        }
        System.out.print(m);
    }
}