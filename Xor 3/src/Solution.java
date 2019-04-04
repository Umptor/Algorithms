import java.util.Scanner;

public class Solution {

    static Scanner scanner =  new Scanner(System.in);

    static int[] xor;
    static int getXor(int a, int b) {
        a = xor[a-1];
        b = xor[b];
        int c = b^a;
        return c;
}

    public static void main(String[] args) {
        int a = scanner.nextInt();
        xor = new int[a + 1];
        for(int i = 1; i <= a; i++) {
            int n = scanner.nextInt();
            xor[i] = n^xor[i-1];
        }
        int b = scanner.nextInt();
        int c = 0;
        for (int i = 0; i < b; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            c = getXor(x,y);
            System.out.println(c);
        }
    }
}
