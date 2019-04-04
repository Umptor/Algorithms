import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int g = scanner.nextInt();
        for (int i = 0; i < g; i++) {
            int n = scanner.nextInt();
            int c = 0;
            for (int j = 0; j < n; j++) {
                int d = scanner.nextInt();
                c = c^d;
            }
            if (c == 0)
                System.out.println("Second");
            else
                System.out.println("First");
        }

    }
}
