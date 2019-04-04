import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> n1 = new ArrayList<>();
    static ArrayList<Integer> n2 = new ArrayList<>();
    static int[][] d;
    static int[] g;

    static void fill() {
        for(int i = 1; i <= g[0]; i++)
            for(int j = 1; j <= g[0]; j++) {
                if(i == j)
                    d[i][j] = 0;
                else
                    d[i][j] = 100000000;
            }
    }
    
    static void floyd() {
        for(int i = 1; i <= g[0]; i++)
            for(int j = 1; j <= g[0]; j++)
                for(int k = 1; k <= g[0]; k++) {
                    d[j][k] = Math.min(d[j][i] + d[i][k], d[j][k]);
                }
    }


    public static void main(String[] args) {

        String[] ar = scanner.nextLine().split(" ");
        g = new int[2];
        g[0] = Integer.parseInt(ar[0]);
        g[1] = Integer.parseInt(ar[1]);
        d = new int[g[0] + 1][g[0] + 1];
        fill();
        for(int i = 1; i <= g[1]; i++) {
            String[] arr = scanner.nextLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            d[a][b] = c;
        }
        floyd();
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(d[a][b] == 100000000)
                System.out.println(-1);
            else
                System.out.println(d[a][b]);
        }
    }
}
