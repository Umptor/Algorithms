import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int[][] grundi;
    static int[][] done;

    /*
      i i i
    j
    j
    j

    i+1,j+2 i-1,j+2 i-2,j+1 i-2,j-1

    */

    static int find(int i, int j) {
        if(i < 1 || j < 1 || i > 15 || j > 15)
            return -1;
        if(done[i][j] != 0)
            return grundi[i][j];
        ArrayList<Integer> a = new ArrayList<>();
        a.add(find(i+1,j-2));
        a.add(find(i-1,j-2));
        a.add(find(i-2,j-1));
        a.add(find(i-2,j+1));
        int g = 0;
        while(true) {
            if(!a.contains(g)) {
                grundi[i][j] = g;
                done[i][j] = 1;
                return g;
            }
            g++;
        }

    }

    public static void main(String[] args) {
        grundi = new int[16][16];
        done = new int[16][16];;
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int r = 0;
            for (int j = 1; j <= n; j++) {
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                r = r ^ find(b, c);
            }
            if(r == 0)
                System.out.println("Second");
            else
                System.out.println("First");
        }
    }

}
